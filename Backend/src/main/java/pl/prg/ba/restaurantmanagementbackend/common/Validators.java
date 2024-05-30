package pl.prg.ba.restaurantmanagementbackend.common;


public class Validators {
    public static final int MAX_DESCRIPTION_LENGTH = 500;
    public static void validateName(String name) throws IllegalArgumentException, NullPointerException {
        if (name == null) {
            throw new NullPointerException("Name cannot be null");
        } else if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty String");
        } else if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot contain only white spaces");
        }
    }
    public static void validateDishDescription(String description) throws IllegalArgumentException, NullPointerException {
        if (description == null) {
            throw new NullPointerException("Description cannot be null");
        } else if (description.length() > MAX_DESCRIPTION_LENGTH) {
            throw new IllegalArgumentException("Description too long - cannot contain more than 500 signs");
        } else if (description.isEmpty()) {
            throw new IllegalArgumentException("Description cannot be empty String");
        } else if (description.isBlank()) {
            throw new IllegalArgumentException("Description cannot contain only white spaces");
        }
    }
}
