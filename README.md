# 🚗 Parking Lot Allotment System

This is a **Java console application** that simulates an efficient Parking Lot System for managing bikes, cars, and trucks.

It was designed to handle:
- 🏍 Bikes (space = 1)
- 🚗 Cars (space = 4)
- 🚚 Trucks (space = 8)

It ensures optimal allocation by parking bikes first in bike slots, then in car or truck slots if needed. Similarly for cars and trucks.

---

## 📂 Features

✅ **Vehicle Parking & Allocation**
- Bikes park in bike slots first, then car, then truck slots.
- Cars park in car slots first, then truck slots.
- Trucks park only in truck slots.

✅ **Dynamic Re-allocation**
- If a vehicle leaves, the system intelligently moves bikes from car/truck slots back to bike slots, and cars from truck slots to car slots if space becomes available.

✅ **Duplicate Plate Check**
- The system rejects vehicles with duplicate number plates.

✅ **Parking Lot Views**
- View current parking lot allocation for bikes, cars, and trucks.

✅ **Parking Slot Details**
- Given a number plate, find where the vehicle is parked.

---

## 🚀 How to Run

### Prerequisites
- Java 8 or higher (your project is using Java 24 — ✅ good to go)
- Git (for cloning)

### Compile & Run
cd src
javac com/practice/ParkingLotSystem/*.java
java com.practice.ParkingLotSystem.MainClass


(Replace `MainClass` with your actual main file name.)

---

## 🏗 Project Structure

src/
└── com/
└── practice/
└── ParkingLotSystem/
├── ParkingAllocationSystem.java
├── BikeAllotmentChange.java
├── CarAllotmentChange.java
├── TruckParking.java
├── BikeParking.java
├── CarParking.java
├── PrintVehicle.java
├── Vehicle.java
└── MainClass.java



---

## 🔍 Sample Console UI

Welcome to the ParkingLot System

1. Park the vehicle

2. Remove the vehicle

3. View the vehicle allocated parking lot

4. View bike parking lot

5. View car parking lot

6. View truck parking lot

7. Exit


---

## ✍️ Author
- **Ashok Kumar** ([GitHub](https://github.com/Ashokkumar310303))

---

## 📜 License
This project is licensed under the MIT License - feel free to use and modify.

---

✅ **Happy coding! 🚀**

