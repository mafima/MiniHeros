package miniheros.hero.allspells;


import main.MiniHeros;
import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;
import miniheros.util.help;

public class Drache2 extends Spell{
	
	public Drache2(){
		// (String name, 		 CD CDSET       NEED               COST
		super("Feuerbombe", 	0, 0,           0, 0, 0, 0, 0,     0, 0, 0, 20, 0);
	}

	public double cast(Hero h, Hero g) {
		double schaden = 0;
		help.p("//> "+this.getSpellname()+" <//");
		if (MiniHeros.dev < 2) help.punkte(3,500);
		

			if (g.getClassS() == Classes.SHELDON) {
				help.spezialfall("Feuerbombe macht kein Schaden gegen Sheldon");
			} else {
				help.p("// Feuerbombe //");
				if (help.chance(100-g.getG())) {
					help.p(">>> Feuerbombe trifft! <<<");
					schaden = (double) (h.getM()*0.35);
				}
				help.p("> Feuerbombe zerreist einen Baum");
				g.reG(0.95);
			}
			return schaden;
		}
}
