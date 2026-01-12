package Uppgiften;

public class CategoryObserver implements BudgetObserver {

    private final Category category;
    private double maxCategoryBudget;
    private double spent = 0.0;

    public CategoryObserver(Category category, double maxCategoryBudget) {
        this.category = category;
        this.maxCategoryBudget = maxCategoryBudget;
    }

    public void onExpenseAdded(Expense e) {
        if (!e.getCategory().equals(category)) {
            return;
        }

        spent += e.getValue();
        double DEFAULT_RATIO = 0.75;
        if (spent > maxCategoryBudget * DEFAULT_RATIO) {
            System.out.println("HOLY SHIT YOU ARE CLOSE TO THE CAP OF " + category.name());
        }
    }

    public Category getCategory() {
        return category;
    }

    public void setMaxCategoryBudget(double maxCategoryBudget) {
        this.maxCategoryBudget = maxCategoryBudget;
    }
}
