package com.pattern.methodProxy.demo;

/**
 * @author HongYi
 * @version 1.0
 * @date 2022/7/19 0:01
 * @description: 静态代理
 */
public class Main {
    public static void main(String[] args) {
        // 获得一只狗
        Dog dog = new DogProxy(new Dog());

        //使用时,我们并不知道他是被代理的;
        System.out.println(dog.say());
    }

    /**
     * 狗
     */
    static class Dog{
        public String say(){
            return "汪汪";
        }
    }

    /**
     * 狗的代理类
     */
    static class DogProxy extends Dog{
        private Dog dog;

        public DogProxy(Dog dog){
            this.dog = dog;
        }

        @Override
        public String say() {
            return super.say() + "嗷嗷嗷~~";
        }
    }
}
