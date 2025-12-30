import java.util.ArrayList;
import java.util.List;

public class BudgetTracker implements Observer{
    double budget;
    double spent;
    double ratio; // (0,1]
    List<Category> categories;

    void setTotalBudget() {
        this.spent = 0.0;
        this.categories = new ArrayList<>();
    }
    void setBudget(double budget) {
        this.budget = budget;
    }

    void setRate(double ratio) {
        this.ratio = ratio;
    }

    void addCategory(Category category) {
        this.categories.add(category);
    }

    @Override
    public void update(String categoryName, double categorySpent){
        spent = 0;

        for (Category category : this.categories) {
            spent += category.getSpent();
        }

        // Spotta ut info om nödvändigt...
        //---------------------------------

        if (spent > budget){
            System.out.println("Gått över budget!");
        } else if (spent >= budget*ratio) {
            System.out.println("Nära gränsen!");
        }

    }
}
