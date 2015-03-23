package miniheros.hero.allspells;

import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;
import miniheros.hero.Values;

public class todo_Creeper1 extends Spell {

    public todo_Creeper1() {
		// HEROWERTE: createHero(0, 1, 5, 3000, 900, 2, Values.POWERcreeper);
        // (spellname, 							cooldowns:  start - set       			NEED               COST
        super("Freunde suchen",
                0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    public double cast(Hero h, Hero g) {
        this.castcd(); // setzt den cooldown auf cooldownset
        double schaden = 0; // schaden is by default 0

        p(new String[]{"creep", "Creeeep", "Creeepedicreep!"}, 800); // 3 nachrichten. 1200ms dazwischen

        // gegnercheck. checkt alle gegner durch.
        if (g.getClassS() == Classes.SHELDON) {
            p("* Sheldon rennt zum Creeper und umarmt ihn! Creeper freut sich! *");
            h.reA(0.5);
            h.reG(3);
            h.reM(1.2);
        } else if (g.getClassS() == Classes.ELF || g.getClassS() == Classes.ORK) {

        } else if (g.getClassS() == Classes.GNOM || g.getClassS() == Classes.MAGIER) {
            pfeile("YOU SHALL NOT PASS, little CREEPER!!!");
            p(g.getpName() + " wirkt Fesselzauber ! Du kannst dich nicht bewegen!");
            p("Creeper wird boese auf " + g.getpName() + " !!!");
            g.reA(1.1);
            g.reM(1.1);
        } else if (g.getClassS() == Classes.SHELDON) {

        } else if (g.getClassS() == Classes.SHELDON) {

        } else if (g.getClassS() == Classes.SHELDON) {

        } else if (g.getClassS() == Classes.SHELDON) {

        } else {
            if (chance(5)) {
                p(">>> Du triffst einen ENDERDRACHEN <<<");
                h.addL(1000 * Hero.life);
                h.addA(200);
                h.addR(-0.3);
            } else if (chance(30)) {
                p("> Du triffst auf dem Weg einen Blaze");
                h.addL(200 * Hero.life);
            } else {
                p(">>> Du triffst auf dem Weg ein Zombie! <<<");
                h.addL(100 * Hero.life);
                h.addR(-0.1);
            }

        }

        return schaden;
    }
}
