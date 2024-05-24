package pl.prg.ba.restaurantmanagementbackend.entity.category;

import lombok.Data;
import pl.prg.ba.restaurantmanagementbackend.entity.menuItem.MenuItem;

import java.util.HashSet;


@Data
public class MenuCategory {
    private MenuCategoryType menuCategoryType;
    private HashSet<MenuItem> menuItems;

    public MenuCategory(MenuCategoryType menuCategoryType, HashSet<MenuItem> menuItems) throws NullPointerException {
        validateMenuCategoryType(menuCategoryType);
        this.menuItems = menuItems != null ? menuItems : new HashSet<>();
    }

    private void validateMenuCategoryType(MenuCategoryType menuCategoryType) throws NullPointerException {
        if (menuCategoryType == null) {
            throw new NullPointerException("MenuCategoryType cannot be null");
        }
        this.menuCategoryType = menuCategoryType;
    }
    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }
    public void removeMenuItem(MenuItem menuItem) {
        menuItems.remove(menuItem);
    }
}
