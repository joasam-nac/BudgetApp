package Tidigare_gjort;

import java.time.LocalDateTime;

public class Transaction {
    int id;
    double amount;
    LocalDateTime date;
    String categoryName;

    Transaction(double amount, String categoryName) {
        this.id = IdHandler.getNextId();
        this.amount = amount;
        this.date = LocalDateTime.now();
        this.categoryName = categoryName;
    }

    int getId() {
        return id;
    }

    double getAmount() {
        return amount;
    }

    LocalDateTime getDate() {
        return date;
    }

    String getCategoryName() {
        return categoryName;
    }


    // inte klar!
    @Override
    public String toString(){
        return "transaction";
    }
}
