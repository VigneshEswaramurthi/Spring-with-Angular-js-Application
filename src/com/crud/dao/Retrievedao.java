package com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.crud.bean.UserBean;
public class Retrievedao implements Iretrievedao
{
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	@Override
	public String insert(UserBean userBean) 
	{
		String sql = "insert into customers " +
				"(username, phone, email, address, password) VALUES (?,?,?,?,?)";
	Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userBean.getUsername());
			ps.setInt(2, userBean.getphone());
			ps.setString(3, userBean.getemail());
			ps.setString(4, userBean.getaddress());
			ps.setString(5, userBean.getPasswords());
			ps.execute();
			ps.close();
			
		} catch (SQLException e) 
		{
			throw new RuntimeException(e);
			
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
	}
		return sql;
	}

}
