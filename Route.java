package com.mycompany.utmsprototype;

public class Route {
    private String routeId;
    private String routeName;
    private String startLocation;
    private String endLocation;
    private double distanceKm;
    private String estimatedDuration; // e.g., "30 mins", "1 hour"

    public Route(String routeId, String routeName, String startLocation, String endLocation, double distanceKm, String estimatedDuration) {
        this.routeId = routeId;
        this.routeName = routeName;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.distanceKm = distanceKm;
        this.estimatedDuration = estimatedDuration;
    }

    
    public String getRouteId() {
        return routeId;
    }

    public String getRouteName() {
        return routeName;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public double getDistanceKm() {
        return distanceKm;
    }

    public String getEstimatedDuration() {
        return estimatedDuration;
    }

   
    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public void setDistanceKm(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public void setEstimatedDuration(String estimatedDuration) {
        this.estimatedDuration = estimatedDuration;
    }

   
    public void displayDetails() {
        System.out.println("Route ID: " + routeId);
        System.out.println("Route Name: " + routeName);
        System.out.println("Start: " + startLocation + ", End: " + endLocation);
        System.out.println("Distance: " + distanceKm + " km");
        System.out.println("Estimated Duration: " + estimatedDuration);
    }
}
