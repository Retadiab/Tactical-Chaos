package UnassignedClasses;

import Arena.SquaresState;
import Champion.Champion;

import java.util.ArrayList;

public class Squares {
    private int x;
    private int y;
    SquaresState state;

    ArrayList<Champion> championInTheSameSquare = new ArrayList<Champion>();
    public SquaresState getState() {
        return state;
    }

    public void setState(SquaresState state) {
        this.state = state;
    }

}
