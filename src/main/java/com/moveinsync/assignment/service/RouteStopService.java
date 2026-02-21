package com.moveinsync.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moveinsync.assignment.dto.RouteStopRequest;
import com.moveinsync.assignment.entity.Route;
import com.moveinsync.assignment.entity.RouteStop;
import com.moveinsync.assignment.entity.Stop;
import com.moveinsync.assignment.repository.RouteRepository;
import com.moveinsync.assignment.repository.RouteStopRepository;
import com.moveinsync.assignment.repository.StopRepository;
// used for admin can add stop to route with sequence number and travel time to next stop
@Service
public class RouteStopService {

    private final RouteStopRepository routeStopRepository;
    private final RouteRepository routeRepository;
    private final StopRepository stopRepository;

    public RouteStopService(RouteStopRepository routeStopRepository,
                            RouteRepository routeRepository,
                            StopRepository stopRepository) {
        this.routeStopRepository = routeStopRepository;
        this.routeRepository = routeRepository;
        this.stopRepository = stopRepository;
    }

    public RouteStop createRouteStop(RouteStopRequest request) {

        Route route = routeRepository.findById(request.getRouteId())
                .orElseThrow(() -> new RuntimeException("Route not found"));

        Stop stop = stopRepository.findById(request.getStopId())
                .orElseThrow(() -> new RuntimeException("Stop not found"));

        RouteStop routeStop = new RouteStop();
        routeStop.setRoute(route);
        routeStop.setStop(stop);
        routeStop.setSequenceNumber(request.getSequenceNumber());
        routeStop.setTravelTimeToNext(request.getTravelTimeToNext());

        return routeStopRepository.save(routeStop);
    }
}
