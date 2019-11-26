package UnassignedClasses;


import Player.ConsolePlayer;

import java.util.ArrayList;

public class Game {
    ArrayList<ConsolePlayer> players = new ArrayList<ConsolePlayer>();
    Arena arena;

    public Game(Arena arena, int playersNumber) {
        this.arena = arena;
        for (int i = 0; i < playersNumber; i++) {
            players.add(new ConsolePlayer());
        }
    }

    public void render() {

    }

}
