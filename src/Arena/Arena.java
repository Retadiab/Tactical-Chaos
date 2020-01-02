package Arena;


import Champion.Champion;
import Items.Item;
import Move.PlaceMove;
import Player.Player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import static Items.ItemsFactory.getItem;

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
                this.squares[i][j].item = RandomItem() ;
                this.squares[i][j].item.x = i;
                this.squares[i][j].item.y = j ;
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
                        System.err.print("| [" + c.toInitials() + "P" + c.getPlayerId() +"] |");


                    }
                    continue;

                }
                else {
                    System.err.print("squares[i][j]");


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

                    for(Champion c : squares[i][j].getChampionsIn()){

                        if(c.playerId == p.getPlayerIndex()) {
                            System.err.print(" | [" + c.toInitials() + "P" + c.getPlayerId() + "] |");


                        }else
                            System.out.print("| [###] |");


                    }


                }
//                else {
//                    System.err.print("");
//
//
//                }
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


    static Random r = new Random() ;
   static public Item RandomItem(){
      int  x= getRandom(7 , 1);
        return getItem(x);
    }


    public static int   getRandom(int h , int l)
    {
        return r.nextInt((h-l)+1)+l ;}






/*    public static void main(String[] args) {
       for (int i = 0 ; i <6 ; i++){
       Item item =  RandomItem() ;
           System.out.print(i+ "  ");
        System.out.println(item);}


        Arena arena = new Arena();
        for (int i = 0 ; i <14 ; i++)
            for (int j = 0 ; j <55 ; j++){
                System.out.println("this is square"+i+j+"item");
                System.out.println(arena.getSquare(i,j).item.toString());}
    }*/


}
