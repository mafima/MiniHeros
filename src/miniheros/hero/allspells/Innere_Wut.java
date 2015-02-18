package miniheros.hero.allspells;

import main.MiniHeros;
import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;

public class Innere_Wut extends Spell{
	
	public Innere_Wut(){
		// HEROWERTE:
		// (spellname, 							cooldowns:  start - set       			NEED               COST
		super("Innere Wut",
															0, 		10,     			0, 0, 0, 0, 0,     0, 0, 0, 0, 0);
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
			pfeile("Du schaust den Gegner an und fragst dich wieso soetwas Abscheuliches noch lebt! Deine Wut steigert sich stark!");
			p("* Sheldon steigert deine Wut 10fach so stark! *");		
			punkte(3,200);
				pfeile("Dein Blut kocht vor Wut!!!");
				h.reG(11);
				h.addA(200);
				schaden = (int) Math.ceil(h.getG()*2 + h.getA()*0.1);
		} else if (g.getClassS() == Classes.ELF) {
		
		} else if (g.getClassS() == Classes.GNOM || g.getClassS() == Classes.MAGIER) {
			
		} else if (g.getClassS() == Classes.SHELDON) {
			
		} else if (g.getClassS() == Classes.SHELDON) {
			
		} else if (g.getClassS() == Classes.SHELDON) {
			
		} else if (g.getClassS() == Classes.SHELDON) {
			
		} else {
			pfeile("Du schaust den Gegner an und fragst dich wieso soetwas Abscheuliches noch lebt! Deine Wut steigert sich stark!");
			punkte(3,200);
			if (chance(90-(70*h.getmissing()))) {
				pfeile("Dein Blut kocht vor Wut!!!");
				h.reG(1.4);
				h.addA(40);
				schaden = (int) Math.ceil(h.getG()*2 + h.getA()*0.1);
			} else {
				p("> Du wirst du wuetend und haust auf den Boden!");
				
				h.kampf(-50*MiniHeros.heat);
			}

		}
		return schaden;
	}
}
