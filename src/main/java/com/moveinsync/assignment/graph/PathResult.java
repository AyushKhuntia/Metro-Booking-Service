package com.moveinsync.assignment.graph;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
@Getter
@AllArgsConstructor
public class PathResult {

    private List<RouteSegment> segments;
    private List<Long> interchanges;
    private Long finalDestination;
    private int totalCost;
    private int totalTransfers;

    public PathResult() {}
    

	public List<RouteSegment> getSegments() {
		return segments;
	}

	public void setSegments(List<RouteSegment> segments) {
		this.segments = segments;
	}

	public List<Long> getInterchanges() {
		return interchanges;
	}

	public void setInterchanges(List<Long> interchanges) {
		this.interchanges = interchanges;
	}

	public Long getFinalDestination() {
		return finalDestination;
	}

	public void setFinalDestination(Long finalDestination) {
		this.finalDestination = finalDestination;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	public int getTotalTransfers() {
		return totalTransfers;
	}

	public void setTotalTransfers(int totalTransfers) {
		this.totalTransfers = totalTransfers;
	}

	public PathResult(List<RouteSegment> segments, List<Long> interchanges, Long finalDestination, int totalCost,
			int totalTransfers) {
		super();
		this.segments = segments;
		this.interchanges = interchanges;
		this.finalDestination = finalDestination;
		this.totalCost = totalCost;
		this.totalTransfers = totalTransfers;
	}
    
}