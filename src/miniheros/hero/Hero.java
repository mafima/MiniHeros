package miniheros.hero;

import java.util.ArrayList;
import java.util.Arrays;

import main.MiniHeros;
import miniheros.hero.allspells.Ansturm;
import miniheros.hero.allspells.Drache1;
import miniheros.hero.allspells.Drache2;
import miniheros.hero.allspells.Drache3;
import miniheros.hero.allspells.Drache4;
import miniheros.hero.allspells.Sturm;
import miniheros.hero.allspells.Zaubertrick;
import miniheros.util.help;

public class Hero {

	/* Hero Erstellen geht so: 
	 * 1. unter Classes einen neuen Eintrag machen. z.b. GOBLIN
	 * 2. unter MiniHeros.java in die AntwortDB funktion gehen und einen else if Zweig erstellen.
	 * 3. unter addDefaultValues einen neuen else if Zweig machen mit createHero(werte...)
	 * 4. addSpells("spellname1","spellname2",usw..);
	 * 5. unter SpellDB.java einen else if zweig hinzufuegen und die funktionen fuer die spells machen!
	 * FERTIG!
	 * 
	 */
	public static double life=3; // LIFECHANGE


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
		this.hangriff = Math.ceil(angriff * change);
		this.hgeschick = Math.ceil(geschick * change);
		this.hhirn = Math.ceil(hirn * change);
		this.hmagie = Math.ceil(magie * change);
		this.hleben = Math.ceil(life * leben * change);
		this.maxleben = hleben;
	}

	// createHero Funktion mit resitenz. Alle Kampfwerte werden zugewiesen
	public void createHero(double angriff, double geschick, double hirn, double magie, double leben, double res, double power) {
		this.change = rand() * power;
		this.hangriff = Math.ceil(angriff * change);
		this.hgeschick = Math.ceil(geschick * change);
		this.hhirn = Math.ceil(hirn * change);
		this.hmagie = Math.ceil(magie * change);
		this.hleben = Math.ceil(life * leben * change);
		this.maxleben = hleben;
		this.res = res;
	}
	public void createHerowithspells(double angriff, double geschick, double hirn, double magie, double leben, double res, double power, Spell... spell) {
		this.change = rand() * power;
		this.hangriff = Math.ceil(angriff * change);
		this.hgeschick = Math.ceil(geschick * change);
		this.hhirn = Math.ceil(hirn * change);
		this.hmagie = Math.ceil(magie * change);
		this.hleben = Math.ceil(life * leben * change);
		this.maxleben = hleben;
		this.res = res;
		addSpells(spell);
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
		return "[-"+klasse+"-] ";
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
		this.hmagie = hmagie*change;
	}

	public double getL() {
		return hleben;
	}

	public void setL(double hleben) {
		this.hleben = hleben;
	}

	public void kampf(double hleben) {
		this.hleben = this.hleben + hleben;
	}

	public double getpercentmax() {
		return hleben/maxleben;
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
		if (this.hangriff!=0 && change!=1) {
			double neu = this.hangriff * change;
			p();
			if (change < 1) {
				help.print("[---] ");
			} else {
				help.print("[+++] ");
			}
			System.out.print(getpName());
			System.out.print("o-(=>  Angriff");
			if (change < 1) {
				System.out.print(" sinkt auf: " + neu);
			} else {
				System.out.print(" steigt auf: " + neu);
			}
			p();
		}
	}
	public void reG(double change) {
		if (this.hgeschick!=0&&change!=1) {
			double neu = this.hgeschick * change;
			p();
			if (change < 1) {
				help.print("[---] ");
			} else {
				help.print("[+++] ");
			}
			System.out.print(getpName());
			System.out.print("////>  Geschick");
			if (change < 1) {
				System.out.print(" sinkt auf: " + neu);
			} else {
				System.out.print(" steigt auf: " + neu);
			}
			p();
		}
	}
	public void reH(double change) {
		if (this.hhirn!=0&&change!=1) {
			double neu = this.hhirn * change;
			p();
			if (change < 1) {
				help.print("[---] ");
			} else {
				help.print("[+++] ");
			}
			System.out.print(getpName());
			System.out.print("-[]-  Hirn");
			if (change < 1) {
				System.out.print(" sinkt auf: " + neu);
			} else {
				System.out.print(" steigt auf: " + neu);
			}
			p();
		}
	}
	public void reM(double change) {
		if (this.hmagie!=0&&change!=1) {
			double neu = this.hmagie * change;
			p();
			if (change < 1) {
				help.print("[---] ");
			} else {
				help.print("[+++] ");
			}
			System.out.print(getpName());
			System.out.print("-< ooo>  Magie");
			if (change < 1) {
				System.out.print(" sinkt auf: " + neu);
			} else {
				System.out.print(" steigt auf: " + neu);
			}
			p();
		}
	}
	public void reL(double change) {
		if (this.hleben!=0&&change!=1) {
			double neu = this.hleben * change;
			p();
			if (change < 1) {
				help.print("[---] ");
			} else {
				help.print("[+++] ");
			}
			System.out.print(getpName());
			System.out.print("<3  Leben");
			if (change < 1) {
				System.out.print(" sinkt auf: " + neu);
			} else {
				System.out.print(" steigt auf: " + neu);
			}
			p();
		}
	}
	public void reR(double change) {
		if (this.res!=0&&change!=1) {
			double neu = this.res * change;
			p();
			if (change < 1) {
				help.print("[---] ");
			} else {
				help.print("[+++] ");
			}
			System.out.print(getpName());
			System.out.print("=|= Resistenz");
			if (change < 1) {
				System.out.print(" sinkt auf: " + neu);
			} else {
				System.out.print(" steigt auf: " + neu);
			}
			p();
		}
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


	// COOLDOWNS-----------------------------------------
	public int getcooldown(int s) {
		return cooldowns.get(s - 1);
	}

	// funktion um spellcooldowns zu SETZEN! die spells nehmen den getcooldown als cooldown!
	public void addcooldowns(Integer... cooldownzahl) {
		this.cooldowns.clear();
		Integer[] cooldownsss = cooldownzahl;
		cooldowns.addAll(Arrays.asList(cooldownsss));
	}


	// WERTEZUWEISUNG
	public void addDefaultValues(Classes heroClass) {
		// Spells 
		addSpells(new Ansturm(),new Sturm(),new Zaubertrick());

		// NORMAL HEROLIST
		if (heroClass == Classes.MENSCH) {
			setgroup(Group.MENSCHEN);
			// createHero(Angriff,Geschick,Hirn,Magie,Leben,POWER,optional: resitenz)
			// wenn du nicht weisst was POWER ist, einfach weglassen, so wie bei mensch.
			createHero(10, 20, 50, 1, 200, Values.POWERmensch);
		} else if (heroClass == Classes.KRIEGER) {
			createHero(70, 30, 10, 1, 600, 0.9, Values.POWERkrieger);
			addSpells(new Ansturm(),new Sturm());
			p(MiniHeros.prefix + getpName() + "ist ein Krieger! MIT KRAFT UND EHRE!");
		} else if (heroClass == Classes.MAGIER) {
			createHero(5, 0, 200, 300, 400, Values.POWERmagier, 1.1);
			addSpells(new Sturm());
			// addSpells("Zaubertrick", "Zauberbuch", "Wirbelsturm", "LAZOR");
			p(MiniHeros.prefix + getpName() + "ist ein Magier! Kazing! Woosh! Lightningbolt! Kazing! Woosh!");
		} else if (heroClass == Classes.ELF) {
			createHero(40, 50, 70, 20, 300, 0.95, Values.POWERelf);
			p(MiniHeros.prefix + getpName() + "ist ein geschickter Elf! Mach dein Volk stolz!");
		} else if (heroClass == Classes.ORK) {
			createHero(70, 30, 5, 0, 800, 0.7, Values.POWERork);
			p(MiniHeros.prefix + getpName() + "ruft: ORK seien STAAARK!");
		} else if (heroClass == Classes.ZWERG) {
			createHero(50, 50, 30, 10, 600, 0.8, Values.POWERzwerg);
			p(MiniHeros.prefix + getpName() + "ruft: Mit einem starkem Bart ist alles moeglich!");
		} else if (heroClass == Classes.GNOM) {
			createHero(20, 30, 250, 400, 200, 1.1, Values.POWERgnom);
			p(MiniHeros.prefix + getpName() + "sagt: Hoert auf zu lachen! Ich bin nicht klein!");
		} else if (heroClass == Classes.ZOMBIE) {
			createHero(5, 4, 2, 15, 1200, Values.POWERzombie, 0.95);
			// addSpells("Zombieschlag", "Hirnwurf", "Zombieschrei", "Zombiebiss");
			p("+++ GESTALT DES TODES +++");
			p(MiniHeros.prefix + ".=======================================.");
			p(MiniHeros.prefix + "|   -   -   -   -   -   -   -   -   -   |");
			System.out.print(MiniHeros.prefix + "|   -   R.  I.  P.  . " + getName() + " ");
			for (int i = 0; i < 15 - getpName().length(); i = i + 4) {
				System.out.print("-   ");
			}
			p("|");
			p(MiniHeros.prefix + "|   -   -   -   -   -   -   -   -   -   |");
			p(MiniHeros.prefix + "*=======================================*");
		} else if (heroClass == Classes.DRACHE) {
			createHero(100, 10, 2, 80, 2000, Values.POWERdrache);
			addSpells( new Drache1(), new Drache2(),  new Drache3(), new Drache4());
			p();
			for (int i = 0; i < 3; i++) {
				System.out.print("~ MOEGEN DIE FLAMMEN SIE FOLTERN! ~");
			}
			p();
			p(MiniHeros.prefix + ".=======================================. ~~~~~~~~~~~~~~           ~~~~~~~ ~  ~     ");
			p(MiniHeros.prefix + "|   -   -   -   -   -   -   -   -   -   | ~~~~~~~~~~~~~~~~~~~  ~~~~~~~~~~~ ~ ~~  ~     ~");
			p(MiniHeros.prefix + "|   -  F e u e r   ~~~  D r a c h e  -  | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   ~~   ~~   ~ ~~  ~     ~");
			p(MiniHeros.prefix + "|   -   -   -   -   -   -   -   -   -   | ~~~      ~~~~~~~~~~~~~~~~~~~  ~     ~");
			p(MiniHeros.prefix + "*=======================================* ~            ~~~~~~~~~~~~~  ~~ ~~  ~     ~");
		} else if (heroClass == Classes.EISDRACHE) {
			createHero(110, 20, 10, 700, 1700, Values.POWEReisdrache);
			// addSpells("Drachenschrei", "Eissplitter", "Eisfeuer", "Drachenbiss des Todes");
			p();
			for (int i = 0; i < 3; i++) {
				System.out.print(" ~| MOEGE DAS EIS SIE VERNICHTEN! |~ ");
			}
			p(MiniHeros.prefix + ".======================================. ~~~~~~~~~~~~~~           ~~~~~~~ ~  ~     ");
			p(MiniHeros.prefix + "|   *   *   *   *   *   *   *   *   *  | ~~~~~~~~~~~~~~~~~~~  ~~~~~~~~~~~ ~ ~~  ~     ~");
			p(MiniHeros.prefix + "|   *    E i s     ///  D r a c h e  * | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   ~~   ~~   ~ ~~  ~     ~");
			p(MiniHeros.prefix + "|   *   *   *   *   *   *   *   *   *  | ~~~      ~~~~~~~~~~~~~~~~~~~  ~     ~");
			p(MiniHeros.prefix + "*======================================* ~            ~~~~~~~~~~~~~  ~~ ~~  ~     ~");
		} // STRANGE HEROLIST
		else if (heroClass == Classes.JESUS) {
			createHero(10, 10, 50, 700, 2000, Values.POWERjesus, 0.5);
		} else if (heroClass == Classes.GOTT) {
			createHero(1000, 10000, 10000, 1000000, 1000000, 0.5, Values.POWERgott);
		} else if (heroClass == Classes.SATAN) {
			createHero(666, 10000, 50, 9999999, 6666666, 0.1, Values.POWERsatan);
		} else if (heroClass == Classes.HITLER) {
			createHero(300, 30, 500, 0, 900, 2, Values.POWERhitler);
			// addSpells("HEIL", "MARSCH", "JUDENVERNICHTUNG");
		} // SPECIAL HEROLIST
		else if (heroClass == Classes.NEINHEIT) {
			createHero(1000, 50, 50000, 1, 50000, 0.1, Values.POWERneinheit);
			// addSpells("NEIN", "ICHSAGENEIN", "EHHHNEIN", "NEINNEINNEIN");
			p(MiniHeros.prefix + "'|.=        |'    ||=========='        ======. ~~~~~~~~~~~~~~           ~~~~~~~ ~  ~     ");
			p(MiniHeros.prefix + "'|| \\      |'    ||=               | ~~~~~~~~~~~~~~~~~~~  ~~~~~~~~~~~ ~ ~~  ~     ~");
			p(MiniHeros.prefix + "'||   \\    |'    ||=========='         des Todes  * | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   ~~   ~~   ~ ~~  ~     ~");
			p(MiniHeros.prefix + "'||     \\  |'    ||=                 ~~~~~~~~~~~~~~~~~~~  ~     ~");
			p(MiniHeros.prefix + "'*|       \\|'    ||=========='         =============================* ~            ~~~~~~~~~~~~~  ~~ ~~  ~     ~");
		} else if (heroClass == Classes.JAHEIT) {
			createHero(1000, 8000, 100, 100, 50000, 2, Values.POWERjaheit);
			// addSpells("JA", "ICH SAGE IMMER JA", "JAKLAR", "JA natuuurlich!");
			p(MiniHeros.prefix + ".======================================. JA~~~~~~~~~~~~           ~~~~~JA~~ ~  ~     ");
			p(MiniHeros.prefix + "|   JJJJJJJJ        AAAA               | ~~~~~~~~~~~~~~~~~~~  ~~~~~~~~~~~ ~ ~~  ~     ~");
			p(MiniHeros.prefix + "|        JJJ       AA  AA     JA JA    | ~~~~~~~~JA~~~~~~~~~~~~~~~JA~~~~~   ~~   JA~   ~ ~~  ~     ~");
			p(MiniHeros.prefix + "|   JJJJJJJJ      AAA  AAA             | ~~~      ~~~~~~~~JA~~~~~~~~~  ~     ~");
			p(MiniHeros.prefix + "*======================================* ~            ~~~~~~~~~~~~~  ~~ ~~  ~     ~");
		} else if (heroClass == Classes.LEVIATHAN) {
			createHero(2500, 1300, 700, 600, 100000, 0.2, Values.POWERleviathan);
			// 	addSpells("normal", "geschickt", "super", "leviate");
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
			 createHero(1, 1, 1, 90000, 100000, Values.POWERspiderpig);
		 } 

		// FREIER PLATZ FUER DEINE HELDEN!
		 else if (heroClass == Classes.MENSCH) {
			 createHero(10, 20, 50, 0, 200, Values.POWERmensch);
			 // addSpells("superschlag", "usw", "usw");
		 } else if (heroClass == Classes.MENSCH) {
			 createHero(10, 20, 50, 0, 200, Values.POWERmensch);
		 } else if (heroClass == Classes.MENSCH) {
			 createHero(10, 20, 50, 0, 200, Values.POWERmensch);
		 } else if (heroClass == Classes.MENSCH) {
			 createHero(10, 20, 50, 0, 200, Values.POWERmensch);
		 } 
		
		
		// END OF LIST >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
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

	//SPELLZ backup
	/*

     public Spellz getSpellz() {
     return superspell;
     }

     public void setSpellz(Spellz supers) {
     this.superspell = supers;
     }
	 */
	// FUNKTIONEN
	public double rand() {
		// generiert 0.8, 1 oder 1.2
		return 0.6 + 0.2 * Math.ceil(3 * Math.random());
	}
	public static void punkte() {
		for (int i = 0; i < 3; i++) {
			p("");
			for (int j = 0; j < i; j++) {
				System.out.print(".");
			}
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void punkte(int punkte, long zeit) {
		for (int i = 0; i < punkte; i++) {
			p("");
			for (int j = 0; j < i; j++) {
				System.out.print(".");
			}
			try {
				Thread.sleep(zeit);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void p() {
		System.out.println();
	}
	public static void p(String text) {
		System.out.println(text);
	}
	public static void r(String text) {
		System.out.println("###>>>"+text);
	}
	public static boolean chance(double prozent) {
		return Math.ceil(Math.random() * (100 / prozent)) == 1 || prozent > 100;
	}

}
