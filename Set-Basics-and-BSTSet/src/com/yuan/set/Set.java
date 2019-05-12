package com.yuan.set;

/**
 * 集合：元素不能重复
 * @param <E>
 */
public interface Set<E> {
    public void add(E e);
    public void remove(E e);
    public int getSize();
    public boolean isEmpty();
    public boolean contains(E e);
}
