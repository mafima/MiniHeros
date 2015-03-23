package miniheros.hero.allspells;


import main.Textarena;
import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;
import miniheros.hero.Values;
import miniheros.util.Help;

public class Zombie3_Hirnwurf extends Spell{

	public Zombie3_Hirnwurf(){
		// createHero(5, 4, 2, 15, 1200, Values.POWERzombie, 0.95);
		// (String name, 		 	cooldown	cooldownset     NEED               		COST
		super("Hirnwurf", 		0, 			10,	 			0, 0, 10, 0, 0,			0, 0, 0, 0, 0);
	}

	public double cast(Hero h, Hero g) {
		this.castcd();
		double schaden = 0;
		p("//> "+this.getSpellname()+" <//");
		spezial("Du wirfst 70% deiner Hirnmasse auf den Gegner!");
		if (g.getH() > 100) {
			schaden += 50;
			p("### HIRNBOMBE!!! ###",3,400);
		}
		 punkte(3,300);
		
		if (g.getClassS() == Classes.SHELDON) {
			spezial("SHELDON kommt mit HIRNMASSE in Kontakt. Er explodiert.");
			return g.getL();
		} else {
			double hirn = h.getH() * 0.7;
			h.setH(h.getH() * 0.3);
			if (chance(100 * malor(hirn, 10))) {
				schaden += (hirn * 2);
			}
			Help.p("Du hast den Gegner nicht mit deinem Hirn getroffen!");

		}
		
	return schaden;
	}
}
