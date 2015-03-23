package main;

import java.util.Scanner;

import miniheros.hero.Classes;
import static miniheros.util.Help.*;
import static main.Textarena.*;

public class Intro {

    public static void play() {
        eingabe = new Scanner(System.in);

        // DEVMODE DEAKTIVIERT !!!!! entferne einfach die // von der next line um ihn zu aktivieren.
        // devmode();
        if (forcedevmode == 1) devmode();
        
        if (dev == 0) {

            intro("- > > > > >    Textarena v 0.105   < < < < < -", "-                    now recruiting Heros!                  -");
            p();
            p("Wie heißt Spieler 1?");
            String answer = eingabe.next();
            if (answer.equalsIgnoreCase("dev")) {
                devmode(1);
                return;
            } else {
                hhero1.setName(answer);
            }

            p("Wie heiÃŸt Spieler 2?");
            answer = eingabe.next();
            hhero2.setName(answer);

            // Who starts? Wer faengt an?
            if (skipmuenze == 0) {
                if (chance(50)) { // coinflip

                    String playertmp = hhero1.getName(); // changes spielernamen werden getauscht wenn spieler 2 anfangen soll
                    hhero1.setName(hhero2.getName());
                    hhero2.setName(playertmp);
                }
                p("Muenzwurf: " + hhero1.getpName() + "beginnt mit Heldenwahl!");
            }
        }
        warte(700);

        if (dev > 0) {
            hhero1.setName("Manuel");
            hhero2.setName("David");
            if (dev == 1) {
                hhero1.setClassS(Classes.MENSCH);
                hhero2.setClassS(Classes.DRACHE);
            }
        }
    }

    private static void devmode() {
        p("+++ DEV MODE +++");
        p("ZAHLEN:      0            -       1      -         2           -         3-9          -      10-unendlich ");
        p("MODUS::     normal   -   fixed    -  zufallsgame  -   speedgame   -   x games machen");
        p(" ");
        p("   ->     Geb eine Zahl ein! Wenn du keine Ahnung hast nimm 0!");
        dev = eingabe.nextInt();
    }

    private static void devmode(int i) {
        p("+++ DEV MODE +++");
        p("ZAHLEN:      0            -       1      -         2           -         3-9          -      10-unendlich ");
        p("MODUS::     normal   -   fixed    -  zufallsgame  -   speedgame   -   x games machen");
        p(" ");
        p("   ->     Geb eine Zahl ein! Wenn du keine Ahnung hast nimm 0!");
        dev = eingabe.nextInt();

        play();
    }
    public static int skipmuenze;
    public static int forcedevmode;
}
