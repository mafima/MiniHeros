package miniheros.hero.allspells;

import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;

public class Marsch extends Spell{
	
	public Marsch(){
		// HEROWERTE: (menschdefault:) createHero(10, 20, 50, 0, 200, Values.POWERmensch); 
		// (spellname, 							cooldowns:  start - set       			NEED               COST
		super("MARSCH!",
															0, 		12,     			0, 0, 0, 0, 0,     0, 0, 0, 0, 0);
	}

	public double cast(Hero h, Hero g) {
		this.castcd(); // setzt den cooldown auf cooldownset
		double schaden = 0; // schaden is by default 0
		double effekt = 1;
		
		p("//> "+this.getSpellname()+" <//"); // zeigt den Zauber kurz an
		warte(600);
		punkte(3,200);	// erstellt 3 schnelle punkte. zeit zwischen den punkten: 200 ms

		// gegnercheck. checkt alle gegner durch.
		if (g.getClassS() == Classes.SHELDON) {
			p("* Sheldon findet das komisch. Er schreit: HIER WIRD NICHT MARSCHIERT! *");
			return 0;
		} else if (g.getClassS() == Classes.ELF || g.getClassS() == Classes.ORK) {
			effekt = 0.75;
		} else if (g.getClassS() == Classes.GNOM || g.getClassS() == Classes.MAGIER) {
			effekt = 1.25;
		} else if (g.getClassS() == Classes.SHELDON) {
			
		} else if (g.getClassS() == Classes.SHELDON) {
			
		} else if (g.getClassS() == Classes.SHELDON) {
			
		} else if (g.getClassS() == Classes.SHELDON) {
			
		} else {

		}
		
		if (chance(95-h.getG()*0.05)) {
			p("Du marschierst auf den Gegner zu und deine Wut steigt!");
			h.reG(1.25*effekt);
			h.reA(1.1*effekt);
		} else {
			p("> Dein Gegner unterbricht deinen Marsch durch einen schnellen Angriff!");
			h.kampf(-g.getG()*0.01);
		}
		
		return schaden;
	}
}
