package main;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Scanner;

import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.SpellDB;
import miniheros.hero.Values;
import miniheros.util.*;
import miniheros.window.fenster;

/* - 1 gegen 1 Kampfspiel -
 *  Author = Manuel Fischer (Mafima)
 *  Helper = Ferdl, Ohnename, Cobra_8
 * 
 * HELDEN ERSTELLEN HIER:  http://derpy.me/held
 */

public class MiniHeros extends fenster {

	private static final long serialVersionUID = -4397649819156845507L; // unwichtig

	// Hero Objekte werden erstellt
	private static Hero hhero1;
	private static Hero hhero2;

	// Scanner laden fuer Eingabe
	// main methode
	public static void main(String[] args) throws IOException {
		// Fenster
		new fenster();

		// Erstellen der 2 Hero Objekte
		hhero1 = new Hero(0, 0, 0, 0, 0);
		hhero2 = new Hero(0, 0, 0, 0, 0);


		/* ============== *
		 * GAMECHANGE BOX *
		 * xxxxxxxxxxxxxx *
		 * ==============*/

		/*
		 *                          .=========================.
		 *                          |                         |
		 *                          |      GAMECHANGE BOX     |
		 *                          |                         |
		 *                          *=========================*
		 *
		 */
		int skipmuenze = 0; // Soll Muenzwurf uebersprungen werden? 0=nein 1=ja
		int quiz = 1;		// QUIZ aktiv = 1.    off= 0
		long timeout = 30000; // bestimme wie lang man zeit zum held nehmen hat!
		double heatset = 1.001; // setzt den anfangwerte
		Hero.life = 3; // Multipliziert das LEBEN, JEDEN Heldes um diesen Wert. Zu Testzwecken auf 3 gesetzt!

		
		help.p("+++ DEV MODE +++");
		help.p("ZAHLEN:      0            -       1      -         2           -         3-9          -      10-unendlich ");
		help.p("MODUS::     normal   -   fixed    -  zufallsgame  -   speedgame   -   x games machen");
		help.p(" ");
		help.p("   ->     Geb eine Zahl ein!");
		Scanner eingabe = new Scanner(System.in);
		int dev = eingabe.nextInt();
		if (dev == 0) {
			/*
			 *                          .=========================.
			 *                          |                         |
			 *                          |         INTRO           |
			 *                          |                         |
			 *                          *=========================*
			 *
			 */
			help.intro("- > > > > >     MiniHeros v 0.15    < < < < < -","-                    now recruiting Heros!                  -");
			help.p(" ");
			help.p(prefix + "Wie heisst du?");
			String antwort = eingabe.next();
			hhero1.setName(antwort);
			help.p(prefix + "Wie heisst dein Gegner?");
			antwort = eingabe.next();
			hhero2.setName(antwort);


			// Wer faengt an?
			if (skipmuenze == 0) {
				if (help.chance(50)) { // muenzwurf
					spielertmp = hhero1.getName(); // spielernamen werden getauscht wenn spieler 2 anfangen soll
					hhero1.setName(hhero2.getName());
					hhero2.setName(spielertmp);
				}
				help.p(prefix + "Eine Muenze wurde geworfen!" + hhero1.getpName() + "faengt an!");
			}
		}

		if (dev > 0) {
			hhero1.setName("Manuel");
			hhero2.setName("David");
			if (dev == 1) {
				hhero1.setClassS(Classes.MENSCH);
				hhero2.setClassS(Classes.ZOMBIE);
			}
			if (dev > 1) {
				herowahlrandom(hhero1, hhero2);
			}
		}

		int win1 = 0;
		int win2 = 0;
		for (int i = 0; i <= dev; i++) {
			MiniHeros.heat = heatset;

			/*
			 *                          .=========================.
			 *                          |                         |
			 *                          |   Spieler   Heldenwahl  |
			 *                          |                         |
			 *                          *=========================*
			 *
			 */

			herowahl(hhero1, dev, timeout);
			herowahl(hhero2, dev, timeout);

			// HEROS GEWAEHLT. 
			if (dev == 0) {
				help.p(prefix + "=====================================");
				help.p(prefix + "Bereit?");
				String antwort = eingabe.next();
				if (antwort.equalsIgnoreCase("nein")) {
					help.p("NAGUT!!! Ich frage in 3 Sekunden nochmal ! :D");
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

			// WER FAENGT AN?
			if (quiz>0 && dev < 2) { // falls quiz an ist, wird quiz gemacht!
				if(Quiz.quiz()) {
					kampf = 1;
				} else kampf = 2;
			} else {
				kampf = 1;
				help.p(hhero1.getpName()+" darf den ersten Angriff machen!");
				if (help.chance(50)) {
					kampf = 2; // Zufall wer Kampf beginnt!
					help.p(hhero2.getpName()+" darf den ersten Angriff machen!");
				}
			}
			
			help.p(prefix2,2);
			help.p(prefix + "DER KAMPF BEGINNT!");
			help.p(prefix2,2);
			/////////////// KAMPF /////////////////////////////////////////////////////////////////
			///////////////////////////////////////////////////////////////////////////////////////
			///////////////////////////////////////////////////////////////////////////////////////
			
			while (hhero1.getL() > 0 && hhero2.getL() > 0) {
				if (kampf == 1) {
					kampf(hhero1, hhero2, dev);
				}
				if (kampf == 2) {
					kampf(hhero2, hhero1, dev);
				}
			}

			// END ><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><
			// ><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><
			help.p(prefix1);
			help.p(prefix2);
			help.p(prefix3);
			if (hhero2.getL() <= 0) {
				help.red(prefix + hhero1.getpName() + hhero1.getpClass() + "hat gewonnen!!!");
				changePOWERLEVEL(hhero1, hhero2);
				if (dev > 9) {
					win1++;
				}
			} else {
				help.red(prefix + hhero2.getpName() + hhero2.getpClass() + "hat gewonnen!!!");
				changePOWERLEVEL(hhero2, hhero1);
				if (dev > 9) {
					win2++;
				}
			}
			help.red(prefix + "********************||| E N D E |||**********************");

			// wiederholen? falls dev > 9 ist wiederholt er das game so oft wie dev gross ist.
			if (dev < 10) {
				i = dev + 1;
			}
		}
		if (dev >= 10) {
		help.red("FULLEND");
		help.red("FULLEND");
		help.red("FULLEND");
		help.red(prefix + hhero1.getpName() + hhero1.getpClass() + "hat " + win1 + " von " + dev + " Spiele gewonnen!!!");
		help.red(prefix + hhero2.getpName() + hhero2.getpClass() + "hat " + win2 + " von " + dev + " Spiele gewonnen!!!");
	}}

	public static void anzleben(double anzlebvor, double anzleb, Hero hero) {
		for (double i = anzlebvor; i > anzleb && i > 0; i = i - (10 + (anzlebvor - anzleb) / 10)) {
			if (i < (anzlebvor - anzleb) / (10 + (anzlebvor - anzleb) / 10)) {
				help.p(prefix + "+KAMPF+" + hero.getpName() + "[ " + hero.getClassS() + " ] " + Math.ceil(anzleb) + " Leben :");
			} else {
				help.print(prefix + " KAMPF -(=>" + hero.getpName() + "[" + hero.getClassS() + "] " + Math.ceil(i) + " Leben :");
			}
			help.print("###");
			for (double i4 = 0; i4 < i; i4 = i4 + 50) {
				help.print("-=");
			}
			help.print("#");
			help.p("||");
		}
	}

	public static void itembox(Hero hero, Hero gegner) throws IOException {
		Scanner eingabe = new Scanner(System.in);
		String Antwort = null;

		if (help.chance(1)) {
			help.p(prefix + "### /37283/$%4684564/$7$584385//68347#74745// ###");
			help.p(prefix + "###   Schwarze Box des Untergangs gefunden!   ###");
			help.p(prefix + "### /37283/$%4684564/$7$584385//68347#74745// ###");
			help.p(prefix + "###                       ###");
			help.p(prefix + "### was willst du machen? ###");
			help.p(prefix + "###      1. Verkaufen     ###");
			help.p(prefix + "###       2. Oeffnen       ###");
			help.p(prefix + "###        3. Essen       ###");
			Antwort = eingabe.next();
			if (Antwort.equalsIgnoreCase("Verkaufen") || Antwort.equals("1")) {
				help.p(prefix + "###        Schwarze Box verkauft!       ###");
				help.p(prefix + "OH MEIN GOTT! Der Haendler ist bei Beruehrung mit der Box gestorben!");
				help.p(prefix + "Willst du sein Haus ausrauben?");
				Antwort = eingabe.next();
				if (Antwort.equalsIgnoreCase("ja")) {
					help.p(prefix + "### Du herzloser Wicht! ###");
					help.p(prefix + "Ein Priester hat dich entdeckt! 50 Schaden durch Herzlosigkeit!");
					hero.kampf(-50);
					help.p(prefix + "Elfische Streitaxt gefunden! Angriff um 70 erhöht!");
					hero.setA(hero.getA() + 70);
				} else if (Antwort.equalsIgnoreCase("nein")) {
					help.p(prefix + "### Mitgefuehlbonus! ###");
					help.p(prefix + "Ein Prister erkennt dein Mitgefuehl und heilt dich um 400 Leben !");
					hero.kampf(400);
				} else {
					help.p(prefix + "Du hast versagt ja oder nein einzugeben.");
					help.p(prefix + "Dummheitsbonus! 50 Schaden!");
					hero.kampf(-50);
				}
			} else if (Antwort.equalsIgnoreCase("oeffnen") || Antwort.equals("2")) {
				int x = (int) Math.random() * 3 + 1;
				if (x == 1) {
					hero.setL(hero.getL() + hero.getM());
					hero.setA(hero.getA() + hero.getM());
					hero.setM(0);
					help.p(prefix + "Schwarze Box entzieht dir all deine Magie und wandelt sie in Angriff und Leben um!");
				} else if (x == 2) {
					hero.setA(hero.getA() * 0.8);
					hero.setG(hero.getG() * 0.8);
					hero.kampf(-200);
					gegner.kampf(-200);
					help.p(prefix + "3$)294 Schwarze Box explodiert! 3)324=");
					help.p(prefix + "Die Explosion fuegt beiden Helden 200 Schaden zu! Ausserdem senkt sich dein Angriff und Geschick um 20%");
				} else {
					hero.setM(666 + hero.getM());
					hero.kampf(200);
					help.p(prefix + "In der schwarzen Box findest du einen winzigen Magier");
					help.p(prefix + "Er heilt dich um 200 und kaempft nun fuer dich! Magie steigt auf: " + hero.getM());
				}
			} else if (Antwort.equalsIgnoreCase("essen") || Antwort.equals("3")) {
				help.p(prefix + "Du isst die dunkle Box mit Messer und Gabel. Es schmeckt hart und nach dunkler Magie.");

				if (help.chance(20)) {
					hero.setClassS(Classes.ULTIMATEFORM);
					hero.addDefaultValues(Classes.ULTIMATEFORM);
					help.red(prefix + "/// RIESIGE EXPLOSION! ///");
					help.red(prefix + "Du wirst zu Illidan, dem Herrscher der Finsterniss!");
					werteanz(hero);
				} else {
					hero.setL(hero.getL() * 0.8);
					help.p(prefix + "Verwandlung fehlgeschlagen. Du verlierst 20% deines Lebens!");
				}
			} else {
				hero.kampf(-50);
				help.p(prefix + "50 Schaden durch Dummheit");
			}
		}
		else if (help.chance(1)) {
			help.p(prefix + "### ********************* ###");
			help.p(prefix + "### ********************* ###");
			help.p(prefix + "###   Diamant gefunden!   ###");
			help.p(prefix + "### ********************* ###");
			help.p(prefix + "### ********************* ###");
			help.p(prefix + "###                       ###");
			help.p(prefix + "### was willst du machen? ###");
			help.p(prefix + "###      1. Verkaufen     ###");
			help.p(prefix + "###       2. Werfen       ###");
			help.p(prefix + "###        3. Essen       ###");
			Antwort = eingabe.next();
			if (Antwort.equalsIgnoreCase("Verkaufen") || Antwort.equals("1")) {
				hero.setA(hero.getA() * 2);
				hero.setL(hero.getL() + 1500);
				hero.setG(hero.getG() * 0.75);
				help.p(prefix + "# Diamant verkauft und davon Waffen und Ruestung gekauft! Die Ruestung ist schwer.");
				help.p(prefix + "Angriff: " + hero.getA());
				help.p(prefix + "Geschick: " + hero.getG());
				help.p(prefix + "Leben: " + hero.getL());
			} else if (Antwort.equalsIgnoreCase("Werfen") || Antwort.equals("2")) {
				help.p("/***/ Diamantwurf /***/");
				help.p("Dein Held holt aus und wirft mit aller Kraft!!!");
				help.punkte();
				help.p("Der Diamant fliegt mit so hoher Geschwindigkeit, dass er die Schallmauer durchbricht und deinen Gegner betaeubt!!");
				gegner.reG(0.7);
				gegner.reA(0.7);
				if (help.chance(100 * hero.getG() / (hero.getG() + 50))) {
					help.red("=== kritischer TREFFER! ===");
					help.p("Diamant trifft Auge des Gegners! 800 Schaden!!!");
					gegner.reG(0.7);
					gegner.reA(0.7);
					gegner.kampf(-800);
				} else {
					help.p("* FAIL * Diamant geht daneben!");
					gegner.reA(1.2);
				}
			} else if (Antwort.equalsIgnoreCase("Essen") || Antwort.equals("3")) {
				help.punkte(5, 1300);
				if (help.chance(70)) {
					hero.kampf(-400);
					help.p(prefix + "# Deine Gabel zerbricht. Du wirfst den Diamant in deinen Mund und schluckst. " + hero.getpName() + " verliert 400 Leben.");
				} else {
					int heilung = (int) ((int) 6 * heat);
					heilung *= 100;
					hero.kampf(+heilung);
					help.p(prefix + "# Der Diamant war schmackhaft! Sehr Knusprig." + hero.getpName() + "hat nun " + heilung + " Leben mehr!");
					hero.reM(1.5);
				}
			} else {
				help.p("FAIL");
			}
		} else if (help.chance(5)) {
			help.p(prefix + "### ********************* ###");
			help.p(prefix + "### ********************* ###");
			help.p(prefix + "###    Banane gefunden!   ###");
			help.p(prefix + "### ********************* ###");
			help.p(prefix + "### ********************* ###");
			help.p(prefix + "###                       ###");
			help.p(prefix + "### was willst du machen? ###");
			help.p(prefix + "###      1. Verkaufen     ###");
			help.p(prefix + "###       2. Werfen       ###");
			help.p(prefix + "###        3. Essen       ###");
			Antwort = eingabe.next();
			if (Antwort.equalsIgnoreCase("Verkaufen") || Antwort.equals("1")) {
				if (help.chance(80)) {
					hero.setA(hero.getA() * 3);
					hero.setL(hero.getL() + 2500);
					hero.setG(hero.getG() * 0.65);
					help.p(prefix + "# Die Banane ist mit purem Gold gefuellt!");
					help.p(prefix + "Angriff: " + hero.getA());
					help.p(prefix + "Geschick: " + hero.getG());
					help.p(prefix + "Leben: " + hero.getL());
				} else {
					help.p(prefix + "# Du willst dem Verkaufer gerade die Banane reichen, da kommt ein Affe und klaut sie dir!");
				}

			} else if (Antwort.equalsIgnoreCase("Werfen") || Antwort.equals("2")) {
				help.p("/***/ Diamantwurf /***/");
				help.p("Dein Held holt aus und wirft mit aller Kraft!!!");
				help.punkte();
				help.p("Der Diamant fliegt mit so hoher Geschwindigkeit, dass er die Schallmauer durchbricht und deinen Gegner betaeubt!!");
				gegner.reG(0.7);
				gegner.reA(0.7);
				if (help.chance(100 * hero.getG() / (hero.getG() + 50))) {
					help.red("=== kritischer TREFFER! ===");
					help.p("Diamant trifft Auge des Gegners! 800 Schaden!!!");
					gegner.reG(0.7);
					gegner.reA(0.7);
					gegner.kampf(-800);
				} else {
					help.p("* FAIL * Diamant geht daneben!");
					gegner.reA(1.2);
				}
			} else if (Antwort.equalsIgnoreCase("Essen") || Antwort.equals("3")) {
				help.punkte(5, 1300);
				if (help.chance(70)) {
					hero.kampf(-400);
					help.p(prefix + "# Deine Gabel zerbricht. Du wirfst den Diamant in deinen Mund und schluckst. " + hero.getpName() + " verliert 400 Leben.");
				} else {
					int heilung = (int) ((int) 6 * heat);
					heilung *= 100;
					hero.kampf(+heilung);
					help.p(prefix + "# Der Diamant war schmackhaft! Sehr Knusprig." + hero.getpName() + "hat nun " + heilung + " Leben mehr!");
					hero.reM(1.5);
				}
			} else {
				help.p("FAIL");
			}
		}
	}

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
			help.p("Netter Versuch, aber Illidan kannst du nicht nehmen, er is zu maechtig.");
		} else {
			help.p(prefix + "Dieser Held wird bald spielbar sein! Versuch einen anderen!");
			TODOi++;
		}
	}

