package com.company.datastructures;

public abstract class AbstractAlgorithm implements IAlgorithm {

    protected void swap(int[] f, int first, int second) {
        int placeholder = f[first];
        f[first] = f[second];
        f[second] = placeholder;
    }

}
