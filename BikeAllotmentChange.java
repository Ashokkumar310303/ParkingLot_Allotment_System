package com.practice.ParkingLotSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BikeAllotmentChange {
    private final List<Vehicle> bikeSlot;
    private final List<Vehicle> carSlot;
    private final List<Vehicle> truckSlot;
    private final Map<Integer,String> vehicleMap;
    private final List<Vehicle> removableVehicleCarSlot;
    private final List<Vehicle> removableVehicleTruckSlot;

    public BikeAllotmentChange(List<Vehicle> bikeSlot,List<Vehicle> carSlot,List<Vehicle> truckSlot,Map<Integer,String> vehicleMap){
        this.bikeSlot=bikeSlot;
        this.carSlot=carSlot;
        this.truckSlot=truckSlot;
        this.vehicleMap=vehicleMap;
        this.removableVehicleCarSlot=new ArrayList<>();
        this.removableVehicleTruckSlot=new ArrayList<>();
    }



    public void changeBike(){
        for(Vehicle vehicle:carSlot){
            if(vehicle.getVehicleType()=='B' && BikeParking.count+vehicle.getSize()<=ParkingAllocationSystem.bikeParkingSize){
                removableVehicleCarSlot.add(vehicle);
                CarParking.count-=vehicle.getSize();

                bikeSlot.add(vehicle);
                BikeParking.count+=vehicle.getSize();
                vehicleMap.put(vehicle.getNumberPlate(),"BikeParking");
            }

        }

        for(Vehicle vehicle:truckSlot){
            if(vehicle.getVehicleType()=='B' && BikeParking.count+vehicle.getSize()<=ParkingAllocationSystem.bikeParkingSize){
                removableVehicleTruckSlot.add(vehicle);
                TruckParking.count-=vehicle.getSize();

                bikeSlot.add(vehicle);
                BikeParking.count+=vehicle.getSize();
                vehicleMap.put(vehicle.getNumberPlate(),"BikeParking");
            }
            else if(vehicle.getVehicleType()=='B' && CarParking.count+vehicle.getSize()<=ParkingAllocationSystem.carParkingSize){
                removableVehicleTruckSlot.add(vehicle);
                TruckParking.count-=vehicle.getSize();

                carSlot.add(vehicle);
                CarParking.count+=vehicle.getSize();
                vehicleMap.put(vehicle.getNumberPlate(),"CarParking");
            }
        }

        for(Vehicle vehicle:removableVehicleCarSlot){
            carSlot.remove(vehicle);
        }

        for(Vehicle vehicle:removableVehicleTruckSlot){
            truckSlot.remove(vehicle);
        }
    }



}
