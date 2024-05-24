package pl.prg.ba.restaurantmanagementbackend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.prg.ba.restaurantmanagementbackend.entity.menuItem.MenuItem;


import java.util.HashSet;

import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.*;

public class MenuItemTest {
    private String name;
    private String description;
    private HashSet<String> ingredients;
    private Double price;
    private boolean availableStatus;

    @BeforeEach
    public void setUp() {
        name = "Pizza";
        description = "Delicious pizza";
        ingredients = new HashSet<>();
        ingredients.add("Ham");
        ingredients.add("Cheese");
        price = 10.99;
        availableStatus = true;
    }
    private MenuItem createMenuItem(String name, String description, HashSet<String> ingredients, Double price, boolean available) {
        return new MenuItem(name, description, ingredients, price, available);
    }

    @Test
    public void testMenuItemProperties(){
        // When
        MenuItem menuItem = createMenuItem(name, description, ingredients, price, availableStatus);

        // Then
        assertEquals(name, menuItem.getName());
        assertEquals(description, menuItem.getDescription());
        String[] testHashSet = {"Ham", "Cheese"};
        assertArrayEquals(ingredients.toArray(), testHashSet);
        assertEquals(price, menuItem.getPrice(), 0.01);
        assertEquals(availableStatus, menuItem.isAvailabilityStatus());
    }
    @Test
    public void testMenuItemPropertiesAfterChange(){
        // When

        MenuItem menuItem = createMenuItem(name, description, ingredients, price, availableStatus);
        String newName = "Salad";
        String newDescription = "Delicious salad";
        HashSet<String> newIngredients = new HashSet<>();
        newIngredients.add("Tomato");
        newIngredients.add("Salad");
        Double newPrice = 5.66;
        boolean newAvailableStatus = false;

        menuItem.setName(newName);
        menuItem.setDescription(newDescription);
        menuItem.setIngredients(newIngredients);
        menuItem.setPrice(newPrice);
        menuItem.setAvailabilityStatus(newAvailableStatus);

        // Then
        assertEquals(newName, menuItem.getName());
        assertEquals(newDescription, menuItem.getDescription());
        String[] testHashSet = {"Tomato", "Salad"};
        assertArrayEquals(newIngredients.toArray(), testHashSet);
        assertEquals(newPrice, menuItem.getPrice(), 0.01);
        assertEquals(newAvailableStatus, menuItem.isAvailabilityStatus());
    }
    @Test
    public void testUnicodeCharactersInNameAndDescription() {
        // Given
        String unicodeName = "Pizzáęą\uD83E\uDEBC";
        String unicodeDescription = "Délicious pizza with chęese and ham";

        // When
        MenuItem menuItem = new MenuItem(unicodeName, unicodeDescription, ingredients, price, availableStatus);

        // Then
        assertEquals(unicodeName, menuItem.getName());
        assertEquals(unicodeDescription, menuItem.getDescription());
    }
    @Test
    public void testNegativePrice() {
        // Given
        Double price = -10.99;

        // When
        try {
            MenuItem menuItem = createMenuItem(name, description, ingredients, price, availableStatus);
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
            MenuItem menuItem = createMenuItem(name, description, ingredients, price, availableStatus);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Then
            assertEquals("Price cannot be higher than " + MenuItem.MAX_MENU_ITEM_PRICE, e.getMessage());
        }
    }
    @Test
    public void testEmptyIngredientsSet() {
        // Given
        ingredients.clear();
        // When
        try {
            MenuItem menuItem = createMenuItem(name, description, ingredients, price, availableStatus);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Then
            assertEquals("Ingredient set cannot be empty", e.getMessage());
        }
    }
    @Test
    public void testNullIngredients() {
        // When
        try {
            MenuItem menuItem = createMenuItem(name, description, null, price, availableStatus);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException e) {
            // Then
            assertEquals("Ingredients set cannot be null", e.getMessage());
        }
    }
    @Test
    public void testDuplicateIngredients() {
        // Given
        HashSet<String> duplicateIngredients = new HashSet<>();
        duplicateIngredients.add("Ham");
        duplicateIngredients.add("Cheese");
        duplicateIngredients.add("Ham");

        // When
        MenuItem menuItem = new MenuItem(name, description, duplicateIngredients, price, availableStatus);

        // Then
        // Checking that "Ham" is not duplicated
        assertEquals(2, menuItem.getIngredients().size());
        assertTrue(menuItem.getIngredients().contains("Ham"));
        assertTrue(menuItem.getIngredients().contains("Cheese"));
    }
    @Test
    public void testEmptyDishName() {
        // Given
        name = "";
        // When
        try {
            MenuItem menuItem = createMenuItem(name, description, ingredients, price, availableStatus);
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
            MenuItem menuItem = createMenuItem(name, description, ingredients, price, availableStatus);
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
            MenuItem menuItem = createMenuItem(name, description, ingredients, price, availableStatus);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException e) {
            // Then
            assertEquals("Name cannot be null", e.getMessage());
        }
    }
    @Test
    public void testEmptyDishDescription() {
        // Given
        description = "";
        // When
        try {
            MenuItem menuItem = createMenuItem(name, description, ingredients, price, availableStatus);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Then
            assertEquals("Description cannot be empty String", e.getMessage());
        }
    }
    @Test
    public void testDishDescriptionFullOfWhiteSpaces() {
        // Given
        description = "     ";
        // When
        try {
            MenuItem menuItem = createMenuItem(name, description, ingredients, price, availableStatus);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Then
            assertEquals("Description cannot contain only white spaces", e.getMessage());
        }
    }
    @Test
    public void testNullDishDescription() {
        // Given
        description = null;
        // When
        try {
            MenuItem menuItem = createMenuItem(name, description, ingredients, price, availableStatus);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException e) {
            // Then
            assertEquals("Description cannot be null", e.getMessage());
        }
    }
    @Test
    public void testTooLongDishDescription() {
        //Given
        description = "\n" +
                "\n" +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed mauris neque, bibendum dictum aliquet in, pharetra ac leo. Sed dapibus justo vitae magna vehicula iaculis. Integer pretium velit eget lacus ullamcorper tincidunt. Nunc dignissim nisl consectetur nibh imperdiet, pellentesque placerat turpis porta. Cras tempus orci risus, at aliquet nulla porttitor ut. Etiam lacus tortor, posuere eget erat non, aliquam iaculis felis. Donec eu velit sapien. Sed at sem neque. Etiam vel est vitae lorem tempus mollis a id neque. Interdum et malesuada fames ac ante ipsum primis in faucibus. Sed a orci tortor. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris in placerat sapien, vel molestie est. Cras porttitor felis a volutpat luctus. Mauris odio diam, pretium scelerisque erat eu, varius commodo est.\n" +
                "\n" +
                "Sed pretium vel sem id mollis. Donec rutrum convallis mauris quis sollicitudin. Nulla pretium eros vulputate elit faucibus consequat. Suspendisse potenti. Donec elementum ut tortor sit amet varius. Vestibulum eu nisi non ex venenatis luctus. Morbi quis nunc elementum, placerat felis sit amet, commodo sem. Donec vitae nisi dictum, placerat est eget, aliquet lorem. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Integer vel auctor lorem, vitae consectetur mi. Donec gravida. ";
        //When
        try {
            MenuItem menuItem = createMenuItem(name, description, ingredients, price, availableStatus);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            //Then
            assertEquals("Description too long - cannot contain more than 500 signs", e.getMessage());
        }
    }
    @Test
    public void testIfTwoItemsWithSamePropertiesAreEqual() {
        MenuItem menuItem1 = createMenuItem(name, description, ingredients, price, availableStatus);
        MenuItem menuItem2 = createMenuItem(name, description, ingredients, price, availableStatus);
        assertEquals(menuItem1, menuItem2);
    }
    @Test
    public void testIfTwoItemsWithSamePropertiesHaveTheSameHashCode() {
        MenuItem menuItem1 = createMenuItem(name, description, ingredients, price, availableStatus);
        MenuItem menuItem2 = createMenuItem(name, description, ingredients, price, availableStatus);
        assertEquals(menuItem1.hashCode(), menuItem2.hashCode());
    }

}
