package com.pattern.relationship.strategy;

/**
 * @version : V1.0
 * @date : 2022/1/6 9:14
 * @Author : LLH
 * @Desc :
 */
public class Client {
    public static void main(String[] args){
        Context context;
        System.out.println("-----执行策略1-----");
        context = new Context(new ConcreteStrategy1());
        context.execute();
        System.out.println("-----执行策略2-----");
        context = new Context(new ConcreteStrategy2());
        context.execute();
        }
    }


    interface IStrategy {
        public void doSomething();
    }
    class ConcreteStrategy1 implements IStrategy {
        public void doSomething() {
            System.out.println("具体策略1");
        }
    }
    class ConcreteStrategy2 implements IStrategy {
        public void doSomething() {
            System.out.println("具体策略2");
        }
    }
    class Context {
        private IStrategy strategy;

        public Context(IStrategy strategy){
            this.strategy = strategy;
        }

        public void execute(){
            strategy.doSomething();
        }
    }