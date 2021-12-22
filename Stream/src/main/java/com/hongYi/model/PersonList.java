package com.hongYi.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @version : V1.0
 * @date : 2021/12/21 0:01
 * @Author : LLH
 * @Desc :
 */
public class PersonList {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, "male", "New York"));
        personList.add(new Person("Jack", 7000, "male", "Washington"));
        personList.add(new Person("Lily", 7800, "female", "Washington"));
        personList.add(new Person("Anni", 8200, "female", "New York"));
        personList.add(new Person("Owen", 9500, "male", "New York"));
        personList.add(new Person("Alisa", 7900, "female", "New York"));

    }

    static class Person {
        private String name;  // 姓名
        private int salary; // 薪资
        private int age; // 年龄
        private String sex; //性别
        private String area;  // 地区

        // 构造方法
        public Person(String tom, int salary, String male, String new_york) {
            this.name=tom;
            this.salary=salary;
            this.name=male;
            this.area=new_york;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", salary=" + salary +
                    ", age=" + age +
                    ", sex='" + sex + '\'' +
                    ", area='" + area + '\'' +
                    '}';
        }
    }


}
