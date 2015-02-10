package miniheros.hero.allspells;


import main.MiniHeros;
import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;
import miniheros.hero.Values;
import miniheros.util.Help;

public class Zombie2_Zombieschrei extends Spell{

	public Zombie2_Zombieschrei(){
		// createHero(5, 4, 2, 15, 1200, Values.POWERzombie, 0.95);
		// (String name, 		 	cooldown	cooldownset     NEED               							COST
		super("*Schrei der Untoten*", 		0, 			10,	 			0, 1, 0, 0, 400*Hero.life,			0, 0, 0, 0, 0);
	}

	public double cast(Hero h, Hero g) {
		this.castcd();
		double schaden = 0;
		p("//> "+this.getSpellname()+" <//");
		if (MiniHeros.dev < 2) punkte(3,300);
		
		if (g.getClassS() == Classes.SHELDON) {
			Help.p("* Sheldon schreit auch!!! Zombieschrei wird neutralisiert! *");
		}
		if (g.getClassS() == Classes.ZOMBIE) {
			Help.p("* Der Gegnerzombie ist schon infiziert!!! *");
		} else {
			int r = (int) (Math.random() * 3);
			if (r > 0) {
				Help.p("Zombieschrei war so laut, dass " + r + " Zombies nun mit dir kaempfen!");
				r++;
				System.out.print(" Angriff steigt von " + h.getA() + " auf " + h.getA() * r + " !");
				System.out.print(" Geschick steigt von " + h.getG() + " auf " + h.getG() * r + " !");
				Help.p("Magie steigt von " + h.getM() + " auf " + h.getM() * r + " !");
				h.setA(h.getA() * r);
				h.setG(h.getG() * r);
				h.setM(h.getM() * r);

				Help.p("Angst verursacht! Gegner hat 20% weniger Angriff und Geschick");
				g.setA(g.getA() * 0.8);
				g.setG(g.getG() * 0.8);
			}
			Help.p("Angst verursacht! Gegner hat 40% weniger Angriff und Geschick");
			g.setA(g.getA() * 0.6);
			g.setG(g.getG() * 0.6);
	}
		return schaden;
}
}