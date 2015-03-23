package miniheros.hero.allspells;


import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;

public class Drache4 extends Spell{
	
	public Drache4(){
		// createHero(100, 10, 2, 80, 2000, Values.POWERdrache);
		// (String name, 		           CD CDSET       NEED               COST
		super("{} Drachenbiss des Todes {}", 4, 50,       0, 0, 0, 0, 0,         0, 0, 0, 100, 0);
	}

	public double cast(Hero h, Hero g) {
		this.castcd();
		double schaden = 0;
		p("//> "+this.getSpellname()+" <//");
		punkte(5,500);
		
		if (g.getClassS() == Classes.SHELDON) {
			p("* Drache hat keine Lust Shelden aufzuessen! Zu eklig! *");
			return 0;
		} else if (g.getClassS() == Classes.GNOM) {
			p("* Gnom ist zu klein um ihn aufzuessen! *");
			return 0;
		} else if (g.getClassS() == Classes.ZWERG) {
			p("* Zwerg ist zu klein um ihn aufzufressen! *");
			return 0;
		} else {
			p("// Drachenbiss //");
			p("Du stuerzt dich auf den Gegner und beisst den Kopf von "+g.getpName()+" ab!");
			schaden = (double) (130+h.getM()*(1-(g.getmissing())));
			h.reM(0);
		}
			return schaden;
		}
}