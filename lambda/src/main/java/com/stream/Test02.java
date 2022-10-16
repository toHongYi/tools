package com.stream;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.stream.Collectors;
import org.apache.commons.lang3.tuple.Pair;

/**
 * @author HongYi
 * @version 1.0
 * @date 2022/9/30 19:56
 * @description:
 */
public class Test02 {


    @Test
    public void test01() {
        String[] int02 = new String[]{"100", "101", "102", "103", "104", "105", "106", "107"};
        String[] int01 = new String[]{"100", "101", "102"};


        List<String> ints1 = Arrays.asList(int01);
        List<String> ints2 = Arrays.asList(int02);


        List<String> collect1 = ints2.stream().filter(t -> !ints1.contains(t)).collect(Collectors.toList());
        System.out.println("collect = " + collect1);

    }


    public boolean listContains(List<String> list, String value) {
        return list.contains(value);
    }

    @Test
    public void test002() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        System.out.println("contains判断：" + listContains(list, "2"));
    }


    @Test
    public void test1003(){
        Instant instant = Instant.now();
        System.out.println("instant = " + instant);
        //l为1970年1月1日至所记录时间的的毫秒数
        Instant instant1 = Instant.ofEpochMilli(10l);
    }

    @Test
    public void test1005(){
        TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
        Date d1 = new Date();
        Instant i1 = Instant.now();
        ZonedDateTime z1 = ZonedDateTime.now();
        LocalDateTime l1 = LocalDateTime.now();

        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        Date d2 = new Date();
        Instant i2 = Instant.now();
        ZonedDateTime z2 = ZonedDateTime.now();
        LocalDateTime l2 = LocalDateTime.now();

        TimeZone.setDefault(TimeZone.getTimeZone("Australia/Darwin"));
        Date d3 = new Date();
        Instant i3 = Instant.now();
        ZonedDateTime z3 = ZonedDateTime.now();
        LocalDateTime l3 = LocalDateTime.now();
//        版权声明：本文为CSDN博主「vant10」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//        原文链接：https://blog.csdn.net/qq_21845263/article/details/106203865
    }

    @Test
    public void test1004(){
        Pair<Date, Date> seasonRange = getSeasonRange();
        System.out.println("seasonRange = " + seasonRange);

    }

    // wrap一层; ,在return时,对数据进行修修正;
    @Test
    public void test1015(){

        Pair<Date, Date> seasonRange2 = getSeasonRangeTwo();
        System.out.println("seasonRange2 = " + seasonRange2);
    }

    public static Pair<Date, Date> getSeasonRange() {
        Pair<Date, Date> seasonRange = getSeasonRange(LocalDate.now());
        return seasonRange;
    }

    public static Pair<Date, Date> getSeasonRangeTwo() {
        Pair<Date, Date> seasonRange = getSeasonRange(LocalDate.now());
        return seasonRange;
    }


    public static Pair<Date, Date> getSeasonRange(LocalDate now) {
        LocalDate beginDate = now.minusMonths(3).with(TemporalAdjusters.firstDayOfMonth());
        LocalDate endDate = now.minusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
        Date value = DateUtil.localDate2Date(endDate);
        return Pair.of(
                DateUtil.localDate2Date(beginDate),
                lastSecondDate(value)
        );
    }


    // 当天的最后一S
    public static  Date lastSecondDate(LocalDate date)  {
        Date d2 = DateUtil.localDate2Date(date);
        int dayMis=1000*60*60*24;//一天的毫秒-1
        //返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
        long curMillisecond=d2.getTime();//当天的毫秒
        long resultMis=curMillisecond+(dayMis-1); //当天最后一秒
        DateFormat format2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //得到我须要的时间    当天最后一秒
        Date resultDate=new Date(resultMis);
        return resultDate;
    }

    // 当天的最后一S
    public static  Date lastSecondDate(Date date)  {

        Date d2=date;
        int dayMis=1000*60*60*24;//一天的毫秒-1
        //返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
        long curMillisecond=d2.getTime();//当天的毫秒
        long resultMis=curMillisecond+(dayMis-1); //当天最后一秒
        DateFormat format2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //得到我须要的时间    当天最后一秒
        Date resultDate=new Date(resultMis);
        return resultDate;
    }

    // 当天的最后一S
    public static  String lastSecond(Date date)  {

        Date d2=date;
        int dayMis=1000*60*60*24;//一天的毫秒-1
        //返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
        long curMillisecond=d2.getTime();//当天的毫秒
        long resultMis=curMillisecond+(dayMis-1); //当天最后一秒
        DateFormat format2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //得到我须要的时间    当天最后一秒
        Date resultDate=new Date(resultMis);
        String str = format2.format(resultDate);
        return str;
    }

    // 当天的最后一S
    public static  String lastSecond(String date)  {
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d2=format.parse(date);
            int dayMis=1000*60*60*24;//一天的毫秒-1
            //返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
            long curMillisecond=d2.getTime();//当天的毫秒
            long resultMis=curMillisecond+(dayMis-1); //当天最后一秒
            DateFormat format2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //得到我须要的时间    当天最后一秒
            Date resultDate=new Date(resultMis);
            String str = format2.format(resultDate);
            return str;
        }catch (ParseException e){
            return date;
        }
    }


    @Test
    void test2103(){


    }

}
