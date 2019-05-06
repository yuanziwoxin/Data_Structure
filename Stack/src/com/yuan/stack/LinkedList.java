package com.yuan.stack;

/**
 * 链表
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

    private Node dummyHead;//头指针(这里指向的是一个只存有next指针的头节点，或称虚拟头节点)
    private int size; //链表元素的个数大小

    // 初始化链表(带头节点)
    public LinkedList(){
        dummyHead = new Node(null,null);
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
    public void add(int index,E e){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add Failed! The index is illegal");
        }

        Node pre = dummyHead; // pre节点先从头节点开始（注意：头节点不是第一个元素节点）
        for (int i=0;i<index;i++){
            pre = pre.next;
        }
        // 方法一：
//            Node node = new Node(e); // 先初始化该节点
//            node.next = pre.next; // 将node节点的next指针指向pre节点的next节点
//            pre.next = node; // 将pre的next指针指向node节点
        // 方法二：（一句话可以实现上面三句话）
        pre.next = new Node(e,pre.next);
        size++;
    }

    /**
     * 在链表头部插入一个元素
     * @param e
     */
    public void addFirst(E e){
        add(0,e);// 加入头节点之后，在链表头部插入元素不再需要区别对待了
    }

    /**
     * 在链表尾部加入一个新的元素e
     * @param e
     */
    public void addLast(E e){
        add(size,e);
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

        Node cur = dummyHead.next;
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
        Node cur = dummyHead.next;
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
        Node cur = dummyHead.next;
        for (int i=0;i<index;i++){
            cur = cur.next;
        }
        cur.e = e;
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
        Node pre = dummyHead;
        // 先找到被删除元素节点和其前一个元素节点
        for (int i=0;i<index;i++){
            pre = pre.next;
        }
        Node delElement = pre.next; // 记录被删除的元素节点
        // 删除该元素节点
        pre.next = delElement.next;
        delElement.next = null; // 使其被删除的元素节点脱离其后面的链表
        size--;
        return delElement.e;
    }

    /**
     * 删除第一个元素
     * @return
     */
    public E deleteFirst(){
        return delete(0);
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
        Node cur = dummyHead.next;
        while (cur != null){
            str.append(cur+" ——> ");
            cur = cur.next;
        }
        str.append("NULL");
        return str.toString();
    }
}
