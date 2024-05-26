import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SILab2Test {

    @Test
    void testEveryBranch() {
        // Test case 1: allItems is null
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(null, 100);
        });
        assertEquals("allItems list can't be null!", exception.getMessage());

        // Test case 2: allItems is empty
        assertTrue(SILab2.checkCart(new ArrayList<>(), 100));

        // Test case 3: item name is null and barcode is null
        List<Item> items = new ArrayList<>();
        items.add(new Item(null, null, 100, 0));
        exception = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(items, 100);
        });
        assertEquals("No barcode!", exception.getMessage());

        // Test case 4: item name is empty and barcode is valid
        items.clear();
        items.add(new Item("", "123456", 100, 0));
        assertTrue(SILab2.checkCart(items, 100));

        // Test case 5: item name is valid and barcode is invalid
        items.clear();
        items.add(new Item("name", "12345a", 100, 0));
        exception = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(items, 100);
        });
        assertEquals("Invalid character in item barcode!", exception.getMessage());

        // Test case 6: item price > 300, discount > 0, barcode starts with '0'
        items.clear();
        items.add(new Item("name", "012345", 400, 0.1f));
        assertFalse(SILab2.checkCart(items, 100));

        // Test case 7: multiple items with valid barcodes and discounts
        items.clear();
        items.add(new Item("name", "123456", 100, 0.2f));
        items.add(new Item("name", "234567", 200, 0));
        assertTrue(SILab2.checkCart(items, 300));

        // Test case 8: high price, discount, and barcode starts with '0'
        items.clear();
        items.add(new Item("name", "012345", 400, 0.1f));
        items.add(new Item("name", "234567", 100, 0));
        assertTrue(SILab2.checkCart(items, 300));
    }

    @Test
    void testMultipleCondition() {
        // Test case 1: price > 300, discount > 0, barcode starts with '0'
        List<Item> items = new ArrayList<>();
        items.add(new Item("name", "012345", 400, 0.1f));
        assertFalse(SILab2.checkCart(items, 100));  // Condition is true

        // Test case 2: price > 300, discount > 0, barcode does not start with '0'
        items.clear();
        items.add(new Item("name", "112345", 400, 0.1f));
        assertTrue(SILab2.checkCart(items, 100));  // Condition is false

        // Test case 3: price > 300, discount <= 0, barcode starts with '0'
        items.clear();
        items.add(new Item("name", "012345", 400, 0.0f));
        assertFalse(SILab2.checkCart(items, 100));  // Condition is false

        // Test case 4: price > 300, discount <= 0, barcode does not start with '0'
        items.clear();
        items.add(new Item("name", "112345", 400, 0.0f));
        assertFalse(SILab2.checkCart(items, 100));  // Condition is false

        // Test case 5: price <= 300, discount > 0, barcode starts with '0'
        items.clear();
        items.add(new Item("name", "012345", 300, 0.1f));
        assertTrue(SILab2.checkCart(items, 100));  // Condition is false

        // Test case 6: price <= 300, discount > 0, barcode does not start with '0'
        items.clear();
        items.add(new Item("name", "112345", 300, 0.1f));
        assertTrue(SILab2.checkCart(items, 100));  // Condition is false

        // Test case 7: price <= 300, discount <= 0, barcode starts with '0'
        items.clear();
        items.add(new Item("name", "012345", 300, 0.0f));
        assertTrue(SILab2.checkCart(items, 100));  // Condition is false

        // Test case 8: price <= 300, discount <= 0, barcode does not start with '0'
        items.clear();
        items.add(new Item("name", "112345", 300, 0.0f));
        assertTrue(SILab2.checkCart(items, 100));  // Condition is false
    }
}
