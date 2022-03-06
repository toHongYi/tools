package string;

import java.io.PrintStream;
import java.util.function.Consumer;

/**
 * @version : V1.0
 * @date : 2022/3/6 19:52
 * @Author : LLH
 * @Desc :
 */
public class PrintDemo {
    public static void main(String[] args) {

        /**
         * 我初次见到的写法
         */
        Consumer<String> fun = System.out::println;
        fun.accept("hello world");

        //此方法实际上是获取了一个静态变量既静态实例,通过该静态实例;
        //调用该对象的类型的指定方法获取到其中的指定方法、最终实现这一功能;
        System.out.println("========================================");

        /**
         * 现在想想其实很简单，查看println方法的源码得知println是PrintStream类中的一个非静态方法
         * 因此按照方法引用的逻辑，它肯定可以使用
         * “函数式接口 变量名 = 类实例::方法名” 的方式对该方法进行引用
         *
         * 而System.out的作用肯定就是来获取PrintStream类的一个类实例,
         *
         * 验证代码如下：
         */
        PrintStream out = System.out;
        Consumer<String> fun2 = out::println;
        fun2.accept("hello beijing");

        //静态变量是public修饰才可直接使用;


        //静态变量是private修饰,无法直接使用;
        //boolean autoFlush = PrintStream.autoFlush;
        //System.out.println("autoFlush = " + autoFlush);


        //为什么不用PrintStream,而要用System.out;
        //PrintStream printStream = new PrintStream(); 不支持无参构造;
        PrintDemo.out1.println("现在即可通过静态公开实例将数据展示");

    }

    public final static PrintStream out1 = null;
}
