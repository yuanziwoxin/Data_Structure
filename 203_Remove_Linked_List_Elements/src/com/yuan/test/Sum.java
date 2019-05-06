package com.yuan.test;

public class Sum  {
    public static int sum(int[] arrs){
        return sum(arrs,0);
    }

    private  static int sum(int[] arrs,int begin){
        // 求解基本问题
        if (begin == arrs.length) // 跳出递归循环的条件
            return 0;
        // 把原问题转化为更小的问题
        return arrs[begin]+sum(arrs,begin+1);
    }
}
