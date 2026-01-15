package Uppgiften;

import Uppgiften.Memento.BudgetMemento;
import Uppgiften.Memento.Caretaker;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Menu {

    private final Caretaker caretaker = new Caretaker();

    public Menu(Budget b){
        caretaker.saveSnapshot(b.save());
    }

    public void showMenu(){

        System.out.println("\n=== Budget App ===");
        UserChoices.getAllDescriptions();
        System.out.print("Choose an option: ");

    }
    
    public boolean executeChoice(Scanner sc, CategoryRepository cr, Budget budget, Factory factory){


            UserChoices uc = UserChoices.fromInput(sc.nextLine());

            switch(uc){
                case CHANGE_BUDGET:
                    System.out.println("Set new budget:");
                    System.out.println("1. Total budget");
                    System.out.println("2. Category budget");
                    System.out.println("Choose an option (number): ");

                    int choice = (Integer) CorrectInputControl.check(sc, InputType.FOR_A_INT, true);

                    if(choice == 1){
                        System.out.print("Set new total budget: ");
                        double maxBudget = (Double) CorrectInputControl.check(sc,InputType.FOR_A_DOUBLE, true);
                        budget.setMaxBudget(maxBudget);
                        break;
                    } else if(choice == 2){
                        System.out.println("Categories:");

                        int idx = 0;
                        for (Category c : cr.getAllCategories()) {
                            idx++;
                            System.out.println(idx + ". " + c.getName() + " (" + c.getBudget() + ")");
                        }
                        System.out.print("Select category (number): ");
                        int categoryChoice = (Integer) CorrectInputControl.check(sc, InputType.FOR_A_INT, true);
                        Category selected = cr.getCategoryFromOrder(categoryChoice - 1);
                        if (selected == null){
                            System.out.println("Invalid category!");
                            break;
                        }
                        System.out.print("Set new budget for " + selected.getName() + ": ");
                        double newBudget = (Double) CorrectInputControl.check(sc, InputType.FOR_A_DOUBLE, true);
                        selected.setBudget(newBudget);
                        break;
                    }
                    System.out.println("Invalid option!");
                    break;

                case ADD_EXPENSE:
                    System.out.print("Write name of expense:");
                    String expenseName = sc.nextLine();
                    System.out.print("Write Expense amount: ");
                    double expenseAmount = (Double) CorrectInputControl.check(sc,InputType.FOR_A_DOUBLE, true);

                    System.out.println("List of categories:");

                    int i = 0;
                    for(Category c: cr.getAllCategories()){
                        i++;
                        System.out.println(i + ". " + c.getName());
                    }
                    System.out.println(++i + ". New Category");

                    System.out.println("Choose an option (number): ");

                    int categoryChoice = (Integer) CorrectInputControl.check(sc,InputType.FOR_A_INT,true);

                    Category selectedCategory;

                    if (categoryChoice == i) {
                        System.out.println("New category name:");
                        String categoryName = sc.nextLine();

                        selectedCategory = cr.addCategory(factory.createCategory(categoryName));

                        System.out.println("Choose budget for category:");
                        double categoryBudget = (Double) CorrectInputControl.check(sc,InputType.FOR_A_DOUBLE, true);


                        budget.addObserver(new CategoryObserver(cr.getCategory(categoryName)));
                    } else {
                        selectedCategory = cr.getCategoryFromOrder(categoryChoice - 1);
                    }

                    budget.addExpense(
                            factory.createExpense(expenseName, expenseAmount, selectedCategory)
                    );
                    caretaker.saveSnapshot(budget.save());
                    break;

                case EDIT_EXPENSE:
                    System.out.println("Edit expense");
                    TransactionEditor te = new TransactionEditor(budget, cr, factory);
                    te.editTransaction(sc);
                    caretaker.saveSnapshot(budget.save());
                    break;
                case UNDO_EXPENSE:
                    try {
                        IO.println("\nThe following expense has been undone: " + budget.getExpenses().getLast().getName());
                        budget.restore((BudgetMemento) caretaker.getMemento());
                    }catch(NoSuchElementException e){
                        IO.println("\nThere is no expense to be undone.");
                    }
                    break;
                case CHECK_OVERVIEW:
                    budget.print();
                    break;
                case EXIT:
                    System.out.println("Exiting...");
                    return false;
                case null:
                    System.out.println("Invalid input :(");
                    break;

            }
            return true;

    }

}
