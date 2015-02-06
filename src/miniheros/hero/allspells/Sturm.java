package miniheros.hero.allspells;

import main.MiniHeros;
import miniheros.hero.Hero;
import miniheros.hero.Spell;
import miniheros.util.help;

public class Sturm extends Spell{
	
	public Sturm(){
		// (String name, 		 CD CDSET       NEED               COST
		super("Sturm",  		0, 0, 			0, 0, 0, 0, 0,     0, 0, 0, 10, 0);
	}

	public float cast(Hero h, Hero g) {
		this.setcd();
		float schaden = 0;
		help.p("//> "+this.getSpellname()+" <//");
		if (MiniHeros.dev < 2) help.punkte(5,500);


		
		help.p("//> "+this.getSpellname()+" <//");
		if (MiniHeros.dev < 2) help.punkte(5,1000);
		schaden = (float) (10+h.getH());
		return schaden;
	}

}
