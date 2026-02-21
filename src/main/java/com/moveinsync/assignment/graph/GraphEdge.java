package com.moveinsync.assignment.graph;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GraphEdge {

    private Long toStopId;
    private Long routeId;
    private int travelTime;
	public Long getToStopId() {
		return toStopId;
	}
	public void setToStopId(Long toStopId) {
		this.toStopId = toStopId;
	}
	public Long getRouteId() {
		return routeId;
	}
	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}
	public int getTravelTime() {
		return travelTime;
	}
	public void setTravelTime(int travelTime) {
		this.travelTime = travelTime;
	}
	@Override
	public String toString() {
		return "GraphEdge [toStopId=" + toStopId + ", routeId=" + routeId + ", travelTime=" + travelTime + "]";
	}
	public GraphEdge() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GraphEdge(Long toStopId, Long routeId, int travelTime) {
		super();
		this.toStopId = toStopId;
		this.routeId = routeId;
		this.travelTime = travelTime;
	}
    
	
    
    
}