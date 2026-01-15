package Uppgiften.Memento;


import Uppgiften.Expense;

import java.util.ArrayList;
import java.util.List;

public class BudgetMemento implements Memento{

    private final List<Expense> snapshot;

    public BudgetMemento(List<Expense> snapshot){
        this.snapshot = new ArrayList<>(snapshot);
    }

    public List<Expense> getSnapshot(){
        return snapshot;
    }



}
