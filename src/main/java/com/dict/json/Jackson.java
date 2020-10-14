package com.dict.json;

import com.dict.entity.Dept;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;


public class Jackson {

    public static void main(String[] args) {
        String json = "[\"zhangsan\",\"lise\",\"wangwu\"]";
        ObjectMapper om = new ObjectMapper();
        try {
            JavaType javaType = om.getTypeFactory().constructParametricType(List.class, String.class);
            List<Integer> list = om.readValue(json, javaType);
            System.out.println(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Dept getDept(){
        Dept dept = new Dept();
        dept.setDeptno(10);
        dept.setDname("produt");
        dept.setLoc("beijing");
        return dept;
    }

}
