import Uppgiften.*;

void main() {
        /*
        Vad programmet ska göra:
        -lägg till expense
        -deklarera budget
        -översikt/hålla koll på budget
        -ha färdiga kategorier vid start
         */
    Scanner sc = new Scanner(System.in);
    Menu menu = new Menu();

    Budget budget = new Budget(1000.0);
    budget.addObserver(new TotalBudgetObserver(budget));

    Factory factory = new Factory();
    CategoryRepository cr = new CategoryRepository();

    for(String s : cr.defaultNames){
        cr.categories.add(factory.createCategory(s));
    }

    for (Category c: cr.categories) {
        budget.addObserver(new CategoryObserver(c, 500.0));
    }

    boolean running = true;
    while(running){
        menu.showMenu();
        running = menu.executeChoice(sc, cr, budget, factory);
    }
}
