package TrainManageApp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TrainAppUC6 {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App (UC6) ===");

        Scanner scanner = new Scanner(System.in);

        // Create HashMap for bogie-capacity mapping
        Map<String, Integer> bogieCapacityMap = new HashMap<>();

        // Ask user how many bogies to add
        System.out.print("Enter number of bogies to map: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Add bogies and capacities from user input
        for (int i = 1; i <= count; i++) {
            System.out.print("Enter bogie " + i + " name: ");
            String bogieName = scanner.nextLine();

            System.out.print("Enter capacity for " + bogieName + ": ");
            int capacity = scanner.nextInt();
            scanner.nextLine(); // consume newline

            bogieCapacityMap.put(bogieName, capacity);
        }

        // Display bogie-capacity mapping
        System.out.println("\n=== Bogie Capacity Details ===");
        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            System.out.println("Bogie: " + entry.getKey() + " | Capacity: " + entry.getValue());
        }

        scanner.close();
    }
}