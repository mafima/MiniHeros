package miniheros.hero.allspells;


import main.MiniHeros;
import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;
import miniheros.util.help;

public class Drache2 extends Spell{
	
	public Drache2(){
		// (String name, long cd, long cdset, float needa, float needg, float needh, float needm, float needl, float costa, float costg, float costh, float costm, float costl)
		super("* .Zaubertrick. *", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 0);
	}

	public float cast(Hero h, Hero g) {
		float schaden = 0;
		help.p("//> "+this.getSpellname()+" <//");
		if (MiniHeros.dev < 2) help.punkte(5,500);
		

			if (g.getClassS() == Classes.SHELDON) {
				help.p("* Feuerbombe macht kein Schaden gegen Sheldon *");
			} else {
				help.p("// Feuerbombe //");
				if (help.chance(100-g.getG())) {
					help.p(">>> Feuerbombe trifft! <<<");
					schaden = (float) (h.getM()*0.35);
				}
				help.p("> Feuerbombe zerreist einen Baum");
				g.reG(0.95);
			}
			return schaden;
		}
}
