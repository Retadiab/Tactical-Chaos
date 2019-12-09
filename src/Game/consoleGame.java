package Game;

import Champion.Champion;
import Exceptions.IllegalGameMove;
import Exceptions.IllegalSquare;
import Player.ConsolePlayer;
import Player.*;

import Arena.Arena;
import UnassignedClasses.Planning;
import UnassignedClasses.Round;

import java.util.ArrayList;
import java.util.Scanner;

public class consoleGame extends Game{
    static Scanner numberOfPlayers1 =new Scanner(System.in);








    ArrayList<Player> players = new ArrayList<Player>();


    @Override
    public void initGame() {

        this.players = this.initPlayers();
        this.arena = new Arena();
//        printArena();
        TacticalChaosTM t = new TacticalChaosTM(this.players);


//        takeTurns(this.players);

    }

    @Override
    public void printArena() {
        this.arena.printArena();

    }

    @Override
    public void ApplyMove(Player p) throws IllegalSquare, IllegalGameMove {

    }

    @Override
    public Player takeTurns(ArrayList<Player> players) {

        return getRandomPlayer(players);

    }




    public  class TacticalChaosTM extends RoundManager {

        ArrayList<Round> rounds =new ArrayList<Round>();
        ArrayList<Player> x = new ArrayList<Player>();
        public void PropagateMove(Champion sourceChampion , Champion targetChampion ){
            gamestate= GameState.startGame;



        }


        public TacticalChaosTM(ArrayList<Player> x) {
            this.x = x;
            ArrayList<Player> tempPlayers = new ArrayList<Player>();
            tempPlayers = this.x;

            while (tempPlayers.size()!=0){
            Player currentPlayer = takeTurns(tempPlayers);
//            System.out.println(currentPlayer);
            tempPlayers.remove(currentPlayer);


                Planning planningPhase1 = new Planning();

                planningPhase1.getChampionChoiceFromPhase1(planningPhase1.printPlanningListPhase1(),currentPlayer,arena);

                rounds.add(planningPhase1);
//            System.out.println(tempPlayers);
//            ApplyMove(currentPlayer);


            }
        }

        public TacticalChaosTM() {


        }


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


    public static void main(String[] args) {
        consoleGame c = new consoleGame();
    }
}
