package com.mycompany.utmsprototype;
public abstract class Vehicle {
    public enum VehicleType {
        BUS, VAN, CAR
    }

    private String vehicleId;
    private VehicleType type; 
    private String make;
    private String model;
    private int capacity; 
    private String currentLocation;
    private boolean isOperational; 

   
    public Vehicle(String vehicleId, VehicleType type, String make, String model, int capacity, String currentLocation) {
        this.vehicleId = vehicleId;
        this.type = type;
        this.make = make;
        this.model = model;
        this.capacity = capacity;
        this.currentLocation = currentLocation;
        this.isOperational = true; 
    }

   
    public String getVehicleId() {
        return vehicleId;
    }

    public VehicleType getType() {
        return type;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public boolean isOperational() {
        return isOperational;
    }

    
    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void setOperational(boolean operational) {
        isOperational = operational;
    }

   
    public void displayDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Type: " + type);
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Capacity: " + capacity + " passengers");
        System.out.println("Current Location: " + currentLocation);
        System.out.println("Operational: " + (isOperational ? "Yes" : "No"));
    }

   
    public void startEngine() {
        System.out.println(make + " " + model + " engine started.");
    }

    
    public void stopEngine() {
        System.out.println(make + " " + model + " engine stopped.");
    }
}
