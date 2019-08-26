/**
 * 
 */
package com.wlw02.zhly.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wlw02.zhly.po.Ticket;
import com.wlw02.zhly.po.User;
import com.wlw02.zhly.service.ITicketService;

/**
 * @author sangh
 *
 */
@Controller
@RequestMapping("/ticket")
public class TicketController {
	@Autowired
	private ITicketService   ticketService;
	
	
	@RequestMapping("/tickets")
	public String   getTickets(Model  model){
		model.addAttribute("tickets",ticketService.queryAll());
		return  "tickets";
	}
	
	
	@RequestMapping("/toadd")
	public String  toadd() {
		
		return "admin/addTicket";
	}
	@RequestMapping("/add")
	public String  add(Ticket ticket) {
		ticketService.insert(ticket);
		
		return "admin/addTicket";
	}
	
	@RequestMapping("/todelete")
	public String  todelete(Model model) {
		List<Ticket> tickets=ticketService.queryAll();
		model.addAttribute("tickets", tickets);
		return "admin/deleteticket";
	}
	@RequestMapping("/toupdate")
	public String  toUpdate() {
		
		return "updateTicket";
	}
	@RequestMapping("/delete")
	public String delete(@Param("tId")int tId) {
		System.out.println(tId);
		ticketService.deleteByPrimaryKey(String.valueOf(tId));
		return "redirect:/ticket/todelete";
	}
	@RequestMapping("/update")
	public String updateUser(HttpServletRequest req,User user) {
		
		return "redirect:/user/toupdate";
	}
	@RequestMapping("/bglogin")
	public String bgLogin() {
		return "admin/login";
	}
	
	@RequestMapping("/initItemList")
	public String initItemList(Model model) {
		List<Ticket> tickets=ticketService.queryAll();
		model.addAttribute("tickets", tickets);
		return "admin/ticketmanage";
	}
	@RequestMapping("/torole")
	public String setUserRole(Model model) {
		List<Ticket> tickets=ticketService.queryAll();
		model.addAttribute("users", tickets);
		 return "admin/userrole";
	}
}
