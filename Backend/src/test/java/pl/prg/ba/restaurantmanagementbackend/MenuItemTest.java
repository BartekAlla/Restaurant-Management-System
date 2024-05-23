package pl.prg.ba.restaurantmanagementbackend;

import org.junit.jupiter.api.Test;
import pl.prg.ba.restaurantmanagementbackend.entity.MenuItem;
import pl.prg.ba.restaurantmanagementbackend.model.Dish;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuItemTest {
    @Test
    public void testMenuItemProperties(){
        // Given

        String name = "Pizza";
        String description = "Delicious pizza";
        Double price = 10.99;
        MenuItemCategory category = MenuItemCategory.MAIN;
        boolean available = true;

        // When
        MenuItem menuItem = new MenuItem(name, description, price, category, available);

        // Then
        assertEquals(name, menuItem.getName());
        assertEquals(description, menuItem.getDescription());
        assertEquals(price, menuItem.getPrice(), 0.01); // Use delta for double comparison
        assertEquals(category, menuItem.getCategory());
        assertEquals(available, menuItem.isAvailabilityStatus());
    }
}
