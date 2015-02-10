package main;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Scanner;

import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Itembox;
import miniheros.hero.Spell;
import miniheros.hero.Values;
import miniheros.util.*;
import miniheros.window.Fenster;

/* - 1 gegen 1 Kampfspiel -
 *  Author = Manuel Fischer (Mafima)
 *  Helper = Ferdl, Ohnename, Cobra_8
 * 
 * HELDEN ERSTELLEN HIER:  http://derpy.me/held
 */

public class MiniHeros extends Fenster {

	private static final long serialVersionUID = -4397649819156845507L; // unwichtig

	// Hero Objekte werden erstellt
	private static Hero hhero1;
	private static Hero hhero2;

	// Scanner laden fuer Eingabe
	// main methode
	public static void main(String[] args) throws IOException {
		new Fenster(); // Fenster wird erstellt

		// Erstellen der 2 Hero Objekte
		hhero1 = new Hero(0, 0, 0, 0, 0);
		hhero2 = new Hero(0, 0, 0, 0, 0);

		/*
		 *                          .=========================.
		 *                          |                         |
		 *                          |  ++  GAMECHANGE BOX  ++ |
		 *                          |                         |
		 *                          *=========================*
		 */
		
		int skipmuenze = 0; // Soll Muenzwurf uebersprungen werden? 0=nein 1=ja
		int quiz = 0;		// QUIZ aktiv = 1.    off= 0
		long timeout = 30000; // bestimme wie lang man zeit zum held nehmen hat!
		double heatset = 1.001; // setzt den anfangwerte
		Hero.life = 3; // Multipliziert das LEBEN aller Heldem um diesen Wert. Zu Testzwecken auf 3 gesetzt!

		Help.p("+++ DEV MODE +++");
		Help.p("ZAHLEN:      0            -       1      -         2           -         3-9          -      10-unendlich ");
		Help.p("MODUS::     normal   -   fixed    -  zufallsgame  -   speedgame   -   x games machen");
		Help.p(" ");
		Help.p("   ->     Geb eine Zahl ein!");
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
			Help.intro("- > > > > >     MiniHeros v 0.15    < < < < < -","-                    now recruiting Heros!                  -");
			Help.p(" ");
			Help.p(prefix + "Wie heisst du?");
			String antwort = eingabe.next();
			hhero1.setName(antwort);
			Help.p(prefix + "Wie heisst dein Gegner?");
			antwort = eingabe.next();
			hhero2.setName(antwort);


			// Wer faengt an?
			if (skipmuenze == 0) {
				if (Help.chance(50)) { // muenzwurf
					spielertmp = hhero1.getName(); // spielernamen werden getauscht wenn spieler 2 anfangen soll
					hhero1.setName(hhero2.getName());
					hhero2.setName(spielertmp);
				}
				Help.p(prefix + "Eine Muenze wurde geworfen!" + hhero1.getpName() + "faengt an!");
			}
		}

