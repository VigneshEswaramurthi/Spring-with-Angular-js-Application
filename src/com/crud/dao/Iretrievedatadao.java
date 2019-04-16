package com.crud.dao;

import java.util.List;

import com.crud.bean.UserBean;

public interface Iretrievedatadao 
{
	public List<UserBean> findAllUsers(UserBean userBean);
	
	public String delete(String username);

}
