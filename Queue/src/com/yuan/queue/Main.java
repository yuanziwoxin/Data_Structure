package com.yuan.queue;

import java.util.Random;

public class Main {
    /*
     这里传入的参数为Queue<Integer>，这样可以通过java的多态性在具体执行（传入的具体参数）时
     决定是执行ArrayQueue<Integer>还是LoopQueue<Integer>中的方法
      */
    private static double execTime(Queue<Integer> q,int opCount){
        long startTime = System.nanoTime();//因为这里的时间单位是纳秒，所以用long类型去存储才合适
        // 执行操作...
        // 执行opCount次入队操作
        for (int i=0;i<opCount;i++){
            // 表示生成一个在0到最大整数之间的随机整数，然后入队
            /*
            Math.random(): 返回的是0(包含)到1(不包含)之间的随机double值
            使用Random对象获取随机数：支持的随机值类型包括：boolean, byte, int, long, float, double。
            如获取0到100的随机int整数：new Random().nextInt(100)
             */
            q.enqueue(new Random().nextInt(Integer.MAX_VALUE));
        }

        for (int i=0;i<opCount;i++){
            q.dequeue();
        }
        long endTime = System.nanoTime();

        return (endTime-startTime)/1000000000.0;//将纳秒转换为秒
    }
    public static void main(String[] args){
        int opCount = 1000000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double arrayTime = execTime(arrayQueue,opCount);
        System.out.println("ArrayQueue time is: "+arrayTime+" s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double loopTime = execTime(loopQueue,opCount);
        System.out.println("LoopQueue time is: "+loopTime+" s");

        // 通过链表实现队列（方法一）的耗时
        LinkedListQueue1<Integer> linkedListQueue1 = new LinkedListQueue1<>();
        double linkedListTime1 = execTime(linkedListQueue1,opCount);
        System.out.println("LinkedListQueue1 time is: "+ linkedListTime1+" s");

        // 通过链表实现队列（方法二）的耗时
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double linkedListTime2 = execTime(linkedListQueue,opCount);
        System.out.println("LinkedListQueue2 time is: "+ linkedListTime2+" s");
        /*
         ArrayQueue time is: 461.3400937 s
         LoopQueue time is: 0.1484922 s
         LinkedListQueue1 time is: 0.1192181 s
         LinkedListQueue2 time is: 0.2756094 s
         通过对比可以看出，循环队列（LoopQueue）的效率比数组队列（ArrayQueue）高，
         准确来说：两者的入队操作效率差不多，影响两者效率的主要因素是出队操作。
         LoopQueue每次出队的平均时间复杂度是O(1),因为循环队列出队只需要修改一下队首指针就可以；
         而ArrayQueue每次出队的平均时间复杂度是O(n),因为数组队列每次出队都需要将队首元素后面的元素前移一个位置
         */


    }
}
