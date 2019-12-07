package Move;

import Champion.Champion;
import Player.Player;

import java.util.ArrayList;

public class BuyMove extends Move {
//
//    public ArrayList<Champion> performMove(ArrayList<Integer> index, ArrayList<Integer> choice, ArrayList<Champion> TemporarStoreChampions) {
//        ArrayList<Champion> currentChampions = new ArrayList();
//        for (int i = 3; i >= 0; i--)
//            if (if_exists(i, choice))
//                index.remove(i);
//        index = sort(index);
//        for (int i = 3; i >= 0 && i < TemporarStoreChampions.size(); i--)
//            if (!if_exists(i, index)) {
//                currentChampions.add(TemporarStoreChampions.get(i));
//                TemporarStoreChampions.remove(i);
//            }
//        return currentChampions;
//    }
//
//    private boolean if_exists(int i, ArrayList<Integer> choice) {
//    }


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


}
