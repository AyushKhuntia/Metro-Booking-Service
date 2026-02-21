package com.moveinsync.assignment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moveinsync.assignment.dto.RouteRequest;
import com.moveinsync.assignment.dto.RouteStopRequest;
import com.moveinsync.assignment.dto.StopRequest;
import com.moveinsync.assignment.entity.Route;
import com.moveinsync.assignment.entity.RouteStop;
import com.moveinsync.assignment.entity.Stop;
import com.moveinsync.assignment.service.RouteService;
import com.moveinsync.assignment.service.RouteStopService;
import com.moveinsync.assignment.service.StopService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	private final StopService stopService;
    private final RouteService routeService;
    private final RouteStopService routeStopService;

    public AdminController(StopService stopService,
                           RouteService routeService,
                           RouteStopService routeStopService) {
        this.stopService = stopService;
        this.routeService = routeService;
        this.routeStopService = routeStopService;
    }
    @GetMapping("/hello")
    public String hello() {
		return "Hello, Admin!";
	}
    @PostMapping("/stop")
    public ResponseEntity<Stop> addStop(@RequestBody StopRequest request) {
        return ResponseEntity.ok(
                stopService.createStop(request)
        );
    }

    @PostMapping("/route")
    public ResponseEntity<Route> addRoute(@RequestBody RouteRequest request) {
        return ResponseEntity.ok(
                routeService.createRoute(request)
        );
    }

    // 3️⃣ Add RouteStop
    @PostMapping("/route-stop")
    public ResponseEntity<RouteStop> addRouteStop(@RequestBody RouteStopRequest request) {
        return ResponseEntity.ok(
                routeStopService.createRouteStop(request)
        );
    }
}
