package com.company.algorithms;

import java.util.*;

public class Kruskal {
    private final List<Node> nodes;
    private final List<Edge> edges;
    private PriorityQueue<Edge> pq;
    private ArrayList<Edge> mst;
    private int[] theSet;


    public Kruskal(Graph graph) {
        this.edges  = graph.getEdges();
        this.nodes = graph.getNodes();

        pq = new PriorityQueue(new EdgeComparator());
        this.mst = new ArrayList<>();

        runKruskal();
        printResult();
    }


    public void runKruskal() {
        initPriorityQueue();
        initSet(nodes.size());

        Edge tempEdge;
        while(pq.size() > 0) {
            tempEdge = pq.poll(); //Get new edge with lowest weight cost

            //Find out if the edge is a part of the set. This is done by calling the find method on both nodes and compare the result. If the result is equal that means they are in the same set.
                // https://www.youtube.com/watch?v=YB3_c11GPEo
            int u = find(tempEdge.getSource().getId());
            int v = find(tempEdge.getDestination().getId());

            //Merge sets if they are not connected
            if(u != v) {
                union(u, v);
                mst.add(tempEdge);
            }
        }
    }


    private void initPriorityQueue() {
        for(int i = 0; i < edges.size(); i++) {
            pq.add(edges.get(i));
        }
    }


    public void initSet(int capacity) {
        theSet = new int[capacity];
        for (int i = 0; i < theSet.length; i++) {
            theSet[i] = -1;
        }
    }


    public int find(int x) {
        if(theSet[x] < 0 ) {
            return x;
        } else {
            theSet[x] = find( theSet[x] ); //Flatten the tree in order to run the algorithm faster. We don't want an unbalanced tree.
            return theSet[x];
        }
    }


    private void union(int u, int v) {
        theSet[u] = v;
    }


    private void printResult() {
        System.out.println("Final result of the set:");
        for(int i = 0; i < theSet.length; i++) {
            System.out.println("[" + i + " -> " + theSet[i] + "]");
        }
        System.out.println();

        System.out.println("Minimum Spanning Tree:  (All remaining edges)");
        for(Edge edge: mst) {
            System.out.println( "(" + edge.getSource().getId() + ", " + edge.getDestination().getId() + ")");
        }
    }

    public ArrayList<Edge> getMST() {
        return mst;
    }

    private class EdgeComparator <E extends Edge> implements Comparator<E> {
        @Override
        public int compare(E edgeFirst, E edgeSecond) {
            if(edgeFirst.getWeight() > edgeSecond.getWeight()) {
                return 1;
            }
            if(edgeFirst.getWeight() == edgeSecond.getWeight()) {
                return 0;
            }
            return -1;
        }
    }

}
