package pl.prg.ba.restaurantmanagementbackend.menuManagement.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.prg.ba.restaurantmanagementbackend.common.Validators;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.entity.ingredient.Ingredient;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.entity.menuItem.MenuItem;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Table(name = "dishes")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    protected String name;
    protected String description;
    @ManyToMany
    @JoinTable(
            name = "ingredients_dishes",
            joinColumns = @JoinColumn(name = "dish_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private Set<Ingredient> ingredients = new HashSet<>();
    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MenuItem> menuItems = new HashSet<>();

    public Dish(String name, String description, HashSet<Ingredient> ingredients) throws NullPointerException, IllegalArgumentException {
        Validators.validateName(name);
        this.name = name;
        Validators.validateDishDescription(description);
        this.description = description;
        validateIngredientsSet(ingredients);
    }


    private void validateIngredientsSet(Set<Ingredient> ingredients) throws IllegalArgumentException, NullPointerException {
        if (ingredients == null) {
            throw new NullPointerException("Ingredients set cannot be null");
        } else if (ingredients.isEmpty()) {
            throw new IllegalArgumentException("Ingredient set cannot be empty");
        }
        this.ingredients = ingredients;

    }

    public void setName(String name) {
        Validators.validateName(name);
        this.name = name;
    }

    public void setDescription(String description) {
        Validators.validateDishDescription(description);
        this.description = description;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        validateIngredientsSet(ingredients);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dish)) return false;
        Dish dish = (Dish) o;
        return Objects.equals(name, dish.name) && Objects.equals(description, dish.description) && Objects.equals(ingredients, dish.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, ingredients);
    }

}
