package com.aiit.service.impl;

import com.aiit.dao.AdminDao;
import com.aiit.dao.impl.AdminDaoImpl;
import com.aiit.model.Admin;
import com.aiit.service.AdminService;

public class AdminServiceImpl implements AdminService {

	AdminDao dao=new AdminDaoImpl();
	/**
	 * 登录
	 */
	
	@Override
	public Admin AdminLogin(String username) {
		return dao.AdminLogin(username);
	}
	
	/**
	 *检验重复
	 */
	@Override
	public boolean vaildUserName(String username) {
		return dao.vaildUserName(username);
	}

	/**
	 * 管理员注册
	 */
	@Override
	public int AdminRegister(Admin admin) {
		return dao.AdminRegister(admin);
	}

	/**
	 * 修改管理员信息
	 */
	@Override
	public int updateAdmin(Admin admin) {
		return dao.updateAdmin(admin);
	}

	/**
	 * 注销管理员信息
	 */
	@Override
	public int deleteAdmin(Admin admin) {
		return dao.deleteAdmin(admin);
	}

	@Override
	public Admin seachAdmin(String user_id) {
		
		return dao.seachAdmin(user_id);
	}


}
