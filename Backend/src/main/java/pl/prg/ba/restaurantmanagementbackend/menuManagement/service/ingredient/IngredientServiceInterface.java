package pl.prg.ba.restaurantmanagementbackend.menuManagement.service.ingredient;

import pl.prg.ba.restaurantmanagementbackend.menuManagement.dto.ingredient.IngredientDTO;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.entity.ingredient.Ingredient;

public interface IngredientServiceInterface {
    public Ingredient addIngredient(IngredientDTO ingredientDTO);
}
