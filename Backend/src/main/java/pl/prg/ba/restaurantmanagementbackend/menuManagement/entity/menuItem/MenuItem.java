package pl.prg.ba.restaurantmanagementbackend.menuManagement.entity.menuItem;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.entity.category.MenuCategory;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.model.Dish;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.entity.ingredient.Ingredient;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@DiscriminatorValue("menu_item")
public class MenuItem extends Dish {
    public static final Double MIN_MENU_ITEM_PRICE = 0.0;
    public static final Double MAX_MENU_ITEM_PRICE = 200.0;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double price;
    private Boolean availabilityStatus;
    @ManyToMany(mappedBy = "menuItems")
    private Set<MenuCategory> menuCategories = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;

    public MenuItem(String name, String description, HashSet<Ingredient> ingredients, Double price, Boolean availabilityStatus) throws IllegalArgumentException, NullPointerException {
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

    public void setMenuItemPrice(Double price) {
        validateMenuItemPrice(price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MenuItem)) return false;
        if (!super.equals(o)) return false;
        MenuItem menuItem = (MenuItem) o;
        return availabilityStatus == menuItem.availabilityStatus &&
                Objects.equals(price, menuItem.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), price, availabilityStatus);
    }

}
