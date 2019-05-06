package com.yuan.test;

/**
 * 方法二：带头节点的解决方法（注：头节点的下一个元素才是第一个元素）
 */
public class Solution2 {
    public  ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);//头节点，头节点的元素值可随便取
        dummyHead.next = head; //头节点之后才是第一个元素
        // 有了头节点
        ListNode pre = dummyHead;
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
        return dummyHead.next; //注意返回的是头节点之后的链表
    }
}
