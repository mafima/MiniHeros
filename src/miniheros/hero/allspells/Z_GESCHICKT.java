package miniheros.hero.allspells;

import main.MiniHeros;
import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;
import miniheros.util.help;

public class Z_GESCHICKT extends Spell{

	public Z_GESCHICKT(){
		// Held stats:					     0, 0, 0, 0, 0
		// (String name, 					 CD CDSET       NEED               COST
		super(">>> geschickter Angriff!",	 0, 0,     		1, 0, 0, 0, 0,     0, 0, 0, 0, 0);
	}

	public float cast(Hero h, Hero g) {
		this.setcd();
		float schaden = 0;
		help.p("//> "+this.getSpellname()+" <//");
		if (MiniHeros.dev < 2) help.punkte(5,500);

		if (g.getClassS() == Classes.SHELDON) {
			help.spezialfall("Sheldon: Diese Regeln stehen nicht in der Einwohnervereinbahrung! Schaden auf 0 gesetzt!");
		} else if (g.getClassS() == Classes.JESUS) {
			help.spezialfall("JESUS: Du kannst mich aufhaengen, mich quaelen, aber ich werde NIIIIIIIEMALS STERBEN!!! ");
		} else if (g.getClassS() == Classes.GOTT) {
			help.spezialfall("* GOTT: Dieser Angriff wird mich nicht erreichen. ");
		} else {
			help.spezialfall(" Geschickter Angriff! ->>> ");
			schaden = (int) Math.ceil((1 + h.getG() / (h.getG() + 333.33)) * h.getA() * (1 - g.getG() / (g.getG() + 333.33)));
		}

		if (g.getClassS() == Classes.DRACHE||g.getClassS() == Classes.EISDRACHE) schaden*=0.4;
		return schaden;
	}
}