package pl.prg.ba.restaurantmanagementbackend.menuManagement.service.category;

import pl.prg.ba.restaurantmanagementbackend.menuManagement.dto.category.CategoryDTO;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.entity.category.MenuCategory;

import java.util.List;
import java.util.Optional;

public interface CategoryServiceInterface {
    public MenuCategory addMenuCategory(CategoryDTO categoryDTO);
    public List<MenuCategory> getAllMenuCategories();
    public Optional<MenuCategory> getMenuCategoryById(Long id);
    public MenuCategory updateMenuCategory(Long id, CategoryDTO categoryDTO);
    public void deleteMenuCategory(Long id);
}
