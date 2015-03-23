package miniheros.hero.allspells;

import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;

public class Zombie2_Zombieschrei extends Spell{

	public Zombie2_Zombieschrei(){
		// createHero(5, 5, 2, 15, 1200, Values.POWERzombie, 0.95);
		// (String name, 		 	cooldown	cooldownset     NEED               							COST
		super("*Schrei der Untoten*", 		0, 			10,	 			0, 0, 1, 0, 300*Hero.life,			0, 0, 0, 0, 0);
	}

	public double cast(Hero h, Hero g) {
		this.castcd();
		double schaden = 0;
		p("//> "+this.getSpellname()+" <//");
		punkte(3,300);

		if (g.getClassS() == Classes.SHELDON) {
			p("* Sheldon schreit auch!!! Zombieschrei wird neutralisiert! *");
		}
		if (g.getClassS() == Classes.ZOMBIE) {
			p("* Der Gegnerzombie ist schon infiziert!!! *");
		} else {
			int r = (int) (Math.random() * 3);
			if (r > 0) {
				p("Zombieschrei war so laut, dass " + r + " Zombies nun mit dir kaempfen!");
				r++;

				h.addA(5 * r);
				h.addG(5 * r);
				h.addH(2 * r);
				h.addM(15 * r);

				p("Angst verursacht! Gegner hat 20% weniger Angriff und Geschick");
				g.reA(0.8);
				g.reG(0.8);
			} else {

				p("Angst verursacht! Gegner hat 40% weniger Angriff und Geschick");
				g.setA(g.getA() * 0.6);
				g.setG(g.getG() * 0.6);
			}
		}
		return schaden;
	}
}