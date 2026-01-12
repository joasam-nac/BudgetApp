package Uppgiften;

import java.util.ArrayList;
import java.util.List;

public class Budget {
    private double maxBudget;
    private final List<Expense> expenses = new ArrayList<>();
    private final List<BudgetObserver> observers = new ArrayList<>();

    public Budget(double maxBudget) {
        this.maxBudget = maxBudget;
        //observers.add(new ObserverTest(maxBudget, 0.75));
    }

    public void addExpense(Expense e){
        this.expenses.add(e);
        notifyObservers(e);
        //observers.getFirst().onExpenseAdded(e);
    }

    public double getMaxBudget() {
        return maxBudget;
    }

    public void setMaxBudget(double maxBudget) {
        this.maxBudget = maxBudget;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void print() {
        System.out.println("Overview:");
        System.out.println("Your max budget is: " + maxBudget);
        double sum = 0.0;
        for(Expense e: this.expenses){
            System.out.println(e.getName() + ", " + e.getCategory().getName() + ": " + e.getValue());
            sum += e.getValue();
        }
        System.out.println("Spent: " + sum);
        System.out.println((sum*100.0)/maxBudget + "% of the budget spent");
    }

    public void notifyObservers(Expense e) {
        for (BudgetObserver ob: this.observers){
            ob.onExpenseAdded(e);
        }
    }

    public void addObserver(BudgetObserver ob){
        for (BudgetObserver inList: this.observers){
            if (inList instanceof CategoryObserver co && ob instanceof CategoryObserver newCo
                    && co.getCategory().equals(newCo.getCategory())){
                return;
            }
        }
        observers.add(ob);

    }

    public void removeObserver(BudgetObserver ob){
        observers.remove(ob);
    }


}