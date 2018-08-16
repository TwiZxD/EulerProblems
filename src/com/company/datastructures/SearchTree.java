package com.company.datastructures;

/**
 * Created by Johan Segerlund on 2018-08-16.
 */
public interface SearchTree<E> {
    boolean add (E item);
    boolean contains(E target);
    E find (E target);
    E delete(E target);
    boolean remove (E target);
}
