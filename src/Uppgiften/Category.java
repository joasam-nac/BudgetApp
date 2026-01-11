package Uppgiften;

import static Uppgiften.Menu.budget;

public class Category {

    public String name;
    public double maxCategoryBudget = 500;
    public double ratio = 0.85;
    public CategoryObserver observer;

    public Category(String name, CategoryObserver observer){
        this.name = name;
        this.observer = observer;
    }

    public String getName() {
        return name;
    }

    public double getMaxCategoryBudget() {
        return maxCategoryBudget;
    }

    public double getRatio() {
        return ratio;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxCategoryBudget(double maxCategoryBudget) {
        this.maxCategoryBudget = maxCategoryBudget;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }
}
