package miniheros.hero.allspells;

import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;

public class Hitler1_Heil extends Spell{

	public Hitler1_Heil(){
		// HEROWERTE: createHero(300, 30, 500, 0, 900, 2, Values.POWERhitler);
		// (spellname, 							cooldowns:  start - set       			NEED               COST
		super("!!! HEIL HITLER !!!",
				0, 		0,     			0, 0, 0, 0, 0,     0, 0, 0, 0, 0);
	}

	public double cast(Hero h, Hero g) {
		this.castcd(); // setzt den cooldown auf cooldownset
		double schaden = 0; // schaden is by default 0

		p("SIEG HEIL!"); // zeigt den Zauber kurz an

		// gegnercheck. checkt alle gegner durch.
		if (g.getClassS() == Classes.SHELDON) {
			p("* Sheldon sagt HEIL! *");
		} else if (g.getClassS() == Classes.ELF || g.getClassS() == Classes.ORK) {

		} else if (g.getClassS() == Classes.GNOM || g.getClassS() == Classes.MAGIER) {

		} else if (g.getClassS() == Classes.SHELDON) {

		} else if (g.getClassS() == Classes.SHELDON) {

		} else if (g.getClassS() == Classes.SHELDON) {

		} else if (g.getClassS() == Classes.SHELDON) {

		} else {
			p(">>> HEIL! <<<",3,300);
			
			if (h.getM()==1) { // NAZI ZOMBIES?
				p("ZOMBIE Soldaten: "+(int) Math.ceil(h.getA()*1000));
				p("+++ Nazi ZOMBIE ARMEE VERNICHTET UND INFIZIERT WELT!!! Doppelter Schaden! +++");
				schaden = 20 + h.getA()*0.1;
			} else { // NORMAL NAZIS
			p("Soldaten: "+(int) Math.ceil(h.getA()*1000));
			p("+++ Nazi Armee vernichtet Welt durch Krieg! +++");
			schaden = 10 + h.getA()*0.05;
			}
			

		}

		return schaden;
	}
}
