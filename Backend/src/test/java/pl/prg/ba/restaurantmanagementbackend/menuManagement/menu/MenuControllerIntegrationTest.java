package pl.prg.ba.restaurantmanagementbackend.menuManagement.menu;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.dto.ingredient.IngredientDTO;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.dto.menu.MenuDTO;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.repository.MenuRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MenuControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MenuRepository menuRepository;

    @Test
    public void testAddMenu() throws Exception {

        MenuDTO menuDTO = new MenuDTO("March Menu");
        mockMvc.perform(MockMvcRequestBuilders.post("/menus")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(menuDTO)))
                .andExpect(status().isOk());

    }

    @Test
    public void testGetAllMenus() throws Exception {
        mockMvc.perform(get("/menus"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetMenuById() throws Exception {
        Long id = menuRepository.findAll().get(0).getId();
        mockMvc.perform(get("/menus/{id}", id))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateMenu() throws Exception {
        Long id = menuRepository.findAll().get(0).getId();
        MenuDTO menuDTO = new MenuDTO("Updated Winter Season Menu");
        mockMvc.perform(MockMvcRequestBuilders.put("/menus/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(menuDTO)))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteMenu() throws Exception {
        Long id = 2L;

        mockMvc.perform(delete("/menus/{id}", id))
                .andExpect(status().isNoContent());
    }
}
