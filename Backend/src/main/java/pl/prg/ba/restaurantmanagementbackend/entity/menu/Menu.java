package pl.prg.ba.restaurantmanagementbackend.entity.menu;

import lombok.Data;
import pl.prg.ba.restaurantmanagementbackend.entity.category.MenuCategory;
import pl.prg.ba.restaurantmanagementbackend.entity.category.MenuCategoryType;

import java.util.HashSet;
import java.util.Optional;

@Data
public class Menu {
    private HashSet<MenuCategory> menuCategories;

    public Menu() {
        this.menuCategories = new HashSet<>();
    }

    public Menu(HashSet<MenuCategory> menuCategories) {
        this.menuCategories = menuCategories != null ? menuCategories : new HashSet<>();
    }

    public void addMenuCategory(MenuCategory menuCategory) {
        this.menuCategories.add(menuCategory);
    }

    public void removeMenuCategory(MenuCategoryType menuCategoryType) {
        this.menuCategories.removeIf(category -> category.getMenuCategoryType().equals(menuCategoryType));
    }

    public Optional<MenuCategory> getMenuCategory(MenuCategoryType menuCategoryType) {
        return this.menuCategories.stream()
                .filter(category -> category.getMenuCategoryType().equals(menuCategoryType))
                .findFirst();
    }
}