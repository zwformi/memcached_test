package com.zw.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/10.
 */
public class person implements Serializable{
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    @Override
    public String toString(){
        return "姓名："+name+",年龄："+age;
    }
}
