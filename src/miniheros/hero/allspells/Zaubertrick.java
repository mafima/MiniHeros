package miniheros.hero.allspells;


import main.MiniHeros;
import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;
import miniheros.util.help;

public class Zaubertrick extends Spell{
	
	public Zaubertrick(){
		// (String name, long cd, long cdset, float needa, float needg, float needh, float needm, float needl, float costa, float costg, float costh, float costm, float costl)
		super("* .Zaubertrick. *", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 0);
	}

	public float cast(Hero h, Hero g) {
		float schaden = 0;
		help.p("//> "+this.getSpellname()+" <//");
		if (MiniHeros.dev < 2) help.punkte(5,500);
		
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
					h.reM(0.5);
					schaden = (float) Math.ceil(h.getM() * 0.5);
				} else if (help.chance(40)) {
					help.p("///> Gedankenraub <///");
					help.p("~ Du buendelst Hirn und Magiekraft um einen Energiestrahl zu erzeugen! ~");
					help.p("# " + h.getpName() + " Angriff und Geschick um 10%, Hirn um 30% reduziert.");
					schaden = (float) (2 * h.getH() * (h.getM() / (h.getM() + 100)));
					g.setA(g.getA() * 0.9);
					g.setG(g.getG() * 0.9);
					g.setH(g.getH() * 0.7);
					h.setM(0);
				} else {
					help.p("///- Schattenfeuer _.xxXX) -///");
					schaden = (float) (0.4*h.getM() + (g.getL() * 0.05));
					h.reM(0);
				}
			}
			return schaden;
		}
}
