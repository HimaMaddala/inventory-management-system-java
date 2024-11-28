# Inventory Management System

A Java-based inventory management system designed to manage and organize inventory efficiently. This application allows operations like adding, updating, deleting, and searching inventory items while ensuring optimal use of Java's collection framework.

---

## Key Features
1. **Inventory Operations**: Add, update, delete, and search items by their unique ID.
2. **Display Inventory**: List all items or filter by category in descending order of quantity.
3. **Restocking Notification**: Alerts when an item's quantity drops below the threshold (default: 5).
4. **Static Data for Chennai Shop**: Preloaded inventory data for demonstration purposes.
5. **Merge Inventories**: Combine two inventories, retaining items with higher quantities for duplicate IDs.
6. **Top K Items**: Retrieve the top K items with the highest quantity.
7. **Modular Design**: Separate classes for `Inventory` and `InventoryItem` for better code organization.
8. **Streamlined Workflow**: Uses `HashMap`, `Stream API`, and other Java collections for efficient operations.

---

## Workflow
1. **Hyderabad Shop Inventory**:
   - Dynamic inventory managed through a user-friendly menu.
   - Options include adding, updating, deleting, searching, and displaying items.

2. **Chennai Shop Inventory**:
   - Preloaded inventory items for testing merge functionality.
   - Hardcoded sample data demonstrates merging workflows.

3. **Inventory Merge**:
   - Combines Hyderabad and Chennai inventories.
   - Resolves conflicts by retaining items with higher quantities.

4. **Restocking Alerts**:
   - Automatically notifies when an item's quantity is below the threshold.

5. **Category-based Display**:
   - Lists items by category in descending order of their quantities.

6. **Top K Items**:
   - Displays the top K items with the highest quantities across all categories.

---

## How to Run
1. Open the project in IntelliJ IDEA (or any Java IDE).
2. Run the `Main.java` file.
3. Follow the menu to perform inventory operations for the Hyderabad Shop.
4. View static inventory for Chennai Shop and merge with Hyderabad Shop.
5. Test other functionalities like top K items and category-based display.

---

## Dependencies
- **Java SE 8 or later**
- **Java Collections Framework** (e.g., `HashMap`, `Stream API`)

---

## File Structure
- `InventoryItem.java`: Represents individual inventory items.
- `Inventory.java`: Contains logic for managing inventory operations.
- `Main.java`: Entry point for running the application, includes menu-driven options.
