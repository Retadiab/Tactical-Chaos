package Game;

import Champion.Champion;
import Exceptions.IllegalGameMove;
import Exceptions.IllegalSquare;
import Player.*;

import Arena.Arena;
import Rounds.Planning;
import Rounds.Round;

import java.util.ArrayList;
import java.util.Scanner;

public class consoleGame extends Game{
    static Scanner numberOfPlayers1 =new Scanner(System.in);








    private ArrayList<Player> players = new ArrayList<Player>();


    @Override
    public void initGame() {

        this.players = this.initPlayers();
        for(int i=0 ; i<this.players.size(); i++){
            System.out.println("mn l 0"+this.players.get(i).getPlayerIndex());
        }
        this.arena = new Arena();
//        printArena();
        TacticalChaosTM t = new TacticalChaosTM(this.players);


//        takeTurns(this.players);

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
            gamestate= GameState.runningGame;



        }



        public TacticalChaosTM(ArrayList<Player> x) {
            this.x = x;
            ArrayList<Player> tempPlayers = new ArrayList<Player>();
            tempPlayers = this.x;
//            System.out.println(this.x);
            ////phase 1 begin
            while (tempPlayers.size()!=0){

                Player currentPlayer = takeTurns(tempPlayers);
//                System.out.println("The Game choose Player "+ (this.x.indexOf(currentPlayer))+"  to start >>>>>>>>>>>>");

                System.out.println(currentPlayer);
                System.out.println("Cuureeent player infexxxx"+currentPlayer.getPlayerIndex());


                int x1 ;
                x1 = this.x.indexOf(currentPlayer);
//                System.out.println("index of player" +x1);
                boolean isRound =false;
                int counter = 0;
                System.out.println("Welcome to Phase 1, please choose your movement: ");
                while(counter < 9 ){
                    System.out.println("Phase 1 is still running, please choose your movement: ");

                    Planning planningPhase1 = new Planning();


                    isRound =planningPhase1.getChampionChoiceFromPhase1(planningPhase1.printPlanningListPhase1(),currentPlayer,arena, this.x);

                    if(isRound){
                        rounds.add(planningPhase1);
                    }
//                    System.out.println("Rounds print "+rounds);
                    counter++;


                }
            tempPlayers.remove(currentPlayer);
                System.out.println("players in x beforw adding" +x);
                x.add(currentPlayer);
                System.out.println("players in x After adding" +x);



            System.out.println(tempPlayers);

//            ApplyMove(currentPlayer);
            }
            if(rounds.size() == (this.x.size()*9)){


                System.out.println("game"+this.x);
                System.out.println("phase 2 is heereeeeeeeeeeeeeeee");
            }

            //end of phase 1




        }

        public TacticalChaosTM() {


        }
        public ArrayList<Player> getX() {
            return x;
        }

        public void setX(ArrayList<Player> x) {
            this.x = x;
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
