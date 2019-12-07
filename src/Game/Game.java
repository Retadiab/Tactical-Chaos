package Game;

import Arena.Arena;
import Exceptions.IllegalGameMove;
import Exceptions.IllegalSquare;
import Player.ConsolePlayer;
import Player.AutoPlayer;
import Player.Player;
import UnassignedClasses.Planning;
import UnassignedClasses.Round;
import UnassignedClasses.RoundManager;

import java.util.ArrayList;

public abstract class Game {
    ArrayList<Player> players = new ArrayList<Player>();
    public Arena arena;
    public int turnNumber;
    protected int numberOfPlayers;

    private GameState gamestate = GameState.startGame ;



    Game() {
        this.initGame();
        this.turnNumber = 0;
        this.gamestate= GameState.startGame;
    }

    abstract public void initGame();

    abstract public void printArena();
    abstract public void ApplyMove(Player p) throws IllegalSquare, IllegalGameMove;
    abstract public void takeTurns();



    public class RoundManager {
        ArrayList<Round> rounds =new ArrayList<Round>();
        ArrayList<Player> x = new ArrayList<Player>();

        public RoundManager(ArrayList<Player> x) {
            this.x = x;
        }



        // public PropogateMove(Champion sourceChampion)

    }

                public void GameBegin(){



                }

    public void initPlayers(){
        players.add(new ConsolePlayer());
        for(int i = 1; i < players.size(); i++)
            players.add(new AutoPlayer());
    }



    public void render() {

    }

}
