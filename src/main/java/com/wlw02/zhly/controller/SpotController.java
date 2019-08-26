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
@RequestMapping("/spot")
public class SpotController {
	@Autowired
	private IUserService   userService;
	
	
	@RequestMapping("/users")
	public String   getUser(Model  model){
		model.addAttribute("users",userService.queryAll());
		return  "users";
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
