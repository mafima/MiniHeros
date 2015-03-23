package miniheros.hero.allspells;

import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;

public class ZZ_Zaubertrick extends Spell{
	
	public ZZ_Zaubertrick(){
		// Held stats:				xxxxxxxx	     ZZ SPELL
		// (spellname, 				cooldowns:  start - set       			NEED               COST
		super("*~.Zaubertrick.~*", 
												0, 10,     					0, 0, 20, 1, 0,     0, 0, 0, 0, 0);
	}

	public double cast(Hero h, Hero g) {
		this.castcd();
		double schaden = 0;
		p("//> "+this.getSpellname()+" <//");
		punkte(3,800);
		
			if (g.getClassS() == Classes.SHELDON) {
				p("/// PSYSTRAHL ///");
				p("* Sheldon: Magie gehorscht keinen Physikalischen Gesetzen!!! WIE KANN ES MIR SCHADEN MACHEN! AHHH *");
				h.setM(0);
				schaden = (int) h.getM();
			} else if (g.getClassS() == Classes.JESUS) {
				p("* JESUS: Magie ist gegen mich sinnlos! *");
			} else if (g.getClassS() == Classes.GOTT) {
				p("* GOTT: Niemand zweifelt an Gott. *");
			} else {
				if (chance(30)) {
					p("// mieser Zaubertrick -> //");
					p("~ Dein Held fuehrt einen raeudigen Zaubertrick aus. Das Publikum lacht "+h.getpName()+" aus! ~");
					h.reM(0.95);
					schaden = (5+h.getM() * 0.05);
				} else if (chance(40)) {
					p("///> Gedankenraub <///");
					p("~ Du buendelst Hirn und Magiekraft um einen Energiestrahl zu erzeugen! ~");
					schaden = (double) (50 + 2 * h.getH() * (h.getM() / (h.getM() + 100)));
					g.reG(0.9);
					g.reH(0.7);
					h.addM(-40);
				} else {
					p("///- Schattenfeuer _.xxXX) -///");
					p("~ Du buendelst all deine Magiekraft um einen Schattenfeuer zu erzeugen! ~");
					schaden = (double) (100+ 0.5*h.getM() + (g.getL() * 0.05));
					h.reM(0);
				}
			}
			return schaden;
		}
}