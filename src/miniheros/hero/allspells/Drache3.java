package miniheros.hero.allspells;

import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;
import miniheros.util.help;

public class Drache3 extends Spell{
	
	public Drache3(){
		// (String name, long cd, long cdset, float needa, float needg, float needh, float needm, float needl, float costa, float costg, float costh, float costm, float costl)
		super("* .Zaubertrick. *", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 0);
	}

	public float cast(Hero h, Hero g) {
		float schaden = 0;
		if (g.getClassS() == Classes.SHELDON) {
			help.p("* Feuerspei toetet Sheldon *");
			schaden = (float) g.getL();
		} else {
			help.p("// Feuerspei //");
			help.p("Du speihst einen riesigen Feuerstrahl!");
			h.reM(0.65);
			schaden = (float) (30+h.getM()*0.5+h.getA()*0.1);
		}
			return schaden;
		}
}
