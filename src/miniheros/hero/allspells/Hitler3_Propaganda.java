package miniheros.hero.allspells;

import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;

public class Hitler3_Propaganda extends Spell{

	public Hitler3_Propaganda() {
		// HEROWERTE: createHero(300, 30, 500, 0, 900, 2, Values.POWERhitler);
		// (spellname, 							cooldowns:  start - set       			NEED               COST
		super("-+< PROPAGANDA >+-",
				0, 		20,     			0, 0, 0, 0, 0,     0, 0, 0, 0, 0);
	}

	public double cast(Hero h, Hero g) {
		this.castcd(); // setzt den cooldown auf cooldownset
		double schaden = 0; // schaden is by default 0
		double effekt = 1;

		p("//> "+this.getSpellname()+" <//"); // zeigt den Zauber kurz an
		punkte(3,200);	// erstellt 3 schnelle punkte. zeit zwischen den punkten: 200 ms

		// gegnercheck. checkt alle gegner durch.
		if (g.getClassS() == Classes.SHELDON) {
			p("* Sheldon sagt NEIN! *");
		} else if (g.getClassS() == Classes.ELF || g.getClassS() == Classes.ORK) {

		} else if (g.getClassS() == Classes.GNOM || g.getClassS() == Classes.MAGIER) {
			spezial(g.getpName()+"wirkt schnell Dummheitszauber! 50% weniger effektiv!");
			effekt = 0.5;
		} else if (g.getClassS() == Classes.SHELDON) {

		} else if (g.getClassS() == Classes.SHELDON) {

		} else if (g.getClassS() == Classes.SHELDON) {

		} else if (g.getClassS() == Classes.SHELDON) {

		} else {
			p(">>> Mehr Macht und Soldaten durch Propaganda Aktion! <<<");
			h.addG(200*effekt);
			double mult = 0.1;

			if (chance(10+50*malor(h.getA(),5000))) {
				p("Du lockst das Volk mit Hakenkreuz Sueßigkeiten! Soldatenanzahl steigt um 200 %!");
				mult = 2;
			} else if (chance(20+50*malor(h.getA(),5000))) {
				p("Du lockst das Volk mit Frauen! Soldatenanzahl steigt um 100 %!");
				mult = 1;
			} else if (chance(20+50*malor(h.getA(),5000))) {
				p("Du lockst das Volk mit Hakenkreuz Sueßigkeiten! Soldatenanzahl steigt um 50 %!");
				mult = 0.5;
			} else if (chance(40+10*malor(h.getA(),5000))) {
				spezial("Du verstehst das Volk jetzt besser zu manipulieren!");
				h.addH(300*effekt);
				p("Das Volk feiert dich! 10% mehr Soldaten!");
			} else {
				p("Das Volk feiert dich! 10% mehr Soldaten!");
			}

			h.reA(1+mult);
		}

		return schaden;
	}
}
