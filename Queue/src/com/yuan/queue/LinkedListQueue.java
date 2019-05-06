package com.yuan.queue;

/**
 * 通过链表实现队列（这是方法二，更加简洁精炼）
 * 定义了一个头指针和一个尾指针，头指针指向队首，尾指针指向队尾
 * @param <E>
 */
public class LinkedListQueue<E> implements Queue<E> {
    // 定义一个私有的内部类
    private class Node{
        public E e; // 节点的元素值
        public Node next; // 指向下一个元素的指针

        public Node(E e,Node next){
            this.e = e;
            this.next =next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }
    }

    private Node head; //头指针（指向第一个元素）
    private Node tail; //尾指针（指向最后一个元素）
    private int size;  //链表（队列）的大小

    // 通过构造函数进行初始化
    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null){ //如果链表（队列）为空，则入队时直接将尾指针指向新元素节点
            tail = new Node(e);
            head = tail;
        }else{ // 如果链表（队列）不为空,则直接在尾指针后面添加新元素，尾指针指向该元素即可。
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++; //一定要记得将元素个数加1
    }

    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new IllegalArgumentException("Can not dequeue from empty queue!");
        }
        // 出队操作
        Node retNode = head;
        head = head.next;
        retNode.next = null; // 将该节点与链表（队列）脱离关系

        if (head == null){ //如果出队之后，队列为空，则将尾指针也指向null
            tail = head;
        }

        size--;  // 别忘了将队列元素的个数减1

        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()){
            throw new IllegalArgumentException("Queue is Empty!");
        }
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("quque front: ");
        res.append("[");
        Node cur = head;
        while (cur != null){
            res.append(cur.e+" ——> ");
            cur = cur.next;
        }
        res.append("NULL");
        res.append(" ] tail");

        return res.toString();
    }

    public static void main(String[] args){
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        for (int i = 0; i<11; i++){
            linkedListQueue.enqueue(i);
            System.out.println(linkedListQueue);
            if (i%3==2){
                linkedListQueue.dequeue();
                System.out.println(linkedListQueue);
            }
        }
    }
}
