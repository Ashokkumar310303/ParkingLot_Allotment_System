package com.practice.ParkingLotSystem;

import java.util.Map;

public class ParkingSlotDetails {
    private final Map<Integer,String> vehicleMap;

    public ParkingSlotDetails(Map<Integer,String> vehicleMap){
        this.vehicleMap=vehicleMap;
    }

    public boolean isAvailable(int numberPlate){
        return vehicleMap.containsKey(numberPlate);
    }
    public String getParking(int numberPlate){
        if(vehicleMap.containsKey(numberPlate)){
            return "Your vehicle was in the "+ vehicleMap.get(numberPlate);
        }
        return "There is no vehicle with the give number plate";

    }
}
