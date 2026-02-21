package com.moveinsync.assignment.graph;


import java.util.*;

public class MetroGraph {

    private final Map<Long, List<GraphEdge>> adjacencyList = new HashMap<>();

    public void addEdge(Long from, GraphEdge edge) {
        adjacencyList
                .computeIfAbsent(from, k -> new ArrayList<>())
                .add(edge);
    }

    public List<GraphEdge> getEdges(Long stopId) {
        return adjacencyList.getOrDefault(stopId, Collections.emptyList());
    }

    public Set<Long> getAllStops() {
        return adjacencyList.keySet();
    }
}