package main;

import static miniheros.util.Help.*;
import static main.Textarena.*;

import java.io.IOException;

import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Herowahl;
import miniheros.hero.Itembox;
import miniheros.hero.Spell;
import miniheros.hero.Values;
import miniheros.util.Anzeigen;
import miniheros.util.Help;
import miniheros.util.Round;

public class Game {

	public static void start (Hero hhero1, Hero hhero2) throws IOException {
		
		int win1 = 0; int win2 = 0; // setzt wins auf 0. (nur bei dev>=10 gebraucht!)
		for (int i = 0; i <= dev; i++) { // wiederholt falls dev >= 10

			heat = heatset; // kampfhitze wird resettet!

			Herowahl.wahl(hhero1, dev, timeout); // Heros werden gesetzt
			Herowahl.wahl(hhero2, dev, timeout);

			bereit(); // es wird gefragt ob man bereit ist.

			whostarts(); // WER FAENGT AN?
			
			/////////////// KAMPF /////////////////////////////////////////////////////////////////
			///////////////////////////////////////////////////////////////////////////////////////

			while (hhero1.getL() > 0 && hhero2.getL() > 0) {
				if (kampf == 1) {
					kampf(hhero1, hhero2);
				}
				else if (kampf == 2) {
					kampf(hhero2, hhero1);
				}
			}

			// DEAD...
			// END ><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><
			// ><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><
			if (hhero2.getL() <= 0) {
				red(hhero1.getpName() + hhero1.getpClass() + "hat gewonnen!!!");
				changePOWERLEVEL(hhero1, hhero2);
				if (dev > 9) {
					win1++;
				}
			} else {
				red(hhero2.getpName() + hhero2.getpClass() + "hat gewonnen!!! yaaaaaaay");
				changePOWERLEVEL(hhero2, hhero1);
				if (dev > 9) {
					win2++;
				}
			}
			red(")))********************||| E N D E |||**********************(((");

			// wiederholen? falls dev > 9 ist wiederholt er das game so oft wie dev gross ist.
			if (dev < 10) {
				i = dev + 1;
			}
		}
		if (dev >= 10) {
			red("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+ FULLEND +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
			red(hhero1.getpName() + hhero1.getpClass() + "hat " + win1 + " von " + (dev + 1) + " Spiele gewonnen!!!");
			red(hhero2.getpName() + hhero2.getpClass() + "hat " + win2 + " von " + (dev + 1) + " Spiele gewonnen!!!");
		}
	}

	private static void bereit() {
		if (dev == 0) {
			p(prefix + "=====================================");
			p(prefix + "Bereit?");
			String antwort = eingabe.next();
			while (antwort.equalsIgnoreCase("nein") || antwort.equalsIgnoreCase("weiss nicht") || antwort.equalsIgnoreCase("ne") || antwort.equalsIgnoreCase("nee") || antwort.equalsIgnoreCase("neee") || antwort.equalsIgnoreCase("keine ahnung")) {
				p("NAGUT!!! Ich frage in 3 Sekunden nochmal ! :D");
				warte(3000);
				p("Bereit?");
				antwort = eingabe.next();
			}
		}
	}
	public static void whostarts() {
		String fightbeginner = "Jemand";
		if (quiz == 1 && dev < 2) { // falls quiz an ist, wird quiz gemacht!

			if (Quiz.quiz()) {
				kampf = 1;
				fightbeginner = hhero1.getpName();
			} else {
				kampf = 2;
				fightbeginner = hhero2.getpName();
			}

		} else {

			if (chance(50)) {
				kampf = 2; // Zufall wer den Kampf beginnt!
				
				p(hhero2.getpName() + " darf den ersten Angriff machen!");
				fightbeginner = hhero2.getpName();
			} else {
				kampf = 1;
				p(hhero1.getpName() + " darf den ersten Angriff machen!");
				fightbeginner = hhero1.getpName();
			}
		}

		p(prefix2, 2);
		p("DER KAMPF BEGINNT!!! "+fightbeginner+" macht den ersten Angriff!");
		p(prefix2, 2);
	}

	public static void kampf(Hero held, Hero gegner) throws IOException {
		p("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\", 2);
		if (Textarena.dev == 0) {
			Itembox.roll(held, gegner);
		}

		if (heat < 2) {
			heat = heat * heat;
			if (heat > 2) {
				heat = 2;
			}
		} else {
			heat = heat + 0.1; // falls heat ueber 2 ist wird der schaden nur noch um 10% erhoeht
		}
		int schaden = 0;
		double s = gegner.getres() * (heat) * held.getspell(checkspell(held, gegner)).cast(held, gegner);
		// schaden wird gerundet!
		schaden = Round.nice(s);

		Help.red("((= Schaden =)): " + schaden);

		if (gegner.getL()-schaden < 0) { 
			// falls todesschlag, setze schaden auf gegnerleben, damit anzeige nicht in minus geht
			gegner.setL((int) gegner.getL());
			schaden = (int) gegner.getL();
		}
		
		Anzeigen.leben(gegner.getL(), (gegner.getL() - schaden), gegner); // SHOWS THE DAMAGE DONE
		gegner.setL(gegner.getL() - schaden); // Does damage

		if (kampf == 2) { // switcht kampf. 2 = gegner is dran. 1 = du bist dran.
			kampf--;
		} else {
			kampf++;
		}
		if (gegner.getL() <= 0 || held.getL() <= 0) {
			kampf = 0;
		}
	}


	public static int checkspell(Hero held, Hero gegner) throws IOException {

		int inputspell = -1;
		long t1 = System.currentTimeMillis();

		if (dev > 1) {
			p("HEAT:" + heat);
			while (inputspell == -1) {
				inputspell = (int) Math.ceil(Math.random() * held.getSpellSize());
				p("### SPELL AUTO: " + inputspell);
				Spell spell = held.getspell(inputspell);
				spell.changecd(-7);
				if (spell.checkall(held)) {
					inputspell = -1;
				}
			}
			if (dev < 10) {
				warte(5000 / dev);
			}
		} else {
			while (inputspell == -1) {

				p();
				pnext(prefix + held.getpName() + held.getpClass() + " Womit willst du angreifen?  ");
				for (int i = 1; i < held.getSpellSize() + 1; i++) {
					pnext("      > " + i + " : " + held.getspell(i).getSpellname());
				}
				p();

				inputspell = eingabe.nextInt();

				if (inputspell <= 0 || inputspell > held.getSpellSize()) {
					red(prefix + " Der Held von " + held.getpName() + " ist beleidigt! Held: Kannst du nicht mal ne Zahl von 1-" + held.getSpellSize() + " druecken ?!");
					warte(1000);
					inputspell = -1;
				} else {
					Spell spell = held.getspell(inputspell);
					if (spell.checkall(held)) {
						inputspell = -1;
					}
				}

			}
			// setzt cooldowns der spells runter, je nach dem wie lange der gegner gebraucht hat
			gegner.cdchangeall(t1 - System.currentTimeMillis());
		}

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
	
	public static int quiz;
	public static long timeout;
    public static int showallheroes;
    public static double heat;
    public static double heatset;
    public static int kampf;

}
