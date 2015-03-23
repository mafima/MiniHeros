package miniheros.hero.allspells;


import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;

public class Drache2 extends Spell{
	
	public Drache2(){
		// createHero(100, 10, 2, 80, 2000, Values.POWERdrache);
		// (String name, 		 CD CDSET       NEED               COST
		super("Feuerbombe", 	0, 0,           0, 0, 0, 0, 0,     0, 0, 0, 30, 0);
	}

	public double cast(Hero h, Hero g) {
		this.castcd();
		double schaden = 0;
		p("//> "+this.getSpellname()+" <//");
		punkte(3,500);
		
			if (g.getClassS() == Classes.SHELDON) {
				spezial("Feuerbombe macht kein Schaden gegen Sheldon");
			} else {
				if (chance(120-g.getG())) {
					p(">>> Feuerbombe trifft! <<<");
					schaden = h.getM()*0.25;
					g.reM(0.7);
					g.reG(0.7);
				} else {
				p("> Feuerbombe zerreist einen Baum");
				g.reG(0.95);
				}
			}
			
			return schaden;
		}
}
