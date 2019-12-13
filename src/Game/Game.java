package Game;

import Arena.Arena;
import Champion.Champion;
import Exceptions.IllegalGameMove;
import Exceptions.IllegalSquare;
import Player.ConsolePlayer;
import Player.AutoPlayer;
import Player.Player;
import Rounds.Planning;
import Rounds.Round;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public abstract class Game {

    static Scanner numberOfPlayers1 =new Scanner(System.in);
    static Scanner PlayerName =new Scanner(System.in);
    ArrayList<Player> players = new ArrayList<Player>();
    public Arena arena ;
    public int turnNumber;
    public int numberOfPlayers3;
    public   Random r =new Random();

    public GameState gamestate = GameState.startGame ;

    int numberOfPlayers ;




    private int IndexToDelete = 0 ;


    public  Player getRandomPlayer(ArrayList<Player> items) {
        this.IndexToDelete = new Random().nextInt(items.size());
        Player p = items.get(this.IndexToDelete);
//        System.out.println(this.IndexToDelete);
//        System.out.println(items.get(this.IndexToDelete));

//        if(this.IndexToDelete == 0){
//
//            //something wrong !!!!!!!!!!!
//            System.out.println("Please enter your NAME: ");
//            String playerName = new String();
//            playerName= PlayerName.nextLine();
////            System.out.println(playerName);
//            items.get(0).setName(playerName);
//
//        }



        return p;
    }

    Game() {
        this.initGame();
        this.turnNumber = 0;
        gamestate= GameState.startGame;
    }
    public int getIndexOfPlayerToPrintItWithArena() {
        return IndexToDelete;
    }
    abstract public void initGame();

    public void printArena(Player p){
                            arena.printArena(p,null);

    }
    abstract public void ApplyMove(Player p) throws IllegalSquare, IllegalGameMove;
    abstract public Player takeTurns(ArrayList<Player> players);


    public abstract class TacticalChaosTM extends RoundManager {};

    public abstract class RoundManager {
        ArrayList<Round> rounds =new ArrayList<Round>();
        public  ArrayList<Player> x = new ArrayList<Player>();

        public RoundManager(ArrayList<Player> x) {
            this.x = x;
//            ApplyMove(currentPlayer);


            while(gamestate != GameState.endGame){

                if( rounds.size()<9){
                    Player currentPlayer = takeTurns(this.x);
                    System.out.println("The Game choose Player "+ (this.x.indexOf(currentPlayer)+1)+"  to start >>>>>>>>>>>>");

                    Planning planningPhase1 = new Planning();

                    planningPhase1.getChampionChoiceFromPhase1(planningPhase1.printPlanningListPhase1(),currentPlayer,arena, this.x);


                     rounds.add(planningPhase1);

                }
                else {

                    Player currentPlayer = takeTurns(this.x);
                    Planning planningPhase2 = new Planning();
//                    .getChampionChoiceFromPhase2(planningPhase2.printPlanningListPhase2(),currentPlayer,arena,getIndexOfPlayerToPrintItWithArena());
                    //how many times the champion could make a plane >> and when should i do the execute move ??
                    //mbye there is no time limited for the planning such ass when he want to end plannig he could press any button to end the planning phase and then directly i could make the execute for planning

                    rounds.add(planningPhase2);



                }


            }
        }



        public RoundManager() {

        }


        public void PropagateMove(Champion sourceChampion, Champion targetChampion){};
//        public void PropagateMove(Champion sourceChampion, Champion targetChampion, ){};

    }

                public void GameBegin(){



                }



    public ArrayList<Player> initPlayers(){
        System.out.println("please enter the number of players ");
        System.out.println("Note : the number must be up to 8 ");
        numberOfPlayers= numberOfPlayers1.nextInt();
        this.numberOfPlayers3=numberOfPlayers;
        boolean wrongNum=false;
        if(numberOfPlayers > 8 || numberOfPlayers <= 1) {
            wrongNum=true;
            while (wrongNum){

                System.err.println("please enter a right Number >>> ");
                numberOfPlayers= numberOfPlayers1.nextInt();
                if(numberOfPlayers > 8 || numberOfPlayers <= 1) {
                    wrongNum=true;}
                else
                    wrongNum=false;

            }


        }


            ConsolePlayer p1 = new ConsolePlayer();
//            p1.setIndex(1);
//            System.out.println("player1 index"+p1.getIndex());
            players.add(p1);
//            System.out.println("player1  after adding"+p1.getIndex());

            players.get(0).setPlayerIndex(1);
//            System.out.println("player1 index"+players.get(0).getPlayerIndex());

            for (int i =2; i <=numberOfPlayers; i++) {
                AutoPlayer p = new AutoPlayer();
                p.setPlayerIndex(i);
//                System.out.println("players from inital"+p.getPlayerIndex());

                players.add(p);
            }
//            System.out.println("players from inital1111111111111"+players);


        System.out.println("players from inital"+players);

        return this.players;

    }



    public void render() {

    }

}
