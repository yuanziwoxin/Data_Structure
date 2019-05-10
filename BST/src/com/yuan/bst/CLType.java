package com.yuan.bst;

import java.util.ArrayList;
import java.util.Scanner;

public class CLType<E> {
    class Node{
        E key;
        Node next;

        public Node(E key,Node next){
            this.key = key;
            this.next  = next;
        }

        public Node(E key){
            this(key,null);
        }

        public Node(){
            this(null,null);
        }
        @Override
        public String toString(){
            return key.toString();
        }
    }

    Node head;
    public CLType(ArrayList<E> arrs){
        if (arrs.isEmpty() && arrs == null){
            throw new IllegalArgumentException("ArrayList is Empty!");
        }
        head = new Node(arrs.get(0));
        Node pre = head;
        for (int i=1;i<arrs.size();i++){
            pre.next =new Node(arrs.get(i));
            pre = pre.next;
        }
    }
    CLType CLFindNode(CLType clType,String key){
        CLType htemp;
        htemp = clType;
        while (htemp.head!= null){
            if (htemp.head.key.equals(key)){
                return htemp;
            }
            htemp.head = htemp.head.next;
        }
        return  null;
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        Node cur = head;
        while (cur != null){
            res.append(cur.key+"-->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }

    public static void main(String[] args){
        ArrayList<String> arrayList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        System.out.println("Please input Single Chain: ");
        String key;
        do {
            key = in.next();// 174997636
            arrayList.add(key);
        }while (!in.hasNext("end"));
//        while(in.hasNext()){
//            key = in.next();
//            if (key.equals("\n")) //如何匹配到换行符时，结束输入操作？
//                break;
//            arrayList.add(key);
//        }

        CLType<String> clType = new CLType<>(arrayList);
        System.out.println(clType);
        CLType res=clType.CLFindNode(clType,"20");
        System.out.println(res);
    }
}
