package main;

import java.io.IOException;
import java.util.Scanner;

import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Herowahl;
import miniheros.hero.Itembox;
import miniheros.hero.Spell;
import miniheros.hero.Values;
import miniheros.util.*;
import miniheros.window.Fenster;
import static miniheros.util.Help.*;

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
	public static Scanner eingabe;

	// Scanner laden fuer Eingabe
	// main methode
	public static void main(String[] args) throws IOException {
		new Fenster(); // Fenster wird erstellt
		eingabe = new Scanner(System.in);

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
		double heatset = 1.0002; // setzt den anfangwerte
		Hero.life = 3; // Multipliziert das LEBEN aller Heldem um diesen Wert. Zu Testzwecken auf 3 gesetzt!
		
		// intro
		Intro.play(skipmuenze);

		int win1 = 0; int win2 = 0;
		for (int i = 0; i <= dev; i++) { // wiederholt falls dev
			MiniHeros.heat = heatset;

			Herowahl.wahl(hhero1, dev, timeout);
			Herowahl.wahl(hhero2, dev, timeout);

			// HEROS GEWAEHLT.
			if (dev == 0) {
				p(prefix + "=====================================");
				p(prefix + "Bereit?");
				String antwort = eingabe.next();
				while (antwort.equalsIgnoreCase("nein")||antwort.equalsIgnoreCase("weiss nicht")||antwort.equalsIgnoreCase("ne")||antwort.equalsIgnoreCase("nee")||antwort.equalsIgnoreCase("neee")||antwort.equalsIgnoreCase("keine ahnung")) {
					p("NAGUT!!! Ich frage in 3 Sekunden nochmal ! :D");
					warte(3000);
					p(prefix + "Bereit?");
					antwort = eingabe.next();
					p("hiii");
				}
			}

			// WER FAENGT AN?
			if (quiz==1 && dev < 2) { // falls quiz an ist, wird quiz gemacht!
				if(Quiz.quiz()) {
					kampf = 1;
				} else kampf = 2;
			} else {
				
				if (chance(50)) {
					kampf = 2; // Zufall wer Kampf beginnt!
					p(hhero2.getpName()+" darf den ersten Angriff machen!");
				} else {
					kampf = 1;
					p(hhero1.getpName()+" darf den ersten Angriff machen!");
				}
			}
			
			p(prefix2,2);
			p("DER KAMPF BEGINNT!");
			p(prefix2,2);
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
			p(prefix1);p(prefix2);p(prefix3);
			if (hhero2.getL() <= 0) {
				red(hhero1.getpName() + hhero1.getpClass() + "hat gewonnen!!!");
				changePOWERLEVEL(hhero1, hhero2);
				if (dev > 9) {
					win1++;
				}
			} else {
				red(hhero2.getpName() + hhero2.getpClass() + "hat gewonnen!!!");
				changePOWERLEVEL(hhero2, hhero1);
				if (dev > 9) {
					win2++;
				}
			}
			red("********************||| E N D E |||**********************");

			// wiederholen? falls dev > 9 ist wiederholt er das game so oft wie dev gross ist.
			if (dev < 10) {
				i = dev + 1;
			}
		}
		if (dev >= 10) {
		red("FULLEND");
		red("FULLEND");
		red("FULLEND");
		red(hhero1.getpName() + hhero1.getpClass() + "hat " + win1 + " von " + (dev+1) + " Spiele gewonnen!!!");
		red(hhero2.getpName() + hhero2.getpClass() + "hat " + win2 + " von " + (dev+1) + " Spiele gewonnen!!!");
	}}


	public static void kampf(Hero held, Hero gegner, int d) throws IOException {
		p("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\",2);
		if (d == 0) Itembox.roll(held, gegner);
		
		if (heat < 2) {
			heat = heat * heat;
		if (heat > 2) heat = 2;
		}
		else heat = heat + 0.2; // falls heat ueber 2 ist wird der schaden nur noch
		
		int schaden;
		double s = gegner.getres() * (heat) * held.getspell(checkspell(held, gegner, d)).cast(held, gegner);
		// schaden wird gerundet!
		if (s >= 1000) {
			s *= 0.01;
			schaden = (int) Math.round(s);
			schaden *= 100;
		} else if (s >= 100) {
			s *= 0.1;
			schaden = (int) Math.round(s);
			schaden *= 10;
		} else if (s >= 50) {
			s *= 0.05;
			schaden = (int) Math.round(s);
			schaden *= 5;
		} else {
			schaden = (int) Math.round(s);
		}
		
		Help.red(prefix + held.getpName() + held.getpClass() + " Schaden : " + schaden);

		// COOLDOWN
		
		// LEBENSANZEIGE
		double hlebenvorher = gegner.getL(); // zwischenspeicher fuer lebensanzeige
		gegner.setL(gegner.getL() - schaden);
		Anzeigen.leben(hlebenvorher, gegner.getL(), gegner);

		if (kampf == 2) {
			kampf--;
		} else {
			kampf++;
		}
		if (gegner.getL() <= 0 || held.getL() <= 0) {
			MiniHeros.kampf = 0;
		}
	}

	/*      SPECIALSAVE
	 *
	 *
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

	public static int checkspell(Hero held, Hero gegner, int d) throws IOException {
		Scanner eingabe = new Scanner(System.in);
		int inputspell = -1;
		long t1 = System.currentTimeMillis();

		if (d > 1) {
			p("HEAT:" + heat);
			while (inputspell == -1) {
				inputspell = (int) Math.ceil(Math.random() * held.getSpellSize());
				p("### SPELL AUTO: "+inputspell);
				Spell spell = held.getspell(inputspell);
				spell.changecd(-7);
				if(spell.checkall(held)) inputspell = -1;
			}
			if (d < 10) warte(5000/d);
		} else {
			while (inputspell == -1) {
				
				p(); pnext(prefix + held.getpName() + held.getpClass()+ " Womit angreifen?  ");
				for (int i = 1; i < held.getSpellSize() + 1; i++) {
					pnext("      > " + i + " : " + held.getspell(i).getSpellname());
				}
				System.out.println("");
				
				inputspell = eingabe.nextInt();

				if (inputspell <= 0 || inputspell > held.getSpellSize()) {
					red(prefix + " Der Held von " + held.getpName() + " ist beleidigt! Held: Kannst du nicht mal ne Zahl von 1-" + held.getSpellSize() + " druecken ?!");
					warte(1000);
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
