package ParkingLotDesign.repository;

import ParkingLotDesign.enums.SpotStatus;
import ParkingLotDesign.models.Spot;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SpotRepo {

    private List<Spot> spotsList;

    public SpotRepo() {
        this.spotsList = new ArrayList<>();
    }

    public void addSpot(Spot spot) {
        this.spotsList.add(spot);
    }

    public List<Spot> getSpotsList(){
        return this.spotsList;
    }

    public Spot getSpotWithId(UUID spotId){
        return this.spotsList.stream().filter(spot -> spot.getId().equals(spotId))
                .findFirst()
                .orElse(null);
    }

    public void updateSpotStatus(UUID spotId, SpotStatus status){
        Spot spot = getSpotWithId(spotId);
        if(spot != null){
            spot.setStatus(status);
        }
    }

}
