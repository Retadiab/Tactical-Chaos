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
import java.util.Iterator;
import java.util.Scanner;

public class consoleGame extends Game{



    public class ConsoleColors {
        // Reset
        public static final String RESET = "\033[0m";  // Text Reset

        // Regular Colors
        public static final String BLACK = "\033[0;30m";   // BLACK
        public static final String RED = "\033[0;31m";     // RED
        public static final String GREEN = "\033[0;32m";   // GREEN
        public static final String YELLOW = "\033[0;33m";  // YELLOW
        public static final String BLUE = "\033[0;34m";    // BLUE
        public static final String PURPLE = "\033[0;35m";  // PURPLE
        public static final String CYAN = "\033[0;36m";    // CYAN
        public static final String WHITE = "\033[0;37m";   // WHITE

        // Bold
        public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
        public static final String RED_BOLD = "\033[1;31m";    // RED
        public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
        public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
        public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
        public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
        public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
        public static final String WHITE_BOLD = "\033[1;37m";  // WHITE

        // Underline
        public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
        public static final String RED_UNDERLINED = "\033[4;31m";    // RED
        public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
        public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
        public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
        public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
        public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
        public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE


    }


    static Scanner WayOfPlaying =new Scanner(System.in);
    private ArrayList<Player> players = new ArrayList<Player>();

//    ArrayList<Player> playersForPhase2 = new ArrayList<Player>();


    @Override
    public void initGame() {
        System.out.println();
        System.out.println(ConsoleColors.YELLOW+"=======================================================================================================================");
        System.out.println(ConsoleColors.PURPLE_BOLD+"\t\t\t\t\t\t\t\t\tWelcome To Tactical Chaos Console Game");
        System.out.println(ConsoleColors.YELLOW+"======================================================================================================================="+ConsoleColors.RESET);

        System.out.println(ConsoleColors.PURPLE_UNDERLINED+"Please choose the way of playing: "+ConsoleColors.RESET);
        System.out.println("#1 \t One console player against bots. ");
        System.out.println("#2 \t Bots against each other: ");

        int wayOfPlaying = WayOfPlaying.nextInt();
//        System.out.println(ConsoleColors.YELLOW+"======================================================================================================================="+ConsoleColors.RESET);


        this.players = this.initPlayers(wayOfPlaying);

//        for(int i=0 ; i<this.players.size(); i++){
//            System.out.println("mn l 0"+this.players.get(i).getPlayerIndex());
//        }

        this.arena = new Arena();
        TacticalChaosTM t = new TacticalChaosTM(this.players,wayOfPlaying);

//        printArena();


//        takeTurns(this.players);

    }


    @Override
    public boolean GameEnd(ArrayList<Player> playersOfTheGame){

        if(playersOfTheGame.size()>1)
        {


            for (Iterator<Player> iterator = playersOfTheGame.iterator(); iterator.hasNext();) {
                Player p = iterator.next();
//                if (p.isEmpty()) {
//                    // Remove the current element from the iterator and the list.
//                }

                if(p.getArenaChampions().size()==0){

                    iterator.remove();
                }
                return false;

            }

//
//            for(Player p : playersOfTheGame)
//            {
//                if(p.getArenaChampions().size()==0){
//
//                    playersOfTheGame.remove(p);
//                }
//
//
//
//            }
            return false;
        }

        else {
            for (Player p : playersOfTheGame) {
                System.out.println("End of the Game! >>>>>>>");
                System.out.println("Player" +p.getPlayerIndex()+"the name ");
            }
            return true;
        }

    }


    @Override
    public void ApplyMove(Player p) throws IllegalSquare, IllegalGameMove {

    }

    @Override
    public Player takeTurns(ArrayList<Player> p) {

        return getRandomPlayer(p);

    }




    public  class TacticalChaosTM extends RoundManager {

        ArrayList<Round> rounds =new ArrayList<Round>();
        ArrayList<Player> x = new ArrayList<Player>();
        ArrayList<Player> arsa = new ArrayList<Player>();

        public void PropagateMove(Champion sourceChampion , Champion targetChampion ){
            gamestate= GameState.runningGame;



        }



