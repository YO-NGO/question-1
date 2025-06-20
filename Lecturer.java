package com.mycompany.utmsprototype;

public class Lecturer extends User {
    private String staffId;
    private String department;

  
    public Lecturer(String userId, String username, String password, String staffId, String department) {
        // Call to the superclass (User) constructor.
        super(userId, username, password, "Lecturer");
        this.staffId = staffId;
        this.department = department;
    }

   
    public String getStaffId() {
        return staffId;
    }

    public String getDepartment() {
        return department;
    }

   
    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    
    @Override
    public void displayDetails() {
        super.displayDetails(); 
        System.out.println("Staff ID: " + staffId);
        System.out.println("Department: " + department);
    }

   
    @Override
    public void requestTransport(String destination) {
        System.out.println(getUsername() + " (Staff ID: " + staffId + ") is requesting transport to " + destination + " for official university business.");
      
    }
}
