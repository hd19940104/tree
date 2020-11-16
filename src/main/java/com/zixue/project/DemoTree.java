package com.zixue.project;

import javax.imageio.stream.IIOByteBuffer;

/**
 * 创建树
 */
public class DemoTree {

    /**
     *            F
     *      E
     *    D   C
     * B        A
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode<String> A = new TreeNode<>(null, null, "A");
        TreeNode<String> B = new TreeNode<>(null, null, "B");
        TreeNode<String> C = new TreeNode<>(null, A, "C");
        TreeNode<String> D = new TreeNode<>(B, null, "D");
        TreeNode<String> E = new TreeNode<>(D, C, "E");
        TreeNode<String> F = new TreeNode<>(E, null, "F");
        new DemoTree().preTree(F);
        System.out.println();
        new DemoTree().zTree(F);
        System.out.println();
        new DemoTree().postTree(F);

    }



    /**
     * 前序遍历
     * @param tree
     */
    public  void preTree( TreeNode tree){
        if (tree==null){
            return;
        }
        System.out.print(tree.data);
        preTree(tree.leftTree);
        preTree(tree.rightTree);
    }
    /**
     * 中序遍历
     * @param tree
     */
    public  void  zTree( TreeNode tree){
        if (tree==null){
            return;
        }

        zTree(tree.leftTree);
        System.out.print(tree.data);
        zTree(tree.rightTree);
    }
    /**
     * 后序遍历
     * @param tree
     */
    public  void postTree( TreeNode tree){
        if (tree==null){
            return;
        }

        postTree(tree.leftTree);
        postTree(tree.rightTree);
        System.out.print(tree.data);
    }

    /**
     * 构建 树
     * @param <T>
     */
    static class TreeNode<T>{
        private TreeNode leftTree;
        private  TreeNode rightTree;
        private T data;
        private  int index;

        public TreeNode(TreeNode leftTree, TreeNode rightTree, T data) {
            this.leftTree = leftTree;
            this.rightTree = rightTree;
            this.data = data;
        }

        public TreeNode getLeftTree() {
            return leftTree;
        }

        public void setLeftTree(TreeNode leftTree) {
            this.leftTree = leftTree;
        }

        public TreeNode getRightTree() {
            return rightTree;
        }

        public void setRightTree(TreeNode rightTree) {
            this.rightTree = rightTree;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "leftTree=" + leftTree +
                    ", rightTree=" + rightTree +
                    ", data=" + data +
                    ", index=" + index +
                    '}';
        }
    }




}
