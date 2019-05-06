package com.yuan.queue;

public class LoopQueue<E> implements Queue<E>{
    private E[] data;
    private int front,tail;//front指向队首元素，tail指向队尾元素的下一个元素
    private int size;

    public LoopQueue(int capacity){
        data =(E[]) new Object[capacity+1];//加1的原因是：循环队列会浪费一个元素的空间
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue(){
        // data = (E[]) new Object[10]; //设置循环队列默认的容量为10；
        this(10);//调用上面的有参构造函数，设置循环队列的默认大小；
    }

    public int getCapacity(){
        return data.length-1; //因为真实情况中循环队列会浪费一个元素空间
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return front == tail;//判断循环队列是否为空
    }

    @Override
    public void enqueue(E e){
        // 如果循环队列满了，则进行扩容
        /*
         判断循环队列是否已满，不能简单地使用tail+1 == front，因为有可能tail=data.length-1，
         而front=0,此时循环的队列也是满的，而这里队列循环的过程靠的就是求余的操作
          */
        if ((tail+1)%data.length==front){
            resize(getCapacity()*2);
        }
        data[tail]=e;
        tail = (tail+1)% data.length;//求模运算是队列循环的关键，若直接使用tail++，是不能实现队尾指针的循环的
        size++;
    }

    @Override
    public E dequeue(){
        // 队列为空，抛出异常
        if (isEmpty()){
            new IllegalArgumentException("Queue is Empty!");
        }
        E ret = data[front];
        data[front] = null;
        front = (front+1)%data.length; //注意：不要忘了使用求模运算，否则front指针不能循环
        size--;
        if (size==getCapacity()/4 && getCapacity()/2 != 0){
            resize(getCapacity()/2);
        }
        return ret;
    }

    @Override
    public E getFront(){
        if (isEmpty())
        {
            throw new IllegalArgumentException("Queue is empty!");
        }
        return data[front];
    }

    public void resize(int newCapacity){
        E[] newData =(E[]) new Object[newCapacity+1];
        // 把原队列的元素赋值给新的队列
        // 方法一
        for (int i=0;i<size;i++){
           //newData[i] = data[i];// 有可能前面几个元素已经出队了，所以应从队首元素开始
            newData[i] = data[(i+front)%data.length];
        }
        // 方法二
//        for (int i=front,j=0;i!=tail;i=(i+1)%data.length){
//            newData[j] = data[i];
//            j++;
//        }
        // 把改变了大小的新队列赋值给原队列，这样原队列相当于扩容（缩容）。
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(String.format("Queue size is: %d, capacity is %d \n",size,getCapacity()));
        str.append("queue: ");
        str.append("front [");
        /*
        这里不能写成i=(i++)%data.length,这样的话会出现：java heap space的内存泄漏错误,
        这样写导致先使用i,再++,而这样的话相当于i=i%data.length,即i一直等于front，而并不会增加，
        这样就成了死循环了
         */
        // 方法一
        for (int i=front;i!=tail;i=(i+1)%data.length){
            str.append(data[i]);
            if ((i+1)%data.length != tail){ // 因为有可能front大于tail，利用求模才能将队列循环起来
                str.append(',');
            }
        }
//        方法二
//        for (int i=0;i<size;i++){
//            str.append(data[(i+front)%data.length]);
//            if (i!=size-1){
//                str.append(',');
//            }
//        }

        str.append("] tail");
        return str.toString();
    }

    public static void main(String[] args){
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        for (int i = 0;i<10;i++){
            loopQueue.enqueue(i);
            System.out.println(loopQueue);
            if (i%3==2){
                loopQueue.dequeue();
                System.out.println(loopQueue);
            }
        }
    }
}
