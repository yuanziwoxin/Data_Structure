package com.yuan.queue;

/**
 * 通过链表实现队列
 * 链表头部作为队首（出队），链表尾部作为队尾（入队）
 * @param <E>
 */
public class LinkedListQueue1<E> implements Queue<E> {

    private LinkedList<E> linkedList;
    // 通过构造函数初始化linkedList
    public LinkedListQueue1(){
        linkedList = new LinkedList<>();
    }

    @Override
    public void enqueue(E e) {
        linkedList.addLast(e);
    }

    @Override
    public E dequeue() {
        return linkedList.deleteFirst();
    }

    @Override
    public E getFront() {
        return linkedList.getFirst();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("queue: front:");
        str.append(" [");
        str.append(linkedList);
        str.append("] tail");
        return str.toString();
    }

    public static void main(String[] args){
        LinkedListQueue1<Integer> linkedListQueue1 = new LinkedListQueue1<>();
        for (int i=0;i<5;i++){
            linkedListQueue1.enqueue(i);
            System.out.println(linkedListQueue1);
        }
        linkedListQueue1.dequeue();
        System.out.println(linkedListQueue1);
        linkedListQueue1.dequeue();
        System.out.println(linkedListQueue1);
        System.out.println("Front is: "+ linkedListQueue1.getFront());
        System.out.println("Size is: "+ linkedListQueue1.getSize());
    }
}
