package pl.prg.ba.restaurantmanagementbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dish {
    protected String name;
    protected String description;
    protected HashSet<String> ingredients;
}
