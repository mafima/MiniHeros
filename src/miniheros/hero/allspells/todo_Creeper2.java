package miniheros.hero.allspells;

import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;
import miniheros.hero.Values;

public class todo_Creeper2 extends Spell{
	
	public todo_Creeper2(){
		// HEROWERTE: createHero(0, 1, 5, 3000, 900, 2, Values.POWERcreeper);
		// (spellname, 							cooldowns:  start - set       			NEED               COST
		super("Night Time B*tch!",
															0, 		0,     			0, 0, 0, 0, 0,     0, 0, 0, 0, 0);
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
			p("* Sheldon sagt NEIN! *");
		} else if (g.getClassS() == Classes.ELF || g.getClassS() == Classes.ORK) {
			
		} else if (g.getClassS() == Classes.GNOM || g.getClassS() == Classes.MAGIER) {
			
		} else if (g.getClassS() == Classes.SHELDON) {
			
		} else if (g.getClassS() == Classes.SHELDON) {
			
		} else if (g.getClassS() == Classes.SHELDON) {
			
		} else if (g.getClassS() == Classes.SHELDON) {
			
		} else {
			p(">>> Du und deine Monster Freunde greifen an! <<<");
			punkte(3,400);
			if (chance(10)) {
				p("> Du findest eine Kiste des Gegners mit Schwertern drin und klaust den Inhalt!");
				h.addA(rand(20));
			} else {
				schaden = (h.getA()*0.5)/malor(g.getG());
			}

		}
		
		return schaden;
	}
}
