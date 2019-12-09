package Player;

import Champion.Champion;

import java.util.ArrayList;

public abstract class Player {
String name;
    public ArrayList<Champion> getCurrentChampions() {
        return currentChampions;
    }

    public void setCurrentChampions(ArrayList<Champion> currentChampions) {
        this.currentChampions = currentChampions;
    }

    ArrayList<Champion> currentChampions = new ArrayList<Champion>();
    public void PropagateMove(){};




}
