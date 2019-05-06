package com.yuan;

public class Student
{
    private String name;
    private int score;

    public Student(String stuName,int stuScore){
        name = stuName;
        score = stuScore;
    }

    @Override
    public String toString(){
        return String.format("%s's score is %d",name,score);
    }

    public static void main(String[] args){
        Array<Student> arr = new Array<>();//采用默认的capacity（即无参构造函数中定义的值：10）
        arr.addLast(new Student("蔡徐坤",66));
        arr.addFirst(new Student("吴亦凡",88));
        arr.addLast(new Student("蒋劲夫",99));
        System.out.println(arr);
    }
}
