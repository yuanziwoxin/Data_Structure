package com.yuan.set;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale;

// 文件相关操作
public class FileOperation {

    // 读取文件名称为filename中的内容，并将其中包含的所有词语放进words中
    public static boolean readFile(String filename, ArrayList<String> words){

        if (filename == null || words == null){
            System.out.println("filename is null or words is null");
            return false;
        }

        // 文件读取
        Scanner scanner;

        try {
            File file = new File(filename);// 打开文件
            if(file.exists()){
                FileInputStream fis = new FileInputStream(file); //将文件读取到数据输入流中
                // 以"UTF-8"的编码格式读取缓冲输入流中的数据；
                /*
                BufferedInputStream是缓冲输入流，它继承于FilterInputStream。
                BufferedInputStream本质上是通过一个内部缓冲区数组实现的。
                 */
                scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
                scanner.useLocale(Locale.ENGLISH);//指定scanner使用的语言环境
            }
            else
                return false;
        }
        catch(IOException ioe){
            System.out.println("Cannot open " + filename);
            return false;
        }

        // 简单分词（有些地方没有处理：例如一个单词因时态不同而有几种形式，但是这其实都是同一个单词）
        // 这个分词方式相对简陋, 没有考虑很多文本处理中的特殊问题
        // 在这里只做demo展示用
        if (scanner.hasNextLine()) {
            // 从scanner对象中读取字符串，分隔符为'\A','\A'表示一个字符串的开头
            String contents = scanner.useDelimiter("\\A").next();// \A表示一个单词的开头
            // 查找字符串中第一个字母字符的索引
            int start = firstCharacterIndex(contents, 0);
            for (int i = start + 1; i <= contents.length(); )
                //如果i遍历到字符串的末尾的下一位或者遍历到字符串的某一个字符不是字母
                if (i == contents.length() || !Character.isLetter(contents.charAt(i))) {
                    //把字母字符串（单词）截取出来，并全转化为小写形式
                    String word = contents.substring(start, i).toLowerCase();
                    words.add(word);//把单词添加到字符串类型的动态数组中去
                    start = firstCharacterIndex(contents, i);//查找接下来的字符串中第一个字母字符的索引
                    i = start + 1; // 继续查找下一个单词
                } else
                    i++;
        }

        return true;
    }

    // 寻找字符串s中，从start的位置开始的第一个字母字符的位置
    private static int firstCharacterIndex(String s, int start){

        for( int i = start ; i < s.length() ; i ++ )
            //判断s字符串中索引为index处的字符是否为字母
            if( Character.isLetter(s.charAt(i)) )
                return i;
        return s.length();
    }

    // test BufferedReader.read()
    public static void IOTest() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int charASCII = br.read();//这里读取的是输入的字符的ASCII码值
//        char inputChar = (char) charASCII; //强制类型转换为字符类型
//        System.out.println(inputChar+":"+charASCII);
//        String inputString = br.readLine();
//        System.out.println(inputString);
        int ascii;
        char c;
        StringBuilder str = new StringBuilder();
        System.out.println("输入字符，直到按下空格结束：");
        while (true){
            ascii = br.read();
            // 当输入换行符的时候跳出循环
            if (ascii == 10) //换行符的ASCII码值为10
                break;
            c = (char)ascii;
            str.append(c);
        }
        System.out.println(str.toString());
    }

    // test BufferedReader.readLine()
    public static void IOTest1() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入字符行，直到输入‘end’结束输入：");

        StringBuilder res = new StringBuilder();
        String str;
        while (true){
            str = br.readLine();
            if (str.equals("end")) //当输入end的时候，跳出循环
                break;
            res.append(str);
        }
        System.out.println(res.toString());
    }

    // test Scanner.next()
    public static void scannerTest(){
        Scanner scanner = new Scanner(System.in);//接收键盘上输入的数据
        System.out.println("next方式读取数据：");
        while (scanner.hasNext()){
            String str = scanner.next();
            //当读取到输入的字符串是“end”,表示输入结束。
            if (str.equals("end"))
                break;
            System.out.println("输入的数据为："+str);
            //System.out.print(str+" ");
        }
        scanner.close();//关闭scanner对象
    }

    // test Scanner.nextLine()
    public static void scannerTest1(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("nextLine方式读取数据：");
        while (scanner.hasNextLine()){
            String str = scanner.nextLine();
            if (str.equals("end"))
                break;
            System.out.println("输出的数据为: "+str);
        }
        scanner.close();
    }

    // test Scanner.nextInt()
    public static void scannerTest2(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("nextInt方式读取数据：");
        while (scanner.hasNextInt()){
            int data = scanner.nextInt();
            System.out.println("输出的数据为: "+data);
        }
        scanner.close();
    }

    public static void main(String[] args) throws IOException {
//        IOTest();
//        System.out.println();
//        IOTest1();
//        scannerTest();
//        scannerTest1();
        scannerTest2();
    }
}