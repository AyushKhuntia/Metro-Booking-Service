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

        Map<Long, Integer> bestCost = new HashMap<>();
        Map<Long, Long> previous = new HashMap<>();
        Map<Long, Long> routeTaken = new HashMap<>();

        // Start state
        State start = new State(sourceId, 0, 0, null);
        pq.add(start);
        bestCost.put(sourceId, 0);

        while (!pq.isEmpty()) {

            State current = pq.poll();

            if (current.stopId.equals(destinationId)) {
                break;
            }

            for (GraphEdge edge : graph.getEdges(current.stopId)) {

                int newTravelTime =
                        current.travelTime + edge.getTravelTime();

                int newTransfers = current.transfers;

                // Check transfer
                if (current.routeId != null &&
                        !current.routeId.equals(edge.getRouteId())) {
                    newTransfers++;
                }

                int newCost =
                        newTravelTime + (newTransfers * TRANSFER_PENALTY);

                if (newCost < bestCost.getOrDefault(
                        edge.getToStopId(),
                        Integer.MAX_VALUE)) {

                    bestCost.put(edge.getToStopId(), newCost);
                    previous.put(edge.getToStopId(), current.stopId);
                    routeTaken.put(edge.getToStopId(), edge.getRouteId());

                    pq.add(new State(
                            edge.getToStopId(),
                            newTravelTime,
                            newTransfers,
                            edge.getRouteId()
                    ));
                }
            }
        }

        if (!bestCost.containsKey(destinationId)) {
            throw new RuntimeException("No path found");
        }

        return buildPath(
                sourceId,
                destinationId,
                previous,
                routeTaken,
                bestCost.get(destinationId)
        );
    }

    private PathResult buildPath(
            Long source,
            Long dest,
            Map<Long, Long> previous,
            Map<Long, Long> routeTaken,
            int totalCost) {

        List<Long> stops = new ArrayList<>();
        List<Long> routes = new ArrayList<>();

        Long current = dest;

        while (current != null) {
            stops.add(current);
            routes.add(routeTaken.get(current));
            current = previous.get(current);
        }

        Collections.reverse(stops);
        Collections.reverse(routes);

        List<RouteSegment> segments = new ArrayList<>();
        List<Long> interchanges = new ArrayList<>();

        Long currentRoute = null;
        List<Long> segmentStops = new ArrayList<>();

        for (int i = 0; i < stops.size(); i++) {

            Long stop = stops.get(i);
            Long route = routes.get(i);

            if (currentRoute == null) {
                currentRoute = route;
            }

            // Transfer detected
            if (route != null && !route.equals(currentRoute)) {

                // Save previous segment
                segments.add(new RouteSegment(currentRoute,
                        new ArrayList<>(segmentStops)));

                interchanges.add(stop);

                segmentStops.clear();
                currentRoute = route;
            }

            segmentStops.add(stop);
        }

        // Add last segment
        if (!segmentStops.isEmpty()) {
            segments.add(new RouteSegment(currentRoute,
                    segmentStops));
        }

        int transfers = interchanges.size();

        return new PathResult(
                segments,
                interchanges,
                dest,
                totalCost,
                transfers
        );
    }
    private static class State {

        Long stopId;
        int travelTime;
        int transfers;
        int cost;
        Long routeId;

        State(Long stopId,
              int travelTime,
              int transfers,
              Long routeId) {

            this.stopId = stopId;
            this.travelTime = travelTime;
            this.transfers = transfers;
            this.routeId = routeId;

            this.cost =
                    travelTime + (transfers * TRANSFER_PENALTY);
        }
    }
    
}
