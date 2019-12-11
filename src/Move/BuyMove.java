package Move;

import Champion.Champion;
import GameStore.TemporalStoreFilter;
import Player.Player;

import java.util.ArrayList;

public class BuyMove extends Move {

        public ArrayList<Champion> performMove(ArrayList<Integer> choice, ArrayList<Champion> TemporalStoreChampions, ArrayList<Champion> storeChampions) {
            ArrayList<Champion> currentChampions = new ArrayList();
            Champion tempChamp = new Champion();
                     for (int i = 0; i <choice.size(); i++){

                         if(choice.size()>0){


                             currentChampions.add(TemporalStoreChampions.get((choice.get(i))-1));

                         }

                     }
//                     System.out.println(currentChampions);

                    return currentChampions;


        }

    public ArrayList<Champion> doBuying(int championsNumber ){

        BuyMove buying = new BuyMove();
        ArrayList<Champion> CurrentChampions =new ArrayList<Champion>();
        ArrayList<Integer> choices = new ArrayList<Integer>();
        TemporalStoreFilter tempStore = new TemporalStoreFilter();
        choices= tempStore.GetOnly(championsNumber);
        System.out.println(choices);
        CurrentChampions =  buying.performMove(choices,tempStore.getChampionsForTempStore1(),tempStore.getChampionsForTempStore());
//        System.out.println();
//
//         System.out.println("================================="+CurrentChampions);
        return CurrentChampions;
    }


    public static void main(String[] args) {
        BuyMove mo = new BuyMove();
        mo.doBuying(5);
    }


}
