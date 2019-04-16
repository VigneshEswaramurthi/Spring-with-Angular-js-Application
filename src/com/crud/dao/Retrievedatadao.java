package com.crud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.crud.bean.UserBean;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
@Repository
@Primary
public class Retrievedatadao implements Iretrievedatadao
{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public void setDataSource(DataSource dataSource) 
	{
		this.dataSource = dataSource;
	}

	@Override
	public List<UserBean> findAllUsers(UserBean userBean) 
	{
		List<UserBean> userList =new ArrayList<UserBean>();
		
			java.sql.Connection con=null;
			String stq="select username, phone, email from customers";
		try
		{
			con = dataSource.getConnection();
			PreparedStatement pst=con.prepareStatement(stq);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				UserBean user = new UserBean();
				user.setUsername(rs.getString(1));
				//System.out.println(rs.getString(1));
				user.setphone(rs.getInt(2));
				user.setemail(rs.getString(3));
				userList.add(user);
			}
			rs.close();
			con.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return userList;
			
	}

	@Override
	public String delete(String username) 
	{
		System.out.println("hii");
		//String sql="delete from customers where username='" + username +"'";
		java.sql.Connection con=null;
		try
		{
			con = dataSource.getConnection();
			PreparedStatement pst=con.prepareStatement("delete from customers where username='" + username +"'");
			pst.executeUpdate();
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
		return null;
	}

}
