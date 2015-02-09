package miniheros.hero.allspells;


import main.MiniHeros;
import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;
import miniheros.util.help;

public class Drache1 extends Spell{

	public Drache1(){
		// (String name, long cd, long cdset, double needa, double needg, double needh, double needm, double needl, double costa, double costg, double costh, double costm, double costl)
		super("Drachenschrei", 0, 1,	 0, 0, 0, 0, 0,		 0, 0, 0, 0, 0);
	}

	public double cast(Hero h, Hero g) {
		double schaden = 0;
		help.p("//> "+this.getSpellname()+" <//");
		
		if (MiniHeros.dev < 2) help.punkte(3,500);
		
		if (g.getClassS() == Classes.SHELDON) {
			help.spezialfall("Drachenschrei toetet Sheldon");
			schaden = (double) g.getL();
		} else {
			help.p("// Drachenschrei //");
			g.reG(0.9);
			h.reM(1.2);
			h.addM(50);
			schaden = (double) (5+h.getM()*0.05);
		}
		
	return schaden;
	}
}
