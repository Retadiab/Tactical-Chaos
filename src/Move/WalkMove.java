package Move;
import Arena.*;
import Champion.*;
import Player.Player;

import java.util.ArrayList;

public class WalkMove extends Move {

    public void PerformMove(Champion champion , int id , Arena arena  , Player p1 , ArrayList<Player> players) {
        /*
        1-move up
        2-move down
        3-move left
        4move right
         */

        switch (id ) {
            case (1) :
                MoveUp(champion , arena,p1,players);
            case (2) :
                MoveDown(champion , arena,p1,players);
            case (3) :
                MoveLeft(champion , arena,p1,players);
            case(4):
                MoveRight(champion , arena,p1,players);
            default:
                throw new IllegalStateException("Unexpected value: " + id);

        }


    }
    public void MoveUp(Champion champion , Arena arena, Player p1 , ArrayList<Player> players ) {
        champion.y = champion.y + (int)champion.MovementSpeed ;
        if (champion.y < 0 )
            champion.y =  0 ;
        PlaceMove move = new PlaceMove();
        move.placeMove(champion.x , champion.y ,champion , arena,players , p1);
    }


    public void MoveDown(Champion champion , Arena arena, Player p1 , ArrayList<Player> players) {
        champion.y = champion.y - (int)champion.MovementSpeed ;
        if (champion.y > 100)
            champion.y = 100 ;
        PlaceMove move = new PlaceMove();
        move.placeMove(champion.x , champion.y ,champion , arena,players,p1);
    }
    public void MoveLeft(Champion champion , Arena arena, Player p1 , ArrayList<Player> players) {
      champion.x = champion.x - (int) champion.MovementSpeed ;
      if (champion.x < 0 )
          champion.x = 0 ;
        PlaceMove move = new PlaceMove();
        move.placeMove(champion.x , champion.y ,champion , arena,players,p1);
    }
    public void MoveRight(Champion champion , Arena arena, Player p1 , ArrayList<Player> players){
        champion.x = champion.x + (int) champion.MovementSpeed ;
        if (champion.x > 100)
            champion.x = 100 ;
        PlaceMove move = new PlaceMove();
        move.placeMove(champion.x , champion.y ,champion , arena,players,p1);

    }
}
