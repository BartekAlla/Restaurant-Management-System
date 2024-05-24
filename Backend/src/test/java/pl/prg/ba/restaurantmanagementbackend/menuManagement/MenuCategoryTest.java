package pl.prg.ba.restaurantmanagementbackend.menuManagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.entity.category.MenuCategory;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.entity.category.MenuCategoryType;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.entity.menuItem.MenuItem;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.model.Ingredient;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.*;

public class MenuCategoryTest {
    private MenuCategoryType menuCategoryType;
    private HashSet<MenuItem> menuItems;


    @BeforeEach
    public void setUp() {
        menuCategoryType = MenuCategoryType.MAIN;
        menuItems = new HashSet<>();
        HashSet<Ingredient> ingredients1 = new HashSet<>();
        ingredients1.add(new Ingredient(1L, "Ham"));
        ingredients1.add(new Ingredient(2L, "Cheese"));
        MenuItem menuItem1 = new MenuItem("Ham Pizza", "Delicious ham pizza", ingredients1, 10.99, true);
        menuItems.add(menuItem1);
        HashSet<Ingredient> ingredients2 = new HashSet<>();
        ingredients2.add(new Ingredient(3L, "Tomato"));
        ingredients2.add(new Ingredient(4L, "Salami"));
        MenuItem menuItem2 = new MenuItem("Salami Pizza", "Delicious salami pizza", ingredients2, 12.99, true);
        menuItems.add(menuItem2);
    }

    private MenuCategory createMenuCategory(MenuCategoryType menuCategoryType, HashSet<MenuItem> menuItems) {
        return new MenuCategory(menuCategoryType, menuItems);
    }

    @Test
    public void testMenuCategoryType() {

        MenuCategory menuCategory = createMenuCategory(menuCategoryType, menuItems);

        assertEquals(menuCategoryType, menuCategory.getMenuCategoryType());
    }

    @Test
    public void testNullCategoryType() {
        menuCategoryType = null;

        try {

            MenuCategory menuCategory = createMenuCategory(menuCategoryType, menuItems);
            ;
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException e) {
            assertEquals("MenuCategoryType cannot be null", e.getMessage());
        }
    }

    @Test
    public void testAddMenuItem() {
        MenuCategory menuCategory = createMenuCategory(menuCategoryType, menuItems);
        MenuItem newItem = new MenuItem("Veggie Pizza", "Delicious veggie pizza", new HashSet<>(Set.of(new Ingredient(1L, "Tomato"), new Ingredient(2L, "Pepper"))), 11.99, true);
        menuCategory.addMenuItem(newItem);
        assertTrue(menuCategory.getMenuItems().contains(newItem));
    }

    @Test
    public void testRemoveMenuItem() {
        MenuCategory menuCategory = createMenuCategory(menuCategoryType, menuItems);
        MenuItem itemToRemove = new MenuItem("Ham Pizza", "Delicious ham pizza", new HashSet<>(Set.of(new Ingredient(1L, "Ham"), new Ingredient(2L, "Cheese"))), 10.99, true);
        menuCategory.removeMenuItem(itemToRemove);
        assertFalse(menuCategory.getMenuItems().contains(itemToRemove));
    }

    @Test
    public void testAddDuplicateMenuItem() {
        MenuCategory menuCategory = new MenuCategory(menuCategoryType, new HashSet<>());
        MenuItem duplicateItem = new MenuItem("Ham Pizza", "Delicious ham pizza", new HashSet<>(Set.of(new Ingredient(1L, "Ham"), new Ingredient(2L, "Cheese"))), 10.99, true);
        menuCategory.addMenuItem(duplicateItem);
        menuCategory.addMenuItem(duplicateItem);
        assertEquals(1, menuCategory.getMenuItems().size());
    }

    @Test
    public void testRemoveNonExistentMenuItem() {
        MenuCategory menuCategory = createMenuCategory(menuCategoryType, menuItems);
        MenuItem nonExistentItem = new MenuItem("Non Existent Pizza", "This pizza does not exist", new HashSet<>(Set.of(new Ingredient(1L, "Imaginary"), new Ingredient(2L, "Ingredients"))), 9.99, true);
        menuCategory.removeMenuItem(nonExistentItem);
        assertEquals(2, menuCategory.getMenuItems().size());
    }

    @Test
    public void testChangeAvailabilityStatus() {
        MenuCategory menuCategory = createMenuCategory(menuCategoryType, menuItems);
        MenuItem itemToChange = new MenuItem("Ham Pizza", "Delicious ham pizza", new HashSet<>(Set.of(new Ingredient(1L, "Ham"), new Ingredient(2L, "Cheese"))), 10.99, false);
        menuCategory.addMenuItem(itemToChange);
        itemToChange.setAvailabilityStatus(true);
        assertTrue(menuCategory.getMenuItems().stream().anyMatch(item -> item.getName().equals("Ham Pizza") && item.getAvailabilityStatus()));
    }
}
