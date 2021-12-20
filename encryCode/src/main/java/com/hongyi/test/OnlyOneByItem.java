package com.hongyi.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @version : V1.0
 * @date : 2021/12/19 21:51
 * @Author : LLH
 * @Desc : 从Mybatis中获取到的数据都为List形式,里面存的是对象;
 *          并对数据进行去重操作;
 *          数据去重后,用工具类,处理掉普通的格式转化;
 *
 *          QT字段内的数据需要进行
 *
 */
public class OnlyOneByItem {
    private static Test test;
    private static HashSet<Object> map;

    /**
     * 入参: 数据库中的数组对象,
     * @param
     * @Return : 返回的数据为数据库需要接收的数组数据,并封装至回惨对象;
     */

    public static void main(String[] args) {
        System.out.println(" ");
        System.out.println("====================================测试开始===========================================");
        Test hongYi = new Test("鸿一", "17");
        Test hongYi2 = new Test("鸿一", "19");
        Test xinYi = new Test("欣一", "27");

        List<Test> tests = new ArrayList<>();
        tests.add(hongYi);
        tests.add(xinYi);
        tests.add(hongYi2);
        System.out.println("此时对象内容tests = " + tests);


        System.out.println("====================================进入下一阶段——取值,去重========================================");
        System.out.println(" ");


        HashSet<String> set = new  HashSet<>();

        tests.parallelStream().forEach((t)->doSome(t,set));
        System.out.println("是否去重成功:set = " + set);

        System.out.println("======================================去重完成================================================");



        System.out.println(" ");
        System.out.println("====================================测试结束===========================================");
    }

    private static void doSome(Test test, HashSet<String> set) {
        System.out.println("test.getTestName() = " + test.getTestName());
        set.add(test.testName);
    }


    static class Test{
        String testName;
        String testAge;


        public String getTestName() {
            return testName;
        }

        public void setTestName(String testName) {
            this.testName = testName;
        }

        public String getTestAge() {
            return testAge;
        }

        public void setTestAge(String testAge) {
            this.testAge = testAge;
        }

        public Test(String testName, String testAge) {
            this.testName = testName;
            this.testAge = testAge;
        }

        @Override
        public String toString() {
            return "Test{" +
                    "testName='" + testName + '\'' +
                    ", testAge='" + testAge + '\'' +
                    '}';
        }
    }

}