		if (dev > 0) {
			hhero1.setName("Manuel");
			hhero2.setName("David");
			if (dev == 1) {
				hhero1.setClassS(Classes.MENSCH);
				hhero2.setClassS(Classes.DRACHE);
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
				Help.p(prefix + "=====================================");
				Help.p(prefix + "Bereit?");
				String antwort = eingabe.next();
				while (antwort.equalsIgnoreCase("nein")) {
					Help.p("NAGUT!!! Ich frage in 3 Sekunden nochmal ! :D");
					Help.warte(3000);
					Help.p(prefix + "Bereit?");
					antwort = eingabe.next();
				}
				
			}

			// WER FAENGT AN?
			if (quiz>0 && dev < 2) { // falls quiz an ist, wird quiz gemacht!
				if(Quiz.quiz()) {
					kampf = 1;
				} else kampf = 2;
			} else {
				kampf = 1;
				Help.p(hhero1.getpName()+" darf den ersten Angriff machen!");
				if (Help.chance(50)) {
					kampf = 2; // Zufall wer Kampf beginnt!
					Help.p(hhero2.getpName()+" darf den ersten Angriff machen!");
				}
			}
			
			Help.p(prefix2,2);
			Help.p(prefix + "DER KAMPF BEGINNT!");
			Help.p(prefix2,2);
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
			Help.p(prefix1);Help.p(prefix2);Help.p(prefix3);
			if (hhero2.getL() <= 0) {
				Help.red(prefix + hhero1.getpName() + hhero1.getpClass() + "hat gewonnen!!!");
				changePOWERLEVEL(hhero1, hhero2);
				if (dev > 9) {
					win1++;
				}
			} else {
				Help.red(prefix + hhero2.getpName() + hhero2.getpClass() + "hat gewonnen!!!");
				changePOWERLEVEL(hhero2, hhero1);
				if (dev > 9) {
					win2++;
				}
			}
			Help.red(prefix + "********************||| E N D E |||**********************");

			// wiederholen? falls dev > 9 ist wiederholt er das game so oft wie dev gross ist.
			if (dev < 10) {
				i = dev + 1;
			}
		}
		if (dev >= 10) {
		Help.red("FULLEND");
		Help.red("FULLEND");
		Help.red("FULLEND");
		Help.red(prefix + hhero1.getpName() + hhero1.getpClass() + "hat " + win1 + " von " + (dev+1) + " Spiele gewonnen!!!");
		Help.red(prefix + hhero2.getpName() + hhero2.getpClass() + "hat " + win2 + " von " + (dev+1) + " Spiele gewonnen!!!");
	}}

	public static void anzleben(double anzlebvor, double anzleb, Hero hero) {
		for (double i = anzlebvor; i > anzleb && i > 0; i = i - (10 + (anzlebvor - anzleb) / 10)) {
			if (i < (anzlebvor - anzleb) / (10 + (anzlebvor - anzleb) / 10)) {
				Help.p("+KAMPF+" + hero.getpName() + "[ " + hero.getClassS() + " ] " + Math.ceil(anzleb) + " Leben :");
			} else {
				Help.print(" KAMPF -(=>" + hero.getpName() + "[" + hero.getClassS() + "] " + Math.ceil(i) + " Leben :");
			}
			Help.print("###");
			for (double i4 = 0; i4 < i; i4 = i4 + 50) {
				Help.print("-=");
			}
			Help.print("#");
			Help.p("||");
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
			Help.p("Netter Versuch, aber Illidan kannst du nicht nehmen, er is zu maechtig.");
		} else {
			Help.p(prefix + "Dieser Held wird bald spielbar sein! Versuch einen anderen!");
			TODOi++;
		}
	}

	public static void herowahl(Hero held, int dev, float time) {
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
		Help.p("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\",2);
		if (d == 0) {
			Itembox.roll(held, gegner);
		}
		
		int schaden = dmg(checkspell(held, gegner, d), held, MiniHeros.heat, gegner);
		Help.red(prefix + held.getpName() + held.getpClass() + " Schaden : " + schaden);

		// COOLDOWN
		
		// LEBENSANZEIGE
		double hlebenvorher = gegner.getL(); // zwischenspeicher fuer lebensanzeige
		gegner.setL(gegner.getL() - schaden);
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

	public static int checkspell(Hero held, Hero gegner, int d) throws IOException {
		Scanner eingabe = new Scanner(System.in);
		int inputspell = -1;
		long t1 = System.currentTimeMillis();

		if (d > 1) {
			Help.p("HEAT:" + heat);
			while (inputspell == -1) {
				inputspell = (int) Math.ceil(Math.random() * held.getSpellSize());
				Help.p("### SPELL AUTO: "+inputspell);
				Spell spell = held.getspell(inputspell);
				spell.changecd(-1);
				if(spell.checkall(held)) inputspell = -1;
			}
			if (d < 10) Help.warte(3000/d);
		} else {
			while (inputspell == -1) {
				
				Help.p(); Help.print(prefix + held.getpName() + held.getpClass()+ " Womit angreifen?  ");
				for (int i = 1; i < held.getSpellSize() + 1; i++) {
					Help.print("      > " + i + " : " + held.getspell(i).getSpellname());
				}
				System.out.println("");
				
				inputspell = eingabe.nextInt();

				if (inputspell <= 0 || inputspell > held.getSpellSize()) {
					Help.red(prefix + " Der Held von " + held.getpName() + " ist beleidigt! Held: Kannst du nicht mal ne Zahl von 1-" + held.getSpellSize() + " druecken ?!");
					Help.warte(1000);
					inputspell = -1;
				} else {
					Spell spell = held.getspell(inputspell);
					if(spell.checkall(held)) inputspell = -1;
				}
				
			}
		}
		long changetime = ((t1-System.currentTimeMillis())/1000);
		gegner.cdchangeall(changetime);
		return inputspell;
	}

	public static int dmg(int i, Hero h, double heat, Hero g) {

		if (heat > 2) {
			MiniHeros.heat = heat + 0.1; // Jede Runde erhoeht sich der Schaden um 10%
		} else {
			MiniHeros.heat = heat * heat;
		}
		return (int) Math.ceil(g.getres() * (heat) * h.getspell(i).cast(h, g));

		/*      SPECIALSAVE
		 *


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

		Help.p(prefix + "###====|| " + hhero.getpName() + hhero.getpClass() + " ||====###");
		Help.p(prefix);
		Help.print(prefix + "### - Angriff: " + hhero.getA() + "         -(=");
		for (int i = 0; i < hhero.getA(); i = i + 20) {
			Help.print("==");
		}
		Help.p(">");
		Help.p(prefix + "### - Geschick: " + hhero.getG() + "        >>>");
		Help.p(prefix + "### - Hirn: " + hhero.getH() + "             [#Hirn#]");
		Help.print(prefix + "### - Zauberkraft: " + hhero.getM() + "    < ");
		for (int i = 0; i < hhero.getM(); i = i + 30) {
			Help.print("~~");
		}
		Help.p("~");
		Help.print(prefix + "### - Leben: " + hhero.getL() + "          [[");
		for (int i = 0; i < hhero.getL(); i = i + 100) {
			Help.print(":");
		}
		Help.p("]]");
		Help.p(prefix);
		superprefix = "null";

		Help.print(prefix + "#// ZAUBER \\# -  ");
		for (int i = 1; i <= hhero.getSpellSize(); i++) {
			Help.print("Taste " + (i) + ": " + hhero.getspell(i).getSpellname() + " || ");
		}
		Help.p();
		Help.p("*----------------------------------*");

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
	public static int dev;
	public static double hchange, h2change;
	public static double hangriff, h2angriff;
	public static double hleben, h2leben;
	public static double hgeschick, h2geschick;
	public static double hhirn, h2hirn;
	public static double hmagie, h2magie;
	public static double heat;
	public static int kampf;



	public static double hrandom = (double) Math.ceil(3 * Math.random()) * 0.15 + 0.8;
	public static double hrandom2 = (double) Math.ceil(3 * Math.random()) * 0.16 + 0.82;
	
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
