package pl.prg.ba.restaurantmanagementbackend.menuManagement.dto.menu;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MenuDTO {
    private String name;
    public MenuDTO(String name) {
        validateMenuDTOName(name);
    }

    private void validateMenuDTOName(String name) throws NullPointerException, IllegalArgumentException {
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
        validateMenuDTOName(name);
    }
}
