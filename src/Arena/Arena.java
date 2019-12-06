package Arena;

import UnassignedClasses.Squares;

import java.util.ArrayList;

public class Arena {
    static Squares[][] squares;
    int arenaSize= 100;






    public Arena() {
        squares = new Squares[arenaSize][arenaSize];
        for (int i = 0; i < arenaSize; i++) {
            for (int j = 0; j < arenaSize; j++) {
                this.squares[i][j] = new Squares();
            }
        }
    }

    public void printArena(){

        for(int i = 0; i < 25; i++)
        {
            for(int j = 0; j < 25; j++)
            {
                System.out.printf("[###]", squares[i][j]);
            }
        }    }


    public Squares getSquare(int i, int j) {
        return this.squares[i][j];
    }

    public int getArenaSize() {
        return this.arenaSize;
    }


    public static void main(String[] args) {
        Arena a =new Arena();
        a.printArena();
    }


}
