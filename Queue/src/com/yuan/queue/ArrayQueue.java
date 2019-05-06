package com.yuan.queue;

public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    // 通过无参构造函数进行初始化
    public ArrayQueue(){
        array = new Array<>();
    }
    // 通过有参构造函数进行初始化
    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    // 获取队首元素
    @Override
    public E getFront() {
        return array.getFirst();
    }

    // 获取当前队列中的元素个数
    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("queue: ");
        str.append("front [");
        for (int i=0;i<array.getSize();i++){
            str.append(array.get(i));
            if (i != array.getSize()-1){
                str.append(',');
            }
        }
        str.append("] tail");
        return str.toString();
    }

    public static void main(String[] args){
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();

        for (int i=0;i<10;i++){
            arrayQueue.enqueue(i);
            System.out.println("capacity: "+arrayQueue.getCapacity());
            System.out.println("en: "+arrayQueue);
            // 每入栈3个元素，就出栈1个元素(除了第0个元素)
            if (i%3==2){
                arrayQueue.dequeue();
                System.out.println("de: "+arrayQueue);
            }
        }
    }
}
