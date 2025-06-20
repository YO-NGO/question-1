package com.mycompany.utmsprototype;
public class Van extends Vehicle implements Serviceable, Trackable, Schedulable {
    private boolean hasCargoSpace; 

    public Van(String vehicleId, String make, String model, int capacity, String currentLocation, boolean hasCargoSpace) {
       
        super(vehicleId, VehicleType.VAN, make, model, capacity, currentLocation);
        this.hasCargoSpace = hasCargoSpace;
    }

    public boolean hasCargoSpace() {
        return hasCargoSpace;
    }
    
    public void setHasCargoSpace(boolean hasCargoSpace) {
        this.hasCargoSpace = hasCargoSpace;
    }

   
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Has Cargo Space: " + (hasCargoSpace ? "Yes" : "No"));
    }

    @Override
    public boolean performMaintenance(String serviceType) {
        System.out.println("Van " + getModel() + " undergoing " + serviceType + " maintenance.");
       
        if (serviceType.equalsIgnoreCase("brake check")) {
            setOperational(true);
            return true;
        }
        setOperational(false);
        System.out.println("Van " + getModel() + " is temporarily out of service for " + serviceType + ".");
        return true;
    }

    @Override
    public String trackLocation() {
        System.out.println("Tracking Van " + getModel() + ". Current location: " + getCurrentLocation());
        return getCurrentLocation();
    }

  
    @Override
    public boolean scheduleTrip(String routeName, String time) {
        System.out.println("Van " + getModel() + " scheduled for route '" + routeName + "' at " + time + ".");
        
        return true;
    }
}
