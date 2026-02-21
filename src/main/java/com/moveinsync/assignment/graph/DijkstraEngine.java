package com.moveinsync.assignment.graph;


import java.util.*;

public class DijkstraEngine {

    private static final int TRANSFER_PENALTY = 5;

    public PathResult findShortestPath(
            MetroGraph graph,
            Long sourceId,
            Long destinationId) {

        PriorityQueue<State> pq =
                new PriorityQueue<>(Comparator.comparingInt(s -> s.cost));

        Map<Long, Integer> distance = new HashMap<>();
        Map<Long, Long> previous = new HashMap<>();

        pq.add(new State(sourceId, 0, null));
        distance.put(sourceId, 0);

        while (!pq.isEmpty()) {
            State current = pq.poll();

            if (current.stopId.equals(destinationId)) break;

            for (GraphEdge edge : graph.getEdges(current.stopId)) {

                int transferCost = 0;
                if (current.routeId != null &&
                        !current.routeId.equals(edge.getRouteId())) {
                    transferCost = TRANSFER_PENALTY;
                }

                int newCost = current.cost
                        + edge.getTravelTime()
                        + transferCost;

                if (newCost < distance.getOrDefault(
                        edge.getToStopId(),
                        Integer.MAX_VALUE)) {

                    distance.put(edge.getToStopId(), newCost);
                    previous.put(edge.getToStopId(), current.stopId);

                    pq.add(new State(
                            edge.getToStopId(),
                            newCost,
                            edge.getRouteId()
                    ));
                }
            }
        }

        if (!distance.containsKey(destinationId)) {
            throw new RuntimeException("No path found");
        }

        return buildPath(sourceId, destinationId,
                previous, distance.get(destinationId));
    }

    private PathResult buildPath(
            Long source,
            Long dest,
            Map<Long, Long> previous,
            int totalCost) {

        List<Long> path = new ArrayList<>();
        Long current = dest;

        while (current != null) {
            path.add(current);
            current = previous.get(current);
        }

        Collections.reverse(path);

        return new PathResult(path, totalCost);
    }

    private static class State {
        Long stopId;
        int cost;
        Long routeId;

        State(Long stopId, int cost, Long routeId) {
            this.stopId = stopId;
            this.cost = cost;
            this.routeId = routeId;
        }
    }
}