package com.hongYi.myhashSet;

/**
 * https://leetcode.cn/problems/design-hashset/solution/yi-ti-san-jie-jian-dan-shu-zu-lian-biao-nj3dg/
 * 设置hash集合;
 * @version : V1.0
 * @date : 2022/7/19 11:12
 * @Author : LLH
 * @Desc : 简单数组
 */
public class MyHashSet02 {

    // 时间复杂度: O(1)
    // 空间复杂度: O(1)

     boolean[] nodes  = new boolean[100009];

     void add(int key){
         nodes[key] = true;
     }

     void remove(int key){
         nodes[key] = false;
     }

     boolean contain(int key){
         return nodes[key];
     }
}
