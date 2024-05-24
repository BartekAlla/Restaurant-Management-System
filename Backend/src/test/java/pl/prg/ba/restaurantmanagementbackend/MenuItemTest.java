package pl.prg.ba.restaurantmanagementbackend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.entity.menuItem.MenuItem;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.model.Ingredient;


import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.*;

public class MenuItemTest {
    private String name;
    private String description;
    private HashSet<Ingredient> ingredients;
    private Double price;
    private Boolean availableStatus;

    @BeforeEach
    public void setUp() {
        name = "Pizza";
        description = "Delicious pizza";
        ingredients = new HashSet<>(Set.of(new Ingredient(1L, "Ham"), new Ingredient(2l, "Cheese")));
        price = 10.99;
        availableStatus = true;
    }

    private MenuItem createMenuItem(String name, String description, HashSet<Ingredient> ingredients, Double price, boolean available) {
        return new MenuItem(name, description, ingredients, price, available);
    }

    @Test
    public void testMenuItemProperties() {

        MenuItem menuItem = createMenuItem(name, description, ingredients, price, availableStatus);


        assertEquals(name, menuItem.getName());
        assertEquals(description, menuItem.getDescription());
        Ingredient[] testIngredientArray = {new Ingredient(1L, "Ham"), new Ingredient(2L, "Cheese")};
        assertArrayEquals(ingredients.toArray(), testIngredientArray);
        assertEquals(price, menuItem.getPrice(), 0.01);
        assertEquals(availableStatus, menuItem.getAvailabilityStatus());
    }

    @Test
    public void testMenuItemPropertiesAfterChange() {


        MenuItem menuItem = createMenuItem(name, description, ingredients, price, availableStatus);
        String newName = "Salad";
        String newDescription = "Delicious salad";
        HashSet<Ingredient> newIngredients = new HashSet<>(Set.of(new Ingredient(1L, "Tomato"), new Ingredient(2l, "Salad")));
        Double newPrice = 5.66;
        boolean newAvailableStatus = false;

        menuItem.setName(newName);
        menuItem.setDescription(newDescription);
        menuItem.setIngredients(newIngredients);
        menuItem.setPrice(newPrice);
        menuItem.setAvailabilityStatus(newAvailableStatus);

        assertEquals(newName, menuItem.getName());
        assertEquals(newDescription, menuItem.getDescription());
        Ingredient[] testHashSet = {new Ingredient(1L, "Tomato"), new Ingredient(2L, "Salad")};
        assertArrayEquals(newIngredients.toArray(), testHashSet);
        assertEquals(newPrice, menuItem.getPrice(), 0.01);
        assertEquals(newAvailableStatus, menuItem.getAvailabilityStatus());
    }

    @Test
    public void testUnicodeCharactersInNameAndDescription() {

        String unicodeName = "Pizzáęą\uD83E\uDEBC";
        String unicodeDescription = "Délicious pizza with chęese and ham";

        MenuItem menuItem = new MenuItem(unicodeName, unicodeDescription, ingredients, price, availableStatus);

        assertEquals(unicodeName, menuItem.getName());
        assertEquals(unicodeDescription, menuItem.getDescription());
    }

    @Test
    public void testNegativePrice() {

        Double price = -10.99;

        try {
            MenuItem menuItem = createMenuItem(name, description, ingredients, price, availableStatus);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Price cannot be negative", e.getMessage());
        }
    }

    @Test
    public void testUnrealItemPrice() {

        price = 201.0;

        try {
            MenuItem menuItem = createMenuItem(name, description, ingredients, price, availableStatus);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Price cannot be higher than " + MenuItem.MAX_MENU_ITEM_PRICE, e.getMessage());
        }
    }

    @Test
    public void testEmptyIngredientsSet() {

        ingredients.clear();

        try {
            MenuItem menuItem = createMenuItem(name, description, ingredients, price, availableStatus);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Ingredient set cannot be empty", e.getMessage());
        }
    }

