package dungeon;

import java.util.Arrays;

public class Dungeon {
    Kamer[] kamers;
    Speler speler;

    public Dungeon(Kamer[] kamers, Speler speler) {
        this.kamers = kamers;
        this.speler = speler;
    }
    public void GoThroughDungeon() {
        for (Kamer kamer: getKamers()) { //loop door alle de kamers heen
            if (kamer.getMonsters().length == 0) { //check of er monsters in de kamer zijn
                System.out.println("De " + kamer.getNaam() + " doorgelopen\n\n");
            } else {
                if (kamer.getNaam().equals("Boss Room")) { //check of de boss room bereikt is
                    bossFight();
                } else {
                    for (Monster monster: kamer.getMonsters()) { //loop door alle monsters heen om ze te vechten
                        System.out.println("\n" + getSpeler().getNaam() + " vecht tegen een " + monster);
                        while (monster.getHp() > 0 || getSpeler().getHp() > 0) {
                            monster.Attacked(getSpeler().Attacking());
                            if (monster.getHp() <= 0) {
                                System.out.println(monster.getType() + " verslagen!\n");
                                break;
                            }
                            getSpeler().Attacked(monster.Attacking());
                            if (getSpeler().getHp() <= 0) {
                                System.out.println(getSpeler().getNaam() + " is dood\nDungeon niet gehaald!\n");
                                break;
                            }
                        }
                    }
                    System.out.println("De " + kamer.getNaam() + " doorgelopen\n");
                }
            }
        }
    }
    public void bossFight() {
        System.out.println("Boss Room bereikt!\n");
        Monster boss = getKamers()[getKamers().length-1].getMonsters()[0];
        while (boss.getHp() > 0 || getSpeler().getHp() > 0) {
            boss.Attacked(getSpeler().Attacking()); //Speler valt 2 keer de boss aan
            if (boss.getHp() > 0) {
                boss.Attacked(getSpeler().Attacking());
            } else {
                System.out.println("\nBoss is verslagen!\nDungeon gehaald!");
                break;
            }

            if (boss.getHp() > 0) {
                getSpeler().Attacked(boss.Attacking()); //boss valt 1 keer de speler aan
            } else {
                System.out.println("Boss is verslagen!\nDungeon gehaald!\n");
                break;
            }
            if (getSpeler().getHp() <= 0) {
                System.out.println("\n" + getSpeler().getNaam() + " is dood\nDungeon niet gehaald!");
                break;
            }
        }
    }
    public Kamer[] getKamers() {
        return kamers;
    }

    public Speler getSpeler() {
        return speler;
    }

    @Override
    public String toString() {
        return "Deze dungeon heeft " + getKamers().length + " kamers:\n\n" +
                Arrays.toString(getKamers()).replace(", ", "").replace("[","").replace("]", "");
    }

    public static void main(String[] args) {
        //Voorbeeld 1
        Speler speler1 = new Speler(100, "Timo");
        Monster[] noMonsters = new Monster[0];

        Zombie zombie1 = new Zombie(25, "Zombie");
        Zombie zombie2 = new Zombie(25, "Zombie");
        Skeleton skeleton1 = new Skeleton(20, "Skeleton");

        Monster[] monsters1 = new Monster[3];
        monsters1[0] = zombie1;
        monsters1[1] = skeleton1;
        monsters1[2] = zombie2;

        Boss boss1 = new Boss(80, "Boss");
        Monster[] boss = new Monster[1];
        boss[0] = boss1;

        Kamer[] kamers = new Kamer[3];
        Gang gang1 = new Gang("Gang", 10, 5, noMonsters);
        MonsterRoom monsterRoom1 = new MonsterRoom("Monster Room", 20, 20, monsters1);
        BossRoom bossRoom1 = new BossRoom("Boss Room", 10, 10, boss);

        kamers[0] = gang1;
        kamers[1] = monsterRoom1;
        kamers[2] = bossRoom1;

        Dungeon dungeon1 = new Dungeon(kamers, speler1);
        System.out.println(dungeon1);
        dungeon1.GoThroughDungeon();

        //Voorbeeld 2
        Speler speler2 = new Speler(100, "Bram");

        Zombie zombie3 = new Zombie(25, "Zombie");
        Skeleton skeleton2 = new Skeleton(20, "Skeleton");

        Monster[] monsters2 = new Monster[2];
        monsters2[0] = zombie3;
        monsters2[1] = skeleton2;

        Zombie zombie4 = new Zombie(25, "Zombie");
        Zombie zombie5 = new Zombie(25, "Zombie");
        Skeleton skeleton3 = new Skeleton(20, "Skeleton");
        Skeleton skeleton4 = new Skeleton(20, "Skeleton");

        Monster[] monsters3 = new Monster[4];
        monsters3[0] = zombie4;
        monsters3[1] = zombie5;
        monsters3[2] = skeleton3;
        monsters3[3] = skeleton4;

        Boss boss2 = new Boss(80, "Boss");
        Monster[] b = new Monster[1];
        b[0] = boss2;

        MonsterRoom monsterRoom2 = new MonsterRoom("Monster Room", 20, 20, monsters2);
        Gang gang2 = new Gang("Gang", 30, 5, noMonsters);
        MonsterRoom monsterRoom3 = new MonsterRoom("Monster Room", 20, 20, monsters3);
        BossRoom bossRoom2 = new BossRoom("Boss Room", 10, 10, b);

        Kamer[] kamers1 = new Kamer[5];
        kamers1[0] = gang1;
        kamers1[1] = monsterRoom2;
        kamers1[2] = gang2;
        kamers1[3] = monsterRoom3;
        kamers1[4] = bossRoom2;

        Dungeon dungeon2 = new Dungeon(kamers1, speler2);
        System.out.println(dungeon2);
        dungeon2.GoThroughDungeon();
    }
}
