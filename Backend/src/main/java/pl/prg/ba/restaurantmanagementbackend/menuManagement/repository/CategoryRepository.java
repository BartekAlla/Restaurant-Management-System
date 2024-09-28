package pl.prg.ba.restaurantmanagementbackend.menuManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.entity.category.MenuCategory;

public interface CategoryRepository extends JpaRepository<MenuCategory, Long> {
}
