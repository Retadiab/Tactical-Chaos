//package UnassignedClasses;
//
//public class Planning extends Round{
//    private int newField(){return 0;};
//    public void GetTemporalList(){};
//
//}
package UnassignedClasses;



import Arena.Arena;
import GameStore.TemporalStoreFilter;
import  Player.*;
import Champion.Champion;
import Move.*;
import Player.Player;

import java.util.Scanner;

public class Planning extends Round{

    static Scanner x =new Scanner(System.in);
    static Scanner x1 =new Scanner(System.in);
    static Scanner x2 =new Scanner(System.in);
    static Scanner indexOfChosenChampionScanner =new Scanner(System.in);
    static Scanner xCoorScanner = new Scanner(System.in);
    static Scanner yCoorScanner = new Scanner(System.in);

    private int newField(){return 0;};
    public void GetTemporalList(){};

    public int printPlanningListPhase1(){

        System.out.println("Welcome to Phase 1, please choose your movement: ");
        System.out.println("1- Buy champions.");
        System.out.println("2- Place your champions.");
        System.out.println("Your choice is: ");
        int userChoice= x.nextInt();
        return userChoice;
    }

    public int printPlanningListPhase2(){

        System.out.println("Welcome to phase 2, please choose your plan: ");

        System.out.println("1- Sell champions.");
        System.out.println("2- Buy champions.");
        System.out.println("3- Move a specific champion.");
        System.out.println("4- Attack a champion.");
        System.out.println("5- Use ability for specific champion.");
        System.out.println("Your choice is: ");


        int userChoice= x.nextInt();
        return userChoice;



    }
    public void getChampionChoiceFromPhase1(int userChoice , Player p, Arena arena){


        switch (userChoice) {

            case (1):
            {

                BuyMove move1 = new BuyMove();
                System.out.println("Buying move must be running right now");
                break;

            }

            case (2):
            {

                System.out.println("Placing move must be running right now");


                if(p.getCurrentChampions().size()==0){

                    System.out.println("You don't have any champion to place yet! you can buy some by pressing 1");
                }

                else{
                    System.out.println("Which champion do you want to place?");
                    System.out.println(p.getCurrentChampions());
                    int indexOfChosenChampion= indexOfChosenChampionScanner.nextInt();
                    int xCoor,yCoor;
                    System.out.println("Please write the coordinates you want to place your champion on: ");
                    System.out.print("X coordinate: \t");
                    xCoor = xCoorScanner.nextInt();

                    System.out.println();
                    System.out.print("Y coordinate: \t");
                    yCoor = yCoorScanner.nextInt();

                    PlaceMove move2  = new PlaceMove();
                   move2.placeMove(xCoor,yCoor,(p.getCurrentChampions().get(indexOfChosenChampion)),arena);

                }
                break;
            }

            default:
                System.out.println("Please enter a right number");



        }

    }



    public void getChampionChoiceFromPhase2(int userChoice ,Player player, Arena arena){


        switch (userChoice) {

            case (1): {
                SellMove move1 = new SellMove();
                System.out.println("Selling move must be running right now");

                break;
            }




            case (2): {
                BuyMove move2 = new BuyMove();
                System.out.println("Buying move must be running right now");
                TemporalStoreFilter tempStore = new TemporalStoreFilter();

                tempStore.doBuying(5);
                ///////the doBuying method returns an array of champions that needs to be added to bench list and the player's champion list
                //and then when the player do the place move the champion must be removed from the bench list and added to current champions on the battlefield



                break;


            }
            case (3): {


                WalkMove move3 = new WalkMove();
                System.out.println("Walking move must be running right now");

                break;


            }
            case (4): {

                BasicAttackMove move4 = new BasicAttackMove();
                System.out.println("BasicAttack move must be running right now");

                break;


            }
            case (5):
            {
                System.out.println("UsingAbilities move must be running right now");
                System.out.println("==========================================================");

                System.out.println("Please enter ID of one of your champions : ");
                System.out.println("your champion list is : ");

//                for(int i =0 ; i<currentChampions.size(); i++){
//                                    //get currentChampions from the player class
//                //consolePlayer.CurrentChampions
//                }
                System.out.println("your choice is : ");

                int userChampionFor= x1.nextInt();

                Champion championToUseAbility = new Champion();
                //championToUseAbility = consolePlayer.CurrentChampions.get(userChampionFor-1);

                ActivateFioraAbilityMove move6 = new ActivateFioraAbilityMove();



                break;




            }
            default:
                System.out.println("Please enter a right number");
                break;


        }

    }


//    public static void main(String[] args) {
//        Planning p= new Planning();
////        p.printPlanningList();
////        p.planningMethod();
//
//    }


}
