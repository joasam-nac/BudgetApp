public class Expense implements Transaction {
    public String name;
    public double value;
    public Category category;

    public Expense(String name, double value,  Category category) {
        this.name = name;
        this.value = value;
        this.category = category;
    }

    public String getName() {
        return name;
    }
    public double getValue() {
        return value;
    }
    public String getCategory() {
        return category.getName();
    }
}
