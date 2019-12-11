package Move;
import Champion.* ;
import Damage.*;

import java.util.Random;

public class BasicAttackMove extends Move {
static Random r = new Random() ;






    public void PerformMove(Champion Attacker , Champion Target ) {
        if(Target.getHealth() == 0 )
        {
            System.out.println("this Champion is dead ");
            return;
        }

        else
        {
            int c = getRandom(4,1 ) ;
            if( c==1 || c==2 || c==3 ){
            DamageCalculatorFactory.creatDamageCalculator(Target , 2 , Attacker.getBasicAttack());
            Attacker.setMana(Attacker.getMana() + 1 );}
            else if (c==4){
                DamageCalculatorFactory.creatDamageCalculator(Target , 2 , Attacker.getBasicAttack() * Attacker.CriticalDamage);
                Attacker.setMana(Attacker.getMana() + 1 );}

        }

    }








    public static int   getRandom(int h , int l)
    {
        return r.nextInt((h-l)+1)+l ;}
}
