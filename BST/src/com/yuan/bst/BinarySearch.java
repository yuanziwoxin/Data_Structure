package com.yuan.bst;

/**
 * 二分查找的递归和非递归实现
 */
public class BinarySearch {
    public int[] arrs;
    public BinarySearch(int[] arrs){
        this.arrs = arrs;
    }
    public int BSearch(int key){
//        return BSearch(0,arrs.length-1,key);// 递归实现
        return BSearchNoRecursive(0,arrs.length-1,key);//非递归实现
    }

    /**
     * 二分查找（递归实现）
     * @param begin
     * @param end
     * @param key
     * @return
     */
    private int BSearch(int begin,int end,int key){
        //若最小值大于key或者最大值小于key或者begin>end(数组中未找到与key值相匹配的元素)，则返回-1
        if (arrs[begin]>key || arrs[end]<key || begin > end){
            return -1;
        }
        int mid = (end+begin+1)/2;
        if (arrs[mid] == key){
            return mid;
        }
        else if (arrs[mid] > key){
            System.out.println("curIndex is:"+mid+" and curElement is:"+arrs[mid]);
            return BSearch(begin,mid-1,key);
        }

        else { // arrs[mid] < key
            System.out.println("curIndex is:"+mid+" and curElement is:"+arrs[mid]);
            return BSearch(mid+1,end,key);
        }
    }

    /**
     * 二分查找（非递归实现）
     * @param begin
     * @param end
     * @param key
     * @return
     */
    private int BSearchNoRecursive(int begin,int end,int key){
        /*
            如果有序数组的最小元素值大于key,或者最大元素值小于key，或者begin>end时，
            则说明数组中没有与key相等的元素，直接返回-1.
         */
        if (arrs[begin]>key || arrs[end]<key || begin>end ){
            return -1;
        }

        while (begin<=end){
            int mid = (begin+end)/2;
            System.out.println("curIndex is:"+mid+" and curElement is:"+arrs[mid]);
            if (arrs[mid]>key){ // 中间值比关键值大，则在左边查找
                end = mid-1;
            }else if (arrs[mid]<key){ // 中间值比关键值小，则在右边查找
                begin = mid+1;
            }else{
                return mid; // 返回中间值的索引
            }
        }
        return -1; // 最后仍然没有找到则返回-1
    }

    public static void main(String[] args){
        int[] arrays = {6,7,8,13,25,28,31,35};
        BinarySearch binarySearch = new BinarySearch(arrays);
        int index = binarySearch.BSearch(6);
        System.out.println("The index of key is: "+index);
    }
}
