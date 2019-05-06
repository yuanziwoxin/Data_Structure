package com.yuan.test;

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 方法一：没有使用头节点
 */
class Solution {
    public  ListNode removeElements(ListNode head, int val) {
        /*
         巧用while循环：当第一个元素值等于val并将其删除之后，链表新的第一个元素
         又等于val，则继续删除，直至链表为空或者链表的第一个元素值不等于val。
          */
        while(head != null && head.val == val){
//            ListNode delNode = head;
//            head = head.next;
//            delNode.next = null;
            head = head.next; //上面也可以简写为这样
        }

        if (head == null)
            return null;

        // 接下来删除链表中除第一个元素外与val值相等的元素节点
        ListNode pre = head;
        while (pre.next != null){
            if (pre.next.val == val){
//                ListNode delNode = pre.next;
//                pre.next = delNode.next;
//                delNode.next = null;
                pre.next = pre.next.next; //上面三行也可简写为这样
            }else{
                pre = pre.next;
            }
        }
        return head;
    }

    public static void main(String[] args){
        int[] arrs = {1,1,0,5,1,0,1,6,7,1,9,7,1,4};
        ListNode listNode = new ListNode(arrs);
        System.out.println(listNode);
        ListNode res = (new Solution()).removeElements(listNode,1);
        /*
         LinkNode: 1 ——> 1 ——> 0 ——> 5 ——> 0 ——> 6 ——> 7 ——> 9 ——> 7 ——> 4 ——> NULL
         为何LinkNode只删除了后面的‘1’，而链表头部的两个值为1的节点未被删除？
          */
        System.out.println(listNode);
        System.out.println(res);
    }
}