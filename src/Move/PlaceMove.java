package Move;

import Arena.*;

import Champion.Champion;

public class PlaceMove {




    public void placeMove(int x , int y , Champion p, Arena a ){



                a.getSquare(x,y).getChampionsIn().add(p);

    }

}
