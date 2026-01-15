package Uppgiften;

public class TotalBudgetObserver implements BudgetObserver {

    private final Budget budget;
    private double spent = 0.0;
    public TotalBudgetObserver(Budget budget) {
        this.budget = budget;

    }

    @Override
    public void onExpenseAdded(Expense e){

        double ratio = 0.85 * budget.getMaxBudget();
        spent += e.getValue();
        if (spent >= ratio && spent < budget.getMaxBudget()){
            IO.println("You are reaching your maximum budget");
        } else if (spent == budget.getMaxBudget()) {
            IO.println("Good job, now dont spend another penny!");
        } else if (spent > budget.getMaxBudget()) {
            IO.println("You have exceeded your maximum budget");
        }
    }
}
