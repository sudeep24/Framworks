package com.user.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.user.dao.UserInfoServiceDao;
import com.user.dao.dataobject.UserInfo;
import com.user.dao.util.DataObjectUtil;
import com.user.service.bean.UserInifoBean;

public class UserIfoServiceDaoImpl implements UserInfoServiceDao {

	@Override
	public UserInifoBean queryInfoById(String email) {
		
		UserInifoBean userInifoBean=new UserInifoBean();
		try
		{
			SessionFactory sessionFactory=DataObjectUtil.getSessionFactory();
			Session session= sessionFactory.openSession();
			session.beginTransaction();
			UserInfo userInfo=(UserInfo)session.load(UserInfo.class,email);
		
		
			
			userInifoBean.setId(userInfo.getUserId());
			userInifoBean.setName(userInfo.getName());
			userInifoBean.setPassword(userInfo.getPassword());
		}
		catch(Exception e)
		{
			return null;
		}
		return userInifoBean;
	}

	@Override
	public boolean saveUserInfo(UserInfo userInfo) 
	{
		boolean isSave=false;
		SessionFactory sessionFactory=DataObjectUtil.getSessionFactory();
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		try
		{
			session.save(userInfo);
			session.getTransaction().commit();
			isSave=true;
		}
		catch(Exception p)
		{
			
		}
		return isSave;
	}

}
