package com.aiit.baidu;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import org.json.JSONObject;

import com.aiit.model.Admin;
import com.aiit.utils.DBUtils;
import com.baidu.aip.face.AipFace;

public class FaceDelete {
	// 设置APPID/AK/SK

	private static final Properties PROPERTIES = new Properties();

	public static AipFace getClient() {

		InputStream is = FaceDelete.class.getResourceAsStream("/api.properties");
		try {
			PROPERTIES.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		AipFace client=new AipFace(PROPERTIES.getProperty("APP_ID"), PROPERTIES.getProperty("API_KEY"), PROPERTIES.getProperty("SECRET_KEY"));
		return client;
	}

	
}
