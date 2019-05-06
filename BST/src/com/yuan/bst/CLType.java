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
    }

    Node head;
    public CLType(){
        head = null;
    }
    public CLType(ArrayList<E> arrs){
        head = new Node(arrs.get(0));
        Node temp = new Node();
        for (int i=1;i<arrs.size();i++){
            head.next =new Node(arrs.get(i));
            head = head.next;
        }
    }
    CLType CLFindNode(CLType head,String key){
        CLType htemp;
        htemp = head;
        while (htemp.head!= null){
            if (htemp.head.key == key){
                return htemp;
            }
            htemp.head = htemp.head.next;
        }
        return  null;
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        while (head.next != null){
            res.append(head.key+"-->");
        }
        return res.toString();
    }

    public static void main(String[] args){
        ArrayList<String> arrayList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        System.out.println("Please input Single Chain: ");
        String  key = in.next();
        arrayList.add(key);
        CLType<String> clType = new CLType<>(arrayList);
        System.out.println(clType);
        CLType res=(new CLType()).CLFindNode(clType,"20");
        System.out.println(res);
    }
}
