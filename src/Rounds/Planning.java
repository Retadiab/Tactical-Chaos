//package UnassignedClasses;
//
//public class Planning extends Round{
//    private int newField(){return 0;};
//    public void GetTemporalList(){};
//
//}
package Rounds;



import Arena.Arena;
import GameStore.TemporalStoreFilter;
import Champion.Champion;
import Move.*;
import Player.Player;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Scanner;

public class Planning extends Round{
     private boolean err =false;
    static Scanner x =new Scanner(System.in);
    static Scanner x1 =new Scanner(System.in);
    static Scanner x2 =new Scanner(System.in);
    static Scanner indexOfChosenChampionScanner =new Scanner(System.in);
    static Scanner xCoorScanner = new Scanner(System.in);
    static Scanner yCoorScanner = new Scanner(System.in);
    ArrayList<String> plan = new ArrayList<String>();
    static Scanner championToMove =new Scanner(System.in);
    static Scanner ChampionToAttackWith =new Scanner(System.in);
    static Scanner ChampionToBeAttacked =new Scanner(System.in);

    static ArrayList<Champion> championsForPlan = new ArrayList<Champion>();




    private int newField(){return 0;};
    public void GetTemporalList(){};

    public int printPlanningListPhase1(){
        if(this.err){
            System.err.println("1- Buy champions.");
        }

        else {
            System.out.println("1- Buy champions.");
        }

        System.out.println("2- Place your champions.");
        System.out.println("Your choice is: ");
        int userChoice= x.nextInt();
        return userChoice;
    }

    public int printPlanningListPhase2(){

        System.out.println("Welcome to phase 2, please choose your plan: ");

        System.out.println("1- Sell champions.");
        System.out.println("2- Buy champions.");
        System.out.println("3- Walk move.");
        System.out.println("4- Attack a champion.");
        System.out.println("5- Use ability for specific champion.");
        System.out.println("6- Place champion.");
        System.out.println("7- Swap");
        System.out.println("Your choice is: ");


        int userChoice= x.nextInt();
        return userChoice;



    }
    public boolean getChampionChoiceFromPhase1(int userChoice, Player p, Arena arena, ArrayList<Player> indexOfPlayerToPrintItWithArena){

boolean isRound = false;
//System.out.println("palesfred iddd" + indexOfPlayerToPrintItWithArena) ;
        switch (userChoice) {

            case (1):
            {

                ArrayList<Champion> addedChampions = new ArrayList<Champion>();
                BuyMove move1 = new BuyMove();

//                System.out.println(addedChampions);
                if(p.getBenchChampions().size()<=9) {
                    if(p.getBenchChampions().size()==9){
                        System.err.println("Your Bench is full, Please place some Champions to free some spaces in the Bench!!! ");
                        this.err=true;
                        break;
                    }
                    System.out.println("champions array size"+p.getBenchChampions().size());
                    addedChampions = move1.doBuying(5);
                    p.getCurrentChampions().addAll(addedChampions);
                    p.getBenchChampions().addAll(addedChampions);
//                    System.out.println();
//                    System.out.println("players Current champions" + p.getCurrentChampions());


//                    System.out.println();
//                    System.out.println("players Arena champions" + p.getArenaChampions());

//                    System.out.println("Buying move must be running right now");





                    isRound = true;
                }



                if(p.getBenchChampions().size()>9){

                    System.err.println("Your Bench is full, Please place some Champions to free some spaces in the Bench!!! ");
                    this.err=true;
                }

                break;

            }

            case (2):
            {

                System.out.println("Placing move must be running right now");




                boolean placeMove = false;

                if(p.getBenchChampions().size()==0){

                    System.err.println("You don't have any champion IN BENCH to place yet! you can buy some by pressing 1");
                }

                else{
                    System.out.println("Which champion do you want to place?");
                    ArrayList<Champion> championsToGetIndex = new ArrayList<Champion>();
                    championsToGetIndex = p.getBenchChampions();
                    System.out.println("Bench champions : " );
                    for (int l= 0 ; l <p.getBenchChampions().size() ; l++){
                        System.out.println(p.getBenchChampions().get(l) );
                        System.out.println();
                    }

//                    System.out.println("\n"+championsToGetIndex+"\n");
//                    System.out.println();
                    int indexOfChosenChampion;
                    indexOfChosenChampion = indexOfChosenChampionScanner.nextInt();
                    if(indexOfChosenChampion > championsToGetIndex.size()){
                        System.err.println("Please enter a right number ... from 1 ---> " + championsToGetIndex.size());
                        System.out.println("Bench champions : " );
                        for (int l= 0 ; l <p.getBenchChampions().size() ; l++){
                            System.out.println(p.getBenchChampions().get(l) );
                            System.out.println();
                        }
                        indexOfChosenChampion= indexOfChosenChampionScanner.nextInt();
                    }

                    int xCoor,yCoor;
                    System.out.println("Please write the coordinates you want to place your champion on: ");
                    System.out.print("X coordinate: ");
                    xCoor = xCoorScanner.nextInt();
                    System.out.println();
                    System.out.print("Y coordinate: ");
                    yCoor = yCoorScanner.nextInt();



                    PlaceMove move2  = new PlaceMove();

                   placeMove = move2.placeMove(xCoor,yCoor,p.getBenchChampions().get(indexOfChosenChampion-1),arena,indexOfPlayerToPrintItWithArena,p);
//                   System.out.println("she lazm estfed nno" + p.getBenchChampions().get(indexOfChosenChampion-1));
                   if(placeMove){


                       Champion championToDeleteFromBench = new Champion();
                       championToDeleteFromBench =  p.getBenchChampions().get(indexOfChosenChampion-1);
                       p.getBenchChampions().remove(championToDeleteFromBench);
                       p.setArenaChampions(championToDeleteFromBench);
                       System.out.println("player int placemove"+p.getPlayerIndex());
                       System.out.println("player as palyer"+p);
                       System.out.println("Arraylist as palyer"+indexOfPlayerToPrintItWithArena);
                       arena.printArena(p,indexOfPlayerToPrintItWithArena);

                   }



                    isRound = true;
                }
                break;
            }

            default:{
                System.out.println("Please enter a right number");
                isRound=false;

            }



        }

//        arena.printArena();
return isRound;
    }

