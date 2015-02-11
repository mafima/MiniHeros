package miniheros.hero.allspells;

import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;
import miniheros.util.Help;

public class Neinheit4 extends Spell{
	
	public Neinheit4(){
		// HEROWERTE: createHero(1000, 50, 50000, 1, 50000, 0.1, Values.POWERneinheit);
		// (spellname, 				cooldowns:  start - set       			NEED               COST
		super("+++ NEIN! NEIN! NEIN! +++",
												5, 		120,     				0, 0, 0, 0, 0,     0, 100, 25000, 0, 0);
	}

	public double cast(Hero h, Hero g) {
		this.castcd();
		double schaden = 0;
		
		p("//> "+this.getSpellname()+" <//");
		punkte(3,200);

		// gegnercheck
		if (g.getClassS() == Classes.SHELDON) {
			Help.p("* Sheldon sagt NEIN zu deiner Ultimate! *");
		} else if (g.getClassS() == Classes.GNOM || g.getClassS() == Classes.MAGIER) {
			Help.p("* Ultimatives Nein nicht gegen so schlaue Person einsetzbar! *");
		} else {
			Help.p(">>> Du wirfst HITLER auf den Gegner! <<<");
			punkte(3,400);
			if (chance(100-g.getG())) {
				Help.p(">>> Treffer! Hitler explodiert! <<<");
				schaden = (int) Math.ceil(h.getG()*2 + h.getA()*0.1);
			} else {
				Help.p("> Ein Jude laeuft vorbei. Der fliegende Hitler aendert den Kurs.");
			}
		}
		
		return schaden;
	}
}
