package com.mycompany.utmsprototype;

public abstract class User {
    private final String userId;
    private String username;
    private String password; // In a real system, passwords would be hashed
    private final String userRole;

   
    public User(String userId, String username, String password, String userRole) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }

    
    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password; 
    }

    public String getUserRole() {
        return userRole;
    }

   
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

 
    public boolean login(String enteredPassword) {
        if (this.password.equals(enteredPassword)) {
            System.out.println(this.username + " (" + this.userRole + ") logged in successfully.");
            return true;
        } else {
            System.out.println("Login failed for " + this.username + ". Incorrect password.");
            return false;
        }
    }

   
    public void logout() {
        System.out.println(this.username + " (" + this.userRole + ") logged out.");
    }

    
    public void displayDetails() {
        System.out.println("User ID: " + userId);
        System.out.println("Username: " + username);
        System.out.println("Role: " + userRole);
    }
    public abstract void requestTransport(String destination);
}
