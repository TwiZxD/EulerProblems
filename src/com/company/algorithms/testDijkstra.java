package com.company.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Johan Segerlund on 2018-07-30.
 */
public class testDijkstra {
    public testDijkstra(){
        this.test();
    }

    private void test() {
        List<Node> nodes = new ArrayList<>();
        List<Edge> edges = new ArrayList<>();
        Node node0 = new Node("0");
        Node node1 = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");
        Node node4 = new Node("4");
        Node node5 = new Node("5");
        Node node6 = new Node("6");
        nodes.add(node0);
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);
        nodes.add(node5);
        nodes.add(node6);
        edges.add(new Edge(node0, node1, 1));
        edges.add(new Edge(node0, node2, 3));
        edges.add(new Edge(node0, node3, 5));
        edges.add(new Edge(node1, node2, 1));
        edges.add(new Edge(node2, node4, 1));
        edges.add(new Edge(node3, node4, 2));
        edges.add(new Edge(node4, node5, 2));
        edges.add(new Edge(node0, node6, 2));
        Graph graph = new Graph(nodes,edges);

        DijkstraAlgorithm algoritm = new DijkstraAlgorithm(graph);
        algoritm.shortestPath(node0);
    }
}
