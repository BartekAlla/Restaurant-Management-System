package pl.prg.ba.restaurantmanagementbackend.menuManagement.dto.category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.prg.ba.restaurantmanagementbackend.common.Validators;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.entity.category.MenuCategoryType;

@Getter
@NoArgsConstructor
public class CategoryDTO {
    private MenuCategoryType menuCategoryType;

    public CategoryDTO(MenuCategoryType menuCategoryType) {
        validateCategoryDTOType(menuCategoryType);
    }

    private void validateCategoryDTOType(MenuCategoryType menuCategoryType) throws NullPointerException, IllegalArgumentException {
        Validators.validateCategoryType(menuCategoryType);
        this.menuCategoryType = menuCategoryType;
    }
    public void setMenuCategoryType(MenuCategoryType menuCategoryType) {
        validateCategoryDTOType(menuCategoryType);
    }
}
