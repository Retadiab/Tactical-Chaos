package Arena;


import Champion.Champion;
import Move.PlaceMove;
import Player.Player;

import java.util.ArrayList;
import java.util.Iterator;

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
    public void printAllChampionsInTheArena() {


        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 55; j++) {


                if(squares[i][j].getState() == State.Free){
                    System.out.print("| [###] |");

                }
                else if(squares[i][j].getState() == State.Occupied) {

                    for(Champion c : squares[i][j].getChampionsIn()){
                        System.err.print(" | [" + c.toInitials() + "P" + c.getPlayerId() +"] |");


                    }

                }
                else {
                    System.err.print("");


                }
            }
            System.out.println("");

        }

    }


    public void printArena(Player p ) {



        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 55; j++) {


                if(squares[i][j].getState() == State.Free){
                    System.out.print("| [###] |");

                }
                else if(squares[i][j].getState() == State.Occupied) {
                    for(Champion c1 :squares[i][j].getChampionsIn() ){


                        for(Champion c : p.getArenaChampions()){


                            if (c.equals(c1))

                                System.err.print(" | [" + c.toInitials() + "P" + c.getPlayerId() +"] |");

                            else
                                System.out.print("| [###] |");

                        }
                    }


                }
                else {
                    System.err.print("| [###] |");


                }
            }
            System.out.println("");

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

ArrayList<Champion> allChampionsOnArena = new ArrayList<Champion>();
    public ArrayList<Champion> getAllChampionsOnArena(){
        for(int i = 0; i < 25; i++)
        {
            for(int j = 0; j < 25; j++) {
                for(int k= 0 ; k<squares[i][j].getChampionsIn().size() ; k++)
                    allChampionsOnArena.addAll(squares[i][j].getChampionsIn());


            }




    }
    return allChampionsOnArena;
    }

//    public static void main(String[] args) {
//        Arena a =new Arena();
//        a.printArena();
//    }


}
