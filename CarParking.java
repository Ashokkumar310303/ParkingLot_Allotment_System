package com.practice.ParkingLotSystem;

import java.util.List;
import java.util.Map;

public class CarParking {
    public static int count=0;
    private final Vehicle currentVehicle;
    private final List<Vehicle> carSlot;
    private final Map<Integer,String> vehicleMap;

    public CarParking(List<Vehicle> carSlot,Vehicle currentVehicle,Map<Integer,String> vehicleMap){
        this.carSlot=carSlot;
        this.currentVehicle=currentVehicle;
        this.vehicleMap=vehicleMap;
    }

    public boolean isCarSpaceAvailable(){
        return count+currentVehicle.getSize()<=ParkingAllocationSystem.carParkingSize;
    }

    public void addCar(){
        count+=currentVehicle.getSize();
        carSlot.add(currentVehicle);
        vehicleMap.put(currentVehicle.getNumberPlate(),"CarParking");
    }
}
