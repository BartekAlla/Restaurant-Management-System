package pl.prg.ba.restaurantmanagementbackend;

import org.junit.jupiter.api.Test;
import pl.prg.ba.restaurantmanagementbackend.entity.MenuItem;


import java.util.HashSet;

import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuItemTest {
    @Test
    public void testMenuItemProperties(){
        // Given
        String name = "Pizza";
        String description = "Delicious pizza";
        HashSet<String> ingredients = new HashSet<>();
        ingredients.add("Ham");
        ingredients.add("Cheese");
        Double price = 10.99;
        MenuItemCategory category = MenuItemCategory.MAIN;
        boolean available = true;

        // When
        MenuItem menuItem = new MenuItem(name, description, ingredients, price, category, available);

        // Then
        assertEquals(name, menuItem.getName());
        assertEquals(description, menuItem.getDescription());
        String[] testHashSet = {"Ham", "Cheese"};
        assertArrayEquals(ingredients.toArray(), testHashSet);
        assertEquals(price, menuItem.getPrice(), 0.01);
        assertEquals(category, menuItem.getCategory());
        assertEquals(available, menuItem.isAvailabilityStatus());
    }
    //TODO CHECK TEST
    @Test
    public void testNegativePrice() {
        // Given
        String name = "Pizza";
        String description = "Delicious pizza";
        HashSet<String> ingredients = new HashSet<>();
        ingredients.add("Ham");
        ingredients.add("Cheese");
        Double price = -10.99;
        MenuItemCategory category = MenuItemCategory.MAIN;
        boolean available = true;

        // When
        try {
            MenuItem menuItem = new MenuItem(name, description, ingredients, price, category, available);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Then
            assertEquals("Price cannot be negative", e.getMessage());
        }
    }
}
