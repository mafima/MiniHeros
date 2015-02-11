package miniheros.hero.allspells;

import main.MiniHeros;
import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;
import miniheros.util.Help;

public class Jaheit2 extends Spell{
	
	public Jaheit2(){
		//	JAHEIT -		createHero(1000, 8000, 100, 100, 50000, 2, Values.POWERjaheit);
		// (spellname, 				cooldowns:  start - set       			NEED               COST
		super("Ich sage immer JA!",
												1, 		8,     				0, 0, 0, 0, 0,     0, 0, 0, 30, 0);
	}

	public double cast(Hero h, Hero g) {
		this.castcd();
		double schaden = 0;
		

		p("//> "+this.getSpellname()+" <//");
		punkte(3,200);

		// gegnercheck
		if (g.getClassS() == Classes.SHELDON) {
			p("* Sheldon sagt Nope! *");
			return 0;
		} else {
			int x = (int) Math.ceil(Math.random()*30);
			p(">>> DU SAGST JA ZU GENPRODUKTE! Du mutierst und verdoppelst dich "+x+" mal!");
			p("Deine Doppelkaenger sind stark agressiv. Sie greifen alle an!");
			schaden = (int) Math.ceil(x*h.getM()*0.01);
			if(chance(20)) {
				p("Einer deiner Doppelkaenger gibt dir einen Kuchen!");
				h.addM(x*100);
			} if (chance(30)) {
				Help.p("Einer deiner Doppelkaenger gibt dir einen Crysis 3 Kampfanzug!");
				h.reG(4); h.reA(2);
			} if (chance(40)) {
				Help.p("All deine Doppelgaenger explodieren.");
				h.kampf((-500*x));
			} else {
				Help.p("All deine Doppelgaenger werden zu Feenstaub. Du musst husten!");
				h.reG(0.8);
			}
		}
		
		return schaden;
	}
}
