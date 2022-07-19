package com.hongYi.myhashSet;

/**
 * @version : V1.0
 * @date : 2022/7/19 13:43
 * @Author : LLH
 * @Desc :
 */
public class MyBitHashSet implements MyHashSetIter{

    int[] bs = new int[40000];
    @Override
    public void add(int key) {
        int bucketIdx = key /32;
        int bitIdx = key % 32;
        setVal(bucketIdx,bitIdx,true);
    }

    @Override
    public void remove(int key) {
        int bucketId = key / 32;
        int bitIdx = key % 32;
        setVal(bucketId,bitIdx,false);
    }

    @Override
    public boolean contain(int key) {
        int bucketIdx = key / 32;
        int bitIdx = key % 32;
        return getVal(bucketIdx,bitIdx);
    }

    public void setVal(int bucket, int loc, boolean val){
        if (val){
            int u = bs[bucket] | (1 <<loc);
            bs[bucket] = u;
        } else {
            int u = bs[bucket] & ~(1<<loc);
            bs[bucket] = u;
        }

    }

    public boolean getVal(int bucket,int loc){
        int u = (bs[bucket] >> loc) & 1;
        return u == 1;
    }
}
