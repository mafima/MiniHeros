package miniheros.hero;

import static miniheros.util.Help.*;

import java.util.ArrayList;
import java.util.Arrays;

import static main.Game.*;
import main.Textarena;
import miniheros.util.Anzeigen;
import miniheros.util.RNG;

public class Herowahl extends Textarena{
	
	public static ArrayList<Classes> allehelden = new ArrayList<Classes>();
	
	public static void antwortDB(String a, Hero hhero) {

		//# NORMAL: MENSCH, KRIEGER, MAGIER, ELF, ORK, GNOM, ZWERG, ZOMBIE, DRACHE, EISDRACHE,
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
		}
		//# STRANGE: JESUS, GOTT, SATAN, HITLER, TEEKANNE, TOPF, COOL, PENIS, schwanz, muschi
		else if (a.equalsIgnoreCase("jesus")) {
			hhero.setClassS(Classes.JESUS);
		} else if (a.equalsIgnoreCase("gott")) {
			hhero.setClassS(Classes.GOTT);
		} else if (a.equalsIgnoreCase("satan")) {
			hhero.setClassS(Classes.SATAN);
		} else if (a.equalsIgnoreCase("hitler")) {
			hhero.setClassS(Classes.HITLER);
		} else if (a.equalsIgnoreCase("teekanne")) {
			hhero.setClassS(Classes.TEEKANNE);
		} else if (a.equalsIgnoreCase("teebeutel")) {
			hhero.setClassS(Classes.TEEBEUTEL);
		} else if (a.equalsIgnoreCase("topf")) {
			hhero.setClassS(Classes.TOPF);
		} else if (a.equalsIgnoreCase("coolman")) {
			hhero.setClassS(Classes.COOLMAN);
		}
			
			/*
		else if (a.equalsIgnoreCase("penis")) {
			hhero.setClassS(Classes.PENIS);
		} else if (a.equalsIgnoreCase("schwanz")) {
			hhero.setClassS(Classes.SCHWANZ);
		} else if (a.equalsIgnoreCase("muschi")) {
			hhero.setClassS(Classes.MUSCHI);
		}
		*/

		//# SPECIAL: NEINHEIT, JAHEIT, LEVIATHAN, ULTIMATEFORM,
		else if (a.equalsIgnoreCase("neinheit")) {
			red("Netter Versuch! :D Aber dazu sage ich NEIN!");
		} else if (a.equalsIgnoreCase("jaheit")) {
			red("Jaaa, Netter Versuch! :D Aber so einfach bekommst du die JAHEIT nicht!");
		} else if (a.equalsIgnoreCase("leviathan")) {
			hhero.setClassS(Classes.LEVIATHAN);
		} else if (a.equalsIgnoreCase("ultimateform")) {
			hhero.setClassS(Classes.ULTIMATEFORM);
		}

		//# MEDIA: SHELDON, PENNY, LENNARD, GOKU, SPIDERMAN, DARKSPIDERMAN, SPIDERPIG, CREEPER;
		else if (a.equalsIgnoreCase("sheldon")) {
			hhero.setClassS(Classes.SHELDON);
		} else if (a.equalsIgnoreCase("penny")) {
			hhero.setClassS(Classes.PENNY);
		} else if (a.equalsIgnoreCase("lennard")) {
			hhero.setClassS(Classes.LENNARD);
		} else if (a.equalsIgnoreCase("goku")) {
			hhero.setClassS(Classes.GOKU);
		} else if (a.equalsIgnoreCase("spiderman")) {
			hhero.setClassS(Classes.SPIDERMAN);
		} else if (a.equalsIgnoreCase("darkspiderman")) {
			hhero.setClassS(Classes.DARKSPIDERMAN);
		} else if (a.equalsIgnoreCase("spiderpig")) {
			hhero.setClassS(Classes.SPIDERPIG);
		} else if (a.equalsIgnoreCase("creeper")) {
			hhero.setClassS(Classes.CREEPER);
		}

