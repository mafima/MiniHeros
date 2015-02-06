package miniheros.hero.allspells;


import main.MiniHeros;
import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;
import miniheros.util.help;

public class Drache1 extends Spell{

	public Drache1(){
		// (String name, long cd, long cdset, float needa, float needg, float needh, float needm, float needl, float costa, float costg, float costh, float costm, float costl)
		super("Drachenschrei", 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 20, 0);
	}

	public float cast(Hero h, Hero g) {
		float schaden = 0;
		help.p("//> "+this.getSpellname()+" <//");
		
		if (MiniHeros.dev < 2) help.punkte(3,500);
		
		if (g.getClassS() == Classes.SHELDON) {
			help.spezialfall("Drachenschrei toetet Sheldon");
			schaden = (float) g.getL();
		} else {
			help.p("// Drachenschrei //");
			g.reG(0.6);
			h.reG(1.3);
			h.reR(1.1);
			h.reM(1.2);
			schaden = (float) (5+h.getM()*0.05);
		}
		
	return schaden;
	}
}
