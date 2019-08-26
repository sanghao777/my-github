/**
 * 
 */
package com.wlw02.zhly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wlw02.zhly.dao.RoleMapper;
import com.wlw02.zhly.po.Role;
import com.wlw02.zhly.service.IRoleService;

/**
 * @author sangh
 *
 */
@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private RoleMapper  dao ;
	
	/* (non-Javadoc)
	 * @see com.sztl.shop.service.IUserService#queryAll()
	 */
	@Override
	public List<Role> queryAll() {
		// TODO Auto-generated method stub
		return dao.queryAll();
	}
	@Override
	public Role selectUserByName(String username) {
		Role user=dao.selectUserByName(username);
		return user;
	}
	@Override
	public void insert(Role user) {
		dao.insert(user);
		
	}
	@Override
	public void updateUser(Role user) {
	 dao.updateByPrimaryKeySelective(user);
	}
    
}
