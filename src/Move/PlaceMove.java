package Move;

import Arena.*;

import Champion.Champion;
import Player.Player;

import java.util.ArrayList;

public class PlaceMove extends Move {


boolean donePlaced = false;

    public boolean placeMove(int x , int y , Champion p, Arena a , ArrayList<Player> players , Player playerForSquare){



                a.getSquare(x,y).setChampionsIn(p);
                a.getSquare(x,y).setPlayersIn(playerForSquare);


                System.out.println("champions on araena");
                System.out.println(a.getSquare(x,y).getPlayersIn());
                p.x = x ;
                p.y = y ;
                a.getSquare(x,y).setState(SquaresState.Occupied);
                //remember to delete the champoin from the old square cuz i used your placemove in walkmove :P
        return donePlaced =true;

    }

}
