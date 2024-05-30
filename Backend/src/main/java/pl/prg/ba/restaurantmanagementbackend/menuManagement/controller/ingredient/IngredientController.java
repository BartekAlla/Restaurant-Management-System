package pl.prg.ba.restaurantmanagementbackend.menuManagement.controller.ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.dto.ingredient.IngredientDTO;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.entity.ingredient.Ingredient;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.service.ingredient.IngredientService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;
    @PostMapping
    public ResponseEntity<?> addIngredient(@RequestBody IngredientDTO ingredientDTO) {
        ingredientService.addIngredient(ingredientDTO);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        List<Ingredient> ingredients = ingredientService.getAllIngredients();
        return ResponseEntity.ok(ingredients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getIngredientById(@PathVariable Long id) {
        return ingredientService.getIngredientById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> updateIngredient(@PathVariable Long id, @RequestBody IngredientDTO ingredientDTO) {
        Ingredient updatedIngredinet = ingredientService.updateIngredient(id, ingredientDTO);
        return ResponseEntity.ok(updatedIngredinet);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredientById(@PathVariable Long id) {
        ingredientService.deleteIngredient(id);
        return ResponseEntity.noContent().build();
    }

}
