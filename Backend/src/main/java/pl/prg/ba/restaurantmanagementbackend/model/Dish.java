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
        validateDishName(name);
        this.description = description;
        validateIngredientsSet(ingredients);
        this.ingredients = ingredients;
    }

    private void validateDishName(String name) {
        if (name.isEmpty()) {
            handleEmptyName();
        } else if (name.isBlank()) {
            handleBlankName();
        } else {
            this.name = name;
        }
    }

    private void handleBlankName() throws IllegalArgumentException {
        throw new IllegalArgumentException("Name cannot contain only white spaces");
    }

    private void handleEmptyName() throws IllegalArgumentException {
        throw new IllegalArgumentException("Name cannot be empty String");
    }

    private void validateIngredientsSet(HashSet<String> ingredients) throws IllegalArgumentException {
        if (ingredients.isEmpty()) {
            throw new IllegalArgumentException("Ingredient set cannot be empty");
        } else {
            this.ingredients = ingredients;
        }
    }
}
