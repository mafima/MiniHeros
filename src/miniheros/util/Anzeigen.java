package miniheros.util;

import miniheros.hero.Hero;

public class Anzeigen {
	public static void werte(Hero hhero) {
		// KAMPFWERTE AUSGABE

		Help.p("###====|| " + hhero.getpName() + hhero.getpClass() + " ||====###");
		Help.p();
		Help.print("### - Angriff: " + hhero.getA() + "         -(=");
		for (int i = 0; i < hhero.getA(); i = i + 20) {
			Help.print("==");
		}
		Help.p(">");
		Help.p( "### - Geschick: " + hhero.getG() + "        >>>");
		Help.p( "### - Hirn: " + hhero.getH() + "             [#Hirn#]");
		Help.print( "### - Zauberkraft: " + hhero.getM() + "    < ");
		for (int i = 0; i < hhero.getM(); i = i + 30) {
			Help.print("~~");
		}
		Help.p("~");
		Help.print( "### - Leben: " + hhero.getL() + "          [[");
		for (int i = 0; i < hhero.getL(); i = i + 100) {
			Help.print(":");
		}
		Help.p("]]");
		Help.p();

		Help.print( "#// ZAUBER \\# -  ");
		for (int i = 1; i <= hhero.getSpellSize(); i++) {
			Help.print("Taste " + (i) + ": " + hhero.getspell(i).getSpellname() + " || ");
		}
		Help.p();
		Help.p("*----------------------------------*");

	}
	public static void leben(double anzlebvor, double anzleb, Hero hero) {
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
}
