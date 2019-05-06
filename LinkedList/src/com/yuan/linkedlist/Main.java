package com.yuan.linkedlist;

public class Main {

    public static void main(String[] args) {
	// write your code here
        LinkedList<Integer> list = new LinkedList<>();
        for (int i=0;i<5;i++){
            list.add(i,i);
            System.out.println(list);
        }
        list.add(2,618);
        System.out.println(list);
        list.set(3,508);
        System.out.println(list);
        System.out.println(list.get(3));
        System.out.println("链表中是否存在该元素节点："+list.isContains(2));
        System.out.println("链表中是否存在该元素节点："+list.isContains(508));
        System.out.println(list.isEmpty()+" size is:"+list.getSize());

        list.delete(2);
        System.out.println(list);

        list.deleteLast();
        System.out.println(list);

        list.deleteFirst();
        System.out.println(list);
    }
}
