package miniheros.hero.allspells;

import main.MiniHeros;
import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;
import miniheros.util.help;

public class EisDrache3 extends Spell{

	public EisDrache3(){
		// createHero(100, 10, 2, 80, 2000, Values.POWERdrache);
		// (String name, 		 CD CDSET       NEED               COST
		super("Eisatem", 0, 1,     0, 0, 0, 0, 0,     0, 0, 0, 50, 0);
	}

	public double cast(Hero h, Hero g) {
		this.setcd();
		double schaden = 0;
		
		help.p("//> "+this.getSpellname()+" <//");
		if (MiniHeros.dev < 2) help.punkte(5,200);

		// DRACHE - "Drachenschrei", "Eissplitter", "Eisfeuer", "Drachenbiss des Todes"

		if (g.getClassS() == Classes.SHELDON) {
			help.p("* Eisatem gegen Sheldon nutzlos! *");
		} else {
			help.p("// Eisatem //");
			help.p("Du speihst einen riesigen Eisstrahl!");
			h.reM(0.75);
			schaden = 50+h.getM()*0.4+h.getH()*0.3;
		}
			
			return schaden;
	}
}