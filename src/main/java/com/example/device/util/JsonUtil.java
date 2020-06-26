package com.example.device.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.example.device.domain.Device;
import com.example.device.domain.RespBean;



public class JsonUtil {
    public static String ObjectToJson(Object object){
        try{
            return JSON.toJSONString(object);
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

    public static Object JsonToResp(String string){
        try{
            return JSON.parseObject(string);
        }
        catch (Exception e){
            return null;
        }
    }

}
