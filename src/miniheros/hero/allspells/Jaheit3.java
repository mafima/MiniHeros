package miniheros.hero.allspells;

import main.Textarena;
import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;
import miniheros.util.Help;

public class Jaheit3 extends Spell{
	
	public Jaheit3(){
		//	JAHEIT -		createHero(1000, 8000, 100, 100, 50000, 2, Values.POWERjaheit);
		// (spellname, 				cooldowns:  start - set       			NEED               COST
		super("JAAA KLAAAR!",
												1, 		20,     				0, 0, 0, 0, 0,     0, 0, 0, 0, 0);
	}

	public double cast(Hero h, Hero g) {
		this.castcd();
		double schaden = 0;
		

		p("//> "+this.getSpellname()+" <//");
		punkte(3,200);

		// gegnercheck
		if (g.getClassS() == Classes.SPIDERPIG) {
			Help.p("* zu SPIDERPIG kann man nur JA sagen! *");
			Help.p("Du streichelst das Spiderpig");
		} else {
			if (chance(85)) {
				Help.p(">>> Du schreist so laut, dass 9 Ja-Kampfeinheiten sich dir anschliessen! <<<");
				h.reM(10);
			} else {
				Help.p("X-X "+g.getpName()+" schreit zurueck: JA is gut, beruhig dich, Peter! X-X");
			}
			Help.p("Der Schrei reinigt deine Lunge. Heilung um 2000 Leben!");
			h.kampf(2000);
		}
		
		return schaden;
	}
}
