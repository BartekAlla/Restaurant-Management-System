package pl.prg.ba.restaurantmanagementbackend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.prg.ba.restaurantmanagementbackend.MenuItemCategory;
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
        this.price = price;
        this.category = category;
        this.availabilityStatus = availabilityStatus;
    }
}
