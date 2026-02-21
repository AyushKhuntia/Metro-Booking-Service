package com.moveinsync.assignment.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "route_stop",
       uniqueConstraints = @UniqueConstraint(columnNames = {"route_id", "sequence_number"}))
public class RouteStop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false)
    private Route route;

    @ManyToOne
    @JoinColumn(name = "stop_id", nullable = false)
    private Stop stop;

    @Column(nullable = false)
    private Integer sequenceNumber;

    private Integer travelTimeToNext;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public Stop getStop() {
		return stop;
	}

	public void setStop(Stop stop) {
		this.stop = stop;
	}

	public Integer getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(Integer sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public Integer getTravelTimeToNext() {
		return travelTimeToNext;
	}

	public void setTravelTimeToNext(Integer travelTimeToNext) {
		this.travelTimeToNext = travelTimeToNext;
	}

	public RouteStop(Long id, Route route, Stop stop, Integer sequenceNumber, Integer travelTimeToNext) {
		super();
		this.id = id;
		this.route = route;
		this.stop = stop;
		this.sequenceNumber = sequenceNumber;
		this.travelTimeToNext = travelTimeToNext;
	}

	@Override
	public String toString() {
		return "RouteStop [id=" + id + ", route=" + route + ", stop=" + stop + ", sequenceNumber=" + sequenceNumber
				+ ", travelTimeToNext=" + travelTimeToNext + "]";
	}

	public RouteStop() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}