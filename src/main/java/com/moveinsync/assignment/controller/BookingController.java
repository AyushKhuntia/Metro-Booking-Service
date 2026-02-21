package com.moveinsync.assignment.controller;
import com.moveinsync.assignment.dto.BookingRequest;
import com.moveinsync.assignment.dto.BookingResponse;
import com.moveinsync.assignment.entity.Booking;
import com.moveinsync.assignment.entity.Stop;
import com.moveinsync.assignment.service.BookingService;
import com.moveinsync.assignment.service.StopService;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

	@Autowired
    private  BookingService bookingService;
	@Autowired
	private  StopService stopService;
	
	@GetMapping("/{code}")
	public Stop getStopByCode(@PathVariable("code") String code) {
		System.out.println("Received request for stop code: " + code);
		return stopService.getStopByCode(code);
	}
    @PostMapping
    public Booking createBooking(
            @RequestBody BookingRequest request) {

        Booking booking = bookingService.createBooking(
                request.getSourceCode(),
                request.getDestinationCode()
        );
        return booking;

//        BookingResponse response = BookingResponse.from(booking);
//
//        return ResponseEntity.ok(response);
    }
}