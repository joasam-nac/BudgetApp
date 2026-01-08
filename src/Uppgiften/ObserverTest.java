package Uppgiften;

public class ObserverTest {

    private final double budget;
    private double spent = 0;
    private final double ratio;
    public ObserverTest(double budget, double spent, double ratio) {
        this.budget = budget;
        this.spent = spent;
        this.ratio = ratio;
    }

    public void ping(double payment){
        addExpense(payment);
        checkSpending();
    }

    public void addExpense(double payment){
        spent += payment;
    }

    public void checkSpending(){
        if (spent >= ratio*budget){
            System.out.println("HOLY SHIT YOU ARE CLOSE TO THE CAP OF YOUR BUDGET ARE YOU CRAZY???");
        }
    }
}
