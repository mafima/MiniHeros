package miniheros.hero.allspells;

import main.MiniHeros;
import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;
import miniheros.hero.Values;
import miniheros.util.Help;

public class Krieger_Ansturm extends Spell{
	
	public Krieger_Ansturm(){
		// createHero(70, 30, 10, 0, 600, 0.9, Values.POWERkrieger);
		// (String name, 		 CD CDSET       NEED               COST
		super("Ansturm", 0, 5,     0, 0, 0, 0, 0,     0, 0, 0, 0, 0);
	}

	public double cast(Hero h, Hero g) {
		this.castcd();
		double schaden = 0;
		
		p("//> "+this.getSpellname()+" <//");
		if (MiniHeros.dev < 2) punkte(3,200);

		// gegnercheck
		if (g.getClassS() == Classes.DRACHE || g.getClassS() == Classes.EISDRACHE) {
			Help.p("* Das ist ein Drache, der hoch im Himmel fliegt. Worauf willst du stuermen?! *");
			h.reG(1.5);
			Help.p("*" + h.getpName() + " ist naeher am Gegner! Geschick steigt auf " + h.getG() + "*");
		} else { // bei normalen gegnern...
			if (chance(1.5 * h.getG())) {
				Help.p("/// >>>>>>>>>>>> /// ");
				Help.p("/// ANSTUUUUUURM /// ");
				Help.p("Du wirfst " + g.getpName() + " zu Boden! Auf dem Boden liegt Schlamm." + g.getpName() + " ekelt sich!");
				h.reG(1.4);
				g.reH(0.8);
				schaden = (int) Math.ceil(20 + h.getM() * 0.5);
			}
			Help.p("Gegner ist vor Ansturm ausgewichen!!");
		}
		return schaden;
	}

}
