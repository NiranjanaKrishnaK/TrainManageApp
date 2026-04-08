package TrainManageApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Custom Exception Class
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// Passenger Bogie Class
class PassengerBogie {
    private String name;
    private int capacity;

    public PassengerBogie(String name, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Passenger Bogie: " + name + " | Capacity: " + capacity;
    }
}

public class TrainAppUC14 {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App (UC14) ===");

        Scanner scanner = new Scanner(System.in);
        List<PassengerBogie> bogies = new ArrayList<>();

        System.out.print("Enter number of passenger bogies: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 1; i <= count; i++) {
            try {
                System.out.print("Enter bogie " + i + " name: ");
                String name = scanner.nextLine();

                System.out.print("Enter seating capacity for " + name + ": ");
                int capacity = scanner.nextInt();
                scanner.nextLine(); // consume newline

                PassengerBogie bogie = new PassengerBogie(name, capacity);
                bogies.add(bogie);
                System.out.println("Successfully added: " + bogie);

            } catch (InvalidCapacityException e) {
                System.out.println("Error creating bogie: " + e.getMessage());
            }
        }

        // Display all valid bogies
        System.out.println("\nFinal list of valid passenger bogies:");
        bogies.forEach(System.out::println);

        scanner.close();
    }
}