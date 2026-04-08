package TrainManageApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class GoodsBogie {
    private String type;   // Cylindrical, Rectangular, etc.
    private String cargo;

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return "Goods Bogie: " + type + " | Cargo: " + cargo;
    }
}

public class TrainAppUC12 {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App (UC12) ===");

        Scanner scanner = new Scanner(System.in);

        // Create list of goods bogies
        List<GoodsBogie> goodsBogies = new ArrayList<>();

        // Ask user how many goods bogies to add
        System.out.print("Enter number of goods bogies: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Add bogies with user input
        for (int i = 1; i <= count; i++) {
            System.out.print("Enter bogie " + i + " type (Cylindrical/Rectangular/etc.): ");
            String type = scanner.nextLine();

            System.out.print("Enter cargo for " + type + " bogie: ");
            String cargo = scanner.nextLine();

            goodsBogies.add(new GoodsBogie(type, cargo));
        }

        // Display all goods bogies
        System.out.println("\nAll goods bogies:");
        goodsBogies.forEach(System.out::println);

        // Safety compliance check using Streams
        boolean isSafe = goodsBogies.stream()
                .allMatch(b -> !(b.getType().equalsIgnoreCase("Cylindrical") && !b.getCargo().equalsIgnoreCase("Petroleum")));

        // Display result
        if (isSafe) {
            System.out.println("\nTrain is SAFETY COMPLIANT ✅");
        } else {
            System.out.println("\nTrain is NOT SAFETY COMPLIANT ❌");
        }

        scanner.close();
    }
}
