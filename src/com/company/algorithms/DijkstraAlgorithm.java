package com.company.algorithms;

import java.util.*;

/**
 * Created by Johan Segerlund on 2018-07-30.
 */
public class DijkstraAlgorithm {
    private final List<Node> nodes;
    private final List<Edge> edges;
    private HashSet<String> visited;
    private HashMap<String, Integer> cost;
    private ArrayList<Edge> neightbours;

    public DijkstraAlgorithm(Graph directedGraph) {
        this.nodes = directedGraph.getNodes();
        this.edges = directedGraph.getEdges();
    }

    /**
     * Calculates the minimum cost to travel from a starting node to each other node.
     * @param start the starting node.
     */
    public void shortestPath(Node start) {
        visited = new HashSet<>();
        cost = new HashMap<>();
        cost.put(start.getStringId(), 0);
        Node node;

        while(true) {
            node = findNextNode(cost, visited);
            if(node == null) break; //Can't find next node? -> Finished.
            visited.add(node.getStringId());
            neightbours = getNeighbours(node);
            updateCost(node);
        }

        printCostTable(cost); //Display result
    }

    private void updateCost(Node node) {
        String neighbour;
        int neighbourWeight, sourceWeight, currentCost;

        for(Edge edge : neightbours) {
            if(!visited.contains(edge.getDestination().getId())) {
                neighbour = edge.getDestination().getStringId();
                neighbourWeight = edge.getWeight();
                sourceWeight = cost.get(node.getStringId());

                //Update only if the cost is lower.
                if(cost.containsKey(neighbour)) {
                    currentCost = cost.get(neighbour);
                    if(currentCost < neighbourWeight + sourceWeight  ) {
                        continue;
                    }
                }

                //Update table
                cost.put(neighbour, neighbourWeight + sourceWeight);
            }
        }
    }

    private ArrayList<Node> getNeighboursNodes(Node node) {
        ArrayList<Node> neighbours = new ArrayList<>();
        for (Edge edge : edges) {
            if (edge.getSource().equals(node)) {
                neighbours.add(edge.getDestination());
            }
        }
        return neighbours;
    }

    /**
     * @return a list of edges which has node as source.
     */
    private ArrayList<Edge> getNeighbours(Node node) {
        ArrayList<Edge> neighbours = new ArrayList<>();
        for (Edge edge : edges) {
            if (edge.getSource().equals(node)) {
                neighbours.add(edge);
            }
        }
        return neighbours;
    }

    /**
     * Finds the node which has the lowest cost and has not yet been visited by the algoritm.
     */
    private Node findNextNode(HashMap<String, Integer> cost, HashSet<String> visited) {
        int minValue = Integer.MAX_VALUE;
        String nodeId = null;
        for (Object o : cost.entrySet()) {
            Map.Entry pair = (Map.Entry) o;
            if (minValue > (int) pair.getValue() && !visited.contains(pair.getKey())) {
                minValue = (int) pair.getValue();
                nodeId = (String) pair.getKey();
            }

        }
        return findNodeById(nodeId);
    }

    private Node findNodeById(String id) {
        if(id == null) {
            return null;
        }
        for (Node node : nodes) {
            if (node.getStringId().equals(id)) {
                return node;
            }
        }
        return null;
    }

    private void printCostTable(HashMap<String, Integer> cost) {
        for (Object o : cost.entrySet()) {
            Map.Entry pair = (Map.Entry) o;
            System.out.println("Node " + pair.getKey() + ". cost: " + pair.getValue());
        }
    }
}
