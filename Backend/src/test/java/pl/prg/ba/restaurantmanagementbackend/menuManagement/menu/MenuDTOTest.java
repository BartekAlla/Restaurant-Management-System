package pl.prg.ba.restaurantmanagementbackend.menuManagement.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.dto.menu.MenuDTO;

import static org.junit.jupiter.api.Assertions.*;

public class MenuDTOTest {
    private MenuDTO menuDTO;
    private String name;

    @BeforeEach
    public void setUp() {
        name = "Spring Season Menu";
        menuDTO = new MenuDTO(name);
    }
    @Test
    public void testMenuDTOCreation() {
        assertNotNull(menuDTO);
        assertEquals(name, menuDTO.getName());
    }

    @Test
    public void testSettingValidName() {
        name = "Winter Season Menu";
        menuDTO.setName(name);
        assertEquals(name, menuDTO.getName());
    }
    @Test
    public void testSettingNullName() {
        Exception exception = assertThrows(NullPointerException.class, () -> menuDTO.setName(null));
        assertEquals("Name cannot be null", exception.getMessage());
    }
    @Test
    public void testSettingBlankName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> menuDTO.setName("     "));
        assertEquals("Name cannot contain only white spaces", exception.getMessage());
    }
    @Test
    public void testSettingEmptyName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> menuDTO.setName(""));
        assertEquals("Name cannot be empty String", exception.getMessage());
    }
}
