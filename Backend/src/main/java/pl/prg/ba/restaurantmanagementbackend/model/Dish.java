package pl.prg.ba.restaurantmanagementbackend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.prg.ba.restaurantmanagementbackend.entity.menuItem.MenuItem;

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
    public static final int MAX_DESCRIPTION_LENGTH = 500;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    protected String name;
    protected String description;
    @ManyToMany
    @JoinTable(
            name = "ingretient_dishes",
            joinColumns = @JoinColumn(name = "dish_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private Set<Ingredient> ingredients = new HashSet<>();
    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MenuItem> menuItems = new HashSet<>();

    public Dish(String name, String description, HashSet<Ingredient> ingredients) throws NullPointerException, IllegalArgumentException {
        validateDishName(name);
        validateDescription(description);
        validateIngredientsSet(ingredients);
    }

    private void validateDescription(String description) throws NullPointerException, IllegalArgumentException {
        if (description == null) {
            throw new NullPointerException("Description cannot be null");
        } else if (description.length() > MAX_DESCRIPTION_LENGTH) {
            throw new IllegalArgumentException("Description too long - cannot contain more than 500 signs");
        } else if (description.isEmpty()) {
            throw new IllegalArgumentException("Description cannot be empty String");
        } else if (description.isBlank()) {
            throw new IllegalArgumentException("Description cannot contain only white spaces");
        }
        this.description = description;

    }

    private void validateDishName(String name) throws NullPointerException, IllegalArgumentException {
        if (name == null) {
            throw new NullPointerException("Name cannot be null");
        } else if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty String");
        } else if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot contain only white spaces");
        }
        this.name = name;

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
        validateDishName(name);
    }

    public void setDescription(String description) {
        validateDescription(description);
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
