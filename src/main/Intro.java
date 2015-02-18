package main;

import java.util.Scanner;

import miniheros.hero.Classes;
import miniheros.hero.Herowahl;
import static miniheros.util.Help.*;

public class Intro extends MiniHeros {
	public static void play(int skipmuenze) {
		p("+++ DEV MODE +++");
		p("ZAHLEN:      0            -       1      -         2           -         3-9          -      10-unendlich ");
		p("MODUS::     normal   -   fixed    -  zufallsgame  -   speedgame   -   x games machen");
		p(" ");
		p("   ->     Geb eine Zahl ein!");
		Scanner eingabe = new Scanner(System.in);
		dev = eingabe.nextInt();
		if (dev == 0) {
			/*
			 *                          .=========================.
			 *                          |                         |
			 *                          |         INTRO           |
			 *                          |                         |
			 *                          *=========================*
			 *
			 */
			intro("- > > > > >     MiniHeros v 0.15    < < < < < -","-                    now recruiting Heros!                  -");
			p();
			p("Wie heisst du?");
			String antwort = eingabe.next();
			getHhero1().setName(antwort);
			p("Wie heisst dein Gegner?");
			antwort = eingabe.next();
			getHhero2().setName(antwort);


			// Wer faengt an?
			if (skipmuenze == 0) {
				if (chance(50)) { // muenzwurf
					spielertmp = getHhero1().getName(); // spielernamen werden getauscht wenn spieler 2 anfangen soll
					getHhero1().setName(getHhero2().getName());
					getHhero2().setName(spielertmp);
				} p(prefix + "Eine Muenze wurde geworfen!" + getHhero1().getpName() + "beginnt!");
			}
		}

		if (dev > 0) {
			getHhero1().setName("Manuel");
			getHhero2().setName("David");
			if (dev == 1) {
				getHhero1().setClassS(Classes.MENSCH);
				getHhero2().setClassS(Classes.DRACHE);
			}
			if (dev > 1) {
				Herowahl.wahlrandom(getHhero1(), getHhero2());
			}
		}
	}
}
