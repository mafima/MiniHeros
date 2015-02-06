package miniheros.hero.allspells;

import main.MiniHeros;
import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;
import miniheros.util.help;

public class Drache3 extends Spell{

	public Drache3(){
		// (String name, 		 CD CDSET       NEED               COST
		super("Feuerspei //", 0, 1,     0, 0, 0, 0, 0,     0, 0, 0, 50, 0);
	}

	public float cast(Hero h, Hero g) {
		this.setcd();
		float schaden = 0;
		
		help.p("//> "+this.getSpellname()+" <//");
		if (MiniHeros.dev < 2) help.punkte(3,500);

		// gegner?
		if (g.getClassS() == Classes.SHELDON) {
			help.spezialfall("Feuerspei toetet Sheldon");
			schaden = (float) g.getL();
		} else if (g.getClassS() == Classes.ZWERG) {
			help.spezialfall("Der Zwerg wirft einen Feueressertrank!");
			schaden = (float) (5+h.getM()*0.001);
		} else {
			help.p("Du speihst einen riesigen Feuerstrahl!");
			h.reM(0.65);
			schaden = (float) (3+h.getM()*0.05+h.getA()*0.01);
		}


		return schaden;
	}
}