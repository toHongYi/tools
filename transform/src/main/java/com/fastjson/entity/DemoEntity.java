package com.fastjson.entity;

import java.util.Date;

public class DemoEntity {
    public String name;
    public String address;
    public Date birthday;
    public Integer day;

    public DemoEntity() {
    }

    public DemoEntity(String name, String address, Integer day) {
        this.name = name;
        this.address = address;
        this.day = day;
    }

    public DemoEntity(String name, String address, Date birthday) {
        this.name = name;
        this.address = address;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}

