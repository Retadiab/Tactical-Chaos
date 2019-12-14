package Move;
import Arena.*;
import Champion.*;
import Player.Player;

import java.util.ArrayList;

public class WalkMove extends Move {

    public boolean PerformMove(Champion champion , int id , Arena arena  , Player p1 , ArrayList<Player> players) {
        /*
        1-move up
        2-move down
        3-move left
        4move right
         */
        boolean done =false ;

        switch (id ) {
            case (1) :{
                done = MoveUp(champion , arena,p1,players);
                break;

            }
            case (2) :
                {
                done = MoveDown(champion , arena,p1,players);
                break;
                }

            case (3) :
                {
               done= MoveLeft(champion, arena, p1, players);
                break;
                }


            case(4):
                {
                done=MoveRight(champion, arena, p1, players);
                break;
                }
            default:
                throw new IllegalStateException("Unexpected value: " + id);

        }

return done;
    }
    public boolean MoveUp(Champion champion , Arena arena, Player p1 , ArrayList<Player> players ) {
        champion.y = champion.y + (int)champion.MovementSpeed ;
        if (champion.y < 0 )
            champion.y =  0 ;
        PlaceMove move = new PlaceMove();
        move.placeMove(champion.x , champion.y ,champion , arena,players , p1);
        return true;
    }


    public boolean MoveDown(Champion champion , Arena arena, Player p1 , ArrayList<Player> players) {
        champion.y = champion.y - (int)champion.MovementSpeed ;
        if (champion.y > 54)
            champion.y = 54 ;
        PlaceMove move = new PlaceMove();
        move.placeMove(champion.x , champion.y ,champion , arena,players,p1);
        return true;

    }
    public boolean MoveLeft(Champion champion , Arena arena, Player p1 , ArrayList<Player> players) {
      champion.x = champion.x - (int) champion.MovementSpeed ;
      if (champion.x < 0 )
          champion.x = 0 ;
        PlaceMove move = new PlaceMove();
        move.placeMove(champion.x , champion.y ,champion , arena,players,p1);
        return true;

    }


    public boolean MoveRight(Champion champion , Arena arena, Player p1 , ArrayList<Player> players){
        champion.x = champion.x + (int) champion.MovementSpeed ;
        if (champion.x > 13)
            champion.x = 13 ;
        PlaceMove move = new PlaceMove();
        move.placeMove(champion.x , champion.y ,champion , arena,players,p1);
        return true;


    }
}
