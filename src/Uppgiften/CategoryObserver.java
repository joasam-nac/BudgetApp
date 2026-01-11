package Uppgiften;

public class CategoryObserver implements BudgetObserver{

    private String category;

    public CategoryObserver(String category){

        this.category = category;
    }

    @Override
    public void maxBudgetCheck(Budget budget, Category category){

        double spentCategory = 0;
        double ratio = category.getRatio() * category.getMaxCategoryBudget();

        for( Expense expense : budget.expenses){
            if(expense.category.equals(category)){
                spentCategory += expense.getValue();
            }
        }

        if (spentCategory >= ratio && spentCategory < category.getMaxCategoryBudget()){
            System.out.println("You are getting close to your planned spending for this category: " + category.getName());
        } else if (spentCategory == category.getMaxCategoryBudget()) {
            IO.println("You reach your budget roof for this category!");
        } else if (spentCategory > category.getMaxCategoryBudget()) {
            IO.println("Opsie you seem to have exceeded the max budget for this category: " + category.getName());
        }
    }
}
