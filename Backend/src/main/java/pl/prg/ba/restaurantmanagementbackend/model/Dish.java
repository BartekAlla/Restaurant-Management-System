package pl.prg.ba.restaurantmanagementbackend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;

@Data
@NoArgsConstructor
public class Dish {
    public static final int MAX_DESCRIPTION_LENGTH = 500;
    protected String name;
    protected String description;
    protected HashSet<String> ingredients;

    public Dish(String name, String description, HashSet<String> ingredients) throws NullPointerException, IllegalArgumentException {
        validateDishName(name);
        validateDescription(description);
        validateIngredientsSet(ingredients);
    }

    private void validateDescription(String description) throws NullPointerException, IllegalArgumentException {
        if (description == null) {
            throw new NullPointerException("Description cannot be null");
        } else if (description.length() > MAX_DESCRIPTION_LENGTH) {
            throw new IllegalArgumentException("Description too long - cannot contain more than 500 signs");
        } else if (description.isEmpty()) {
            throw new IllegalArgumentException("Description cannot be empty String");
        } else if (description.isBlank()) {
            throw new IllegalArgumentException("Description cannot contain only white spaces");
        }
        this.description = description;

    }

    private void validateDishName(String name) throws NullPointerException, IllegalArgumentException {
        if (name == null) {
            throw new NullPointerException("Name cannot be null");
        } else if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty String");
        } else if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot contain only white spaces");
        }
        this.name = name;

    }

    private void validateIngredientsSet(HashSet<String> ingredients) throws IllegalArgumentException, NullPointerException {
        if (ingredients == null) {
            throw new NullPointerException("Ingredients set cannot be null");
        } else if (ingredients.isEmpty()) {
            throw new IllegalArgumentException("Ingredient set cannot be empty");
        }
        this.ingredients = ingredients;

    }

}
