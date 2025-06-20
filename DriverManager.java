package com.mycompany.utmsprototype;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional; // For returning Optional in find methods


public final class DriverManager {
    private final List<Driver> drivers;

    /**
     * Constructor for DriverManager. Initializes the list of drivers.
     */
    public DriverManager() {
        this.drivers = new ArrayList<>();
        
    }

    public void addDriver(Driver driver) {
        this.drivers.add(driver);
        System.out.println("Driver " + driver.getName() + " added to manager.");
    }

    
    public Optional<Driver> getDriver(String driverId) {
        return drivers.stream()
                      .filter(d -> d.getDriverId().equals(driverId))
                      .findFirst();
    }

   
    public Optional<Driver> findAvailableDriver() {
        System.out.println("Searching for any available driver...");
        return drivers.stream()
                      .filter(Driver::isAvailable)
                      .findFirst();
    }


    
    public Optional<Driver> findAvailableDriver(Vehicle.VehicleType vehicleType, String shiftTime) {
        System.out.println("Searching for available driver for " + vehicleType + " during " + shiftTime + " shift...");
   
        return drivers.stream()
                      .filter(Driver::isAvailable)
                  
                      .findFirst();
    }

    
    public void displayAllDrivers() {
        if (drivers.isEmpty()) {
            System.out.println("No drivers registered in the system.");
            return;
        }
        System.out.println("\n--- All Registered Drivers ---");
        for (Driver driver : drivers) {
            driver.displayDetails();
            System.out.println("--------------------");
        }
    }
}
