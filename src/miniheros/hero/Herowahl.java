package miniheros.hero;

import java.util.Scanner;

import main.MiniHeros;
import miniheros.util.Anzeigen;
import miniheros.util.Help;

public class Herowahl extends MiniHeros{

	public static void antwortDB(String a, Hero hhero) {
		if (a.equalsIgnoreCase("mensch")) {
			hhero.setClassS(Classes.MENSCH);
		} else if (a.equalsIgnoreCase("krieger")) {
			hhero.setClassS(Classes.KRIEGER);
		} else if (a.equalsIgnoreCase("magier")) {
			hhero.setClassS(Classes.MAGIER);
		} else if (a.equalsIgnoreCase("elf")) {
			hhero.setClassS(Classes.ELF);
		} else if (a.equalsIgnoreCase("ork")) {
			hhero.setClassS(Classes.ORK);
		} else if (a.equalsIgnoreCase("gnom")) {
			hhero.setClassS(Classes.GNOM);
		} else if (a.equalsIgnoreCase("zwerg")) {
			hhero.setClassS(Classes.ZWERG);
		} else if (a.equalsIgnoreCase("zombie")) {
			hhero.setClassS(Classes.ZOMBIE);
		} else if (a.equalsIgnoreCase("drache")) {
			hhero.setClassS(Classes.DRACHE);
		} else if (a.equalsIgnoreCase("eisdrache")) {
			hhero.setClassS(Classes.EISDRACHE);
		} else if (a.equalsIgnoreCase("penny")) {
			hhero.setClassS(Classes.PENNY);
		} else if (a.equalsIgnoreCase("sheldon")) {
			hhero.setClassS(Classes.SHELDON);
		} else if (a.equalsIgnoreCase("hitler")) {
			hhero.setClassS(Classes.HITLER);
		} else if (a.equalsIgnoreCase("gott")) {
			hhero.setClassS(Classes.GOTT);
		} else if (a.equalsIgnoreCase("jesus")) {
			hhero.setClassS(Classes.JESUS);
		} else if (a.equalsIgnoreCase("mensch")) {
			hhero.setClassS(Classes.MENSCH);
		} else if (a.equalsIgnoreCase("Illidan")) {
			Help.p("Netter Versuch, aber Illidan kannst du nicht nehmen, er is zu maechtig.");
		} else {
			Help.p(prefix + "Dieser Held wird bald spielbar sein! Versuch einen anderen!");
			TODOi++;
		}
	}

	public static void wahl(Hero held, int dev, float time) {
		Scanner antworter = new Scanner(System.in);
		if (dev == 0) {
			Help.p(prefix + "Du hast " + time / 1000 + " Sekunden Zeit! Sei kreativ!");
		}

		long t1 = System.currentTimeMillis(); // Zeit zaehlen beginnt
		while (held.getClassS() == null) {
			Help.red(prefix + "Welcher Held willst du,  " + held.getName() + " sein?");
			String antwort = antworter.next();

			// Hero wird gelesen
			// AUSNAHMEHELDEN:
			if (antwort.equalsIgnoreCase("nein")) {
				Help.p(prefix + "Du hast Nein eingegeben. Bist du bescheuert?");
				antwort = antworter.next();
				if (antwort.equalsIgnoreCase("ja")) {
					Help.p(prefix + "Sicher dass du bescheuert bist?");
					antwort = antworter.next();
					if (antwort.equalsIgnoreCase("ja")) {
						Help.p(prefix + "Nimm deinen Held! Letzte Chance, sonst stirbst du!");
						antwort = antworter.next();
						if (antwort.equalsIgnoreCase("nein")) {
							held.setClassS(Classes.NEINHEIT);
						} else {
							Help.p(prefix + "oke gut!");
							Help.p(prefix + "Welchen Held waehlt " + held.getpName() + "?");
						}
					} else {
						Help.p(prefix + "oke gut!");
						Help.p(prefix + "Welchen Held waehlt " + held.getpName() + "?");
					}
				} else {
					Help.p(prefix + "oke gut!");
					Help.p(prefix + "Welchen Held waehlt " + held.getpName() + "?");
				}
			} else if (antwort.equalsIgnoreCase("ja")) {
				Help.p(prefix + "Du hast JA eingegeben. Bist du bescheuert?");
				antwort = antworter.next();
				if (antwort.equalsIgnoreCase("ja")) {
					Help.p(prefix + "Bist du denn noch bei Sinnen?!");
					antwort = antworter.next();
					if (antwort.equalsIgnoreCase("nein")) {
						Help.p(prefix + "Nimm deinen Held! Letzte Chance, sonst stirbst du!");
						antwort = antworter.next();
						if (antwort.equalsIgnoreCase("ja")) {
							held.setClassS(Classes.JAHEIT);
						} else {
							Help.p(prefix + "oke gut!");
							Help.p(prefix + "Welchen Held waehlt " + held.getpName() + "?");
						}
					} else {
						Help.p(prefix + "oke gut!");
						Help.p(prefix + "Welchen Held waehlt " + held.getpName() + "?");
					}
				} else {
					Help.p(prefix + "oke gut!");
					Help.p(prefix + "Welchen Held waehlt " + held.getpName() + "?");
				}
			}
			if ((System.currentTimeMillis() - t1) > time) {  // falls zu lange gebraucht wird Held "mensch" genommen
				Help.red(prefix + "Zeit abgelaufen! Du bist jetzt ein Mensch!!!");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				antwort = "mensch";
			}

			// ANTWORT WIRD IN HELD FALLS HELD IN DB IST!
			if (held.getClassS() == null) antwortDB(antwort, held);
		}
		held.addDefaultValues(held.getClassS()); // Wertezuweisung
		Anzeigen.werte(held); // Werteanzeige
	}

	public static void wahlrandom(Hero held1, Hero held2) {
		int zufall = (int) Math.ceil(Math.random() * 5);
		held1.setClassS(Classes.MENSCH);
		if (zufall == 2) {
			held1.setClassS(Classes.KRIEGER);
		} else if (zufall == 3) {
			held1.setClassS(Classes.MAGIER);
		} else if (zufall == 4) {
			held1.setClassS(Classes.ZOMBIE);
		} else if (zufall == 5) {
			held1.setClassS(Classes.DRACHE);
		}
		zufall = (int) Math.ceil(Math.random() * 5);
		held2.setClassS(Classes.MENSCH);
		if (zufall == 2) {
			held2.setClassS(Classes.KRIEGER);
		} else if (zufall == 3) {
			held2.setClassS(Classes.MAGIER);
		} else if (zufall == 4) {
			held2.setClassS(Classes.ZOMBIE);
		} else if (zufall == 5) {
			held2.setClassS(Classes.DRACHE);
		}
	}

}
