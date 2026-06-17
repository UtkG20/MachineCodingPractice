package ParkingLotDesign.models;

import ParkingLotDesign.enums.BookingStatus;

import java.util.UUID;

public class Booking {
    private UUID id;
    private UUID spotId;
    private String vehicleId;
    private Long startTime;
    private Long endTime;
    private BookingStatus status;

    public UUID getId() {
        return id;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public Long getEndTime() {
        return endTime;
    }

    public Long getStartTime() {
        return startTime;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public UUID getSpotId() {
        return spotId;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public void setSpotId(UUID spotId) {
        this.spotId = spotId;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }
}
