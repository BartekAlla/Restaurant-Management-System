package pl.prg.ba.restaurantmanagementbackend.menuManagement.dto.ingredient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.prg.ba.restaurantmanagementbackend.common.Validators;


@Getter
@NoArgsConstructor
public class IngredientDTO {
    private String name;

    public IngredientDTO(String name) {
        validateIngredientDTOName(name);
    }

    private void validateIngredientDTOName(String name) throws NullPointerException, IllegalArgumentException {
        Validators.validateName(name);
        this.name = name;
    }
    public void setName(String name) {
        validateIngredientDTOName(name);
    }
}
