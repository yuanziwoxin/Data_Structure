package com.yuan.stack;

public class Main {
    public static double testStack(Stack<Integer> stack,int opCount){
        long startTime = System.nanoTime();
        // 执行操作
        for (int i=0;i<opCount;i++){
            stack.push(i);
        }

        for (int i=0;i<opCount;i++){
            stack.pop();
        }
        long endTime = System.nanoTime();

        return (endTime-startTime)/1000000000.0; //转化为秒
    }
    public static void main(String[] args) {
	    // 比较通过数组实现的栈和通过链表实现的栈进行相应操作的时间
        int opCount = 10000000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double arrayTime = testStack(arrayStack,opCount);
        System.out.println("arrayTime is: "+arrayTime+" s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double linkedListTime = testStack(linkedListStack,opCount);
        System.out.println("linkListTime is: "+ linkedListTime+" s");

        // arrayTime is: 4.7649957 s
        // linkListTime is: 7.9184627 s
        // 这个时间比较复杂，因为LinkedListStack包含更多的new操作。
        // 具体的执行时间虽有些差异，但这两种方式实现的栈的时间复杂度是相同的，
    }
}
