package com.hongYi.arithmetic;

import java.util.Arrays;
import java.util.List;

/**
 * @version : V1.0
 * @date : 2022/7/15 10:51
 * @Author : LLH
 * @Desc :
 */
public class FirstDemo {
    public static void main(String[] args) {

        int[] num1 = new int[]{-1,0,3,5,9,12};
        System.out.println("num1 = " + 33/2);
        System.out.println("num1 = " + 33%2);

        System.out.println("search(num1,4) = " + search3(num1, 9));
    }

    public static int searchTwo(int[] items,int target){
        int left = 0;
        int right = items.length-1;

        while (left<=right){
            int mid = (right-left)/2 + left;
            int n = items[mid];
            if (n==target){
                return mid;
            }else if (n>target){
                right = mid-1;
            }else {
                left = mid+1;
            }

        }

        return -1;
    }

    public static int search2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int search(int[] nums, int target) {
        int returnTarget = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==target){
                returnTarget = i;
            }
        }
        return returnTarget;
    }

    public static int search3(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(left<=right){
            int mid = (right-left)/2 + left;
            int num = nums[mid];
            if(num==target){
                return mid;
            }else if(num>target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }

}
