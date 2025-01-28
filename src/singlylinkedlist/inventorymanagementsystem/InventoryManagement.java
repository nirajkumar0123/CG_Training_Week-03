package singlylinkedlist.inventorymanagementsystem;

class InventoryManagement {
    private Item head = null;

    // Add an item at the beginning
    public void addItemAtBeginning(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    // Add an item at the end
    public void addItemAtEnd(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (head == null) {
            head = newItem;
        } else {
            Item temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newItem;
        }
    }

    // Add an item at a specific position
    public void addItemAtPosition(int position, String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (position == 1) {
            newItem.next = head;
            head = newItem;
            return;
        }

        Item temp = head;
        int count = 1;
        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            System.out.println("Invalid position.");
        } else {
            newItem.next = temp.next;
            temp.next = newItem;
        }
    }

    // Remove an item based on Item ID
    public void removeItemById(int itemId) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        // If the item to be removed is the head
        if (head.itemId == itemId) {
            head = head.next;
            System.out.println("Item with ID " + itemId + " removed.");
            return;
        }

        Item temp = head;
        while (temp.next != null && temp.next.itemId != itemId) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Item with ID " + itemId + " not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Item with ID " + itemId + " removed.");
        }
    }

    // Update the quantity of an item by Item ID
    public void updateQuantityById(int itemId, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                System.out.println("Quantity updated for Item ID " + itemId);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    // Search for an item by Item ID
    public void searchItemById(int itemId) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                System.out.println("Item found: Name: " + temp.itemName + ", ID: " + temp.itemId +
                        ", Quantity: " + temp.quantity + ", Price: " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    // Search for an item by Item Name
    public void searchItemByName(String itemName) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemName.equals(itemName)) {
                System.out.println("Item found: Name: " + temp.itemName + ", ID: " + temp.itemId +
                        ", Quantity: " + temp.quantity + ", Price: " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item with name " + itemName + " not found.");
    }

    // Calculate and display total value of inventory
    public void calculateTotalValue() {
        double totalValue = 0;
        Item temp = head;

        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }

        System.out.println("Total value of inventory: $" + totalValue);
    }

    // Sort the inventory by Item Name in ascending order
    public void sortInventoryByName() {
        if (head == null || head.next == null) {
            return;
        }

        boolean swapped;
        do {
            swapped = false;
            Item current = head;

            while (current.next != null) {
                if (current.itemName.compareTo(current.next.itemName) > 0) {
                    // Swap item names
                    String tempName = current.itemName;
                    current.itemName = current.next.itemName;
                    current.next.itemName = tempName;

                    // Swap item IDs
                    int tempId = current.itemId;
                    current.itemId = current.next.itemId;
                    current.next.itemId = tempId;

                    // Swap quantities
                    int tempQuantity = current.quantity;
                    current.quantity = current.next.quantity;
                    current.next.quantity = tempQuantity;

                    // Swap prices
                    double tempPrice = current.price;
                    current.price = current.next.price;
                    current.next.price = tempPrice;

                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    // Display all items
    public void displayInventory() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        Item temp = head;
        System.out.println("Inventory:");
        while (temp != null) {
            System.out.println("Name: " + temp.itemName + ", ID: " + temp.itemId +
                    ", Quantity: " + temp.quantity + ", Price: $" + temp.price);
            temp = temp.next;
        }
    }
}

