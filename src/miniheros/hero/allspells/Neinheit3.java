package miniheros.hero.allspells;

import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;
import miniheros.util.Help;

public class Neinheit3 extends Spell{
	
	public Neinheit3(){
		// HEROWERTE: createHero(1000, 50, 50000, 1, 50000, 0.1, Values.POWERneinheit);
		// (spellname, 				cooldowns:  start - set       			NEED               COST
		super("EHHH NEIN?!",
												1, 		15,     				0, 0, 0, 0, 0,     0, 10, 0, 0, 0);
	}

	public double cast(Hero h, Hero g) {
		this.castcd();
		double schaden = 0;
		
		p("///////////////////////////////");
		p("//> "+this.getSpellname()+" <//");
		punkte(3,200);

		// gegnercheck
		if (g.getClassS() == Classes.SHELDON) {
			Help.p("* EHH NEIN! gegen Sheldon nutzlos! *");
			return 0;
		} else {
			Help.p("// EHHH NEIN! //");
			Help.p(">>> DU SAGST NEIN ZU REGELN UND JA ZUR ATOMKRAFT!");
			int x = (int) Math.ceil(Math.random()*5);
			if(chance(20)) {
				h.addM(x*100);
			} else if (chance(30)) {
				h.addG(x*200);
			} else if (chance(40)) {
				h.addM(x*500);
			} else {
				h.addA(x*500);
			}
			if (chance (40)) {
				Help.p("!!!!!!!!11!!4!!13423!!!!§ ATOMSCHLAG !!!!!!!!!!11!!1!!! snipar. lensflare. sampletext!");
				schaden = x*250;
			}
		}
		
		return schaden;
	}
}
