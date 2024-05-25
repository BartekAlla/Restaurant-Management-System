package pl.prg.ba.restaurantmanagementbackend.menuManagement.entity.ingredient;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.model.Dish;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "ingredients")
    private Set<Dish> dishes = new HashSet<>();

    public Ingredient(Long id, String name) throws NullPointerException, IllegalArgumentException {
        this.id = id;
        validateIngredientName(name);
    }

    private void validateIngredientName(String name) throws NullPointerException, IllegalArgumentException {
        if (name == null) {
            throw new NullPointerException("Name cannot be null");
        } else if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty String");
        } else if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot contain only white spaces");
        }
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public void setName(String name) {
        validateIngredientName(name);
    }
}
