package string;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version : V1.0
 * @date : 2022/3/4 9:12
 * @Author : LLH
 * @Desc :
 */
public class string02 {

    private static final String datePattern = "yyyyMMdd";
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat(datePattern);
        Date date = new Date();
        System.out.println("date = " + date);

        String nowData = format.format(date);
        System.out.println("nowData = " + nowData);

        System.out.println(nowData.concat("0000"));
        System.out.println(nowData.concat("0830"));

        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        String s = f.format(d);   //此时这个字符串为 2019-06-27
        Date d2 = f.parse(s);   //结果为 Thu Jun 27 00:00:00 CST 2019
        //失去时分秒的精度是因为我设置的simpledateformat并没有时分秒

        long time1 = d2.getTime() + 1000 * 60 * 60 * 24;  //1561564800000
//d2.getTime()将日期转化为时间戳，数据类型为long

        Date d31 = new Date(time1);   //又将时间戳转化我日期
        String s21 = f.format(d31);   //又将日期，根据我想要的格式转化为字符串,2019-06-28
        System.out.println("s21 = " + s21);

    }
}
