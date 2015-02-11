package miniheros.hero.allspells;

import main.MiniHeros;
import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;
import miniheros.hero.Values;
import miniheros.util.Help;

public class Krieger_Fury extends Spell{
	
	public Krieger_Fury(){
		// createHero(70, 30, 10, 0, 600, 0.9, Values.POWERkrieger);
		// (String name, CD CDSET       				NEED               COST
		super("+((- FURY -))+", 3, 20,     				1, 0, 0, 0, 0,     0, 0, 0, 0, 0);
	}

	public double cast(Hero h, Hero g) {
		ZZ_Normal z_normal = new ZZ_Normal();
		this.castcd();
		double schaden = 0;
		
		p("//> "+this.getSpellname()+" <//");
		punkte(3,200);

		// gegnercheck
		if (g.getClassS() == Classes.DRACHE) {
			Help.p("* Gegner fliegt. Worauf willst du Fury anwenden?! *");
			h.reG(1.4);
			Help.p("*" + h.getpName() + " hat sich besser positioniert! Geschick steigt auf " + h.getG() + "*");
			return 0;
		} else if (g.getClassS() == Classes.GNOM) {
			spezial("Beim 2. Angriff schlaegt dir der Gnom in die Nuesse. " + g.getpName() + "lacht dich aus.");
			h.reG(0.5);
			
			schaden = z_normal.cast(h, g) * 1.2;
		} else {
			if (chance(h.getG() * 0.8 - (20 * h.getL() / h.getmax()))) {
				int m= 3;
				
				for (int i = 0; i < m; i++) {
					if (chance(100 * malor(h.getG(), 300))) {
						schaden += z_normal.cast(h, g) * 1.1;
					} else {
						Help.p("*** o-(==> Kritischer Treffer! ***");
						schaden += Math.ceil(h.getA() * 2);
					}
				}
				h.kampf(schaden * 0.1);
				Help.p("+++ Fury Heilung: " + schaden * 0.1 + " +++");
				return schaden;
			}
			Help.p("$ Beim 2. Angriff rutschst du aus und faellst um!" + g.getpName() + "lacht dich aus. $");
			h.reG(0.9);
			schaden = z_normal.cast(h, g) * 1.2;
		}
		
		return schaden;
	}

}
