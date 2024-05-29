package pl.prg.ba.restaurantmanagementbackend.menuManagement.service.ingredient;

import pl.prg.ba.restaurantmanagementbackend.menuManagement.dto.ingredient.IngredientDTO;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.entity.ingredient.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientServiceInterface {
    public Ingredient addIngredient(IngredientDTO ingredientDTO);
    public List<Ingredient> getAllIngredients();
    public Optional<Ingredient> getIngredientById(Long id);
    public Ingredient updateIngredient(Long id, IngredientDTO ingredientDTO);
    public void deleteIngredient(Long id);
}
