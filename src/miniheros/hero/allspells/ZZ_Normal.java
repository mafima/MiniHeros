package miniheros.hero.allspells;

import main.Textarena;
import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;
import miniheros.util.Help;

public class ZZ_Normal extends Spell{
	
	public ZZ_Normal(){
		// Held stats:					     0, 0, 0, 0, 0
		// (String name, 		 CD CDSET       NEED               COST
		super("o-(==> normaler Angriff", 0, 0,     1, 0, 0, 0, 0,     0, 0, 0, 0, 0);
	}

	public double cast(Hero h, Hero g) {
		this.castcd();
		double schaden = 0;
		
		p("//> "+this.getSpellname()+" <//");
		punkte(3,200);
		
		if (g.getClassS() == Classes.SHELDON) {
			p("* Sheldon: Diese Regeln stehen nicht in der Einwohnervereinbahrung! Schaden auf 0 gesetzt! *");
		} else if (g.getClassS() == Classes.GOTT) {
			p("* GOTT: Niemand zweifelt an Gott. *");
		} else {
			p("Normaler Angriff! o-(==>");
			if (g.getG() < 0) {
				return (double) (h.getA() * (((-1) * g.getG())) * 0.02);
			} else {
				if (g.getG() > 0) {
					if (chance(g.getG() / (g.getG() + 500))) {
						p(g.getpName() + " ist deinem Angriff geschickt ausgewichen!");
						/*
						 * 	         double ausweichevent = (double) (h2geschick)*Math.random();
	         if (ausweichevent > 100 ) {
	         hdmg = hdmg*((h.getG())*0.2) -20; help.p(prefix + h.getpName() + Math.ceil((h.getH() - h2hirn)*0.2 + 400)+" Schaden durch praezisen Steinwurf auf Dummkopf!");
	         } else if (ausweichevent > 99) {
	         hdmg = hdmg*(0.7*(h.getG())); help.p(prefix + h.getpName() + Math.ceil((h.getH() - h2hirn)*0.2 + 20) +" Schaden durch Überheblichkeit verursacht!");
	         }
						 */
					} else {
						schaden = (int) Math.ceil((1 + h.getG() / (h.getG() + 100)) * (h.getA()) * (1 - g.getG() / (g.getG() + 100)));
					}
				} else {
					// schaden = (int) Math.ceil(h.getA()+(g.getG()*g.getG()));
					schaden = h.angriff(g);
				}
			}
		}
		if (g.getClassS() == Classes.DRACHE||g.getClassS() == Classes.EISDRACHE) schaden*=0.4;
		return h.angriff(g);
		// return schaden;
		}
}