package com.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @version : V1.0
 * @date : 2021/12/9 9:59
 * @Author : LLH
 * @Desc :
 */
public class testAction01 {
    public static void main(String[] args) {

        List<String> strList = Arrays.asList("YangHang", "AnXiaoHei", "LiuPengFei");
        //对传入的参数执行遍历,  在便利的同时,去执行工具类中的addString方法;
                //因为每次都需要传入,和被方法调用同一个对象;
                        // 所以直接用 " :: " 对参数进行省略;
        strList.forEach(new testActionUtils()::addString);
                        // "::"号前是主类;  后面是要调用的方法;
        strList.forEach((t)->new testActionUtils().addString(t));
    }
    /**
     * FunctionalInterface允许传入：
     *   接口的实现类（传统写法，代码较繁琐）；
     *   Lambda表达式（只需列出参数名，由编译器推断类型）；
     *   符合方法签名的静态方法；（类名::方法名） 符合方法签名的实例方法（实例类型被看做第一个参数类型，比如：Arrays.sort(array, String::compareTo);）；
     *  符合方法签名的构造方法（实例类型被看做返回类型，这个可以看廖雪峰博客讲的详细点：https://www.liaoxuefeng.com/wiki/1252599548343744/1305207799545890）。
     *   FunctionalInterface不强制继承关系，不需要方法名称相同，只要求方法参数（类型和数量）与方法返回类型相同，即认为方法签名相同。 博主讲的很不错哦。呸！
     */

}
