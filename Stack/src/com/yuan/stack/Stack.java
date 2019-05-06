package com.yuan.stack;

public interface Stack<E>{

    public void push(E e);
    public E pop();

    /**
     * 获取栈顶元素
     * @return
     */
    public E peek();
    public boolean isEmpty();

    /**
     * 获取当前栈中的元素个数
     * @return
     */
    public int getSize();
}
