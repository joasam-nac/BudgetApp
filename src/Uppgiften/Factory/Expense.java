package Uppgiften.Factory;

import Uppgiften.Transaction;

public class Expense implements Transaction, BudgetObject {
    private String name;
    private double value;
    private Category category;

    public Expense(String name, double value,  Category category) {
        this.name = name;
        this.value = value;
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }
    public double getValue() {
        return value;
    }
    public Category getCategory() {
        return category;
    }
    public void fill(String name, double value,  Category category){
        this.name = name;
        this.value = value;
        this.category = category;
    }
}
