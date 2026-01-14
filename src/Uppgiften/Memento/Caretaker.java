package Uppgiften.Memento;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {

    private int state = -1;
    private final List<Memento> snapshots = new ArrayList<>();

    public Caretaker(){}

    public void saveSnapshot(Memento snapshot){

        while(snapshots.size() > state + 1) {
            snapshots.removeLast();
        }

        snapshots.add(snapshot);
        state++;
    }

    public Memento getMemento(){

        if(state <= 0){
            state = 0;
            return snapshots.isEmpty() ? null : snapshots.getFirst();
        }
        state--;
        return snapshots.get(state);
    }
}
