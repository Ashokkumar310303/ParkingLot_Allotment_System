package com.practice.ParkingLotSystem;

import java.util.List;
import java.util.Map;

public class TruckParking {
    public static int count=0;
    private final Vehicle currentVehicle;
    private final List<Vehicle> truckSlot;
    private final Map<Integer,String> vehicleMap;

    public TruckParking(List<Vehicle> truckSlot,Vehicle currentVehicle,Map<Integer,String> vehicleMap){
        this.currentVehicle=currentVehicle;
        this.truckSlot=truckSlot;
        this.vehicleMap=vehicleMap;
    }

    public boolean isTruckSpaceAvailable(){
        return count+currentVehicle.getSize()<=ParkingAllocationSystem.truckParkingSize;
    }

    public void addTruck(){
        count+=currentVehicle.getSize();
        truckSlot.add(currentVehicle);
        vehicleMap.put(currentVehicle.getNumberPlate(),"TruckParking");
    }
}
