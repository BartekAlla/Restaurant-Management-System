package pl.prg.ba.restaurantmanagementbackend.menuManagement.service.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.dto.category.CategoryDTO;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.entity.category.MenuCategory;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements CategoryServiceInterface {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public MenuCategory addMenuCategory(CategoryDTO categoryDTO) {
        return null;
    }

    @Override
    public List<MenuCategory> getAllMenuCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<MenuCategory> getMenuCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public MenuCategory updateMenuCategory(Long id, CategoryDTO categoryDTO) {
        MenuCategory menuCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));
        menuCategory.setMenuCategoryType(categoryDTO.getMenuCategoryType());
        return categoryRepository.save(menuCategory);
    }

    @Override
    public void deleteMenuCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
