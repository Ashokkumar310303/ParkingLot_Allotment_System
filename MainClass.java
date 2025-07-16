package com.practice.ParkingLotSystem;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("---------------------------------");
        System.out.println("Welcome to the ParkingLot System");
        System.out.println("---------------------------------");
        System.out.println();

        boolean isValid=true;
        Scanner input=new Scanner(System.in);
        ParkingAllocationSystem parking=new ParkingAllocationSystem(1,1,1);

        while(isValid){
            System.out.println();
            System.out.println();
            System.out.println("1. Park the vehicle");
            System.out.println("2. Remove the vehicle");
            System.out.println("3. To view the vehicle allocated parking lot");
            System.out.println("4. View bike parking lot");
            System.out.println("5. View car parking lot");
            System.out.println("6. View truck parking lot");
            System.out.println("7. Exit");
            System.out.println();
            System.out.println();
            int choice;
            System.out.println("Enter the choice:");
            choice=input.nextInt();

            switch (choice){
                case 1:
                    boolean isNotValid=true;
                    int numberPlate=0;
                    String vehicleOwner="",vehicleName="";
                    char vehicleType='f';

                    while(isNotValid){
                        System.out.println("Enter the number Plate:");
                        numberPlate=input.nextInt();

                        if(parking.isAvailableNumber(numberPlate)){
                            System.out.println("Number plate already exist please enter your valid number plate");
                            continue;
                        }

                        System.out.println("Enter the vehicle Name:");
                        vehicleName=input.next();

                        System.out.println("Enter the vehicle Type - [Bike,Car,Truck]:");
                        vehicleType=input.next().toUpperCase().charAt(0);

                        System.out.println("Enter the vehicle Owner Name:");
                        vehicleOwner=input.next();

                        if(vehicleType=='B' || vehicleType=='C' || vehicleType=='T'){
                            isNotValid=false;
                        }
                        else{
                            System.out.println("Enter the valid vehicle type - [ Bike || Car || Truck ]");
                        }
                    }

                    parking.parkVehicle(new Vehicle(numberPlate,vehicleName,vehicleOwner,vehicleType));
                    break;

                case 2:
                    int plateNumber=0;
                    System.out.println("Enter the number plate of your vehicle");
                    plateNumber=input.nextInt();
                    parking.removeVehicle(plateNumber);
                    break;

                case 3:
                    System.out.println("Enter the numberPlate:");
                    int number=input.nextInt();
                    parking.getParkingSlot(number);
                    break;
                case 4:
                    parking.printAllocation("Bike");
                    break;
                case 5:
                    parking.printAllocation("Car");
                    break;
                case 6:
                    parking.printAllocation("Truck");
                    break;
                case 7:
                    isValid=false;
                    break;
                default:
                    System.out.println("Invalid choice !!!");
                    break;
            }




        }
    }
}
