package com.hongYi.myhashSet;

/**
 * @version : V1.0
 * @date : 2022/7/19 11:21
 * @Author : LLH
 * @Desc :
 */
public class MyHashSetNode {
    //由于使用的是链表、这个值可以取得很小;
    Node[] nodes = new Node[10009];

    public void add(int key) {
        // 根据key获取哈希桶的位置
        int idx = getIndex(key);

        //判断链表中是否已经存在
        Node loc = nodes[idx];
        Node tmp = loc;

        if (loc != null) {
            Node prev = null;
            while (tmp != null) {
                if (tmp.key == key) {
                    return;
                }
                prev = tmp;
                tmp = tmp.next;
            }
            tmp = prev;
        }
        Node node = new Node(key);

        // 头插法
        // node.next = loc;
        // nodes[idx] = node;

        //尾插法;
        if (tmp!=null){
            tmp.next =node;
        }else {
            nodes[idx] = node;
        }

    }


    public void remove(int key) {
        int idx = getIndex(key);
        Node loc = nodes[idx];
        if (loc != null){
            Node prev = null;
            while (loc != null){
                if (loc.key == key){
                    if (prev != null){
                        prev.next = loc.next;
                    }else {
                        nodes[idx] = loc.next;
                    }
                }
                return;
            }
            prev = loc;
            loc = loc.next;
        }
    }

    public boolean contain(int key) {
        int idx = getIndex(key);
        Node loc = nodes[idx];
        if (loc != null){
            while (loc!=null){
                if (loc.key == key){
                    return true;
                }
                loc = loc.next;
            }
        }
        return false;
    }

    static class Node {

        private int key;
        private Node next;

        private Node(int key) {
            this.key = key;
        }
    }

    /**
     * 因为 nodes 的长度只有 10009，对应的十进制的 10011100011001（总长度为 32 位，其余高位都是 0）
     *         // 为了让 key 对应的 hash 高位也参与运算，这里对 hashCode 进行右移异或
     *         // 使得 hashCode 的高位随机性和低位随机性都能体现在低 16 位中
     *
     * 作者：AC_OIer
     * 链接：https://leetcode.cn/problems/design-hashset/solution/yi-ti-san-jie-jian-dan-shu-zu-lian-biao-nj3dg/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param key
     * @return
     */
    int getIndex(int key) {
        int hash = Integer.hashCode(key);
        hash = (hash >>> 16);
        return hash % nodes.length;
    }
}
