package miniheros.hero;

import java.util.ArrayList;
import java.util.Arrays;

import miniheros.hero.allspells.*;
import miniheros.util.Help;
import miniheros.util.Round;

public class Hero extends Help {

    /* Hero Erstellen geht so: 
     * 1. unter Classes einen neuen Eintrag machen. z.b. GOBLIN
     * 2. unter MiniHeros.java in die AntwortDB funktion gehen und einen else if Zweig erstellen.
     * 3. unter addDefaultValues einen neuen else if Zweig machen mit createHero(werte...)
     * 4. addSpells("spellname1","spellname2",usw..);
     * 5. unter SpellDB.java einen else if zweig hinzufuegen und die funktionen fuer die spells machen!
     * FERTIG!
     * 
     */
    public static double life = 2; // LIFECHANGE

    private double hangriff;
    private double hgeschick;
    private double hhirn;
    private double hmagie;
    private double hleben;
    private double maxleben;
    private double res = 1;
    private double dmg;
    private double change;
    private String name;
    public ArrayList<Spell> spells = new ArrayList<Spell>();
    public ArrayList<Integer> cooldowns = new ArrayList<Integer>();
    public Integer[] realcooldowns;
    private Classes klasse;
    private Group group;

    public Hero(double angriff, double geschick, double hirn, double magie, double leben) {
        this.hangriff = angriff;
        this.hgeschick = geschick;
        this.hhirn = hirn;
        this.hmagie = magie;
        this.hleben = leben;
        this.maxleben = hleben;
    }

    // createHero Funktion OHNE resistenz
    public void createHero(double angriff, double geschick, double hirn, double magie, double leben, double power) {
        this.change = rand() * power;
        this.hangriff = (double) Math.ceil(angriff * change);
        this.hgeschick = (double) Math.ceil(geschick * change);
        this.hhirn = (double) Math.ceil(hirn * change);
        this.hmagie = (double) Math.ceil(magie * change);
        this.hleben = (double) Math.ceil(life * leben * change);
        this.maxleben = hleben;
    }

    // createHero Funktion mit resitenz. Alle Kampfwerte werden zugewiesen
    public void createHero(double angriff, double geschick, double hirn, double magie, double leben, double res, double power) {
        this.change = rand() * power;
        this.hangriff = (double) Math.ceil(angriff * change);
        this.hgeschick = (double) Math.ceil(geschick * change);
        this.hhirn = (double) Math.ceil(hirn * change);
        this.hmagie = (double) Math.ceil(magie * change);
        this.hleben = (double) Math.ceil(life * leben * change);
        this.maxleben = hleben;
        this.res = res;
    }

    public void createHerowithspells(double angriff, double geschick, double hirn, double magie, double leben, double res, double power, Spell... spell) {
        this.change = rand() * power;
        this.hangriff = (double) Math.ceil(angriff * change);
        this.hgeschick = (double) Math.ceil(geschick * change);
        this.hhirn = (double) Math.ceil(hirn * change);
        this.hmagie = (double) Math.ceil(magie * change);
        this.hleben = (double) Math.ceil(life * leben * change);
        this.maxleben = hleben;
        this.res = res;
        addSpells(spell);
    }

    /*
     * 
     *  SPELLSYSTEM!
     * 
     */
    public Spell getspell(int s) {
        return spells.get(s - 1);
    }

    public int getSpellSize() {
        return spells.size();
    }

    // funktion um spells zu addieren
    public void addSpells(Spell... spell) {
        this.spells.clear();
        Spell[] spellsss = spell;
        spells.addAll(Arrays.asList(spellsss));
    }

    public void cdchangeall(long zeit) {
        for (int i = 1; i <= this.getSpellSize(); i++) {
            this.getspell(i).changecd(zeit);
            // DEBUG: p("cooldown von spell: "+i+" > "+this.getspell(i).getcd());
        }
    }

