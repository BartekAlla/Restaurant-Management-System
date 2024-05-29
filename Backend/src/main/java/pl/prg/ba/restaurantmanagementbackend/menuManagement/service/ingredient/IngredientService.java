package pl.prg.ba.restaurantmanagementbackend.menuManagement.service.ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.dto.ingredient.IngredientDTO;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.entity.ingredient.Ingredient;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.repository.IngredientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService implements IngredientServiceInterface {
    @Autowired
    private IngredientRepository ingredientRepository;


    public Ingredient addIngredient(IngredientDTO ingredientDTO) {
        if (ingredientDTO.getName() == null) {
            throw new NullPointerException("Name cannot be null");
        }
        Ingredient ingredient = new Ingredient(0L, ingredientDTO.getName());
        return ingredientRepository.save(ingredient);
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    @Override
    public Optional<Ingredient> getIngredientById(Long id) {
        return ingredientRepository.findById(id);
    }

    @Override
    public Ingredient updateIngredient(Long id, IngredientDTO ingredientDTO) {
        Ingredient ingredient = ingredientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ingredient not found"));
    ingredient.setName(ingredientDTO.getName());
        return ingredientRepository.save(ingredient);
    }

    @Override
    public void deleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }


}
