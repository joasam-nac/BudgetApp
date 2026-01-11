package Uppgiften;

import java.util.*;

public final class CategoryFactory {

    public final Set<String> defaultNames = Set.of("Food", "Clothes", "Hobbies", "Transportation", "Utilities", "Health", "LifeStyle");

    public final List<Category> categories = new ArrayList<>();

    public CategoryFactory() {
        for (String s: defaultNames) {
            categories.add(new Category(s, new CategoryObserver(s)));
        }
    }

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

    public void createCategory(String category) {
        for (Category c: categories) {
            if (c.getName().equals(category)){
                return;
            }
        }
        categories.add(new Category(category, new CategoryObserver(category)));
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
