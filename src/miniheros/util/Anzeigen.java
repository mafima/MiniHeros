package miniheros.util;

import main.MiniHeros;
import miniheros.hero.Hero;

public class Anzeigen {
	public static void werte(Hero hhero) {
		// KAMPFWERTE AUSGABE
		Help.p("###>>>> || " + hhero.getpName() + hhero.getpClass() + "|| <<<<###");
		Help.pnext(MiniHeros.prefix + "### - Angriff: " + hhero.getA() + "         -(="); for (int i = 10; i < hhero.getA(); i = i + 10) Help.pnext("="); Help.pnext(">"); Help.p();
		Help.pnext(MiniHeros.prefix + "### - Geschick: " + hhero.getG() + "       |>"); for (int i = 10; i < hhero.getG(); i = i + 20) Help.pnext(">"); Help.p();
		Help.pnext(MiniHeros.prefix + "### - Hirn: " + hhero.getH() + "              [#Hi"); for (int i = 10; i < hhero.getH(); i = i + 25) Help.pnext("i"); Help.pnext("rn#]"); Help.p();
		Help.pnext(MiniHeros.prefix + "### - Magie: " + hhero.getM() + "           /o/ "); for (int i = 10; i < hhero.getM(); i = i + 20) Help.pnext("~"); Help.pnext("~O>  |o/ ahh"); Help.p();
		Help.pnext(MiniHeros.prefix + "### - Leben: " + hhero.getL() + "          [["); for (int i = 0; i < hhero.getL(); i = i + 100) Help.pnext(":"); Help.pnext("]]"); Help.p();

		Help.pnext(MiniHeros.prefix + "#// ZAUBER \\# -  ");
		for (int i = 1; i <= hhero.getSpellSize(); i++) Help.pnext("Taste " + (i) + ": " + hhero.getspell(i).getSpellname() + " || ");
		Help.p();
		Help.p("//////////////////////////////////////////////////////////////////////////////////////////////////////////////////");

	}
	public static void leben(double anzlebvor, double anzleb, Hero hero) {
		for (double i = anzlebvor; i > anzleb && i > 0; i = i - (10 + (anzlebvor - anzleb) / 10)) {
			if (i < (anzlebvor - anzleb) / (10 + (anzlebvor - anzleb) / 10)) {
				Help.p("+KAMPF+" + hero.getpName() + "[ " + hero.getClassS() + " ] " + Math.ceil(anzleb) + " Leben :");
			} else {
				Help.pnext(" KAMPF -(=>" + hero.getpName() + "[" + hero.getClassS() + "] " + Math.ceil(i) + " Leben :");
			}
			Help.pnext("###");
			for (double i4 = 0; i4 < i; i4 = i4 + 50) {
				Help.pnext("-=");
			}
			Help.pnext("#");
			Help.pnext("||");
			Help.p();
		}
	}
}