    public     String  getChampionChoiceFromPhase2(int userChoice , Player player, Arena arena , ArrayList<Player> indexOfPlayerToPrintItWithArena){
        boolean isRound = false;
        String moveAsString =new String();


        switch (userChoice) {
            case (1): {
//                SellMove move1 = new SellMove();
                moveAsString = moveAsString+"S";

                System.out.println("Selling move must be running right now");

                break;
            }




            case (2): {
//                BuyMove move2 = new BuyMove();
                moveAsString = moveAsString+"T";

                ///ro7y jebeha mn hnek
                System.out.println("Buying move must be running right now");
                TemporalStoreFilter tempStore = new TemporalStoreFilter();

                ArrayList<Champion> addedChampions = new ArrayList<Champion>();
                BuyMove move1 = new BuyMove();

//                System.out.println(addedChampions);
                if(player.getBenchChampions().size()<=9) {
                    if(player.getBenchChampions().size()==9){
                        System.err.println("Your Bench is full, Please place some Champions to free some spaces in the Bench!!! ");
                        this.err=true;
                        break;
                    }
                    System.out.println("champions array size"+player.getBenchChampions().size());
                    addedChampions = move1.doBuying(5);
                    String planForBuying = new String();
                    planForBuying= "BuyChampions:  ";
                    for(int i1 =0 ; i1 <addedChampions.size(); i1++)
                    {
                        planForBuying = planForBuying + addedChampions.get(i1).toString()+"\n";
                    }
                    System.out.println(planForBuying);
                    plan.add(planForBuying);

                    player.getCurrentChampions().addAll(addedChampions);
                    player.getBenchChampions().addAll(addedChampions);



                }



                if(player.getBenchChampions().size()>9){

                    System.err.println("Your Bench is full, Please place some Champions to free some spaces in the Bench!!! ");
                    this.err=true;
                }

                break;




            }
            case (3): {

                moveAsString = moveAsString+"W";
                System.out.println("Please select the champion that you want to Move: ");
                System.out.println(player.getArenaChampions());
                int championToMove1;
                championToMove1 =championToMove.nextInt();
                System.out.println(championToMove1);
                String s =new String();
                s =player.getArenaChampions().get(championToMove1-1).championName.substring(0,3);

//                MoveFactory.creatMove(player.getArenaChampions().get(championToMove1),userChoice,arena,player,indexOfPlayerToPrintItWithArena);
                System.out.println("Walking move must be running right now");
                Scanner d = new Scanner(System.in);
                String id ;
                System.out.println("where did you want to move ? ");
                System.out.println(" 1-move up \n 2-move down \n 3-move left \n 4-move right");
                System.out.print("your choice :");
                id = d.next() ;

                moveAsString = moveAsString+s+id;
                System.out.println("move as string"+ moveAsString);

                break;
            }
            case (4): {

                moveAsString = moveAsString+"A";
                ArrayList<Champion> championGetsAttack = new ArrayList<Champion>();
                System.out.println("Please select the champion you want to attack with: ");
                System.out.println(player.getArenaChampions());
                int championToAttackWith;
                championToAttackWith =ChampionToAttackWith.nextInt();
                String championAsString = new String();
                championAsString= player.getArenaChampions().get(championToAttackWith-1).championName.substring(0,3);
                moveAsString = moveAsString+championAsString;
                System.out.println("The Champions on your Attack Range Are: ");

                BasicAttackMove move = new BasicAttackMove();
                championGetsAttack = move.attackAccepted(player.getArenaChampions().get(championToAttackWith-1),arena);
                System.out.println(championGetsAttack);
                System.out.println("Please choice a champion: ");
                int championToBeAttacked;
                championToBeAttacked =ChampionToBeAttacked.nextInt();
                String championAsString2 = new String();
                championAsString2 =championGetsAttack.get(championToBeAttacked-1).championName.substring(0,3);
                moveAsString = moveAsString+championAsString2;


                System.out.println(moveAsString);

                break;


            }
            case (5):
            {moveAsString = moveAsString+"B";
                System.out.println("Using Abilities move must be running right now");
                System.out.println("==========================================================");
                System.out.println("Please choose your champion : ");
                System.out.println("your champions list is : ");


               System.out.println(player.getArenaChampions());

                System.out.println("your choice is : ");
                int userChampionForUsingAbility= x1.nextInt();
                String useAbilityChampion = new String();
                useAbilityChampion =player.getArenaChampions().get(userChampionForUsingAbility-1).championName.substring(0,3);
                moveAsString = moveAsString+useAbilityChampion;
//                championsForPlan.add( player.getArenaChampions().get(userChampionForUsingAbility-1));

                break;




            }
            case (6):{
                moveAsString = moveAsString+"P";

                System.out.println("Placing move must be running right now");




                boolean placeMove = false;

                if(player.getBenchChampions().size()==0){

                    System.err.println("You don't have any champion IN BENCH to place yet! you can buy some by pressing 2");
                }

                else{
                    System.out.println("Which champion do you want to place?");
                    ArrayList<Champion> championsToGetIndex = new ArrayList<Champion>();
                    championsToGetIndex = player.getBenchChampions();
                    System.out.println("Bench champions : " );
                    for (int l= 0 ; l <player.getBenchChampions().size() ; l++){
                        System.out.println(player.getBenchChampions().get(l) );
                        System.out.println();
                    }

//                    System.out.println("\n"+championsToGetIndex+"\n");
//                    System.out.println();
                    int indexOfChosenChampion;
                    indexOfChosenChampion = indexOfChosenChampionScanner.nextInt();
                    if(indexOfChosenChampion > championsToGetIndex.size()){
                        System.err.println("Please enter a right number ... from 1 ---> " + championsToGetIndex.size());
                        System.out.println("Bench champions : " );
                        for (int l= 0 ; l <player.getBenchChampions().size() ; l++){
                            System.out.println(player.getBenchChampions().get(l) );
                            System.out.println();
                        }
                        indexOfChosenChampion= indexOfChosenChampionScanner.nextInt();
                    }

                    int xCoor,yCoor;
                    System.out.println("Please write the coordinates you want to place your champion on: ");
                    System.out.print("X coordinate: ");
                    xCoor = xCoorScanner.nextInt();
                    System.out.println();
                    System.out.print("Y coordinate: ");
                    yCoor = yCoorScanner.nextInt();



                    PlaceMove move2  = new PlaceMove();

                    placeMove = move2.placeMove(xCoor,yCoor,player.getBenchChampions().get(indexOfChosenChampion-1),arena,indexOfPlayerToPrintItWithArena,player);
//                   System.out.println("she lazm estfed nno" + p.getBenchChampions().get(indexOfChosenChampion-1));
                    if(placeMove){


                        Champion championToDeleteFromBench = new Champion();
                        championToDeleteFromBench =  player.getBenchChampions().get(indexOfChosenChampion-1);
                        player.getBenchChampions().remove(championToDeleteFromBench);
                        player.setArenaChampions(championToDeleteFromBench);
//                        System.out.println("player int placemove"+player.getPlayerIndex());
//                        System.out.println("player as palyer"+player);
//                        System.out.println("Arraylist as palyer"+indexOfPlayerToPrintItWithArena);
                        arena.printArena(player,indexOfPlayerToPrintItWithArena);

                    }



                    isRound = true;
                }
                break;
            }
            case (7):{
                moveAsString = moveAsString+"R";
                //swap
                System.out.println("swaaaaap");
                break;
            }
            default:
                System.out.println("Please enter a right number");



        }
return moveAsString;
    }




//    public static void main(String[] args) {
//        Planning p= new Planning();
////        p.printPlanningList();
////        p.planningMethod();
//
//    }


}
