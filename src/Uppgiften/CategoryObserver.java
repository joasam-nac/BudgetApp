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
        if (spent > category.getBudget() * DEFAULT_RATIO && spent < category.getBudget()) {
            System.out.println("You have almost reached your maximum budget " + category.getName());
        } else if (spent == category.getBudget()) {
            IO.println("Good job, now dont spend another penny on the " +  category.getName() + " category!");
        } else if (spent > category.getBudget()) {
            IO.println("You have exceeded your maximum budget for the "  + category.getName() + " category!");
    }
    }

    public Category getCategory() {
        return category;
    }
}
