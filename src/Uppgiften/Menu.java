package Uppgiften;

import java.util.Scanner;

//MHA observer kunna sätta budget per kategori

//Kolla in att lägga in decorator i menyval

public class Menu {

    public void showMenu(){

        System.out.println("\n=== Budget App ===");
        UserChoices.getAllDescriptions();
        System.out.print("Choose an option: ");

    }
    
    public boolean executeChoice(Scanner sc, CategoryRepository cr, Budget budget, Factory factory){

            UserChoices uc = UserChoices.fromInput(sc.nextLine());

            switch(uc){
                case CHANGE_BUDGET:
                    System.out.print("Set new max budget:");
                    double maxBudget = (Double) CorrectInputControl.check(sc,InputType.FOR_A_DOUBLE, true);

                    budget.setMaxBudget(maxBudget);
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
                        System.out.println(i + ". " + c.name());
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


                        budget.addObserver(new CategoryObserver(cr.getCategory(categoryName), categoryBudget));
                    } else {
                        selectedCategory = cr.getCategoryFromOrder(categoryChoice);
                    }

                    budget.addExpense(
                            factory.createExpense(expenseName, expenseAmount, selectedCategory)
                    );
                    break;

                case EDIT_EXPENSE:
                    System.out.println("Edit expense");
                    TransactionEditor te = new TransactionEditor(budget, cr, factory);
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
