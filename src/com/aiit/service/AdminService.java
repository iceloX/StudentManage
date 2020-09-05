package com.aiit.service;

import com.aiit.model.Admin;

public interface AdminService {

	Admin AdminLogin(String username);

	boolean vaildUserName(String username);

	int AdminRegister(Admin admin);

	int updateAdmin(Admin admin);

	int deleteAdmin(Admin admin);

	Admin seachAdmin(String user_id);

}
