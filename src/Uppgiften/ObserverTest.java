package Uppgiften;

public class ObserverTest implements BudgetObserver {

    private final Budget budget;
    private double spent = 0.0;
    private final double ratio;
    public ObserverTest(Budget budget, double ratio) {
        this.budget = budget;
        this.ratio = ratio;
    }

    @Override
    public void onExpenseAdded(Expense e){
        spent += e.getValue();
        if (spent >= ratio*budget.getMaxBudget()){
            System.out.println("HOLY SHIT YOU ARE CLOSE TO THE CAP OF YOUR BUDGET ARE YOU CRAZY???");
        }
    }
}
