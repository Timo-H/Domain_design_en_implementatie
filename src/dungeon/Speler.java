package dungeon;
import java.util.Random;

public class Speler implements Attack{

    int hp;
    String naam;
    Random rand = new Random();

    public Speler(int hp, String naam) {
        this.hp = hp;
        this.naam = naam;
    }

    public int getHp() {
        return hp;
    }

    public String getNaam() {
        return naam;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean Dodge() { //speler heeft 10% kans om te dodgen
        int dodgeChance = 1;
        int dodge = rand.nextInt(11);
        return dodgeChance == dodge;
    }

    @Override
    public int Attacking() {
        int attack = rand.nextInt(11) + 10;
        System.out.println(getNaam() + " doet " + attack + " damage");
        return attack;
    }

    @Override
    public void Attacked(int damage) {
        if (Dodge()) {
            System.out.println("Player dodged");
        } else {
            setHp(getHp()-damage);
            if (getHp() < 0) {
                setHp(0);
            }
            System.out.println(getNaam() + " houdt " + getHp() + " hp over\n");
        }
    }

    @Override
    public String toString() {
        return "Speler{" +
                "hp=" + getHp() +
                ", naam='" + getNaam() + '\'' +
                '}';
    }
}
