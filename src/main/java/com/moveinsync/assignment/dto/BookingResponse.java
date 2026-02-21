package com.moveinsync.assignment.dto;
import com.moveinsync.assignment.entity.Booking;

import java.time.LocalDateTime;

public class BookingResponse {

    private String bookingReference;
    private String source;
    private String destination;
    private Integer totalTravelTime;
    private Integer totalTransfers;
    private String routeSummary;
    private String qrString;
    private String status;
    private LocalDateTime createdAt;

    public static BookingResponse from(Booking booking) {
        BookingResponse response = new BookingResponse();
        response.bookingReference = booking.getBookingReference();
        response.source = booking.getSourceStop().getCode();
        response.destination = booking.getDestinationStop().getCode();
        response.totalTravelTime = booking.getTotalTravelTime();
        response.totalTransfers = booking.getTotalTransfers();
        response.routeSummary = booking.getRouteSummary();
        response.qrString = booking.getQrString();
        response.status = booking.getStatus();
        response.createdAt = booking.getCreatedAt();
        return response;
    }

	public String getBookingReference() {
		return bookingReference;
	}

	public void setBookingReference(String bookingReference) {
		this.bookingReference = bookingReference;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Integer getTotalTravelTime() {
		return totalTravelTime;
	}

	public void setTotalTravelTime(Integer totalTravelTime) {
		this.totalTravelTime = totalTravelTime;
	}

	public Integer getTotalTransfers() {
		return totalTransfers;
	}

	public void setTotalTransfers(Integer totalTransfers) {
		this.totalTransfers = totalTransfers;
	}

	public String getRouteSummary() {
		return routeSummary;
	}

	public void setRouteSummary(String routeSummary) {
		this.routeSummary = routeSummary;
	}

	public String getQrString() {
		return qrString;
	}

	public void setQrString(String qrString) {
		this.qrString = qrString;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

    // getters
    
}