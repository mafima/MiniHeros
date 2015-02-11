package miniheros.hero.allspells;

import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;
import miniheros.hero.Values;

public class superb extends Spell{
	
	public superb(){
		// createHero(2500, 1300, 700, 600, 100000, 0.2, Values.POWERleviathan);
		// (spellname, 				cooldowns:  start - set       			NEED               COST
		super("+++ S U P E R B +++",
												0, 		20,     				0, 0, 0, 0, 0,     100, 100, 100, 100, 10000);
	}

	public double cast(Hero h, Hero g) {
		this.castcd();
		double schaden = 0;
		

		p("//> "+this.getSpellname()+" <//");
		punkte(10,100);

		// gegnercheck
		if (g.getClassS() == Classes.SHELDON) {
			p("* Sheldon sagt NEIN zu superb! *");
		} else if (g.getClassS() == Classes.NEINHEIT) {
			p("// NEEEEEEEE! //");
			warte(1000); p(">>> NE! <<<"); warte(1000); p(">>> NE! <<<"); warte(1000);
			if (chance(70+ 10/malor(g.getG(),300))) {
				p(">>> KAWUUUUUUUUSCH <<<");
				p("NEIN WAND durchbrochen!");
				schaden = (int) Math.ceil(5*h.getM());
			} else {
				p("> "+g.getpName()+" ist eine NEINHEIT! SAGT NEIN ZU ANGRIFFEN!");
			}
		} else if (g.getClassS() == Classes.SHELDON) {
			// FREIER PLATZ
		} else if (g.getClassS() == Classes.SHELDON) {
			// FREIER PLATZ
		} else if ( g.getClassS() == Classes.DARKSPIDERMAN || g.getClassS() == Classes.SPIDERMAN || g.getClassS() == Classes.SPIDERPIG || g.getClassS() == Classes.GOKU) {
			p(g.getpName()+g.getpClass()+" besitzt ein cooles Kostuem! Du bist abgelenkt. "+this.getSpellname()+" fehlgeschlagen!");
		} else {
			p(">>> Du sammelst deine Kraft und drinkst 1000 Energydrinks auf ein mal! <<<");
			warte(1000); p(">>> LECKER! <<<"); warte(1000); p(">>> LECKER! <<<"); warte(1000);
			if (chance(80-(g.getH()*0.01))) {
				effekt("BLITZE",3,200);
				warte(2000);
				spezial("OMG!!!! Du nimmst eine Dose und wirfst sie auf deinen Gegner!");
				if (chance(h.getG()/1000)) {
					p("+++ TREFFER +++");
					schaden = (int) Math.ceil(h.getG()*0.1+h.getA()*0.025);
				}
				spezial("Das ganze WASSER heilt dich um 10000 !");
				h.kampf(10000);
				if (chance(90)) {
					warte(500);
					spezial("DOCH NICHT NUR DAS!!!!!!");
					spezial("GOTT SELBST STEIGT HINAB UND SAGT: GUT SO MEIN SOHN. WIE RED BULL BEREITS SAGTE, NUN HAST DU FLUEGEL!");
					p("VERNICHTE SIE!",3,300);
					warte(400);
					p("MACH PAPA STOLZ!");
					h.addA(1000);
					h.reG(5);
				}
			} else {
				p("> "+g.getpName()+" ruft: Diese Energydrinks sind ungesund!");
				p("OMG! Du begreifst, dass er recht hat...");
				h.reM(0.5);
			}
		}
		
		return schaden;
	}
}
