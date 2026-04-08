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

public class TrainAppUC13 {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App (UC13) ===");

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

            System.out.print("Enter capacity for " + name + ": ");
            int capacity = scanner.nextInt();
            scanner.nextLine(); // consume newline

            bogies.add(new Bogie(name, capacity));
        }

        // Threshold for filtering
        System.out.print("\nEnter capacity threshold for filtering: ");
        int threshold = scanner.nextInt();

        // Loop-based filtering
        long loopStart = System.nanoTime();
        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > threshold) {
                loopFiltered.add(b);
            }
        }
        long loopEnd = System.nanoTime();
        long loopDuration = loopEnd - loopStart;

        // Stream-based filtering
        long streamStart = System.nanoTime();
        List<Bogie> streamFiltered = bogies.stream()
                .filter(b -> b.getCapacity() > threshold)
                .collect(Collectors.toList());
        long streamEnd = System.nanoTime();
        long streamDuration = streamEnd - streamStart;

        // Display results
        System.out.println("\n=== Loop Filtering Results ===");
        loopFiltered.forEach(System.out::println);
        System.out.println("Loop execution time (ns): " + loopDuration);

        System.out.println("\n=== Stream Filtering Results ===");
        streamFiltered.forEach(System.out::println);
        System.out.println("Stream execution time (ns): " + streamDuration);

        scanner.close();
    }
}