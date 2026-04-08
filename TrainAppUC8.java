package TrainManageApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
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
        return "Bogie: " + name + " | Capacity: " + capacity;
    }
}

public class TrainAppUC8 {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App (UC8) ===");

        Scanner scanner = new Scanner(System.in);

        // Create list of bogies
        List<Bogie> bogies = new ArrayList<>();

        // Ask user how many bogies to add
        System.out.print("Enter number of passenger bogies: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Add bogies with user input
        for (int i = 1; i <= count; i++) {
            System.out.print("Enter bogie " + i + " name: ");
            String name = scanner.nextLine();

            System.out.print("Enter capacity for " + name + ": ");
            int capacity = scanner.nextInt();
            scanner.nextLine(); // consume newline

            bogies.add(new Bogie(name, capacity));
        }

        // Display all bogies
        System.out.println("\nAll bogies:");
        bogies.forEach(System.out::println);

        // Ask user for capacity threshold
        System.out.print("\nEnter capacity threshold for filtering: ");
        int threshold = scanner.nextInt();

        // Filter bogies using Stream API
        List<Bogie> filteredBogies = bogies.stream()
                .filter(b -> b.getCapacity() > threshold)
                .collect(Collectors.toList());

        // Display filtered bogies
        System.out.println("\nBogies with capacity greater than " + threshold + ":");
        filteredBogies.forEach(System.out::println);

        scanner.close();
    }
}