package Game;

import Exceptions.IllegalGameMove;
import Exceptions.IllegalSquare;
import Player.ConsolePlayer;
import Player.*;

import Arena.Arena;
import java.util.ArrayList;
import java.util.Scanner;

public class consoleGame extends Game{
    static Scanner numberOfPlayers1 =new Scanner(System.in);








    ArrayList<Player> players = new ArrayList<Player>();
    public void scanSettings(){
        System.out.println("please enter the number of players ");
        System.out.println("Note : the number must be up to 8 ");
        int numberOfPlayers ;
        numberOfPlayers= numberOfPlayers1.nextInt();
        if(numberOfPlayers > 8 || numberOfPlayers <= 0) {

            ConsolePlayer p1 = new ConsolePlayer();
            players.add(p1);
            for (int i =1; i < numberOfPlayers; i++) {
                AutoPlayer p = new AutoPlayer();
                players.add(p);
            }
        }
        else
        {
            System.out.println("please enter a right Number >>> ");
        }



    }

    @Override
    public void initGame() {

        this.initPlayers();
        printArena();
        takeTurns();

    }

    @Override
    public void printArena() {
        this.arena.printArena();

    }

    @Override
    public void ApplyMove(Player p) throws IllegalSquare, IllegalGameMove {

    }

    @Override
    public void takeTurns() {

    }



//
//    public void scanSettings() {
//
//        this.numberOfPlayers= numberOfPlayers1.nextInt();
//         Scanner numberOfPlayers2 =new Scanner(System.in);
//
//        this.numberOfPlayers = numberOfPlayers2.nextInt();
//        while(this.numberOfPlayers > 8 || this.numberOfPlayers < 2) {
//            System.err.println("Number of players is invalid");
//            this.numberOfPlayers = numberOfPlayers2.nextInt();
//        }
//
//
//    }

}
