package Uppgiften;

public class ObserverTest implements BudgetObserver {

    private final Budget budget;
    private double spent;
    public ObserverTest(Budget budget) {
        this.budget = budget;
    }

    public void onBudgetEdited(){

        double ratio = 0.85 * budget.getMaxBudget();

        for( Expense expense : budget.expenses){
            spent += expense.getValue();
        }

        if (spent >= ratio && spent < budget.getMaxBudget()){
            System.out.println("HOLY SHIT YOU ARE CLOSE TO THE CAP OF YOUR BUDGET ARE YOU CRAZY???");
        } else if (spent == budget.getMaxBudget()) {
            IO.println("Good job, now dont spend another penny!");
        } else if (spent > budget.getMaxBudget()) {
            IO.println("HOLY SHIT YOU ARE YOU CRAZY???");
        }
        spent = 0;
    }
}
