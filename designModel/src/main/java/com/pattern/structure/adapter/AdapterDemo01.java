package com.pattern.structure.adapter;

/**
 * @version : V1.0
 * @date : 2022/1/8 18:34
 * @Author : LLH
 * @Desc :
 */
public class AdapterDemo01 {

    // 已存在的、具有特殊功能、但不符合我们既有的标准接口的类
    class Adaptee {
        public void specificRequest() {
            System.out.println("被适配类具有 特殊功能...");
        }
    }

    // 目标接口，或称为标准接口
    interface Target {
        public void request();
    }

    // 具体目标类，只提供普通功能
    static class ConcreteTarget implements Target {
        public void request() {
            System.out.println("普通类 具有 普通功能...");
        }
    }

    // 适配器类，继承了被适配类，同时实现标准接口
    static class Adapter extends AdapterDemo01 implements Target{
        public void request() {
            //super.specificRequest();
        }
    }

    // 测试类public class Client {
    public static void main(String[] args) {
        // 使用普通功能类
        Target concreteTarget = new ConcreteTarget();
        concreteTarget.request();

        // 使用特殊功能类，即适配类
        Target adapter = new Adapter();
        adapter.request();
    }
}

