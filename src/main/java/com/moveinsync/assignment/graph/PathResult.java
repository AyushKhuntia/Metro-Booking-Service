package com.moveinsync.assignment.graph;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PathResult {

    private List<Long> stopIds;
    private int totalCost;
	public List<Long> getStopIds() {
		return stopIds;
	}
	public void setStopIds(List<Long> stopIds) {
		this.stopIds = stopIds;
	}
	public int getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	public PathResult(List<Long> stopIds, int totalCost) {
		super();
		this.stopIds = stopIds;
		this.totalCost = totalCost;
	}
	public PathResult() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}