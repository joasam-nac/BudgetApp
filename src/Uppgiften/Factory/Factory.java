package Uppgiften.Factory;

public class Factory {

    public Factory() {}

    public BudgetObject createObject(String object) {
        return switch (object) {
            case "category" -> new Category("placeholder", 500);
            case "expense" -> new Expense("placeholder", 0, new Category("placeholder", 500));
            default -> throw new IllegalStateException("Unexpected value: " + object);
        };
    }
}
