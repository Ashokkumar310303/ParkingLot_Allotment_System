package com.practice.ParkingLotSystem;

public class Vehicle {
    static int idGenerator=0;
    private final String vehicleOwner;
    private final int vehicleId;
    private final int numberPlate;
    private final String vehicleName;
    private final int size;
    private final char vehicleType;

    public Vehicle(int numberPlate,String vehicleName,String vehicleOwner,char vehicleType){
        this.numberPlate=numberPlate;
        this.vehicleName=vehicleName;
        this.vehicleType=vehicleType;
        this.vehicleOwner=vehicleOwner;
        this.vehicleId=++idGenerator;

        if(vehicleType=='B'){
            //bike size 1
            this.size=1;
        }
        else if(vehicleType=='C'){
            //car size 4
            this.size=4;
        }
        else{
            //truck
            this.size=8;
        }
    }

    public static void setIdGenerator(){
        Vehicle.idGenerator=idGenerator-1;
    }


    public String getVehicleOwner(){
        return vehicleOwner;
    }

    public String getVehicleName(){
        return vehicleName;
    }

    public int getVehicleId(){
        return vehicleId;
    }

    public int getSize(){
        return size;
    }

    public int getNumberPlate(){
        return numberPlate;
    }

    public char getVehicleType(){
        return vehicleType;
    }
}
