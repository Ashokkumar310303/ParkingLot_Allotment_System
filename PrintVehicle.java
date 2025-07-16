package com.practice.ParkingLotSystem;

import java.util.List;

public class PrintVehicle {
  private final List<Vehicle> vehicleList;

  public PrintVehicle(List<Vehicle> vehicleList){
      this.vehicleList=vehicleList;
  }

  public void print(){
      for(Vehicle vehicle:vehicleList){
          System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -");
          System.out.println("Vehicle id:"+vehicle.getVehicleId());
          System.out.println("Number Plate:"+vehicle.getNumberPlate());
          System.out.println("Vehicle Name:"+vehicle.getVehicleName());
          System.out.println("Vehicle Owner Name:"+vehicle.getVehicleOwner());
          if(vehicle.getVehicleType()=='B'){
              System.out.println("Vehicle Type:"+"Bike");
          }
          else if(vehicle.getVehicleType()=='C'){
              System.out.println("Vehicle Type:"+"Car");
          }
          else{
              System.out.println("Vehicle Type:"+"Truck");
          }
          System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -");
      }
  }

}
