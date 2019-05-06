package com.yuan.stack;

/**
 * 通过动态数组实现栈的基本操作
 */
public class ArrayStack<E> implements Stack<E>{

    private Array<E> array;

    public ArrayStack(){
        array = new Array<>();
    }

    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }
    // 获取当前栈中的元素个数
    @Override
    public int getSize() {
        return array.getSize();
    }
    // 获取栈的容量
    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("stack: ");
        str.append("[");
        for (int i=0;i<array.getSize();i++){
            str.append(array.get(i));
            if (i != array.getSize()-1){
                str.append(',');
            }
        }
        str.append("] top");
        return str.toString();
    }
}
