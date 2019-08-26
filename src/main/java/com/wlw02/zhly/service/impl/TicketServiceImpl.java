/**
 * 
 */
package com.wlw02.zhly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wlw02.zhly.dao.TicketMapper;
import com.wlw02.zhly.po.Ticket;
import com.wlw02.zhly.po.User;
import com.wlw02.zhly.service.ITicketService;

/**
 * @author sangh
 *
 */
@Service
public class TicketServiceImpl implements ITicketService {

	@Autowired
	private TicketMapper  dao ;
	
	/* (non-Javadoc)
	 * @see com.sztl.shop.service.IUserService#queryAll()
	 */
	@Override
	public List<Ticket> queryAll() {
		// TODO Auto-generated method stub
		return dao.queryAll();
	}
	@Override
	public Ticket selectUserByName(String username) {
		Ticket user=dao.selectUserByName(username);
		return user;
	}
	@Override
	public void insert(Ticket user) {
		dao.insert(user);
		
	}
	@Override
	public void updateUser(Ticket user) {
	 dao.updateUser(user);
	}
	@Override
	public int deleteByPrimaryKey(String tId) {
		dao.deleteByPrimaryKey(tId);
		return 0;
	}
    
}
