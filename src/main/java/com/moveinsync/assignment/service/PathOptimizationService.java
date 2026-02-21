package com.moveinsync.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moveinsync.assignment.graph.DijkstraEngine;
import com.moveinsync.assignment.graph.GraphBuilder;
import com.moveinsync.assignment.graph.MetroGraph;
import com.moveinsync.assignment.graph.PathResult;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PathOptimizationService {

	@Autowired
    private RouteService routeService;
	
	@Autowired
    private GraphBuilder graphBuilder;

    private MetroGraph metroGraph;
    private final DijkstraEngine engine = new DijkstraEngine();

    @PostConstruct
    public void loadGraph() {

        metroGraph = graphBuilder.buildGraph(
                routeService.getAllRoutes(),
                routeId -> routeService.getRouteStops(routeId)
        );
    }

    public PathResult findOptimalPath(Long source, Long dest) {
        return engine.findShortestPath(metroGraph, source, dest);
    }
}
