package com.moveinsync.assignment.dto;


public class RouteStopRequest {

    private Long routeId;
    private Long stopId;
    private Integer sequenceNumber;
    private Integer travelTimeToNext;

    public Long getRouteId() { return routeId; }
    public Long getStopId() { return stopId; }
    public Integer getSequenceNumber() { return sequenceNumber; }
    public Integer getTravelTimeToNext() { return travelTimeToNext; }
}