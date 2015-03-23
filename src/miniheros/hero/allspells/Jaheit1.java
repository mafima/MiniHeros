package miniheros.hero.allspells;

import main.Textarena;
import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;
import miniheros.util.Help;

public class Jaheit1 extends Spell{
	
	public Jaheit1(){
		//	JAHEIT -		createHero(1000, 8000, 100, 100, 50000, 2, Values.POWERjaheit);
		// (spellname, 				cooldowns:  start - set       			NEED               COST
		super("JA",
												0, 		0,     				0, 0, 0, 0, 0,     0, 0, 0, 0, 0);
	}

	public double cast(Hero h, Hero g) {
		this.castcd();
		double schaden = 0;
		

		p("//> "+this.getSpellname()+" <//");
		punkte(3,200);

		// gegnercheck
		if (g.getClassS() == Classes.SHELDON) {
			spezial("* JA heilt Sheldon um 500 Leben! *");
			g.kampf(500);
		} else if (g.getClassS() == Classes.NEINHEIT) {
			p("// JA ZUM LEBEN!!! //");
			p("Du schaust erleuchtet hoch und streckst deine Arme in den Himmel! ausserdem zeigst du der neinheit den MITTELFINGER !!!");
			punkte(); 
			h.addL(40000);
			if (chance(30)) {
				p("Deine Erleuchtung ver5-facht deine Zauberkraft");
				h.reM(5);
			} else if (chance(30)) {
				p("Deine Erleuchtung ver20-facht deine Zauberkraft");
				h.reM(20);
			} else {
				p("Ein Vogel kackt dir ins Gesicht! Du bekommst 10000 Schaden! Unangenehm!");
				h.kampf(-10000);
			}
		} else if (g.getClassS() == Classes.SHELDON) {
			p("* JA heilt Sheldon um 500 Leben! *");
			g.kampf(500);
		} else if (g.getClassS() == Classes.SHELDON) {
			p("* JA heilt Sheldon um 500 Leben! *");
			g.kampf(500);
		} else if (g.getClassS() == Classes.KRIEGER) {
			p("* Krieger unterbricht deine Jasagung! *");
		} else {
			p("// JA ZUM LEBEN!!! //");
			p("Du schaust erleuchtet hoch und streckst deine Arme in den Himmel!");
			punkte();
			p("Du heilst alle um 400 Leben!"); h.addL(400); g.addL(400);
			if (chance(30)) {
				p("Deine Erleuchtung ver2-facht deine Zauberkraft");
				h.reM(2);
			} else if (chance(30)) {
				p("Deine Erleuchtung ver5-facht deine Zauberkraft");
				h.reM(5);
			} else {
				p("Ein Vogel kackt dir ins Gesicht! Du bekommst 20000 Schaden! Unangenehm!");
				h.kampf(-20000);
				h.reM(0.8); h.reA(0.8); h.reG(0.8);
			}
		}
		
		return schaden;
	}
}
