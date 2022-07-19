package com.hongYi.arithmetic;

/**
 * @version : V1.0
 * @date : 2022/7/19 10:17
 * @Author : LLH
 * @Desc :
 */
public class Bin {
    public static void main(String[] args) {


    }

    public int firstBadVersion(int n) {
        int left = 1, right = n;


        while (right >= left) {
            int mid = (right - left) / 2 + left;
//            int mid2 = (right + left)/2;    //求平均值防止出现内存溢出;
            if (isBadVersion(mid)) {
                right = mid;
            }else {
                left = mid +1;
            }
        }
        return n;
    }

    public boolean isBadVersion(int a) {
        return true;
    }
}
