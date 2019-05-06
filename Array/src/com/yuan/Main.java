package com.yuan;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Array<Integer> arr=new Array<>();//可自定义数组容量，或使用默认数组容量
        for (int i=0;i<10;i++)
            arr.addLast(i);
        System.out.println("Original Array: "+arr);//按照toString方法中的格式输出

        arr.set(5,199);
        System.out.println("After set:"+arr);

        arr.addFirst(-10);
        arr.add(2,222);
        System.out.println("After addFirst and add:"+arr);

        arr.set(6,3);
        arr.set(8,3);
        arr.addFirst(3);
        System.out.println("After set and addFirst:"+arr);

        boolean contain=arr.contains(100);
        System.out.println("Is contains: "+contain);

        arr.remove(2);
        System.out.println("After remove: "+arr);

        arr.removeLast();
        System.out.println("After removeLast: "+arr);

        arr.removeElement(7);
        System.out.println("After removeElement: "+arr);

        Array indexs = arr.findAll(3);
        System.out.println("indexs(findAll): "+indexs);

//        arr.removeAllElement(3);
//        System.out.println(arr);

        ArrayList<Integer> indexsV2 = arr.findAllv2(3);
        System.out.println("indexsV2(findAllV2): "+indexsV2);

        arr.removeAllElementV2(3);
        System.out.println("After removeAllElementV2: "+arr);
    }
}
