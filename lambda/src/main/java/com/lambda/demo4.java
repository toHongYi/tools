package com.lambda;

import java.util.List;

/**
 * @version : V1.0
 * @date : 2021/12/5 20:33
 * @Author : LLH
 * @Description :
 */
public class demo4 {


    static class Person {
        private final String name;
        private final String surname;

        public Person(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }
        public String getName() {
            return name;
        }
        public String getSurname() {
            return surname;
        }


    }

    public static void main(String[] args) throws Exception{
        Person person1 = new Person("小黑","小二黑");
        Person person2 = new Person("小2黑","小二黑1");
        List<Person> people = null;
        people.add(person1);
        people.add(person2);

        System.out.println("people.stream().map(Person::getName) = " + people.stream().map(Person::getName));

    }

}