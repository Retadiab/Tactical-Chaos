package Arena;


import Player.Player;

import java.util.ArrayList;

public  class Arena {
    public static Squares[][] getSquares() {
        return squares;
    }

    public static void setSquares(Squares[][] squares) {
        Arena.squares = squares;
    }

    static Squares[][] squares;
    public void setArenaSize(int arenaSize) {
        this.arenaSize = arenaSize;
    }

    int arenaSize= 100;

    SquaresState State;



    public Arena() {
       squares = new Squares[arenaSize][arenaSize];

       for (int i = 0; i < arenaSize; i++) {
            for (int j = 0; j < arenaSize; j++) {
                this.squares[i][j] = new Squares(i,j);
                this.squares[i][j].setState(State.Free);

            }
        }
    }

    public void printArena(Player p , ArrayList<Player> p1){
        System.out.println(p1.size());
System.out.println(p1);
        System.out.println("player in arena "+p);

        for(int i = 0; i < 25; i++)
        {
            for(int j = 0; j < 25; j++)
            {

            if(squares[i][j].getState() == State.Free)
                System.out.print("[###]");

            else {
//                if (squares[i][j].getPlayersIn().contains(p.getPlayerIndex())){
//                    for(int k= 0 ; k<squares[i][j].getChampionsIn().size() ; k++)
//
//                        System.err.print("["+squares[i][j].getChampionsIn().get(k).toInitials()+"P"+(p1.indexOf(p))+"]");
//                }
//                else

                                    for(int k= 0 ; k<squares[i][j].getChampionsIn().size() ; k++)
                System.err.print("["+squares[i][j].getChampionsIn().get(k).toInitials()+"P"+squares[i][j].getPlayersIn().get(k)+"]");

            }


            }
            System.out.println();
        }

    }


    public Squares getSquare(int i, int j) {
        return this.squares[i][j];
    }

    public void setSquares(int i, int j) {
        this.squares[i][j].setX(i);

    }

    public int getArenaSize() {
        return this.arenaSize;
    }


//    public static void main(String[] args) {
//        Arena a =new Arena();
//        a.printArena();
//    }


}
