package com.mycompany.utmsprototype;
public class Driver {
    private String driverId;
    private String name;
    private String licenseNumber; 
    private String contactInfo;
    private boolean isAvailable; 

    public Driver(String driverId, String name, String licenseNumber, String contactInfo) {
        this.driverId = driverId;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.contactInfo = contactInfo;
        this.isAvailable = true; 
    }

    
    public String getDriverId() {
        return driverId;
    }

    public String getName() {
        return name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    
    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

  
    public void displayDetails() {
        System.out.println("Driver ID: " + driverId);
        System.out.println("Name: " + name);
        System.out.println("License No.: " + licenseNumber);
        System.out.println("Contact: " + contactInfo);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Occupied"));
    }
}

