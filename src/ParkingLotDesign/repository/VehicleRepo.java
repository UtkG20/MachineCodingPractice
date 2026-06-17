package ParkingLotDesign.repository;

import ParkingLotDesign.models.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleRepo {

    private List<Vehicle> vehicles;

    public VehicleRepo(){
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

}
