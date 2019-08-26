/**
 * 
 */
package com.wlw02.zhly.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wlw02.zhly.util.VerifyCodeUtils;

/**
 * @author chendf
 * @datetime 2018年10月12日 下午1:10:50
 * 
 */
@Controller
public class CodeController {
   
    @RequestMapping(value="/getImage",method=RequestMethod.GET)
    public void authImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
		// 生成随机字串
		String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
		// 存入会话session
		HttpSession session = request.getSession();
		// 删除以前的
		session.removeAttribute("verCode");
		session.removeAttribute("codeTime");
		session.setAttribute("verCode", verifyCode.toLowerCase());
		session.setAttribute("codeTime", LocalDateTime.now());
		// 生成图片
		int w = 100, h = 30;
		OutputStream out = response.getOutputStream();
		VerifyCodeUtils.outputImage(w, h, out, verifyCode);
    }
    

}
