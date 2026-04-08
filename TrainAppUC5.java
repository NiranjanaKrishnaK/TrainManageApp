package TrainManageApp;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class TrainAppUC5 {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App (UC5) ===");

        Scanner scanner = new Scanner(System.in);

        // Create LinkedHashSet for train formation (unique + ordered)
        Set<String> trainFormation = new LinkedHashSet<>();

        // Ask user how many bogies to attach
        System.out.print("Enter number of bogies to attach: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Add bogies from user input
        for (int i = 1; i <= count; i++) {
            System.out.print("Enter bogie " + i + " name: ");
            String bogieName = scanner.nextLine();
            boolean added = trainFormation.add(bogieName);
            if (!added) {
                System.out.println("Duplicate bogie ignored: " + bogieName);
            }
        }

        // Display final formation order
        System.out.println("Final train formation (in order): " + trainFormation);

        scanner.close();
    }
}