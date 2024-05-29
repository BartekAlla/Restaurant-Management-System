package pl.prg.ba.restaurantmanagementbackend.menuManagement.controller.ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    //TODO
    // add new endpoints
    // for new methods

    @PostMapping
    public ResponseEntity<?> addIngredient(@RequestBody IngredientDTO ingredientDTO) {
        ingredientService.addIngredient(ingredientDTO);
        return ResponseEntity.ok().build();
    }

//    public List<Ingredient> getAllIngredients() {
//
//    }
//
//
//    public Optional<Ingredient> getIngredientById(Long id) {
//
//    }
//
//
//    public Ingredient updateIngredient(Long id, IngredientDTO ingredientDTO) {
//
//    }
//
//
//    public void deleteIngredient(Long id) {
//
//    }

}
