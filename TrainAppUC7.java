package TrainManageApp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

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

public class TrainAppUC7 {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App (UC7) ===");

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

        // Display bogies before sorting
        System.out.println("\nBogies before sorting:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        // Sort bogies by capacity using Comparator
        bogies.sort(Comparator.comparingInt(Bogie::getCapacity));

        // Display bogies after sorting
        System.out.println("\nBogies sorted by capacity:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        scanner.close();
    }
}