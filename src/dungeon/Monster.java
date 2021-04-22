package dungeon;
import java.util.Random;

public class Monster implements Attack{
    int hp;
    String type;
    Random rand = new Random();

    public Monster(int hp, String type) {
        this.hp = hp;
        this.type = type;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getType() {
        return type;
    }

    @Override
    public int Attacking() {
        int attack;
        if (getType().equals("Boss")) {
            attack = rand.nextInt(25) + 10;
        } else if (getType().equals("Skeleton")) {
            attack = rand.nextInt(8) + 5;
        } else {
            attack = rand.nextInt(5) + 5;
        }
        System.out.println(getType() + " doet " + attack + " damage");
        return attack;
    }

    @Override
    public void Attacked(int damage) {
        setHp(getHp()-damage);
        if (getHp() < 0) {
            setHp(0);
        }
        System.out.println(getType() + " houdt " + getHp() + " hp over\n");
    }

    @Override
    public String toString() {
        return getType() + "(" + getHp() + "hp)";
    }
}
