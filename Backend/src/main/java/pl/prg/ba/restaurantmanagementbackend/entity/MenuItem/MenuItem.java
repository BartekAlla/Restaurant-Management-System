package pl.prg.ba.restaurantmanagementbackend.entity.MenuItem;

import jakarta.validation.constraints.Null;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.prg.ba.restaurantmanagementbackend.model.Dish;

import java.util.HashSet;

@Data
@EqualsAndHashCode(callSuper = true)
public class MenuItem extends Dish {
    private static Double MIN_MENU_ITEM_PRICE = 0.0;
    private static Double MAX_MENU_ITEM_PRICE = 200.0;
    private Double price;
    private MenuItemCategory category;
    private boolean availabilityStatus;
    public MenuItem(String name, String description, HashSet<String> ingredients, Double price, MenuItemCategory category, boolean availabilityStatus) {
        super(name, description, ingredients);
        validateMenuItemPrice(price);
        validateCategory(category);
        this.availabilityStatus = availabilityStatus;
    }

    private void validateCategory(MenuItemCategory category) throws NullPointerException {
        if (category == null) {
            throw new NullPointerException("Category cannot be null");
        } else {
            this.category = category;
        }
    }

    private void validateMenuItemPrice(Double price) throws IllegalArgumentException {
        if (price < MIN_MENU_ITEM_PRICE) {
            throw new IllegalArgumentException("Price cannot be negative");
        } else if (price > MAX_MENU_ITEM_PRICE) {
            throw new IllegalArgumentException("Price cannot be higher than 200");
        } else {
            this.price = price;
        }
    }
}
