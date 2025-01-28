package singlylinkedlist.inventorymanagementsystem;

public class ItemMain {
    public static void main(String[] args) {
        InventoryManagement inventory = new InventoryManagement();

        // Add items
        inventory.addItemAtBeginning("Item1", 101, 10, 5.99);
        inventory.addItemAtEnd("Item2", 102, 20, 3.49);
        inventory.addItemAtPosition(2, "Item3", 103, 15, 4.99);

        // Display inventory
        inventory.displayInventory();

        // Update quantity
        inventory.updateQuantityById(102, 25);

        // Search item
        inventory.searchItemById(103);
        inventory.searchItemByName("Item2");

        // Calculate total value
        inventory.calculateTotalValue();

        // Sort inventory
        inventory.sortInventoryByName();
        System.out.println("Inventory sorted by name:");
        inventory.displayInventory();

        // Remove an item
        inventory.removeItemById(101);
        inventory.displayInventory();
    }
}

