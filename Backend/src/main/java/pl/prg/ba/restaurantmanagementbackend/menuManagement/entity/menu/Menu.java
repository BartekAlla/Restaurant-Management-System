package pl.prg.ba.restaurantmanagementbackend.menuManagement.entity.menu;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.entity.category.MenuCategory;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.entity.category.MenuCategoryType;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "menus")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @ManyToMany
    @JoinTable(
            name = "menu_categories_menus",
            joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_category_id")
    )
    private Set<MenuCategory> menuCategories = new HashSet<>();

    public Menu(Long id, String name) {
        this.id = id;
        validateMenuName(name);
        this.menuCategories = new HashSet<>();
    }

    private void validateMenuName(String name) {
        if (name == null) {
            throw new NullPointerException("Name cannot be null");
        } else if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty String");
        } else if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot contain only white spaces");
        }
        this.name = name;
    }

    public void setName(String name) {
        validateMenuName(name);
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(id, menu.id) && Objects.equals(name, menu.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}