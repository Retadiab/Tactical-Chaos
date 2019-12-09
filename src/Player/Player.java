package Player;

import Champion.Champion;
import GameStore.Bench;

import java.util.ArrayList;

public abstract class Player {
    String name;
    Bench playerBench = new Bench();
    ArrayList<Champion> currentChampions = new ArrayList<Champion>();

    public ArrayList<Champion> getBenchChampions() {
        return playerBench.getBenchChampions();
    }



    public ArrayList<Champion> setBenchChampions(ArrayList<Champion> benchChampions) {

        ArrayList<Champion> benchChampions1 = new ArrayList<Champion>();
        playerBench.setBenchChampions(benchChampions);
         return benchChampions1;
    }



    public ArrayList<Champion> getCurrentChampions() {
        return currentChampions;
    }

    public void setCurrentChampions(ArrayList<Champion> currentChampions) {
        this.currentChampions = currentChampions;
    }

    public void PropagateMove(){};

    public abstract void setName(String playerName);


}
