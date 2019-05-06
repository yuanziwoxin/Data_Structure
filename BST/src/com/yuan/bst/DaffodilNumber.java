package com.yuan.bst;

import java.util.ArrayList;

/**
 * 打印出所有的水仙花数，所为谓“水仙花数”是指一个三位数，其各位数字立方和等于该数本身。
 * 比如 153 = 1^3 + 5^3 + 3^3;
 */
public class DaffodilNumber {

    /**
     * 判断是否是水仙花数，若是则存储到动态数组中去
     * @return
     */
    private static ArrayList<Integer> isDaffodilNumber(){
        ArrayList<Integer> arrayList = new ArrayList<>();

        int hundred,ten,single; //分别表示百位，十位，个位

        for (int i=100;i<1000;i++){
            hundred = i/100;
            ten = (i-hundred*100)/10;
            single = i-hundred*100-ten*10;
            //若该三位数等于其各位数字的立方和，则添加到动态数组中，Math.pow(x,y)表示求x的y次方
            if (i == Math.pow(hundred,3)+Math.pow(ten,3)+Math.pow(single,3)){
                arrayList.add(i);
            }
        }
        return arrayList;
    }

    public static void main(String[] args){
        ArrayList<Integer> arrayList = isDaffodilNumber();
        System.out.println(arrayList);
        for (int i=0;i<arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }
    }
}
