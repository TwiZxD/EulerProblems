package com.company.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Johan Segerlund on 2018-07-30.
 */
public class tester {
    List<Node> nodes;
    List<Edge> edges;
    public tester(){
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
        //dijkstraTest();
        testKruskal();
    }

    private void testKruskal() {
        createNodes(6);
        createEdge(0,1, 2, true);
        createEdge(0,4, 2, true);
        createEdge(1,2, 1, true);
        createEdge(1,5, 1, true);
        createEdge(2,5, 1, true);
        createEdge(2,3, 2, true);
        createEdge(3,5, 1, true);
        createEdge(3,4, 2, true);
        createEdge(4,5, 3, true);
        Graph graph = new Graph(nodes, edges);
        Kruskal kruskal = new Kruskal(graph);
    }

    private void dijkstraTest() {
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
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

        /** Graph:
         *           __3____
         *       ___|___ ___|___
         *      6   0   2   4   5
         *          |___|
         *             1
         */

        DijkstraAlgorithm algoritm = new DijkstraAlgorithm(graph);
        algoritm.shortestPath(node0);
    }

    private void createNodes(int amountOfNodes) {
        for (int i = 0; i < amountOfNodes; i++) {
            Node node = new Node(i);
            nodes.add(node);
        }
    }

    private void createEdge(int sourceNodeIndex, int destinationNodeIndex, int weight, boolean isDirected) {
        Node source = nodes.get(sourceNodeIndex);
        Node destination = nodes.get(destinationNodeIndex);
        edges.add(new Edge(source, destination, weight));
    }
}
