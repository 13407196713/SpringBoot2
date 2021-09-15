package com.example.springboot2.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

// 用户

// 对实体注释。任何 Hibernate 映射对象都要有这个注释
@Entity

// 声明此对象映射到数据库的数据表，如果没有则系统使用默认值(实体的短类名)。
@Table(name = "ay_user")

public class AyUser implements Serializable {

    //主键
    @Id
    private Integer id;
    //用户名
    private String name;
    //电话号码
    private String phoneNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
