package com.pattern.create.builder.variety;

/**
 * @ClassName demo1
 * @Created by theLin
 * @Date 2021/12/13 22:44
 * @Description 需要创建一个不可变对象,这个对象中可以拥有几种属性；其中还存在属性为必有属性。
 *          必有属性加上final修饰; 没填入便不可初始化;
 *             如果加了final，就必须对其进行初始化
 *     其他非必须的属性都通过方法设置，每个方法都返回Builder对象自身。
 */

/**
 *     Person person = new Person();
 *         person.setName("张三");
 *         person.setAge("22");
 *         person.setGender("男");
 *         person.setCareer("程序员");
 *         ......
 *=====================================================
 *             Person person = new Person.Builder("张三","男")
 *                 .age("12")
 *                 .money("1000000")
 *                 .car("宝马")
 *                 .build();
 *
 *
 */

public class demo1 {
    public static void main(String[] args) {
        Person person = new Person.Builder("张三","男")
                .age("12")
                .money("1000000")
                .car("宝马")
                .build();
        System.out.println("person = " + person);
    }
}

class Person {
    /*名字（必须）*/
    private final String name;
    /*性别（必须）*/
    private final String gender;
    /*年龄（非必须）*/
    private final String age;
    /*鞋子（非必须）*/
    private final String shoes;
    /*衣服（非必须）*/
    private final String clothes;
    /*钱（非必须）*/
    private final String money;
    /*房子（非必须）*/
    private final String house;
    /*汽车（非必须）*/
    private final String car;
    /*职业（非必须）*/
    private final String career;

    @Override
    public String  toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                ", shoes='" + shoes + '\'' +
                ", clothes='" + clothes + '\'' +
                ", money='" + money + '\'' +
                ", house='" + house + '\'' +
                ", car='" + car + '\'' +
                ", career='" + career + '\'' +
                '}';
    }

    private Person(Builder builder) {
        this.name = builder.name;
        this.gender = builder.gender;
        this.age = builder.age;
        this.shoes = builder.shoes;
        this.clothes = builder.clothes;
        this.money = builder.money;
        this.house = builder.house;
        this.car = builder.car;
        this.career = builder.career;
    }

    public static class Builder {
        private final String name;
        private final String gender;
        private String age;
        private String shoes;
        private String clothes;
        private String money;
        private String house;
        private String car;
        private String career;

        public Builder(String name, String gender) {
            this.name = name;
            this.gender = gender;
        }

        public Builder age(String age) {
            this.age = age;
            return this;
        }

        public Builder car(String car) {
            this.car = car;
            return this;
        }

        public Builder shoes(String shoes) {
            this.shoes = shoes;
            return this;
        }

        public Builder clothes(String clothes) {
            this.clothes = clothes;
            return this;
        }

        public Builder money(String money) {
            this.money = money;
            return this;
        }

        public Builder house(String house) {
            this.house = house;
            return this;
        }

        public Builder career(String career) {
            this.career = career;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

}



