package com.hongYi.model;

import java.util.Date;

/**
 * @version : V1.0
 * @date : 2022/5/6 17:29
 * @Author : LLH
 * @Desc :
 */
public class Student {

    private long id;
    private String name;
    private int age;
    private boolean sex;
    private Date birthday;

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Student(long id, String name, int age, boolean sex, Date birthday) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.birthday = birthday;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", birthday=" + birthday +
                '}';
    }
}
