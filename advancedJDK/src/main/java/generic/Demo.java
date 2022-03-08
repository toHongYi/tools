package generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @version : V1.0
 * @date : 2022/3/8 9:02
 * @Author : LLH
 * @Desc :
 */
public class Demo {
    public static void main(String[] args) {

        Demo demo = new Demo();
        ResponseDemo<ResponseDemo> sout = demo.sout();
        System.out.println("sout = " + sout);

        ResponseDemo<String> stringResponseDemo = demo.sout1();
        System.out.println("stringResponseDemo = " + stringResponseDemo);

        Repu<String> stringRepu = demo.sout3();
        System.out.println("stringRepu = " + stringRepu);

        List<String> list = new ArrayList();
        list.add("测试");

    }

    private ResponseDemo<ResponseDemo> sout(){

        System.out.println("测试数据");
        return null;
    }

    private ResponseDemo<String> sout1(){

        //ResponseDemo<Object> demo = new ResponseDemo<>();
        ResponseDemo<String> demo = new ResponseDemo<>();

        /**
         *  demo.setData(1);
         *  return demo;
         */

        demo.setData("测试");
        return demo;
    }

    private Repu<String> sout3(){
        Repu<String> repu = new Repu<>();
        repu.age="2";

        return repu;
    }
}
