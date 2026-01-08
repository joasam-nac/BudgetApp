package Uppgiften;

import java.util.InputMismatchException;
import java.util.Scanner;

//MHA observer kunna sätta budget per kategori
//varna när användare är nära budget-tak

public class Menu {

    public static Budget budget = new Budget(1000.0);

    public void showMenu(){

        System.out.println("\n=== Budget App ===");
        UserChoices.getAllDescriptions();
        System.out.print("Choose an option: ");

    }
    
    public boolean executeChoice(Scanner sc, CategoryFactory cf){

            UserChoices uc = UserChoices.fromInput(sc.nextLine());

            IO.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

            switch(uc){
                case CHANGE_BUDGET:
                    System.out.print("Set new max budget:");
                    double maxBudget = awaitDouble(sc);
                    budget.setMaxBudget(maxBudget);
                    break;
                case ADD_EXPENSE:
                    System.out.print("Write name of expense:");
                    String expenseName = sc.nextLine();
                    System.out.print("Write Expense amount: ");
                    double expenseAmount = awaitDouble(sc);
                    System.out.println("List of categories:");

                    int i = 0;
                    for(Category c: cf.getAllCategories()){
                        i++;
                        System.out.println(i + ". " + c.name());
                    }
                    System.out.println(++i + ". New Category");

                    System.out.println("Choose an option (number): ");

                    int categoryChoice = awaitInt(sc);
                    sc.nextLine();

                    if(categoryChoice == i){
                        System.out.println("New category selected");
                        System.out.println("New category name: ");

                        String categoryName = sc.nextLine();
                        cf.createCategory(new Category(categoryName));
                    }
                    budget.addExpense(new Expense(expenseName, expenseAmount, cf.getCategoryFromOrder(categoryChoice)));
                    break;

                case EDIT_EXPENSE:
                    System.out.println("Edit expense");
                    TransactionEditor te = new TransactionEditor(budget, cf);
                    te.editTransaction(sc);
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

    public double awaitDouble(Scanner sc){

        double input;

        while(true){
            try{
            input = sc.nextDouble();
            break;
            }catch (InputMismatchException ex) {
                IO.println("Invalid input, try again!");
            }
            sc.nextLine();
        }
        return input;
    }

    public int awaitInt(Scanner sc){

        int input;

        while(true){
            try{
                input = sc.nextInt();
                break;
            }catch (InputMismatchException ex) {
                IO.println("Invalid input, try again!");
            }
            sc.nextLine();
        }
        return input;
    }


}
