package com.yuan.test;

/**
 * 斐波那契数列
 */
public class Fibonacci {

    public static int fibonacci(int n){
        // 斐波那契数列前两项为1
        if (n == 1){
            return 1;  // f(1)=1
        }else if (n == 2){ //如果没有这个递归出口，将出现f(2) = f(1)+f(0),而f(0)并不是出口
            return 1;  // f(2)=1
        }else{
            return fibonacci(n-1)+fibonacci(n-2);
        }
    }

    public static void main(String[] args){
        for (int i=1;i<20;i++){
            System.out.println(fibonacci(i));
        }
    }
}
