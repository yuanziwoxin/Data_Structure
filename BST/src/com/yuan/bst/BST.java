package com.yuan.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二分搜索树:节点大于其左子树，节点小于其右子树；（不包含重复元素）
 * 如果要使二分搜索树可包含重复元素，则只需要将节点大于等于其左子树，或者节点小于等于其右子树；
 * 注意： 我们之前所实现的数组和链表是可以有重复元素的；
 *
 * 支持泛型，但是这里的泛型必须是可以比较的；
 */
public class BST<E extends Comparable<E>> {
    // 定义一个私有的内部类
    private class Node{
        public E e;
        public Node left; // 左孩子
        public Node right; // 右孩子
        // 初始化一个节点
        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }
    public Node root;
    public int size;

    // 初始化二分搜索树
    public BST(){
        root = null;
        size = 0;
    }

    // 获取当前二分搜索树的节点个数
    public int getSize(){
        return size;
    }

    // 判断二分搜索树是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    // 向二分搜索树添加元素
    public void add(E e){
        root = add(root,e);
    }

    /**
     * 向以node为根节点的二分搜索树添插入元素e.(递归算法)
     * @param node  根节点
     * @param e 插入的元素
     * @return 返回插入新元素后二分搜索树的根
     *   若对象类型继承了Comparable类，则该类型的对象之间比较大小，可以使用y.compareTo(x)方法
     *      y.compareTo(x) > 0 表示对象y的值大于对象x的值；
     *      y.compareTo(x) < 0 表示对象y的值小于对象x的值;
     *      y.compareTo(x) == 0 表示对象y的值等于对象x的值;（类似于y.equals(x)）
     */
    private Node add(Node node,E e){
        // 递归出口
        if(node == null){
            size++;
            node = new Node(e);
            return node;
        }
        // 递归
        if(e.compareTo(node.e)< 0){ //如果插入的元素小于根节点node的元素值，则将节点插入到左子树中；
            node.left = add(node.left,e);
        }else if (e.compareTo(node.e) > 0){ //如果插入的元素大于根节点node的元素值，则将节点插入到右子树中；
            node.right = add(node.right,e);
        }
        return node;
    }

    /**
     * 判断二分搜索树是否包含元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        return contains(root,e);
    }

    /**
     * 判断以node为根节点的二分搜索树是否包含元素e, 递归算法
     * @param node 根节点
     * @param e 元素
     * @return
     */
    private boolean contains(Node node,E e){
        if(node == null){ // 如果根节点node为空，则直接返回false
            return false;
        }

        if (e.compareTo(node.e)==0){ //如果插入的元素等于根节点node的元素值，则直接返回true；
            return true;
        }else if (e.compareTo(node.e) < 0){
            // 如果插入的元素小于根节点的元素值，则查询其左子树上是否包含该元素；
            return contains(node.left,e);
        }else {    // 即 e.compareTo(node.e) > 0
            return contains(node.right,e);
        }
    }

    /**
     * 前序遍历的非递归实现
     * 以栈的形式实现：（用栈来记录访问的顺序）
     * 先把根节点压入栈，然后只要栈不为空，则出栈一个节点并访问它，然后分别判断其是否有左右孩子，
     * 有的话先将右孩子先入栈，再将左孩子入栈，然后按照上述过程循环，直至栈为空。
     */
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root); //先将根节点压入栈
        while (!stack.isEmpty()){ //如果栈不为空
            Node cur = stack.pop(); //先将节点出栈
            System.out.println(cur.e);// 访问该节点
            // 注意：先压入栈的是右孩子，然后才是左孩子，这样才是先访问左孩子，再访问右孩子
            if (cur.right != null) // 如果出栈节点的右孩子不为空，则将其压入栈
                stack.push(cur.right);
            if (cur.left != null) // 如果出栈节点的左孩子不为空，则将其压入栈
                stack.push(cur.left);
        }
    }

    /**
     * 对二分搜索树进行前序遍历
     */
    public void preOrder(){
        preOrder(root);
    }

    /**
     * 对以node为根节点的二分搜索树进行前序遍历，递归算法
     * @param node 根节点
     */
    private void preOrder(Node node){
        if (node == null){ // 如果根节点为空，则直接返回；
            return;
        }

        System.out.println(node.e); // 否则，打印输出根节点node的元素值（访问根节点的值）
        preOrder(node.left);  // 对根节点的左子树进行前序遍历
        preOrder(node.right); // 对根节点的右子树进行前序遍历
    }

    /**
     * 对二叉搜索树进行中序遍历
     *
     * 二分搜索树的中序遍历就是二分搜索树节点的顺序排列
     */
    public void inOrder(){
        inOrder(root);
    }

    /**
     * 对以node为根节点的二分搜索树进行中序遍历
     * @param node
     */
    private void inOrder(Node node){
        if (node == null){
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);  //访问根节点
        inOrder(node.right);
    }

    /**
     * 对二分搜索树进行后序遍历
     */
    public void postOrder(){
        postOrder(root);
    }

    /**
     * 对以node为根节点的二分搜索树进行后序遍历
     * @param node
     */
    private void postOrder(Node node){
        if (node == null){
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e); //访问根节点
    }

    /**
     * 二叉树的层序遍历
     */
    public void levelOrder(){
        Queue<Node> q = new LinkedList<>();//一般都通过链表实现队列
        q.add(root);
        while (!q.isEmpty()){
            Node cur = q.remove(); //删除节点，即出队
            System.out.println(cur.e);

            if (cur.left != null){ //如果出队节点的左孩子存在，则将其左孩子入队
                q.add(cur.left);
            }
            if (cur.right != null){//如果出队节点的右孩子存在，则将其右孩子入队
                q.add(cur.right);
            }
        }
    }

    // 二分搜索树的字符串形式
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root,0,res);
        return res.toString();
    }

    /**
     * 产生二分搜索树字符串（采用前序遍历的方式）   递归算法
     * @param node 根节点
     * @param depth 节点所在层数
     * @param res 字符串
     */
    private void generateBSTString(Node node,int depth,StringBuilder res){
        // 递归出口
        if (node == null){ // 如果根节点为空，则输出相应的层数和与层数成正比的符号，以及null
            res.append(depth+": "+generateDepthString(depth)+"null\n");
            return; // 根节点为空，一定要结束本次函数的执行，否则会造成下面的node为空
        }

        // 若不为空，则按照一定形式打印输出根节点的元素值
        res.append(depth+": "+generateDepthString(depth)+node.e+"\n");
        generateBSTString(node.left,depth+1,res);// 以前序遍历的方式遍历其左子树
        generateBSTString(node.right,depth+1,res);// 以前序遍历的方式遍历其右子树
    }

    /**
     * 主要是通过打印输出的形式更加直观地显示元素所在的层次
     * @param depth
     * @return
     */
    private String generateDepthString(int depth){
        StringBuilder str = new StringBuilder();
        for (int i=0;i<depth;i++){
            str.append(" -- ");
        }
        return str.toString();
    }
}
