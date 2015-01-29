package HeroPack;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

/* Erfinder = "Manuel Fischer" aka Mafima
 *
 * - 1 gegen 1 Kampfspiel -
 *
 * Heldenanzahl: ~30
 * 
 * HELDEN ERSTELLEN HIER:  http://derpy.me/held
 *
 */

public class MiniHeros extends JFrame implements ActionListener, KeyListener {

	private static final long serialVersionUID = -4397649819156845507L; // unwichtig

	// Hero Objekte werden erstellt
	private static Hero hhero1;
	private static Hero hhero2;

	// Fenster wird initialisiert
	private static ModifiedJEditorPane log;
	private JTextField prompt;
	private JLabel Logo;
	private JButton button2;

	private final PipedInputStream inPipe = new PipedInputStream();
	private final PipedInputStream outPipe = new PipedInputStream();
	private PrintWriter inWriter;

	// Scanner laden fuer Eingabe
	// main methode
	public static void main(String[] args) throws IOException {
		// Fenster
		new MiniHeros();

		// Erstellen der 2 Hero Objekte
		setHhero1(new Hero(0, 0, 0, 0, 0));
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

		log.append(Color.RED, " DEV?"); // color test
		p("+++ DEV MODE +++");
		p("ZAHLEN:      0            -       1      -         2           -         3-9          -      10-unendlich ");
		p("MODUS::     normal   -   fixed    -  zufallsgame  -   speedgame   -   x games machen");
		p(" ");
		p("   ->     Geb eine Zahl ein!");
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
			intro("- > > > > >     MiniHeros v 0.15    < < < < < -","-                    now recruiting Heros!                  -");
			p(" ");
			p(prefix + "Wie heisst du?");
			String antwort = eingabe.next();
			getHhero1().setName(antwort);
			p(prefix + "Wie heisst dein Gegner?");
			antwort = eingabe.next();
			hhero2.setName(antwort);


			// Wer faengt an?
			if (skipmuenze == 0) {
				if (chance(50)) { // muenzwurf
					spielertmp = getHhero1().getName(); // spielernamen werden getauscht wenn spieler 2 anfangen soll
					getHhero1().setName(hhero2.getName());
					hhero2.setName(spielertmp);
				}
				p(prefix + "Eine Muenze wurde geworfen!" + getHhero1().getpName() + "faengt an!");
			}
		}

