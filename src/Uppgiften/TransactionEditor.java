package Uppgiften;

import java.util.Scanner;

public record TransactionEditor(Budget budget, CategoryFactory categoryFactory) {

    public void editTransaction(Scanner scanner) {

        if (budget.expenses.isEmpty()) {
            System.out.println("No expenses found");
            return;
        }
        System.out.println("Current expenses: ");
        for (int i = 0; i < budget.expenses.size(); i++) {
            Expense e = budget.expenses.get(i);
            System.out.println((i + 1) + ". " + e.getName() + ". " + e.getValue() + ". " + e.getCategory());
        }


        System.out.println("Select expense you want to change ");
        int selection = scanner.nextInt();
        scanner.nextLine();

        Expense expenseToEdit = budget.expenses.get(selection - 1);

        System.out.println("Editing: " + expenseToEdit.getName());
        System.out.println("1. Change name");
        System.out.println("2. Change value");
        System.out.println("3. Change category");
        System.out.println("4. Delete expense");

        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                System.out.println("Enter new name: ");
                expenseToEdit.name = scanner.nextLine();
                System.out.println("Name change Successful");
                break;
            case 2:
                System.out.println("Enter new value: ");
                double newValue = scanner.nextDouble();
                scanner.nextLine();
                expenseToEdit.value = newValue;
                System.out.println("Amount updated: " + expenseToEdit.name);
                budget.observers.getFirst().onBudgetEdited();
                break;
            case 3:
                System.out.println("Enter new category: ");
                int i = 0;
                for (Category c : categoryFactory.getAllCategories()) {
                    i++;
                    System.out.println(i + ". " + c.name());
                }

                System.out.print("Choose category: ");
                int categoryChoice = scanner.nextInt();
                scanner.nextLine();
                expenseToEdit.category = categoryFactory.getCategoryFromOrder(categoryChoice);
                System.out.println(expenseToEdit.name + " successfully edited");
                break;
            case 4:
                String name = budget.expenses.get(selection - 1).getName();
                budget.expenses.remove(selection - 1);
                System.out.println("Deleted expense: " + name);
                budget.observers.getFirst().onBudgetEdited();
                break;
            default:
                System.out.println("Invalid option");

        }

    }
}
