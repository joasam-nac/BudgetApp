package Uppgiften;

import java.util.*;

public final class CategoryFactory {

    public final List<String> defaultNames = List.of("Food", "Clothes", "Hobbies", "Transportation", "Utilities", "Health", "LifeStyle");

    public final List<Category> categories = new ArrayList<>();

    public CategoryFactory() {
        for (String s: defaultNames) {
            categories.add(new Category(s));
        }

    }

    public Category getCategory(String name) {
        for (Category c: categories) {
            if (Objects.equals(c.name(), name)){
                return c;
            }
        }
        return null;
    }

    public List<Category> getAllCategories() {
        return categories;
    }

    public Category createCategory(String name) {
        for (Category c: categories) {
            if (c.name().equals(name)){
                return c;
            }
        }
        categories.add(new Category(name));
        return getCategory(name);
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
