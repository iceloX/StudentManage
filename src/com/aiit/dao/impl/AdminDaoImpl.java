package com.aiit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aiit.dao.AdminDao;
import com.aiit.model.Admin;
import com.aiit.utils.DBUtils;

public class AdminDaoImpl implements AdminDao {

	/**
	 * 管理员登录数据库
	 */
	@Override
	public Admin AdminLogin(String username) {
		Connection con=null;
		PreparedStatement pstat=null;
		ResultSet res=null;
		String sql="select * from admin where username=?";
		Admin admin=null;
		try {
			con=DBUtils.getConnection();
			pstat=con.prepareStatement(sql);
			pstat.setString(1, username);
			res=pstat.executeQuery();
			if(res.next()) {
				int id = res.getInt(1);
				String name=res.getString(2);
				String username1=res.getString(3);
				String password=res.getString(4);
				admin =new Admin(id, name, username1, password);
				return admin;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(con, pstat, res);
		}
		return admin;
	}

	/**
	 * 重复用户注册检查的数据库操作
	 * @param username->用户名
	 */
	@Override
	public boolean vaildUserName(String username) {
		Connection connection=null;
		PreparedStatement pstat=null;
		ResultSet res=null;
		String sql="select * from admin where username=?";
		boolean flag=false;

		try {
			connection=DBUtils.getConnection();
			pstat=connection.prepareStatement(sql);
			pstat.setString(1, username);
			res=pstat.executeQuery();
			if(res.next()) {
				flag=true;
				return flag;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(connection, pstat, res);
		}
		return flag;
	}

	/**
	 * 管理员注册的数据库操作
	 */
	@Override
	public int AdminRegister(Admin admin) {
		Connection connection=null;
		PreparedStatement pstat=null;
		ResultSet res=null;
		int i=0;
		String sql="insert into admin(name,username,password) values(?,?,?)";
		
		try {
			connection=DBUtils.getConnection();
			pstat=connection.prepareStatement(sql);
			pstat.setString(1, admin.getName());
			pstat.setString(2, admin.getUsername());
			pstat.setString(3, admin.getPassword());
			i=pstat.executeUpdate();
			
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(connection, pstat, res);
		}
		
		return i;
	}

	/**
	 * 修改管理员信息数据库操作
	 */
	@Override
	public int updateAdmin(Admin admin) {
		Connection con=null;
		PreparedStatement pstat=null;
		String sql="update admin set name=?,username=?,password=? where id=? ";
		int i=0;
		try {
			con=DBUtils.getConnection();
			pstat=con.prepareStatement(sql);
			pstat.setString(1, admin.getName());
			pstat.setString(2, admin.getUsername());
			pstat.setString(3,admin.getPassword());
			pstat.setInt(4, admin.getId());
			i=pstat.executeUpdate();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(con, pstat, null);
		}
		return i;
	}

	/**
	 * 注销管理员的数据库操作;
	 */
	@Override
	public int deleteAdmin(Admin admin) {
		Connection con=null;
		PreparedStatement pstat=null;
		String sql="delete from admin where id =?";
		int i=0;
		try {
			con=DBUtils.getConnection();
			pstat=con.prepareStatement(sql);
			pstat.setInt(1, admin.getId());
			i=pstat.executeUpdate();
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(con, pstat, null);
		}
		return i;
	}

	@Override
	public Admin seachAdmin(String user_id) {
		Connection con=null;
		PreparedStatement pstat=null;
		ResultSet res=null;
		String sql="select * from admin where username =?";
		Admin admin=null;
		try {
			con=DBUtils.getConnection();
			pstat=con.prepareStatement(sql);
			pstat.setString(1,user_id);
			res=pstat.executeQuery();
			while(res.next()) {
				int id=res.getInt(1); //id
				System.out.println(id);
				String name=res.getString(2);//name
				String username=res.getString(3);//username
				String password=res.getString(4);//password
				admin=new Admin(id,name,username,password);
			}
			return admin;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

}
