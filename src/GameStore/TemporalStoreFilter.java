package GameStore;

import Champion.Champion;
import Move.BuyMove;
import Player.Player;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TemporalStoreFilter extends StoreFilter {
    public  static Random r =new Random();
    static Scanner pickedChampionScanner =new Scanner(System.in);


    //championsForTempStore has got the 10 copies of each champion ,
   static ArrayList<Champion> championsForTempStore =new ArrayList<Champion>();



    //championsForTempStore1 getting random 5 elements from the championsForTempStore tah got 10 copies  ,
    static ArrayList<Champion> championsForTempStore1 =new ArrayList<Champion>();



   //Player choices from the championsForTempStore1 that got 5 random champions
   static ArrayList<Integer> championChoices =new ArrayList<Integer>();


   private int IndexToDelete = 0 ;

   //The Real indexes of the champion's choices to remove it from the main list that got 10 copies
    static ArrayList<Integer> IndexesToDelete =new ArrayList<Integer>();

    BuyMove move = new BuyMove();




    //random champion from the list
    public  Champion getRandomChestItem(ArrayList<Champion> items) {
        this.IndexToDelete = new Random().nextInt(items.size());
        return items.get(this.IndexToDelete);
    }


    //this championsListFromStore is for getting the array from exel file
    private ArrayList<Champion> championsListFromStore = new ArrayList<Champion>();


    //this method is for getting the choices from Player and store them in Arraylist of integers
    ArrayList<Integer> GetOnly(int championsNumber) {


        championsListFromStore = GetChampionsList();
        int championList = 47, copyOfEachChampionInMainStore = 10;
        ArrayList <Champion> mainstore;


            for (int i = 1; i < championList ; i++) {
                for (int j = 0; j < copyOfEachChampionInMainStore; j++) {
                    Champion champ = new Champion();
                    championsForTempStore.add(championsListFromStore.get(i));
                }

            }


//            System.out.println(championsForTempStore);
        for(int i1=0 ; i1<championsNumber ;i1++){
            championsForTempStore1.add(getRandomChestItem(championsForTempStore));
          IndexesToDelete.add(this.IndexToDelete);


            System.out.println(championsForTempStore1.get(i1));
            System.out.println("==============================================");
        }



        int counter=0;

        while(counter < 3 ) {

            System.out.println("Please Enter Your choice  :  -------IF YOU DON'T WANT TO ADD MORE CHAMPIONS PRESS ***0***------ ");

            int pickedChampion;
            pickedChampion = pickedChampionScanner.nextInt();


            if(pickedChampion == 0 ){

                break;
            }
            else if(pickedChampion >5 || pickedChampion<0){
                System.out.println("Please enter a number between 1 -> 5 ");
            }
            else if(championChoices.contains(pickedChampion)){

                System.out.println("You have Already chosen this Champion , Please Pick Another One.. ");
            }
            else{
                championChoices.add(pickedChampion);
                int x =IndexesToDelete.get(pickedChampion-1);
                championsForTempStore.remove(x);
                System.out.println("Your champion Has been Added successfully! ");
                counter = counter+1;}
               }

        System.out.println(championChoices);
        return championChoices;
    }



    public boolean doBuying(int championsNumber ){

         BuyMove buying = new BuyMove();
         ArrayList<Champion> CurrentChampions =new ArrayList<Champion>();
         ArrayList<Integer> choices = new ArrayList<Integer>();
         TemporalStoreFilter tempStore = new TemporalStoreFilter();
         choices= tempStore.GetOnly(championsNumber);
         CurrentChampions =  buying.performMove(choices,championsForTempStore1,championsForTempStore);
         System.out.println("================================="+CurrentChampions);


             return true;
    }







    public static void main(String[] args) {
        TemporalStoreFilter Store = new TemporalStoreFilter();
        Store.GetOnly(5);
    }
}
