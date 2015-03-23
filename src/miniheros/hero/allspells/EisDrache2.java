package miniheros.hero.allspells;

import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;

public class EisDrache2 extends Spell{

	public EisDrache2(){
		// createHero(100, 10, 2, 80, 2000, Values.POWERdrache);
		// (String name, 		 CD CDSET       NEED               COST
		super("Eissplitter", 0, 15,     0, 0, 0, 0, 0,     0, 0, 0, 50, 0);
	}

	public double cast(Hero h, Hero g) {
		this.castcd();
		double schaden = 0;
		
		p("//> "+this.getSpellname()+" <//");
		punkte(5,200);
		
		
		
		
		

		// DRACHE - "Drachenschrei", "Eissplitter", "Eisfeuer", "Drachenbiss des Todes"

			if (g.getClassS() == Classes.SHELDON) {
				p("* Eissplitter toetet Sheldon*");
				schaden = g.getL();
			} else {
				if (chance(100-g.getG()) && h.getM()>=10) {
					p(">>> Eissplitter trifft! <<<");
					schaden = h.getM()*0.8;
				} else {
				p("> Eissplitter rammt voll in den Boden rein");
				g.reG(0.95);
				schaden = 0;
				}
			
		}
			
			return schaden;
	}
}