import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventory hyderabadShop = new Inventory();
        Inventory chennaiShop = new Inventory();

        //chennaiShop with sample data
        chennaiShop.addItem("201", "Laptop", "Electronics", 10);
        chennaiShop.addItem("202", "Chair", "Furniture", 15);
        chennaiShop.addItem("203", "Rice", "Groceries", 20);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Hyderabad Shop Inventory Management ---");
            System.out.println("1. Add Item");
            System.out.println("2. Update Item");
            System.out.println("3. Delete Item");
            System.out.println("4. Search Item");
            System.out.println("5. Display All Items");
            System.out.println("6. Display Items by Category");
            System.out.println("7. Merge Inventories");
            System.out.println("8. Top K Items");
            System.out.println("9. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Item ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Item Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Item Category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    hyderabadShop.addItem(id, name, category, quantity);
                }
                case 2 -> {
                    System.out.print("Enter Item ID to update: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter New Quantity: ");
                    int quantity = scanner.nextInt();
                    hyderabadShop.updateItem(id, quantity);
                }
                case 3 -> {
                    System.out.print("Enter Item ID to delete: ");
                    String id = scanner.nextLine();
                    hyderabadShop.deleteItem(id);
                }
                case 4 -> {
                    System.out.print("Enter Item ID to search: ");
                    String id = scanner.nextLine();
                    InventoryItem item = hyderabadShop.searchItem(id);
                    if (item != null) {
                        System.out.println(item);
                    } else {
                        System.out.println("Item not found.");
                    }
                }
                case 5 -> {
                    System.out.println("\n--- All Items in Inventory ---");
                    hyderabadShop.displayAllItems();
                }
                case 6 -> {
                    System.out.print("Enter Category: ");
                    String category = scanner.nextLine();
                    System.out.println("\n--- Items in " + category + " ---");
                    hyderabadShop.displayItemsByCategory(category);
                }
                case 7 -> {
                    hyderabadShop.mergeInventory(chennaiShop);
                }
                case 8 -> {
                    System.out.print("Enter the value of K: ");
                    int k = scanner.nextInt();
                    System.out.println("\n--- Top " + k + " Items ---");
                    hyderabadShop.getTopKItems(k).forEach(System.out::println);
                }
                case 9 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option! Please try again.");
            }
        }
    }
}
