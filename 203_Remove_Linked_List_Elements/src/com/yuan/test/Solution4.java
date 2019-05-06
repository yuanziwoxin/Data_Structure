package com.yuan.test;

/**
 * 通过编写输入输出的方法测试递归过程
 * 加入了depth，递归层数（递归高度）
 */
public class Solution4 {
    public  ListNode removeElements(ListNode head, int val,int depth) {
        String depthString = generateString(depth);
        System.out.print(depth+": ");
        System.out.print(depthString);
        System.out.println("Call remove:"+val+" in "+head);
        if (head == null){
            System.out.print(depth+": ");
            System.out.print(depthString);
            System.out.println("Return: "+head);
            return null;
        }
        // 方法一：
        /*
        先判断第一个元素节点之后的子链表是否有等于val值的节点，有则删除，然后把新的子链表返回；
         */
        ListNode res = removeElements(head.next,val,depth+1);
        System.out.print(depth+": ");
        System.out.print(depthString);
        System.out.println("After remove: "+val+" in "+res);

        ListNode ret;
        // 如果第一个元素节点的值等于val，则返回第一个元素之后的子链表即可；
        if (head.val == val){
            ret = res;
        }else{ // 否则将第一个元素与经过筛选的子链表连接组成新的链表，并返回；
            head.next = res;
            ret = head;
        }

        System.out.print(depth+": ");
        System.out.print(depthString);
        System.out.println("Return: "+ret);

        return ret;
        //方法二：由方法一改变而来，实质还是方法一
        // 返回经过删除函数处理过的子链表
//        head.next = removeElements(head.next,val);
//        /*
//         第一个元素值等于被删除值，则返回子链表（这样就把第一个元素删除了），
//         否则返回包含第一个元素和经过删除函数处理过的子链表。
//         注意：head其实就表示第一个元素加删除函数处理过的子链表。
//          */
//        return head.val == val ? head.next:head;
    }

    public String generateString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i=0;i<depth;i++){
            res.append(" -- ");
        }
        return res.toString();
    }

    public static void main(String[] args){
        int[] arrs = {1,1,0,5,1};
        ListNode listNode = new ListNode(arrs);
        System.out.println(listNode);
        ListNode res = (new Solution4()).removeElements(listNode,1,0);
        System.out.println(res);
    }
}
