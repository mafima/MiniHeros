package miniheros.util;

import main.Textarena;
import miniheros.hero.Hero;
import static miniheros.util.Help.*;

public class Anzeigen {

    public static void stats(Hero hhero) {
        // KAMPFWERTE AUSGABE
        p("|# >>>> ~ || " + hhero.getpName() + hhero.getpClass() + "|| ~ <<<< #|");
        p(" ");
        pnext(prefix + "### - Angriff: " + (int) Math.round(hhero.getA()));
        if (hhero.getA() > 0) {
            pnext("           -(=");
            for (int i = 10; i < hhero.getA(); i = i + 10) {
                pnext("=");
            }
            pnext(">");
        } else {
            pnext("           x");
        }
        p();

        pnext(prefix + "### - Geschick: " + (int) Math.round(hhero.getG()));
        if (hhero.getG() > 0) {
            pnext("           |>");
            for (int i = 10; i < hhero.getG(); i = i + 20) {
                pnext(">");
            }
        } else {
            pnext("           x");
        }
        p();
        pnext(prefix + "### - Hirn: " + (int) Math.round(hhero.getH()));
        if (hhero.getH() > 0) {
            pnext("                    [#Hi");
            for (int i = 10; i < hhero.getH(); i = i + 50) {
                pnext("i");
            }
            pnext("rn#]");
        } else {
            pnext("           x");
        }
        p();
        pnext(prefix + "### - Magie: " + (int) Math.round(hhero.getM()));
        if (hhero.getM() > 0) {
            pnext("                /o/ ");
            for (int i = 10; i < hhero.getM(); i = i + 20) {
                pnext("~");
            }
            pnext("~O>  |o/ ahh");
        } else {
            pnext("           x");
        }
        p();
        pnext(prefix + "### - Leben: " + (int) Math.round(hhero.getL()));
        if (hhero.getL() > 0) {
            pnext("              [[");
            for (int i = 0; i < hhero.getL(); i = i + 50) {
                pnext(":");
            }
            pnext("]]");
        } else {
            pnext("                  x");
        }
        p();
        p(" ");
        pnext(prefix + ".#//> SPELLS <\\#. -         ");
        for (int i = 1; i <= hhero.getSpellSize(); i++) {
            pnext("# Taste " + (i) + ":  " + hhero.getspell(i).getSpellname() + "     ||     ");
        }
        p();
        p("//////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
        p("//////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
    }

    public static void leben(double anzlebvor, double anzleb, Hero hero) {

        for (double i = anzlebvor; i > anzleb; i = i - (10 + (anzlebvor - anzleb) / 10)) {

            if (i < (anzlebvor - anzleb) / (10 + (anzlebvor - anzleb) / 10)) {
                p("+KAMPF+" + hero.getpName() + "[ " + hero.getClassS() + " ] " + Math.ceil(anzleb) + " Leben :");
            } else {
                pnext(" KAMPF -(=>" + hero.getpName() + "[" + hero.getClassS() + "] " + Math.ceil(i) + " Leben :");
            }
            pnext("###");
            for (double y = 0; y < i; y = y + 100) {
                pnext("-=");
            }
            pnext("|");
            p();
        }
    }
}
