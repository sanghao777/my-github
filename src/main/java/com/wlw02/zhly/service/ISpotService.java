/**
 * 
 */
package com.wlw02.zhly.service;

import java.util.List;

import com.wlw02.zhly.po.Spot;


/**
 * @author sangh
 *
 */
public interface ISpotService {

	/**
	 * 
	 * @return
	 */
	List<Spot> queryAll();
	Spot selectUserByName(String spotname);
	void insert(Spot spot);
	void updateUser(Spot spot);
}
  