package miniheros.hero;

import java.io.IOException;
import java.util.Scanner;

import main.MiniHeros;
import miniheros.util.help;

public class Itembox {

	public static void roll(Hero hero, Hero gegner) throws IOException {
		Scanner eingabe = new Scanner(System.in);
		String Antwort = null;
		
		
		float xx = (float) Math.ceil(Math.random()*100);
		int e = 0;

		if (help.chance(1)) {
			help.p(MiniHeros.prefix + "### /37283/$%4684564/$7$584385//68347#74745// ###");
			help.p(MiniHeros.prefix + "###   Schwarze Box des Untergangs gefunden!   ###");
			help.p(MiniHeros.prefix + "### /37283/$%4684564/$7$584385//68347#74745// ###");
			help.p(MiniHeros.prefix + "###                       ###");
			help.p(MiniHeros.prefix + "### was willst du machen? ###");
			help.p(MiniHeros.prefix + "###      1. Verkaufen     ###");
			help.p(MiniHeros.prefix + "###       2. Oeffnen       ###");
			help.p(MiniHeros.prefix + "###        3. Essen       ###");
			Antwort = eingabe.next();
			if (Antwort.equalsIgnoreCase("Verkaufen") || Antwort.equals("1")) {
				help.p(MiniHeros.prefix + "###        Schwarze Box verkauft!       ###");
				help.p(MiniHeros.prefix + "OH MEIN GOTT! Der Haendler ist bei Beruehrung mit der Box gestorben!");
				help.p(MiniHeros.prefix + "Willst du sein Haus ausrauben?");
				Antwort = eingabe.next();
				if (Antwort.equalsIgnoreCase("ja")) {
					help.p(MiniHeros.prefix + "### Du herzloser Wicht! ###");
					help.p(MiniHeros.prefix + "Ein Priester hat dich entdeckt! 50 Schaden durch Herzlosigkeit!");
					hero.kampf(-50);
					help.p(MiniHeros.prefix + "Elfische Streitaxt gefunden! Angriff um 70 erhöht!");
					hero.setA(hero.getA() + 70);
				} else if (Antwort.equalsIgnoreCase("nein")) {
					help.p(MiniHeros.prefix + "### Mitgefuehlbonus! ###");
					help.p(MiniHeros.prefix + "Ein Prister erkennt dein Mitgefuehl und heilt dich um 400 Leben !");
					hero.kampf(400);
				} else {
					help.p(MiniHeros.prefix + "Du hast versagt ja oder nein einzugeben.");
					help.p(MiniHeros.prefix + "Dummheitsbonus! 50 Schaden!");
					hero.kampf(-50);
				}
			} else if (Antwort.equalsIgnoreCase("oeffnen") || Antwort.equals("2")) {
				int x = (int) Math.random() * 3 + 1;
				if (x == 1) {
					hero.setL(hero.getL() + hero.getM());
					hero.setA(hero.getA() + hero.getM());
					hero.setM(0);
					help.p(MiniHeros.prefix + "Schwarze Box entzieht dir all deine Magie und wandelt sie in Angriff und Leben um!");
				} else if (x == 2) {
					hero.setA(hero.getA() * 0.8);
					hero.setG(hero.getG() * 0.8);
					hero.kampf(-200);
					gegner.kampf(-200);
					help.p(MiniHeros.prefix + "3$)294 Schwarze Box explodiert! 3)324=");
					help.p(MiniHeros.prefix + "Die Explosion fuegt beiden Helden 200 Schaden zu! Ausserdem senkt sich dein Angriff und Geschick um 20%");
				} else {
					hero.setM(666 + hero.getM());
					hero.kampf(200);
					help.p(MiniHeros.prefix + "In der schwarzen Box findest du einen winzigen Magier");
					help.p(MiniHeros.prefix + "Er heilt dich um 200 und kaempft nun fuer dich! Magie steigt auf: " + hero.getM());
				}
			} else if (Antwort.equalsIgnoreCase("essen") || Antwort.equals("3")) {
				help.p(MiniHeros.prefix + "Du isst die dunkle Box mit Messer und Gabel. Es schmeckt hart und nach dunkler Magie.");

				if (help.chance(20)) {
					hero.setClassS(Classes.ULTIMATEFORM);
					hero.addDefaultValues(Classes.ULTIMATEFORM);
					help.red(MiniHeros.prefix + "/// RIESIGE EXPLOSION! ///");
					help.red(MiniHeros.prefix + "Du wirst zu Illidan, dem Herrscher der Finsterniss!");
					MiniHeros.werteanz(hero);
				} else {
					hero.setL(hero.getL() * 0.8);
					help.p(MiniHeros.prefix + "Verwandlung fehlgeschlagen. Du verlierst 20% deines Lebens!");
				}
			} else {
				hero.kampf(-50);
				help.p(MiniHeros.prefix + "50 Schaden durch Dummheit");
			}
		} else if (help.chance(1)) { // 0.9*0.01 = 0.009
			help.p(MiniHeros.prefix + "### ********************* ###");
			help.p(MiniHeros.prefix + "### ********************* ###");
			help.p(MiniHeros.prefix + "###   Diamant gefunden!   ###");
			help.p(MiniHeros.prefix + "### ********************* ###");
			help.p(MiniHeros.prefix + "### ********************* ###");
			help.p(MiniHeros.prefix + "###                       ###");
			help.p(MiniHeros.prefix + "### was willst du machen? ###");
			help.p(MiniHeros.prefix + "###      1. Verkaufen     ###");
			help.p(MiniHeros.prefix + "###       2. Werfen       ###");
			help.p(MiniHeros.prefix + "###        3. Essen       ###");
			Antwort = eingabe.next();
			if (Antwort.equalsIgnoreCase("Verkaufen") || Antwort.equals("1")) {
				hero.setA(hero.getA() * 2);
				hero.setL(hero.getL() + 1500);
				hero.setG(hero.getG() * 0.75);
				help.p(MiniHeros.prefix + "# Diamant verkauft und davon Waffen und Ruestung gekauft! Die Ruestung ist schwer.");
				help.p(MiniHeros.prefix + "Angriff: " + hero.getA());
				help.p(MiniHeros.prefix + "Geschick: " + hero.getG());
				help.p(MiniHeros.prefix + "Leben: " + hero.getL());
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
					help.p(MiniHeros.prefix + "# Deine Gabel zerbricht. Du wirfst den Diamant in deinen Mund und schluckst. " + hero.getpName() + " verliert 400 Leben.");
				} else {
					int heilung = (int) ((int) 6 * MiniHeros.heat);
					heilung *= 100;
					hero.kampf(+heilung);
					help.p(MiniHeros.prefix + "# Der Diamant war schmackhaft! Sehr Knusprig." + hero.getpName() + "hat nun " + heilung + " Leben mehr!");
					hero.reM(1.5);
				}
			} else {
				help.p("FAIL");
			}
		} else if (help.chance(5)) {
			help.p(MiniHeros.prefix + "### ********************* ###");
			help.p(MiniHeros.prefix + "### ********************* ###");
			help.p(MiniHeros.prefix + "###    Banane gefunden!   ###");
			help.p(MiniHeros.prefix + "### ********************* ###");
			help.p(MiniHeros.prefix + "### ********************* ###");
			help.p(MiniHeros.prefix + "###                       ###");
			help.p(MiniHeros.prefix + "### was willst du machen? ###");
			help.p(MiniHeros.prefix + "###      1. Verkaufen     ###");
			help.p(MiniHeros.prefix + "###       2. Werfen       ###");
			help.p(MiniHeros.prefix + "###        3. Essen       ###");
			Antwort = eingabe.next();
			if (Antwort.equalsIgnoreCase("Verkaufen") || Antwort.equals("1")) {
				if (help.chance(60+hero.getG()*0.5)) {
					hero.setA(hero.getA() * 3);
					hero.setL(hero.getL() + 2500);
					hero.setG(hero.getG() * 0.65);
					help.p(MiniHeros.prefix + "# Die Banane ist mit purem Gold gefuellt! Du verkaufst sie gegen ein Todesbringer Schwert und eine Goldruestung!");
					help.p(MiniHeros.prefix + "Angriff: " + hero.getA());
					help.p(MiniHeros.prefix + "Geschick: " + hero.getG());
					help.p(MiniHeros.prefix + "Leben: " + hero.getL());
				} else {
					help.p(MiniHeros.prefix + "# Du willst dem Verkaufer gerade die Banane reichen, da kommt ein Affe und klaut sie dir!");
				}

			} else if (Antwort.equalsIgnoreCase("Werfen") || Antwort.equals("2")) {
				help.p("/***/ Bananenwurf! /***/");
				help.p("Dein Held holt aus und wirft mit aller Kraft!!!");
				help.punkte();
				if (help.chance(100 * hero.getG() / (hero.getG() + 50))) {
					int schaden = (int) (200*Hero.life);
					help.red("=== kritischer TREFFER! ===");
					help.p("Die Banane explodiert. Aus der Banane erscheinen 10 Affen, die auf "+gegner.getpName()+"einpruegeln! "+schaden+" Schaden!");
					gegner.reG(0.6);
					gegner.reA(0.6);
					gegner.kampf(-schaden);
				} else {
					help.p("* FAIL * Banane geht daneben!");
				}
			} else if (Antwort.equalsIgnoreCase("Essen") || Antwort.equals("3")) {
				help.p("// ESSEN! //");
				help.punkte(3, 1300);
				if (help.chance(30)) {
					int schaden = (int) (50*Hero.life);
					hero.kampf(-schaden);
					help.p(MiniHeros.prefix + "# Du schaelst die Banana und willst gerade reinbeissen, da rutschst du auf einer Bananenschale aus! Woher kommt die denn?! "+schaden+" Schaden!");
					hero.reG(0.75);
				} else {
					int schaden = (int) (1 * Hero.life);
					schaden *= 100;
					hero.kampf(schaden);
					help.p(MiniHeros.prefix + "# Die Banane ist schon lange in diesem Programm. Sie is abgelaufen und du isst sie auch noch!" + hero.getpName() + schaden + " Schaden durch Bauchschmerzen!");
				}
			} else {
				help.p("FAIL");
			}
		}
	}

	
}
