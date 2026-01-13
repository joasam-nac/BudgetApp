package Uppgiften;

public class CategoryObserver implements BudgetObserver {

    private final Category category;
    private double spent = 0.0;

    public CategoryObserver(Category category) {
        this.category = category;
    }

    @Override
    public void onExpenseAdded(Expense e) {
        if (!e.getCategory().equals(category)) {
            return;
        }

        spent += e.getValue();
        double DEFAULT_RATIO = 0.75;
        if (spent > category.getBudget() * DEFAULT_RATIO) {
            System.out.println("You are reaching the maximum budget for " + category.getName());
        }
    }

    public Category getCategory() {
        return category;
    }
}
