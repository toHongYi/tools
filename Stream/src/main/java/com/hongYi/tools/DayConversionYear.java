package com.hongYi.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

/**
 * @version : V1.0
 * @date : 2022/5/17 15:03
 * @Author : LLH
 * @Desc :
 */
public class DayConversionYear {

        /**
         * 将字符串天数转换为几年几天
         * @param day：字符串天数
         * @return
         */
        public static String conversionDayToYear(String day){
            int time = Integer.parseInt(day);
            LocalDate today = LocalDate.now();
            LocalDate startDay = today.minusDays(time);
            Period p = Period.between(startDay, today);
            StringBuilder term = new StringBuilder();
            int years = p.getYears();
            //算隔了多少天
            startDay = startDay.plusYears(years);
            long days = today.toEpochDay() - startDay.toEpochDay();
            if (0 != years) {
                term.append(years).append("年");
            }
            if (0 != days) {
                term.append(days).append("天");
            }
            return term.toString();
        }

        /**
         * 日期格式转换
         * 将20210101转换为2021-01-01
         * @param date
         * @return
         */
        public static String dateFormatConversion(String date){
            StringBuilder sb = new StringBuilder();
            sb.append(date.substring(0,4));
            sb.append("-");
            if (date.length()==6){
                sb.append(date.substring(4));
            }else if(date.length()==8){
                sb.append(date.substring(4,6));
                sb.append("-");
                sb.append(date.substring(6));
            }
            return new String(sb);
        }

        /**
         * 日期转星期
         *
         * @param datetime
         * @return
         */
        public static String dateToWeek(String datetime) {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            String[] weekDays = { "周日", "周一", "周二", "周三", "周四", "周五", "周六" };
            // 获得一个日历
            Calendar cal = Calendar.getInstance();
            Date datet = null;
            try {
                datet = f.parse(datetime);
                cal.setTime(datet);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            // 指示一个星期中的某天。
            int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
            if (w < 0){
                w = 0;
            }
            return weekDays[w];
        }

}
