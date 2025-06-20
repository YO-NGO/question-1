package com.mycompany.utmsprototype;

public class Bus extends Vehicle implements Serviceable, Trackable, Schedulable {
    private int numberOfWheels; // Bus-specific attribute

    public Bus(String vehicleId, String make, String model, int capacity, String currentLocation, int numberOfWheels) {
        
        super(vehicleId, VehicleType.BUS, make, model, capacity, currentLocation);
        this.numberOfWheels = numberOfWheels;
    }

   
    public int getNumberOfWheels() {
        return numberOfWheels;
    }

   
    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

   
    @Override
    public void displayDetails() {
        super.displayDetails(); // Call parent method to display common vehicle details
        System.out.println("Number of Wheels: " + numberOfWheels);
    }

   
    @Override
    public boolean performMaintenance(String serviceType) {
        System.out.println("Bus " + getModel() + " undergoing " + serviceType + " maintenance.");
       
        if (serviceType.equalsIgnoreCase("engine check")) {
            setOperational(true);
            return true;
        }
        setOperational(false); 
        System.out.println("Bus " + getModel() + " is temporarily out of service for " + serviceType + ".");
        return true;
    }

    
    @Override
    public String trackLocation() {
        System.out.println("Tracking Bus " + getModel() + ". Current location: " + getCurrentLocation());
        return getCurrentLocation();
    }

   
    @Override
    public boolean scheduleTrip(String routeName, String time) {
        System.out.println("Bus " + getModel() + " scheduled for route '" + routeName + "' at " + time + ".");
       
        return true;
    }
}


