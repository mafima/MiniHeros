package miniheros.hero.allspells;

import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;

public class Ork4 extends Spell{

	public Ork4(){
		// HEROWERTE: createHero(1000, 50, 50000, 1, 50000, 0.1, Values.POWERneinheit);
		// (spellname, 							cooldowns:  start - set       			NEED               COST
		super("- Spaltung -",
				0, 		12,     			0, 0, 0, 0, 0,     0, 0, 0, 0, 0);
		// BEISPIEL: der zauber soll 15 Magie kosten!	 	0,		12,     			0, 0, 0, 0, 0,     0, 0, 0, 15, 0);
		// BEISPIEL: der zauber soll 20 Geschick brauchen!	0,		12,     			0, 20, 0, 0, 0,     0, 0, 0, 0, 0);
		// BEISPIEL: der zauber soll nur alle 20 sekunden einsetzbar sein und 30 magie und geschick kosten!	
		//													0,		20,     			0, 0, 0, 0, 0,     0, 30, 0, 30, 0);
	}

	public double cast(Hero h, Hero g) {
		this.castcd(); // setzt den cooldown auf cooldownset
		double schaden = 0; // schaden is by default 0

		p("//> "+this.getSpellname()+" <//"); // zeigt den Zauber kurz an
		punkte(3,200);	// erstellt 3 schnelle punkte. zeit zwischen den punkten: 200 ms

		// gegnercheck. checkt alle gegner durch.
		if (g.getClassS() == Classes.SHELDON) {
			p("* Sheldon stirbt sofort! *");
		} else if (g.getClassS() == Classes.ELF) {

		} else if (g.getClassS() == Classes.GNOM || g.getClassS() == Classes.MAGIER) {

		} else if (g.getClassS() == Classes.SHELDON) {

		} else if (g.getClassS() == Classes.SHELDON) {

		} else if (g.getClassS() == Classes.SHELDON) {

		} else if (g.getClassS() == Classes.SHELDON) {

		} else {
			pfeile("Ork rennt auf Gegner zu und springt ab!");
			punkte();
			if (chance(90-60*malor(g.getG()))) {
				double biggest = g.getA();
				if (g.getG()> biggest) biggest = g.getG();
				if (g.getH()> biggest) biggest = g.getH();
				if (g.getM()> biggest) biggest = g.getM();

				if (biggest == g.getA()) {
					p(">>> Treffer! Du zerspaltest die Waffe des Gegners! <<<");
					g.reA(0.5);
				} else if (biggest == g.getG()) {
					p(">>> Treffer! Du zerspaltest den Arm des Gegners! <<<");
					g.reG(0.5);
				} else if (biggest == g.getH()) {
					p(">>> Treffer! Du zerspaltest das Taschenbuch deines Gegners! <<<");
					g.reH(0.5);
				} else if (biggest == g.getM()) {
					p(">>> Treffer! Du zerspaltest die Zauberkraft des Gegners! <<<");
					g.reM(0.5);
				}
				schaden = h.getA()*malor(h.getG(),200);
			} else {
				p("> Du zernichtest den Boden! Der Gegner konnte leider ausweichen! Wut steigt.");
				h.reG(1.1);
			}

		}

		return schaden;
	}
}
