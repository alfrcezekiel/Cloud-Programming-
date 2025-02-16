import java.util.Scanner;

public class InventoryManagmentApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try (input) {
            InventoryManagementSystem ims = new InventoryManagementSystem();
            do {
                System.out.println("*********************************************");
                System.out.println("Welcome to Inventory Management System \nby Aelfric Ezekiel Amor");
                System.out.println("*********************************************");
    
                System.out.println("\nMenu");
                System.out.println("1. Add Product");
                System.out.println("2. Display Products");
                System.out.println("3. Exit");
    
                System.out.print("Enter your choice: ");
                int choice = input.nextInt();
    
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter product name: ");
                        String name = input.next();
                        System.out.println("Enter product price: ");
                        int price = input.nextInt();
                        ims.addProduct(name, price);
                        break;
                    }
                    case 2 -> {
                        ims.displayProducts();
                        break;
                    }
                    case 3 -> {
                        System.out.println("Exiting the progeram. Goodbye!");
                        break;
                    }
                    default -> {
                        System.out.println("Invalid choice");
                        break;
                    }
                }
            } while (true);
            
        } catch (Exception e) {
            System.out.println("An error occured: " + e.getMessage());
        }
    }
}
