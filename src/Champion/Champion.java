package Champion;


import Damage.DamageCalculator;
import Move.Move;

import java.util.ArrayList;

public class Champion {

    private ArrayList<Move> Moves = new ArrayList<Move>();
//    private Champion Class[];
    private ArrayList<DamageCalculator> damageCalculators = new ArrayList<DamageCalculator>();
//    public Champion c1 = new Champion();
//    public ArrayList<Champion> champions = new ArrayList<Champion>();
    private String championName;
    private String championClass1;
    private String championClass3;
    private String championClass2;

    private float health ;
    private float Armor ;
    //private float Mana ;
    private float MagicResist;
    private float  VisionRange;
    private float AttackRange;
    private float MovementSpeed;
    private float CriticalChance;
    private float CriticalDamage;
    private float AttackDamage;
    private float ManaStart;
    private float ManaCost;
    private int GoldCost;

    private String championAbility;
    private  int championId;
     public Champion(){

         this.GoldCost=0;
         this.health=0;
         this.Armor=0;
         this.MagicResist=0;
         this.VisionRange=0;
         this.AttackRange=0;
         this.MovementSpeed=0;
         this.CriticalChance=0;
         this.CriticalDamage=0;
         this.AttackDamage =0;
         this.ManaStart =0;
         this.ManaCost =0;
         this.championName = null;
         this.championClass1 = null;
         this.championClass2 = null;
         this.championClass3 = null;


     }
     public Champion(

                    String championName1,
                    String championClass1,
                    String championClass2,
                    String championClass3,
                    int GoldCost1,
                     float health1,
                     float Armor1,
                    float MagicResist1,
                     float VisionRange1,
                     float AttackRange1,
                     float AttackDamage1,
                     float MovementSpeed1,
                     float CriticalChance1,
                     float ManaStart1,
                     float ManaCost1,
                     float CriticalDamage1,
                    String championAbility1
                     ){



         this.championName =championName1;
         this.championClass1 = championClass1;
         this.championClass2 = championClass2;
         this.championClass3=championClass3;
         this.GoldCost=GoldCost1;
         this.health=health1;
         this.Armor=Armor1;
         this.MagicResist=MagicResist1;
         this.VisionRange=VisionRange1;
         this.AttackRange=AttackRange1;
         this.AttackDamage=AttackDamage1;
         this.MovementSpeed=MovementSpeed1;
         this.CriticalChance=CriticalChance1;
         this.CriticalDamage=CriticalDamage1;
         this.ManaStart =ManaStart1;
         this.ManaCost =ManaCost1;
         this.championAbility = championAbility1;

     }



//this constructor is for the player's champions list with Id For the ability
    public Champion(

            String championName1,
            String championClass1,
            String championClass2,
            String championClass3,
            int GoldCost1,
            float health1,
            float Armor1,
            float MagicResist1,
            float VisionRange1,
            float AttackRange1,
            float AttackDamage1,
            float MovementSpeed1,
            float CriticalChance1,
            float ManaStart1,
            float ManaCost1,
            float CriticalDamage1,
            String championAbility1,
            int championId1

    ){



        this.championName =championName1;
        this.championClass1 = championClass1;
        this.championClass2 = championClass2;
        this.championClass3=championClass3;
        this.GoldCost=GoldCost1;
        this.health=health1;
        this.Armor=Armor1;
        this.MagicResist=MagicResist1;
        this.VisionRange=VisionRange1;
        this.AttackRange=AttackRange1;
        this.AttackDamage=AttackDamage1;
        this.MovementSpeed=MovementSpeed1;
        this.CriticalChance=CriticalChance1;
        this.CriticalDamage=CriticalDamage1;
        this.ManaStart =ManaStart1;
        this.ManaCost =ManaCost1;
        this.championAbility = championAbility1;
        this.championId = championId1;

    }




    public void printChamp(Champion c){
         System.out.println(c.toString());
    }


//       class ChampionAttributes {
//
//    }

    public void AcceptDamage() {

    }

    public void GetIntendedDamage() {

    }


    public String toString() {
        return String.format("\t%s \t%s  \t%s  \t%s \t %d \t %f \t %f \t %f\t %f\t %f\t %f  \t %f\t %f\t %f \t %f \t %f \t %s",

                this.championName,
        this.championClass1,
        this.championClass2,
        this.championClass3,
        this.GoldCost,
        this.health,
        this.Armor,
        this.MagicResist,
        this.VisionRange,
        this.AttackRange,
        this.MovementSpeed,
        this.CriticalChance,
        this.CriticalDamage,
        this.AttackDamage ,
        this.ManaStart,
        this.ManaCost,
        this.championAbility);
    }

//    public static void main(String[] args) {
//        Champion c = new Champion();
//        c.toString();
//        System.out.println(c.toString());
//    }

}
