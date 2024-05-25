package pl.prg.ba.restaurantmanagementbackend.menuManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.entity.ingredient.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

}
