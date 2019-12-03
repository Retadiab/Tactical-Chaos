package GameStore;

import Champion.Champion;

import java.util.ArrayList;
import java.util.Random;

public class TemporalStoreFilter extends StoreFilter {
    public  static Random r =new Random();


    public static Champion getRandomChestItem(ArrayList<Champion> items) {
        return items.get(new Random().nextInt(items.size()));
    }

    private ArrayList<Champion> championsListForStore = new ArrayList<Champion>();



    ArrayList<Champion> GetOnly(int championsNumber) {

        ArrayList<Champion> championsForTempStore =new ArrayList<Champion>();
        championsListForStore = GetChampionsList();

        for(int i=0 ; i<championsNumber ;i++){

            championsForTempStore.add(getRandomChestItem(championsListForStore));

            System.out.println(championsForTempStore.get(i));
            System.out.println("==============================================");


        }
        return championsForTempStore;
    }




//    public static void main(String[] args) {
//
//
//        TemporalStoreFilter Store = new TemporalStoreFilter();
//
//        Store.GetOnly(5);
//      //  Store.GetOnly(5);
////        System.out.println(Store.GetChampionsList());
//
//
//
//    }
}
