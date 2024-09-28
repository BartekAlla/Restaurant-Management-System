package pl.prg.ba.restaurantmanagementbackend.menuManagement.controller.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.dto.category.CategoryDTO;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.entity.category.MenuCategory;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.service.category.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<MenuCategory> addCategory(@RequestBody CategoryDTO categoryDTO) {
        MenuCategory menuCategory = categoryService.addMenuCategory(categoryDTO);
        return ResponseEntity.ok(menuCategory);
    }

    @GetMapping
    public ResponseEntity<List<MenuCategory>> getAllMenuCategories() {
        List<MenuCategory> menuCategories = categoryService.getAllMenuCategories();
        return ResponseEntity.ok(menuCategories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuCategory> getMenuCategoryById(@PathVariable Long id) {
        return categoryService.getMenuCategoryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MenuCategory> updateMenuCategory(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO) {
        MenuCategory updatedCategory = categoryService.updateMenuCategory(id, categoryDTO);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenuCategoryById(@PathVariable Long id) {
        categoryService.deleteMenuCategory(id);
        return ResponseEntity.noContent().build();
    }

}
