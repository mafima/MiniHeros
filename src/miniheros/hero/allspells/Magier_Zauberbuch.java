package miniheros.hero.allspells;

import main.MiniHeros;
import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;
import miniheros.util.Help;

public class Magier_Zauberbuch extends Spell{
	
	public Magier_Zauberbuch(){
		// createHero(5, 10, 200, 300, 400, Values.POWERmagier, 1.1);
		// (String name, 			CD CDSET       			NEED               COST
		super("Zauberbuch", 		0, 4,     				0, 0, 0, 0, 0,     0, 0, 0, 0, 0);
	}

	public double cast(Hero h, Hero g) {
		this.castcd();
		double schaden = 0;
		

		p("//> "+this.getSpellname()+" <//");
		if (MiniHeros.dev < 2) punkte(3,200);

		h.setM(50+(h.getM()*1.20));
		h.reH(1.4);
		Help.p("// Zauberbuch - Du lernst neue Zaubersprueche. Deine Zauberkraft steigt auf: "+h.getM());
		if (chance(10)) {
			Help.p("// +++ Heilzauber +++ // Du heilst dich um "+150*((int) MiniHeros.heat)+" Leben!");
			h.kampf(150*((int) MiniHeros.heat));
		} else if (chance(40)) {
			Help.p("// Buchwurf! // Du wirfst dein Buch dem Gegner ins Gesicht!");
			return 120;
		}

		return schaden;
	}
}
