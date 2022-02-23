package demo;

/**
 * @version : V1.0
 * @date : 2022/1/28 16:09
 * @Author : LLH
 * @Desc :
 */
class TexrException extends Exception{

    TexrException(String str){
        super(str);
    }
}

class LanPingException extends Exception {

    LanPingException(String message) {
        super(message);
    }

}

class MaoYanException extends Exception {

    MaoYanException(String message) {
        super(message);
    }

}


class NoPlanException extends Exception {

    NoPlanException(String msg) {
        super(msg);
    }
}

class Computer {
    private int state = 3;
    public void run()throws LanPingException,MaoYanException {

        if(state==2)
            throw new LanPingException("蓝屏了");

        if(state==3)
            throw new MaoYanException("冒烟了");

        System.out.println("电脑运行");
    }

    public void reset() {
        state = 1;
        System.out.println("电脑重启");
    }
}

class Teacher {

    private String name;
    private Computer cmpt;

    Teacher(String name) {
        this.name = name;
        cmpt = new Computer();
    }

public void prelect()throws Exception {

        try {
            cmpt.run();
        } catch (LanPingException e) {
            cmpt.reset();
        } catch (MaoYanException e) {
            test();
            throw new NoPlanException("后方是不是冒烟了::".concat(e.getMessage()));
        }
        System.out.println("讲课");
    }
    public void test(){
        System.out.println("练习");
    }
}



class ExceptionTest {
    public static void main(String[] args) {

        Teacher t = new Teacher("毕老师");
        //t.prelect();
        try {
            t.prelect();
            System.out.println("t = " + "让我康康");

            //其结构类似与if()else()结构;通过接受下层抛出异常对象再进行逻辑处理;
            //
            /**
             * 外层接受内层抛出的异常;
             *      自定义异常可以通过继承Exception类进行实现创建。
             *           唯一参数是有参构造(String str);
             *           将输入的参数作为其代表的异常信息向外界进行展示;
             *
             */
        } catch (LanPingException e) {
            System.out.println(e.toString());
            System.out.println("换老师或者放假");
            System.err.println("测试结束,准备打印");
            /**  将JVM中的异常信息向外界进行打印出来;内部使用了方法重载添加默认参数    System.err  */
            e.printStackTrace();

        } catch (Exception e) {
            System.err.println("测试结果");
            e.printStackTrace();
        }
    }
}

