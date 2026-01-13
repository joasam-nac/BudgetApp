package Uppgiften;

import java.util.*;

public final class CategoryRepository {

    public final List<String> defaultNames = List.of("Food", "Clothes", "Hobbies", "Transportation", "Utilities", "Health", "LifeStyle");

    public final List<Category> categories = new ArrayList<>();

    public CategoryRepository() {}

    public Category getCategory(String name) {
        for (Category c: categories) {
            if (Objects.equals(c.getName(), name)){
                return c;
            }
        }
        return null;
    }

    public List<Category> getAllCategories() {
        return categories;
    }

    public Category addCategory(Category category) {
        for (Category c: categories) {
            if (Objects.equals(c, category)){
                return c;
            }
        }
        categories.add(category);
        return category;
    }

    public Category getCategoryFromOrder(int order) {
        int i = 0;
        for (Category c: categories) {
            i++;
            if (order == i-1){
                return c;
            }
        }
        return null;
    }

}
