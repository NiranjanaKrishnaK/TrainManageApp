package TrainManageApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrainAppUC2 {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App (UC2) ===");

        Scanner scanner = new Scanner(System.in);

        // Create ArrayList for passenger bogies
        List<String> passengerBogies = new ArrayList<>();

        // Ask user how many bogies to add
        System.out.print("Enter number of passenger bogies to add: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Add bogies from user input
        for (int i = 1; i <= count; i++) {
            System.out.print("Enter bogie " + i + " name: ");
            String bogieName = scanner.nextLine();
            passengerBogies.add(bogieName);
        }

        // Display bogies after insertion
        System.out.println("Passenger bogies after insertion: " + passengerBogies);

        // Ask user which bogie to remove
        System.out.print("Enter bogie name to remove: ");
        String removeName = scanner.nextLine();
        passengerBogies.remove(removeName);
        System.out.println("After removing " + removeName + ": " + passengerBogies);

        // Ask user which bogie to check
        System.out.print("Enter bogie name to check existence: ");
        String checkName = scanner.nextLine();
        if (passengerBogies.contains(checkName)) {
            System.out.println(checkName + " bogie exists in the train.");
        } else {
            System.out.println(checkName + " bogie does not exist.");
        }

        // Final state of bogies
        System.out.println("Final passenger bogies: " + passengerBogies);

        scanner.close();
    }
}
