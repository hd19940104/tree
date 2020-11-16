package com.zixue.project;

import java.util.Arrays;
import java.util.Stack;

/**
 * 栈
 */
public class DemoStack {
    public static void main(String[] args) {
        Stack<Object> stack = new Stack<>();
        StackByArray<Integer> integerStackByArray = new StackByArray<>();
        integerStackByArray.push(1);
        integerStackByArray.push(2);
        integerStackByArray.push(5);
        integerStackByArray.push(3);
        integerStackByArray.push(4);

        System.out.println("size:"+integerStackByArray.size);



    }
    /**
     * 基于 链表
     */
    static class  StackByLink<T>{
        //定义 链表
        class Node<T>{
            private  T t;
            private Node next;
        }
        private  Node<T> head;

        //初始化
        StackByLink(){
            head=null;
        }

        //入 栈
        public  void push(T t ){
            if (t==null){
                throw  new NullPointerException("参数不能为空");
            }
            if (head==null){
                head=new Node<T>();
                head.t=t;
                head.next=null;
            }else {
                //头 插法
                Node<T> temp =head;
                head=new Node<>();
                head.t=t;
                head.next=temp;
            }
        }

        //出 栈
        public T pop(){
            T t= head.t;
            head= head.next;
            return t;
        }
        //栈顶 元素
        public  T peek(){
            T t = head.t;
            return t;
        }

        //判断 是否 为空
        public  boolean isEmpty(){
            if (head==null){
                return true;
            }else {
                return false;
            }
        }

    }

    /**
     * 基于 数组 实现
     */
    static class StackByArray<T>{
        //实现 栈 的数组
        private  Object[] stack;
        //数组 大小
        private volatile int size;

        StackByArray(){
            //初始 容量 10
            stack=new Object[10];
        }

        //判断 是否 为空
        public synchronized   boolean isEmpty(){
            return  size== 0;
        }

        //返回 栈顶 元素
        public synchronized   T peek(){
            T t =null;
            if (size>0){
                t= (T)stack[size-1];
            }
            return  t;
        }

        public synchronized   void  push(T t){
            expandCapacity(size+1);
            stack[size]=t;
            size++;
        }
        //出 栈
        public synchronized T pop(){
            T t =peek();
            if (size>0){
                stack[size-1]=null;
                size--;
            }
            return  t;
        }
        //扩大 量
        public synchronized   void expandCapacity(int size){
            int len =stack.length;
            if (size>len){
                size=size * 3/2+1;//每次扩大50%
                stack= Arrays.copyOf(stack,size);
            }

        }

    }

}
