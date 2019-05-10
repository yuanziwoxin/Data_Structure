package com.yuan.bst;

import java.util.Scanner;

public class ScannerTest {
    public static void test(){
        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据

        // next方式接收字符串
        System.out.println("next方式接收：");
        // 判断是否还有输入
        while (scan.hasNext()) {
            String str1 = scan.next();
            System.out.println("输入的数据为：" + str1);
        }
        scan.close();
    }
    public static void main(String[] args) {
// 每次输入一个数，换行一下，直到输入一个非数字的字符，则结束输入
//        Scanner scan = new Scanner(System.in);
//
//        double sum = 0;
//        int m = 0;
//        while (scan.hasNextDouble()) {
//            double x = scan.nextDouble();
//            m = m + 1;
//            sum = sum + x;
//        }
//        System.out.println(m + "个数的和为" + sum);
//        System.out.println(m + "个数的平均值是" + (sum / m));
//        scan.close();
        test();
    }

}
