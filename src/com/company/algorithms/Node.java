package com.company.algorithms;

/**
 * Created by Johan Segerlund on 2018-07-30.
 */
public class Node {
    private final int id;

    public Node(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getStringId() {
        return Integer.toString(id);
    }
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Node other = (Node) obj;
        return id == other.getId();
    }

    public String toString() {
        return String.valueOf(id);
    }
}
