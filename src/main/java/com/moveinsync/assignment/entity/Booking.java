package com.moveinsync.assignment.entity;

import jakarta.persistence.*;
import lombok.Builder;

import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String bookingReference;

    @ManyToOne
    @JoinColumn(name = "source_stop_id", nullable = false)
    private Stop sourceStop;

    @ManyToOne
    @JoinColumn(name = "destination_stop_id", nullable = false)
    private Stop destinationStop;

    private Integer totalTravelTime;

    private Integer totalTransfers;

    @Lob
    private String routeSummary;

    @Lob
    private String qrString;

    private String status;

    private LocalDateTime createdAt;
    
    private Booking(Builder builder) {
        this.bookingReference = builder.bookingReference;
        this.sourceStop = builder.sourceStop;
        this.destinationStop = builder.destinationStop;
        this.totalTravelTime = builder.totalTravelTime;
        this.totalTransfers = builder.totalTransfers;
        this.routeSummary = builder.routeSummary;
        this.qrString = builder.qrString;
        this.status = builder.status;
        this.createdAt = builder.createdAt;
    }
    public static Builder builder() {
        return new Builder();
    }
    public static class Builder {

        private String bookingReference;
        private Stop sourceStop;
        private Stop destinationStop;
        private Integer totalTravelTime;
        private Integer totalTransfers;
        private String routeSummary;
        private String qrString;
        private String status;
        private LocalDateTime createdAt;

        public Builder bookingReference(String bookingReference) {
            this.bookingReference = bookingReference;
            return this;
        }

        public Builder sourceStop(Stop sourceStop) {
            this.sourceStop = sourceStop;
            return this;
        }

        public Builder destinationStop(Stop destinationStop) {
            this.destinationStop = destinationStop;
            return this;
        }

        public Builder totalTravelTime(Integer totalTravelTime) {
            this.totalTravelTime = totalTravelTime;
            return this;
        }

        public Builder totalTransfers(Integer totalTransfers) {
            this.totalTransfers = totalTransfers;
            return this;
        }

        public Builder routeSummary(String routeSummary) {
            this.routeSummary = routeSummary;
            return this;
        }

        public Builder qrString(String qrString) {
            this.qrString = qrString;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Booking build() {
            return new Booking(this);
        }
    }


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookingReference() {
		return bookingReference;
	}

	public void setBookingReference(String bookingReference) {
		this.bookingReference = bookingReference;
	}

	public Stop getSourceStop() {
		return sourceStop;
	}

	public void setSourceStop(Stop sourceStop) {
		this.sourceStop = sourceStop;
	}

	public Stop getDestinationStop() {
		return destinationStop;
	}

	public void setDestinationStop(Stop destinationStop) {
		this.destinationStop = destinationStop;
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

	@Override
	public String toString() {
		return "Booking [id=" + id + ", bookingReference=" + bookingReference + ", sourceStop=" + sourceStop
				+ ", destinationStop=" + destinationStop + ", totalTravelTime=" + totalTravelTime + ", totalTransfers="
				+ totalTransfers + ", routeSummary=" + routeSummary + ", qrString=" + qrString + ", status=" + status
				+ ", createdAt=" + createdAt + "]";
	}

	public Booking(Long id, String bookingReference, Stop sourceStop, Stop destinationStop, Integer totalTravelTime,
			Integer totalTransfers, String routeSummary, String qrString, String status, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.bookingReference = bookingReference;
		this.sourceStop = sourceStop;
		this.destinationStop = destinationStop;
		this.totalTravelTime = totalTravelTime;
		this.totalTransfers = totalTransfers;
		this.routeSummary = routeSummary;
		this.qrString = qrString;
		this.status = status;
		this.createdAt = createdAt;
	}

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}