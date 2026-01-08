package Uppgiften;

import java.util.ArrayList;
import java.util.List;

public class Budget {
    public double maxBudget = 1000.0;
    public List<Expense> expenses;
    public List<BudgetObserver> observers;

    public Budget(double maxBudget) {
        this.maxBudget = maxBudget;
        this.expenses = new ArrayList<Expense>();
        observers.add(new ObserverTest(maxBudget, 0.75));
    }

    public Budget() {
        this.expenses = new ArrayList<>();
    }

    public void addExpense(Expense e){
        this.expenses.add(e);
        observers.getFirst().onExpenseAdded(e);
    }

    public double getMaxBudget() {
        return maxBudget;
    }

    public void setMaxBudget(double maxBudget) {
        this.maxBudget = maxBudget;
    }

    public void print() {
        System.out.println("Overview:");
        System.out.println("Your max budget is: " + maxBudget);
        double sum = 0.0;
        for(Expense e: this.expenses){
            System.out.println(e.getName() + ", " + e.getCategory() + ": " + e.getValue());
            sum += e.getValue();
        }
        System.out.println("Spent: " + sum);
        System.out.println((sum*100.0)/maxBudget + "% of the budget spent");
    }
}