package TrainManageApp;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrainAppUC11 {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App (UC11) ===");

        Scanner scanner = new Scanner(System.in);

        // Regex patterns
        String trainIdPattern = "TRN-\\d{4}";       // TRN- followed by exactly 4 digits
        String cargoCodePattern = "PET-[A-Z]{2}";   // PET- followed by exactly 2 uppercase letters

        Pattern trainPattern = Pattern.compile(trainIdPattern);
        Pattern cargoPattern = Pattern.compile(cargoCodePattern);

        // User input for Train ID
        System.out.print("Enter Train ID (format TRN-1234): ");
        String trainId = scanner.nextLine();

        Matcher trainMatcher = trainPattern.matcher(trainId);
        if (trainMatcher.matches()) {
            System.out.println("Valid Train ID: " + trainId);
        } else {
            System.out.println("Invalid Train ID format! Expected TRN-1234.");
        }

        // User input for Cargo Code
        System.out.print("Enter Cargo Code (format PET-AB): ");
        String cargoCode = scanner.nextLine();

        Matcher cargoMatcher = cargoPattern.matcher(cargoCode);
        if (cargoMatcher.matches()) {
            System.out.println("Valid Cargo Code: " + cargoCode);
        } else {
            System.out.println("Invalid Cargo Code format! Expected PET-AB.");
        }

        scanner.close();
    }
}
