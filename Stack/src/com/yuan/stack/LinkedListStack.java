package com.yuan.stack;

/**
 * 通过链表来实现栈
 * 因为对链表的头部操作起来比较方便，所以把链表的头部当作栈顶，出栈和入栈、
 * 获取栈顶元素等操作都比较方便。
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> linkedList; // 定义一个LinkedList类型的对象
    // 利用构造函数初始化linkedList（因为链表没有容积的概念，所以不用含参构造函数进行初始化）
    public LinkedListStack(){
        linkedList = new LinkedList<>();
    }

    @Override
    public void push(E e) {
        // 从链表头部进行节点的插入操作是非常方便的，时间复杂度为O(1);
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        // 从链表头部进行节点的删除操作是非常方便的，时间复杂度为O(1);
        return linkedList.deleteFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("stack: top [");
        str.append(linkedList);
        str.append("]");
        return str.toString();
    }

    public static void main(String[] args) {
        // write your code here
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        for (int i=0;i<5;i++){
            stack.push(i);
            System.out.println(stack);
        }
        stack.push(20);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }
}
