package com.yuan.queue;

/**
 * 链表（不带头节点，带头指针和为尾指针）
 * @param <E>
 */
public class LinkedList<E> {
    // 定义一个私有的内部类
    private class Node{
        // 这里的元素类型定义为public类型，才能供Node类之外的类访问
        public E e;
        public Node next;

        // 设置多种类型的构造函数以供用户使用
        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node head;//头指针(这里的头指针指向第一个元素)
    private Node tail;//尾指针（指向最后一个元素）
    private int size; //链表元素的个数大小

    // 初始化链表(带头指针和尾指针)
    public LinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * 获取链表元素的个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 判断链表是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 在链表索引为index插入元素e
     * @param index
     * @param e
     */
    /**
     * 在链表头部插入一个元素(没有头节点)
     * @param e
     */
    public void addFirst(E e){
        // 没有头节点
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
        head = new Node(e,head);
        tail = head;//尾指针和头指针都指向第一个元素
        size++;
    }


    public void add(int index,E e){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add Failed! The index is illegal");
        }

        if (index == 0){
            addFirst(e);
        }else{
            Node pre = head;
            for (int i=0;i<index-1;i++){
                pre = pre.next;
            }
            // 方法一：
//            Node node = new Node(e); // 先初始化该节点
//            node.next = pre.next; // 将node节点的next指针指向pre节点的next节点
//            pre.next = node; // 将pre的next指针指向node节点
            // 方法二：（一句话可以实现上面三句话）
            pre.next = new Node(e,pre.next);
            size++;
            tail = pre.next;
            for (int j=index;j<size-1;j++){
                tail = tail.next;
            }
        }

    }

    /**
     * 在链表尾部加入一个新的元素e
     * @param e
     */
    public void addLast(E e){
//        add(size,e);
        if (head == null && tail == null){
            addFirst(e);
        }else {
            tail.next = new Node(e);
            tail = tail.next;
            size++;
        }
    }

    /**
     * 获取指定位置的元素
     * @param index
     * @return
     */
    public E get(int index){
        if (index < 0 && index >= size){
            throw new IllegalArgumentException("Get Failed.The index is illegal.");
        }

        Node cur = head;
        for (int i=0;i<index;i++){
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size-1);
    }

    /**
     * 判断链表是否存在元素节点e
     * @param e
     * @return
     */
    public boolean isContains(E e){
        Node cur = head;
        while (cur!=null){
            //对象的值比较用equals,如果用“==”进行的是引用比较，所以用==比较的时候，可能造成值相同但返回仍为false
            if (cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 修改指定节点的元素值
     * @param index 位置
     * @param e 元素值
     */
    public void set(int index,E e){
        if (index < 0 && index >= size){
            throw new IllegalArgumentException("Set Failed.The index is illegal!");
        }
        Node cur = head;
        for (int i=0;i<index;i++){
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 删除第一个元素
     * @return
     */
    public E deleteFirst(){
        Node delElement = head;
        head = delElement.next;
        delElement.next = null;
        size--;
        return delElement.e;
    }

    /**
     * 删除指定位置的元素节点
     * @param index
     * @return
     */
    public E delete(int index){
        if (index<0 && index >=size){
            throw new IllegalArgumentException("delete failed! The index is illegal! ");
        }
        if (index == 0){
            return deleteFirst();
        }else{
            Node pre = head;
            // 先找到被删除元素节点和其前一个元素节点
            for (int i=0;i<index-1;i++){
                pre = pre.next;
            }
            Node delElement = pre.next; // 记录被删除的元素节点
            // 删除该元素节点
            pre.next = delElement.next;
            delElement.next = null; // 使其被删除的元素节点脱离其后面的链表
            size--;
            return delElement.e;
        }

    }


    /**
     * 删除最后一个元素
     * @return
     */
    public E deleteLast(){
        return delete(size-1);
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        Node cur = head;
        while (cur != null){
            str.append(cur+" ——> ");
            cur = cur.next;
        }
        str.append("NULL");
        return str.toString();
    }

    public static void main(String[] args){
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5 ;i++){
            linkedList.add(i,i);
            System.out.println(linkedList);
        }
        linkedList.addLast(100);
        System.out.println(linkedList);
        linkedList.addFirst(200);
        System.out.println(linkedList);
        linkedList.deleteFirst();
        System.out.println(linkedList);
        linkedList.delete(2);
        System.out.println(linkedList);
        linkedList.deleteLast();
        System.out.println(linkedList);
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
    }
}
