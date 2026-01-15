import Uppgiften.*;
import Uppgiften.Factory.Category;
import Uppgiften.Factory.Factory;

void main() {

    Scanner sc = new Scanner(System.in);

    Budget budget = new Budget(1000.0);
    budget.addObserver(new TotalBudgetObserver(budget));

    Menu menu = new Menu(budget);

    Factory factory = new Factory();
    CategoryRepository cr = new CategoryRepository();

    for(String s : cr.defaultNames){
        Category c = (Category) factory.createObject("category");
        c.setName(s);
        cr.categories.add(c);
    }

    for (Category c: cr.categories) {
        budget.addObserver(new CategoryObserver(c));
    }

    boolean running = true;
    while(running){
        menu.showMenu();
        running = menu.executeChoice(sc, cr, budget, factory);
    }


}
