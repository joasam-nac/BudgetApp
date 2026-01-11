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
    CategoryFactory cf = new CategoryFactory();
    Budget budget = new Budget(1000.0);
    budget.addObserver(new ObserverTest(budget, 0.8));
    for (Category c: cf.categories) {
        budget.addObserver(new CategoryObserver(c, 500.0));
    }

    boolean running = true;
    while(running){
        menu.showMenu();
        running = menu.executeChoice(sc, cf, budget);
    }
}
