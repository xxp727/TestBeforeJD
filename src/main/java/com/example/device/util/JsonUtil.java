package com.example.device.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
    private static ObjectMapper mapper = new ObjectMapper();

    public static String ObjectToJson(Object object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }

}
