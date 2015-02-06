package miniheros.hero.allspells;

import main.MiniHeros;
import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;
import miniheros.util.help;

public class Z_NORMAL extends Spell{
	
	public Z_NORMAL(){
		// Held stats:					     0, 0, 0, 0, 0
		// (String name, 		 CD CDSET       NEED               COST
		super("* .NORMAL. *", 0, 0,     1, 0, 0, 0, 0,     0, 0, 0, 0, 0);
	}

	public float cast(Hero h, Hero g) {
		this.setcd();
		float schaden = 0;
		help.p("//> "+this.getSpellname()+" <//");
		if (MiniHeros.dev < 2) help.punkte(5,500);
		
		if (g.getClassS() == Classes.SHELDON) {
			help.p("* Sheldon: Diese Regeln stehen nicht in der Einwohnervereinbahrung! Schaden auf 0 gesetzt! *");
		} else if (g.getClassS() == Classes.GOTT) {
			help.p("* GOTT: Niemand zweifelt an Gott. *");
		} else {
			help.p("Normaler Angriff! o-(==>");
			if (g.getG() < 0) {
				return (float) (h.getA() * (((-1) * g.getG())) * 0.02);
			} else {
				if (g.getG() > 0) {
					if (help.chance(g.getG() / (g.getG() + 500))) {
						help.p(g.getpName() + " ist deinem Angriff geschickt ausgewichen!");
					} else {
						schaden = (int) Math.ceil((1 + h.getG() / (h.getG() + 100)) * (h.getA()) * (1 - g.getG() / (g.getG() + 100)));
					}
				} else {
					schaden = (int) Math.ceil(h.getA()+(g.getG()*g.getG()));
				}
			}
		}
		if (g.getClassS() == Classes.DRACHE||g.getClassS() == Classes.EISDRACHE) schaden*=0.4;
		return schaden;
		}
}