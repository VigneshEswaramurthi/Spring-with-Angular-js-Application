package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.crud.bean.UserBean;
import com.crud.dao.Iretrievedao;

@Repository
@Primary
public class RetrieveService implements IretrieveService
{

	@Autowired
	public Iretrievedao retrievedao;
	@Override
	public String insert(UserBean userBean) 
	{
		
		return retrievedao.insert(userBean);
	}

	
	
}
