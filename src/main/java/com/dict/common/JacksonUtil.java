package com.dict.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JacksonUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JacksonUtil.class);

    /**
     * 将object序列化为json字符串
     * @param object
     * @return
     */
    public static String toJson(Object object){
        String json = null;
        if (object == null){
            return null;
        }
        ObjectMapper om = new ObjectMapper();
        try {
            json = om.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            LOGGER.error("object to json failed",e.getMessage());
        }
        return json;
    }

    /**
     * json字符串反序列化为对象
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T toObject(String json, Class<T> clazz){
        T obj = null;
        if (StringUtils.isEmpty(json)){
            return null;
        }
        ObjectMapper om = new ObjectMapper();
        try {
            obj = om.readValue(json, clazz);
        } catch (IOException e) {
            LOGGER.error("to object failed", e.getMessage());
        }
        return obj;
    }




}
