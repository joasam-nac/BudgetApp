package Uppgiften;

public class Factory {

    public Factory(){}

    public Category createCategory(String name){
        return new Category(name, 500.0);
    }

    public Expense createExpense(String name, Double value, Category category){
        return new Expense(name, value, category);
    }
}
