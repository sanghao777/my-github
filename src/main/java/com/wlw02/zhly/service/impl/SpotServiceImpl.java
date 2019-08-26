/**
 * 
 */
package com.wlw02.zhly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wlw02.zhly.dao.SpotMapper;
import com.wlw02.zhly.po.Spot;
import com.wlw02.zhly.po.User;
import com.wlw02.zhly.service.ISpotService;

/**
 * @author sangh
 *
 */
@Service
public class SpotServiceImpl implements ISpotService {

	@Autowired
	private SpotMapper  dao;
	
	/* (non-Javadoc)
	 * @see com.sztl.shop.service.IUserService#queryAll()
	 */
	@Override
	public List<Spot> queryAll() {
		// TODO Auto-generated method stub
		return dao.queryAll();
	}
	@Override
	public Spot selectUserByName(String username) {
		Spot user=dao.selectUserByName(username);
		return user;
	}
	@Override
	public void insert(Spot spot) {
		dao.insert(spot);
		
	}
	@Override
	public void updateUser(Spot spot) {
	 dao.updateByPrimaryKeySelective(spot);
	}
	
	
    
}
