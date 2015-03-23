package miniheros.hero.allspells;


import main.Textarena;
import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;
import miniheros.util.Help;

public class Zombie4_Todesbiss extends Spell{

	public Zombie4_Todesbiss(){
		// createHero(5, 4, 2, 15, 1200, Values.POWERzombie, 0.95);
		// (String name, 		 	cooldown	cooldownset     NEED               		COST
		super("=| Biss des Todes |=", 		0, 			100,	0, 0, 0, 0, 0,			0, 0, 0, 0, 0);
	}
 
	public double cast(Hero h, Hero g) {
		this.castcd();
		double schaden = 0;
		p("//> "+this.getSpellname()+" <//");
		if (Textarena.dev < 2) punkte(3,300);
		
		if (g.getClassS() == Classes.SHELDON) {
			Help.p("* Hirn zu eklig! *");
			schaden = 5 + h.getA() * 0.01;
		} else {
			if (chance(100 * h.getL() / (h.getmax() + g.getG()))) {
				Help.p("/// ZOMBIEBISS /// ");
				Help.p("100  Hirnmasse verspeist!!!");
				g.setH(g.getH() - 100);
				h.setH(h.getH() + 100);
				if (g.getH() <= 0) {
					Help.p("*** " + (0.5 * h.getM() + 300 - g.getH() * 0.8) + " Schaden durch Zombievirus! ***");
					schaden = (0.5 * h.getM() + 300 - g.getH() * 0.8);
				}
				schaden = (50+ 200*g.getmissing() + h.getM() * 0.5);
			}
			p("Gegner ist vor Zombiebiss ausgewichen!");
		}
		
	return schaden;
	}
}
