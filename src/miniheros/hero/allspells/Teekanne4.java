package miniheros.hero.allspells;

import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;

public class Teekanne4 extends Spell{
	
	public Teekanne4(){
		// HEROWERTE: createHero(1000, 50, 50000, 1, 50000, 0.1, Values.POWERneinheit);
		// (spellname, 							cooldowns:  start - set       			NEED               COST
		super("+++ hoellisches Wasser (des Todes) +++",
															15, 		9999,     			0, 0, 20, 0, 0,     0, 0, 0, 0, 200);
	}

	public double cast(Hero h, Hero g) {
		this.castcd(); // setzt den cooldown auf cooldownset
		double schaden = 0; // schaden is by default 0
		
		p("//> "+this.getSpellname()+" <//"); // zeigt den Zauber kurz an
		punkte(3,200);	// erstellt 3 schnelle punkte. zeit zwischen den punkten: 200 ms

		// gegnercheck. checkt alle gegner durch.
		if (g.getClassS() == Classes.SHELDON) {
			p("* Sheldon sagt HEISS! tot! *");
			schaden = g.getL();
		} else if (g.getClassS() == Classes.SHELDON) {
			
		} else if (g.getClassS() == Classes.SHELDON) {
			
		} else if (g.getClassS() == Classes.SHELDON) {
			
		} else if (g.getClassS() == Classes.SHELDON) {
			
		} else {
			p(">>> Du versuchst dem Gegner heissen Tee zu servieren! <<<");
			punkte(3,400);
			if (chance(30-(0.1*g.getG()))) {
				p(">>> HOELLENQUAAAALEN! Heisser Tee schmilzt den Gegner auf grausame Weise!!! <<<");
				schaden = 3*h.getH() + (0.025*g.getmissing()*g.getmissing());
			} else {
				p("Du hast eine Blume gegossen! 800 Leben!");
				h.kampf(800);
				p("Die Blume besanftigt den Gegner!");
				h.reA(0.8);
			}

		}
		
		return schaden;
	}
}
