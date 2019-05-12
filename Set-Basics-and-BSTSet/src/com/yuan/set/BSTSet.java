package com.yuan.set;

/**
 * 通过二分搜索树实现集合
 * （1）这里的泛型类型一定是可比较（所以必须继承Comparable<E>）
 * （2）BSTSet的基本方法都可以通过BST中的方法实现，因为集合主要特点是没有重复元素，
 *     而我们实现的BST也是没有重复元素的；
 * （3）集合可以用来统计词汇量（一本书的单词量有多少），统计客户数量，
 *     访问网站的用户数量（同一个用户访问多次也是算一个用户）
 * @param <E>
 */
public class BSTSet<E extends Comparable<E>> implements Set<E>{

    private BST<E> bst;

    //在构造函数中初始化
    public BSTSet(){
        bst = new BST<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }
}
