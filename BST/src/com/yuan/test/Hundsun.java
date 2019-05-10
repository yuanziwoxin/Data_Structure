package com.yuan.test;

/**
 * 恒生电子笔试题之编程题
 */
public class Hundsun {
    public boolean isInclude(char[] sourceArray,char[] destArray){
        //先找原数组中第一个与目标数组第一个元素相同的元素，然后进行依次对这两个数组的后续元素进行比较
        for (int i = 0;i <= sourceArray.length-destArray.length;i++){
            if (sourceArray[i] == destArray[0])
                return isInclude(i+1,1,sourceArray,destArray);
        }
        /*
        若原数组在索引为其长度减去目标数组长度的元素（包括该元素）之前没有元素与目标数组的第一个元素相匹配，则直接返回false；
        因为即使有原数组在索引为其长度进去目标数组长度后面的元素之后的元素与目标数组的第一个元素相同，
        原数组也不可能完全顺序包含目标数组了，因为原数组剩余的元素个数已经不够包含目标数组了。
         */
        return false;
    }

    /**
     * 判断从sourceArray数组从索引为s的元素开始的子数组是否顺序包含
     * destArray数组从索引为d的元素开始的子数组；
     * @param s  从sourceArray数组的哪个位置开始取值
     * @param d  从destArray数组的哪个位置开始取值
     * @param sourceArray  原数组
     * @param destArray    目标数组
     * @return
     */
    private boolean isInclude(int s,int d,char[] sourceArray,char[] destArray){
        /*
         如果sourceArray的子数组的长度小于destArray的子数组长度，
         则原数组显然不可能顺序包含目标数组；
          */
        if (sourceArray.length-s < destArray.length-d){
            return false;
        }
        /*
         如果递归到destArray的子数组的开始索引值为destArray的长度值，
         说明原数组顺序包含了目标数组
          */
        if (d == destArray.length){
            return true;
        }

        if (sourceArray[s] != destArray[d] ){
            return false;
        }else{
            return isInclude(s+1,d+1,sourceArray,destArray);
        }
    }

    /**
     * 用a元钱买啤酒（啤酒单价为1元），每b个空瓶可以换购一瓶啤酒，问对最多可以喝多少瓶啤酒？（b<a）
     * @param a  初始的资金
     * @param b
     * @return
     */
    public int maxBeers(int a,int b){
        int totalBeers = a; //总共喝的啤酒数，初始为a瓶；
        int bottles = a;
        int bottleToBeers = 0; //空瓶换啤酒的瓶数，初始为0瓶；
        while (bottles >= b){
            bottleToBeers = bottles/b;
            totalBeers += bottleToBeers;
            bottles = bottleToBeers+bottles%b;
        }
        System.out.println("The number of left Bottles is: "+ bottles);
        return totalBeers;
    }

    public static void main(String[] args){
        char[] sourceArray = {'a','d','c','e','f'};
        char[] destArray = {'c','e','f'};
        Hundsun hundsun = new Hundsun();
        boolean res = hundsun.isInclude(sourceArray,destArray);
        System.out.println(res);
        int maxBeers = hundsun.maxBeers(10,3);
        System.out.println("maxBeers: "+maxBeers);
    }
}
