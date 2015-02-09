package miniheros.hero.allspells;


import main.MiniHeros;
import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;
import miniheros.util.help;

public class Z_Zaubertrick extends Spell{
	
	public Z_Zaubertrick(Hero h){
		// Held stats:					     0, 0, 0, 0, 0
		// (String name, 		 CD CDSET       NEED               COST
		super("*~.Zaubertrick.~*", 0, 1,     0, 0, 10, 1, 0,     0, 0, 0, 0, 0);
	}

	public double cast(Hero h, Hero g) {
		this.setcd();
		double schaden = 0;
		help.p("//> "+this.getSpellname()+" <//");
		if (MiniHeros.dev < 2) help.punkte(3,800);
		
			if (g.getClassS() == Classes.SHELDON) {
				help.p("/// PSYSTRAHL ///");
				help.p("* Sheldon: Magie gehorscht keinen Physikalischen Gesetzen!!! WIE KANN ES MIR SCHADEN MACHEN! AHHH *");
				h.setM(0);
				schaden = (int) h.getM();
			} else if (g.getClassS() == Classes.JESUS) {
				help.p("* JESUS: Magie ist gegen mich sinnlos! *");
			} else if (g.getClassS() == Classes.GOTT) {
				help.p("* GOTT: Niemand zweifelt an Gott. *");
			} else {
				if (help.chance(30)) {
					help.p("// mieser Zaubertrick -> //");
					help.p("~ Dein Held fuehrt einen raeudigen Zaubertrick aus. Das Publikum lacht "+h.getpName()+" aus! ~");
					h.reM(0.8);
					schaden = (10+h.getM() * 0.25);
				} else if (help.chance(40)) {
					help.p("///> Gedankenraub <///");
					help.p("~ Du buendelst Hirn und Magiekraft um einen Energiestrahl zu erzeugen! ~");
					help.p("# " + h.getpName() + " Angriff und Geschick um 10%, Hirn um 30% reduziert.");
					schaden = (double) (50 + 2 * h.getH() * (h.getM() / (h.getM() + 100)));
					g.reA(0.9);
					g.reG(0.9);
					g.reH(0.7);
					h.reM(0);
				} else {
					help.p("///- Schattenfeuer _.xxXX) -///");
					help.p("~ Du buendelst all deine Magiekraft um einen Schattenfeuer zu erzeugen! ~");
					schaden = (double) (100+ 0.5*h.getM() + (g.getL() * 0.05));
					h.reM(0);
				}
			}
			return schaden;
		}
}