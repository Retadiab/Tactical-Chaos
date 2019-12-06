package Damage;

public class Champion {
    private float Health = 100  ;
    private  float Mana = 100 ;
    private  float MagicR = (float) 0.10;
    private  float Armor = (float) 0.7;
    private float BasicAttack = 10 ;


    public float getHealth() {
        return Health;
    }

    public void setHealth(float health) {
        Health = health;
    }

    public float getMana() {
        return Mana;
    }

    public void setMana(float mana) {
        Mana = mana;
    }

    public float getMagicR() {
        return MagicR;
    }

    public void setMagicR(float magicR) {
        MagicR = magicR;
    }

    public float getArmor() {
        return Armor;
    }

    public void setArmor(float armor) {
        Armor = armor;
    }

    public void setBasicAttack(float basicAttack) {
        BasicAttack = basicAttack;
    }

    public float getBasicAttack() {
        return BasicAttack;
    }
}
