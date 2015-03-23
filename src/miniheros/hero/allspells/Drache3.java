package miniheros.hero.allspells;

import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;

public class Drache3 extends Spell{

	public Drache3(){
		// createHero(100, 10, 2, 80, 2000, Values.POWERdrache);
		// (String name, 		 CD CDSET       NEED               COST
		super("Feuerspei", 0, 1,     0, 0, 0, 0, 0,     0, 0, 0, 20, 0);
	}

	public double cast(Hero h, Hero g) {
		this.castcd();
		double schaden = 0;
		
		p("//> "+this.getSpellname()+" <//");
		punkte(3,500);

		// gegner?
		if (g.getClassS() == Classes.SHELDON) {
			spezial("Sheldon wurde geroestet!!!");
			schaden = (double) g.getL()/5;
		} else if (g.getClassS() == Classes.ZWERG) {
			spezial("Der Zwerg wirft einen Feueressertrank!");
			schaden = (double) (5+h.getM()*0.05)/5;
		} else {
			p("> Du speihst einen riesigen Feuerstrahl!");
			schaden = (int) (20+h.getM()*0.15+h.getA()*0.05);
		}
		return schaden*5;
	}
}