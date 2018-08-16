package com.company.datastructures;

/**
 * Created by Johan Segerlund on 2018-08-16.
 */
public class BinarySearchTree <E extends Comparable<E>> extends BinaryTree<E> implements SearchTree<E> {

    protected boolean addReturn;
    protected E deleteReturn;

    public boolean add(E item) {
        root = add(root, item);
        return addReturn;
    }

    private Node<E> add(Node<E> localRoot, E item) {
        if (localRoot == null) {
            addReturn = true;
            return new Node<E> (item);
        } else if(item.compareTo(localRoot.data) == 0) {
            addReturn = false;
            return localRoot;
        } else if(item.compareTo(localRoot.data) <0) {
            localRoot.left = add(localRoot.left, item);
            return localRoot;
        } else {
            localRoot.right = add(localRoot.right, item);
            return localRoot;
        }
    }

    public boolean contains(E target) {
        return false;
    }

    public E find(E target) {
        return find(root, target);
    }

    private E find(Node<E> localRoot, E target) {
        if (localRoot == null)
            return null;

        int compResult = target.compareTo(localRoot.data);
        if (compResult == 0)
            return localRoot.data;
        else if (compResult < 0)
            return (E) find(localRoot.left, target);
        else
            return (E) find(localRoot.right, target);
    }

    public E delete(E target) {
        return null;
    }

    public boolean remove(E target) {
        return false;
    }
}
