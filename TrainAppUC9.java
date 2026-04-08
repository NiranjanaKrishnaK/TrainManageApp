package TrainManageApp;

import java.util.*;
import java.util.stream.Collectors;

class Bogie {
    private String name;
    private String type;   // Passenger or Goods
    private int capacity;

    public Bogie(String name, String type, int capacity) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Bogie: " + name + " | Type: " + type + " | Capacity: " + capacity;
    }
}

public class TrainAppUC9 {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App (UC9) ===");

        Scanner scanner = new Scanner(System.in);

        // Create list of bogies
        List<Bogie> bogies = new ArrayList<>();

        // Ask user how many bogies to add
        System.out.print("Enter number of bogies: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Add bogies with user input
        for (int i = 1; i <= count; i++) {
            System.out.print("Enter bogie " + i + " name: ");
            String name = scanner.nextLine();

            System.out.print("Enter bogie type (Passenger/Goods): ");
            String type = scanner.nextLine();

            System.out.print("Enter capacity for " + name + ": ");
            int capacity = scanner.nextInt();
            scanner.nextLine(); // consume newline

            bogies.add(new Bogie(name, type, capacity));
        }

        // Display all bogies
        System.out.println("\nAll bogies:");
        bogies.forEach(System.out::println);

        // Group bogies by type using Stream API
        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        // Display grouped bogies
        System.out.println("\nGrouped bogies by type:");
        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println("Type: " + entry.getKey());
            entry.getValue().forEach(System.out::println);
        }

        scanner.close();
    }
}