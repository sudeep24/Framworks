package com.user.dao;

import com.user.dao.dataobject.UserInfo;
import com.user.service.bean.UserInifoBean;
/**
 * 
 * @author sudeep
 *
 */
public interface UserInfoServiceDao 
{
	/**
	 * 
	 * @param email
	 * @return UserInifoBean
	 */
	UserInifoBean queryInfoById(String email);
	
	/**
	 * 
	 */
	boolean saveUserInfo(UserInfo userInfo);
	
}
