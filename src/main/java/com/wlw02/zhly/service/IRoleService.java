/**
 * 
 */
package com.wlw02.zhly.service;

import java.util.List;

import com.wlw02.zhly.po.Role;


/**
 * @author sangh
 *
 */
public interface IRoleService {

	/**
	 * 
	 * @return
	 */
	List<Role> queryAll();
	Role selectUserByName(String rolename);
	void insert(Role role);
	void updateUser(Role role);
}
  