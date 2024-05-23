package pl.prg.ba.restaurantmanagementbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.prg.ba.restaurantmanagementbackend.MenuItemCategory;
import pl.prg.ba.restaurantmanagementbackend.model.Dish;

@Data
public class MenuItem extends Dish {
    private Double price;
    private MenuItemCategory category;
    private boolean availabilityStatus;
    public MenuItem(String name, String description, Double price, MenuItemCategory category, boolean availabilityStatus) {
        super(name, description);
        this.price = price;
        this.category = category;
        this.availabilityStatus = availabilityStatus;
    }
}
