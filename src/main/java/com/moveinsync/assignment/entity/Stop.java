package com.moveinsync.assignment.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "stop")
public class Stop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String code;
    
    
    //Generate Getters and Setters

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Stop(Long id, String name, String code) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
	}
	public Stop() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Stop [id=" + id + ", name=" + name + ", code=" + code + "]";
	}
    
    
}