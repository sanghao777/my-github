/**
 * 
 */
package com.wlw02.zhly.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wlw02.zhly.po.User;


/**
 * 
 * @author sangh
 *
 */
@Repository
public interface IDao {
	List<User>   queryAll();
	
	User selectUserByName(@Param("username")String username);
	void updateUser(User user);
	void insert(User user);
	
	
}
