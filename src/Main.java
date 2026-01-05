public class Main {
    static void main() {
        /*
        Vad programmet ska göra:
        -lägg till expense
        -deklarera budget
        -översikt/hålla koll på budget
        -ha färdiga kategorier vid start
         */
        Category clothes = new Category("Kläder");
        Category food = new Category("Mat");

        Budget budget = new Budget(10000.0);

        budget.addExpense(new Expense("Uniqlo t-shirt", 300.0, clothes));
        budget.addExpense(new Expense("HM t-shirt", 400.0, clothes));

        budget.addExpense(new Expense("MAX", 600.0, food));
        budget.addExpense(new Expense("ICA", 700.0, food));

        budget.print();
    }

    // går igenom lista med kategorier

}
