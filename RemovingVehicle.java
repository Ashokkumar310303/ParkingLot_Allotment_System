package com.practice.ParkingLotSystem;

import java.util.List;
import java.util.Map;

public class RemovingVehicle {
    private final List<Vehicle> vehicleList;
    private final Map<Integer,String> vehicleMap;
    private final int numberPlate;

    public RemovingVehicle(List<Vehicle> vehicleList,Map<Integer,String> vehicleMap,int numberPlate){
        this.vehicleList=vehicleList;
        this.numberPlate=numberPlate;
        this.vehicleMap=vehicleMap;
    }

    public int removeVehicle(){
        int vehicleSize=0;
        for(Vehicle vehicle:vehicleList){
            if(numberPlate==vehicle.getNumberPlate()){
                vehicleSize=vehicle.getSize();
                vehicleList.remove(vehicle);
                vehicleMap.remove(vehicle.getNumberPlate());
                return vehicleSize;
            }
        }
        return 0;
    }

}
