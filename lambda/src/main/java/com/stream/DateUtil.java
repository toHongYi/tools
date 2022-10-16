package com.stream;

import org.apache.commons.lang3.tuple.Pair;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

public class DateUtil {


    public static final String DATE_YEAR_START_TIME = "yyyy-01-01 00:00:00";

    /**
     * 例如:2018
     */
    public static final String DATE_YEAR = "yyyy";

    /**
     * 例如:2018-12-28
     */
    public static final String DATE = "yyyy-MM-dd";

    /**
     * 例如:2018-12-28
     */
    public static final String DATE_OTHER = "yyyy/MM/dd";

    /**
     * 例如:12月28日
     */
    public static final String DATE_DAY = "MM月dd日";

    /**
     * 例如:2018-12-28 10:00:00
     */
    public static final String DATE_TIME = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_TIME_START = "yyyy-MM-dd 00:00:00";

    public static final String DATE_TIME_END = "yyyy-MM-dd 23:59:59";
    /**
     * 例如:2018/12/28 10:00:00
     */
    public static final String DATE_TIME_NEW = "yyyy/MM/dd HH:mm:ss";
    /**
     *
     */
    public static final String START_DATE_HOURS = "yyyy-MM-dd HH:00:00";

    public static final String START_DATE_MINUTE = "yyyy-MM-dd HH:mm:00";

    public static final String END_DATE_MINUTE = "yyyy-MM-dd HH:mm:59";

    public static final String END_DATE_HOURS = "yyyy-MM-dd HH:59:59";

    public static final String DATE_ONE = "yyyy/MM/dd HH:mm:ss";

    public static final String DATE_TWO = "yyyyMMddHHmmss";

    public static final String NUM_ONE = " 00:00:00";

    public static final String NUM_TWO = "0000";

    public static final String NUM_THREE = " 23:59:59";

    public static final String FULL_TIME_PATTERN = "yyyyMMddHHmmss";

    public static final String FULL_TIME_SPLIT_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static final String CST_TIME_PATTERN = "EEE MMM dd HH:mm:ss zzz yyyy";

    public static final String FULL_DAY_PATTERN = "yyyyMMdd";

    /**
     * 月份开始时间
     */
    public static final String DATE_MONTH_START_TIME = "yyyy-MM-01 00:00:00";

    /**
     * 例如:10
     */
    public static final String HOURS = "HH";
    /**
     * 例如:10日10时
     */
    public static final String TIME_CHARTS = "dd日HH时";

    /**
     * 例如:10日10时
     */
    public static final String TIME_CHARTS_SHOW = "MM.dd";

    /**
     * 例如:10月10日
     */
    public static final String TIME_CHARTS_DAY = "MM月dd日";

    /**
     * 例如:10月10日
     */
    public static final String TIME_CHARTS_DAY_ONE = "yyyy年MM月dd日";

    /**
     * 例如:10月10日
     */
    public static final String TIME_CHARTS_DAY_TWO = "yyyy年MM月dd日HH时";

    /**
     * 例如:2018-12-28 10:00:00
     */
    public static final String DATE_TIME_ONE = "yyyy年MM月dd日 HH:mm:ss";
    /**
     * 例如:10:00:00
     */
    public static final String TIME = "HHmmss";

    /**
     * 例如:10:00:00
     */
    public static final String TIME_ONE = "HH:mm:ss";
    /**
     * 例如:10:00
     */
    public static final String TIME_WITHOUT_SECOND = "HH:mm";

    /**
     * 例如:2018-12-28 10:00
     */
    public static final String DATE_TIME_WITHOUT_SECONDS = "yyyy-MM-dd HH:mm";

    // 时间元素
    public static final String YEAR = "year";
    public static final String MONTH = "month";
    public static final String WEEK = "week";
    public static final String DAY = "day";
    public static final String HOUR = "hour";
    public static final String MINUTE = "minute";
    public static final String SECOND = "second";
    // 根据指定格式显示日期和时间
    /**
     * yyyy-MM-dd
     */
    private static final DateTimeFormatter yyyyMMdd_EN = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private DateUtil() {

    }

