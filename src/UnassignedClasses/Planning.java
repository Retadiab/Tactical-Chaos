//package UnassignedClasses;
//
//public class Planning extends Round{
//    private int newField(){return 0;};
//    public void GetTemporalList(){};
//
//}
package UnassignedClasses;

import Champion.Champion;
import Move.*;

import java.util.Scanner;

public class Planning extends Round{

    static Scanner x =new Scanner(System.in);
    static Scanner x1 =new Scanner(System.in);
    static Scanner x2 =new Scanner(System.in);

    private int newField(){return 0;};
    public void GetTemporalList(){};

    public int printPlanningList(){

        System.out.println("welcome to planning phase please choose your movement ");
        System.out.println("1- Sell champions.");
        System.out.println("2- Buy champions.");
        System.out.println("3- move specific champion .");
        System.out.println("4- Attack a specific enemy champion by a specific champion .");
        System.out.println("5- Use ability for specific champion .");
        System.out.println("your choice is : ");


        int userChoice= x.nextInt();
        return userChoice;



    }


    public void getChampionChoice(int userChoice){


        switch (userChoice) {

            case (1):
                SellMove move1 = new SellMove();


            case (2):
                BuyMove move2 = new BuyMove();

            case (3):
                WalkMove move3 = new WalkMove();

            case (4):

                BasicAttackMove move4 = new BasicAttackMove();

            case (5):
            {


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








            }
            default:
                System.out.println("Please enter a right number");



        }

    }





    public static void main(String[] args) {
        Planning p= new Planning();
        p.printPlanningList();
//        p.planningMethod();

    }


}
