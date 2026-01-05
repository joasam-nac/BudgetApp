import java.util.ArrayList;
import java.util.List;

public class Budget {
    public double maxBudget = 1000.0;
    public List<Expense> expenses;

    Budget(double maxBudget) {
        this.maxBudget = maxBudget;
        this.expenses = new ArrayList<Expense>();
    }

    public void addExpense(Expense e){
        this.expenses.add(e);
    }

    public void print() {
        System.out.println("Översikt:");
        double sum = 0.0;
        for(Expense e: this.expenses){
            System.out.println(e.getName() + ", " + e.getCategory() + ": " + e.getValue());
            sum += e.getValue();
        }
        System.out.println("Total: " + sum);
        System.out.println((sum*100.0)/maxBudget + "% av budgeten spenderad");
    }
}
