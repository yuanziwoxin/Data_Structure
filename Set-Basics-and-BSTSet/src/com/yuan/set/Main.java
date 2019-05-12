package com.yuan.set;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    // 利用集合的性质统计文件中的词汇量（同一个单词只算一个）
        System.out.println("a-tale-of-two-cities: ");
        BSTSet<String> bstSet1 = new BSTSet<>();
        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile("a-tale-of-two-cities.txt",words1)){
            System.out.println("The size of words is: "+words1.size());
            for (int i=0;i<words1.size();i++){
                bstSet1.add(words1.get(i));//将单词依次加入到集合中（不会加入重复的单词）
            }
            System.out.println("The size of different vocabulary is: "+bstSet1.getSize());
        }

        System.out.println();
        System.out.println("pride-and-prejudice: ");
        BSTSet<String> bstSet2 = new BSTSet<>();
        ArrayList<String> words2 = new ArrayList<>();
        // 如果读取文件成功
        if (FileOperation.readFile("pride-and-prejudice.txt",words2)){
            System.out.println("The size of words is: "+words2.size());
            for (int i=0;i<words2.size();i++){
                bstSet2.add(words2.get(i));//将单词依次加入到集合中（不会加入重复的单词）
            }
            System.out.println("The size of different vocabulary is: "+bstSet2.getSize());
        }


    }
}