		//+++++ RANDOM
		else if (a.equalsIgnoreCase("random") || a.equalsIgnoreCase("rng") || a.equalsIgnoreCase("topdeck") || a.equalsIgnoreCase("zufall") || a.equalsIgnoreCase("kp") || a.equalsIgnoreCase("gg")) {
			double heroes = 30;
			double P = 100/heroes;
			
			RNG.gen();
			if (RNG.chance(P)) hhero.setClassS(Classes.MENSCH);
			else if (RNG.chance(P)) hhero.setClassS(Classes.KRIEGER);
			else if (RNG.chance(P)) hhero.setClassS(Classes.MAGIER);
			else if (RNG.chance(P)) hhero.setClassS(Classes.ELF);
			else if (RNG.chance(P)) hhero.setClassS(Classes.ORK);
			else if (RNG.chance(P)) hhero.setClassS(Classes.GNOM);
			else if (RNG.chance(P)) hhero.setClassS(Classes.ZWERG);
			else if (RNG.chance(P)) hhero.setClassS(Classes.ZOMBIE);
			else if (RNG.chance(P)) hhero.setClassS(Classes.DRACHE);
			else if (RNG.chance(P)) hhero.setClassS(Classes.EISDRACHE);

			else if (RNG.chance(P)) hhero.setClassS(Classes.JESUS);
			else if (RNG.chance(P)) hhero.setClassS(Classes.GOTT);
			else if (RNG.chance(P)) hhero.setClassS(Classes.SATAN);
			else if (RNG.chance(P)) hhero.setClassS(Classes.HITLER);
			else if (RNG.chance(P)) hhero.setClassS(Classes.TEEKANNE);
			else if (RNG.chance(P)) hhero.setClassS(Classes.TEEBEUTEL);
			else if (RNG.chance(P)) hhero.setClassS(Classes.TOPF);
			else if (RNG.chance(P)) hhero.setClassS(Classes.COOLMAN);

			else if (RNG.chance(P)) hhero.setClassS(Classes.NEINHEIT);
			else if (RNG.chance(P)) hhero.setClassS(Classes.JAHEIT);
			else if (RNG.chance(P)) hhero.setClassS(Classes.LEVIATHAN);
			else if (RNG.chance(P)) hhero.setClassS(Classes.ULTIMATEFORM);

			else if (RNG.chance(P)) hhero.setClassS(Classes.SHELDON);
			else if (RNG.chance(P)) hhero.setClassS(Classes.PENNY);
			else if (RNG.chance(P)) hhero.setClassS(Classes.LENNARD);
			else if (RNG.chance(P)) hhero.setClassS(Classes.GOKU);
			else if (RNG.chance(P)) hhero.setClassS(Classes.SPIDERMAN);
			else if (RNG.chance(P)) hhero.setClassS(Classes.DARKSPIDERMAN);
			else if (RNG.chance(P)) hhero.setClassS(Classes.SPIDERPIG);
			else if (RNG.chance(P)) hhero.setClassS(Classes.CREEPER);
		}

