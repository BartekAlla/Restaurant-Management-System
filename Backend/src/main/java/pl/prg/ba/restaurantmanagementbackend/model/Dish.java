package pl.prg.ba.restaurantmanagementbackend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;

@Data
@NoArgsConstructor
public class Dish {
    protected String name;
    protected String description;
    protected HashSet<String> ingredients;
    public Dish(String name, String description, HashSet<String> ingredients) {
        this.name = name;
        this.description = description;
        validateIngredientsSet(ingredients);
        this.ingredients = ingredients;
    }

    private void validateIngredientsSet(HashSet<String> ingredients) throws IllegalArgumentException {
        if (ingredients.isEmpty()) {
            throw new IllegalArgumentException("Ingredient set cannot be empty");
        } else {
            this.ingredients = ingredients;
        }
    }
}
