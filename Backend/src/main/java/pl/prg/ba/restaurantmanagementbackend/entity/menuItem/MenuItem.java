package pl.prg.ba.restaurantmanagementbackend.entity.menuItem;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.prg.ba.restaurantmanagementbackend.model.Dish;

import java.util.HashSet;

@Data
@EqualsAndHashCode(callSuper = true)
public class MenuItem extends Dish {
    public static final Double MIN_MENU_ITEM_PRICE = 0.0;
    public static final Double MAX_MENU_ITEM_PRICE = 200.0;
    private Double price;
    private boolean availabilityStatus;

    public MenuItem(String name, String description, HashSet<String> ingredients, Double price, boolean availabilityStatus) {
        super(name, description, ingredients);
        validateMenuItemPrice(price);

        this.availabilityStatus = availabilityStatus;
    }



    private void validateMenuItemPrice(Double price) throws IllegalArgumentException {
        if (price < MIN_MENU_ITEM_PRICE) {
            throw new IllegalArgumentException("Price cannot be negative");
        } else if (price > MAX_MENU_ITEM_PRICE) {
            throw new IllegalArgumentException("Price cannot be higher than " + MAX_MENU_ITEM_PRICE);
        }
        this.price = price;

    }
}
