package Move;

import Arena.Arena;
import Champion.Champion;
import Player.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class MoveFactory {
    /*
       System.out.println("Welcome to phase 2, please choose your plan: ");

       System.out.println("1- Sell champions.");
       System.out.println("2- Buy champions.");
       System.out.println("3- Move a specific champion.");
       System.out.println("4- Attack a champion.");
       System.out.println("5- Use ability for specific champion.");
       System.out.println("6- Place champion.");
       System.out.println("7- Swap between tow champions -one from the Arena , the other one from the Bench-. ");
       System.out.println("Your choice is: ");
        */
    public static void creatMove(Champion champion , int choice  , Arena arena , Player p1 , ArrayList<Player> players){

        switch (choice) {
            case (1) :
            {

            }
            case (2) :
            {
                BuyMove buyMove = new BuyMove();
                buyMove.doBuying(5) ;

                break;
            }
            case (3) :
            {
                Scanner d = new Scanner(System.in);
                int id ;
                System.out.println("where did you want to move ? ");
                System.out.println(" 1-move up \n 2-move down \n 3-move left \n 4-move right");
                System.out.print("your choice :");
                id = d.nextInt() ;
                WalkMove move = new WalkMove();
                move.PerformMove(champion , id , arena,p1,players);
                break;
            }
            case (4) :
            {
                break;
            }


            case (5):
                break;



            case (6) :
            {
                Scanner Sx = new Scanner(System.in) ;
                Scanner Sy = new Scanner(System.in) ;
                int x ;
                int y ;
                System.out.print("select x :");
                x = Sx.nextInt() ;
                System.out.print("select y : ");
                y = Sy.nextInt() ;
                PlaceMove move = new PlaceMove();
                move.placeMove(x,y,champion , arena,players,p1);
                break;
            }
            case (7) :
            {

            }
        }

    }

    public static void main(String[] args) {


    }



}
