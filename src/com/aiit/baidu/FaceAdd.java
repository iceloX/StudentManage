package com.aiit.baidu;

import com.baidu.ai.aip.utils.HttpUtil;
import com.aiit.model.Admin;
import com.baidu.ai.aip.utils.Base64Util;
import com.baidu.ai.aip.utils.FileUtil;
import com.baidu.ai.aip.utils.GsonUtils;

import java.io.File;
import java.util.*;

/**
* 人脸注册
*/
public class FaceAdd {

    /**
    * 重要提示代码中所需工具类
    * FileUtil,Base64Util,HttpUtil,GsonUtils请从
    * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
    * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
    * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
    * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
    * 下载
    */
    public static String add(String filePath,Admin a) {
        // 请求url
    	//File file=new File(filePath);
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/user/add";
       
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("image", Base64Util.encode(FileUtil.readFileByBytes(filePath)));
            System.out.println(a.toString());
            map.put("group_id", "admin");
            map.put("user_id", a.getUsername());
            map.put("user_info", a.toString());
            map.put("liveness_control", "NONE");
           // map.put("image_type", "FACE_TOKEN");
            map.put("image_type", "BASE64");
            map.put("quality_control", "LOW");

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = AuthService.getAuth();
            //String myselfToken="25.db82e4c7983c384934c1fd2f96777da0.315360000.1912600774.282335-21745111";

            String result = HttpUtil.post(url, accessToken, "application/json", param);
          //  System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}