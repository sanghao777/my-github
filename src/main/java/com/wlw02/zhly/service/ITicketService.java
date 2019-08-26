/**
 * 
 */
package com.wlw02.zhly.service;

import java.util.List;

import com.wlw02.zhly.po.Ticket;


/**
 * @author sangh
 *
 */
public interface ITicketService {

	/**
	 * 
	 * @return
	 */
	List<Ticket> queryAll();
	Ticket selectUserByName(String  ticketname);
	void insert(Ticket ticket);
	void updateUser(Ticket ticket);
	int deleteByPrimaryKey(String tId);
}
  