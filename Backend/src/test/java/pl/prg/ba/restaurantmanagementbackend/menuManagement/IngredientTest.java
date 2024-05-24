package pl.prg.ba.restaurantmanagementbackend.menuManagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.model.Dish;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.model.Ingredient;

import java.util.HashSet;
import java.util.Set;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

public class IngredientTest {
    private Long id;
    private String name;
    private Ingredient ingredient;
    private Set<Dish> dishes;

    @BeforeEach
    public void setUp() {
        id = 1L;
        name = "Tomato";
        dishes = new HashSet<>();
        ingredient = new Ingredient(id, name);
    }

    @Test
    public void testValidIngredientCreation() {
        assertNotNull(ingredient);
        assertEquals(id, ingredient.getId());
        assertEquals(name, ingredient.getName());
        assertTrue(ingredient.getDishes().isEmpty());
    }

    @Test
    public void testIngredientCreationWithNullName() {
        Exception exception = assertThrows(NullPointerException.class, () -> new Ingredient(id, null));
        assertEquals("Name cannot be null", exception.getMessage());
    }

    @Test
    public void testSettingValidName() {
        String newName = "Cheese";
        ingredient.setName(newName);
        assertEquals(newName, ingredient.getName());
    }

    @Test
    public void testSettingInvalidName() {
        Exception exception = assertThrows(NullPointerException.class, () -> ingredient.setName(null));
        assertEquals("Name cannot be null", exception.getMessage());
    }

    @Test
    public void testAddingDish() {
        Dish dish = new Dish("Pizza", "Delicious pizza", new HashSet<>(Set.of(ingredient)));
        dishes.add(dish);
        ingredient.setDishes(dishes);
        assertTrue(ingredient.getDishes().contains(dish));
    }

    @Test
    public void testRemovingDish() {
        Dish dish = new Dish("Pizza", "Delicious pizza", new HashSet<>(Set.of(ingredient)));
        dishes.add(dish);
        ingredient.setDishes(dishes);
        ingredient.getDishes().remove(dish);
        assertFalse(ingredient.getDishes().contains(dish));
    }

    @Test
    public void testEqualsAndHashCode() {
        Ingredient ingredient1 = new Ingredient(id, name);
        Ingredient ingredient2 = new Ingredient(id, name);
        Ingredient ingredient3 = new Ingredient(2L, "Cheese");

        assertEquals(ingredient1, ingredient2);
        assertNotEquals(ingredient1, ingredient3);
        assertEquals(ingredient1.hashCode(), ingredient2.hashCode());
        assertNotEquals(ingredient1.hashCode(), ingredient3.hashCode());
    }
}

