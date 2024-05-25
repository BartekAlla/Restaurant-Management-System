package pl.prg.ba.restaurantmanagementbackend.menuManagement.service.ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.dto.ingredient.IngredientDTO;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.entity.ingredient.Ingredient;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.repository.IngredientRepository;

@Service
public class IngredientService implements IngredientServiceInterface{
    @Autowired
    private IngredientRepository ingredientRepository;


    public Ingredient addIngredient(IngredientDTO ingredientDTO) {
       Ingredient ingredient = new Ingredient(null, ingredientDTO.getName());
       return ingredientRepository.save(ingredient);
    }
}
