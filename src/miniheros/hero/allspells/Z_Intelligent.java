package miniheros.hero.allspells;

import main.MiniHeros;
import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;
import miniheros.util.help;

public class Z_Intelligent extends Spell{

	public Z_Intelligent(){
		// Held stats:					     0, 0, 0, 0, 0
		// (String name, 					 CD CDSET       NEED               COST
		super("intelligenter Angriff!",	 	0, 1,     		1, 0, 0, 0, 0,     0, 0, 0, 0, 0);
	}

	public double cast(Hero h, Hero g) {
		this.setcd();
		double schaden = 0;
		help.p("//> "+this.getSpellname()+" <//");

		if (g.getClassS() == Classes.SHELDON) {
			help.p("* Sheldon: Diese Regeln stehen nicht in der Einwohnervereinbahrung! Schaden auf 0 gesetzt! *");
		} else if (g.getClassS() == Classes.JESUS) {
			help.p("* JESUS: NEIIIIN, NICHT DEIN HIRN AN MACHEN!!!! AHHHH *TOT* *");
			schaden= g.getL();
		} else if (g.getClassS() == Classes.GOTT) {
			help.p("* GOTT: Zu zweifelst an mir??? *");
			schaden= g.getL();
		} else {
			schaden = (int) Math.ceil(help.malor(h.getH()*h.getH(),300));
			help.p(h.getpName()+"liest ein dickes Buch und wirft es auf "+g.getpName() + "! Wurfschaden: "+schaden);
			help.p(h.getpName()+"versucht etwas Intelligentes zu machen!");
			if (MiniHeros.dev < 2) help.punkte();
			     if (h.getH() > (g.getH()*1.20)) {
		         double hirnevent = (double) (h.getH() - g.getH())*Math.random();
		         if (hirnevent > 300) {
		         schaden += Math.ceil(((h.getH() - g.getH())*0.05 + 2)*150);
		         
		         help.p(MiniHeros.prefix + "OOOHH NEIN!!!! "+h.getpName() + "zaehlt alle Stellen von Pi auf!!!! "+ Math.ceil(((h.getH() - g.getH())*0.05 + 2)*150) + " Schaden!");
		         g.reH(0.3);
		         g.reA(0.2);
		         } else if (hirnevent > 120) {
		         schaden += (h.getH() - g.getH())*0.2 + 20;
		         help.p(MiniHeros.prefix + h.getpName() + Math.ceil((h.getH() - g.getH())*0.2 + 70) +" Schaden durch Matheunterricht!");
		         } else if (hirnevent > 30) {
		         schaden += (h.getH() - g.getH())*0.2 + 20;
		         help.p(MiniHeros.prefix + h.getpName() + Math.ceil((h.getH() - g.getH())*0.2 + 20) +" Schaden durch Ueberheblichkeit verursacht!");
		         g.reG(1.2);
		         } else {
		         help.p("Versuch ging daneben!");
		         }
		         }
		}
		if (g.getClassS() == Classes.DRACHE||g.getClassS() == Classes.EISDRACHE) schaden*=0.4;
		return schaden;
	}
}