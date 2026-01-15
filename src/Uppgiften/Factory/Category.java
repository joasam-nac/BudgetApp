package Uppgiften.Factory;

public class Category implements BudgetObject {
    private String name;
    private double budget;

    Category(String name, double budget){
        this.name = name;
        this.budget = budget;
    }

    public String getName() {
        return name;
    }
    public double getBudget() { return budget;}
    public void setBudget(double newMax){ this.budget = newMax;}

    public void setName(String name) {
        this.name = name;
    }
}


