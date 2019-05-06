package com.yuan.bst;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BST<Integer> bst = new BST<>();
        int[] nums = {7,6,9,4,3,2,5,8,10};
        for (int num:nums){
            bst.add(num);
        }
        System.out.println("preOrderNR: ");
        bst.preOrderNR();//前序遍历的非递归实现


        System.out.println("preOrder: ");
        bst.preOrder();
        System.out.println();
        System.out.println(bst);

        System.out.println("inOrder: ");
        bst.inOrder();
        System.out.println();
        System.out.println(bst);

        System.out.println("postOrder: ");
        bst.postOrder();
        System.out.println();
        System.out.println(bst);

        System.out.println("levelOrder: ");
        bst.levelOrder();
    }
}
