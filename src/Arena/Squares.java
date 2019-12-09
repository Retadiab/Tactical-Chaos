package Arena;

import Arena.SquaresState;
import Champion.Champion;

import java.util.ArrayList;

public class Squares {
    private int x;
    private int y;
    SquaresState state;

    ArrayList<Champion> championsIn = new ArrayList<Champion>();


    public ArrayList<Champion> getChampionsIn() {
        return championsIn;
    }

    public void setChampionsIn(ArrayList<Champion> championsIn) {
        this.championsIn = championsIn;
    }







    public SquaresState getState() {
        return state;
    }

    public void setState(SquaresState state) {
        this.state = state;
    }

}