    /**
     * 获取1970到当前的秒数
     */
    public static long getTimeSecond() {
        return Instant.now().getEpochSecond();
    }

    /**
     * 获取1970到当前的毫秒数
     */
    public static long getTimeMillisecond() {
        return Instant.now().toEpochMilli();
    }

    /**
     * 将Long类型的时间戳转换成String 类型的时间格式，时间格式为：yyyy-MM-dd HH:mm:ss
     */
    public static String convertTimeToString(Long time) {
        if (StringUtils.isEmpty(time)) {
            throw new RuntimeException("传入时间不能为空");
        }
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return ftf.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault()));
    }

    /**
     * 将字符串转日期成Long类型的时间戳，格式为：yyyy-MM-dd HH:mm:ss
     */
    public static Long convertTimeToLong(String time) {
        if (StringUtils.isEmpty(time)) {
            throw new RuntimeException("传入时间不能为空");
        }
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse(time, ftf);
        return LocalDateTime.from(parse).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 将Long类型的时间戳转换成String 类型的时间格式
     */
    public static String convertTimeToString(Long time, String format) {
        if (StringUtils.isEmpty(time)) {
            throw new RuntimeException("传入时间不能为空");
        }
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern(format);
        return ftf.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault()));
    }

    /**
     * 将字符串转日期成Long类型的时间戳，格式为自定义
     */
    public static Long convertTimeToLong(String time, String pattern) {
        if (StringUtils.isEmpty(time)) {
            throw new RuntimeException("传入时间不能为空");
        }
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime parse = LocalDateTime.parse(time, ftf);
        return LocalDateTime.from(parse).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 格式化日期为字符串
     *
     * @param date    date
     * @param pattern 格式
     * @return 日期字符串
     */
    public static String format(Date date, String pattern) {
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 格式化日期为字符串
     *
     * @param date date
     * @return 日期字符串
     */
    public static String dateToString(Date date) {
        return dateToString(date, DATE);
    }

    /**
     * 格式化日期为字符串
     *
     * @param date    date
     * @param pattern 格式
     * @return 日期字符串
     */
    public static String dateToString(Date date, String pattern) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalDate localDate = localDateTime.toLocalDate();
        return localDate.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String formatFullTime(LocalDateTime localDateTime) {
        return formatFullTime(localDateTime, FULL_TIME_PATTERN);
    }

    public static String formatFullTime(LocalDateTime localDateTime, String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return localDateTime.format(dateTimeFormatter);
    }

    public static String formatCstTime(String date, String format) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(CST_TIME_PATTERN, Locale.US);
        Date usDate = simpleDateFormat.parse(date);
        return DateUtil.getDateFormat(usDate, format);
    }

    public static String formatInstant(Instant instant, String format) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return localDateTime.format(DateTimeFormatter.ofPattern(format));
    }

    /**
     * 解析字符串日期为Date
     *
     * @param dateStr 日期字符串
     * @param pattern 格式
     * @return Date
     */
    public static Date parse(String dateStr, String pattern) {
        LocalDateTime localDateTime = LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    /**
     * 解析字符串 20211122->String类型2021-11-22 00:00:00
     *
     * @param dateStr 日期字符串
     * @return 返回String
     */
    public static String stringToDateStart(String dateStr) {
        LocalDate localDate = LocalDate.parse(dateStr, DateTimeFormatter.BASIC_ISO_DATE);
        String strDate =
                localDate.atStartOfDay().atZone(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern(DATE_TIME));
        return strDate;
    }

    /**
     * 解析字符串 20211122->String类型2021-11-22 23:59:59
     *
     * @param dateStr 日期字符串
     * @return 返回String
     */
    public static String stringToDateEnd(String dateStr) {
        LocalDate localDate = LocalDate.parse(dateStr, DateTimeFormatter.BASIC_ISO_DATE);
        LocalDateTime localDateTime = localDate.atTime(23, 59, 59);
        String strDate = localDateTime.format(DateTimeFormatter.ofPattern(DATE_TIME));
        return strDate;
    }

    /**
     * 解析字符串日期为Date
     *
     * @param dateStr 日期字符串
     * @return Date
     */
    public static Date parseCommonDate(String dateStr) {
        LocalDate localDate = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(DATE));
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * 为Date增加分钟,减传负数
     *
     * @param date        日期
     * @param plusMinutes 要增加的分钟数
     * @return 新的日期
     */
    public static Date addMinutes(Date date, Long plusMinutes) {
        LocalDateTime dateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        LocalDateTime newDateTime = dateTime.plusMinutes(plusMinutes);
        return Date.from(newDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 增加时间,减传负数
     *
     * @param date date
     * @param hour 要增加的小时数
     * @return new date
     */
    public static Date addHour(Date date, Long hour) {
        LocalDateTime dateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        LocalDateTime localDateTime = dateTime.plusHours(hour);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 增加时间,减传负数
     *
     * @param date date
     * @param days 要增加的天数
     * @return new date
     */
    public static Date addDay(Date date, Long days) {
        LocalDateTime dateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        LocalDateTime localDateTime = dateTime.plusDays(days);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 增加时间,减传负数
     *
     * @param date  date
     * @param month 要增加的月数
     * @return new date
     */
    public static Date addMonth(Date date, Long month) {
        LocalDateTime dateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        LocalDateTime localDateTime = dateTime.plusMonths(month);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 增加时间,减传负数
     *
     * @param date date
     * @param year 要增加的月数
     * @return new date
     */
    public static Date addYear(Date date, Long year) {
        LocalDateTime dateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        LocalDateTime localDateTime = dateTime.plusYears(year);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * @return 返回当天的起始时间
     */
    public static Date getStartTime() {
        LocalDateTime now = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0);
        return localDateTime2Date(now);
    }

    /**
     * @return 返回当天的结束时间
     */
    public static Date getEndTime() {
        LocalDateTime now = LocalDateTime.now().withHour(23).withMinute(59).withSecond(59).withNano(999);
        return localDateTime2Date(now);
    }

    /**
     * 减月份
     *
     * @param monthsToSubtract 月份
     * @return Date
     */
    public static Date minusMonths(long monthsToSubtract) {
        LocalDate localDate = LocalDate.now().minusMonths(monthsToSubtract);
        return localDate2Date(localDate);
    }

    /**
     * 减年份
     *
     * @param yearsToSubtract 年份
     * @return Date
     */
    public static Date minusYears(long yearsToSubtract) {
        LocalDate localDate = LocalDate.now().minusYears(yearsToSubtract);
        return localDate2Date(localDate);
    }

    /**
     * LocalDate类型转为Date
     *
     * @param localDate LocalDate object
     * @return Date object
     */
    public static Date localDate2Date(LocalDate localDate) {
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }

    /**
     * LocalDateTime类型转为Date
     *
     * @param localDateTime LocalDateTime object
     * @return Date object
     */
    public static Date localDateTime2Date(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 查询当前年的第一天
     *
     * @param pattern 格式，默认格式yyyyMMdd
     * @return 20190101
     */
    public static String getFirstDayOfCurrentYear(String pattern) {
        LocalDateTime localDateTime = LocalDateTime.now().withMonth(1).withDayOfMonth(1);

        if (StringUtils.isEmpty(pattern)) {
            pattern = "yyyyMMdd";
        }
        return format(localDateTime2Date(localDateTime), pattern);
    }

    /**
     * 查询前一年最后一个月第一天
     *
     * @param pattern 格式，默认格式yyyyMMdd
     * @return 20190101
     */
    public static String getLastMonthFirstDayOfPreviousYear(String pattern) {
        LocalDateTime localDateTime = LocalDateTime.now().minusYears(1L).withMonth(12).withDayOfMonth(1);

        if (StringUtils.isEmpty(pattern)) {
            pattern = "yyyyMMdd";
        }
        return format(localDateTime2Date(localDateTime), pattern);
    }

    /**
     * 查询当前月的第一天
     *
     * @param pattern 格式，默认格式yyyyMMdd
     * @return 20190101
     */
    public static String getFirstDayOfCurrentMonth(String pattern) {
        LocalDateTime localDateTime = LocalDateTime.now().plusMonths(0).with(TemporalAdjusters.firstDayOfMonth());

        if (StringUtils.isEmpty(pattern)) {
            pattern = "yyyyMMdd";
        }
        return format(localDateTime2Date(localDateTime), pattern);
    }

    /**
     * 查询当前周的第一天
     *
     * @param pattern 格式，默认格式yyyyMMdd
     * @return 20190101
     */
    public static String getFirstDayOfCurrentWeek(String pattern) {
        LocalDateTime localDateTime = LocalDateTime.now().plusMonths(0).with(DayOfWeek.MONDAY);

        if (StringUtils.isEmpty(pattern)) {
            pattern = "yyyyMMdd";
        }
        return format(localDateTime2Date(localDateTime), pattern);
    }

    /**
     * 查询当前周的最后一天
     *
     * @param pattern 格式，默认格式yyyyMMdd
     * @return 20190101
     */
    public static String getLastDayOfCurrentWeek(String pattern) {
        LocalDateTime localDateTime = LocalDateTime.now().plusMonths(0).with(DayOfWeek.SUNDAY);

        if (StringUtils.isEmpty(pattern)) {
            pattern = "yyyyMMdd";
        }
        return format(localDateTime2Date(localDateTime), pattern);
    }

    /**
     * 查询前一年最后一个月第一天
     *
     * @param pattern 格式，默认格式yyyyMMdd
     * @return 20190101
     */
    public static String getLastMonthLastDayOfPreviousYear(String pattern) {
        LocalDateTime localDateTime = LocalDateTime.now().minusYears(1L).with(TemporalAdjusters.lastDayOfYear());
        if (StringUtils.isEmpty(pattern)) {
            pattern = "yyyyMMdd";
        }
        return format(localDateTime2Date(localDateTime), pattern);
    }

    /**
     * 获取当前日期
     *
     * @param pattern 格式，默认格式yyyyMMdd
     * @return 20190101
     */
    public static String getCurrentDay(String pattern) {
        LocalDateTime localDateTime = LocalDateTime.now();

        if (StringUtils.isEmpty(pattern)) {
            pattern = "yyyyMMdd";
        }
        return format(localDateTime2Date(localDateTime), pattern);
    }

    /**
     * 获取当前日期的小时
     *
     * @param pattern 格式，默认格式yyyyMMdd
     * @return 20190101
     */
    public static String getCurrentHours(String pattern) {
        LocalDateTime localDateTime = LocalDateTime.now();

        if (StringUtils.isEmpty(pattern)) {
            pattern = START_DATE_HOURS;
        }
        return format(localDateTime2Date(localDateTime), pattern);
    }

    /**
     * 获取年
     *
     * @return 年
     */
    public static int getYear() {
        LocalTime localTime = LocalTime.now();
        return localTime.get(ChronoField.YEAR);
    }

    /**
     * @return
     */
    public static int getTime() {
        LocalTime localTime = LocalTime.now();
        return localTime.get(ChronoField.HOUR_OF_DAY);
    }

    /**
     * 获取月份
     *
     * @return 月份
     */
    public static int getMonth() {
        LocalTime localTime = LocalTime.now();
        return localTime.get(ChronoField.MONTH_OF_YEAR);
    }

    /**
     * 获取某月的第几天
     *
     * @return 几号
     */
    public static int getMonthOfDay() {
        LocalTime localTime = LocalTime.now();
        return localTime.get(ChronoField.DAY_OF_MONTH);
    }

    private static String getDateFormat(Date date, String dateFormatType) {
        SimpleDateFormat simformat = new SimpleDateFormat(dateFormatType);
        return simformat.format(date);
    }

    /**
     * @param time 时间
     * @param num  加的数，-num就是减去
     * @return 减去相应的数量的天的日期
     */
    public static Date dayAddNum(Date time, Integer num) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        calendar.add(Calendar.DAY_OF_MONTH, num);
        return calendar.getTime();
    }

    /**
     * @param time 时间
     * @param num  加的数，-num就是减去
     * @return 减去相应的数量的天的日期
     */
    public static Date monthAddNum(Date time, Integer num) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        calendar.add(Calendar.MONTH, num);
        return calendar.getTime();
    }

    /**
     * 获取时间间隔(小时)
     *
     * @param dateNow
     * @param dateOld
     * @return
     */
    public static int getDateIntervalHour(Date dateNow, Date dateOld) {
        Instant now = dateNow.toInstant();
        Instant old = dateOld.toInstant();
        return Integer.parseInt(Duration.between(now, old).toHours() + "");
    }

    /**
     * 获取时间间隔(秒)
     *
     * @param dateNow
     * @param dateOld
     * @return
     */
    public static int getDateIntervalSecond(Date dateNow, Date dateOld) {
        if (dateNow == null || dateOld == null) {
            return 0;
        }
        Instant now = dateNow.toInstant();
        Instant old = dateOld.toInstant();
        return Integer.parseInt(Duration.between(now, old).toMillis() / 1000 + "");
    }

    /**
     * 获取时间间隔(天)
     *
     * @param dateNow
     * @param dateOld
     * @return
     */
    public static int getDateIntervalDay(Date dateNow, Date dateOld) {
        Instant now = dateNow.toInstant();
        Instant old = dateOld.toInstant();
        return Integer.parseInt(Duration.between(now, old).toDays() + "");
    }

    /**
     * 获取时间间隔(分钟)
     *
     * @param dateNow
     * @param dateOld
     * @return
     */
    public static int getDateIntervalMinute(Date dateNow, Date dateOld) {
        Instant now = dateNow.toInstant();
        Instant old = dateOld.toInstant();
        return Integer.parseInt(Duration.between(now, old).toMinutes() + "");
    }

    /**
     * 获取时间间隔(月)
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static int getDateIntervalMonth(String startTime, String endTime) {
        LocalDate startDate = LocalDate.parse(startTime, yyyyMMdd_EN);
        LocalDate endDate = LocalDate.parse(endTime, yyyyMMdd_EN);
        return Integer.parseInt(Period.between(startDate, endDate).getMonths() + "");
    }

    /**
     * 检测：输入年份是否是闰年？
     *
     * @param date 日期格式：yyyy-MM-dd
     * @return true：闰年，false：平年
     */
    public static boolean isLeapYear(String date) {
        return LocalDate.parse(date.trim()).isLeapYear();
    }

    /**
     * 切割日期。按照周期切割成小段日期段。例如： <br>
     *
     * @param startDate 开始日期（yyyy-MM-dd）
     * @param endDate   结束日期（yyyy-MM-dd）
     * @param period    周期（天，周，月，年）
     * @return 切割之后的日期集合
     * @example <li>startDate="2019-02-28",endDate="2019-03-05",period="day"
     * </li>
     * <li>结果为：[2019-02-28, 2019-03-01, 2019-03-02, 2019-03-03,
     * 2019-03-04, 2019-03-05]</li><br>
     * <li>startDate="2019-02-28",endDate="2019-03-25",period="week"
     * </li>
     * <li>结果为：[2019-02-28,2019-03-06, 2019-03-07,2019-03-13,
     * 2019-03-14,2019-03-20, 2019-03-21,2019-03-25]</li><br>
     * <li>startDate="2019-02-28",endDate="2019-05-25",period="month"
     * </li>
     * <li>结果为：[2019-02-28,2019-02-28, 2019-03-01,2019-03-31,
     * 2019-04-01,2019-04-30, 2019-05-01,2019-05-25]</li><br>
     * <li>startDate="2019-02-28",endDate="2020-05-25",period="year"
     * </li>
     * <li>结果为：[2019-02-28,2019-12-31, 2020-01-01,2020-05-25]</li><br>
     */
    public static List<String> getPieDateRange(String startDate, String endDate, String period) {
        List<String> result = new ArrayList();
        LocalDate end = LocalDate.parse(endDate, yyyyMMdd_EN);
        LocalDate start = LocalDate.parse(startDate, yyyyMMdd_EN);
        LocalDate tmp = start;
        switch (period) {
            case DAY:
                while (start.isBefore(end) || start.isEqual(end)) {
                    result.add(start.toString());
                    start = start.plusDays(1);
                }
                break;
            case WEEK:
                while (tmp.isBefore(end) || tmp.isEqual(end)) {
                    if (tmp.plusDays(6).isAfter(end)) {
                        result.add(tmp.toString() + "," + end);
                    } else {
                        result.add(tmp.toString() + "," + tmp.plusDays(6));
                    }
                    tmp = tmp.plusDays(7);
                }
                break;
            case MONTH:
                while (tmp.isBefore(end) || tmp.isEqual(end)) {
                    LocalDate lastDayOfMonth = tmp.with(TemporalAdjusters.lastDayOfMonth());
                    if (lastDayOfMonth.isAfter(end)) {
                        result.add(tmp.toString() + "," + end);
                    } else {
                        result.add(tmp.toString() + "," + lastDayOfMonth);
                    }
                    tmp = lastDayOfMonth.plusDays(1);
                }
                break;
            case YEAR:
                while (tmp.isBefore(end) || tmp.isEqual(end)) {
                    LocalDate lastDayOfYear = tmp.with(TemporalAdjusters.lastDayOfYear());
                    if (lastDayOfYear.isAfter(end)) {
                        result.add(tmp.toString() + "," + end);
                    } else {
                        result.add(tmp.toString() + "," + lastDayOfYear);
                    }
                    tmp = lastDayOfYear.plusDays(1);
                }
                break;
            default:
                break;
        }
        return result;
    }

    /**
     * 获取当天开始->结束时间，传入天数的前/后N天小时集合，含当天，负数为前N天
     *
     * @param days
     * @return
     */
    public static List<String> getCurrentDayHourDateRange(Integer days) {
        List<String> list = new ArrayList<>();
        if (days > 0) {
            for (int i = 0; i < days * 24; i++) {
                String tmp = getDateFormat(addHour(getStartTime(), (long) i), DATE_TIME);
                list.add(tmp);
            }
        } else {
            // System.out.println( days * 24);
            Long i = (long) (days * 24);
            while (i < 24) {
                // System.out.println( days * 24);
                // System.out.println( i * 24);
                String tmp = getDateFormat(addHour(getStartTime(), i), DATE_TIME);
                list.add(tmp);
                i++;
            }
        }
        return list;
    }

    /**
     * 获取当天开始->结束时间，传入天小时前小时集合，含当天，负数为前N小时
     *
     * @param hours
     * @return
     */
    public static List<String> getCurrentHourRange(Integer hours) {
        List<String> list = new ArrayList<>();
        if (hours >= 0) {
            for (int i = 0; i <= hours; i++) {
                String tmp = getDateFormat(addHour(new Date(), (long) i), START_DATE_HOURS);
                list.add(tmp);
            }
        } else {
            for (int i = hours; i <= 0; i++) {
                String tmp = getDateFormat(addHour(new Date(), (long) i), START_DATE_HOURS);
                list.add(tmp);
            }
        }
        return list;
    }

    /**
     * 获取开始时间(小)到结束时间（大）内的小时集合
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static List<String> getCurrentHourRange(Date startTime, Date endTime) {
        List<String> list = new ArrayList<>();
        list.add(getDateFormat(startTime, START_DATE_HOURS));
        int i = 1;
        while (true) {
            Date date = addHour(startTime, (long) i);
            if (date.getTime() > endTime.getTime()) {
                // list.add(getDateFormat(date, START_DATE_HOURS));
                break;
            }
            i++;
            list.add(getDateFormat(date, START_DATE_HOURS));
        }
        return list;
    }

    /**
     * 获取开始时间（小）到结束时间（大）内的天集合
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static List<String> getCurrentDayRange(Date startTime, Date endTime) {
        List<String> list = new ArrayList<>();
        list.add(getDateFormat(startTime, DATE_TIME_START));
        int i = 1;
        while (true) {
            Date date = addDay(startTime, (long) i);
            Date dayStartTime = formatYMD(date);
            if (dayStartTime.getTime() > endTime.getTime()) {
                // list.add(getDateFormat(date, DATE_TIME_START));
                break;
            }
            i++;
            list.add(getDateFormat(date, DATE_TIME_START));
        }
        return list;
    }

    public static Date stringToDate(String strDate, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        ParsePosition pos = new ParsePosition(0);
        return simpleDateFormat.parse(strDate, pos);
    }

    public static Date formatYMD(Date date) {
        String dateStr = format(date, DATE_TIME_START);
        return parse(dateStr, DATE_TIME);
    }

    /**
     * @param time
     * @Description: 持续时间(秒)转换, 如果超过24小时，则转换为“1天xx小时”；如果未超过24小时，转换为“xx小时xx分钟”；如果不足1小时，转换为“xx分钟”
     * @Author: weng.yifeng
     * @Date: 2021/11/23 15:11
     **/
    public static String secondsFormat(Long time) {
        if (time == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        long minute = 60;
        long hour = minute * 60;
        long day = hour * 24;
        if (time < minute) {
            //小于一分钟
            stringBuilder.append(time).append("秒");
            return stringBuilder.toString();
        } else if (time < hour) {
            //不足一小时
            stringBuilder.append(time / minute).append("分钟").append(time % minute).append("秒");
            return stringBuilder.toString();
        } else if (time >= hour && time < day) {
            //大于一小时不超过一天
            stringBuilder.append(time / hour).append("小时").append((time % hour) / minute).append("分钟");
            return stringBuilder.toString();
        } else {
            //超过24小时
            stringBuilder.append(time / day).append("天").append((time % day) / hour).append("小时");
            return stringBuilder.toString();
        }
    }

    public static int getYear(Date date) {
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return localDateTime.getYear();
    }

    public static int getMonth(Date date) {
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return localDateTime.getMonth().getValue();
    }

    /**
     * 获取当前几号
     *
     * @return 当前几号
     */
    public static Integer getDay(Date date) {
        if(null == date) {
            return null;
        }
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate.getDayOfMonth();    //获取日
    }

    /**
     * 获取小时
     *
     * @return 小时
     */
    public static Integer getHour(Date date) {
        if(null == date) {
            return null;
        }
        LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        return localDateTime.get(ChronoField.HOUR_OF_DAY);    //获取当前小时
    }

    public static int getDayOfMonth(Date date) {
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return localDateTime.getDayOfMonth();
    }

    public Date getMaxDate(Date... dates) {
        return Arrays.stream(dates).filter(Objects::nonNull).max(Date::compareTo).orElse(null);
    }

    public static void main(String[] args) {
        System.out.println(getCurrentMonthByYear(2020));
    }

    /**
     * 为Date增加秒,减传负数
     *
     * @param date       日期
     * @param plusSecond 要增加的秒
     * @return 新的日期
     */
    public static Date addSecond(Date date, Long plusSecond) {
        LocalDateTime dateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        LocalDateTime newDateTime = dateTime.plusSeconds(plusSecond);
        return Date.from(newDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static int getDateIntervalMonth(Date dateNow, Date dateOld) {
        if (dateOld.compareTo(dateNow) > 0) {
            return 0;
        }
        int count = 1;
        Date temp = dateOld;
        while (DateUtil.addMonth(temp, 1L).compareTo(dateNow) < 0) {
            count++;
            temp = DateUtil.addMonth(temp, 1L);
        }
        return count;
    }

    /**
     * 获取季度集合
     *
     * @return
     */
    public static List<Pair<String, String>> getSeasonList(String startTime, String endTime) {
        if (DateUtil.parse(endTime, DateUtil.DATE_TIME).compareTo(new Date()) > 0) {
            endTime = DateUtil.format(new Date(), DateUtil.DATE_TIME);
        }
        List<Pair<String, String>> list = new ArrayList<>(4);
        while (DateUtil.parse(startTime, DateUtil.DATE_TIME).compareTo(DateUtil.parse(endTime, DateUtil.DATE_TIME)) < 0) {
            Date nextSeaSon = DateUtil.addMonth(DateUtil.parse(startTime, DateUtil.DATE_TIME), 3L);
            list.add(Pair.of(startTime, DateUtil.format(DateUtil.addSecond(nextSeaSon, -1L), DateUtil.DATE_TIME)));
            startTime = DateUtil.format(nextSeaSon, DateUtil.DATE_TIME);
        }
        return list;
    }

    /**
     * date转换为LocalDate
     *
     * @param date
     * @return
     */
    public static LocalDate date2LocalDate(Date date) {
        if (null == date) {
            return null;
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * 获取年度集合
     *
     * @return
     */
    public static List<Pair<String, String>> getYearList(String startTime, String endTime) {
        if (DateUtil.parse(endTime, DateUtil.DATE_TIME).compareTo(new Date()) > 0) {
            endTime = DateUtil.format(new Date(), DateUtil.DATE_TIME);
        }
        List<Pair<String, String>> list = new ArrayList<>(3);
        while (DateUtil.parse(startTime, DateUtil.DATE_TIME).compareTo(DateUtil.parse(endTime, DateUtil.DATE_TIME)) < 0) {
            Date nextSeaSon = DateUtil.addMonth(DateUtil.parse(startTime, DateUtil.DATE_TIME), 12L);
            list.add(Pair.of(startTime, DateUtil.format(DateUtil.addSecond(nextSeaSon, -1L), DateUtil.DATE_TIME)));
            startTime = DateUtil.format(nextSeaSon, DateUtil.DATE_TIME);
        }
        return list;
    }

    /**
     * 根据年份获取当前月的起止时间
     *
     * @param year
     * @return
     */
    public static Pair<String, String> getCurrentMonthByYear(int year) {
        LocalDate now = LocalDate.now();

        // 如果是历史的年份的话  直接12月的最后一天
        int dayOfMonth = now.getYear() > year ? 31 : now.getDayOfMonth();
        // 如果是历史的年份的话  直接取12月
        int monthValue = now.getYear() > year ? 12 : now.getMonthValue();
        LocalDateTime localDateTime =
                LocalDateTime.now().withYear(year)
                        .withMonth(monthValue)
                        .withDayOfMonth(dayOfMonth)
                        .withHour(23)
                        .withMinute(59)
                        .withSecond(59).withNano(999);

        Date endDate = localDateTime2Date(localDateTime);

        LocalDateTime startDateTime =
                LocalDateTime.now().withYear(year)
                        .withMonth(1)
                        .withDayOfMonth(1)
                        .withHour(0)
                        .withMinute(0)
                        .withSecond(0).withNano(0);

        Date startDate = localDateTime2Date(startDateTime);
        Pair<String, String> pair = Pair.of(DateUtil.format(startDate, DateUtil.DATE_TIME), DateUtil.format(endDate,
                DateUtil.DATE_TIME));
        return pair;
    }

    /**
     * 获取指定年份月份的最后一天
     * @param year Integer
     * @param month Integer
     * @return
     */
    public static String getLastDayOfMonth(Integer year, Integer month) {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, month - 1);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String lastDayOfMonth = sdf.format(cal.getTime());
        return lastDayOfMonth;
    }

    /**
     * 获取指定年份月份的最后一天
     * @param year Integer
     * @param month Integer
     * @return
     */
    public static String getFirstDayOfMonth(Integer year, Integer month) {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, month - 1);
        //设置日历中月份的第一天
        cal.set(Calendar.DAY_OF_MONTH, 1);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String firstDayOfMonth = sdf.format(cal.getTime());
        return firstDayOfMonth;
    }

    /**
     * @Description: 判断当前时间是否在12点之前，是12点之前返回true，反之false
     * @param date 当前时间
     * @Author: weng.yifeng
     * @Date: 2022/6/21 10:44
     **/
    public static boolean checkDateTwelve(Date date) {
        String internetTime = DateUtil.format(date, DateUtil.DATE) + " " + "12:00:00";
        if (date.before(DateUtil.parse(internetTime, DateUtil.DATE_TIME))){
            return true;
        }else {
            return false;
        }
    }
}
