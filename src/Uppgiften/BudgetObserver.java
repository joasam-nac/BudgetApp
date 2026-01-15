package Uppgiften;

import Uppgiften.Factory.Expense;

public interface BudgetObserver {
    void onExpenseAdded(Expense e);
}
