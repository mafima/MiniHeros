package miniheros.hero.allspells;

import main.Textarena;
import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;
import miniheros.util.Help;

public class ZZ_Intelligent extends Spell{

	public ZZ_Intelligent(){
		// Held stats:					     0, 0, 0, 0, 0
		// (String name, 					 CD CDSET       NEED               COST
		super("intelligenter Angriff!",	 	0, 1,     		1, 0, 0, 0, 0,     0, 0, 0, 0, 0);
	}

	public double cast(Hero h, Hero g) {
		this.castcd();
		double schaden = 0;
		p("//> "+this.getSpellname()+" <//");

		if (g.getClassS() == Classes.SHELDON) {
			p("* Sheldon: Diese Regeln stehen nicht in der Einwohnervereinbahrung! Schaden auf 0 gesetzt! *");
		} else if (g.getClassS() == Classes.JESUS) {
			p("* JESUS: NEIIIIN, NICHT DEIN HIRN AN MACHEN!!!! AHHHH *TOT* *");
			schaden= g.getL();
		} else if (g.getClassS() == Classes.GOTT) {
			p("* GOTT: Zu zweifelst an mir??? *");
			schaden= g.getL();
		} else {
			schaden += (int) Math.ceil(malor(h.getH()*h.getH(),300)*30);
			p(h.getpName()+"liest ein dickes Buch und wirft es auf "+g.getpName() + "! Wurfschaden: "+schaden);
			p(h.getpName()+"versucht etwas Intelligentes zu machen!");
			punkte();
			     if (h.getH() > (g.getH()*1.20)) {
		         double hirnevent = (double) (h.getH() - g.getH())*Math.random();
		         if (hirnevent > 300) {
		         schaden += Math.ceil(((h.getH() - g.getH())*0.05 + 2)*150);
		         
		         p("OOOHH NEIN!!!! "+h.getpName() + "zaehlt alle Stellen von Pi auf!!!! "+ Math.ceil(((h.getH() - g.getH())*0.05 + 2)*150) + " Schaden!");
		         g.reH(0.7);
		         h.reM(1.2);
		         } else if (hirnevent > 120) {
		         schaden += Math.ceil((h.getH() - g.getH())*0.2 + 70);
		         p( h.getpName() + Math.ceil((h.getH() - g.getH())*0.2 + 70) +" Schaden durch Matheunterricht!");
		         h.addM(100);
		         } else if (hirnevent > 30) {
		         schaden += Math.ceil((h.getH() - g.getH())*0.2 + 20);
		         p( h.getpName() + Math.ceil((h.getH() - g.getH())*0.2 + 20) +" Schaden durch Intelligentes Gelaber verursacht!");
		         h.addM(20);
		         } else {
		         p(h.getpName()+"war zu doof! Er ist nur im Kreis gelaufen. Mehr nicht.");
		         }
		         }
		}
		if (g.getClassS() == Classes.DRACHE||g.getClassS() == Classes.EISDRACHE) {
			schaden*=0.4;
			spezial("Schaden um 40% reduziert, weil dein Gegner ein Drache ist!");
		}
		return schaden;
	}
}