package miniheros.hero.allspells;

import main.MiniHeros;
import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;

public class Magier_Lazor extends Spell{
	
	public Magier_Lazor(Hero h){
		// createHero(5, 10, 200, 300, 400, Values.POWERmagier, 1.1);
		// (String name, 	CD CDSET       			NEED               COST
		super("IMMA FIRIN MY LAZ0R", 		5, 60,     				0, 0, 0, 1, 0,     0, 0, 0, 100, 0);
	}

	public double cast(Hero h, Hero g) {
		this.castcd();
		double schaden = 0;
		
		spezial("|o/ -============)))  /o/  LAzzz00RBEAAAAAM !!!!!");
		if (MiniHeros.dev < 2) punkte(3,200);

		// gegnercheck
		if (g.getClassS() == Classes.SHELDON ) {
			spezial("* LAZZZ0000RRR BEAAAAAM !!!! Sheldons Hirn wird pulverisiert. *");
			schaden = g.getL();
		} else if (g.getClassS() == Classes.DRACHE ) {
			spezial("* Fluegel des Drachen getroffen!!! Er faellt heftig zu Boden! *");
			g.reA(0.2); g.reG(0.2);
			schaden = 50+g.getL()*0.4;
		} else if (g.getClassS() == Classes.GNOM ) {
			p("* LAZ00000RBEAM DES TODES !!! ... trifft einen Baum. Der Gnom hat einen Ablenkungszauber genutzt! *");
		} else if (g.getClassS() == Classes.ZWERG ) {
			p("* LAZ00000RBEAM DES TODES !!! ... trifft den Zwerg! Ein zischen ist zu hoeren. Es scheint ihm nicht sehr zu schaden. *");
			schaden = 10+g.getL()*(malor(h.getM(),1000));
		} else if (g.getClassS() == Classes.ORK ) {
			p("* LAZ000R BEAAAM zerreist die Haut des Orks! Der Ork schreit grausam wegen den Schmerzen. Aus Mitleid hoerst du nach 4 Sekunden auf. *");
			schaden = 0.75*g.getL()/g.getres();
		} else {
			schaden = 100+0.6*h.getM()+g.getL()*0.15;
		}
		
		return schaden;
	}
}
