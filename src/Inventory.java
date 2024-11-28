import java.util.*;
import java.util.stream.Collectors;

public class Inventory {
    private final Map<String, InventoryItem> inventoryMap = new HashMap<>();
    private static final int GLOBAL_THRESHOLD = 5;

    // Add item
    public void addItem(String id, String name, String category, int quantity) {
        if (inventoryMap.containsKey(id)) {
            System.out.println("Item with this ID already exists. Use update option instead.");
            return;
        }
        InventoryItem item = new InventoryItem(id, name, category, quantity);
        inventoryMap.put(id, item);
        System.out.println("Item added: " + item);
        checkRestocking(item);
    }

    // Update item by ID
    public void updateItem(String id, int quantity) {
        InventoryItem item = inventoryMap.get(id);
        if (item == null) {
            System.out.println("Item with this ID does not exist.");
            return;
        }
        item.setQuantity(quantity);
        System.out.println("Item updated: " + item);
        checkRestocking(item);
    }

    // Remove item
    public void deleteItem(String id) {
        InventoryItem removedItem = inventoryMap.remove(id);
        if (removedItem != null) {
            System.out.println("Item removed: " + removedItem);
        } else {
            System.out.println("Item with this ID does not exist.");
        }
    }

    // Search item by ID
    public InventoryItem searchItem(String id) {
        return inventoryMap.get(id);
    }

    // Display all items
    public void displayAllItems() {
        inventoryMap.values().forEach(System.out::println);
    }

    // Display items by category in desc order
    public void displayItemsByCategory(String category) {
        List<InventoryItem> items = inventoryMap.values().stream()
                .filter(item -> item.getCategory().equalsIgnoreCase(category))
                .sorted((a, b) -> Integer.compare(b.getQuantity(), a.getQuantity()))
                .collect(Collectors.toList());

        if (items.isEmpty()) {
            System.out.println("No items found in this category.");
        } else {
            items.forEach(System.out::println);
        }
    }

    // Merge second inventory
    public void mergeInventory(Inventory otherInventory) {
        for (InventoryItem item : otherInventory.inventoryMap.values()) {
            if (inventoryMap.containsKey(item.getId())) {
                InventoryItem existingItem = inventoryMap.get(item.getId());
                if (existingItem.getQuantity() < item.getQuantity()) {
                    existingItem.setQuantity(item.getQuantity());
                }
            } else {
                inventoryMap.put(item.getId(), item);
            }
        }
        System.out.println("Inventories merged successfully.");
    }

    // Top k items
    public List<InventoryItem> getTopKItems(int k) {
        return inventoryMap.values().stream()
                .sorted((a, b) -> Integer.compare(b.getQuantity(), a.getQuantity()))
                .limit(k)
                .collect(Collectors.toList());
    }

    // Restocking alert
    private void checkRestocking(InventoryItem item) {
        if (item.getQuantity() < GLOBAL_THRESHOLD) {
            System.out.println("Restock notification: " + item.getName() + " is below the threshold.");
        }
    }
}
