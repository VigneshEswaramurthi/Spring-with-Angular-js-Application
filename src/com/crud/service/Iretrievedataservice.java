package com.crud.service;

import java.util.List;

import com.crud.bean.UserBean;


public interface Iretrievedataservice 
{
	public List<UserBean> findAllUsers(UserBean userBean);
	
	public String delete(String username);
}
