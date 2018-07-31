package com.company.algorithms;

/**
 * Created by Johan Segerlund on 2018-07-30.
 */
public class Node {
    private final String id;

    public Node(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Node other = (Node) obj;
        return id.equals(other.getId());
    }

    public String toString() {
        return String.valueOf(id);
    }
}
