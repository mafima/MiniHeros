package miniheros.hero.allspells;

import main.MiniHeros;
import miniheros.hero.Hero;
import miniheros.hero.Spell;
import miniheros.util.help;

public class Sturm extends Spell{
	
	public Sturm(){
		// (String name, String[] spelltext, long cd, long cdset, float needa, float needg, float needh, float needm, float needl, float costa, float costg, float costh, float costm, float costl)
		super("Sturm", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 0);
		super.setCooldownset(2000);
	}

	public float cast(Hero hero, Hero gegner) {
		this.setcd(super.getCooldownset());
		float schaden = 0;
		
		help.p("//> "+this.getSpellname()+" <//");
		if (MiniHeros.dev < 2) help.punkte(5,1000);
		schaden = (float) (10+hero.getH());
		return schaden;
	}

}
