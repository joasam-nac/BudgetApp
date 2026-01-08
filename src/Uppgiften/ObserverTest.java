package Uppgiften;

public class ObserverTest implements BudgetObserver {

    private final double budget;
    private double spent = 0.0;
    private final double ratio;
    public ObserverTest(double budget, double ratio) {
        this.budget = budget;
        this.ratio = ratio;
    }

    public void ping(Expense e) {
        onExpenseAdded(e);
    }

    public void onExpenseAdded(Expense e){
        spent += e.getValue();
        if (spent >= ratio*budget){
            System.out.println("HOLY SHIT YOU ARE CLOSE TO THE CAP OF YOUR BUDGET ARE YOU CRAZY???");
        }
    }
}
