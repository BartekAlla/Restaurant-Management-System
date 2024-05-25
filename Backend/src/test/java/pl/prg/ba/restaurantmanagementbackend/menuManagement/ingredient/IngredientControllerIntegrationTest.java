package pl.prg.ba.restaurantmanagementbackend.menuManagement.ingredient;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.dto.ingredient.IngredientDTO;

@SpringBootTest
@AutoConfigureMockMvc
public class IngredientControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    //TODO
    //  update ingredient class to pass this test
    @Test
    public void testAddIngredient() throws Exception {

        IngredientDTO ingredientDTO = new IngredientDTO("Test Ingredient");
        mockMvc.perform(MockMvcRequestBuilders.post("/ingredients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(ingredientDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}
