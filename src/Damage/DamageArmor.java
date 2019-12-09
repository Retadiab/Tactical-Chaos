package Damage;
import Champion.*;
public class DamageArmor extends DamageDecorator {
    public DamageArmor(IDamage damage) {
        super(damage);
    }


// func deal with damage to champion's health with Armor
    public void Damaged(Champion champion , float much ){
        float AttackAfterShilding = champion.getArmor() * much ;
        this.damage.Damaged(champion, much - AttackAfterShilding  );

    }
}