        public TacticalChaosTM(ArrayList<Player> playersOfTheGame,int wayOfPlaying) {

//            ArrayList<Player> playersToPrintArena = new ArrayList<Player>();
//
//            playersToPrintArena = x;
////            this.x = x;
//            ArrayList<Player> tempPlayers = new ArrayList<Player>();
//            tempPlayers = playersOfTheGame;
////            System.out.println(this.x);
//            int counter1 = tempPlayers.size();
//            System.err.println(counter1);
//
//            //phase 1 begin
//
//
//                boolean isRound =false;
//
////                Player currentPlayer = takeTurns(tempPlayers);
////                System.out.println("The Game choose Player "+ (this.x.indexOf(currentPlayer))+"  to start >>>>>>>>>>>>");
//
////                System.out.println("Cuureeent player in the phase 1"+currentPlayer);
//
//
////                int x1 ;
////                x1 = x.indexOf(currentPlayer);
////                System.out.println("index of CURRENTplayer" +x1);
//
//                tempPlayers.remove(currentPlayer);
//                arsa.add(currentPlayer);
//
//                System.out.println("tempplayers :" + tempPlayers);
//                System.out.println("tempplayers :" + arsa);
//
//                for(int j= 0 ; j<arsa.size() ; j++){
//                    System.out.println("2ersa players indexes " + arsa.get(j).getPlayerIndex());
//
//                }



            boolean isRound =false;
             ArrayList<ArrayList<String>> plansOfTheRound = new ArrayList<ArrayList<String>>();

            for(Player p : playersOfTheGame) {

                if(wayOfPlaying == 1){
                    boolean consolePlayerGotTurn=false;
                    int counter = 0;
                    int counter1 = 0;




                    if(p == playersOfTheGame.get(0)){


                        System.out.println(ConsoleColors.BLUE_BOLD+"Welcome to Phase 1. "+ConsoleColors.RESET);
                        while (counter < 9) {
                            counter = counter + 1;


                            System.out.println(ConsoleColors.PURPLE_UNDERLINED + "Phase 1 is running, please choose your movement: " + ConsoleColors.RESET);
                            Planning planningPhase1 = new Planning();
                            isRound = planningPhase1.getChampionChoiceFromPhase1(planningPhase1.printPlanningListPhase1(), p, arena, playersOfTheGame);

                            if (isRound) {
                                rounds.add(planningPhase1);
                            }
                            System.out.println("Rounds print " + rounds.size());
//                         consolePlayerGotTurn =true;
//                         continue;
                        }

                    }

                        else {
                            //planning moves of the bots
                            System.out.println(ConsoleColors.BLUE_BOLD+"Welcome to Phase 1. "+ConsoleColors.RESET);

                                Planning planningPhase1 = new Planning();
                                isRound=planningPhase1.AutoPlayerChoicesForPhase1( p, arena, playersOfTheGame);

                                if (isRound) {
                                    rounds.add(planningPhase1);
                                    rounds.add(planningPhase1);
                                    rounds.add(planningPhase1);
                                    rounds.add(planningPhase1);
                                    rounds.add(planningPhase1);
                                    rounds.add(planningPhase1);
                                    rounds.add(planningPhase1);
                                    rounds.add(planningPhase1);
                                    rounds.add(planningPhase1);
                                }
                                System.out.println("Rounds print " + rounds.size());
                                counter1++;


                        System.out.println("Rounds print " + rounds.size());

                    }
                }


                else {
                    //planning moves of the bots

                    int counter = 0;
                    System.out.println(ConsoleColors.BLUE_BOLD+"Welcome to Phase 1. "+ConsoleColors.RESET);

                        counter=counter+1;
                            Planning planningPhase1 = new Planning();
                            isRound=planningPhase1.AutoPlayerChoicesForPhase1( p, arena, playersOfTheGame);

                            if (isRound) {
                                rounds.add(planningPhase1);
                                rounds.add(planningPhase1);
                                rounds.add(planningPhase1);
                                rounds.add(planningPhase1);
                                rounds.add(planningPhase1);
                                rounds.add(planningPhase1);
                                rounds.add(planningPhase1);
                                rounds.add(planningPhase1);
                                rounds.add(planningPhase1);
                            }
                            System.out.println("Rounds print " + rounds.size());


                }

                }


//                counter1 = counter1 -1;

                //end of phase 1
//            ApplyMove(currentPlayer);



////            for(int j= 0 ; j<x.size()*9 ; j++)
////            rounds.add(new Planning());
//
//
//                ArrayList<String> planForEachPlayer = new ArrayList<String>();
//                ArrayList<ArrayList<String>> plansOfTheRound1 = new ArrayList<ArrayList<String>>();
//
//                int CounterForPlans =arsa.size()+2;
////                playersForPhase2 = arsa;
////            Player currentPlayer = takeTurns(playersForPhase2);
////            System.out.println(currentPlayer);
////            System.out.println("rsa AFTER PICKING PLAYER"+arsa);
//                while(CounterForPlans!=0) {
////
////                    System.out.println("Welcome to Phase 2 ");
////                    System.out.println(arsa);
////
////
////
////
////                    int counterPhase2 = 0;
////                    int limit = 4;
////                    Planning planningPhase2 = new Planning();
////
////                    while (counterPhase2 != limit) {
////                        planForEachPlayer.add(planningPhase2.getChampionChoiceFromPhase2(planningPhase2.printPlanningListPhase2(), currentPlayer, arena, arsa));
////                        //                    ExecuteMove executeMovePhase2 = new ExecuteMove();
////                        System.out.println(plansOfTheRound);
////                        counterPhase2++;
////                    }
////                    playersForPhase2.remove(currentPlayer);
////                    arsa.add(currentPlayer);
////                    System.out.println("player in the temp array after phase 2"+playersForPhase2);
////                    System.out.println("players in arsa"+arsa);
////                    plansOfTheRound.add(planForEachPlayer);
////                    for (int i = 0; i < plansOfTheRound.size(); i++) {
////                        for (int j = 0; j < plansOfTheRound.get(i).size(); j++) {
////                            System.out.print(plansOfTheRound.get(i).get(j) + " ");
////                        }
////                        System.out.println();
////                    }
////
////                }
////
                  int counterForTheGame =0 ;
                    while ((!GameEnd(playersOfTheGame) ) || (counterForTheGame == playersOfTheGame.size()*11 )) {
                        ArrayList<String> planForEachPlayer = new ArrayList<String>();
                        Planning plan = new Planning();
                        for (Player p : playersOfTheGame) {

                            for (Champion c : p.getArenaChampions()) {

                                //do the moves for each champion
                                String s = new String();
                                System.out.println(ConsoleColors.YELLOW + "=====================================================" + ConsoleColors.RESET);
                                System.out.println(ConsoleColors.GREEN + "Choose one move for champion " + c.championName + ConsoleColors.RESET);
                                System.out.println(ConsoleColors.YELLOW + "=====================================================" + ConsoleColors.RESET);

                                s = plan.getChampionChoiceFromPhase2(plan.printPlanningListPhase2MovesList(), p, arena, playersOfTheGame, c);
                                System.err.println("the move as string" + s);
                                planForEachPlayer.add(s);
                                System.err.println("conent of palnofeachplayer:" + planForEachPlayer);
                            }
                            plansOfTheRound.add(planForEachPlayer);

                            int counter = 0;
                            while (counter != 2) {
                                plan.getChampionChoiceFromPhase1(plan.printPlanningListPhase1(), p, arena, playersOfTheGame);

                                //do the buy and sell and place moves
                                counter++;
                            }

                        }

//
//
//
//                for (int i = 0; i < plansOfTheRound.size(); i++) {
//                        for (int j = 0; j < plansOfTheRound.get(i).size(); j++) {
//                            System.out.print(plansOfTheRound.get(i).get(j) + " ");
//                        }
//                        System.out.println();
//                    }
//
//            }

                        counterForTheGame = counterForTheGame +1;
                        System.out.println("END OF PHASE 2");
                    }

            for (Player p : playersOfTheGame) {
                System.out.println("End of the Game! >>>>>>>");
                System.out.println("Player" +p.getPlayerIndex()+"the name ");
            }


//                }
//

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
