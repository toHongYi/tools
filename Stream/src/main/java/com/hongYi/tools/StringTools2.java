package com.hongYi.tools;

import java.math.BigDecimal;

/**
 * @version : V1.0
 * @date : 2022/6/10 11:15
 * @Author : LLH
 * @Desc :
 */
public class StringTools2 {
    public static void main(String[] args) {
        Double index = null;
        String winnerIndex = "0.0094";
        Double integer = Double.valueOf(winnerIndex);
        integer = integer*100;
        index = integer;
        winnerIndex = String.valueOf(index);
        System.out.println("integer = " + integer);

        Float index1 = null;
        String winnerIndex1 = "0.0096";
        Float integer1 = Float.valueOf(winnerIndex1);
        integer1 = integer1*100;
        index1 = integer1;
        winnerIndex = String.valueOf(index);
        System.out.println("integer = " + integer1);

/*******************************************************************/

        BigDecimal bigDecimal = new BigDecimal(integer1);
        BigDecimal bigDecima2 = new BigDecimal(winnerIndex1);
        BigDecimal big100 = new BigDecimal("100");
        bigDecima2.multiply(big100);
        System.out.println("bigDecima2 = " + bigDecima2);

    }
    public void setWinnerIndex(String winnerIndex) {





    }
}
