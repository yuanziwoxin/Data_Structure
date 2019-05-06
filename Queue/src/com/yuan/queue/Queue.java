package com.yuan.queue;

public interface Queue<E> {

    public void enqueue(E e);
    public E dequeue();

    /**
     * 获取队首元素
     * @return
     */
    public E getFront();

    /**
     * 获取当前队列中的元素个数
     * @return
     */
    public int getSize();
    public boolean isEmpty();
}
