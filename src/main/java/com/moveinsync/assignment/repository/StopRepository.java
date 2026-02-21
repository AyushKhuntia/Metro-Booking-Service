package com.moveinsync.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moveinsync.assignment.entity.Stop;

import java.util.Optional;

public interface StopRepository extends JpaRepository<Stop, Long> {

    Optional<Stop> findByCode(String code);
}
