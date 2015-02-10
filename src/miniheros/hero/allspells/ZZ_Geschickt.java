package miniheros.hero.allspells;

import main.MiniHeros;
import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;
import miniheros.util.Help;

public class ZZ_Geschickt extends Spell{

	public ZZ_Geschickt(){
		// Held stats:					     0, 0, 0, 0, 0
		// (String name, 					 CD CDSET       NEED               COST
		super(">>> geschickter Angriff!",	 0, 1,     		1, 0, 0, 0, 0,     0, 0, 0, 0, 0);
	}

	public double cast(Hero h, Hero g) {
		this.castcd();
		double schaden = 0;
		p("//> "+this.getSpellname()+" <//");
		if (MiniHeros.dev < 2) punkte(3,200);

		if (g.getClassS() == Classes.SHELDON) {
			spezial("Sheldon: Diese Regeln stehen nicht in der Einwohnervereinbahrung! Schaden auf 0 gesetzt!");
		} else if (g.getClassS() == Classes.JESUS) {
			spezial("JESUS: Du kannst mich aufhaengen, mich quaelen, aber ich werde NIIIIIIIEMALS STERBEN!!! ");
		} else if (g.getClassS() == Classes.GOTT) {
			spezial("* GOTT: Dieser Angriff wird mich nicht erreichen. ");
		} else {
			spezial(" Geschickter Angriff! ->>> ");
			schaden = (int) Math.ceil((1 + h.getG() / (h.getG() + 333.33)) * h.getA() * (1 - g.getG() / (g.getG() + 333.33)));
		}

		if (g.getClassS() == Classes.DRACHE||g.getClassS() == Classes.EISDRACHE) schaden*=0.4;
		return schaden;
	}
}