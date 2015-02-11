package miniheros.hero.allspells;

import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;
import miniheros.util.Help;

public class Neinheit1 extends Spell{
	
	public Neinheit1(){
		// HEROWERTE: createHero(1000, 50, 50000, 1, 50000, 0.1, Values.POWERneinheit);
		// (spellname, 				cooldowns:  start - set       			NEED               COST
		super("NEIN!",
												0, 		0,     				0, 0, 0, 0, 0,     0, 0, 0, 0, 0);
	}

	public double cast(Hero h, Hero g) {
		this.castcd();
		double schaden = 0;
		

		p("//> "+this.getSpellname()+" <//");
		punkte(3,200);

		// gegnercheck
		if (g.getClassS() == Classes.SHELDON) {
			Help.p("* NEIN verwirrt Sheldon! *");
			schaden = 50;
		} else if (g.getClassS() == Classes.MAGIER) {
			Help.p("* Magier unterbricht deine Neinsagung! *");
		} else{
			Help.p("// NEIN zum Angriff! //");
			Help.p("Angreifen wird ueberbewertet!");
			if (chance(40)) {
				Help.p("Deine Entspanntheit ver11-facht dein Geschick");
				h.reG(11);
			} else if (chance(80)) {
				Help.p("Deine Entspanntheit ver3-facht dein Geschick");
				h.reG(3);
			} else {
				Help.p("Du rutschst auf einer Banane aus und explodierst aus Versehen! 20000 Schaden an dir selbst!");
				h.kampf(-20000);
				h.reH(0.75);
			}
		}
		
		return schaden;
	}
}