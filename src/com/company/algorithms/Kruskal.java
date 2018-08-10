package com.company.algorithms;

import java.lang.reflect.Array;
import java.util.*;

public class Kruskal {
    private final List<Node> nodes;
    private final List<Edge> edges;
    private List<Node> mst;
    private PriorityQueue<Edge> pq;

    public Kruskal(Graph graph) {
        this.edges  = graph.getEdges();
        this.nodes = graph.getNodes();

        pq = new PriorityQueue(new EdgeComparator());
        this.mst = new ArrayList<Node>();

        doKruskal();
    }

    public void doKruskal() {

        initPriorityQueue();
        Edge tempEdge;
        while(pq.size() > 0) {
            tempEdge = pq.poll();
            tryToAddEdgeToMST(tempEdge);
        }

        /*
        ArrayList<Edge> sortedEdges = sortEdgesByWeight();
        for (Edge edge : sortedEdges) {
            edge = getEdgeWithLowestWeight();
            tryToAddEdgeToMST(edge);
        }
        */
        //Edge edge = getLowestEdge();
        //tryToAddToMST(edge);

    }

    private void initPriorityQueue() {
        for(int i = 0; i < edges.size(); i++) {
            pq.add(edges.get(i));
        }
    }

/*
List<String> names = ....
Iterator<String> i = names.iterator();
while (i.hasNext()) {
   String s = i.next(); // must be called before you can call i.remove()
   // Do something
   i.remove();
}
 */

    private ArrayList<Edge> sortEdgesByWeight() {
        ArrayList<Edge> sortedEdges = new ArrayList();
        int lowestWeight = Integer.MAX_VALUE;
        int tempWeight;
        int lowestEdge = 0;
        //Edge lowestEdge, temp;
        Iterator<Edge> iter = edges.iterator();

        for(int i = 0; i < edges.size(); i++) {
            tempWeight = edges.get(i).getWeight();
            if(lowestWeight > tempWeight) {
                lowestWeight = tempWeight;
                lowestEdge = i;
            }
        }
        sortedEdges.add(edges.get(lowestEdge));
        edges.remove(lowestEdge);
/*
        while (i.hasNext()) {
            temp = i.next();

        }
        */
        return null;
    }

    private Edge getEdgeWithLowestWeight() {
        return null;
    }

    private void tryToAddEdgeToMST(Edge edge) {
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
