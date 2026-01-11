package Uppgiften;

import java.util.Scanner;

//MHA observer kunna sätta budget per kategori
//varna när användare är nära budget-tak

//Kolla in att lägga in decorator i menyval
//Jobba vidare på observer för katogori

public class Menu {



    public void showMenu(){

        System.out.println("\n=== Budget App ===");
        UserChoices.getAllDescriptions();
        System.out.print("Choose an option: ");

    }
    
    public boolean executeChoice(Scanner sc, CategoryFactory cf, Budget budget){

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

                    Category selectedCategory;

                    if (categoryChoice == i) {
                        System.out.println("New category name:");
                        String categoryName = sc.nextLine();

                        selectedCategory = new Category(categoryName);
                        cf.createCategory(selectedCategory);

                        System.out.println("Choose budget for category:");
                        double categoryBudget = sc.nextDouble();
                        sc.nextLine();

                        budget.addObserver(new CategoryObserver(selectedCategory, categoryBudget));
                    } else {
                        selectedCategory = cf.getCategoryFromOrder(categoryChoice);
                    }

                    budget.addExpense(
                            new Expense(expenseName, expenseAmount, selectedCategory)
                    );
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


}
