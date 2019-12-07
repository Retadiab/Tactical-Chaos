package Player;

import Champion.Champion;

import java.util.ArrayList;

public  class ConsolePlayer extends Player {

    ArrayList<Champion> currentChampions = new ArrayList<Champion>();
    int PlayerIndex;



    public int getIndex() {
        return PlayerIndex;
    }

    public void setIndex(int PlayerIndex) {
        this.PlayerIndex = PlayerIndex;;
    }




    public void setCurrentChampions(ArrayList<Champion> currentChampions) {
        this.currentChampions = currentChampions;
    }

    public ArrayList<Champion> getCurrentChampions() {
        return currentChampions;
    }

    int money= 0 ;



}
