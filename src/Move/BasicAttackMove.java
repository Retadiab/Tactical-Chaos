package Move;
import Arena.*;
import Champion.* ;
import Damage.*;
import Player.Player;

import java.util.ArrayList;
import java.util.Random;

public class BasicAttackMove extends Move {
static Random r = new Random() ;





    public  ArrayList<Champion> attackAccepted(Champion Attacker , Arena arena, Player p){
        ArrayList<Champion> AttackableChampion = new ArrayList<Champion>();
//        int x = Attacker.x - (int)Attacker.AttackRange ;
//        int y = Attacker.y - (int) Attacker.AttackRange;





        ////zb6e l arena size
//         if((Attacker.x + Attacker.AttackRange ) < 13)
////         {
////        for(int i = Attacker.x ; i <= Attacker.x + Attacker.AttackRange ; i++ )
////            {
////                if (arena.getSquare(i , Attacker.y).getState() == SquaresState.Occupied){
////
////
////
////                            //                AttackableChampion.addAll(arena.getSquare(i, Attacker.y).getChampionsIn());
////                            for(Champion c : arena.getSquare(i, Attacker.y).getChampionsIn())
////                            {
////
////                                if(c.getPlayerId() == p.getPlayerIndex()){
////                                    break;
////                                }
////                                else {
////                                    AttackableChampion.add(c);
////                                }
////                            }
////                  }
////            }
////        }
////
////         else
////         {
////             for(int i1 = Attacker.x ; i1 <= 13 ; i1++ )
////             {
////                 for(Champion c : arena.getSquare(i1, Attacker.y).getChampionsIn()){
////
////                 if(c.getPlayerId() == p.getPlayerIndex()){
////
////                     break;
////
////                 }
////                 else {
////
////                     AttackableChampion.add(c);
////
////                 }
////             }
////         }
////
////         }
////
/////////zb6ehon mtl elle fo8
////
////        if (Attacker.y + Attacker.AttackRange < 54 ) {
////            for (int j = Attacker.y; j <= Attacker.y + Attacker.AttackRange; j++) {
////                if (arena.getSquare(Attacker.x, j).getState() == SquaresState.Occupied)
////                {
////
////                    for(Champion c : arena.getSquare(Attacker.x, j).getChampionsIn())
////                    {
////
////                        if(c.getPlayerId() == p.getPlayerIndex()){
////                            break;
////                        }
////                        else {
////                            AttackableChampion.add(c);
////                        }
////                    }
////
////                }
////            }
////        } else
////        {
////            for (int j = Attacker.y; j <= arena.getArenaSize(); j++) {
////                if (arena.getSquare(Attacker.x, j).getState() == SquaresState.Occupied){
////
////
////
////                    for(Champion c : arena.getSquare(Attacker.x, j).getChampionsIn()){
////
////                        if(c.getPlayerId() == p.getPlayerIndex()){
////
////                            break;
////
////                        }
////                        else {
////
////                            AttackableChampion.add(c);
////
////                        }
////                    }
////
////                }
////            }
////        }
////
////
////
////
////          if( Attacker.x - (int) Attacker.AttackRange > 0 )
////          {
////              for(int i =( Attacker.x - (int) Attacker.AttackRange ); i <= Attacker.x  ; i++ )
////              {
////                  if (arena.getSquare(i , Attacker.y).getState() == SquaresState.Occupied){
////
////
////                      for(Champion c : arena.getSquare(i , Attacker.y).getChampionsIn()){
////
////                          if(c.getPlayerId() == p.getPlayerIndex()){
////
////                              break;
////
////                          }
////                          else {
////
////                              AttackableChampion.add(c);
////
////                          }
////                      }
////                  }
////              }
////          }else
////          {
////              for(int i =0; i <= Attacker.x  ; i++ )
////              {
////                  if (arena.getSquare(i , Attacker.y).getState() == SquaresState.Occupied){
////
////                      for(Champion c : arena.getSquare(i , Attacker.y).getChampionsIn()){
////
////                          if(c.getPlayerId() == p.getPlayerIndex()){
////
////                              break;
////
////                          }
////                          else {
////
////                              AttackableChampion.add(c);
////
////                          }
////                      }
////
////
////                  }
////                      AttackableChampion.addAll(arena.getSquare(i, Attacker.y).getChampionsIn());
////              }
////          }
////
////
////
////        if (Attacker.y - (int)Attacker.AttackRange >0 ) {
////            for (int j = Attacker.y - (int) Attacker.AttackRange; j <= Attacker.y; j++) {
////                if (arena.getSquare(Attacker.x, j).getState() == SquaresState.Occupied){
////
////
////                    for(Champion c : arena.getSquare(Attacker.x, j).getChampionsIn()){
////
////                        if(c.getPlayerId() == p.getPlayerIndex()){
////
////                            break;
////
////                        }
////                        else {
////
////                            AttackableChampion.add(c);
////
////                        }
////                    }
////                }
////            }
////        }
////        else
////        {
////            for (int j =0; j <= Attacker.y; j++) {
////                if (arena.getSquare(Attacker.x, j).getState() == SquaresState.Occupied){
////
////
////                    for(Champion c : arena.getSquare(Attacker.x, j).getChampionsIn()){
////
////                        if(c.getPlayerId() == p.getPlayerIndex()){
////
////                            break;
////
////                        }
////                        else {
////
////                            AttackableChampion.add(c);
////
////                        }
////                    }
////
////                }
////            }
////        }





            int stX = Attacker.x - (int)Attacker.AttackRange;
            if(stX<0) stX = 0;
            if(stX > 14) stX = 14;

            int  stY = Attacker.y - (int)Attacker.AttackRange;
                    if(stY<0) stY = 0;
                    if(stY > 55) stY = 55;

        for (int i = stX; i < (int)Attacker.AttackRange*2 && i < 14; i++) {
            for (int j = stY; j<(int)Attacker.AttackRange*2 && j<55; j++) {
             //   if(square[stX][stY].state == state.ocuppied)
            }
        }


        return AttackableChampion ;
    }

    public boolean PerformMove(Champion Attacker , Champion Target ) {
        if(Target.getHealth() == 0 )
        {
            System.out.println("this Champion is dead ");
            return false;
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
            return true;

        }

    }








    public static int   getRandom(int h , int l)
    {
        return r.nextInt((h-l)+1)+l ;}
}
