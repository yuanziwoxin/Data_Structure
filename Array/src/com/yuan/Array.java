package com.yuan;

import java.util.ArrayList;

public class Array<E> {

    private E[] data;
    private int size;

    //构造函数，传入数组长度的构造Array;
    public Array(int capacity)
    {
        /*
         java不支持泛型数组，所以不能直接使用new E[capacity]初始化一个泛型数组。
         任意类都是Object类的子类，换句话说就是Object类是任意类的父类。
         然后使用强制转换，转换为泛型类型的数组（即这里E类型的数组，E是一个自定义的类型名，可自取）
        */
        data=(E[])new Object[capacity];
        size=0;
    }

    //无参构造函数，不传入数组长度的构造函数，默认数组长度为10;
    public Array()
    {
        this(10);
        size=0;
    }

    //获取数组中当前元素的个数
    public int getSize()
    {
        return size;
    }

    //获取数组的容量
    public int getCapacity()
    {
        return data.length;
    }

    //判断数组是否为空
    public boolean isEmpty()
    {
        return size==0;//如果size为0，返回true，说明数组为空
    }

    //在所有元素的后面插入一个新元素
    public void addLast(E e)
    {
        add(size,e);//索引为size指向的正是数组的最后一个元素的后一位；
    }

    //在所有元素的前面插入一个新元素
    public void addFirst(E e)
    {
        add(0,e);
    }

    //在索引为index的位置插入新的元素e
    public void add(int index,E e)
    {

        //如果添加新元素的位置索引小于0或者大于当前元素的个数，则抛出异常；（索引为size，表示在数组末尾添加一个新元素）
        if (index < 0 || index > size)
        {
            throw new IllegalArgumentException("Add failed.Required index >= 0 and index <= size!");
        }

        //如果数组的容量已经满了，这里不再抛出异常，而是采用动态扩容的方式给数组扩容
        if (size == data.length)
        {
            //throw new IllegalArgumentException("Add failed.Array is full!");
            resize(2*data.length);//动态扩容为原数组长度的2倍
        }

        //依次将索引为index后的元素（包括索引为index位置的元素）向后移一位
        for (int i=size-1;i >= index;i--)
        {
            data[i+1]=data[i];//将前一个元素向后移一位
        }

        data[index]=e;//插入新元素e;
        size ++;//指向下一个元素，不要忘了!!!
    }

    //查询index索引位置的元素(这样封装的好处：1、用户看不到数组的具体结构；2、可以在查询数组元素前判断索引是否合法)
    E get(int index)
    {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed.Require index>=0 and index<size !");
        return data[index];
    }

    //查询数组是否包含元素e,包含就返回true，否则返回false
    boolean contains(E e)
    {
        for (int i=0;i<size;i++)
        {
            // 因为data[i]和e都是类对象，所以两个类对象的值比较，用equals比较合适
            // 引用比较则使用==,==只有在对象的引用地址相同才会返回true
            if (data[i].equals(e))
                return true;
        }
        return false;
    }

    //在数组中查询元素e,如果存在则返回该元素的索引index,否则返回-1；
    //注意：这种方法的局限性在于只能查找数组中第一个与元素e相同的元素，不能查找所有与元素e相同的元素；
    int find(E e)
    {
        for (int i=0;i<size;i++)
        {
            if(data[i].equals(e))
                return i;
        }
        return -1;
    }

    //查询出数组中所有的元素e;(Thinking by myself)
    Array findAll(E e)
    {
        Array indexs=new Array(data.length);//有点浪费空间！！！
        for (int i=0;i<size;i++)
        {
            if (data[i].equals(e))
                indexs.addLast(i);
        }
        return indexs;
    }

    // 查询数组中所有的元素e，找到返回其索引值的动态数组(另一种方法)
    ArrayList<Integer> findAllv2(E e){
        ArrayList<Integer> indexs = new ArrayList<>();
        for (int i=0;i<size;i++){
            if (data[i].equals(e)){
                indexs.add(i);
            }
        }
        return indexs;
    }

