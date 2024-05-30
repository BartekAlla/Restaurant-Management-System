package pl.prg.ba.restaurantmanagementbackend.menuManagement.ingredient;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.dto.ingredient.IngredientDTO;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.entity.ingredient.Ingredient;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

public class IngredientDTOTest {

    private String name;
    private IngredientDTO ingredientDTO;

    @BeforeEach
    public void setUp() {
        name = "Potato";
        ingredientDTO = new IngredientDTO(name);
    }

    @Test
    public void testValidIngredientDTOCreation() {
        assertNotNull(ingredientDTO);
        assertEquals(name, ingredientDTO.getName());
    }

    @Test
    public void testSettingValidName() {
        String newName = "New Potato";
        ingredientDTO.setName(newName);
        assertEquals(newName, ingredientDTO.getName());
    }
    @Test
    public void testSettingNullName() {
        Exception exception = assertThrows(NullPointerException.class, () -> ingredientDTO.setName(null));
        assertEquals("Name cannot be null", exception.getMessage());
    }
    @Test
    public void testSettingBlankName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> ingredientDTO.setName("     "));
        assertEquals("Name cannot contain only white spaces", exception.getMessage());
    }
    @Test
    public void testSettingEmptyName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> ingredientDTO.setName(""));
        assertEquals("Name cannot be empty String", exception.getMessage());
    }
}
