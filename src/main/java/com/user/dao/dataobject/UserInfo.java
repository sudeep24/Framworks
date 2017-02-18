package com.user.dao.dataobject;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERINFO")
public class UserInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	@Id
	@Column(name = "USERID")
	String userId;
	@Column(name = "USERNAME")
	String name;
	@Column(name = "PASSWORD")
	String password;

	public UserInfo() {

	}

	public UserInfo(String userId, String name, String password) {
		this.userId = userId;
		this.name = name;
		this.password = password;
	}

	/**
	 * @return the userId
	 */

	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the name
	 */

	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the password
	 */
	/*
	 * @Column(name = "PASSWORD", unique = true, nullable = false, precision =
	 * 5, scale = 0)
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
