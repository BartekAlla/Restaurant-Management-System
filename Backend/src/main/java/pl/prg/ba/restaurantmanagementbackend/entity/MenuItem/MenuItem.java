package pl.prg.ba.restaurantmanagementbackend.entity.MenuItem;

import jakarta.validation.constraints.Null;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.prg.ba.restaurantmanagementbackend.model.Dish;

import java.util.HashSet;

@Data
@EqualsAndHashCode(callSuper = true)
public class MenuItem extends Dish {
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
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        } else {
            this.price = price;
        }
    }
}
