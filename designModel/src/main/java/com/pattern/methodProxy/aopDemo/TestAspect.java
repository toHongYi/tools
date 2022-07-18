//package com.pattern.methodProxy.aopDemo;
//
//import org.springframework.stereotype.Component;
//
///**
// * @author HongYi
// * @version 1.0
// * @date 2022/7/19 0:08
// * @description: TODO
// */
//@Aspect
//@Component
//public class TestAspect {
//
//    /**
//     * 切入点
//     *  public 所有权,可省略不写;
//     *  第一个*号代表返回类型 * 号匹配所有
//     *  Dog类名 可用D* 或 **来模糊匹配
//     *  方法名称 可用 * 号匹配所有
//     *  ()参数列表 可用 (..)匹配所有
//     */
//    @Pointcut("execution(public * com.pattern.aopDemo.Dog.*())")
//    public void pointCut(){
//    }
//
//    /**
//     *
//     */
//    @Before("Pointcut")
//    public void before(){
//        System.out.println("before 汪汪");
//    }
//
//    @After("Pointcut")
//    public void after(){
//        System.out.println("after 汪汪");
//    }
//
//    @Around("Pointcut")
//    public void around(){
//        System.out.println("汪汪");
//    }
//
//    @AfterReturning("Pointcut")
//    public void before(){
//        System.out.println("汪汪");
//    }
//
//
//}
