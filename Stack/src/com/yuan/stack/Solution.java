package com.yuan.stack;

import java.util.Stack;

/**
 * 20. Valid Parentheses(有效的括号):括号匹配问题
  */

public class Solution {
    public boolean isValid(String str){
        // 先定义一个元素类型为Character的动态栈
        Stack<Character> stack = new Stack<>();
        // 遍历传入的字符串
        for (int i=0;i<str.length();i++){
            // 返回指定索引的字符
            char c = str.charAt(i);
            // 如果字符为'{'、'['、'('中的一种，则入栈；
            if (c == '{' || c == '[' || c == '('){
                stack.push(c);
            }else{
                // 如果栈为空，则直接返回false，因为没有相应的前括号与之匹配；
                if (!stack.isEmpty())
                    return false;
                // 获取栈顶元素
                char topChar = stack.peek();
                // 一旦栈顶的括号元素，无法与之匹配，则返回false
                if (c ==')' && topChar != '('){
                    return false;
                }
                if (c == ']' && topChar != '['){
                    return false;
                }
                if (c == '}' && topChar != '{'){
                    return false;
                }
                // 栈顶的括号元素与之匹配，则出栈
                stack.pop();
            }
        }
        // 如果栈最终为空，则表示字符串中的括号一一匹配，否则匹配无效。
        return stack.isEmpty();
    }
}
