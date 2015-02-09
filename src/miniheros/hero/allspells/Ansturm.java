package miniheros.hero.allspells;

import main.MiniHeros;
import miniheros.hero.Hero;
import miniheros.hero.Spell;
import miniheros.util.help;

public class Ansturm extends Spell{
	
	public Ansturm(){
		super("Ansturm", 0, 1, 5, 10, 0, 0, 0, 0, 0, 0, 0, 0);
	}
	
	@Override
	public double cast(Hero hero, Hero gegner) {
		double schaden = 0;
		System.out.println("Anstuuuurm! ");
		if (MiniHeros.dev < 2) help.warte(2000);
		schaden = 100;
		return schaden;
	}

}
