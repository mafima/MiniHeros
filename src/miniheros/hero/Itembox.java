package miniheros.hero;

import java.io.IOException;

import static main.Textarena.*;
import static miniheros.util.Help.*;
import static main.Game.*;
import miniheros.util.Anzeigen;
import miniheros.util.RNG;

public class Itembox {

	public static double chance = 1;

	public static void roll(Hero hero, Hero gegner) throws IOException {
		String Antwort = null;

		/*
		 *                          .=========================.
		 *                          |                         |
		 *                          |  ++  GAMECHANGE BOX  ++ |
		 *                          |                         |
		 *                          *=========================*
		 */

		// # ITEMCHANCE in prozent
		double box = 1 * chance;
		double diamant = 2 * chance;
		double banana = 5 * chance;

		double aboost = 2 * chance;
		double gboost = 2 * chance;
		double hboost = 2 * chance;
		double mboost = 2 * chance;
		double lboost = 5 * chance;

		// alle itemchances zusammen muss zusammen unter 100 liegen!!!


		// initialisiere itembox
		RNG.gen();
		if (RNG.chance(box)) {
			warte(250);
			p( "### /37283/$%4684564/$7$584385//68347#74745// ###");
			p( "###   Schwarze Box des Untergangs gefunden!   ###");
			p( "### /37283/$%46lol84564/$7$385//68347#74745// ###");
			p( "###                       ###");
			p( "### was willst du machen? ###");
			p( "###      1. Verkaufen     ###");
			p( "###       2. Oeffnen      ###");
			p( "###        3. Essen       ###");
			p();
			Antwort = eingabe.next();
			if (Antwort.equalsIgnoreCase("Verkaufen") || Antwort.equals("1")) {
				p( "###        Schwarze Box verkauft!       ###");
				p( "OH MEIN GOTT! Der Haendler ist bei Beruehrung mit der Box gestorben!");
				p( "Willst du sein Haus ausrauben?");
				Antwort = eingabe.next();
				if (Antwort.equalsIgnoreCase("ja")) {
					p( "### Du herzloser Wicht! ###");
					p( "Ein Priester hat dich entdeckt! 50 Schaden durch Herzlosigkeit!");
					hero.kampf(-50);
					p( "Elfische Streitaxt gefunden! Angriff um 70 erhÃ¶ht!");
					hero.setA(hero.getA() + 70);
				} else if (Antwort.equalsIgnoreCase("nein")) {
					p( "### Mitgefuehlbonus! ###");
					p( "Ein Prister erkennt dein Mitgefuehl und heilt dich um 400 Leben !");
					hero.kampf(400);
				} else {
					p( "Du hast versagt ja oder nein einzugeben.");
					p( "Dummheitsbonus! 50 Schaden!");
					hero.kampf(-50);
				}
			} else if (Antwort.equalsIgnoreCase("oeffnen") || Antwort.equals("2")) {
				RNG.gen();
				if (RNG.chance(25)) {
					hero.setL(hero.getL() + hero.getM());
					hero.setA(hero.getA() + hero.getM());
					hero.setM(0);
					p( "Schwarze Box entzieht dir all deine Magie und wandelt sie in Angriff und Leben um!");
				} else if (RNG.chance(25)) {
					hero.reA(0.8);
					hero.reG(0.8);
					hero.kampf(-200);
					gegner.kampf(-200);
					p( "3$)294 Schwarze Box explodiert! 3)324=");
					p( "Die Explosion fuegt beiden Helden 200 Schaden zu! Ausserdem senkt sich dein Angriff und Geschick um 20%");
				} else {
					hero.addM(666);
					hero.kampf(200);
					p( "In der schwarzen Box findest du einen winzigen Magier");
					p( "Er heilt dich um 200 und kaempft nun fuer dich! Magie steigt auf: " + hero.getM());
				}
			} else if (Antwort.equalsIgnoreCase("essen") || Antwort.equals("3")) {
				p( "Du isst die dunkle Box mit Messer und Gabel. Es schmeckt hart und nach dunkler Magie.");

				if (chance(20)) {
					hero.setClassS(Classes.ULTIMATEFORM);
					hero.addDefaultValues(Classes.ULTIMATEFORM);
					red( "/// RIESIGE EXPLOSION! ///");
					red( "Du wirst zu Illidan, dem Herrscher der Finsterniss!");
					Anzeigen.stats(hero);
				} else {
					hero.setL(hero.getL() * 0.8);
					p( "Verwandlung fehlgeschlagen. Du verlierst 20% deines Lebens!");
				}
			} else {
				hero.kampf(-50);
				p( "50 Schaden durch Dummheit");
			}
		} else if (RNG.chance(diamant)) {
			warte(250);
			p( "### ********************* ###");
			p( "### ********************* ###");
			p( "###   Diamant gefunden!   ###");
			p( "### ********************* ###");
			p( "### ********************* ###");
			p( "###                       ###");
			p( "### was willst du machen? ###");
			p( "###      1. Verkaufen     ###");
			p( "###       2. Werfen       ###");
			p( "###        3. Essen       ###");
			p();
			Antwort = eingabe.next();
			if (Antwort.equalsIgnoreCase("Verkaufen") || Antwort.equals("1")) {
				hero.setA(hero.getA() * 2);
				hero.setL(hero.getL() + 1500);
				hero.setG(hero.getG() * 0.75);
				p( "# Diamant verkauft und davon Waffen und Ruestung gekauft! Die Ruestung ist schwer.");
				p( "Angriff: " + hero.getA());
				p( "Geschick: " + hero.getG());
				p( "Leben: " + hero.getL());
			} else if (Antwort.equalsIgnoreCase("Werfen") || Antwort.equals("2")) {
				p("/***/ Diamantwurf /***/");
				p("Dein Held holt aus und wirft mit aller Kraft!!!");
				punkte();
				p("Der Diamant fliegt mit so hoher Geschwindigkeit, dass er die Schallmauer durchbricht und deinen Gegner betaeubt!!");
				gegner.reG(0.7);
				gegner.reA(0.7);
				if (chance(100 * hero.getG() / (hero.getG() + 50))) {
					red("=== kritischer TREFFER! ===");
					p("Diamant trifft Auge des Gegners! 800 Schaden!!!");
					gegner.reG(0.7);
					gegner.reA(0.7);
					gegner.kampf(-800);
				} else {
					p("* FAIL * Diamant geht daneben!");
					gegner.reA(1.2);
				}
			} else if (Antwort.equalsIgnoreCase("Essen") || Antwort.equals("3")) {
				punkte(5, 1300);
				if (chance(70)) {
					hero.kampf(-400);
					p( "# Deine Gabel zerbricht. Du wirfst den Diamant in deinen Mund und schluckst. " + hero.getpName() + " verliert 400 Leben.");
				} else {
					int heilung = (int) ((int) 6 * heat);
					heilung *= 100;
					hero.kampf(+heilung);
					p( "# Der Diamant war schmackhaft! Sehr Knusprig." + hero.getpName() + "hat nun " + heilung + " Leben mehr!");
					hero.reM(1.5);
				}
			} else {
				p("FAIL");
			}
		} else if (RNG.chance(banana)) {
			warte(250);
			p( "### ********************* ###");
			p( "### ********************* ###");
			p( "###    Banane gefunden!   ###");
			p( "### ********************* ###");
			p( "### ********************* ###");
			p( "###                       ###");
			p( "### was willst du machen? ###");
			p( "###      1. Verkaufen     ###");
			p( "###       2. Werfen       ###");
			p( "###        3. Essen       ###");
			p();
			Antwort = eingabe.next();
			if (Antwort.equalsIgnoreCase("Verkaufen") || Antwort.equals("1")) {
				if (chance(40+60*malor(hero.getG(),50))) {
					hero.setA(hero.getA() * 3);
					hero.reR(0.75);
					hero.setG(hero.getG() * 0.65);
					p( "# Die Banane ist mit purem Gold gefuellt! Du verkaufst sie gegen ein Todesbringer Schwert und eine Goldruestung!");
					p( "Angriff: " + hero.getA());
					p( "Geschick: " + hero.getG());
					p( "Leben: " + hero.getL());
				} else {
					p( "# Du willst dem Verkaufer gerade die Banane reichen, da kommt ein Affe und klaut sie dir!");
				}

			} else if (Antwort.equalsIgnoreCase("Werfen") || Antwort.equals("2")) {
				p("/***/ Bananenwurf! /***/");
				p("Dein Held holt aus und wirft mit aller Kraft!!!");
				punkte();
				if (chance(10 + 90 * malor(hero.getG(), 70))) {
					int schaden = (int) (100*Hero.life);
					red("=== kritischer TREFFER! ===");
					p("Die Banane explodiert. Aus der Banane erscheinen 10 Affen, die auf "+gegner.getpName()+"einpruegeln! "+schaden+" Schaden!");
					gegner.reG(0.6);
					gegner.reA(0.6);
					gegner.kampf(-schaden);
				} else {
					p("* FAIL * Banane geht daneben!");
				}
			} else if (Antwort.equalsIgnoreCase("Essen") || Antwort.equals("3")) {
				p("// ESSEN! //");
				punkte(3, 1300);
				if (chance(30)) {
					int schaden = (int) (50*Hero.life);
					hero.kampf(-schaden);
					p( "# Du schaelst die Banana und willst gerade reinbeissen, da rutschst du auf einer Bananenschale aus! Woher kommt die denn?! "+schaden+" Schaden!");
					hero.reG(0.75);
				} else {
					int schaden = (int) (1 * Hero.life);
					schaden *= 100;
					hero.kampf(schaden);
					p( "# Die Banane ist schon lange in diesem Programm. Sie is abgelaufen und du isst sie auch noch!" + hero.getpName() + schaden + " Schaden durch Bauchschmerzen!");
				}
			} else {
				p("FAIL");
			}
		} else if (RNG.chance(aboost)) {
			warte(250);
			p( "### ********************* ###");
			p( "### ********************* ###");
			p( "###  Kampfzwerg gefunden! ###");
			p( "### ********************* ###");
			p( "### ********************* ###");
			p( "###                       ###");
			p( "### was willst du machen? ###");
			p( "###      1. Wegkicken     ###");
			p( "###       2. Streicheln   ###");
			p( "###        3. Essen       ###");
			p();
			Antwort = eingabe.next();
			punkte(3,1500);
			if (Antwort.equalsIgnoreCase("wegkicken") || Antwort.equals("1")) {
				if (chance(70+ 30*malor(hero.getG(),300))) {
					p( "# Kampfzwerg weggekickt!");
					hero.reG(1.1);
				} else {
					p("FAIL! Du kickst daneben und der Kampfzwerg tritt dir in die Eier!");
					hero.reG(0.8);
					hero.kampf(-50,"Eiertritt");
				}

			} else if (Antwort.equalsIgnoreCase("Streicheln") || Antwort.equals("2")) {
				p("/***/ Streicheln! /***/");

				if (chance(95-70*malor(hero.getA(),200))) {
					red("=== Streicheln kommt gut an! ===");
					p("Der Kampfzwerg schliesst sich dir an!");
					p("Er holt sein Ninjaanzug und Katanas raus!");
					hero.addA(10);
					hero.addG(20);
				} else {
					p("Der Zwerg hat Angst weil so so viel Angriff hast! Er rennt weg!");
					p("Du rennst ihm hinterher aber verlierst ihn."); warte(2000);
					p("Doch du findest eine abgebrochene Klinge auf dem Boden!"); warte(2000);
					hero.addA(5);
				}
			} else if (Antwort.equalsIgnoreCase("Essen") || Antwort.equals("3")) {
				if (chance(70)) {
					hero.kampf(300*Hero.life,"Zwergspeise");
					p( "# Deine Gabel zerbricht. Du wirfst den Diamant in deinen Mund und schluckst. " + hero.getpName() + " verliert 400 Leben.");
				} else {
					red("Der Zwerg merkt, dass du deine Gabel auspackst und rennt davon!"); warte (3000);
					p("Du rennst ihm hinterher aber verlierst ihn."); warte(2000);
					p("Doch du findest eine abgebrochene Klinge auf dem Boden!"); warte(2000);
					hero.addA(5);
				}
			} else {
				p("FAIL");
			}
		} else if (RNG.chance(gboost)) {
			warte(250);
			p( "### ********************* ###");
			p( "### ********************* ###");
			p( "###   RedBull gefunden!   ###");
			p( "### ********************* ###");
			p( "### ********************* ###");
			p( "###                       ###");
			p( "### was willst du machen? ###");
			p( "###      1. Trinken       ###");
			p( "###       2. Rot          ###");
			p( "###        3. Streicheln  ###");
			p();
			Antwort = eingabe.next();
			punkte(3,1500);
			if (Antwort.equalsIgnoreCase("trinken") || Antwort.equals("1")) {
				red("DAS IST EIN ROTER STIER!!!");
				p("Du versuchst ernsthaft an dem roten Stier zu trinken?!... Wow.");
				p("Das ist falsch auf so vielen Ebenen.");
				if (chance(30)) {
					p( "# Der Stier findet es geil und schliesst sich dir an!");
					hero.addA(150);
					hero.addG(200);
				} else {
					p("FAIL! Der Stier rammt dich weg!");
					p("Er rennt auf dich zu!");
					punkte();
					p("Gerade will dich der Stier erledigen, da kommt eine Menschenmasse aus Spanien und killt ihn!");
					p("Du lernst daraus, dass Tiere doof sind! Lerneffekt!!!");
					hero.addH(30);
					hero.reG(0.9);
				}

			} else if (Antwort.equalsIgnoreCase("Rot") || Antwort.equals("2")) {
				p("/***/ ROT IST TOLL! /***/... rufst du in den Himmel!");
				punkte();

				if (chance(95-50*malor(hero.getA(),500))) {
					red("=== LEONARDO DAVINCI STEIGT VOM HIMMEL HERAB! ===");
					punkte();
					p("Leonardo: Ich teile deine Liebe zur Farbe ROT!");
					p("Er holt seine SuperMachineGun raus und feuert eine Salve auf den Stier!");
					warte(4500);
					p("Leonardo: Hier mein Freund!");
					warte(1000);
					p("Er wirft einen Roten Farbeimer auf dich. Du bist nun voll mit roter Farbe!");
					p("Dein Gegner bekommt Angst vor dir!");
					warte(3500);
					gegner.reA(0.8);
					gegner.reG(0.8);
				} else {
					red("* FAIL * Kampfzwerg ist zu scheu und rennt weg!");
					p("Du rennst ihm hinterher aber verlierst ihn."); warte(2000);
					p("Doch du findest eine abgebrochene Klinge auf dem Boden!"); warte(2000);
					hero.addA(10);
				}
			} else if (Antwort.equalsIgnoreCase("Streicheln") || Antwort.equals("3")) {

				red("Einen Stier streicheln??!?!?");
				p(new String[] {"KEINE","FUCKING","GUTE","IDEE"},1300);
				p("Stier stoßt dich weg und rennt auf dich zu!");
				punkte();
				if (chance(40+hero.getG()*1.5)) {
					p( "# Du weichst aus und springst auf den Stier! RODEO TIME!");
					hero.reG(1.2);
				} else {
					p("Stier rammt seine Hoerner in dich!");
					hero.kampf(-400*Hero.life,"Stier");
				}
			} else {
				p("FAIL");
			}
		} else if (RNG.chance(hboost)) {
			warte(250);
			p( "### ********************* ###");
			p( "### ********************* ###");
			p( "###  Lesemaus gefunden!   ###");
			p( "###       Quieck          ###");
			p( "### ********************* ###");
			p( "### ********************* ###");
			p( "### was willst du machen? ###");
			p( "###      1. Wegkicken     ###");
			p( "###       2. Streicheln   ###");
			p( "###        3. Essen       ###");
			p();
			Antwort = eingabe.next();
			punkte(3,1500);
			if (Antwort.equalsIgnoreCase("wegkicken") || Antwort.equals("1")) {
				if (chance(70+ 30*malor(hero.getG(),300))) {
					p( "# Lesemaus weggekickt!");
					hero.reG(1.075);
				} else {
					p("FAIL! Du kickst daneben und die Lesemaus beisst dich!");
					hero.reG(0.9);
					hero.kampf(-30,"Biss");
				}

			} else if (Antwort.equalsIgnoreCase("Streicheln") || Antwort.equals("2")) {
				if (chance(80)) {
					red("=== Streicheln kommt gut an! ===");
					p("Die Lesemaus schliesst sich dir an!");
					p("Sie setzt sich auf deine Schulter und hilft bei taktischen Entscheidungen!");
					gegner.addH(60);
				} else {
					red("* FAIL * Lesemaus ist zu scheu und rennt weg!");
					p("Doch du findest eine Buch auf dem Boden!"); warte(2000);
					hero.addH(10);
				}
			} else if (Antwort.equalsIgnoreCase("Essen") || Antwort.equals("3")) {
				if (chance(50)) {
					p("OHHH NEINNN! Es ist eine Ninjamaus! Sie packt ihre Schwerter aus und greift an!");
					hero.kampf(-100*Hero.life,"Ninjamaus");
				} else {
					red("Die Maus merkt, dass du deine Gabel auspackst und rennt davon!"); warte (2000);
					p("Du rennst ihr hinterher aber verlierst ihn."); warte(1000);
					p("Doch du findest ein Buch auf dem Boden!"); warte(1000);
					hero.addH(10);
				}
			} else {
				p("FAIL");
			}
			 
			
		} else if (RNG.chance(mboost)) {
			warte(250);
			p( "### ~~~~~~~~~~~~~~~~~~~~~ ###");
			p( "### ~~~~~~~~~~~~~~~~~~~~~ ###");
			p( "###  Magiestaub gefunden! ###");
			p( "### ~~~~~~~~~~~~~~~~~~~~~ ###");
			p( "### ~~~~~~~~~~~~~~~~~~~~~ ###");
			p( "###                       ###");
			p( "### was willst du machen? ###");
			p( "###      1. Angreifen     ###");
			p( "###       2. Essen        ###");
			p( "###        3. Nichts      ###");
			p();
			
			Antwort = eingabe.next();
			if (Antwort.equalsIgnoreCase("angreifen") || Antwort.equals("1")) {
				p( "# Du greifst mit einem Zauber den Magiestaub an!");
				punkte();
				
				if (chance(hero.getM())){
					p("Gut! Du hast den Magiestaub vernichtet! Es war ein Magiestaub voller Hass!");
					p("Es erscheinen zwei Zauberwichtel aus dem Staub! Sie sind dir sehr dankbar, dass du sie befreit hast!");
					p("2 Zauberwichtel schließen sich dir an!");
					hero.addM(40);
				} else {
					p("FAIL! Es ist ein freundlicher Magiestaub! Durch Magie wird dein Angriff auf dich selbst gewirkt!");
					hero.kampf(-hero.getA()*0.2,"Magiestaub");
				}

			} else if (Antwort.equalsIgnoreCase("essen") || Antwort.equals("2")) {
				p(" Streicheln! ");
				punkte();

				if (chance(95-50*malor(hero.getA(),500))) {
					red("=== Streicheln kommt gut an! ===");
					p("Der Kampfzwerg schliesst sich dir an!");
					p("Er holt sein Ninjaanzug und Katanas raus!");
					gegner.addA(20);
					gegner.addG(50);
				} else {
					red("* FAIL * Kampfzwerg ist zu scheu und rennt weg!");
					p("Du rennst ihm hinterher aber verlierst ihn."); warte(1000);
					p("Doch du findest eine abgebrochene Klinge auf dem Boden!"); warte(1000);
					hero.addA(10);
				}
			} else if (Antwort.equalsIgnoreCase("nichts") || Antwort.equals("3")) {
				p("Du tust nichts!");
				punkte();
				if (chance(50)) {
					p( "# Es ist ein freundlicher Magiestaub! Er kommt langsam zu dir und umarmt dich!");
					hero.addR(-0.1);
				} else {
					spezial("# Der Magiestaub ist voller Hass! Er greift dich an!"); warte (1000);
					p("Du rennst schnell weg! Ausdauer sinkt!"); warte(1000);
					p("Doch du findest eine abgebrochene Klinge auf dem Boden!"); warte(1000);
					hero.addA(10);
				}
			} else {
				p("FAIL");
			}
			
		} else if (RNG.chance(lboost)) {
			
			p( "### ********************* ###");
			p( "### ********************* ###");
			p( "### Lebenstrank gefunden! ###");
			p( "### ********************* ###");
			p( "### ********************* ###");
			p( "###                       ###");
			p( "### was willst du machen? ###");
			p( "###      1. Werfen        ###");
			p( "###       2. Trinken      ###");
			p();
			Antwort = eingabe.next();
			if (Antwort.equalsIgnoreCase("werfen") || Antwort.equals("1")) {
				p("Du nimmst all deine Kraft zusammen und wirfst den Trank!");
				punkte();
				if (chance(40+ 60*malor(hero.getG(),30))) {
					p( "# PATSCH! KLIRR! Trank trifft voll ins Gesicht!");
					gegner.reA(0.75);
					gegner.reG(0.75);
					gegner.kampf(-50*Hero.life,"Glassplitter");
				} else {
					p("*FAIL* -> Dein Trank verplatze auf den Boden!");
				}

			} else if (Antwort.equalsIgnoreCase("Trinken") || Antwort.equals("2")) {
				punkte();

				if (chance(75+25*malor(hero.getG(),20))) {
					red("- Lecker Trank! -");
					hero.kampf(50*Hero.life, "Heiltrank");
				} else {
					red(" DU TOLLPATSCH! Verschluckt! 50% des Tranks geht daneben!");
					hero.kampf(25*Hero.life, "Heiltrank");
				}
			} else {
				p("FAIL");
			}
		} else if (chance (0.000001)) {
			// hier endet die letzte else klammer
			// platz fuer mehr items!
		}


	}
}

