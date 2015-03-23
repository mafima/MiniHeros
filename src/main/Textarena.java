package main;

import java.io.IOException;
import java.util.Scanner;

import miniheros.hero.Hero;
import miniheros.window.Fenster;

/* - 1 gegen 1 Kampfspiel -
 *  Author = Manuel Fischer (Mafima)
 *  CoAuthor = Ferdl
 * 
 * HELDEN ERSTELLEN HIER:  http://derpy.me/held
 */


public class Textarena extends Fenster {

    protected static Hero hhero1; // Hero Objekte werden erstellt
    protected static Hero hhero2;

    public static Scanner eingabe; // Scanner laden fuer Eingabe

    public static void main(String[] args) throws IOException {

        hhero1 = new Hero(0, 0, 0, 0, 0); // Erstellen der 2 Hero Objekte
        hhero2 = new Hero(0, 0, 0, 0, 0);
        
        Gamechange(); // beeinflusst alle Spielwerte

        new Fenster(); // Fenster wird erstellt

        Intro.play();

        Game.start(hhero1, hhero2);
    }
    
    public static void Gamechange() {
        dev = 0;
        Intro.forcedevmode = 0;		// aktiviert devmodus in jeden fall. 1=on 0=off
        Intro.skipmuenze = 0; 		// Soll Muenzwurf uebersprungen werden? 0=nein 1=ja
        Game.quiz = 1;				// QUIZ aktiv = 1.    off= 0
        Game.timeout = 30 * 1000; 		// bestimme wie lang man zeit zum held nehmen hat! 30 sekunden = 30 * 1000
        Game.showallheroes = 1;			// zeigt alle helden kurz in einer zeile an. 0 = off 1 = on
        Game.heatset = 1.0002; 			// setzt den Anfangswert fuer die Hitze! (dmgberechnung: schaden*heat)
        Hero.life = 3; 				// Multipliziert das LEBEN aller Heldem um diesen Wert. Zu Testzwecken auf 3 gesetzt!
    }

    public static int TODOi = 0;

    public static int dev;

    // HERO GETTER AND SETTER
    public static Hero getHhero1() {
        return hhero1;
    }

    public static void setHhero1(Hero hhero1) {
        Textarena.hhero1 = hhero1;
    }

    public static Hero getHhero2() {
        return hhero2;
    }

    public static void setHhero2(Hero hhero2) {
        Textarena.hhero2 = hhero2;
    }
}
