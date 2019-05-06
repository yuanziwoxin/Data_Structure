package com.yuan.test;


import java.util.List;

//Definition for singly-linked list.
public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
      }

    /**
     * 通过给构造函数传入一个数组，并通过遍历数组给链表赋值
     * @param arrs
     */
      public ListNode(int[] arrs){

            // 为何不可直接按照如下方式进行链表的初始化
//          ListNode cur = this;
//          for (int i=0;i<arrs.length;i++){
//              cur = new ListNode(arrs[i]);
//              cur = cur.next;
//          }
          if (arrs == null || arrs.length == 0){
              throw new IllegalArgumentException("array is empty!");
          }

          this.val = arrs[0];  // this本来就是一个节点
          ListNode cur = this;
          for (int i=1;i<arrs.length;i++){
              cur.next = new ListNode(arrs[i]);
              cur = cur.next;
          }

      }

      @Override
      public String toString(){
          StringBuilder res = new StringBuilder();
          res.append("LinkNode: ");
          ListNode cur = this;
          while (cur!=null){
              res.append(cur.val+" ——> ");
              cur = cur.next;
          }
          res.append("NULL");

          return res.toString();
      }
}
