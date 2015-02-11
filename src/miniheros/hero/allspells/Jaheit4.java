package miniheros.hero.allspells;

import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;

public class Jaheit4 extends Spell{
	
	public Jaheit4(){
		//	JAHEIT -		createHero(1000, 8000, 100, 100, 50000, 2, Values.POWERjaheit);
		// (spellname, 				cooldowns:  start - set       			NEED               COST
		super("JAAA, NATUEEEEERLICH!",
												1, 		160,     				0, 0, 0, 0, 0,     0, 0, 0, 50, 10000);
	}

	public double cast(Hero h, Hero g) {
		this.castcd();
		double schaden = 0;
		

		p("//> "+this.getSpellname()+" <//");
		punkte(3,200);

		// gegnercheck
		if (g.getClassS() == Classes.SHELDON) {
			p("* Sheldon sagt JA zu deiner Ultimate! *");
			p("* Dein Strahl aus JAs erhellt die Umgebung durchbohrt Sheldon! *");
			schaden = (int) g.getL();
		} else if (g.getClassS() == Classes.NEINHEIT) {
			p(">>> Du wirfst die heilige Granate auf ALLE NEEEEES! HALELUJA! <<<");
			warte(1000); p(">>> HALELUJA! <<<"); warte(1000); p(">>> HALELUJA! <<<"); warte(1000);
			if (chance(70+ 10/malor(g.getG(),300))) {
				p(">>> KAWUUUUUUUUSCH <<<");
				schaden = (int) Math.ceil(5*h.getM()*2+h.getA()*0.1);
			} else {
				p("> "+g.getpName()+"kickt die Granate wieder zurueck! 8000 Schaden an dich!");
				g.kampf(-8000);
			}
		} else if (g.getClassS() == Classes.SHELDON) {
			// FREIER PLATZ
		} else if (g.getClassS() == Classes.SHELDON) {
			// FREIER PLATZ
		} else if (g.getClassS() == Classes.ELF || g.getClassS() == Classes.KRIEGER || g.getClassS() == Classes.DARKSPIDERMAN || g.getClassS() == Classes.SPIDERMAN || g.getClassS() == Classes.SPIDERPIG || g.getClassS() == Classes.GOKU || g.getClassS() == Classes.ZWERG) {
			p(g.getpName()+" weicht deinem ULTIMATIVEN JA aus!!!!  ... Ja das hat er gut gemacht!");
			p("* Ultimatives JA nicht gegen so geschickte Person einsetzbar! *");
		} else {
			p(">>> Du wirfst die heilige Granate auf den Gegner! HALELUJA! <<<");
			warte(1000); p(">>> HALELUJA! <<<"); warte(1000); p(">>> HALELUJA! <<<"); warte(1000);
			if (chance(40+ 10/malor(g.getG(),300))) {
				p(">>> KAWUUUUUUUUSCH <<<");
				schaden = (int) Math.ceil(h.getM()*2+h.getA()*0.1);
				spezial("Das ganze HALELUJA heilt dich um "+schaden*0.4+" !");
				h.kampf(schaden*0.4);
			} else {
				p("> "+g.getpName()+"kickt die Granate wieder zurueck! 8000 Schaden an dich!");
				g.kampf(-8000);
			}
		}
		
		return schaden;
	}
}
