package pl.prg.ba.restaurantmanagementbackend.menuManagement.category;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.dto.category.CategoryDTO;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.entity.category.MenuCategoryType;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MenuCategoryDTOTest {
    private MenuCategoryType menuCategoryType;
    private CategoryDTO categoryDTO;

    @BeforeEach
    public void setUp() {
        menuCategoryType = MenuCategoryType.MAIN;
        categoryDTO = new CategoryDTO(menuCategoryType);
    }

    @Test
    public void testValidCategoryDTOCreation() {
        assertNotNull(categoryDTO);
        assertEquals(menuCategoryType, categoryDTO.getMenuCategoryType());
    }
    @Test
    public void testSettingValidCategoryType() {
        MenuCategoryType newMenuCategoryType = MenuCategoryType.MAIN;
        categoryDTO.setMenuCategoryType(newMenuCategoryType);
        assertEquals(newMenuCategoryType, categoryDTO.getMenuCategoryType());
    }
    //TODO make this test pass
    @Test
    public void testSettingNullCategoryType() {
        Exception exception = assertThrows(NullPointerException.class, () -> categoryDTO.setMenuCategoryType(null));
        assertEquals("Menu category type cannot be null", exception.getMessage());
    }
}
