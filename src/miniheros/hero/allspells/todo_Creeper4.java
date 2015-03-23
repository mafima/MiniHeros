package miniheros.hero.allspells;

import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;

public class todo_Creeper4 extends Spell{
	
	public todo_Creeper4(){
		// HEROWERTE: createHero(0, 1, 5, 3000, 900, 2, Values.POWERcreeper);
		// (spellname, 							cooldowns:  start - set       			NEED               COST
		super("...sss BOOOOOOM!!!",
															40, 		500,     			0, 0, 0, 0, 0,     0, 0, 0, 0, 150*Hero.life);
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
			p(">>> DEINE ZEIT IST GEKOMMEN! AUFLADUNG FERTIG! <<<");
			punkte(10,200);
			if (chance(200-g.getG())) {
				p(">>> VOLLTREFFER! <<<");
				p("Dein Vater Notch ist stolz auf dich!");
				schaden = h.getM();
			} else {
				p("> Der Gegner ist ausgewichen! Du bist tot!");
				h.kampf(-99999, "explosion");
			}

		}
		
		return schaden;
	}
}
