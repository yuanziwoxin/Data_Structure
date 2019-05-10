package com.yuan.bst;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    /**
     * 测试删除最小元素节点的方法（removeMin）
     */
    public static void testRemoveMin(){
        BST<Integer> bst1 = new BST<>();
        Random random = new Random(); //定义一个随机数对象
        int n = 1000;  //生成随机数的个数
        for (int i = 0;i < n;i++){
            bst1.add(random.nextInt(10000)); //将生成的大小在0到10000以内的随机数存储到二分搜索树中
        }

        ArrayList<Integer> minList = new ArrayList<>();
        while (!bst1.isEmpty()){ // 当二分搜索树不为空
            // 将从二分搜索树中删除的最小元素依次存储到动态数组minList中
            minList.add(bst1.removeMin());
        }
        System.out.println(minList);

        for (int i=1;i<minList.size();i++){
            //如果存储到minList中的元素不是按从小到大的顺序排列的，则说明removeMin方法有误
            if (minList.get(i-1) > minList.get(i)){
                throw new IllegalArgumentException("removeMin is Error!!!");
            }
        }
        System.out.println("removeMin is true!");
    }

    /**
     * 测试删除最大元素节点的方法（removeMax）
     */
    public static void testRemoveMax(){
        BST<Integer> bst1 = new BST<>();
        Random random = new Random(); //定义一个随机数对象
        int n = 1000;  //生成随机数的个数
        for (int i = 0;i < n;i++){
            bst1.add(random.nextInt(10000)); //将生成的大小在0到10000以内的随机数存储到二分搜索树中
        }

        ArrayList<Integer> maxList = new ArrayList<>();
        while (!bst1.isEmpty()){ // 当二分搜索树不为空
            // 将从二分搜索树中删除的最大元素依次存储到动态数组maxList中
            maxList.add(bst1.removeMax());
        }
        System.out.println(maxList);

        for (int i=1;i<maxList.size();i++){
            //如果存储到maxList中的元素不是按从大到小的顺序排列的，则说明removeMax方法有误
            if (maxList.get(i-1) < maxList.get(i)){
                throw new IllegalArgumentException("removeMax is Error!!!");
            }
        }
        System.out.println("removeMax is true!");
    }

    public static void main(String[] args) {
	// write your code here
        BST<Integer> bst = new BST<>();
        int[] nums = {7,6,9,4,3,2,5,8,10};
        for (int num:nums){
            bst.add(num);
        }

        System.out.println(bst);
        System.out.println();

        System.out.println("preOrderNR: ");
        bst.preOrderNR();//前序遍历的非递归实现


        System.out.println("preOrder: ");
        bst.preOrder();
        System.out.println();


        System.out.println("inOrder: ");
        bst.inOrder();
        System.out.println();


        System.out.println("postOrder: ");
        bst.postOrder();
        System.out.println();

        System.out.println("levelOrder: ");
        bst.levelOrder();

        // 测试删除最小元素节点的方法（removeMin）
        testRemoveMin();

        // 测试删除最大元素节点的方法（removeMax）
        testRemoveMax();
    }
}
