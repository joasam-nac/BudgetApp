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

    boolean running = true;
    while(running){
        menu.showMenu();
        running = menu.executeChoice(sc, cf);
    }
}
