package pl.prg.ba.restaurantmanagementbackend.menuManagement.dto.ingredient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@NoArgsConstructor
public class IngredientDTO {
    private String name;

    public IngredientDTO(String name) {
        validateIngredientDTOName(name);
    }

    private void validateIngredientDTOName(String name) throws NullPointerException, IllegalArgumentException {
        if (name == null) {
            throw new NullPointerException("Name cannot be null");
        } else if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty String");
        } else if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot contain only white spaces");
        }
        this.name = name;
    }
    public void setName(String name) {
        validateIngredientDTOName(name);
    }
}
