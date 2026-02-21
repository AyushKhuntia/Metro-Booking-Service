package com.moveinsync.assignment.service;

import com.moveinsync.assignment.dto.RouteRequest;
import com.moveinsync.assignment.entity.Route;
import com.moveinsync.assignment.entity.RouteStop;
import com.moveinsync.assignment.repository.RouteRepository;
import com.moveinsync.assignment.repository.RouteStopRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RouteService {

	@Autowired
    private RouteRepository routeRepository;
	@Autowired
    private RouteStopRepository routeStopRepository;

    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    public List<RouteStop> getRouteStops(Long routeId) {
        return routeStopRepository.findByRouteIdOrderBySequenceNumber(routeId);
    }
    public Route createRoute(RouteRequest request) {

        Route route = new Route();
        route.setName(request.getName());
        route.setColor(request.getColor());

        return routeRepository.save(route);
    }

}