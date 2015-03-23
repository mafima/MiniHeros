package miniheros.hero.allspells;

import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;
import miniheros.hero.Values;

public class Hitler4_Judenhass extends Spell{

	public Hitler4_Judenhass(){
		// HEROWERTE: createHero(300, 30, 500, 0, 900, 2, Values.POWERhitler);
		// (spellname, 							cooldowns:  start - set       			NEED               COST
		super("+++ JUDENHASS +++",
				0, 		50,     			0, 0, 0, 0, 0,     0, 0, 0, 0, 100*Hero.life);
	}

	public double cast(Hero h, Hero g) {
		this.castcd(); // setzt den cooldown auf cooldownset
		double schaden = 0; // schaden is by default 0

		p("//> "+this.getSpellname()+" <//",3,500); // zeigt den Zauber kurz an
		punkte(3,200);	// erstellt 3 schnelle punkte. zeit zwischen den punkten: 200 ms

		// gegnercheck. checkt alle gegner durch.
		if (g.getClassS() == Classes.SHELDON) {
			spezial("Sheldon: Juden hassen? Das is sooo 19hundert! Looser!");
		} else if (g.getClassS() == Classes.ELF || g.getClassS() == Classes.ORK) {

		} else if (g.getClassS() == Classes.GNOM || g.getClassS() == Classes.MAGIER) {
			spezial("Die Magier dieser Welt lassen dies nicht zu!!!");
		} else if (g.getClassS() == Classes.SPIDERPIG) {
			spezial("SPIIIDERPIG, SPIDERPIG! Spiderpig mag Juden.");
		} else if (g.getClassS() == Classes.SHELDON) {

		} else if (g.getClassS() == Classes.SHELDON) {

		} else if (g.getClassS() == Classes.SHELDON) {

		} else {
			p(">>> Dein Hass auf Juden wandelt "+h.getH()/1000+"% deines Geschick in Angriff um! Kosten: "+100*Hero.life+" Leben <<<");
			double mult = h.getH()/1000;
			h.addA(h.getG() * mult);
			h.addG(- h.getG() * mult);
			
			if (chance (10)) {
				p("Du wirfst einen Nazi-ninjastern auf "+g.getpName()+"!!!");
				schaden = 20;
			} else if (chance(20) && h.getM()==0) {
				p("OMG!!!!!",3,500);
				spezial("DEINE WISSENSCHAFTLER HABEN EINEN ZOMBIEVIRUS ENTWICKELT! DU HAST NUN NAZIZOMBIE-SOLDATEN!");
				warte(1500);
				h.setM(1);
			}
		}

		return schaden;
	}
}
