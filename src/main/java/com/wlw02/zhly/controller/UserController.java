/**
 * 
 */
package com.wlw02.zhly.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wlw02.zhly.po.User;
import com.wlw02.zhly.service.IUserService;

/**
 * @author sangh
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService   userService;
	
	
	@RequestMapping("/users")
	public String   getUser(Model  model){
		model.addAttribute("users",userService.queryAll());
		return  "users";
	}
	@RequestMapping("/validate")
	public String validateUser(@RequestParam String username,
			@RequestParam String password,Model model,HttpServletRequest req) {
		User user=userService.selectUserByName(username);
		String msg="";
		 try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			msg=new BigInteger(1, md.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  if(user==null) {
			  return "redirect:/user/login";
		  }else if(user.getUsername().equals(username)&&user.getPassword().equals(msg)) {
			  req.getSession().setAttribute("user", user);
			 return "index1";
		 }else {
			 return "redirect:/user/login";
		 }
	}
	@RequestMapping("/login")
	public String   toLogin(){
		return  "login";
	}
	@RequestMapping("/reg")
	public String toReg() {
		return "reg";
	}
	@RequestMapping("/check.do")
	@ResponseBody
	public String check(HttpServletRequest req,@RequestParam String username) {
		String msg="";
		User user=userService.selectUserByName(username);
		if(user==null) {
			msg="该用户名可用";
		}else if(user.getUsername().equalsIgnoreCase(username)){
			msg="该用户名不可用";
		}
		return msg;
	}
	@RequestMapping("/checkreg")
	public  String checkReg(HttpSession session,HttpServletRequest request,User user,
			@RequestParam String code) {
    	Object verCode = session.getAttribute("verCode");
    	System.out.println(verCode);
    	if (null == verCode) {
    		request.setAttribute("errmsg", "验证码已失效，请重新输入");
    		return "验证码已失效，请重新输入";
    	}
    	String verCodeStr = verCode.toString();
    	LocalDateTime localDateTime = (LocalDateTime)session.getAttribute("codeTime");
    	long past = localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    	long now = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    	if(verCodeStr == null || code == null || code.isEmpty() || !verCodeStr.equalsIgnoreCase(code)){
    		request.setAttribute("errmsg", "验证码错误");
    		return "redirect:/user/reg";
    	} else if((now-past)/1000/60>5){
    		request.setAttribute("errmsg", "验证码已过期，重新获取");
    		return "验证码已过期，重新获取";
    	} else {
    		//验证成功，删除存储的验证码
    		session.removeAttribute("verCode");
    		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
    		user.setUserClass("1");
    		user.setCreated(new Date());
    		user.setUpdated(new Date());
    		userService.insert(user);
    		return "login";
    	}
		//userService.insertUser(user);
	}
	@RequestMapping("/toupdate")
	public String  toUpdateUser() {
		return "updateUser";
	}
	@RequestMapping("/update")
	public String updateUser(HttpServletRequest req,User user) {
		User loginUser=(User)req.getSession().getAttribute("user");
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		user.setId(loginUser.getId());
		userService.updateUser(user);
		return "redirect:/user/toupdate";
	}
	@RequestMapping("/bglogin")
	public String bgLogin() {
		return "admin/login";
	}
	@RequestMapping("/bgvalidate")
	public String bgValidate(User user) {
		if(user.getUsername().equals("admin")&&user.getPassword().equals("admin")) {
			return "admin/index";
		}else {
			return "admin/login";
		}
	}
	@RequestMapping("/show")
	public String showUser(Model model) {
		List<User> users=userService.queryAll();
		model.addAttribute("users", users);
		return "admin/usermanage";
	}
	@RequestMapping("/torole")
	public String setUserRole(Model model) {
		List<User> users=userService.queryAll();
		model.addAttribute("users", users);
		 return "admin/userrole";
	}
}
