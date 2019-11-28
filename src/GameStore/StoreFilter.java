package GameStore;

import Champion.Champion;
import UnassignedClasses.ReadFileLineByLineUsingBufferedReader;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class StoreFilter {
    protected StoreFilter decoratedStoreFilter;

    private ArrayList<String> championsList = new ArrayList<String>();
    public ArrayList<String> c = new ArrayList<String>();
    private float[] floatAttributes = new float[50];

    private  int championId;
    private int int1 ;
    public String str;
    public  ArrayList<String>  readChampionFromFile() {

        ReadFileLineByLineUsingBufferedReader myFile = new ReadFileLineByLineUsingBufferedReader();
        this.championsList = ReadFileLineByLineUsingBufferedReader.readFile();

        return this.championsList;
        //        System.out.println(this.sequence);

    }

public Champion readChampion(String championAsString){
    String[] champion = championAsString.split(",");
//System.out.println(championAsString);
for (int l =0 ; l<champion.length; l++)
{

//    System.out.println(champion[l]);
}
    this.int1= parseInt(champion[4]);

//    System.out.println("44444444444444444444444"+this.int1);

        String string =new String();
//        String[] array1 = array1.champion[i].split(",");

    float f = parseFloat(champion[5]);
//    System.out.println("5555555555555555555555555555555"+f);
int j =0 ;
        for (int i = 5; i < champion.length-1; i++) {
            floatAttributes[j] = parseFloat(champion[i]);
//            System.out.println("floate addddd"+floatAttributes[j]);
            j++;


    }


int len = champion.length;

    Champion championToReturn = new Champion(
            champion[0],
            champion[1],
            champion[2],
            champion[3],
            this.int1,
            floatAttributes[0],
            floatAttributes[1],
            floatAttributes[2],
            floatAttributes[3],
            floatAttributes[4],
            floatAttributes[5],
            floatAttributes[6],
            floatAttributes[7],
            floatAttributes[8],
            floatAttributes[9],
            floatAttributes[10],
            champion[len-1]);

    return  championToReturn;

}


    //
    public ArrayList<Champion>  GetChampionsList(){
        ArrayList<String> championsList1 = new ArrayList<String>();
        championsList1 = readChampionFromFile();
        ArrayList<Champion> championsList = new ArrayList<Champion>();

        for(int i1 =1 ; i1< championsList1.size() ; i1++ )
        {



            Champion c;


            c= readChampion(championsList1.get(i1));

            championsList.add(i1-1,c);


        }
        return  championsList ;

    }


    protected  StoreFilter storeFilter(StoreFilter storefilter){
return storefilter;
    }

    public static void  main(String[] args) {
         ArrayList<Champion> championsList1 = new ArrayList<Champion>();

        StoreFilter f = new StoreFilter();
        championsList1 = f.GetChampionsList();
        for(int i = 0 ; i< championsList1.size() ; i++) {
            System.out.println("==============================================");
            System.out.print(i);
            System.out.print(championsList1.get(i));
        }

    }
}
