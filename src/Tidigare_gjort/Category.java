package Tidigare_gjort;

import java.util.ArrayList;
import java.util.List;

public class Category {
    String name;
    double budget;
    double spent;
    List<Transaction> transactions;
    Observer observer;

    Category(String name, double budget, Observer observer) {
        this.name = name;
        this.budget = budget;
        this.observer = observer;

        this.transactions = new ArrayList<Transaction>();
        this.spent = 0.0;
    }

    void addExpense(double amount){
        transactions.add(new Transaction(amount, name));
        this.spent += amount;
        notifyObservers();
    }

    double getRemaining(){
        return budget - spent;
    }

    String getName(){
        return name;
    }

    double getBudget(){
        return budget;
    }

    double getSpent(){
        return spent;
    }

    List<Transaction> getTransactions(){
        return transactions;
    }

    void notifyObservers(){
        if (observer != null){
            observer.update(this.name, this.spent);
        }
    }
}
