package pl.prg.ba.restaurantmanagementbackend.entity.menuItem;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.prg.ba.restaurantmanagementbackend.entity.category.MenuCategory;
import pl.prg.ba.restaurantmanagementbackend.model.Dish;

import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "menu_items")
public class MenuItem extends Dish {
    public static final Double MIN_MENU_ITEM_PRICE = 0.0;
    public static final Double MAX_MENU_ITEM_PRICE = 200.0;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private boolean availabilityStatus;
    @ManyToMany(mappedBy = "menuItems")
    private Set<MenuCategory> menuCategories = new HashSet<>();

    public MenuItem(String name, String description, HashSet<String> ingredients, Double price, boolean availabilityStatus) throws IllegalArgumentException, NullPointerException {
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
