package com.practice.ParkingLotSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CarAllotmentChange {
    private final List<Vehicle> carSlot;
    private final List<Vehicle> truckSlot;
    private final Map<Integer,String> vehicleMap;
    private final List<Vehicle> removableTruckSlot;

    public CarAllotmentChange(List<Vehicle> carSlot, List<Vehicle> truckSlot, Map<Integer,String> vehicleMap){
        this.carSlot=carSlot;
        this.truckSlot=truckSlot;
        this.vehicleMap=vehicleMap;
        this.removableTruckSlot=new ArrayList<>();
    }

    public void changeCar(){

        for(Vehicle vehicle:truckSlot){
            if(vehicle.getVehicleType()=='C' && CarParking.count+vehicle.getSize()<=ParkingAllocationSystem.carParkingSize){
                removableTruckSlot.add(vehicle);
                TruckParking.count-=vehicle.getSize();

                carSlot.add(vehicle);
                CarParking.count+=vehicle.getSize();

                vehicleMap.put(vehicle.getNumberPlate(),"CarParking");
            }
        }

        for(Vehicle vehicle:removableTruckSlot){
            truckSlot.remove(vehicle);
        }
    }
}
