package ParkingLotDesign.services;

import ParkingLotDesign.enums.BookingStatus;
import ParkingLotDesign.enums.VehicleType;
import ParkingLotDesign.models.Booking;
import ParkingLotDesign.models.Spot;
import ParkingLotDesign.repository.BookingsRepo;

import java.util.List;
import java.util.UUID;

public class BookingManager {
    private BookingsRepo bookingsRepo;
    private ParkingLotManager parkingLotManager;

    public BookingManager(BookingsRepo bookingsRepo, ParkingLotManager parkingLotManager){
        this.bookingsRepo = bookingsRepo;
        this.parkingLotManager = parkingLotManager;
    }

    public UUID createBooking(String vehicleId, UUID spotId){
        Booking booking = new Booking();
        booking.setId(UUID.randomUUID());
        booking.setStatus(BookingStatus.ACTIVE);
        booking.setStartTime(System.currentTimeMillis());
        booking.setVehicleId(vehicleId);
        booking.setSpotId(spotId);

        this.bookingsRepo.addBooking(booking);
        parkingLotManager.occupySpot(spotId);
        return booking.getId();
    }

    public void terminateBooking(UUID id){
        Booking booking = bookingsRepo.getBookingById(id);
        if(booking == null){
            throw new RuntimeException("Booking not found");
        }
        booking.setStatus(BookingStatus.COMPLETED);
        bookingsRepo.updateBooking(booking);
        parkingLotManager.unOccupySpot(booking.getSpotId());
    }

    public List<UUID> getAllBookingsbyType(VehicleType type){
        return bookingsRepo.getBookingsList().stream().filter(booking -> {
            Spot spot = parkingLotManager.getSpotById(booking.getSpotId());
            return spot.getType().equals(type);
        }).map(Booking::getId).toList();

    }
}
