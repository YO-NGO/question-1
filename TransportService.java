package com.mycompany.utmsprototype;


import java.util.Optional; // For using Optional in driver assignment

public class TransportService {
    private String serviceId;
    private User requestedBy; // The user who initiated this transport service request
    private Vehicle vehicleAssigned;
    private Driver driverAssigned;
    private Route route;
    private String status; // e.g., "Pending", "Assigned", "In Progress", "Completed", "Cancelled"
    private final DriverManager driverManager; // Dependency injection for DriverManager

    /**
     * Constructor for TransportService.
     * @param serviceId Unique identifier for the service.
     * @param requestedBy The User who requested this service.
     * @param route The Route for this service.
     * @param driverManager An instance of DriverManager to manage driver assignments.
     */
    public TransportService(String serviceId, User requestedBy, Route route, DriverManager driverManager) {
        this.serviceId = serviceId;
        this.requestedBy = requestedBy;
        this.route = route;
        this.status = "Pending"; // Initial status of a new service request
        this.driverManager = driverManager; // Inject the driver manager
    }

    // --- Getter methods for encapsulated private data ---
    public String getServiceId() {
        return serviceId;
    }

    public User getRequestedBy() {
        return requestedBy;
    }

    public Vehicle getVehicleAssigned() {
        return vehicleAssigned;
    }

    public Driver getDriverAssigned() {
        return driverAssigned;
    }

    public Route getRoute() {
        return route;
    }

    public String getStatus() {
        return status;
    }

    // --- Setter methods to modify encapsulated private data ---
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public void setRequestedBy(User requestedBy) {
        this.requestedBy = requestedBy;
    }

    public void setVehicleAssigned(Vehicle vehicleAssigned) {
        this.vehicleAssigned = vehicleAssigned;
        System.out.println("Service " + serviceId + ": Vehicle " + vehicleAssigned.getModel() + " assigned.");
        // Automatically update status if both vehicle and driver are assigned
        if (this.driverAssigned != null) {
            this.status = "Assigned";
        }
    }

    public void setDriverAssigned(Driver driverAssigned) {
        this.driverAssigned = driverAssigned;
        System.out.println("Service " + serviceId + ": Driver " + driverAssigned.getName() + " assigned.");
        // Automatically update status if both vehicle and driver are assigned
        if (this.vehicleAssigned != null) {
            this.status = "Assigned";
        }
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Overloaded method: Attempts to assign any available driver to this service.
     * This method delegates the finding of an available driver to DriverManager.
     * Demonstrates (vii) Method Overloading: Same method name, different parameter list (no parameters here).
     * @return true if a driver was successfully assigned, false otherwise.
     */
    public boolean assignDriver() {
        System.out.println("Service " + serviceId + ": Attempting to assign driver (auto-selection).");
        Optional<Driver> foundDriver = driverManager.findAvailableDriver();
        if (foundDriver.isPresent()) {
            Driver driver = foundDriver.get();
            this.setDriverAssigned(driver);
            driver.setAvailable(false); // Mark the driver as occupied
            return true;
        } else {
            System.out.println("Service " + serviceId + ": No available drivers at the moment for auto-assignment.");
            return false;
        }
    }

  
    public boolean assignDriver(Vehicle.VehicleType vehicleType, String shiftTime) {
        System.out.println("Service " + serviceId + ": Attempting to assign driver for " + vehicleType + " during " + shiftTime + " shift.");
        Optional<Driver> foundDriver = driverManager.findAvailableDriver(vehicleType, shiftTime);
        if (foundDriver.isPresent()) {
            Driver driver = foundDriver.get();
            this.setDriverAssigned(driver);
            driver.setAvailable(false); // Mark as occupied
            return true;
        } else {
            System.out.println("Service " + serviceId + ": No suitable drivers found for " + vehicleType + " and " + shiftTime + " shift.");
            return false;
        }
    }

    
    public void startTrip() {
        if (vehicleAssigned != null && driverAssigned != null && status.equals("Assigned")) {
            status = "In Progress";
            System.out.println("Service " + serviceId + ": Trip started with " + driverAssigned.getName() + " in " + vehicleAssigned.getModel() + " to " + route.getEndLocation() + ".");
            vehicleAssigned.startEngine(); // Demonstrate vehicle action
        } else {
            System.out.println("Service " + serviceId + ": Cannot start trip. Vehicle and/or driver not assigned, or status not 'Assigned'. Current status: " + status);
        }
    }

    /**
     * Simulates ending the transport trip.
     */
    public void endTrip() {
        if (status.equals("In Progress")) {
            status = "Completed";
            System.out.println("Service " + serviceId + ": Trip completed. " + driverAssigned.getName() + " is now available.");
            if (driverAssigned != null) {
                driverAssigned.setAvailable(true); 
            }
            if (vehicleAssigned != null) {
                vehicleAssigned.stopEngine(); 
            }
        } else {
            System.out.println("Service " + serviceId + ": Cannot end trip. Status is not 'In Progress'. Current status: " + status);
        }
    }

    
    public void displayServiceDetails() {
        System.out.println("\n--- Transport Service Details (ID: " + serviceId + ") ---");
        System.out.println("Requested By: " + requestedBy.getUsername() + " (" + requestedBy.getUserRole() + ")");
        System.out.println("Route: " + (route != null ? route.getRouteName() : "N/A"));
        System.out.println("Status: " + status);
        if (vehicleAssigned != null) {
            System.out.println("Vehicle Assigned: " + vehicleAssigned.getMake() + " " + vehicleAssigned.getModel() + " (ID: " + vehicleAssigned.getVehicleId() + ")");
        } else {
            System.out.println("Vehicle Assigned: None");
        }
        if (driverAssigned != null) {
            System.out.println("Driver Assigned: " + driverAssigned.getName() + " (ID: " + driverAssigned.getDriverId() + ")");
        } else {
            System.out.println("Driver Assigned: None");
        }
        System.out.println("------------------------------------");
    }
}
