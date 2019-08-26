/**
 * 
 */
package com.wlw02.zhly.po;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

/**
 * @author sangh
 *
 */
public class User  implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -7605073187374025273L;
	private  Long id;
	private  String username;
	private String password;
	private  String phone;
	private String userClass;
	private  Date  created;
	private  Date  updated;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUserClass() {
		return userClass;
	}
	public void setUserClass(String userClass) {
		this.userClass = userClass;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.format(created);
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	
	
}
