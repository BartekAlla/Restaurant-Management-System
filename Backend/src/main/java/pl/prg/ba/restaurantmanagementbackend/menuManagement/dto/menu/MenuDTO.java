package pl.prg.ba.restaurantmanagementbackend.menuManagement.dto.menu;


import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.prg.ba.restaurantmanagementbackend.common.Validators;

@Getter
@NoArgsConstructor
public class MenuDTO {
    private String name;
    public MenuDTO(String name) {
        validateMenuDTOName(name);
    }

    private void validateMenuDTOName(String name) throws NullPointerException, IllegalArgumentException {
        Validators.validateName(name);
        this.name = name;
    }
    public void setName(String name) {
        validateMenuDTOName(name);
    }
}