    //从数组中删除索引为index的元素，返回被删除的元素值；
    E remove(int index)
    {
        if (index<0 || index>=size)
            throw new IllegalArgumentException("Remove failed.Index is illegal!");
        E ret=data[index];//存储要被删除元素的值
        /*
        当size = capacity的时候，这里会造成数组越界；
        因为当i=size-1，执行data[size-1]=data[size],事实上data[size]是不存在的
        for (int i=index;i<size;i++)
        {
            data[i]=data[i+1];
        }
        */
        for (int i=index+1;i<size;i++)
        {   // 所谓的删除无非是用后面的值覆盖前面一个单元的值，所以其实最后一个是单元还是有值的，只是访问不到而已
            data[i-1]=data[i];
        }
        size--;
         /*
         data[size]其实还存着一个类对象，如果data[size]还存储一个对象的引用，
         java的自动回收机制就不会自动进行回收,这里只有让data[size]=null，
         这样data[size]原来指向的对象不会和程序中其他的对象相关联，所以java的自动回收机制会快速将其回收。
          */
        data[size] = null;

        /*
         如果删除元素后，当前存储的元素个数是原数组容量的1/4时，那么为了节省空间可进行缩容。
         data.length/2 != 0的目的是为了防止原数组的容量为1时，将数组的容量进一步缩容为0。
         数组的容量是不能为0的。
          */
        if (size == data.length/4 && data.length/2 != 0 ){
            resize(data.length/2);
        }

        return ret;
    }

    //从数组中删除第一个元素,并返回第一个元素的值；
    E removeFirst()
    {
        return remove(0);
    }

    //从数组中删除最后一个元素,并返回最后一个元素的值；
    E removeLast()
    {
        return remove(size-1);
    }

    //从数组中删除元素e;
    //注意：如果数组中有多个元素e,则只会删除数组中第一个元素e，其他仍然保留。
    void removeElement(E e)
    {
        int index=find(e);
        if (index != -1)//index=-1，说明数组中没有找到元素e
        {
            remove(index);
        }
    }

    //删除数组中的所有元素e;
    // 注意:如果不加i--，当数组中存在连续的元素e,并不能把所有元素e删除;
    //如data={10,3,3,5,2}当删除第一个元素3,后面连续的元素3直接向前移动一位，而i++使得下次比较的是5,所以刚好跳过了原来的3.
    void removeAllElement(E e)
    {

        for (int i=0;i<size;i++)
        {
            if (data[i].equals(e))
            {
                remove(i);
                i--;//因为删除一个元素后，后面的所有元素会前移一位，如果不i--,会导致漏比较被删除元素的下一个元素；
            }
            //System.out.println("all:"+i);
        }
    }
    // 删除数组中的所有元素e（方法二）
    void removeAllElementV2(E e){
        ArrayList indexs = findAllv2(e);
        // 获取ArrayList存储的当前元素的数量的方法为.size()
//        System.out.println(indexs);
        for (int i=0;i<indexs.size();i++){
            Integer  tempInteger = (Integer) indexs.get(i);
            //因为每删除一次，得到新的数组，原来的数组索引也会相应地发生变化（即减i）
            int tempInt = tempInteger.intValue()-i;
            remove(tempInt);
        }
    }

    //修改index索引位置的元素
    void set(int index,E e)
    {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed.Index is illegal!");
        data[index]=e;
    }

    @Override  //覆写父类中的方法
    public String toString()
    {
        // 构建一个空的字符串构造器
        StringBuilder res=new StringBuilder();
        // String.format():用于创建格式化的字符串以及连接多个字符串对象,类似于C语言中的printf
        res.append(String.format("Array size is %d, capacity is %d\n",size,data.length));
        res.append('[');

        for (int i=0;i<size;i++)
        {
            res.append(data[i]);
            if (i != size-1)//只要不是最后一个元素，就在添加完每个元素之后加上‘,’;
                res.append(',');
        }

        res.append(']');

        return res.toString();//将StringBuilder转化为String
    }

    /**
     * 给数组动态扩容（缩容）
     * 定义一个更大（更小）容量的新数组，然后将原数组的元素全部赋值给新数组，然后将原数组指向新数组，
     * 这样原数组就动态扩容（或缩容）了。
     */
    public void resize(int newCapacity){
        E[] newData =(E[]) new Object[newCapacity];
        for (int i=0;i<size;i++){
            newData[i] = data[i];
        }
        data = newData;
    }
}
