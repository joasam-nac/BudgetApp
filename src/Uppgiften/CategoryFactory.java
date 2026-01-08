package Uppgiften;

import java.util.*;

public final class CategoryFactory {

    public final Set<String> defaultNames = Set.of("Food", "Clothes");

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

    public void createCategory(Category category) {
        for (Category c: categories) {
            if (Objects.equals(c, category)){
                return;
            }
        }
        categories.add(category);
    }

    public Category getCategoryFromOrder(int order) {
        int i = 0;
        for (Category c: categories) {
            i++;
            if (order == i){
                return c;
            }
        }
        return null;
    }

}
