package miniheros.hero;

import java.io.IOException;
import java.util.Scanner;

import main.MiniHeros;
import miniheros.util.Anzeigen;
import miniheros.util.Help;
import miniheros.util.RNG.*;

public class Itembox {

	public static void roll(Hero hero, Hero gegner) throws IOException {
		Scanner eingabe = new Scanner(System.in);
		String Antwort = null;

		/*
		 *                          .=========================.
		 *                          |                         |
		 *                          |  ++  GAMECHANGE BOX  ++ |
		 *                          |                         |
		 *                          *=========================*
		 */
		double boxchance = 1; // ist 1%
		double diamantchance = 2; // sind 2%
		double bananachance = 5; // sind 5%


		// initialisiere itembox
		double randomzahl = (double) Math.ceil(Math.random()*100);
		double maxzahl = 100; // maxzahl ist hilfsvariabel um prozente von oben zu nutzen!
		maxzahl = maxzahl - boxchance; // stellt prozent da!   -1 stellt 1% dar.
		if (randomzahl > maxzahl) {
			Help.p(MiniHeros.prefix + "### /37283/$%4684564/$7$584385//68347#74745// ###");
			Help.p(MiniHeros.prefix + "###   Schwarze Box des Untergangs gefunden!   ###");
			Help.p(MiniHeros.prefix + "### /37283/$%4684564/$7$584385//68347#74745// ###");
			Help.p(MiniHeros.prefix + "###                       ###");
			Help.p(MiniHeros.prefix + "### was willst du machen? ###");
			Help.p(MiniHeros.prefix + "###      1. Verkaufen     ###");
			Help.p(MiniHeros.prefix + "###       2. Oeffnen       ###");
			Help.p(MiniHeros.prefix + "###        3. Essen       ###");
			Antwort = eingabe.next();
			if (Antwort.equalsIgnoreCase("Verkaufen") || Antwort.equals("1")) {
				Help.p(MiniHeros.prefix + "###        Schwarze Box verkauft!       ###");
				Help.p(MiniHeros.prefix + "OH MEIN GOTT! Der Haendler ist bei Beruehrung mit der Box gestorben!");
				Help.p(MiniHeros.prefix + "Willst du sein Haus ausrauben?");
				Antwort = eingabe.next();
				if (Antwort.equalsIgnoreCase("ja")) {
					Help.p(MiniHeros.prefix + "### Du herzloser Wicht! ###");
					Help.p(MiniHeros.prefix + "Ein Priester hat dich entdeckt! 50 Schaden durch Herzlosigkeit!");
					hero.kampf(-50);
					Help.p(MiniHeros.prefix + "Elfische Streitaxt gefunden! Angriff um 70 erhöht!");
					hero.setA(hero.getA() + 70);
				} else if (Antwort.equalsIgnoreCase("nein")) {
					Help.p(MiniHeros.prefix + "### Mitgefuehlbonus! ###");
					Help.p(MiniHeros.prefix + "Ein Prister erkennt dein Mitgefuehl und heilt dich um 400 Leben !");
					hero.kampf(400);
				} else {
					Help.p(MiniHeros.prefix + "Du hast versagt ja oder nein einzugeben.");
					Help.p(MiniHeros.prefix + "Dummheitsbonus! 50 Schaden!");
					hero.kampf(-50);
				}
			} else if (Antwort.equalsIgnoreCase("oeffnen") || Antwort.equals("2")) {
				int x = (int) Math.random() * 3 + 1;
				if (x == 1) {
					hero.setL(hero.getL() + hero.getM());
					hero.setA(hero.getA() + hero.getM());
					hero.setM(0);
					Help.p(MiniHeros.prefix + "Schwarze Box entzieht dir all deine Magie und wandelt sie in Angriff und Leben um!");
				} else if (x == 2) {
					hero.setA(hero.getA() * 0.8);
					hero.setG(hero.getG() * 0.8);
					hero.kampf(-200);
					gegner.kampf(-200);
					Help.p(MiniHeros.prefix + "3$)294 Schwarze Box explodiert! 3)324=");
					Help.p(MiniHeros.prefix + "Die Explosion fuegt beiden Helden 200 Schaden zu! Ausserdem senkt sich dein Angriff und Geschick um 20%");
				} else {
					hero.setM(666 + hero.getM());
					hero.kampf(200);
					Help.p(MiniHeros.prefix + "In der schwarzen Box findest du einen winzigen Magier");
					Help.p(MiniHeros.prefix + "Er heilt dich um 200 und kaempft nun fuer dich! Magie steigt auf: " + hero.getM());
				}
			} else if (Antwort.equalsIgnoreCase("essen") || Antwort.equals("3")) {
				Help.p(MiniHeros.prefix + "Du isst die dunkle Box mit Messer und Gabel. Es schmeckt hart und nach dunkler Magie.");

				if (Help.chance(20)) {
					hero.setClassS(Classes.ULTIMATEFORM);
					hero.addDefaultValues(Classes.ULTIMATEFORM);
					Help.red(MiniHeros.prefix + "/// RIESIGE EXPLOSION! ///");
					Help.red(MiniHeros.prefix + "Du wirst zu Illidan, dem Herrscher der Finsterniss!");
					Anzeigen.werte(hero);
				} else {
					hero.setL(hero.getL() * 0.8);
					Help.p(MiniHeros.prefix + "Verwandlung fehlgeschlagen. Du verlierst 20% deines Lebens!");
				}
			} else {
				hero.kampf(-50);
				Help.p(MiniHeros.prefix + "50 Schaden durch Dummheit");
			}
		} else {
			maxzahl = maxzahl - diamantchance; // stellt prozent da!   -2 stellt 2% dar.
			if (randomzahl > maxzahl) {
				Help.p(MiniHeros.prefix + "### ********************* ###");
				Help.p(MiniHeros.prefix + "### ********************* ###");
				Help.p(MiniHeros.prefix + "###   Diamant gefunden!   ###");
				Help.p(MiniHeros.prefix + "### ********************* ###");
				Help.p(MiniHeros.prefix + "### ********************* ###");
				Help.p(MiniHeros.prefix + "###                       ###");
				Help.p(MiniHeros.prefix + "### was willst du machen? ###");
				Help.p(MiniHeros.prefix + "###      1. Verkaufen     ###");
				Help.p(MiniHeros.prefix + "###       2. Werfen       ###");
				Help.p(MiniHeros.prefix + "###        3. Essen       ###");
				Antwort = eingabe.next();
				if (Antwort.equalsIgnoreCase("Verkaufen") || Antwort.equals("1")) {
					hero.setA(hero.getA() * 2);
					hero.setL(hero.getL() + 1500);
					hero.setG(hero.getG() * 0.75);
					Help.p(MiniHeros.prefix + "# Diamant verkauft und davon Waffen und Ruestung gekauft! Die Ruestung ist schwer.");
					Help.p(MiniHeros.prefix + "Angriff: " + hero.getA());
					Help.p(MiniHeros.prefix + "Geschick: " + hero.getG());
					Help.p(MiniHeros.prefix + "Leben: " + hero.getL());
				} else if (Antwort.equalsIgnoreCase("Werfen") || Antwort.equals("2")) {
					Help.p("/***/ Diamantwurf /***/");
					Help.p("Dein Held holt aus und wirft mit aller Kraft!!!");
					Help.punkte();
					Help.p("Der Diamant fliegt mit so hoher Geschwindigkeit, dass er die Schallmauer durchbricht und deinen Gegner betaeubt!!");
					gegner.reG(0.7);
					gegner.reA(0.7);
					if (Help.chance(100 * hero.getG() / (hero.getG() + 50))) {
						Help.red("=== kritischer TREFFER! ===");
						Help.p("Diamant trifft Auge des Gegners! 800 Schaden!!!");
						gegner.reG(0.7);
						gegner.reA(0.7);
						gegner.kampf(-800);
					} else {
						Help.p("* FAIL * Diamant geht daneben!");
						gegner.reA(1.2);
					}
				} else if (Antwort.equalsIgnoreCase("Essen") || Antwort.equals("3")) {
					Help.punkte(5, 1300);
					if (Help.chance(70)) {
						hero.kampf(-400);
						Help.p(MiniHeros.prefix + "# Deine Gabel zerbricht. Du wirfst den Diamant in deinen Mund und schluckst. " + hero.getpName() + " verliert 400 Leben.");
					} else {
						int heilung = (int) ((int) 6 * MiniHeros.heat);
						heilung *= 100;
						hero.kampf(+heilung);
						Help.p(MiniHeros.prefix + "# Der Diamant war schmackhaft! Sehr Knusprig." + hero.getpName() + "hat nun " + heilung + " Leben mehr!");
						hero.reM(1.5);
					}
				} else {
					Help.p("FAIL");
				}
			} else {
				maxzahl = maxzahl - bananachance; // stellt prozent da!   -5 stellt 5% dar.
				if (randomzahl > maxzahl) {
					Help.p(MiniHeros.prefix + "### ********************* ###");
					Help.p(MiniHeros.prefix + "### ********************* ###");
					Help.p(MiniHeros.prefix + "###    Banane gefunden!   ###");
					Help.p(MiniHeros.prefix + "### ********************* ###");
					Help.p(MiniHeros.prefix + "### ********************* ###");
					Help.p(MiniHeros.prefix + "###                       ###");
					Help.p(MiniHeros.prefix + "### was willst du machen? ###");
					Help.p(MiniHeros.prefix + "###      1. Verkaufen     ###");
					Help.p(MiniHeros.prefix + "###       2. Werfen       ###");
					Help.p(MiniHeros.prefix + "###        3. Essen       ###");
					Antwort = eingabe.next();
					if (Antwort.equalsIgnoreCase("Verkaufen") || Antwort.equals("1")) {
						if (Help.chance(60+hero.getG()*0.5)) {
							hero.setA(hero.getA() * 3);
							hero.setL(hero.getL() + 2500);
							hero.setG(hero.getG() * 0.65);
							Help.p(MiniHeros.prefix + "# Die Banane ist mit purem Gold gefuellt! Du verkaufst sie gegen ein Todesbringer Schwert und eine Goldruestung!");
							Help.p(MiniHeros.prefix + "Angriff: " + hero.getA());
							Help.p(MiniHeros.prefix + "Geschick: " + hero.getG());
							Help.p(MiniHeros.prefix + "Leben: " + hero.getL());
						} else {
							Help.p(MiniHeros.prefix + "# Du willst dem Verkaufer gerade die Banane reichen, da kommt ein Affe und klaut sie dir!");
						}

					} else if (Antwort.equalsIgnoreCase("Werfen") || Antwort.equals("2")) {
						Help.p("/***/ Bananenwurf! /***/");
						Help.p("Dein Held holt aus und wirft mit aller Kraft!!!");
						Help.punkte();
						if (Help.chance(100 * hero.getG() / (hero.getG() + 50))) {
							int schaden = (int) (200*Hero.life);
							Help.red("=== kritischer TREFFER! ===");
							Help.p("Die Banane explodiert. Aus der Banane erscheinen 10 Affen, die auf "+gegner.getpName()+"einpruegeln! "+schaden+" Schaden!");
							gegner.reG(0.6);
							gegner.reA(0.6);
							gegner.kampf(-schaden);
						} else {
							Help.p("* FAIL * Banane geht daneben!");
						}
					} else if (Antwort.equalsIgnoreCase("Essen") || Antwort.equals("3")) {
						Help.p("// ESSEN! //");
						Help.punkte(3, 1300);
						if (Help.chance(30)) {
							int schaden = (int) (50*Hero.life);
							hero.kampf(-schaden);
							Help.p(MiniHeros.prefix + "# Du schaelst die Banana und willst gerade reinbeissen, da rutschst du auf einer Bananenschale aus! Woher kommt die denn?! "+schaden+" Schaden!");
							hero.reG(0.75);
						} else {
							int schaden = (int) (1 * Hero.life);
							schaden *= 100;
							hero.kampf(schaden);
							Help.p(MiniHeros.prefix + "# Die Banane ist schon lange in diesem Programm. Sie is abgelaufen und du isst sie auch noch!" + hero.getpName() + schaden + " Schaden durch Bauchschmerzen!");
						}
					} else {
						Help.p("FAIL");
					}
				} else {
					// hier endet die letzte else klammer
					// platz fuer mehr items..
					// maxzahl = maxzahl - bananachance; // stellt prozent da!   -5 stellt 5% dar.
					// if (randomzahl > maxzahl) {
				}
			}
			
			
		}
	}
}

