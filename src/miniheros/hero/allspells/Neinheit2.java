package miniheros.hero.allspells;

import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;
import miniheros.util.Help;

public class Neinheit2 extends Spell{
	
	public Neinheit2(){
		// HEROWERTE: createHero(1000, 50, 50000, 1, 50000, 0.1, Values.POWERneinheit);
		// (spellname, 				cooldowns:  start - set       			NEED               COST
		super("ICH SAGE NEIN!",
												0, 		7,     				0, 0, 0, 0, 0,     0, 20, 0, 0, 0);
	}

	public double cast(Hero h, Hero g) {
		this.castcd();
		double schaden = 0;
		

		p("//> "+this.getSpellname()+" <//");
		punkte(3,200);

		// gegnercheck
		if (g.getClassS() == Classes.SPIDERPIG) {
			Help.p("* zu SPIDERPIG kann man nicht NEIN sagen! *");
			g.reM(1.5); g.reA(1.5);
		} else {
			Help.p("// ICH SAGE ... //");
			int ende = 0;
			while (ende < 2) {
				if (chance(70)) {
					Help.p(">>> BOOM! NEINBOMBE TRIFFT! <<<");
					schaden += h.getG()*0.01;
				} else {
					Help.p("X-X NEINBOMBE geht daneben! OCH NEIN! X-X");
					ende++;
				}
				warte(300);
			}
			Help.p("Die Bomben heilen dich um "+schaden*0.05);
			h.kampf(schaden*0.05);
		}
		
		return schaden;
	}
}
