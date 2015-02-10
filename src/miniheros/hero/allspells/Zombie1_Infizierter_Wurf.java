package miniheros.hero.allspells;


import main.MiniHeros;
import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;
import miniheros.hero.Values;
import miniheros.util.Help;

public class Zombie1_Infizierter_Wurf extends Spell{

	public Zombie1_Infizierter_Wurf(){
		// createHero(5, 4, 2, 15, 1200, Values.POWERzombie, 0.95);
		// (String name, 		 	cooldown	cooldownset     NEED               		COST
		super("Infizierter Wurf", 		0, 			0,	 			0, 0, 0, 0, 0,			0, 0, 0, 0, 0);
	}

	public double cast(Hero h, Hero g) {
		this.castcd();
		double schaden = 0;
		p("//> "+this.getSpellname()+" <//");
		p("// Zombie wirft einen Teil von sich auf "+h.getpName());
		
		punkte(3,300);
		
		if (g.getClassS() == Classes.SHELDON) {
			Help.p("* Sheldon ekelt sich zu Tode! *");
			schaden = g.getL();
		} else {
			if (chance(95-g.getG()*0.1)) {
				schaden = h.getA() * 0.5 + h.getG() * 0.4 + h.getM() * 0.1;
				if (chance(30+1000/g.getG())) {
					spezial("--- Kritischer Treffer! ---");
					schaden *= 2;
				}
			} else {
				p("Daneben!");
			}
			
		}
		
	return schaden-(schaden*g.getpercentmissing()*0.8);
	}
}
