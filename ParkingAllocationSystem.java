package com.practice.ParkingLotSystem;

import java.util.*;

public class ParkingAllocationSystem {
    public static  int bikeParkingSize=0;
    public static int carParkingSize=0;
    public static int truckParkingSize=0;


    private final List<Vehicle> bikeSlot;
    private final List<Vehicle> carSlot;
    private final List<Vehicle> truckSlot;

    private final Map<Integer,String> vehicleMap;


    public ParkingAllocationSystem(int bikeParkingSize,int carParkingSize,int truckParkingSize){

        ParkingAllocationSystem.bikeParkingSize =bikeParkingSize;
        ParkingAllocationSystem.carParkingSize=(carParkingSize * 4);
        ParkingAllocationSystem.truckParkingSize=(truckParkingSize * 8);

        bikeSlot=new ArrayList<>();
        carSlot=new ArrayList<>();
        truckSlot=new ArrayList<>();
        vehicleMap=new HashMap<>();

    }

    public void parkVehicle(Vehicle currentVehicle){
        char type=currentVehicle.getVehicleType();
        BikeParking bike=new BikeParking(bikeSlot,currentVehicle,vehicleMap);
        CarParking car=new CarParking(carSlot,currentVehicle,vehicleMap);
        TruckParking truck=new TruckParking(truckSlot,currentVehicle,vehicleMap);


        if(type=='B'){
            if(bike.isBikeSpaceAvailable()){
                bike.addBike();
                System.out.println("Your bike was parked Successfully in the bike parking :)");
            }
            else if(car.isCarSpaceAvailable()){
                car.addCar();
                System.out.println("Your bike was parked Successfully in the car parking :)");
            }
            else if(truck.isTruckSpaceAvailable()){
                truck.addTruck();
                System.out.println("Your bike was parked Successfully in the truck parking :)");
            }
            else{
                System.out.println("Sorry there is no space for your bike in our parking right now");
            }
        }
        if(type=='C'){
            if(car.isCarSpaceAvailable()){
                car.addCar();
                System.out.println("Your car was parked successfully in the car parking :)");
            }
            else if(truck.isTruckSpaceAvailable()){
                truck.addTruck();
                System.out.println("Your car was parked successfully in the truck parking :)");
            }
            else{
                System.out.println("Sorry there is no space for your car in our parking right now");
            }

        }
        if(type=='T' && truck.isTruckSpaceAvailable()){
            truck.addTruck();
            System.out.println("Your truck was parked successfully in the truck parking :)");
        }
        else if(type=='T' && !truck.isTruckSpaceAvailable()){
            System.out.println("Sorry there is no space for your truck in our parking right now");
        }
    }

    public void removeVehicle(int numberPlate){

        if(vehicleMap.containsKey(numberPlate)){
            String parkingLot=vehicleMap.get(numberPlate);
            int vehicleSize=0;

            if(Objects.equals(parkingLot, "BikeParking")){
                RemovingVehicle remove=new RemovingVehicle(bikeSlot,vehicleMap,numberPlate);
                vehicleSize=remove.removeVehicle();
                BikeParking.count-=vehicleSize;
                BikeAllotmentChange bike=new BikeAllotmentChange(bikeSlot,carSlot,truckSlot,vehicleMap);
                bike.changeBike();
                CarAllotmentChange car=new CarAllotmentChange(carSlot,truckSlot,vehicleMap);
                car.changeCar();
                System.out.println("Your vehicle was removed from the bike parking");
            }

            else if(Objects.equals(parkingLot, "CarParking")){
                RemovingVehicle remove=new RemovingVehicle(carSlot,vehicleMap,numberPlate);
                vehicleSize=remove.removeVehicle();
                CarParking.count-=vehicleSize;
                CarAllotmentChange car=new CarAllotmentChange(carSlot,truckSlot,vehicleMap);
                car.changeCar();
                System.out.println("Your vehicle was removed from the car parking");
            }

            else{
                RemovingVehicle remove=new RemovingVehicle(truckSlot,vehicleMap,numberPlate);
                vehicleSize=remove.removeVehicle();
                TruckParking.count-=vehicleSize;
                System.out.println("Your vehicle was removed from the truck parking");
            }
        }
        else{
            Vehicle.setIdGenerator();
            System.out.println("Sorry there is no vehicle in that number Plate");
        }
    }

    public void printAllocation(String vehicle){

        if(vehicle.equals("Bike")){
            System.out.println("-----------------------------------------------------");
            System.out.println("Bike Parking Area");
            System.out.println("-----------------------------------------------------");
            PrintVehicle bike=new PrintVehicle(bikeSlot);
            bike.print();
        }
        else if(vehicle.equals("Car")){
            System.out.println("-----------------------------------------------------");
            System.out.println("Car Parking Area");
            System.out.println("-----------------------------------------------------");
            PrintVehicle car=new PrintVehicle(carSlot);
            car.print();
        }
        else{
            System.out.println("-----------------------------------------------------");
            System.out.println("Truck Parking Area");
            System.out.println("-----------------------------------------------------");
            PrintVehicle truck=new PrintVehicle(truckSlot);
            truck.print();
        }


    }

    public void getParkingSlot(int numberPlate){
        ParkingSlotDetails details=new ParkingSlotDetails(vehicleMap);
        System.out.println(details.getParking(numberPlate));
    }

    public boolean isAvailableNumber(int numberPlate){
        ParkingSlotDetails details=new ParkingSlotDetails(vehicleMap);
        return details.isAvailable(numberPlate);
    }

}
