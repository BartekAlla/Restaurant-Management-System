package pl.prg.ba.restaurantmanagementbackend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.model.Dish;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.model.Ingredient;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DishTest {
    private String validName;
    private String validDescription;
    private Set<Ingredient> validIngredients;

    @BeforeEach
    public void setUp() {
        validName = "Pizza";
        validDescription = "Delicious pizza";
        validIngredients = new HashSet<>();
        validIngredients.add(new Ingredient(1L, "Ham"));
        validIngredients.add(new Ingredient(2L, "Cheese"));
    }

    @Test
    public void testValidDishCreation() {
        Dish dish = new Dish(validName, validDescription, new HashSet<>(validIngredients));
        assertEquals(validName, dish.getName());
        assertEquals(validDescription, dish.getDescription());
        assertEquals(validIngredients, dish.getIngredients());
    }

    @Test
    public void testDishCreationWithNullName() {
        Exception exception = assertThrows(NullPointerException.class, () -> new Dish(null, validDescription, new HashSet<>(validIngredients)));
        assertEquals("Name cannot be null", exception.getMessage());
    }

    @Test
    public void testDishCreationWithEmptyName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Dish("", validDescription, new HashSet<>(validIngredients)));
        assertEquals("Name cannot be empty String", exception.getMessage());
    }

    @Test
    public void testDishCreationWithBlankName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Dish("   ", validDescription, new HashSet<>(validIngredients)));
        assertEquals("Name cannot contain only white spaces", exception.getMessage());
    }

    @Test
    public void testDishCreationWithNullDescription() {
        Exception exception = assertThrows(NullPointerException.class, () -> new Dish(validName, null, new HashSet<>(validIngredients)));
        assertEquals("Description cannot be null", exception.getMessage());
    }

    @Test
    public void testDishCreationWithEmptyDescription() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Dish(validName, "", new HashSet<>(validIngredients)));
        assertEquals("Description cannot be empty String", exception.getMessage());
    }

    @Test
    public void testDishCreationWithBlankDescription() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Dish(validName, "   ", new HashSet<>(validIngredients)));
        assertEquals("Description cannot contain only white spaces", exception.getMessage());
    }

    @Test
    public void testDishCreationWithLongDescription() {
        String longDescription = "a".repeat(Dish.MAX_DESCRIPTION_LENGTH + 1);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Dish(validName, longDescription, new HashSet<>(validIngredients)));
        assertEquals("Description too long - cannot contain more than 500 signs", exception.getMessage());
    }

    @Test
    public void testDishCreationWithNullIngredients() {
        Exception exception = assertThrows(NullPointerException.class, () -> new Dish(validName, validDescription, null));
        assertEquals("Ingredients set cannot be null", exception.getMessage());
    }

    @Test
    public void testDishCreationWithEmptyIngredients() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Dish(validName, validDescription, new HashSet<>()));
        assertEquals("Ingredient set cannot be empty", exception.getMessage());
    }

    @Test
    public void testSettingValidName() {
        Dish dish = new Dish(validName, validDescription, new HashSet<>(validIngredients));
        String newName = "Salad";
        dish.setName(newName);
        assertEquals(newName, dish.getName());
    }

    @Test
    public void testSettingInvalidName() {
        Dish dish = new Dish(validName, validDescription, new HashSet<>(validIngredients));
        Exception exception = assertThrows(NullPointerException.class, () -> dish.setName(null));
        assertEquals("Name cannot be null", exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class, () -> dish.setName(""));
        assertEquals("Name cannot be empty String", exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class, () -> dish.setName("   "));
        assertEquals("Name cannot contain only white spaces", exception.getMessage());
    }

    @Test
    public void testSettingValidDescription() {
        Dish dish = new Dish(validName, validDescription, new HashSet<>(validIngredients));
        String newDescription = "Delicious salad";
        dish.setDescription(newDescription);
        assertEquals(newDescription, dish.getDescription());
    }

    @Test
    public void testSettingInvalidDescription() {
        Dish dish = new Dish(validName, validDescription, new HashSet<>(validIngredients));
        Exception exception = assertThrows(NullPointerException.class, () -> dish.setDescription(null));
        assertEquals("Description cannot be null", exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class, () -> dish.setDescription(""));
        assertEquals("Description cannot be empty String", exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class, () -> dish.setDescription("   "));
        assertEquals("Description cannot contain only white spaces", exception.getMessage());
        String longDescription = "a".repeat(Dish.MAX_DESCRIPTION_LENGTH + 1);
        exception = assertThrows(IllegalArgumentException.class, () -> dish.setDescription(longDescription));
        assertEquals("Description too long - cannot contain more than 500 signs", exception.getMessage());
    }

    @Test
    public void testSettingValidIngredients() {
        Dish dish = new Dish(validName, validDescription, new HashSet<>(validIngredients));
        Set<Ingredient> newIngredients = new HashSet<>(Set.of(new Ingredient(3L, "Tomato"), new Ingredient(4L, "Lettuce")));
        dish.setIngredients(newIngredients);
        assertEquals(newIngredients, dish.getIngredients());
    }

    @Test
    public void testSettingInvalidIngredients() {
        Dish dish = new Dish(validName, validDescription, new HashSet<>(validIngredients));
        Exception exception = assertThrows(NullPointerException.class, () -> dish.setIngredients(null));
        assertEquals("Ingredients set cannot be null", exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class, () -> dish.setIngredients(new HashSet<>()));
        assertEquals("Ingredient set cannot be empty", exception.getMessage());
    }

}
