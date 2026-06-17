package ParkingLotDesign.models;

import ParkingLotDesign.enums.SpotStatus;
import ParkingLotDesign.enums.VehicleType;

import java.util.UUID;

public class Spot {
    private UUID id;
    private VehicleType type;
    private SpotStatus status;

    public SpotStatus getStatus() {
        return status;
    }

    public VehicleType getType() {
        return type;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setStatus(SpotStatus status) {
        this.status = status;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }
}
