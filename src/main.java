import UnassignedClasses.Arena;
import UnassignedClasses.Game;

public class main {

    public static void main(String[] args) {
        System.out.println("HELLO WORLD!");
        Arena arena = new Arena(10, 10);
        Game game = new Game(arena,3);
    }

}
