package pl.prg.ba.restaurantmanagementbackend.entity.MenuItem;

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
        this.category = category;
        this.availabilityStatus = availabilityStatus;
    }

    private void validateMenuItemPrice(Double price) throws IllegalArgumentException {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        } else {
            this.price = price;
        }
    }
}