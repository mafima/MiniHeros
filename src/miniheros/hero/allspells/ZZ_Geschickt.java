package miniheros.hero.allspells;

import main.Textarena;
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
		if (Textarena.dev < 2) punkte(6,200);

		if (g.getClassS() == Classes.SHELDON) {
			spezial("Sheldon: Diese Regeln stehen nicht in der Einwohnervereinbahrung! Schaden auf 0 gesetzt!");
		} else if (g.getClassS() == Classes.JESUS) {
			spezial("JESUS: Du kannst mich aufhaengen, mich quaelen, aber ich werde NIIIIIIIEMALS STERBEN!!! ");
		} else if (g.getClassS() == Classes.GOTT) {
			spezial("* GOTT: Dieser Angriff wird mich nicht erreichen. ");
		} else {
			spezial(" Geschickter Angriff! ->>> ");
			schaden = (int) Math.ceil(h.getG()*0.01 + h.getA() * (1 + malor(h.getG(),333)));

			double critevent = (double) ((h.getG())*Math.random());
			if (critevent > 1000) {
				schaden = schaden *3;
				p(".........................-<<< HYPE >>>-.........................",3,1500);
				spezial("Deine Geschwindigkeit durchbricht die Schallmauer! Niemand hat genau gesehen was passiert ist, aber die Kehle, die Beine und Arme deines Gegners sind zerrissen !!!");
				p("10-facher Schaden!");
			} else if (critevent > 199) {
				schaden = schaden *2;
				spezial(" <<<SCHATTENSPRUNG>>> ");
				p("Du rast auf deinen Gegner zu! Direkt vor ihm verschwindest und tauchst in die Schatten ein! Du erscheinst hinter deinem Gegner und greifst an!");
				p("3-facher Schaden!");
			} else if (critevent > 99) {
				schaden = schaden *1.5;
				p("Du wirfst alle Gegenstaende in der Umgebung auf "+g.getpName()+"! Er verliert die Orientierung");
				p("50% mehr Schaden!");
			} else if (critevent > 50) {
				schaden = schaden *1.25;
				p("25% mehr Schaden!");
			} else if (critevent > 20) {
				schaden = schaden *1.1;
				p("10% mehr Schaden durch boesen Blick!");
			} else {
				p("Du rennst auf deinen Gegner zu und greifst an!");
			}
		}

		if (g.getClassS() == Classes.DRACHE||g.getClassS() == Classes.EISDRACHE) schaden*=0.4;
		return schaden;
	}
}