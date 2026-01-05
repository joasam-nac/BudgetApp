package Tidigare_gjort;

import java.util.ArrayList;
import java.util.List;

public class CategoryFactory {
    private List<String> defaultCategories = new ArrayList<>();
    // fasta budgetvärden
    private List<Double> defaultBudgets = new ArrayList<>();

    CategoryFactory() {
        defaultCategories.add("Mat");
        defaultCategories.add("Kläder");

        defaultBudgets.add(1000.0);
        defaultBudgets.add(2000.0);



    }
}
