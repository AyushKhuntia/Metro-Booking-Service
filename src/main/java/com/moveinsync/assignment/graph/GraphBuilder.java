package com.moveinsync.assignment.graph;


import com.moveinsync.assignment.entity.Route;
import com.moveinsync.assignment.entity.RouteStop;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GraphBuilder {

    public MetroGraph buildGraph(
            List<Route> routes,
            java.util.function.Function<Long, List<RouteStop>> routeStopFetcher) {

        MetroGraph graph = new MetroGraph();

        for (Route route : routes) {

            List<RouteStop> stops =
                    routeStopFetcher.apply(route.getId());

            for (int i = 0; i < stops.size() - 1; i++) {

                RouteStop current = stops.get(i);
                RouteStop next = stops.get(i + 1);

                graph.addEdge(
                        current.getStop().getId(),
                        new GraphEdge(
                                next.getStop().getId(),
                                route.getId(),
                                current.getTravelTimeToNext() != null
                                        ? current.getTravelTimeToNext()
                                        : 1
                        )
                );

                graph.addEdge(
                        next.getStop().getId(),
                        new GraphEdge(
                                current.getStop().getId(),
                                route.getId(),
                                current.getTravelTimeToNext() != null
                                        ? current.getTravelTimeToNext()
                                        : 1
                        )
                );
            }
        }

        return graph;
    }
}
