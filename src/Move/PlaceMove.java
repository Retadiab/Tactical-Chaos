package Move;

import Arena.*;

import Champion.Champion;

public class PlaceMove extends Move {




    public void placeMove(int x , int y , Champion p, Arena a ){



                a.getSquare(x,y).getChampionsIn().add(p);
                p.x = x ;
                p.y = y ;
                //remember to delete the champoin from the old square cuz i used your placemove in walkmove :P

    }

}
