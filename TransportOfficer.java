package com.mycompany.utmsprototype;

public class TransportOfficer extends User {
    private String employeeId;

    public TransportOfficer(String userId, String username, String password, String employeeId) {
        super(userId, username, password, "TransportOfficer"); 
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

   
    @Override
    public void displayDetails() {
        super.displayDetails(); // Call parent method for common user details
        System.out.println("Employee ID: " + employeeId);
    }

  
    @Override
    public void requestTransport(String destination) {
        System.out.println(getUsername() + " (Employee ID: " + employeeId + ") is coordinating transport or requesting a vehicle for: " + destination + ".");
      
    }

   
    public void manageTransportAssignments(TransportService service, Driver driver, Vehicle vehicle) {
        System.out.println(getUsername() + " (Transport Officer) is assigning Driver " + driver.getName() +
                           " to Vehicle " + vehicle.getMake() + " " + vehicle.getModel() +
                           " for service " + service.getServiceId() + ".");
       
        service.setDriverAssigned(driver);
        service.setVehicleAssigned(vehicle);
        service.setStatus("Assigned"); // Update service status
    }
}
