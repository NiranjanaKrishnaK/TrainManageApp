package TrainManageApp;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TrainAppUC3 {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App (UC3) ===");

        Scanner scanner = new Scanner(System.in);

        // Create HashSet for bogie IDs (unique values only)
        Set<String> bogieIDs = new HashSet<>();

        // Ask user how many bogie IDs to add
        System.out.print("Enter number of bogie IDs to add: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Add bogie IDs from user input
        for (int i = 1; i <= count; i++) {
            System.out.print("Enter bogie ID " + i + ": ");
            String bogieID = scanner.nextLine();
            boolean added = bogieIDs.add(bogieID);
            if (!added) {
                System.out.println("Duplicate ID ignored: " + bogieID);
            }
        }

        // Display final set of unique bogie IDs
        System.out.println("Unique bogie IDs in train: " + bogieIDs);

        scanner.close();
    }
}
