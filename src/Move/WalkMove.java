package Move;
import Arena.*;
import Champion.*;
public class WalkMove extends Move {

    public void PerformMove(Champion champion , int id , Arena arena ) {
        /*
        1-move up
        2-move down
        3-move left
        4move right
         */

        switch (id ) {
            case (1) :
                MoveUp(champion , arena);
            case (2) :
                MoveDown(champion , arena);
            case (3) :
                MoveLeft(champion , arena);
            case(4):
                MoveRight(champion , arena);
            default:
                throw new IllegalStateException("Unexpected value: " + id);

        }


    }
    public void MoveUp(Champion champion , Arena arena ) {
        champion.y = champion.y + (int)champion.MovementSpeed ;
        if (champion.y < 0 )
            champion.y =  0 ;
        PlaceMove move = new PlaceMove();
        move.placeMove(champion.x , champion.y ,champion , arena,null,null);
    }
    public void MoveDown(Champion champion , Arena arena) {
        champion.y = champion.y - (int)champion.MovementSpeed ;
        if (champion.y > 100)
            champion.y = 100 ;
        PlaceMove move = new PlaceMove();
        move.placeMove(champion.x , champion.y ,champion , arena,null,null);
    }
    public void MoveLeft(Champion champion , Arena arena) {
      champion.x = champion.x - (int) champion.MovementSpeed ;
      if (champion.x < 0 )
          champion.x = 0 ;
        PlaceMove move = new PlaceMove();
        move.placeMove(champion.x , champion.y ,champion , arena,null , null);
    }
    public void MoveRight(Champion champion , Arena arena){
        champion.x = champion.x + (int) champion.MovementSpeed ;
        if (champion.x > 100)
            champion.x = 100 ;
        PlaceMove move = new PlaceMove();
        move.placeMove(champion.x , champion.y ,champion , arena,null,null);

    }
}
