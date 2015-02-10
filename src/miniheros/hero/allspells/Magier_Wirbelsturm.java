package miniheros.hero.allspells;

import main.MiniHeros;
import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;
import miniheros.util.Help;

public class Magier_Wirbelsturm extends Spell{
	
	public Magier_Wirbelsturm(){
		// HEROWERTE: createHero(5, 10, 200, 300, 400, Values.POWERmagier, 1.1);
		// (spellname, 				cooldowns:  start - set       			NEED               COST
		super("Wirbelsturm",
												1, 		7,     				0, 0, 0, 0, 0,     0, 0, 0, 30, 0);
	}

	public double cast(Hero h, Hero g) {
		this.castcd();
		double schaden = 0;
		

		p("//> "+this.getSpellname()+" <//");
		if (MiniHeros.dev < 2) punkte(3,200);

		// gegnercheck
		if (g.getClassS() == Classes.SHELDON ) {
			p("* WUUUUSCH STUUUUURM WAAAH !!!! Sheldon stirbt *");
			schaden=g.getL();
		} else if (g.getClassS() == Classes.DRACHE ) {
			p("*  WUUUUSCH STUUUUURM WAAAH !!! Der Drache faellt zu Boden! *");
			g.reA(0.4); g.reG(0.4);
			schaden=50+g.getL()*0.3;
		} else if (g.getClassS() == Classes.GNOM ) {
			p("*  WUUUUSCH STUUUUURM WAAAH !!! Hurricane hat bei einem Gnom keine Wirkung *");
			schaden=0;
		} else if (g.getClassS() == Classes.ZWERG ) {
			p("*  WUUUUSCH STUUUUURM WAAAH !!! Es scheint ihm nicht sehr zu schaden. *");
			schaden=10+g.getL()*(0.01+malor(h.getM(),500));
		} else if (g.getClassS() == Classes.ORK ) {
			p("*  WUUUUSCH STUUUUURM WAAAH !!! Hurricane wirft den Ork zu Himmel! *");
			schaden=0.45*g.getL()/g.getres();
		} else {
			spezial("Du erzeugst einen Wirbelsturm und wirfst so eine fliegende Kuh auf den Gegner!");
			schaden=h.getH()*0.2+h.getM()*0.4;
		}
		
		return schaden;
	}
}
