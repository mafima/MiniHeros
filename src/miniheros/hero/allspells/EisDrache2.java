package miniheros.hero.allspells;

import main.MiniHeros;
import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;
import miniheros.util.help;

public class EisDrache2 extends Spell{

	public EisDrache2(){
		// createHero(100, 10, 2, 80, 2000, Values.POWERdrache);
		// (String name, 		 CD CDSET       NEED               COST
		super("Eissplitter", 0, 1,     0, 0, 0, 0, 0,     0, 0, 0, 50, 0);
	}

	public double cast(Hero h, Hero g) {
		this.setcd();
		double schaden = 0;
		
		help.p("//> "+this.getSpellname()+" <//");
		if (MiniHeros.dev < 2) help.punkte(5,200);

		// DRACHE - "Drachenschrei", "Eissplitter", "Eisfeuer", "Drachenbiss des Todes"

			if (g.getClassS() == Classes.SHELDON) {
				help.p("* Eissplitter toetet Sheldon*");
				schaden = g.getL();
			} else {
				if (help.chance(120-g.getG())) {
					help.p(">>> Eissplitter trifft! <<<");
					schaden = h.getM()*0.8;
				} else {
				help.p("> Eissplitter rammt voll in den Boden rein");
				g.reG(0.95);
				schaden = 0;
				}
			
		}
			
			return schaden;
	}
}