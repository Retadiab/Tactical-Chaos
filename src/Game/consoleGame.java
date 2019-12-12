package Game;

import Champion.Champion;
import Exceptions.IllegalGameMove;
import Exceptions.IllegalSquare;
import Player.*;

import Arena.Arena;
import Rounds.ExecuteMove;
import Rounds.Plan;
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
//        for(int i=0 ; i<this.players.size(); i++){
//            System.out.println("mn l 0"+this.players.get(i).getPlayerIndex());
//        }

        this.arena = new Arena();
        TacticalChaosTM t = new TacticalChaosTM(this.players);

//        printArena();


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

            ArrayList<Player> playersToPrintArena = new ArrayList<Player>();

            playersToPrintArena = x;
//            this.x = x;
            ArrayList<Player> tempPlayers = new ArrayList<Player>();
            tempPlayers = x;
//            System.out.println(this.x);
            int counter1 = tempPlayers.size();
            ////phase 1 begin
//            while (counter1 !=0){
//
//                Player currentPlayer = takeTurns(tempPlayers);
////                System.out.println("The Game choose Player "+ (this.x.indexOf(currentPlayer))+"  to start >>>>>>>>>>>>");
//
//                System.out.println(currentPlayer);
//                System.out.println("Cuureeent player infexxxx"+currentPlayer.getPlayerIndex());
//
//
//                int x1 ;
//                x1 = x.indexOf(currentPlayer);
//                System.out.println("index of CURRENTplayer" +x1);
//                boolean isRound =false;
//                int counter = 0;
//                System.out.println("Welcome to Phase 1, please choose your movement: ");
//                while(counter < 9 ){
//                    System.out.println("Phase 1 is still running, please choose your movement: ");
//
//                    Planning planningPhase1 = new Planning();
//
//                    isRound =planningPhase1.getChampionChoiceFromPhase1(planningPhase1.printPlanningListPhase1(),currentPlayer,arena, playersToPrintArena);
//
//                    if(isRound){
//                        rounds.add(planningPhase1);
//                    }
////                    System.out.println("Rounds print "+rounds);
//                    counter++;
//
//
//                }
//            tempPlayers.remove(currentPlayer);
//                x.add(currentPlayer);
//
//counter1 = counter1 -1;
//
//
//            System.out.println(tempPlayers);
//
////            ApplyMove(currentPlayer);
//            }
            for(int j= 0 ; j<x.size()*9 ; j++)
            rounds.add(new Planning());


            if(rounds.size() == (x.size()*9)){
                ArrayList<Plan> plansOfTheRound = new ArrayList<Plan>();
                int CounterForPlans = tempPlayers.size();



                System.out.println("Welcome to Phase 2 ");
                System.out.println(tempPlayers);
                Player currentPlayer = takeTurns(tempPlayers);
                System.out.println(currentPlayer);
                int counterPhase2 = 0 ;
                int limit = currentPlayer.getArenaChampions().size()+2;
                while (counterPhase2 != limit) {
                    Planning planningPhase2 = new Planning();
                    planningPhase2.getChampionChoiceFromPhase2(planningPhase2.printPlanningListPhase2(), currentPlayer, arena, tempPlayers);


                    //                    ExecuteMove executeMovePhase2 = new ExecuteMove();

                    counterPhase2++;
                }
                System.out.println("END OF PHASE 2");

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
    public ArrayList<Player> getPlayers(){
        return initPlayers();
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
