package pl.prg.ba.restaurantmanagementbackend.menuManagement.controller.ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.dto.ingredient.IngredientDTO;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.entity.ingredient.Ingredient;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.service.ingredient.IngredientService;

import java.util.List;

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
}
