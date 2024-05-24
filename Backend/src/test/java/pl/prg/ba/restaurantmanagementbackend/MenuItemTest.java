package pl.prg.ba.restaurantmanagementbackend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.prg.ba.restaurantmanagementbackend.entity.MenuItem.MenuItem;
import pl.prg.ba.restaurantmanagementbackend.entity.MenuItem.MenuItemCategory;


import java.util.HashSet;

import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuItemTest {
    private String name;
    private String description;
    private HashSet<String> ingredients;
    private Double price;
    private MenuItemCategory category;
    private boolean available;

    @BeforeEach
    public void setUp() {
        name = "Pizza";
        description = "Delicious pizza";
        ingredients = new HashSet<>();
        ingredients.add("Ham");
        ingredients.add("Cheese");
        price = 10.99;
        category = MenuItemCategory.MAIN;
        available = true;
    }
    private MenuItem createMenuItem(String name, String description, HashSet<String> ingredients, Double price, MenuItemCategory category, boolean available) {
        return new MenuItem(name, description, ingredients, price, category, available);
    }

    @Test
    public void testMenuItemProperties(){
        // When
        MenuItem menuItem = createMenuItem(name, description, ingredients, price, category, available);

        // Then
        assertEquals(name, menuItem.getName());
        assertEquals(description, menuItem.getDescription());
        String[] testHashSet = {"Ham", "Cheese"};
        assertArrayEquals(ingredients.toArray(), testHashSet);
        assertEquals(price, menuItem.getPrice(), 0.01);
        assertEquals(category, menuItem.getCategory());
        assertEquals(available, menuItem.isAvailabilityStatus());
    }
    @Test
    public void testNegativePrice() {
        // Given
        Double price = -10.99;

        // When
        try {
            MenuItem menuItem = createMenuItem(name, description, ingredients, price, category, available);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Then
            assertEquals("Price cannot be negative", e.getMessage());
        }
    }
    @Test
    public void testUnrealItemPrice() {
        // Given
        price = 201.0;
        // When
        try {
            MenuItem menuItem = createMenuItem(name, description, ingredients, price, category, available);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Then
            assertEquals("Price cannot be higher than 200", e.getMessage());
        }
    }
    @Test
    public void testEmptyIngredientsSet() {
        // Given
        ingredients.remove("Ham");
        ingredients.remove("Cheese");
        // When
        try {
            MenuItem menuItem = createMenuItem(name, description, ingredients, price, category, available);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Then
            assertEquals("Ingredient set cannot be empty", e.getMessage());
        }
    }
    @Test
    public void testEmptyDishName() {
        // Given
        name = "";
        // When
        try {
            MenuItem menuItem = createMenuItem(name, description, ingredients, price, category, available);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Then
            assertEquals("Name cannot be empty String", e.getMessage());
        }
    }
    @Test
    public void testDishNameFullOfWhiteSpaces() {
        // Given
        name = "     ";
        // When
        try {
            MenuItem menuItem = createMenuItem(name, description, ingredients, price, category, available);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Then
            assertEquals("Name cannot contain only white spaces", e.getMessage());
        }
    }
    @Test
    public void testNullDishName() {
        // Given
        name = null;
        // When
        try {
            MenuItem menuItem = createMenuItem(name, description, ingredients, price, category, available);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException e) {
            // Then
            assertEquals("Name cannot be null", e.getMessage());
        }
    }
    @Test
    public void testNullMenuItemCategory() {
        // Given
        category = null;
        // When
        try {
            MenuItem menuItem = createMenuItem(name, description, ingredients, price, category, available);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException e) {
            // Then
            assertEquals("Category cannot be null", e.getMessage());
        }
    }

}
