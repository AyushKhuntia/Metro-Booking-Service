package com.moveinsync.assignment.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "route")

public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String color;

    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
    private List<RouteStop> routeStops;
    // Generate Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public List<RouteStop> getRouteStops() {
		return routeStops;
	}

	public void setRouteStops(List<RouteStop> routeStops) {
		this.routeStops = routeStops;
	}

	public Route(Long id, String name, String color, List<RouteStop> routeStops) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.routeStops = routeStops;
	}

	public Route() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
    
}