    // setzt mit bestimmter chance cooldown von 1 spell auf x
    public void cdchangerandom(long x, double c) {
        long t = (long) (Math.random() * x + 1);
        int i = (int) Math.ceil(Math.random() * this.getSpellSize()) - 1;
        if (chance(c)) {
            this.getspell(i).changecd(t);
        }
    }

    // setzt mit bestimmter chance cooldown von allen spells auf x
    public void cdchangerandomall(long x, double c) {
        long t = (long) (Math.random() * x + 1);
        for (int i = 2; i <= this.getSpellSize(); i++) { // faengt bei 2 an DAMIT nicht der normale angriff auch cooldown bekommt!
            if (chance(c)) {
                this.getspell(i).changecd(t);
            }
        }
    }

	// Namen
    public String getName() {
        return name;
    }

    public String getpName() {
        return "[" + name + "] ";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getpClass() {
        return "[-" + klasse + "-] ";
    }

    public double getA() {
        return hangriff;
    }

    public void setA(double hangriff) {
        this.hangriff = hangriff;
    }

    public void hiddenreA(double change) {
        this.hangriff = this.hangriff * change;
    }

    public double getG() {
        return hgeschick;
    }

    public void setG(double hgeschick) {
        this.hgeschick = hgeschick;
    }

    public void hiddenreG(double change) {
        this.hgeschick = this.hgeschick * change;
    }

    public double getH() {
        return hhirn;
    }

    public void setH(double hhirn) {
        this.hhirn = hhirn;
    }

    public void hiddenreH(double change) {
        this.hhirn = this.hhirn * change;
    }

    public double getM() {
        return hmagie;
    }

    public void setM(double hmagie) {
        this.hmagie = hmagie;
    }

    public void hiddenreM(double change) {
        this.hmagie = hmagie * change;
    }

    public double getL() {
        return hleben;
    }

    public void setL(double hleben) {
        this.hleben = hleben;
    }

    public void kampf(double lifechange) {
        if (lifechange < 0) {
            p(getpName() + "verliert " + lifechange * (-1) + " Leben!");
        } else {
            p(getpName() + "bekommt " + lifechange + " Leben!");
        }
        this.hleben = this.hleben + lifechange;
    }

    public void kampf(double lifechange, String s) {
        if (this.hleben + lifechange > 0) {
            if (lifechange < 0) {
                p(getpName() + "verliert " + lifechange * (-1) + " Leben durch " + s + "!");
            } else {
                p(getpName() + "bekommt " + lifechange + " Leben durch " + s + "!");
            }

            this.hleben = this.hleben + lifechange;
        } else {
            p(getpName() + "stirbt durch " + s);
        }
    }

    public void hiddenkampf(double lifechange) {
        this.hleben = this.hleben + lifechange;
    }

    public double getmissing() {
        return hleben / maxleben;
    }

    public double getpercetmissing() {
        return 100 * hleben / maxleben;
    }

    public double getmax() {
        return maxleben;
    }

    public void setmax(double max) {
        this.maxleben = max;
    }

    public double getdmg() {
        return dmg;
    }

    public double setdmg(double dmg) {
        this.dmg = dmg;
        return dmg;
    }

    public double getres() {
        return res;
    }

    public void setres(double ressi) {
        this.res = ressi;
    }

	// --------- AUSGABE + REDEFINE FUNKTIONEN! -------
    // setzt wert neu und gibt ihn aus!
    public void reA(double change) {
        if (this.hangriff != 0 && change != 1) {
            double neu = this.hangriff * change;
            this.hangriff = neu;
            p();
            if (change < 1) {
                pnext("[---] ");
            } else {
                pnext("[+++] ");
            }
            pnext(getpName());
            pnext("o-(=>  Angriff");
            if (change < 1) {
                pnext(" sinkt um " + (int) Math.ceil((1 - change) * 100) + "% auf: " + Round.r(neu));
            } else {
                pnext(" steigt um " + (int) Math.ceil((change - 1) * 100) + "% auf: " + Round.r(neu));
            }
            p();
        }
    }

    public void reG(double change) {
        if (this.hgeschick != 0 && change != 1) {
            double neu = this.hgeschick * change;
            this.hgeschick = neu;
            p();
            if (change < 1) {
                pnext("[---] ");
            } else {
                pnext("[+++] ");
            }
            pnext(getpName());
            pnext("////>  Geschick");
            if (change < 1) {
                pnext(" sinkt um " + (int) Math.ceil((1 - change) * 100) + "% auf: " + Round.r(neu));
            } else {
                pnext(" steigt um " + (int) Math.ceil((change - 1) * 100) + "% auf: " + Round.r(neu));
            }
            p();
        }
    }

    public void reH(double change) {
        if (this.hhirn != 0 && change != 1) {
            double neu = this.hhirn * change;
            this.hhirn = neu;
            p();
            if (change < 1) {
                pnext("[---] ");
            } else {
                pnext("[+++] ");
            }
            pnext(getpName());
            pnext("-[]-  Hirn");
            if (change < 1) {
                pnext(" sinkt um " + (int) Math.ceil((1 - change) * 100) + "% auf: " + Round.r(neu));
            } else {
                pnext(" steigt um " + (int) Math.ceil((change - 1) * 100) + "% auf: " + Round.r(neu));
            }
            p();
        }
    }

    public void reM(double change) {
        if (this.hmagie != 0 && change != 1) {
            this.hmagie = this.hmagie * change;
            p();
            if (change < 1) {
                pnext("[---] ");
            } else {
                pnext("[+++] ");
            }
            pnext(getpName());
            pnext("-< ooo>  Magie");
            if (change < 1) {
                pnext(" sinkt um " + (int) ((1.0 - change) * 100) + "% auf: " + Round.r(this.hmagie));
            } else {
                pnext(" steigt um " + (int) ((change - 1.0) * 100) + "% auf: " + Round.r(this.hmagie));
            }
            p();
        }
    }

    public void reL(double change) {
        if (this.hleben != 0 && change != 1) {
            double neu = this.hleben * change;
            this.hleben = neu;
            p();
            if (change < 1) {
                pnext("[---] ");
            } else {
                pnext("[+++] ");
            }
            pnext(getpName());
            pnext("<3  Leben");
            if (change < 1) {
                pnext(" sinkt um " + (int) Math.ceil((1 - change) * 100) + "% auf: " + Round.r(neu));
            } else {
                pnext(" steigt um " + (int) Math.ceil((change - 1) * 100) + "% auf: " + Round.r(neu));
            }
            p();
        }
    }

    public void reR(double change) {
        if (this.res != 0 && change != 1) {
            double neu = this.res * change;
            this.res = neu;
            p();
            if (change < 1) {
                pnext("[---] ");
            } else {
                pnext("[+++] ");
            }
            pnext(getpName());
            pnext("=|= Resistenz");
            if (change < 1) {
                pnext(" sinkt um " + (int) Math.ceil((1 - change) * 100) + "% auf: " + neu);
            } else {
                pnext(" steigt um " + (int) Math.ceil((change - 1) * 100) + "% auf: " + neu);
            }
            p();
        }
    }

	// ADDIERSYSTEM
	/*
     * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

     */
    public void addA(double change) {
        double neu = this.hangriff + change;
        this.hangriff = neu;
        if (this.hangriff < 0) {
            hangriff = 0; // angriff kann NICHT negativ werden!
        }
        p();
        if (change < 0) {
            pnext("[---] ");
        } else {
            pnext("[+++] ");
        }
        pnext(getpName());
        pnext("o-(=>  Angriff");
        if (change < 0) {
            pnext(" sinkt um " + Round.nice(change) * (-1) + " auf: " + Round.r(neu));
        } else {
            pnext(" steigt um " + Round.nice(change) + " auf: " + Round.r(neu));
        }
        p();

    }

    public void addG(double change) {
        double neu = this.hgeschick + change;
        this.hgeschick = neu;
        if (this.hgeschick < 0) {
            hgeschick = 0; // geschick kann NICHT negativ werden!
        }
        p();
        if (change < 0) {
            pnext("[---] ");
        } else {
            pnext("[+++] ");
        }
        pnext(getpName());
        pnext("////>  Geschick");
        if (change < 0) {
            pnext(" sinkt um " + Round.nice(change * (-1)) + " auf: " + Round.r(neu));
        } else {
            pnext(" steigt um " + Round.nice(change) + " auf: " + Round.r(neu));
        }
        p();

    }

    public void addH(double change) {
        this.hhirn = this.hhirn + change;
        if (this.hhirn < 0) {
            hhirn = 0; // Hirn kann NICHT negativ werden!
        }
        p();
        if (change < 0) {
            pnext("[---] ");
        } else {
            pnext("[+++] ");
        }
        pnext(getpName());
        pnext("-[]-  Hirn");
        if (change < 0) {
            pnext(" sinkt um " + Round.nice(change) * (-1) + " auf: " + Round.r(hhirn));
        } else {
            pnext(" steigt um " + Round.nice(change) + " auf: " + Round.r(hhirn));
        }
        p();

    }

    public void addM(double change) {
        boolean weniger = true;
        if (this.hmagie < this.hmagie + change) {
            weniger = false;
        }
        this.hmagie = this.hmagie + change; // MAGIE kann negativ werden!
        p();
        if (weniger) {
            pnext("[---] ");
        } else {
            pnext("[+++] ");
        }
        pnext(getpName());
        pnext("-< ooo>  Magie");
        if (weniger) {
            pnext(" sinkt um " + Round.nice(change) * (-1) + " auf: " + Round.r(this.hmagie));
        } else {
            pnext(" steigt um " + Round.nice(change) + " auf: " + Round.r(this.hmagie));
        }
        p();

    }

    public void addL(double change) {
        this.hleben = this.hleben + change;
        if (this.hleben < 0) {
            hleben = 0;
        }
        p();
        if (change < 0) {
            pnext("[---] ");
        } else {
            pnext("[+++] ");
        }
        pnext(getpName());
        pnext("<3  Leben");
        if (change < 0) {
            pnext(" sinkt um " + Round.nice(change) * (-1) + " auf: " + Round.r(hleben));
        } else {
            pnext(" steigt um " + Round.nice(change) + " auf: " + Round.r(hleben));
        }
        p();
    }

    public void addR(double change) {

        p();
        if (change > 0) {
            pnext("[---] ");
        } else {
            pnext("[+++] ");
        }
        pnext(getpName() + "=|= Resistenz");
        if (change > 0) {
            pnext(" sinkt um " + Round.r(change / res * 100) + "% auf: " + Round.r(this.res));
        } else {
            pnext(" steigt um " + Round.r(change / res * -100) + "% auf: " + Round.r(this.res));
        }

        this.res = this.res + change;
        if (this.res < 0) {
            spezial("Fehler! Resistenz ist unter 0 gesunken! setze auf 0.0001");
            this.res = 0.0001;
        }
        p();
    }

    public double angriff(Hero g) {
        System.out.println("angriff funktion schaden:" + 0.1 * getA() * malor(getG()) / malor(g.getG()));
        return 0.1 * getA() + 0.1 * getA() * malor(getG()) / malor(g.getG());
    }

    // WERTEZUWEISUNG
    public void addDefaultValues(Classes heroClass) {
        // Spells 
        addSpells(new ZZ_Normal(), new ZZ_Geschickt(), new ZZ_Intelligent(), new ZZ_Zaubertrick());

        pleer();
        // NORMAL HEROLIST
        if (heroClass == Classes.MENSCH) {
            setgroup(Group.MENSCHEN);
			// createHero(Angriff,Geschick,Hirn,Magie,Leben,POWER,optional: resitenz)
            // wenn du nicht weisst was POWER ist, einfach weglassen, so wie bei mensch.
            createHero(10, 20, 50, 0, 200, Values.POWERmensch);
        } else if (heroClass == Classes.KRIEGER) {
            createHero(70, 30, 10, 0, 600, 0.9, Values.POWERkrieger);
            addSpells(new ZZ_Normal(), new Krieger_Ansturm(), new Krieger_Fury());
            intro(getpName() + "ist ein Krieger!", " MIT KRAFT UND EHRE!");
        } else if (heroClass == Classes.MAGIER) {
            createHero(5, 10, 200, 300, 400, 1.1, Values.POWERmagier);
            addSpells(new Magier_Zauberbuch(), new ZZ_Zaubertrick(), new Magier_Wirbelsturm(), new Magier_Lazor(this));
            p(getpName() + "ist ein Magier! Kazing! Woosh! Lightningbolt! Kazing! Woosh!");
        } else if (heroClass == Classes.ELF) {
            createHero(40, 120, 70, 20, 300, Values.POWERelf);
            p(getpName() + "ist ein geschickter Elf! Mach dein Volk stolz!");
        } else if (heroClass == Classes.ORK) {
            createHero(70, 70, 5, 0, 800, 0.7, Values.POWERork);
            addSpells(new ZZ_Normal(), new ZZ_Geschickt(), new Innere_Wut(), new Ork4());
            p(getpName() + "ruft: ORK seien STAAARK!");
        } else if (heroClass == Classes.ZWERG) {
            createHero(50, 80, 30, 10, 600, 0.8, Values.POWERzwerg);
            p(getpName() + "ruft: Mit einem starkem Bart ist alles moeglich!");
        } else if (heroClass == Classes.GNOM) {
            createHero(20, 20, 250, 400, 200, 1.1, Values.POWERgnom);
            p(getpName() + "sagt: Hoert auf zu lachen! Ich bin nicht klein!");
        } else if (heroClass == Classes.ZOMBIE) {
            createHero(5, 5, 2, 15, 1200, Values.POWERzombie, 0.95);
            addSpells(new Zombie1_Infizierter_Wurf(), new Zombie2_Zombieschrei(), new Zombie3_Hirnwurf(), new Zombie4_Todesbiss());
            p("+++ GESTALT DES TODES +++");
            p(".================.");
            p("|   -   -   -   -   -   -   -   -   -   |");
            p();
            pnext("|   -   R.  I.  P.  . " + getName() + " ");
            for (int i = 0; i < 25 - getpName().length(); i = i + 4) {
                pnext("-   ");
            }
            p("|");
            p("|   -   -   -   -   -   -   -   -   -   |");
            p("*================*");
        } else if (heroClass == Classes.DRACHE) {
            createHero(100, 30, 2, 100, 1600, Values.POWERdrache);
            addSpells(new Drache1(), new Drache2(), new Drache3(), new Drache4());
            p();
            for (int i = 0; i < 3; i++) {
                pnext("~ MOEGEN DIE FLAMMEN SIE FOLTERN! ~");
            }
            p();
            p(".=======================================. ~~~~~~~~~~~~~~           ~~~~~~~ ~  ~     ");
            p("|   -   -   -   -   -   -   -   -   -   | ~~~~~~~~~~~~~~~~~~~  ~~~~~~~~~~~ ~ ~~  ~     ~");
            p("|   -  F e u e r   ~~~  D r a c h e  -  | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   ~~   ~~   ~ ~~  ~     ~");
            p("|   -   -   -   -   -   -   -   -   -   | ~~~      ~~~~~~~~~~~~~~~~~~~  ~     ~");
            p("*=======================================* ~            ~~~~~~~~~~~~~  ~~ ~~  ~     ~");
        } else if (heroClass == Classes.EISDRACHE) {
            createHero(90, 20, 10, 700, 1400, Values.POWEReisdrache);
            // addSpells("Drachenschrei", "Eissplitter", "Eisfeuer", "Drachenbiss des Todes");

            addSpells(new Drache1(), new EisDrache2(), new EisDrache3(), new Drache4());
            p();
            for (int i = 0; i < 3; i++) {
                pnext(" ~| MOEGE DAS EIS SIE VERNICHTEN! |~ ");
            }
            p(".======================================. ~~~~~~~~~~~~~~           ~~~~~~~ ~  ~     ");
            p("|   *   *   *   *   *   *   *   *   *  | ~~~~~~~~~~~~~~~~~~~  ~~~~~~~~~~~ ~ ~~  ~     ~");
            p("|   *    E i s     ///  D r a c h e  * | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   ~~   ~~   ~ ~~  ~     ~");
            p("|   *   *   *   *   *   *   *   *   *  | ~~~      ~~~~~~~~~~~~~~~~~~~  ~     ~");
            p("*======================================* ~            ~~~~~~~~~~~~~  ~~ ~~  ~     ~");
        } // STRANGE HEROLIST
        else if (heroClass == Classes.JESUS) {
            createHero(10, 10, 50, 700, 200, Values.POWERjesus, 0.5);
        } else if (heroClass == Classes.GOTT) {
            createHero(1000, 10000, 10000, 1000000, 1000000, 0.5, Values.POWERgott);
        } else if (heroClass == Classes.SATAN) {
            createHero(666, 10000, 50, 9999999, 6666666, 0.1, Values.POWERsatan);
        } else if (heroClass == Classes.HITLER) {
            createHero(300, 30, 500, 0, 900, 2, Values.POWERhitler);
            // addSpells("HEIL", "MARSCH", "PROPAGANDA", "JUDENVERNICHTUNG");
            addSpells(new Hitler1_Heil(), new Marsch(), new Hitler3_Propaganda(), new Hitler4_Judenhass());
        } else if (heroClass == Classes.TEEKANNE) {
            createHero(0, 0, 30, 0, 140, 0.2, Values.POWERteekanne);
            // addSpells(new Neinheit1(),new Neinheit2(),new Neinheit3(),new Teekanne4());
            p("'  >>.>|'|>.>>  | |======='  | |======='                    ======. ~~~~~~~~~~~~~~           ~~~~~~~ ~  ~     ");
            p("'      |'|      | |=         | |=                    ~~~~~~~~~~~~~~~~~~~  ~~~~~~~~~~~ ~ ~~  ~     ~");
            p("'      |'|      | |======='  | |======='            des Todes  * | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   ~~   ~~   ~ ~~  ~     ~");
            p("'      |'|      | |=         | |=                   ~~~~~~~~~~~~~~~~~~~  ~     ~");
            p("'      |'|      | |======='  | |======='                    =============================* ~            ~~~~~~~~~~~~~  ~~ ~~  ~     ~");
        } else if (heroClass == Classes.TEEBEUTEL) {
            createHero(1, 700, 2, 0, 60, 0.1, Values.POWERteebeutel);
            // addSpells(new Neinheit1(),new Neinheit2(),new Neinheit3(),new Teekanne4());
            p("'  >>.>|'|>.>>  | |======='  | |======='                    ======. ~~~~~~~~~~~~~~           ~~~~~~~ ~  ~     ");
            p("'      |'|      | |=         | |=                    ~~~~~~~~~~~~~~~~~~~  ~~~~~~~~~~~ ~ ~~  ~     ~");
            p("'      |'|      | |======='  | |======='            des Todes  * | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   ~~   ~~   ~ ~~  ~     ~");
            p("'      |'|      | |=         | |=                   ~~~~~~~~~~~~~~~~~~~  ~     ~");
            p("'      |'|      | |======='  | |======='                    =============================* ~            ~~~~~~~~~~~~~  ~~ ~~  ~     ~");
        } else if (heroClass == Classes.TOPF) {
            createHero(3, 1, 0, 5, 500, 0.025, Values.POWERtopf);
            // addSpells(new Neinheit1(),new Neinheit2(),new Neinheit3(),new Teekanne4());
            p("'  >>.>|'|>.>>  | || || || |   | |======='       | |======='             ======. ~~~~~~~~~~~~~~           ~~~~~~~ ~  ~     ");
            p("'      |'|      | || || || |   | |==  =='        | |                        ~~~~~~~~~~~~~~~~~~~  ~~~~~~~~~~~ ~ ~~  ~     ~");
            p("'      |'|      | || || || |   | |======='       | |======='     des Todes  * | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   ~~   ~~   ~ ~~  ~     ~");
            p("'      |'|      | || || || |   | |=              | |                   ~~~~~~~~~~~~~~~~~~~  ~     ~");
            p("'      |'|      | || || || |   | |=              | |                         =============================* ~            ~~~~~~~~~~~~~  ~~ ~~  ~     ~");
        } else if (heroClass == Classes.COOLMAN) {
            createHero(0, 0, 15, 0, 50000, 0.1, Values.POWERcool);
			// addSpells(new Neinheit1(),new Neinheit2(),new Neinheit3(),new Teekanne4());
            // soll cooldowns erhoehen und mehr schaden machen je mehr cooldowns
            p("'  COOOOOOOOOOOOOOOOOOOOOOOOOOOOOOL");
        } /*
         } else if (heroClass == Classes.PE) {
         createHero(150, 3, 0, 1, 1500, 1);
         p("Super P Power AKTIVIERT");
         } else if (heroClass == Classes.SCH) {
         createHero(300, 50, 1, 20, 5000, 1.5, 1);
         p( "Oh geil :3");
         } else if (heroClass == Classes.MU) {
         createHero(5, 100, 0, 200, 5000, 0.8, 1);
         p( "Feucht bekommt man mich am Besten ;b");
         }
         */ // SPECIAL HEROLIST
        else if (heroClass == Classes.NEINHEIT) {
            createHero(1000, 50, 50000, 1, 50000, 0.1, Values.POWERneinheit);
            addSpells(new Neinheit1(), new Neinheit2(), new Neinheit3(), new Neinheit4());
            p("'| |>.>       |'|    | |======='                  ======. ~~~~~~~~~~~~~~           ~~~~~~~ ~  ~     ");
            p("'| | >.>      |'|    | |=                        ~~~~~~~~~~~~~~~~~~~  ~~~~~~~~~~~ ~ ~~  ~     ~");
            p("'| |   >.>    |'|    | |======='              des Todes  * | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   ~~   ~~   ~ ~~  ~     ~");
            p("'| |     >.>  |'|    | |=                        ~~~~~~~~~~~~~~~~~~~  ~     ~");
            p("'� |       >.>|'|    | |======='                  =============================* ~            ~~~~~~~~~~~~~  ~~ ~~  ~     ~");
        } else if (heroClass == Classes.JAHEIT) {
            createHero(1000, 8000, 100, 100, 50000, 2, Values.POWERjaheit);
            addSpells(new Jaheit1(), new Jaheit2(), new Jaheit3(), new Jaheit4());
            p(".==========================. JA~~~~~~~~~~~~           ~~~~~JA~~ ~  ~     ");
            p("|   JJJJJJJJ        AAAA                      | ~~~~~~~~~~~~~~~~~~~  ~~~~~~~~~~~ ~ ~~  ~     ~");
            p("|          JJJ       AA   AA                     | ~~~~~~~~JA~~~~~~~~~~~~~~~JA~~~~~   ~~   JA~   ~ ~~  ~     ~");
            p("|   JJJJJJJJ      AAA  AAA                    | ~~~      ~~~~~~~~JA~~~~~~~~~  ~     ~");
            p("*==========================* ~            ~~~~~~~~~~~~~  ~~ ~~  ~     ~");
        } else if (heroClass == Classes.LEVIATHAN) {
            createHero(2500, 1300, 700, 600, 10000, 0.75, Values.POWERleviathan);
            addSpells(new ZZ_Normal(), new ZZ_Geschickt(), new superb(), new ZZ_Zaubertrick());
            p("*===========    L E V I A T H A N    ===============*", 7, 500);
        } else if (heroClass == Classes.ULTIMATEFORM) {
            createHero(777, 400, 5000, 3000, 100, 0.05, Values.POWERjaheit);
            // addSpells("verwirren", "vernaschen", "zermalmen", "zernichten", "Zetox");
        } /*
         *
         * ------------------------------------------
         *        SUPER HEROLIST
         * ------------------------------------------
         */ else if (heroClass == Classes.SHELDON) {
            createHero(2, 1, 2000, 0, 600, 1.5, Values.POWERsheldon);
            // addSpells("penny", "dasistmeinplatz", "zeitreise");
        } else if (heroClass == Classes.PENNY) {
            createHero(15, 30, 20, 0, 800, Values.POWERpenny);
        } else if (heroClass == Classes.LENNARD) {
            createHero(10, 20, 150, 0, 700, 0.95, Values.POWERlennard);
        } else if (heroClass == Classes.GOKU) {
            createHero(700, 2000, 20, 100, 4500, 0.75, Values.POWERgoku);
        } else if (heroClass == Classes.SPIDERMAN) {
            createHero(250, 500, 60, 0, 2000, 0.9, Values.POWERspiderman);
        } else if (heroClass == Classes.DARKSPIDERMAN) {
            createHero(500, 700, 20, 0, 1700, 1.2, Values.POWERdarkspiderman);
        } else if (heroClass == Classes.SPIDERPIG) {
            createHero(1, 1, 1, 7000, 3000, Values.POWERspiderpig);
        } else if (heroClass == Classes.CREEPER) {
            createHero(0, 1, 5, 3000, 900, 2, Values.POWERcreeper);
            addSpells(new ZZ_Normal(), new ZZ_Geschickt(), new todo_Creeper3(), new todo_Creeper4());
        } // FREIER PLATZ FUER DEINE HELDEN!
        else if (heroClass == Classes.MENSCH) {
            createHero(10, 20, 50, 0, 200, Values.POWERmensch);
            // addSpells("superschlag", "usw", "usw");
        } else if (heroClass == Classes.MENSCH) {
            createHero(10, 20, 50, 0, 200, Values.POWERmensch);
        } else if (heroClass == Classes.MENSCH) {
            createHero(10, 20, 50, 0, 200, Values.POWERmensch);
        } else if (heroClass == Classes.MENSCH) {
            createHero(10, 20, 50, 0, 200, Values.POWERmensch);
        } // END OF LIST >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        else {
            p("#FEHLER - missing HeroData!");
            createHero(10, 20, 50, 1, 200, Values.POWERmensch); // Spieler wird Mensch
        }

        /* 
         cooldowns werden von jedem spell auf 0 gesetzt!
         realcooldowns = new Integer[getSpellSize()];
         for(int i=0;i<getSpellSize()-1;i++) {
         realcooldowns[i] = 0;
         }
         */
    }

    // KLASSEN
    public Classes getClassS() {
        return klasse;
    }

    public void setClassS(Classes classS) {
        this.klasse = classS;
    }

    // GRUPPEN
    public Group getgroup() {
        return group;
    }

    public void setgroup(Group group) {
        this.group = group;
    }
}
