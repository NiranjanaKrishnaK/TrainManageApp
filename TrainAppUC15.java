package TrainManageApp;

import java.util.Scanner;

// Custom Runtime Exception
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

// Goods Bogie Class
class GoodsBogie {
    private String type;   // Cylindrical, Rectangular, etc.
    private String cargo;

    public GoodsBogie(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    // Assign cargo with safety validation
    public void assignCargo(String cargo) {
        try {
            if (type.equalsIgnoreCase("Rectangular") && cargo.equalsIgnoreCase("Petroleum")) {
                throw new CargoSafetyException("Unsafe assignment: Petroleum cannot be carried in a Rectangular bogie!");
            }
            this.cargo = cargo;
            System.out.println("Cargo assigned successfully: " + this);

        } catch (CargoSafetyException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Cargo assignment attempt completed for bogie type: " + type);
        }
    }

    @Override
    public String toString() {
        return "Goods Bogie: " + type + " | Cargo: " + (cargo == null ? "None" : cargo);
    }
}

public class TrainAppUC15 {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App (UC15) ===");

        Scanner scanner = new Scanner(System.in);

        // User input for bogie type
        System.out.print("Enter bogie type (Cylindrical/Rectangular/etc.): ");
        String type = scanner.nextLine();

        GoodsBogie bogie = new GoodsBogie(type);

        // User input for cargo assignment
        System.out.print("Enter cargo to assign: ");
        String cargo = scanner.nextLine();

        // Attempt cargo assignment with try-catch-finally
        bogie.assignCargo(cargo);

        // Continue program safely
        System.out.println("\nFinal bogie state: " + bogie);

        scanner.close();
    }
}