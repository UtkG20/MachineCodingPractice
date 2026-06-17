package ParkingLotDesign;

import ParkingLotDesign.enums.VehicleType;
import ParkingLotDesign.repository.BookingsRepo;
import ParkingLotDesign.repository.SpotRepo;
import ParkingLotDesign.services.BookingManager;
import ParkingLotDesign.services.ParkingLotManager;

import java.util.List;
import java.util.UUID;

public class main {
    public static void main(String[] args) {
        SpotRepo spotRepo = new SpotRepo();
        ParkingLotManager parkingLotManager = new ParkingLotManager(spotRepo);
        BookingsRepo bookingsRepo = new BookingsRepo();
        BookingManager bookingManager = new BookingManager(bookingsRepo, parkingLotManager);

        for(int i =0; i<10;i++){
            parkingLotManager.addNewSpot(VehicleType.CAR);
        }

        for(int i =0; i<20;i++){
            parkingLotManager.addNewSpot(VehicleType.BIKE);
        }

        for(int i =0; i<5;i++){
            parkingLotManager.addNewSpot(VehicleType.TRUCK);
        }

        System.out.println("Available spot : " + parkingLotManager.getAvailableSpot(VehicleType.BIKE));

        for(int i =0; i<10;i++){
            UUID bookingId = bookingManager.createBooking(String.valueOf(i), parkingLotManager.getAvailableSpot(VehicleType.CAR));
            System.out.println("Booking created with id : "+ bookingId);
        }

        System.out.println("Available spot : " + parkingLotManager.getAvailableSpot(VehicleType.CAR));

        List<UUID> bookings = bookingManager.getAllBookingsbyType(VehicleType.CAR);

        bookingManager.terminateBooking(bookings.get(0));

        System.out.println("Available spot after terminating : " + parkingLotManager.getAvailableSpot(VehicleType.CAR));

        bookingManager.terminateBooking(UUID.randomUUID());

        System.out.println(bookings.get(0));
    }
}
