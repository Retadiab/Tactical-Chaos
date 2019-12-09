package Game;

import Arena.Arena;
import Champion.Champion;
import Exceptions.IllegalGameMove;
import Exceptions.IllegalSquare;
import Player.ConsolePlayer;
import Player.AutoPlayer;
import Player.Player;
import UnassignedClasses.Planning;
import UnassignedClasses.Round;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public abstract class Game {

    static Scanner numberOfPlayers1 =new Scanner(System.in);
    static Scanner PlayerName =new Scanner(System.in);
    ArrayList<Player> players = new ArrayList<Player>();
    public Arena arena ;
    public int turnNumber;
    protected int numberOfPlayers;
    public  static Random r =new Random();

    public GameState gamestate = GameState.startGame ;
    private int IndexToDelete = 0 ;


    public  Player getRandomPlayer(ArrayList<Player> items) {
        this.IndexToDelete = new Random().nextInt(items.size());
//        System.out.println(this.IndexToDelete);
//        System.out.println(items.get(this.IndexToDelete));

        System.out.println("The Game choose Player "+(this.IndexToDelete+1 )+ "  to start >>>>>>>>>>>>");

        return items.get(this.IndexToDelete);
    }

    Game() {
        this.initGame();
        this.turnNumber = 0;
        gamestate= GameState.startGame;
    }

    abstract public void initGame();

    abstract public void printArena();
    abstract public void ApplyMove(Player p) throws IllegalSquare, IllegalGameMove;
    abstract public Player takeTurns(ArrayList<Player> players);


    public abstract class TacticalChaosTM extends RoundManager {};

    public abstract class RoundManager {
        ArrayList<Round> rounds =new ArrayList<Round>();
        ArrayList<Player> x = new ArrayList<Player>();

        public RoundManager(ArrayList<Player> x) {
            this.x = x;
//            ApplyMove(currentPlayer);


            while(gamestate != GameState.endGame){

                if( rounds.size()<9){
                    Player currentPlayer = takeTurns(this.x);

                    Planning planningPhase1 = new Planning();

                    planningPhase1.getChampionChoiceFromPhase1(planningPhase1.printPlanningListPhase1(),currentPlayer,arena);

                     rounds.add(planningPhase1);

                }
                else {

                    Player currentPlayer = takeTurns(this.x);
                    Planning planningPhase2 = new Planning();
                    planningPhase2.getChampionChoiceFromPhase2(planningPhase2.printPlanningListPhase2(),currentPlayer,arena);
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
        int numberOfPlayers ;
        numberOfPlayers= numberOfPlayers1.nextInt();
        if(numberOfPlayers > 8 || numberOfPlayers <= 0) {
            System.out.println("please enter a right Number >>> ");


        }
        else
        {


            ConsolePlayer p1 = new ConsolePlayer();
            players.add(p1);
            System.out.println("Please enter your NAME: ");
            String playerName = new String();
            playerName= PlayerName.nextLine();
            System.out.println(playerName);
            p1.setName(playerName);

            for (int i =1; i < numberOfPlayers; i++) {
                AutoPlayer p = new AutoPlayer();
                players.add(p);
            }
        }
//        System.out.println(players);

        return this.players;

    }



    public void render() {

    }

}