    @Test
    public void testNullIngredients() {
        try {
            MenuItem menuItem = createMenuItem(name, description, null, price, availableStatus);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException e) {
            assertEquals("Ingredients set cannot be null", e.getMessage());
        }
    }

    @Test
    public void testDuplicateIngredients() {

        HashSet<Ingredient> duplicateIngredients = new HashSet<>();
        duplicateIngredients.add(new Ingredient(1l, "Ham"));
        duplicateIngredients.add(new Ingredient(2l, "Cheese"));
        duplicateIngredients.add(new Ingredient(1l, "Ham"));

        MenuItem menuItem = new MenuItem(name, description, duplicateIngredients, price, availableStatus);

        assertEquals(2, menuItem.getIngredients().size());
        assertTrue(menuItem.getIngredients().contains(new Ingredient(1l, "Ham")));
        assertTrue(menuItem.getIngredients().contains(new Ingredient(2l, "Cheese")));
    }

    @Test
    public void testEmptyDishName() {

        name = "";

        try {
            MenuItem menuItem = createMenuItem(name, description, ingredients, price, availableStatus);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Name cannot be empty String", e.getMessage());
        }
    }

    @Test
    public void testDishNameFullOfWhiteSpaces() {

        name = "     ";

        try {
            MenuItem menuItem = createMenuItem(name, description, ingredients, price, availableStatus);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Name cannot contain only white spaces", e.getMessage());
        }
    }

    @Test
    public void testNullDishName() {

        name = null;

        try {
            MenuItem menuItem = createMenuItem(name, description, ingredients, price, availableStatus);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException e) {
            assertEquals("Name cannot be null", e.getMessage());
        }
    }

    @Test
    public void testEmptyDishDescription() {

        description = "";

        try {
            MenuItem menuItem = createMenuItem(name, description, ingredients, price, availableStatus);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Description cannot be empty String", e.getMessage());
        }
    }

    @Test
    public void testDishDescriptionFullOfWhiteSpaces() {

        description = "     ";

        try {
            MenuItem menuItem = createMenuItem(name, description, ingredients, price, availableStatus);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Description cannot contain only white spaces", e.getMessage());
        }
    }

    @Test
    public void testNullDishDescription() {

        description = null;

        try {
            MenuItem menuItem = createMenuItem(name, description, ingredients, price, availableStatus);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException e) {
            assertEquals("Description cannot be null", e.getMessage());
        }
    }

    @Test
    public void testTooLongDishDescription() {

        description = "\n" +
                "\n" +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed mauris neque, bibendum dictum aliquet in, pharetra ac leo. Sed dapibus justo vitae magna vehicula iaculis. Integer pretium velit eget lacus ullamcorper tincidunt. Nunc dignissim nisl consectetur nibh imperdiet, pellentesque placerat turpis porta. Cras tempus orci risus, at aliquet nulla porttitor ut. Etiam lacus tortor, posuere eget erat non, aliquam iaculis felis. Donec eu velit sapien. Sed at sem neque. Etiam vel est vitae lorem tempus mollis a id neque. Interdum et malesuada fames ac ante ipsum primis in faucibus. Sed a orci tortor. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris in placerat sapien, vel molestie est. Cras porttitor felis a volutpat luctus. Mauris odio diam, pretium scelerisque erat eu, varius commodo est.\n" +
                "\n" +
                "Sed pretium vel sem id mollis. Donec rutrum convallis mauris quis sollicitudin. Nulla pretium eros vulputate elit faucibus consequat. Suspendisse potenti. Donec elementum ut tortor sit amet varius. Vestibulum eu nisi non ex venenatis luctus. Morbi quis nunc elementum, placerat felis sit amet, commodo sem. Donec vitae nisi dictum, placerat est eget, aliquet lorem. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Integer vel auctor lorem, vitae consectetur mi. Donec gravida. ";

        try {
            MenuItem menuItem = createMenuItem(name, description, ingredients, price, availableStatus);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
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
