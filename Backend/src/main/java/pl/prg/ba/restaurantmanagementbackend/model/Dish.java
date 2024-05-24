package pl.prg.ba.restaurantmanagementbackend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;

@Data
@NoArgsConstructor
public class Dish {
    private static int MAX_DESCRIPTION_LENGTH = 500;
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
            handleNullDescription();
        } else if (description.length() > MAX_DESCRIPTION_LENGTH){
            handleTooLongDescription();
        } else if (description.isEmpty()) {
            handleEmptyDescription();
        } else if (description.isBlank()) {
            handleBlankDescription();
        } else {
            this.description = description;
        }
    }

    private void handleTooLongDescription() throws IllegalArgumentException {
        throw new IllegalArgumentException("Description too long - cannot contain more than 500 signs");
    }

    private void handleBlankDescription() throws IllegalArgumentException {
        throw new IllegalArgumentException("Description cannot contain only white spaces");
    }

    private void handleEmptyDescription() throws IllegalArgumentException {
        throw new IllegalArgumentException("Description cannot be empty String");
    }

    private void handleNullDescription() throws NullPointerException {
        throw new NullPointerException("Description cannot be null");
    }

    private void validateDishName(String name) throws NullPointerException, IllegalArgumentException {
        if (name == null) {
            handleNullName();
        } else if (name.isEmpty()) {
            handleEmptyName();
        } else if (name.isBlank()) {
            handleBlankName();
        } else {
            this.name = name;
        }
    }

    private void handleNullName() throws NullPointerException {
        throw new NullPointerException("Name cannot be null");
    }

    private void handleBlankName() throws IllegalArgumentException {
        throw new IllegalArgumentException("Name cannot contain only white spaces");
    }

    private void handleEmptyName() throws IllegalArgumentException {
        throw new IllegalArgumentException("Name cannot be empty String");
    }

    private void validateIngredientsSet(HashSet<String> ingredients) throws IllegalArgumentException, NullPointerException {
        if (ingredients == null) {
            handleNullIngredientSet();
        } else if (ingredients.isEmpty()) {
            handleEmptyIngredientSet();
        } else {
            this.ingredients = ingredients;
        }
    }

    private void handleNullIngredientSet() throws NullPointerException {
        throw new NullPointerException("Ingredients set cannot be null");
    }

    private void handleEmptyIngredientSet() throws IllegalArgumentException {
        throw new IllegalArgumentException("Ingredient set cannot be empty");
    }
}
