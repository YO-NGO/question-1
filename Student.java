package com.mycompany.utmsprototype;

public class Student extends User {
    private String studentId;
    private String faculty;

   
    public Student(String userId, String username, String password, String studentId, String faculty) {
       
        super(userId, username, password, "Student");
        this.studentId = studentId;
        this.faculty = faculty;
    }

    
    public String getStudentId() {
        return studentId;
    }

    public String getFaculty() {
        return faculty;
    }

   
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Student ID: " + studentId);
        System.out.println("Faculty: " + faculty);
    }

    
    @Override
    public void requestTransport(String destination) {
        System.out.println(getUsername() + " (Student ID: " + studentId + ") is requesting transport to " + destination + " for academic purposes.");
       
    }
}
