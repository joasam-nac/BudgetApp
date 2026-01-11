package Uppgiften;


public class ObserverTest implements BudgetObserver{

    public ObserverTest() {}

    public void maxBudgetCheck(Budget budget, Category category){
        double spent = 0;
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
    }
}
