package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.crud.bean.UserBean;
import com.crud.dao.Iretrievedatadao;

@Service
@Repository
@Primary
public class Retrievedataservice implements Iretrievedataservice
{
	@Autowired
	public Iretrievedatadao retrievedatadao;

	@Override
	public List<UserBean> findAllUsers(UserBean userBean) 
	{
		return retrievedatadao.findAllUsers(userBean);
	}

	@Override
	public String delete(String username) {
		
		return retrievedatadao.delete(username);
	}
	
	
}