		if (dev > 0) {
			getHhero1().setName("Manuel");
			hhero2.setName("David");
			if (dev == 1) {
				getHhero1().setClassS(Classes.MENSCH);
				hhero2.setClassS(Classes.ZOMBIE);
			}
			if (dev > 1) {
				herowahlrandom(getHhero1(), hhero2);
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

			herowahl(getHhero1(), dev, timeout);
			herowahl(hhero2, dev, timeout);

			// HEROS GEWAEHLT. 
			if (dev == 0) {
				p(prefix + "=====================================");
				p(prefix + "Bereit?");
				String antwort = eingabe.next();
				if (antwort.equalsIgnoreCase("nein")) {
					p("NAGUT!!! Ich frage in 3 Sekunden nochmal ! :D");
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}


			MiniHeros.kampf = 1;

			// WER FAENGT AN?
			if (quiz>0) { // falls quiz an ist, wird quiz gemacht!
				if(Quiz.quiz()) {
					kampf = 1;
				} else kampf = 2;
			} else {
				if (chance(50)) {
					kampf = 2; // Zufall wer Kampf beginnt!
				}
			}
			
			p(prefix2,2);
			p(prefix + "DER KAMPF BEGINNT!");
			p(prefix2);
			p(prefix2);
			
			/////////////// KAMPF /////////////////////////////////////////////////////////////////
			///////////////////////////////////////////////////////////////////////////////////////
			///////////////////////////////////////////////////////////////////////////////////////
			
			while (getHhero1().getL() > 0 && hhero2.getL() > 0) {
				if (kampf == 1) {
					kampf(getHhero1(), hhero2, dev);
				}
				if (kampf == 2) {
					kampf(hhero2, getHhero1(), dev);
				}
			}

			// END ><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><
			// ><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><
			p(prefix1);
			p(prefix2);
			p(prefix3);
			if (hhero2.getL() <= 0) {
				r(prefix + getHhero1().getpName() + getHhero1().getpClass() + "hat gewonnen!!!");
				changePOWERLEVEL(getHhero1(), hhero2);
				if (dev > 9) {
					win1++;
				}
			} else {
				r(prefix + hhero2.getpName() + hhero2.getpClass() + "hat gewonnen!!!");
				changePOWERLEVEL(hhero2, getHhero1());
				if (dev > 9) {
					win2++;
				}
			}
			r(prefix + "********************||| E N D E |||**********************");

			// wiederholen? falls dev > 9 ist wiederholt er das game so oft wie dev gross ist.
			if (dev < 10) {
				i = dev + 1;
			}
		}
		r("FULLEND");
		r("FULLEND");
		r("FULLEND");
		r(prefix + getHhero1().getpName() + getHhero1().getpClass() + "hat " + win1 + " von " + dev + " Spiele gewonnen!!!");
		r(prefix + hhero2.getpName() + hhero2.getpClass() + "hat " + win2 + " von " + dev + " Spiele gewonnen!!!");
	}

	public static void anzleben(double anzlebvor, double anzleb, Hero hero) {
		for (double i = anzlebvor; i > anzleb && i > 0; i = i - (10 + (anzlebvor - anzleb) / 10)) {
			if (i < (anzlebvor - anzleb) / (10 + (anzlebvor - anzleb) / 10)) {
				p(prefix + "+KAMPF+" + hero.getpName() + "[ " + hero.getClassS() + " ] " + Math.ceil(anzleb) + " Leben :");
			} else {
				print(prefix + " KAMPF -(=>" + hero.getpName() + "[" + hero.getClassS() + "] " + Math.ceil(i) + " Leben :");
			}
			print("###");
			for (double i4 = 0; i4 < i; i4 = i4 + 50) {
				print("-=");
			}
			print("#");
			p("||");
		}
	}

	public static void itembox(Hero hero, Hero gegner) throws IOException {
		Scanner eingabe = new Scanner(System.in);
		String Antwort = null;

		if (chance(1)) {
			p(prefix + "### /37283/$%4684564/$7$584385//68347#74745// ###");
			p(prefix + "###   Schwarze Box des Untergangs gefunden!   ###");
			p(prefix + "### /37283/$%4684564/$7$584385//68347#74745// ###");
			p(prefix + "###                       ###");
			p(prefix + "### was willst du machen? ###");
			p(prefix + "###      1. Verkaufen     ###");
			p(prefix + "###       2. Oeffnen       ###");
			p(prefix + "###        3. Essen       ###");
			Antwort = eingabe.next();
			if (Antwort.equalsIgnoreCase("Verkaufen") || Antwort.equals("1")) {
				p(prefix + "###        Schwarze Box verkauft!       ###");
				p(prefix + "OH MEIN GOTT! Der Haendler ist bei Beruehrung mit der Box gestorben!");
				p(prefix + "Willst du sein Haus ausrauben?");
				Antwort = eingabe.next();
				if (Antwort.equalsIgnoreCase("ja")) {
					p(prefix + "### Du herzloser Wicht! ###");
					p(prefix + "Ein Priester hat dich entdeckt! 50 Schaden durch Herzlosigkeit!");
					hero.kampf(-50);
					p(prefix + "Elfische Streitaxt gefunden! Angriff um 70 erhöht!");
					hero.setA(hero.getA() + 70);
				} else if (Antwort.equalsIgnoreCase("nein")) {
					p(prefix + "### Mitgefuehlbonus! ###");
					p(prefix + "Ein Prister erkennt dein Mitgefuehl und heilt dich um 400 Leben !");
					hero.kampf(400);
				} else {
					p(prefix + "Du hast versagt ja oder nein einzugeben.");
					p(prefix + "Dummheitsbonus! 50 Schaden!");
					hero.kampf(-50);
				}
			} else if (Antwort.equalsIgnoreCase("oeffnen") || Antwort.equals("2")) {
				int x = (int) Math.random() * 3 + 1;
				if (x == 1) {
					hero.setL(hero.getL() + hero.getM());
					hero.setA(hero.getA() + hero.getM());
					hero.setM(0);
					p(prefix + "Schwarze Box entzieht dir all deine Magie und wandelt sie in Angriff und Leben um!");
				} else if (x == 2) {
					hero.setA(hero.getA() * 0.8);
					hero.setG(hero.getG() * 0.8);
					hero.kampf(-200);
					gegner.kampf(-200);
					p(prefix + "3$)294 Schwarze Box explodiert! 3)324=");
					p(prefix + "Die Explosion fuegt beiden Helden 200 Schaden zu! Ausserdem senkt sich dein Angriff und Geschick um 20%");
				} else {
					hero.setM(666 + hero.getM());
					hero.kampf(200);
					p(prefix + "In der schwarzen Box findest du einen winzigen Magier");
					p(prefix + "Er heilt dich um 200 und kaempft nun fuer dich! Magie steigt auf: " + hero.getM());
				}
			} else if (Antwort.equalsIgnoreCase("essen") || Antwort.equals("3")) {
				p(prefix + "Du isst die dunkle Box mit Messer und Gabel. Es schmeckt hart und nach dunkler Magie.");

				if (chance(20)) {
					hero.setClassS(Classes.ULTIMATEFORM);
					hero.addDefaultValues(Classes.ULTIMATEFORM);
					r(prefix + "/// RIESIGE EXPLOSION! ///");
					r(prefix + "Du wirst zu Illidan, dem Herrscher der Finsterniss!");
					werteanz(hero);
				} else {
					hero.setL(hero.getL() * 0.8);
					p(prefix + "Verwandlung fehlgeschlagen. Du verlierst 20% deines Lebens!");
				}
			} else {
				hero.kampf(-50);
				p(prefix + "50 Schaden durch Dummheit");
			}
		}
		if (chance(1)) {
			p(prefix + "### ********************* ###");
			p(prefix + "### ********************* ###");
			p(prefix + "###   Diamant gefunden!   ###");
			p(prefix + "### ********************* ###");
			p(prefix + "### ********************* ###");
			p(prefix + "###                       ###");
			p(prefix + "### was willst du machen? ###");
			p(prefix + "###      1. Verkaufen     ###");
			p(prefix + "###       2. Werfen       ###");
			p(prefix + "###        3. Essen       ###");
			Antwort = eingabe.next();
			if (Antwort.equalsIgnoreCase("Verkaufen") || Antwort.equals("1")) {
				hero.setA(hero.getA() * 2);
				hero.setL(hero.getL() + 1500);
				hero.setG(hero.getG() * 0.75);
				p(prefix + "# Diamant verkauft und davon Waffen und Ruestung gekauft! Die Ruestung ist schwer.");
				p(prefix + "Angriff: " + hero.getA());
				p(prefix + "Geschick: " + hero.getG());
				p(prefix + "Leben: " + hero.getL());
			} else if (Antwort.equalsIgnoreCase("Werfen") || Antwort.equals("2")) {
				p("/***/ Diamantwurf /***/");
				p("Dein Held holt aus und wirft mit aller Kraft!!!");
				punkte();
				p("Der Diamant fliegt mit so hoher Geschwindigkeit, dass er die Schallmauer durchbricht und deinen Gegner betaeubt!!");
				gegner.reG(0.7);
				gegner.reA(0.7);
				if (chance(100 * hero.getG() / (hero.getG() + 50))) {
					r("=== kritischer TREFFER! ===");
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
					p(prefix + "# Deine Gabel zerbricht. Du wirfst den Diamant in deinen Mund und schluckst. " + hero.getpName() + " verliert 400 Leben.");
				} else {
					int heilung = (int) ((int) 6 * heat);
					heilung *= 100;
					hero.kampf(+heilung);
					p(prefix + "# Der Diamant war schmackhaft! Sehr Knusprig." + hero.getpName() + "hat nun " + heilung + " Leben mehr!");
					hero.reM(1.5);
				}
			} else {

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
			p("Netter Versuch, aber Illidan kannst du nicht nehmen, er is zu maechtig.");
		} else {
			p(prefix + "Dieser Held wird bald spielbar sein! Versuch einen anderen!");
			TODOi++;
		}
	}

	public static void herowahl(Hero held, int dev, float time) {
		Scanner antworter = new Scanner(System.in);
		if (dev == 0) {
			p(prefix + "Du hast " + time / 1000 + " Sekunden Zeit! Sei kreativ!");
		}

		long t1 = System.currentTimeMillis(); // Zeit zaehlen beginnt
		while (held.getClassS() == null) {
			r(prefix + "Welcher Held willst du,  " + held.getName() + " sein?");
			String antwort = antworter.next();

			// Hero wird gelesen
			// AUSNAHMEHELDEN:
			if (antwort.equalsIgnoreCase("nein")) {
				p(prefix + "Du hast Nein eingegeben. Bist du bescheuert?");
				antwort = antworter.next();
				if (antwort.equalsIgnoreCase("ja")) {
					p(prefix + "Sicher dass du bescheuert bist?");
					antwort = antworter.next();
					if (antwort.equalsIgnoreCase("ja")) {
						p(prefix + "Nimm deinen Held! Letzte Chance, sonst stirbst du!");
						antwort = antworter.next();
						if (antwort.equalsIgnoreCase("nein")) {
							antwort = "NEINHEIT";
						} else {
							p(prefix + "oke gut!");
							p(prefix + "Welchen Held waehlt " + held.getpName() + "?");
						}
					} else {
						p(prefix + "oke gut!");
						p(prefix + "Welchen Held waehlt " + held.getpName() + "?");
					}
				} else {
					p(prefix + "oke gut!");
					p(prefix + "Welchen Held waehlt " + held.getpName() + "?");
				}
			}
			if ((System.currentTimeMillis() - t1) > time) {  // falls zu lange gebraucht wird Held "mensch" genommen
				r(prefix + "Zeit abgelaufen! Du bist jetzt ein Mensch!!!");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				antwort = "mensch";
			}

			// ANTWORT WIRD IN HELD FALLS HELD IN DB IST!
			antwortDB(antwort, held);
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
		p("=====================================");
		if (d == 0) {
			itembox(gegner, held);
		}
		int inputspell = checkspell(held, gegner, d);
		held.setdmg(dmg(inputspell, held, MiniHeros.heat, gegner));
		r(prefix + held.getpName() + held.getpClass() + " Schaden : " + held.getdmg());

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

		if (d > 0) {
			p("HEAT:" + heat);
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
				p();
				print(prefix + held.getpName() + " Welchen Angriff? 1-" + held.getSpellSize());
				for (int i = 1; i < held.getSpellSize() + 1; i++) {
					print("  > " + i + ": " + held.getspell(i).toString());
				}
				p("");
				inputspell = eingabe.nextInt();

				if (inputspell <= 0 || inputspell > held.getSpellSize()) {
					r(prefix + " Der Held von " + held.getpName() + " ist beleidigt! Held: Kannst du nicht mal ne Zahl von 1-" + held.getSpellSize() + " druecken ?!");
				}
			}
			/*
             COOLDOWN VERSUCH....
             p(held.realcooldowns[inputspell-1]); // DEBUG
             if (held.realcooldowns[inputspell-1] > 0) {
             r(prefix + " Der Held von "+held.getpName()+" muss sich erst "+held.realcooldowns[inputspell-1]+" Zuege ausruhen! Nimm nen anderen Zauber!");
             p("");
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
         p(prefix + hhero1.getpName() + hero1+ "zaehlt alle Stellen von Pi auf! "+ Math.ceil((hhirn - h2hirn)*0.2 + 400)+" Schaden!");
         p(prefix + "90% der Gehirnzellen wurden gebraten!");
         } else if (hirnevent > 99) {
         double hdmgh = (hhirn - h2hirn)*0.2 + 20;
         hdmg = hdmg + hdmgh; p(prefix + hhero1.getpName() + Math.ceil((hhirn - h2hirn)*0.2 + 70) +" Schaden durch Matheunterricht!");
         } else if (hirnevent > 30) {
         double hdmgh = (hhirn - h2hirn)*0.2 + 20; hdmg = hdmg + hdmgh ;
         p(prefix + hhero1.getpName() + Math.ceil(hdmgh) +" Schaden durch Überheblichkeit verursacht!");
         }
         }

         double critevent = (double) (hgeschick)*Math.random();
         if (critevent > 200) {
         hdmg = hdmg*3; p(prefix + hhero1.getpName() + Math.ceil(hdmg*2) + " ");
         } else if (critevent > 99) {
         hdmg = hdmg + (hhirn - h2hirn)*0.2 + 60; p(prefix + hhero1.getpName() + Math.ceil((hhirn - h2hirn)*0.2 + 70) +" Schaden durch Matheunterricht!");
         } else if (critevent > 30) {
         hdmg = hdmg + (hhirn - h2hirn)*0.2 + 20; p(prefix + hhero1.getpName() + Math.ceil((hhirn - h2hirn)*0.2 + 20) +" Schaden durch Überheblichkeit verursacht!");
         }

         double ausweichevent = (double) (h2geschick)*Math.random();
         if (ausweichevent > 100 ) {
         hdmg = hdmg*((hgeschick)*0.2) -20; p(prefix + hhero1.getpName() + Math.ceil((hhirn - h2hirn)*0.2 + 400)+" Schaden durch praezisen Steinwurf auf Dummkopf!");
         } else if (ausweichevent > 99) {
         hdmg = hdmg*(0.7*(hgeschick)); p(prefix + hhero1.getpName() + Math.ceil((hhirn - h2hirn)*0.2 + 20) +" Schaden durch Überheblichkeit verursacht!");
         }


         double critchance = 0.1 + (Math.pow((hgeschick/400),2) + Math.pow((hhirn/400),2))*0.9;
         double chance = 0.7 - (0.3*Math.pow((hgeschick/100),2)) ;

         double fail = (double) (Math.random() * (1 - chance));
         double mittel = (double) (Math.random() * chance);
         double kritisch = (double) (Math.random() * critchance);

         if (kritisch > fail && kritisch > mittel) {
         // p("Du bekommst ein Diamantschwert");
         kritisch =1;
         } else if (mittel > fail && mittel > kritisch) {
         // p("Du bekommst ein Goldschwert");
         mittel =1;
         } else {
         // p("Du bekommst ein Steinschwert");
         fail = 1;
         }
		 *
		 */
	}

	public static void werteanz(Hero hhero) {
		// KAMPFWERTE AUSGABE

		p(prefix + "###====|| " + hhero.getpName() + hhero.getpClass() + " ||====###");
		p(prefix);
		print(prefix + "### - Angriff: " + hhero.getA() + "         -(=");
		for (int i = 0; i < hhero.getA(); i = i + 20) {
			print("==");
		}
		p(">");
		p(prefix + "### - Geschick: " + hhero.getG() + "        >>>");
		p(prefix + "### - Hirn: " + hhero.getH() + "             [#Hirn#]");
		print(prefix + "### - Zauberkraft: " + hhero.getM() + "    < ");
		for (int i = 0; i < hhero.getM(); i = i + 30) {
			print("~~");
		}
		p("~");
		print(prefix + "### - Leben: " + hhero.getL() + "          [[");
		for (int i = 0; i < hhero.getL(); i = i + 100) {
			print(":");
		}
		p("]]");
		p(prefix);
		superprefix = "null";

		print(prefix + "#// ZAUBER \\# -  ");
		for (int i = 1; i <= hhero.getSpellSize(); i++) {
			print("Taste " + (i) + ": " + hhero.getspell(i) + " || ");
		}
		p();
		p("*----------------------------------*");

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
	 *                          |  NUETZLICHE FUNKTIONEN  |
	 *                          |                         |
	 *                          *=========================*
	 *
	 */

	public static void warte(long zeit) {
			p("");
			try {
				Thread.sleep(zeit);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
	}
	
	public static void punkte() {
		for (int i = 0; i < 3; i++) {
			p("");
			for (int j = 0; j < i; j++) {
				print(".");
			}
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void punkte(int punkte, long zeit) {
		for (int i = 0; i < punkte; i++) {
			p("");
			for (int j = 0; j < i; j++) {
				print(".");
			}
			try {
				Thread.sleep(zeit);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void p() {
		System.out.println(" ");
	}
	public static void p(String text) {
		System.out.println(text);
	}
	public static void p(String text, int z) {
		while (z>0) {
			System.out.println(text); 
			z--;
			}
	}
	public static void print(String text) {
		System.out.print(text);
	}
	public static void print(String text, int z) {
		while (z>0) {
			System.out.print(text); 
			z--;
			}
	}
	public static void r(String text) {
		System.out.println("###>>>>> " + text);
	}
	public static void intro(String x, String y) {
		p(prefix1); p(prefix2); p(prefix3);
		p(x); p(y);
		p(prefix3); p(prefix2); p(prefix1);
	}
	
	public static boolean chance(double prozent) {
		return Math.ceil(Math.random() * (100 / prozent)) == 1 || prozent > 100;
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
	public MiniHeros() {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		this.log = new ModifiedJEditorPane();//(50, 20);
		log.setSize(50, 20);
		this.prompt = new JTextField();

		System.setIn(inPipe);
		try {
			System.setOut(new PrintStream(new PipedOutputStream(outPipe), true));
			inWriter = new PrintWriter(new PipedOutputStream(inPipe), true);
		} catch (IOException e) {
			p("Error: " + e);
			return;
		}

		PrintStream printstream = new PrintStream(new ModifiedOutputStream(log));
		System.setErr(printstream);

		(new SwingWorker<Void, String>() {
			protected Void doInBackground() throws Exception {
				Scanner s = new Scanner(outPipe);
				while (s.hasNextLine()) {
					String line = s.nextLine();
					publish(line);
				}
				return null;
			}

			@Override
			protected void process(java.util.List<String> chunks) {
				for (String line : chunks) {
					if (line.length() < 1) {
						continue;
					}

					Document doc = log.getDocument();
					try {
						doc.insertString(doc.getLength(), line.trim() + "\n", null);
					} catch (BadLocationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					//log.append(line.trim() + "\n"); 
				}
			}
		}).execute();

		this.setTitle("MiniHeros 0.15");
		this.setSize(1035, 680);
		this.setLayout(null);
		// ICON SETZEN: setContentPane(new JLabel(new ImageIcon("C:\\Users\\Manuel\\Documents\\GitHub\\MiniHeros\\src\\HeroPack\\server-icon.png")));
		setContentPane(new JLabel());
		Logo = new JLabel();

		JScrollPane scrollpane = new JScrollPane(log);
		scrollpane.setBounds(10, 10, 1000, 380);
		log.setBackground(Color.DARK_GRAY);
		log.setForeground(Color.white);
		prompt.setBackground(Color.DARK_GRAY);
		prompt.setForeground(Color.cyan);
		this.setBackground(Color.GRAY);

		this.button2 = new JButton("+10% auf alle Werte!");

		this.log.setEditable(false);
		this.log.setBounds(10, 10, 1220, 600);
		this.prompt.setBounds(10, 400, 500, 20);
		this.Logo.setBounds(120, 520, 260, 40);
		this.button2.setBounds(520, 400, 260, 40);
		this.button2.addActionListener(this);

		this.setVisible(true);
		this.add(Logo);
		this.add(button2);

		prompt.addKeyListener(this);

		this.add(scrollpane);
		this.add(prompt);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void execute() {
		String text = prompt.getText();
		prompt.setText("");
		p(text);
		inWriter.println(text.trim().replaceAll("\r\n", ""));
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		/*if(e.getSource() == Logo) {
         log.setText("Jesus");
         } else if(e.getSource() == button2) {
         log.setText("Gott");
         }
		 */
		p("looooooool");
		getHhero1().reA(1.1);
		getHhero1().reG(1.1);
		getHhero1().reH(1.1);
		getHhero1().reM(1.1);
		getHhero1().reL(1.1);
		getHhero1().reR(1.1);
		p("looooooool");
		hhero2.reA(1.1);
		hhero2.reG(1.1);
		hhero2.reH(1.1);
		hhero2.reM(1.1);
		hhero2.reL(1.1);
		hhero2.reR(1.1);
		p("looooooool");
	}

	@Override
	public void keyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			execute();
		}

	}

	@Override
	public void keyReleased(KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			execute();
		}
	}

	@Override
	public void keyTyped(KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			execute();
		}
	}

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
}
