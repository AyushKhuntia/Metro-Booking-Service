package com.moveinsync.assignment.repository;



import com.moveinsync.assignment.entity.RouteStop;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RouteStopRepository extends JpaRepository<RouteStop, Long> {

    List<RouteStop> findByRouteIdOrderBySequenceNumber(Long routeId);
}