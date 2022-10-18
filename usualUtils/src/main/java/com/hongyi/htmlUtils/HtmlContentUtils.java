package com.hongyi.htmlUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @Author lin_lvhua
 * @Date 2022/10/18 17:24
 * @Description 将微博富文本中的链接抽取出来;
 **/
public class HtmlContentUtils {


    public static void main(String[] args) {
        String htmlContent = "<a  href=\"https://m.weibo.cn/search?containerid=231522type%3D1%26t%3D10%26q%3D%23%E6%B8%A9%E5%B7%9E%E6%B7%B1%E5%A4%9C%E8%AF%9D%E9%A2%98%23&luicode=10000011&lfid=1076031801838560\" data-hide=\"\"><span class=\"surl-text\">#温州深夜话题#</span></a>该睡觉了哦哦，温州人哄睡除了“哦哦”还有其他说法吗？ ";


        char[] chars = htmlContent.toCharArray();
        for (int i = 0; i < chars.length; i++) {



        }


        List<String> strings = Arrays.asList(htmlContent);


        System.out.println("已结束");
    }

    // 统计字符串数量
    public Integer countWordForContent(String a) {
        char[] charArrays = a.toCharArray();
        int chineseCount = 0, englishCount = 0, blankCount = 0, numberCount = 0, otherCharacterCount = 0;
        for (int i = 0; i < charArrays.length; i++) {
            if (Character.UnicodeBlock.of(charArrays[i]) == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) {
                //判断是否是中文汉字,若是中文计数器+1,
                //此时无需进行后面的判断操作,直接开启(continue)下一次循环
                chineseCount++;
                continue;
            }
            if ((charArrays[i] >= 65 && charArrays[i] <= 90) || (charArrays[i] >= 97 && charArrays[i] <= 122)) {
                //判断是否为英文字母, A-Z 65-90 a-z 97-122
                englishCount++;
                continue;
            }
            //空格的ascii码值是32
            if (charArrays[i] == 32) {
                blankCount++;
                continue;
            }
            //数字0~9对应的ASCII码范围为[48,57]
            if ((charArrays[i] >= 48 && charArrays[i] <= 57)) {
                //判断是否为数字
                numberCount++;
                continue;
            }
            //当不是中文汉字、英文字母、空格、数字时,那么就代表它是其他字符了
            otherCharacterCount++;
        }
        return chineseCount + englishCount + numberCount;
    }
}


