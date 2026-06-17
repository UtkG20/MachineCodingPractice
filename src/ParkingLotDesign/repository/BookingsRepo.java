package ParkingLotDesign.repository;

import ParkingLotDesign.models.Booking;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookingsRepo {
    private List<Booking> bookingsList;

    public BookingsRepo() {
        this.bookingsList = new ArrayList<>();
    }

    public void addBooking(Booking booking) {
        this.bookingsList.add(booking);
    }

    public List<Booking> getBookingsList(){
        return this.bookingsList;
    }

    public Booking getBookingById(UUID id){
        return this.bookingsList.stream()
                .filter(booking -> booking.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void updateBooking(Booking booking){
        bookingsList.stream().filter(book -> book.getId().equals(booking.getId()))
                .findFirst()
                .ifPresent(book -> {
                    book.setSpotId(booking.getSpotId());
                    book.setVehicleId(booking.getVehicleId());
                    book.setStartTime(booking.getStartTime());
                    book.setEndTime(booking.getEndTime());
                    book.setStatus(booking.getStatus());
                });
    }
}
