package pl.prg.ba.restaurantmanagementbackend.entity.category;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.prg.ba.restaurantmanagementbackend.entity.menu.Menu;
import pl.prg.ba.restaurantmanagementbackend.entity.menuItem.MenuItem;

import java.util.HashSet;
import java.util.Set;


@Data
@NoArgsConstructor
@Entity
@Table(name = "menu_categories")
public class MenuCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MenuCategoryType menuCategoryType;
    @ManyToMany
    @JoinTable(
            name = "menu_category_items",
            joinColumns = @JoinColumn(name = "menu_category_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_item_id")
    )
    private Set<MenuItem> menuItems = new HashSet<>();
    @ManyToMany(mappedBy = "menuCategories")
    private Set<Menu> menus = new HashSet<>();
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
