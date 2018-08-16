package com.company.datastructures;

/**
 * Created by Johan Segerlund on 2018-08-16.
 */
public class BinaryTree<E extends Comparable<? super E>> {


    public class Node <E> {
        protected E data;
        protected Node left;
        protected Node right;

        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }

        public Node<E> getLeftChild () {
            return left;
        }
        public Node<E> getRightChild () {
            return right;
        }

        public E getData() {
            return data;
        }
    }

    protected Node<E> root;

    public BinaryTree() {
        this.root = null;
    }

    protected BinaryTree(Node<E> root) {
        this.root = root;
    }

    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
        root = new Node<E>(data);
        if(leftTree != null) {
            root.left = leftTree.root;
        } else {
            root.left = null;
        }
        if(rightTree != null) {
            root.right = rightTree.root;
        } else {
            root.right = null;
        }
    }

    public BinaryTree<E> getLeftSubtree() {
        if (root != null && root.left != null) {
            return new BinaryTree<E>(root.left);
        } else {
            return new BinaryTree<>(null);
        }
    }

    public BinaryTree<E> getRightSubTree() {
        if (root != null && root.right != null) {
            return new BinaryTree<E>(root.right);
        } else {
            return new BinaryTree<>(null);
        }
    }

    public E getData() {
        return root.data;
    }

    public Node<E> getRoot() {
        return root;
    }

    public boolean isLeaf() {
        return root == null || (root.left == null && root.right == null);
    }


}
