package com.aiit.test;

import java.sql.Connection;

import org.junit.Test;

import com.aiit.utils.DBUtils;

/**
 * 测试数据库连接
 * @author icelo
 *
 */
public class DBtest {
	
	@Test
	public void DBtest(){
		Connection con=DBUtils.getConnection();
		System.out.println(con);
	}
}
