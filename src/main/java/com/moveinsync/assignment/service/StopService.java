package com.moveinsync.assignment.service;

import com.moveinsync.assignment.dto.StopRequest;
import com.moveinsync.assignment.entity.Stop;
import com.moveinsync.assignment.repository.StopRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StopService {
	
	@Autowired
    private  StopRepository stopRepository;

    public Stop getStopByCode(String code) {
        return stopRepository.findByCode(code)
                .orElseThrow(() -> new RuntimeException("Stop not found: " + code));
    }

    public Stop getStopById(Long id) {
        return stopRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stop not found: " + id));
    }
    public Stop createStop(StopRequest request) {

        Stop stop = new Stop();
        stop.setName(request.getName());
        stop.setCode(request.getCode());

        return stopRepository.save(stop);
    }
}