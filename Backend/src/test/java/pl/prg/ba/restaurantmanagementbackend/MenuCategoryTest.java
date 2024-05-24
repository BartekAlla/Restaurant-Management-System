package pl.prg.ba.restaurantmanagementbackend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.prg.ba.restaurantmanagementbackend.entity.customer.MenuCategory;
import pl.prg.ba.restaurantmanagementbackend.entity.customer.MenuCategoryType;
import pl.prg.ba.restaurantmanagementbackend.entity.menuItem.MenuItem;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuCategoryTest {
    private MenuCategoryType menuCategoryType;
    private HashSet<MenuItem> menuItems;


    @BeforeEach
    public void setUp() {
        menuCategoryType = MenuCategoryType.MAIN;
        menuItems = new HashSet<>();
        HashSet<String> ingredients1 = new HashSet<>();
        ingredients1.add("Ham");
        ingredients1.add("Cheese");
        MenuItem menuItem1 = new MenuItem("Ham Pizza", "Delicious ham pizza", ingredients1, 10.99, true);
        menuItems.add(menuItem1);
        HashSet<String> ingredients2 = new HashSet<>();
        ingredients2.add("Tomato");
        ingredients2.add("Salami");
        MenuItem menuItem2 = new MenuItem("Salami Pizza", "Delicious salami pizza", ingredients2, 12.99, true);
        menuItems.add(menuItem2);
    }
    private MenuCategory createMenuCategory(MenuCategoryType menuCategoryType, HashSet<MenuItem> menuItems) {
        return new MenuCategory(menuCategoryType, menuItems);
    }

    @Test
    public void testMenuCategoryType(){
        // When
        MenuCategory menuCategory = createMenuCategory(menuCategoryType, menuItems);

        // Then
        assertEquals(menuCategoryType, menuCategory.getMenuCategoryType());
    }
}
