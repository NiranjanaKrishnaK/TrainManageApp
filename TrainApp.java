package TrainManageApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrainApp {
    public static void main(String[] args) {
        // Welcome message
        System.out.println("=== Train Consist Management App ===");

        // Initialize empty train consist
        List<String> bogies = new ArrayList<>();

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Ask user how many bogies to add initially
        System.out.print("Enter the number of bogies to initialize: ");
        int bogieCount = scanner.nextInt();

        // Add bogies dynamically
        for (int i = 1; i <= bogieCount; i++) {
            bogies.add("Bogie-" + i);
        }

        // Display initial bogie count
        System.out.println("Initial bogie count: " + bogies.size());

        // Display bogie list
        System.out.println("Train consist: " + bogies);

        // Program continues...
        System.out.println("Train initialized successfully.");

        scanner.close();
    }
}