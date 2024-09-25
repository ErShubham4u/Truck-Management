package org.example;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        TruckService truckService = new TruckService();
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Keep the program running until the user chooses to exit
        while (true) {
            System.out.println("\n===== Truck Management System =====");
            System.out.println("1. Add Truck");
            System.out.println("2. Fetch Truck by ID");
            System.out.println("3. Update Truck");
            System.out.println("4. Get All Trucks");
            System.out.println("5. Delete Truck by ID");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add truck
                    System.out.println("Enter Truck details to add:");
                    System.out.print("Truck Name: ");
                    String name = scanner.next();
                    System.out.print("Truck Model: ");
                    String model = scanner.next();
                    System.out.print("Capacity: ");
                    int capacity = scanner.nextInt();
                    System.out.print("Driver Name: ");
                    String driverName = scanner.next();

                    Truck newTruck = new Truck(name, model, capacity, driverName);
                    truckService.addTruck(newTruck);
                    System.out.println("Truck added: " + newTruck);
                    break;

                case 2:
                    // Fetch truck by ID
                    System.out.print("Enter Truck ID to fetch: ");
                    int fetchId = scanner.nextInt();
                    Truck fetchedTruck = truckService.getTruckById(fetchId);
                    System.out.println("Fetched Truck: " + fetchedTruck);
                    break;

                case 3:
                    // Update truck
                    System.out.print("Enter Truck ID to update: ");
                    int updateId = scanner.nextInt();
                    Truck truckToUpdate = truckService.getTruckById(updateId);

                    if (truckToUpdate != null) {
                        System.out.print("Enter new Driver Name: ");
                        String newDriverName = scanner.next();
                        truckToUpdate.setDriverName(newDriverName);
                        truckService.updateTruck(truckToUpdate);
                        System.out.println("Updated Truck: " + truckToUpdate);
                    } else {
                        System.out.println("Truck with ID " + updateId + " not found.");
                    }
                    break;

                case 4:
                    // Get all trucks
                    List<Truck> allTrucks = truckService.getAllTrucks();
                    System.out.println("All Trucks in DB:");
                    for (Truck truck : allTrucks) {
                        System.out.println(truck);
                    }
                    break;

                case 5:
                    // Delete truck by ID
                    System.out.print("Enter Truck ID to delete: ");
                    int deleteId = scanner.nextInt();
                    truckService.deleteTruck(deleteId);
                    System.out.println("Deleted Truck with ID: " + deleteId);
                    break;

                case 6:
                    // Exit the program
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
