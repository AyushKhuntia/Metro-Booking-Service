package com.moveinsync.assignment.service;


import com.moveinsync.assignment.entity.Booking;
import com.moveinsync.assignment.entity.Stop;
import com.moveinsync.assignment.repository.BookingRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookingService {

	@Autowired
    private StopService stopService;
	
	@Autowired
    private BookingRepository bookingRepository;
    
	@Autowired
    private PathOptimizationService pathService;
	
	@Autowired
    private QRService qrService;

    public Booking createBooking(String sourceCode, String destinationCode) {

        Stop source = stopService.getStopByCode(sourceCode);
        Stop destination = stopService.getStopByCode(destinationCode);

        if (source.getId().equals(destination.getId())) {
            throw new RuntimeException("Source and destination cannot be same");
        }

        var pathResult = pathService.findOptimalPath(source.getId(), destination.getId());

        String bookingRef = UUID.randomUUID().toString();

        Booking booking = Booking.builder()
                .bookingReference(bookingRef)
                .sourceStop(source)
                .destinationStop(destination)
                .totalTravelTime(pathResult.getTotalCost())
                .totalTransfers(0) // can enhance later
                .routeSummary(pathResult.getStopIds().toString())
                .status("CONFIRMED")
                .createdAt(LocalDateTime.now())
                .build();

        String qr = qrService.generateQRString(bookingRef);
        booking.setQrString(qr);

        return bookingRepository.save(booking);
    }


}