	public static void herowahl(Hero held, int dev, float time) {
		Scanner antworter = new Scanner(System.in);
		if (dev == 0) {
			help.p(prefix + "Du hast " + time / 1000 + " Sekunden Zeit! Sei kreativ!");
		}

		long t1 = System.currentTimeMillis(); // Zeit zaehlen beginnt
		while (held.getClassS() == null) {
			help.red(prefix + "Welcher Held willst du,  " + held.getName() + " sein?");
			String antwort = antworter.next();

			// Hero wird gelesen
			// AUSNAHMEHELDEN:
			if (antwort.equalsIgnoreCase("nein")) {
				help.p(prefix + "Du hast Nein eingegeben. Bist du bescheuert?");
				antwort = antworter.next();
				if (antwort.equalsIgnoreCase("ja")) {
					help.p(prefix + "Sicher dass du bescheuert bist?");
					antwort = antworter.next();
					if (antwort.equalsIgnoreCase("ja")) {
						help.p(prefix + "Nimm deinen Held! Letzte Chance, sonst stirbst du!");
						antwort = antworter.next();
						if (antwort.equalsIgnoreCase("nein")) {
							held.setClassS(Classes.NEINHEIT);
						} else {
							help.p(prefix + "oke gut!");
							help.p(prefix + "Welchen Held waehlt " + held.getpName() + "?");
						}
					} else {
						help.p(prefix + "oke gut!");
						help.p(prefix + "Welchen Held waehlt " + held.getpName() + "?");
					}
				} else {
					help.p(prefix + "oke gut!");
					help.p(prefix + "Welchen Held waehlt " + held.getpName() + "?");
				}
			} else if (antwort.equalsIgnoreCase("ja")) {
				help.p(prefix + "Du hast JA eingegeben. Bist du bescheuert?");
				antwort = antworter.next();
				if (antwort.equalsIgnoreCase("ja")) {
					help.p(prefix + "Bist du denn noch bei Sinnen?!");
					antwort = antworter.next();
					if (antwort.equalsIgnoreCase("nein")) {
						help.p(prefix + "Nimm deinen Held! Letzte Chance, sonst stirbst du!");
						antwort = antworter.next();
						if (antwort.equalsIgnoreCase("ja")) {
							held.setClassS(Classes.JAHEIT);
						} else {
							help.p(prefix + "oke gut!");
							help.p(prefix + "Welchen Held waehlt " + held.getpName() + "?");
						}
					} else {
						help.p(prefix + "oke gut!");
						help.p(prefix + "Welchen Held waehlt " + held.getpName() + "?");
					}
				} else {
					help.p(prefix + "oke gut!");
					help.p(prefix + "Welchen Held waehlt " + held.getpName() + "?");
				}
			}
			if ((System.currentTimeMillis() - t1) > time) {  // falls zu lange gebraucht wird Held "mensch" genommen
				help.red(prefix + "Zeit abgelaufen! Du bist jetzt ein Mensch!!!");
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
		werteanz(held); // Werteanzeige
	}

	public static void herowahlrandom(Hero held1, Hero held2) {
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

	public static void kampf(Hero held, Hero gegner, int d) throws IOException {
		help.p("=====================================");
		if (d == 0) {
			itembox(gegner, held);
		}
		int inputspell = checkspell(held, gegner, d);
		held.setdmg(dmg(inputspell, held, MiniHeros.heat, gegner));
		help.red(prefix + held.getpName() + held.getpClass() + " Schaden : " + held.getdmg());

		// LEBENSANZEIGE
		double hlebenvorher = gegner.getL(); // zwischenspeicher fuer lebensanzeige
		gegner.setL(gegner.getL() - held.getdmg());
		anzleben(hlebenvorher, gegner.getL(), gegner);

		if (kampf == 2) {
			kampf--;
		} else {
			kampf++;
		}
		if (gegner.getL() <= 0 || held.getL() <= 0) {
			MiniHeros.kampf = 0;
		}
	}

	private static int checkspell(Hero held, Hero gegner, int d) throws IOException {
		Scanner eingabe = new Scanner(System.in);
		int inputspell=-1;

		if (d > 1) {
			help.p("HEAT:" + heat);
			inputspell = (int) Math.ceil(Math.random() * held.getSpellSize());
			if (d < 10) {
				try {
					Thread.sleep(2000 / d);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return inputspell;
		} else {
			while (inputspell == -1) {
				help.p();
				help.print(prefix + held.getpName() + " Welchen Angriff? 1-" + held.getSpellSize());
				for (int i = 1; i < held.getSpellSize() + 1; i++) {
					help.print("  > " + i + ": " + held.getspell(i).toString());
				}
				help.p("");
				inputspell = eingabe.nextInt();

				if (inputspell <= 0 || inputspell > held.getSpellSize()) {
					help.red(prefix + " Der Held von " + held.getpName() + " ist beleidigt! Held: Kannst du nicht mal ne Zahl von 1-" + held.getSpellSize() + " druecken ?!");
				}
			}
			/*
             COOLDOWN VERSUCH....
             help.p(held.realcooldowns[inputspell-1]); // DEBUG
             if (held.realcooldowns[inputspell-1] > 0) {
             r(prefix + " Der Held von "+held.getpName()+" muss sich erst "+held.realcooldowns[inputspell-1]+" Zuege ausruhen! Nimm nen anderen Zauber!");
             help.p("");
             return checkspell(held,gegner,d);}
			 */
			return inputspell;
		}

	}

	public static int dmg(int i, Hero h, double heat, Hero g) {
		Scanner eingabe = new Scanner(System.in);

		if (heat > 2) {
			MiniHeros.heat = heat + 0.1; // Jede Runde erh�ht sich der Schaden um 5%
		} else {
			MiniHeros.heat = heat * heat;
		}
		/*COOLDOWN VERSUCH...          for (int y=1;y<(h.getSpellSize());y++) if (h.realcooldowns[y-1]>0) h.realcooldowns[y-1] = h.realcooldowns[y-1]-1;
         h.realcooldowns[i] = h.getcooldown(i);      */
		return (int) Math.ceil(g.getres() * (heat) * (SpellDB.spell(h, g, h.getspell(i))));

		/*      SPECIALSAVE
		 *
		 *              if (hhirn > h2hirn*1.10) {
         double hirnevent = (double) (hhirn - h2hirn)*Math.random();
         if (hirnevent > 300) {
         double hdmgh = Math.ceil((hhirn - h2hirn)*0.05 + 2)*100;
         hdmg = hdmg + hdmgh;
         h2hirn=h2hirn*0.9;
         help.p(prefix + hhero1.getpName() + hero1+ "zaehlt alle Stellen von Pi auf! "+ Math.ceil((hhirn - h2hirn)*0.2 + 400)+" Schaden!");
         help.p(prefix + "90% der Gehirnzellen wurden gebraten!");
         } else if (hirnevent > 99) {
         double hdmgh = (hhirn - h2hirn)*0.2 + 20;
         hdmg = hdmg + hdmgh; help.p(prefix + hhero1.getpName() + Math.ceil((hhirn - h2hirn)*0.2 + 70) +" Schaden durch Matheunterricht!");
         } else if (hirnevent > 30) {
         double hdmgh = (hhirn - h2hirn)*0.2 + 20; hdmg = hdmg + hdmgh ;
         help.p(prefix + hhero1.getpName() + Math.ceil(hdmgh) +" Schaden durch Überheblichkeit verursacht!");
         }
         }

         double critevent = (double) (hgeschick)*Math.random();
         if (critevent > 200) {
         hdmg = hdmg*3; help.p(prefix + hhero1.getpName() + Math.ceil(hdmg*2) + " ");
         } else if (critevent > 99) {
         hdmg = hdmg + (hhirn - h2hirn)*0.2 + 60; help.p(prefix + hhero1.getpName() + Math.ceil((hhirn - h2hirn)*0.2 + 70) +" Schaden durch Matheunterricht!");
         } else if (critevent > 30) {
         hdmg = hdmg + (hhirn - h2hirn)*0.2 + 20; help.p(prefix + hhero1.getpName() + Math.ceil((hhirn - h2hirn)*0.2 + 20) +" Schaden durch Überheblichkeit verursacht!");
         }

         double ausweichevent = (double) (h2geschick)*Math.random();
         if (ausweichevent > 100 ) {
         hdmg = hdmg*((hgeschick)*0.2) -20; help.p(prefix + hhero1.getpName() + Math.ceil((hhirn - h2hirn)*0.2 + 400)+" Schaden durch praezisen Steinwurf auf Dummkopf!");
         } else if (ausweichevent > 99) {
         hdmg = hdmg*(0.7*(hgeschick)); help.p(prefix + hhero1.getpName() + Math.ceil((hhirn - h2hirn)*0.2 + 20) +" Schaden durch Überheblichkeit verursacht!");
         }


         double critchance = 0.1 + (Math.pow((hgeschick/400),2) + Math.pow((hhirn/400),2))*0.9;
         double chance = 0.7 - (0.3*Math.pow((hgeschick/100),2)) ;

         double fail = (double) (Math.random() * (1 - chance));
         double mittel = (double) (Math.random() * chance);
         double kritisch = (double) (Math.random() * critchance);

         if (kritisch > fail && kritisch > mittel) {
         // help.p("Du bekommst ein Diamantschwert");
         kritisch =1;
         } else if (mittel > fail && mittel > kritisch) {
         // help.p("Du bekommst ein Goldschwert");
         mittel =1;
         } else {
         // help.p("Du bekommst ein Steinschwert");
         fail = 1;
         }
		 *
		 */
	}

	public static void werteanz(Hero hhero) {
		// KAMPFWERTE AUSGABE

		help.p(prefix + "###====|| " + hhero.getpName() + hhero.getpClass() + " ||====###");
		help.p(prefix);
		help.print(prefix + "### - Angriff: " + hhero.getA() + "         -(=");
		for (int i = 0; i < hhero.getA(); i = i + 20) {
			help.print("==");
		}
		help.p(">");
		help.p(prefix + "### - Geschick: " + hhero.getG() + "        >>>");
		help.p(prefix + "### - Hirn: " + hhero.getH() + "             [#Hirn#]");
		help.print(prefix + "### - Zauberkraft: " + hhero.getM() + "    < ");
		for (int i = 0; i < hhero.getM(); i = i + 30) {
			help.print("~~");
		}
		help.p("~");
		help.print(prefix + "### - Leben: " + hhero.getL() + "          [[");
		for (int i = 0; i < hhero.getL(); i = i + 100) {
			help.print(":");
		}
		help.p("]]");
		help.p(prefix);
		superprefix = "null";

		help.print(prefix + "#// ZAUBER \\# -  ");
		for (int i = 1; i <= hhero.getSpellSize(); i++) {
			help.print("Taste " + (i) + ": " + hhero.getspell(i) + " || ");
		}
		help.p();
		help.p("*----------------------------------*");

	}

	public static void changePOWERLEVEL(Hero winner, Hero looser) {
		if (winner.getClassS() == Classes.MENSCH) {
			Values.POWERdrache -= 0.1;
		} else if (winner.getClassS() == Classes.DRACHE) {
			Values.POWERdrache -= 0.1;
		} else if (winner.getClassS() == Classes.EISDRACHE) {
			Values.POWERdrache -= 0.1;
		}
	}





	/*
	 *                          .=========================.
	 *                          |                         |
	 *                          |      VARIABELN PACK     |
	 *                          |                         |
	 *                          *=========================*
	 *
	 */

	public static String prefix = "[MiniHeros] ";
	public static String prefix1 = "**************************************";
	public static String prefix2 = "---------------------------------------------------------";
	public static String prefix3 = ". . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . .";
	public static String spieler1 = "David";
	public static String spieler2 = "Manuel";
	public static String spielertmp = "jesus";
	public static String hero1 = "null";
	public static String hero2 = "null";
	public static String superprefix = "null";
	public static int TODOi = 0;

	// Variabeln pack
	public static double hchange, h2change;
	public static double hangriff, h2angriff;
	public static double hleben, h2leben;
	public static double hgeschick, h2geschick;
	public static double hhirn, h2hirn;
	public static double hmagie, h2magie;
	public static int kampf;

	public static double hrandom = (double) Math.ceil(3 * Math.random()) * 0.15 + 0.8;
	public static double hrandom2 = (double) Math.ceil(3 * Math.random()) * 0.16 + 0.82;

	// GAMECHANGE:
	public static double heat;


	/*
	 *                          .=========================.
	 *                          |                         |
	 *                          |          FENSTER        |
	 *                          |                         |
	 *                          *=========================*
	 *
	 */


	// HHERO SETTER UND GETTER
	public static Hero getHhero1() {
		return hhero1;
	}
	public static void setHhero1(Hero hhero1) {
		MiniHeros.hhero1 = hhero1;
	}
	public static Hero getHhero2() {
		return hhero2;
	}
	public static void setHhero2(Hero hhero1) {
		MiniHeros.hhero2 = hhero1;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
