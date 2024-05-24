package pl.prg.ba.restaurantmanagementbackend.entity.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.prg.ba.restaurantmanagementbackend.entity.menuItem.MenuItem;

import java.util.HashSet;


@Data
@AllArgsConstructor
public class MenuCategory {
    private MenuCategoryType menuCategoryType;
    private HashSet<MenuItem> menuItems;
}
