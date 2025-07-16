package com.practice.ParkingLotSystem;

import java.util.List;
import java.util.Map;

public class BikeParking {
    public static int count=0;
    private final Vehicle currentVehicle;
    private final List<Vehicle> bikeSlot;
    private final Map<Integer,String> vehicleMap;

    public BikeParking(List<Vehicle> bikeSlot, Vehicle currentVehicle, Map<Integer,String> vehicleMap){
        this.bikeSlot=bikeSlot;
        this.currentVehicle=currentVehicle;
        this.vehicleMap=vehicleMap;
    }

    public boolean isBikeSpaceAvailable(){
        return count+currentVehicle.getSize()<=ParkingAllocationSystem.bikeParkingSize;
    }

    public void addBike(){
        count+=currentVehicle.getSize();
        bikeSlot.add(currentVehicle);
        vehicleMap.put(currentVehicle.getNumberPlate(),"BikeParking");
    }







}
