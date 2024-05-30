package pl.prg.ba.restaurantmanagementbackend.menuManagement.ingredient;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.dto.ingredient.IngredientDTO;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class IngredientControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testAddIngredient() throws Exception {

        IngredientDTO ingredientDTO = new IngredientDTO("New Test Ingredient");
        mockMvc.perform(MockMvcRequestBuilders.post("/ingredients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(ingredientDTO)))
                .andExpect(status().isOk());

    }

    @Test
    public void testGetAllIngredients() throws Exception {
        mockMvc.perform(get("/ingredients"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetIngredientById() throws Exception {
        Long id = 1L;

        mockMvc.perform(get("/ingredients/{id}", id))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateIngredient() throws Exception {
        Long id = 1L;
        IngredientDTO ingredientDTO = new IngredientDTO("Updated Ham");

        mockMvc.perform(MockMvcRequestBuilders.put("/ingredients/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(ingredientDTO)))
                        .andExpect(status().isOk());

    }
    @Test
    public void testDeleteIngredient() throws Exception {
        Long id = 4L;

        mockMvc.perform(delete("/ingredients/{id}", id))
                .andExpect(status().isNoContent());
    }
}
