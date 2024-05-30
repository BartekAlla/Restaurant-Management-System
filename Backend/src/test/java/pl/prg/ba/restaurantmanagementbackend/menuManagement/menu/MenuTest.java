package pl.prg.ba.restaurantmanagementbackend.menuManagement.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.entity.category.MenuCategory;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.entity.category.MenuCategoryType;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.entity.menu.Menu;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.entity.menuItem.MenuItem;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.entity.ingredient.Ingredient;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {
    private Menu menu;
    private String menuName;
    private MenuCategory mainCourseCategory;
    private MenuCategory dessertCategory;

    @BeforeEach
    public void setUp() {
        menuName = "menu";
        menu = new Menu(menuName);

        HashSet<MenuItem> mainCourseItems = new HashSet<>();
        mainCourseItems.add(new MenuItem("Steak", "Juicy grilled steak", new HashSet<>(Set.of(new Ingredient(1L, "Beef"), new Ingredient(2l, "Spices"))), 25.99, true));
        mainCourseCategory = new MenuCategory(MenuCategoryType.MAIN, mainCourseItems);

        HashSet<MenuItem> dessertItems = new HashSet<>();
        dessertItems.add(new MenuItem("Cheesecake", "Delicious cheesecake", new HashSet<>(Set.of(new Ingredient(1l, "Cheese"), new Ingredient(2l, "Sugar"))), 6.99, true));
        dessertCategory = new MenuCategory(MenuCategoryType.DESSERT, dessertItems);
    }

    @Test
    public void testAddMenuCategory() {
        menu.addMenuCategory(mainCourseCategory);
        assertTrue(menu.getMenuCategories().contains(mainCourseCategory));
    }


    @Test
    public void testRemoveMenuCategory() {
        menu.addMenuCategory(mainCourseCategory);
        menu.removeMenuCategory(MenuCategoryType.MAIN);
        assertFalse(menu.getMenuCategories().contains(mainCourseCategory));
    }

    @Test
    public void testGetMenuCategory() {
        menu.addMenuCategory(mainCourseCategory);
        assertTrue(menu.getMenuCategory(MenuCategoryType.MAIN).isPresent());
        assertEquals(mainCourseCategory, menu.getMenuCategory(MenuCategoryType.MAIN).get());
    }

    @Test
    public void testGetNonExistentMenuCategory() {
        assertFalse(menu.getMenuCategory(MenuCategoryType.SIDE).isPresent());
    }

    @Test
    public void testAddMultipleCategories() {
        menu.addMenuCategory(mainCourseCategory);
        menu.addMenuCategory(dessertCategory);
        assertEquals(2, menu.getMenuCategories().size());
    }
    @Test
    public void testMenuName() {
        assertEquals(menuName, menu.getName());

        String newName = "New Menu Name";
        menu.setName(newName);
        assertEquals(newName, menu.getName());
    }
    @Test
    public void testMenuNameCannotBeNull() {
        String name = null;
        NullPointerException exception = assertThrows(NullPointerException.class, () -> new Menu(name));
        assertEquals("Name cannot be null", exception.getMessage());
    }

    @Test
    public void testMenuNameCannotBeEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Menu(""));
        assertEquals("Name cannot be empty String", exception.getMessage());
    }

    @Test
    public void testMenuNameCannotBeBlank() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Menu("   "));
        assertEquals("Name cannot contain only white spaces", exception.getMessage());
    }
}
