package miniheros.hero.allspells;


import main.Textarena;
import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;
import miniheros.hero.Values;
import miniheros.util.Help;

public class Zombie1_Infizierter_Wurf extends Spell{

	public Zombie1_Infizierter_Wurf(){
		// createHero(5, 4, 2, 15, 1200, Values.POWERzombie, 0.95);
		// (String name, 		 	cooldown	cooldownset     NEED               		COST
		super("Infizierter Wurf", 		0, 			0,	 			0, 0, 0, 0, 0,			0, 0, 0, 0, 20*Hero.life);
	}

	public double cast(Hero h, Hero g) {
		this.castcd();
		double schaden = 0;
		p("//> "+this.getSpellname()+" <//");
		p("// Zombie wirft einen Teil von sich auf "+g.getpName());
		
		punkte();
		
		if (g.getClassS() == Classes.SHELDON) {
			Help.p("* Sheldon ekelt sich zu Tode! *");
			schaden = g.getL();
		} else {
			if (chance(95-g.getG()*0.1)) {
				schaden = (h.getA() * 0.65 + h.getG() * 0.75)*(1+g.getmissing());
				if (chance(40+h.getG())) {
					spezial("--- Kritischer Treffer! ---");
					schaden *= 2;
				}
			} else {
				p("Daneben!");
			}
			
		}
		
	return schaden;
	}
}
