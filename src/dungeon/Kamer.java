package dungeon;

import java.util.Arrays;

public class Kamer {
    String naam;
    int lengte;
    int breedte;
    Monster[] monsters;

    public Kamer(String naam, int lengte, int breedte, Monster[] monsters) {
        this.naam = naam;
        this.lengte = lengte;
        this.breedte = breedte;
        this.monsters = monsters;
    }

    public String getNaam() {
        return naam;
    }

    public int getLengte() {
        return lengte;
    }

    public int getBreedte() {
        return breedte;
    }

    public Monster[] getMonsters() {
        return monsters;
    }

    @Override
    public String toString() {
        return "De " + getNaam() + " is " + getLengte() + " meter lang en " + getBreedte() + " meter breedt\n" +
                "Hij heeft in totaal " + getMonsters().length + " monster(s)\n\n";
    }
}