		else if (a.equalsIgnoreCase("mensch")) {
			hhero.setClassS(Classes.MENSCH);
		} else if (a.equalsIgnoreCase("Illidan")) {
			p("Netter Versuch, aber Illidan kannst du nicht nehmen, er is zu stark fuer einen schwachen Wicht wie dich!");
		} else {
			p("Woah! Dieser Held war wohl zu exotisch! Ihn gibt es (noch) nicht. Versuch einen anderen!");
			TODOi++;
		}
	}
	
	public static void ausgabearray(ArrayList<Classes> array) {
		p();
		for (int i = 0; i < array.size()-1;i++)
		pnext(array.get(i).toString() + " ");
		p();
	}
	public static void setallehelden(Classes... Class) {
		Classes[] helden = Class;
		allehelden.addAll(Arrays.asList(helden));
	}

	public static void wahl(Hero held, int dev, long time) {
		if (showallheroes == 1) {
			setallehelden(Classes.MENSCH,Classes.LENNARD,Classes.KRIEGER,Classes.MAGIER,Classes.ELF,Classes.ORK,Classes.GNOM,Classes.ZWERG,Classes.ZOMBIE,Classes.DRACHE,Classes.EISDRACHE,Classes.JESUS,Classes.GOTT,Classes.SATAN,Classes.HITLER,Classes.TEEKANNE,Classes.TEEBEUTEL,Classes.TOPF,Classes.COOLMAN);
			p("Helden zur Auswahl: ");
			ausgabearray(allehelden);
			
		}

		String antwort = null;
		long t1 = System.currentTimeMillis(); // Zeit zaehlen beginnt

		if (dev <= 1) {
			while (held.getClassS()==null) { // wiederhole falls keine antwort UND kein held gesetzt!
				red(held.getpName() + "welcher Held willst du sein? Du hast noch "+Math.round(time-(System.currentTimeMillis()-t1))/1000+" sekunden");
				antwort = eingabe.next();

				ausnahmeabfrage(antwort,held); // JAHEIT UND NEINHEIT SPEZIALHELDEN

				if ((System.currentTimeMillis() - t1) > time) {  // falls zu lange gebraucht wird Held "mensch" genommen
					red((time/1000)+" Sekunden abgelaufen! Du bist jetzt ein Mensch!!!");
					warte(2000);
					antwort = "mensch";
				}
				// ANTWORT WIRD IN HELD FALLS HELD IN DB IST!
				if (held.getClassS() == null) antwortDB(antwort, held); // falls noch kein held, setze held
			}
		} else {
			if (held.getClassS()==null) {
			antwort = "zufall"; // falls devmode > 1 dann soll er einen ZUFALLSHELD nehmen und das unten skippen!
			antwortDB(antwort, held);
			}
		}
		
		held.addDefaultValues(held.getClassS()); // Wertezuweisung
		Anzeigen.stats(held); // Werteanzeige
	}

	private static void ausnahmeabfrage(String antwort, Hero held) {
		// Hero wird gelesen
		// AUSNAHMEHELDEN:
		if (antwort.equalsIgnoreCase("nein")) {
			p("Du hast Nein eingegeben. Bist du bescheuert?");
			antwort = eingabe.next();
			if (antwort.equalsIgnoreCase("ja")) {
				p("Sicher dass du bescheuert bist?");
				antwort = eingabe.next();
				if (antwort.equalsIgnoreCase("ja")) {
					p("Nimm deinen Held! Letzte Chance, sonst stirbst du!");
					antwort = eingabe.next();
					if (antwort.equalsIgnoreCase("nein")) {
						held.setClassS(Classes.NEINHEIT);
					} else {
						p("oke gut!");
						p("Welchen Held waehlt " + held.getpName() + "?");
					}
				} else {
					p("oke gut!");
					p("Welchen Held waehlt " + held.getpName() + "?");
				}
			} else {
				p("oke gut!");
				p("Welchen Held waehlt " + held.getpName() + "?");
			}
		} else if (antwort.equalsIgnoreCase("ja")) {
			p("Du hast JA eingegeben. Bist du bescheuert?");
			antwort = eingabe.next();
			if (antwort.equalsIgnoreCase("ja")) {
				p("Bist du denn noch bei Sinnen?!");
				antwort = eingabe.next();
				if (antwort.equalsIgnoreCase("nein")) {
					p("Nimm deinen Held! Letzte Chance, sonst stirbst du!");
					antwort = eingabe.next();
					if (antwort.equalsIgnoreCase("ja")) {
						held.setClassS(Classes.JAHEIT);
					} else {
						p("oke gut!");
						p("Welchen Held waehlt " + held.getpName() + "?");
					}
				} else {
					p("oke gut!");
					p("Welchen Held waehlt " + held.getpName() + "?");
				}
			} else {
				p("oke gut!");
				p("Welchen Held waehlt " + held.getpName() + "?");
			}

		}
	}

}
