/**
 * 
 */
package com.wlw02.zhly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wlw02.zhly.dao.IDao;
import com.wlw02.zhly.po.User;
import com.wlw02.zhly.service.IUserService;

/**
 * @author sangh
 *
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IDao  dao ;
	
	/* (non-Javadoc)
	 * @see com.sztl.shop.service.IUserService#queryAll()
	 */
	@Override
	public List<User> queryAll() {
		// TODO Auto-generated method stub
		return dao.queryAll();
	}
	@Override
	public User selectUserByName(String username) {
		User user=dao.selectUserByName(username);
		return user;
	}
	@Override
	public void insert(User user) {
		dao.insert(user);
		
	}
	@Override
	public void updateUser(User user) {
	 dao.updateUser(user);
	}
    
}
