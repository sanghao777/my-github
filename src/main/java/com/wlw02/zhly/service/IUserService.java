/**
 * 
 */
package com.wlw02.zhly.service;

import java.util.List;

import com.wlw02.zhly.po.Spot;
import com.wlw02.zhly.po.User;

/**
 * @author sangh
 *
 */
public interface IUserService {

	/**
	 * 
	 * @return
	 */
	List<User> queryAll();
	User selectUserByName(String username);
	void insert(User user);
	void updateUser(User user);
}
  