
package com.mycompany.utmsprototype;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        
        try (Scanner scanner = new Scanner(System.in)) {
            
            DriverManager driverManager = new DriverManager();
            System.out.println(" Victoria University Transport Management System ");
            System.out.println(" (Comprehensive Interactive Demonstration)");

            System.out.println("--- Setup: Creating Users, Vehicles, and a Route ---");
            System.out.println("You will now input details for various entities to start the simulation.");

            // --- USER CREATION SECTION ---
            System.out.println(" Creating a Student User ");
            System.out.print("Enter Student User ID (U001): ");
            String studentUserId = scanner.nextLine();
            System.out.print("Enter Student Username ( Full Name): ");
            String studentUsername = scanner.nextLine();
            System.out.print("Enter Student Password: ");
            String studentPassword = scanner.nextLine();
            System.out.print("Enter Student ID ( VU-001): ");
            String studentID = scanner.nextLine();
            System.out.print("Enter Student Faculty (Forexample; Engineering): ");
            String studentFaculty = scanner.nextLine();
            User student = new Student(studentUserId, studentUsername, studentPassword, studentID, studentFaculty);
            System.out.println("Student created: " + student.getUsername());
            System.out.println("Press Enter to continue...");
            scanner.nextLine();

            System.out.println(" Creating a Lecturer User ");
            System.out.print("Enter Lecturer User ID (L001): ");
            String lecturerUserId = scanner.nextLine();
            System.out.print("Enter Lecturer Username ( Dr,Mr,Mrs,....): ");
            String lecturerUsername = scanner.nextLine();
            System.out.print("Enter Lecturer Password: ");
            String lecturerPassword = scanner.nextLine();
            System.out.print("Enter Lecturer Staff ID ( VU-STAFF-005): ");
            String lecturerStaffID = scanner.nextLine();
            System.out.print("Enter Lecturer Department (): ");
            String lecturerDepartment = scanner.nextLine();
            User lecturer = new Lecturer(lecturerUserId, lecturerUsername, lecturerPassword, lecturerStaffID, lecturerDepartment);
            System.out.println("Lecturer created: " + lecturer.getUsername());
            System.out.println("Press Enter to continue...");
            scanner.nextLine();

            System.out.println(" Creating a Transport Officer User ");
            System.out.print("Enter Transport Officer User ID (TO001): ");
            String officerUserId = scanner.nextLine();
            System.out.print("Enter Transport Officer Username ( Mr/Mrs): ");
            String officerUsername = scanner.nextLine();
            System.out.print("Enter Transport Officer Password: ");
            String officerPassword = scanner.nextLine();
            System.out.print("Enter Transport Officer Employee ID ( EMP-010): ");
            String officerEmployeeID = scanner.nextLine();
            TransportOfficer officer = new TransportOfficer(officerUserId, officerUsername, officerPassword, officerEmployeeID);
            System.out.println("Transport Officer created: " + officer.getUsername());
            System.out.println("Press Enter to continue...");
            scanner.nextLine();

            List<User> users = new ArrayList<>();
            users.add(student);
            users.add(lecturer);
            users.add(officer);

            // --- VEHICLE CREATION SECTION ---
            System.out.println("  Creating a Bus Vehicle ");
            System.out.print("Enter Bus Vehicle ID ( V001): ");
            String busId = scanner.nextLine();
            System.out.print("Enter Bus Make ( Toyota/King Long/IC Bus/Volva/Man Se): ");
            String busMake = scanner.nextLine();
            System.out.print("Enter Bus Model (Double decker,Sprinter,BYD K9/Type C): ");
            String busModel = scanner.nextLine();
            System.out.print("Enter Bus Capacity (number less than or equal to 100(<=100): ");
            int busCapacity = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter Bus Current Location ( Main Campus/Anex Campus): ");
            String busLocation = scanner.nextLine();
            System.out.print("Enter Bus Number of Wheels(4,6): ");
            int busWheels = Integer.parseInt(scanner.nextLine());
            Vehicle bus = new Bus(busId, busMake, busModel, busCapacity, busLocation, busWheels);
            System.out.println("Bus created: " + bus.getModel());
            System.out.println("Press Enter to continue...");
            scanner.nextLine();

            System.out.println(" Creating a Van Vehicle ");
            System.out.print("Enter Van Vehicle ID (V002): ");
            String vanId = scanner.nextLine();
            System.out.print("Enter Van Make (Toyota only): ");
            String vanMake = scanner.nextLine();
            System.out.print("Enter Van Model (Drone,Panel,Luton): ");
            String vanModel = scanner.nextLine();
            System.out.print("Enter Van Capacity (number less than or equal to 14(<=14)): ");
            int vanCapacity = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter Van Current Location ( Annex Campus/Main Campus): ");
            String vanLocation = scanner.nextLine();
            System.out.print("Does Van have Cargo Space (true/false)?: ");
            boolean vanCargoSpace = Boolean.parseBoolean(scanner.nextLine());
            Vehicle van = new Van(vanId, vanMake, vanModel, vanCapacity, vanLocation, vanCargoSpace);
            System.out.println("Van created: " + van.getModel());
            System.out.println("Press Enter to continue...");
            scanner.nextLine();

            String routeId = scanner.nextLine();
            System.out.print("Enter Route Name ( Campus Route/Annex Route): ");
            String routeName = scanner.nextLine();
            System.out.print("Enter Start Location: ");
            String startLoc = scanner.nextLine();
            System.out.print("Enter End Location: ");
            String endLoc = scanner.nextLine();
            System.out.print("Enter Distance (KM): ");
            double distance = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter Estimated Duration (Time it takes): ");
            String duration = scanner.nextLine();
            Route mainRoute = new Route(routeId, routeName, startLoc, endLoc, distance, duration);
            System.out.println("Route created: " + mainRoute.getRouteName());
            System.out.println("Press Enter to continue the demonstration...");
            scanner.nextLine();
            
            System.out.println("--- DEMONSTRATING OOP PRINCIPLES WITH YOUR INPUT ---");
           
            System.out.println("--- DEMO 1 ---");
            System.out.println("Accessing and modifying driver information via getters/setters:");
           
            Driver demoDriver = driverManager.getDriver("DR-V001")
                                 .orElse(new Driver("DUMMY", "Dummy Driver", "N/A", "dummy@example.com"));
            System.out.println(" Driver Contact (via getName(Email)): " + demoDriver.getName() + ": " + demoDriver.getContactInfo());

            

            System.out.println("\n DEMO 2-");
            System.out.println("Displaying details for various users and vehicles (demonstrates inherited methods):");
            for (User user : users) {
                user.displayDetails();
                System.out.print("Attempting login for " + user.getUsername() + ". Enter password (try wrong, then correct: " + user.getPassword() + "): ");
                user.login(scanner.nextLine()); 
                user.login(user.getPassword()); 
                System.out.println("--------------------");
            }
            bus.displayDetails(); 
            System.out.println("--------------------");
            van.displayDetails(); 
            System.out.println("--------------------");
            System.out.println("Role of Abstract Classes: Define common templates for related classes (e.g., User, Vehicle), ensuring consistency and extensibility. They hide implementation details.");
            System.out.println("Role of Inheritance: Allows specialized classes (Student, Bus) to derive properties and behaviors from general classes (User, Vehicle), promoting code reusability and establishing 'is-a' relationships.");
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();

            System.out.println("\n--- DEMO 3 ---");
            System.out.println("Each user type requests transport differently, even via the same method call (`requestTransport()`):");
            System.out.print("Student " + student.getUsername() + ", enter your desired destination (Annex campus/Main Campus): ");
            student.requestTransport(scanner.nextLine()); 
            System.out.print("Lecturer " + lecturer.getUsername() + ", enter your desired destination ('Annex/Main Campus'): ");
            lecturer.requestTransport(scanner.nextLine()); 
            System.out.print("Transport Officer " + officer.getUsername() + ", enter the purpose of your request ( like;Vehicle Inspection etc.): ");
            officer.requestTransport(scanner.nextLine()); // Calls TransportOfficer's specific implementation
            System.out.println("Role of Runtime Polymorphism: Enables the system to call a method on a superclass reference, but execute the specific implementation of the actual object type at runtime.");
            System.out.println("Role of Overriding `requestTransport()`: Allows subclasses to provide unique logic for a method defined in their superclass, reflecting their distinct needs.");
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();

            // --- PRINCIPLE 4: Interfaces (v) ---
            System.out.println("\n--- DEMO 4: ---");
            System.out.println("Vehicles demonstrating behaviors defined by interfaces (Serviceable, Trackable, Schedulable):");
            
            System.out.println("\n--- Bus specific behaviors (via interfaces) ---");
            System.out.print("Enter maintenance type for " + bus.getModel() + " Bus (like;'tire rotation etc.): ");
            ((Bus) bus).performMaintenance(scanner.nextLine()); // Serviceable interface method
            System.out.println(bus.getModel() + " current location: " + ((Bus) bus).trackLocation()); // Trackable interface method
            System.out.print("Enter route name for " + bus.getModel() + " Bus schedule (e.g., 'Campus Shuttle Route'): ");
            String busRouteName = scanner.nextLine();
            System.out.print("Enter scheduled time for " + bus.getModel() + " Bus trip (e.g., '08:00 AM'): ");
            String busTime = scanner.nextLine();
            ((Bus) bus).scheduleTrip(busRouteName, busTime); // Schedulable interface method

            System.out.println("\n--- Van specific behaviors (via interfaces) ---");
            System.out.print("Enter maintenance type for " + van.getModel() + " Van (e.g., 'oil change'): ");
            ((Van) van).performMaintenance(scanner.nextLine()); // Serviceable interface method
            System.out.println(van.getModel() + " current location: " + ((Van) van).trackLocation()); // Trackable interface method
            System.out.print("Enter route name for " + van.getModel() + " Van schedule ( 'Staff Pick-up Route'): ");
            String vanRouteName = scanner.nextLine();
            System.out.print("Enter scheduled time for " + van.getModel() + " Van trip ( Forexample '09:30 AM'): ");
            String vanTime = scanner.nextLine();
            ((Van) van).scheduleTrip(vanRouteName, vanTime); // Schedulable interface method
            System.out.println("Role of Interfaces: Define contracts for common behaviors (e.g., being serviceable, trackable, schedulable) that diverse classes can implement. This allows for flexible design and polymorphic interaction based on capabilities.");
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();

            // --- PRINCIPLE 5: Method Overloading (vii) for assignDriver() ---
            System.out.println("\n--- DEMO 5: Method Overloading (vii) for assignDriver() ---");
            System.out.println("The `assignDriver()` method in `TransportService` has multiple versions.");

            // Scenario 1: Assign driver by just finding the first available one (no specific criteria)
            System.out.println("\n--- Scenario 1: Auto-assigning any available driver to a new Transport Service (TS001) ---");
            TransportService service1 = new TransportService("TS001", student, mainRoute, driverManager);
            service1.setVehicleAssigned(bus); // Assign a vehicle first

            System.out.println("\nCalling assignDriver() with NO parameters (auto-selection)...");
            boolean assigned1 = service1.assignDriver(); // Calls assignDriver() with no parameters
            if (assigned1) {
                service1.displayServiceDetails();
                service1.startTrip();
                service1.endTrip();
                service1.displayServiceDetails();
            } else {
                System.out.println("Could not assign a driver for TS001.");
            }
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();

            // Scenario 2: Assign driver based on Vehicle Type and Shift Time
            System.out.println("\n--- Scenario 2: Assigning a driver based on Vehicle Type and Shift Time to a new Transport Service (TS002) ---");
            // Make the driver from Service1 available again for a clearer demo
            if (service1.getDriverAssigned() != null) {
                service1.getDriverAssigned().setAvailable(true);
                System.out.println("Driver " + service1.getDriverAssigned().getName() + " made available again for demo purposes.");
            }

            TransportService service2 = new TransportService("TS002", lecturer, mainRoute, driverManager);
            service2.setVehicleAssigned(van); // Assign another vehicle

            System.out.print("Enter Vehicle Type for driver assignment (BUS/VAN/CAR): ");
            String vehicleTypeStr = scanner.nextLine().toUpperCase();
            Vehicle.VehicleType selectedVehicleType = null;
            try {
                selectedVehicleType = Vehicle.VehicleType.valueOf(vehicleTypeStr);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Vehicle Type entered. Defaulting to VAN.");
                selectedVehicleType = Vehicle.VehicleType.VAN;
            }

            System.out.print("Enter Shift Time for driver assignment ( 'Morning', 'Afternoon', 'Night', 'Any'): ");
            String shiftTime = scanner.nextLine();

            System.out.println("\nCalling assignDriver(Vehicle.VehicleType, String) with your parameters...");
            boolean assigned2 = service2.assignDriver(selectedVehicleType, shiftTime); // Calls overloaded assignDriver
            if (assigned2) {
                service2.displayServiceDetails();
                service2.startTrip();
                service2.endTrip();
                service2.displayServiceDetails();
            } else {
                System.out.println("Could not assign a driver for TS002 with specified criteria.");
            }

            System.out.println("Role of Method Overloading: Allows a class to have multiple methods with the same name but different parameter lists. In UTMS, `assignDriver()` can be called with no parameters (for any available driver) or with specific criteria (vehicle type, shift time), providing flexibility to the caller.");
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();


            // Final cleanup
            System.out.println("\n--- Cleanup: Logging out all users ---");
            for (User user : users) {
                user.logout();
            }

            System.out.println("\n--- All Drivers in Manager (Current Availability) ---");
            driverManager.displayAllDrivers();

            System.out.println(" End of Comprehensive UTMS Prototype Demonstration");
          
        }
    }
}
