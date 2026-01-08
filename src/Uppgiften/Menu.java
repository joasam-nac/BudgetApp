package Uppgiften;

import java.util.Scanner;

// Att göra: Kunna redigera transaktion.
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

            switch(uc){
                case CHANGE_BUDGET:
                    System.out.print("Set new max budget:");
                    double maxBudget = sc.nextDouble();
                    sc.nextLine();
                    budget.setMaxBudget(maxBudget);
                    break;
                case ADD_EXPENSE:
                    System.out.print("Write name of expense:");
                    String expenseName = sc.nextLine();
                    System.out.print("Write Expense amount: ");
                    double expenseAmount = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("List of categories:");

                    int i = 0;
                    for(Category c: cf.getAllCategories()){
                        i++;
                        System.out.println(i + ". " + c.name());
                    }
                    System.out.println(++i + ". New Category");

                    System.out.println("Choose an option (number): ");

                    int categoryChoice = sc.nextInt();

                    sc.nextLine();

                    if(categoryChoice == i){
                        System.out.println("New category selected");
                        System.out.println("New category name: ");

                        String categoryName = sc.nextLine();
                        cf.createCategory(new Category(categoryName));
                    }
                    budget.addExpense(new Expense(expenseName, expenseAmount, cf.getCategoryFromOrder(categoryChoice)));
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
