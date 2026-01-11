import Uppgiften.*;

void main() {

    Scanner sc = new Scanner(System.in);
    Menu menu = new Menu();
    CategoryFactory cf = new CategoryFactory();

    boolean running = true;
    while(running){
        menu.showMenu();
        running = menu.executeChoice(sc, cf);
    }
}
