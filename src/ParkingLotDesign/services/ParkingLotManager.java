package ParkingLotDesign.services;

import ParkingLotDesign.enums.SpotStatus;
import ParkingLotDesign.enums.VehicleType;
import ParkingLotDesign.models.Spot;
import ParkingLotDesign.repository.SpotRepo;

import java.util.UUID;

public class ParkingLotManager {

    private SpotRepo spotRepo;

    public ParkingLotManager(SpotRepo spotRepo) {
        this.spotRepo = spotRepo;
    }

    public void addNewSpot(VehicleType type){
        Spot spot = new Spot();
        spot.setId(UUID.randomUUID());
        spot.setType(type);
        spot.setStatus(ParkingLotDesign.enums.SpotStatus.AVAILABLE);
        this.spotRepo.addSpot(spot);
    }

    public UUID getAvailableSpot(VehicleType type){
        return this.spotRepo.getSpotsList().stream().filter(spot -> spot.getType().equals(type) && spot.getStatus().equals(SpotStatus.AVAILABLE))
                .findFirst()
                .map(Spot::getId)
                .orElse(null);
    }

    public void occupySpot(UUID spotId){
        Spot spot = this.spotRepo.getSpotWithId(spotId);

        spotRepo.updateSpotStatus(spot.getId(), SpotStatus.OCCUPIED);
    }

    public void unOccupySpot(UUID spotId){
        Spot spot = this.spotRepo.getSpotWithId(spotId);

        spotRepo.updateSpotStatus(spot.getId(), SpotStatus.AVAILABLE);
    }

    public Spot getSpotById(UUID id){
        return spotRepo.getSpotWithId(id);
    }

}
