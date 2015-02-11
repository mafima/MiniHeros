package miniheros.hero.allspells;

import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;

public class AA_Spell_Tutorial extends Spell{
	
	public AA_Spell_Tutorial(){
		// HEROWERTE: createHero(1000, 50, 50000, 1, 50000, 0.1, Values.POWERneinheit);
		// (spellname, 							cooldowns:  start - set       			NEED               COST
		super("+++ Steinwurf +++",
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
			p("* Sheldon sagt NEIN zu deinem Stein! *");
		} else if (g.getClassS() == Classes.GNOM || g.getClassS() == Classes.MAGIER) {
			spezial("* Ultimativer Steinwurfnicht gegen so schlaue Person einsetzbar! *");
		} else { 
			// ELSE klammer! Dieser Code wird MEISTENS ausgefuehrt!
			p(">>> Du wirfst einen STEIN auf den Gegner! <<<");
			punkte(3,400);
			if (chance(100-g.getG())) {
				p(">>> Treffer! Du triffst einen Baum, der auf deinen Gegner faellt! <<<");
				schaden = (int) Math.ceil(h.getG()*2 + h.getA()*0.1);
			} else {
				p("> Ein Polizist lauft vorbei und fragt sich warum du mit Steinen wirfst! Sein boeser Blick verursacht 300 Schaden!");
				h.kampf(-300);
			}
			
			// HIER IST ALLES MOEGLICH!
			// WERTE ADDIEREN: h.addG(20); addiert 20 geschick zum held.
			// WERTE mal nehmen: h.reG(1.4); Geschick steigt um 40%
		}
		
		return schaden;
	}
}
