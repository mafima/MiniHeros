package miniheros.hero.allspells;


import main.Textarena;
import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;

public class Drache1 extends Spell{

	public Drache1(){
		// createHero(100, 10, 2, 80, 2000, Values.POWERdrache);
		// (String name, 		 	cooldown	cooldownset     NEED               		COST
		super("Drachenschrei", 		0, 			1,	 			0, 0, 0, 0, 0,			0, 0, 0, 0, 0);
	}

	public double cast(Hero h, Hero g) {
		this.castcd();
		double schaden = 0;
		p("//> "+this.getSpellname()+" <//");
		
		if (Textarena.dev < 2) punkte(3,300);
		
		if (g.getClassS() == Classes.SHELDON) {
			spezial("Drachenschrei toetet Sheldon");
			schaden = (double) g.getL();
		} else {
			p("// Drachenschrei //");
			g.reG(0.9);
			h.reM(1.2);
			h.addM(50);
			schaden = (double) (5+h.getM()*0.05);
		}
		
	return schaden;
	}
}
