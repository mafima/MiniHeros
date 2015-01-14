package HeroPack;

import java.util.ArrayList;

public class Hero {
	
	/* Hero Erstellen geht so: 
	 * 1. unter Classes einen neuen Eintrag machen. z.b. GOBLIN
	 * 2. unter MiniHeros.java in die AntwortDB funktion gehen und einen else if Zweig erstellen.
	 * 3. unter addDefaultValues einen neuen else if Zweig machen mit createHero(werte...)
	 * 4. addSpells("spellname1","spellname2",usw..);
	 * 5. unter SpellDB.java einen else if zweig hinzufügen und die funktionen für die spells machen!
	 * FERTIG!
	 * 
	 * 
	 */

	private double life = 3; // LIFECHANGE
	
	private double change;
	private double hgeschick;
	private double hhirn;
	private double hmagie;
	private double hleben;
	private double hangriff;
	private double maxleben;
	private double res=1;
	private double dmg;
	private String name;
	public ArrayList<String> spells = new ArrayList<String>();
	public ArrayList<String> usedSpells = new ArrayList<String>();
	private Classes clas;
	private Group group;





	public Hero(double angriff, double geschick, double hirn, double magie, double leben) {
		this.hangriff = angriff;
		this.hgeschick = geschick;
		this.hhirn = hirn;
		this.hmagie = magie;
		this.hleben = leben;
	}

	// createHero Funktion OHNE resistenz
	public void createHero(double angriff, double geschick, double hirn, double magie, double leben, double power) {
		this.change = rand() * power;
		this.hangriff = Math.ceil(angriff * change);
		this.hgeschick = Math.ceil(geschick * change);
		this.hhirn = Math.ceil(hirn * change);
		this.hmagie = Math.ceil(magie * change);
		this.hleben = Math.ceil(life * leben * change);
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



	// Namen
	public Hero(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public String getpName() {
		return " ["+name+"] ";
	}
	public void setName(String name) {
		this.name = name;
	}
	public String showclass() {
		return "[ "+clas.toString()+" ]";
	}

	public double get(String choose) {
		if (choose.equalsIgnoreCase("a")) return hangriff;
		if (choose.equalsIgnoreCase("g")) return hangriff;
		if (choose.equalsIgnoreCase("h")) return hangriff;
		if (choose.equalsIgnoreCase("m")) return hangriff;
		if (choose.equalsIgnoreCase("l")) return hleben;
		if (choose.equalsIgnoreCase("max")) return maxleben;
		if (choose.equalsIgnoreCase("res")) return res;
		else return 0;
	}
	
	public double getA() {
		return hangriff;
	}
	public void setA(double hangriff) {
		this.hangriff = hangriff;
	}
	public void reA(double change) {
		this.hangriff = this.hangriff*change;
	}
	public double getG() {
		return hgeschick;
	}
	public void setG(double hgeschick) {
		this.hgeschick = hgeschick;
	}
	public void reG(double change) {
		this.hgeschick = this.hgeschick*change;
	}
	public void ausreG(double change) {
		this.hgeschick = this.hgeschick*change;
		if (change <  1) System.out.println(this.getpName()+" Geschick sinkt auf " + hgeschick);
		else System.out.println(this.getpName()+" Geschick steigt auf " + hgeschick);
	}
	public double getH() {
		return hhirn;
	}
	public void setH(double hhirn) {
		this.hhirn = hhirn;
	}
	public void reH(double change) {
		this.hhirn = this.hhirn*change;
	}
	public double getM() {
		return hmagie;
	}
	public void setM(double hmagie) {
		this.hmagie = hmagie;
	}
	public double getL() {
		return hleben;
	}
	public void setL(double hleben) {
		this.hleben = hleben;
	}
	public void kampf(double hleben) {
		this.hleben = this.hleben+hleben;
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
	public void ausre(String choose, double change) {
		double neu = 0;
		System.out.println();
		if (change <  1) System.out.print("---");
		else System.out.print("+++");
		System.out.print(this.getpName());
		if (choose.equalsIgnoreCase("a")) {
			this.hangriff = this.hgeschick*change;
			neu = this.hangriff;
			System.out.print("o-(=>  Angriff");
		}
		if (choose.equalsIgnoreCase("g")) {
			this.hgeschick = this.hgeschick*change;
			neu = this.hgeschick;
			System.out.print("////>  Geschick");
		}
		if (choose.equalsIgnoreCase("h")) {
			this.hhirn = this.hhirn*change;
			neu = this.hhirn;
			System.out.print("-[]-  Hirn");
		}
		if (choose.equalsIgnoreCase("m")) {
			this.hmagie = this.hmagie*change;
			neu = this.hmagie;
			System.out.print("-< ooo>  Magie");
		}
		if (choose.equalsIgnoreCase("leben")) {
			this.hleben = this.hleben*change;
			neu = this.hleben;
			System.out.print("<3  Leben");
		}
		if (choose.equalsIgnoreCase("res")) {
			this.res = this.res*change;
			neu = this.res;
			System.out.print("=|= Resistenz");
		}
		if (change <  1) System.out.print(" sinkt auf: " + neu);
		else System.out.print(" steigt auf: " + neu);
	}


	/*
	 * 
	 *  SPELLSYSTEM!
	 * 
	 */
	
	public String getspell(int s) {
		return spells.get(s-1);
	}

	public int getSpellSize() {
		return spells.size();
	}

	public void addSpells(String... spell) {
		this.spells.clear();
		String[] spellsss = spell;
		for(String sp : spellsss) {
			spells.add(sp);
		}
	}

	public void addDefaultValues(Classes heroClass) {
		// Spells 
		addSpells("normal","geschickt","intelligent","Zaubertrick");
		
		
		// NORMAL HEROLIST
		if(heroClass == Classes.MENSCH) {
			setgroup(group.MENSCHEN);
			// createHero(Angriff,Geschick,Hirn,Magie,Leben,POWER,optional: resitenz)
			// wenn du nicht weisst was POWER ist, einfach weglassen, so wie bei mensch.
			createHero(10,20,50,1,200,Values.POWERmensch);
		} else if(heroClass == Classes.KRIEGER) {
			createHero(70,30,10,1,600,0.9,Values.POWERkrieger);
			addSpells("normal","Ansturm","Fury");
			System.out.println(MiniHeros.prefix + getpName() + "ist ein Krieger! MIT KRAFT UND EHRE!");
		} else if(heroClass == Classes.MAGIER) {
			createHero(5,0,200,300,400,Values.POWERmagier,1.1);
			addSpells("Zaubertrick","Spellbook","Hurricane","LAZOR");
			System.out.println(MiniHeros.prefix + getpName() + "ist ein Magier! Kazing! Woosh! Lightningbolt! Kazing! Woosh!");
		} else if(heroClass == Classes.ELF) {
			createHero(40,50,70,20,300,0.95,Values.POWERelf);
			System.out.println(MiniHeros.prefix + getpName() + "ist ein geschickter Elf! Mach dein Volk stolz!");
		} else if(heroClass == Classes.ORK) {
			createHero(70,30,5,0,800,0.7,Values.POWERork);
			System.out.println(MiniHeros.prefix + getpName() + "ruft: ORK seien STAAARK!");
		} else if(heroClass == Classes.ZWERG) {
			createHero(50,50,30,10,600,0.8,Values.POWERzwerg);
			System.out.println(MiniHeros.prefix + getpName() + "ruft: Mit einem starkem Bart ist alles möglich!");
		} else if(heroClass == Classes.GNOM) {
			createHero(20,30,250,400,200,1.1,Values.POWERgnom);
			System.out.println(MiniHeros.prefix + getpName() + "sagt: Hört auf zu lachen! Ich bin nicht klein!");
		} else if(heroClass == Classes.ZOMBIE) {
			createHero(5,4,2,15,1200,Values.POWERzombie,0.95);
			addSpells("Zombieschlag","Hirnwurf","Zombieschrei","Zombiebiss");
			System.out.println("+++ GESTALT DES TODES +++");
			System.out.println(MiniHeros.prefix + ".=======================================.");
			System.out.println(MiniHeros.prefix + "|   -   -   -   -   -   -   -   -   -   |");
			System.out.print  (MiniHeros.prefix + "|   -   R.  I.  P.  . "+getName()+" ");for (int i = 0; i < 15-getpName().length();i=i+4) System.out.print("-   ");System.out.println("|");
			System.out.println(MiniHeros.prefix + "|   -   -   -   -   -   -   -   -   -   |");
			System.out.println(MiniHeros.prefix + "*=======================================*");
		} else if(heroClass == Classes.DRACHE) {
			createHero(100,10,2,80,2000,Values.POWERdrache);
			addSpells("Drachenschrei","Feuerbombe","Feueratem","Drachenbiss des Todes");
			System.out.println(); for (int i=0;i<3;i++) {System.out.print("~ MÖGEN DIE FLAMMEN SIE FOLTERN! ~");} System.out.println();
			System.out.println(MiniHeros.prefix + ".=======================================. ~~~~~~~~~~~~~~           ~~~~~~~ ~  ~     ");
			System.out.println(MiniHeros.prefix + "|   -   -   -   -   -   -   -   -   -   | ~~~~~~~~~~~~~~~~~~~  ~~~~~~~~~~~ ~ ~~  ~     ~");
			System.out.println(MiniHeros.prefix + "|   -  F e u e r   ~~~  D r a c h e  -  | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   ~~   ~~   ~ ~~  ~     ~");
			System.out.println(MiniHeros.prefix + "|   -   -   -   -   -   -   -   -   -   | ~~~      ~~~~~~~~~~~~~~~~~~~  ~     ~");
			System.out.println(MiniHeros.prefix + "*=======================================* ~            ~~~~~~~~~~~~~  ~~ ~~  ~     ~");
		} else if(heroClass == Classes.EISDRACHE) {
			createHero(110,20,10,700,1700,Values.POWEReisdrache);
			addSpells("Drachenschrei","Eissplitter","Eisfeuer","Drachenbiss des Todes");
			System.out.println(); for (int i=0;i<3;i++) {System.out.print(" ~| MÖGE DAS EIS SIE VERNICHTEN! |~ ");}
			System.out.println(MiniHeros.prefix + ".======================================. ~~~~~~~~~~~~~~           ~~~~~~~ ~  ~     ");
			System.out.println(MiniHeros.prefix + "|   *   *   *   *   *   *   *   *   *  | ~~~~~~~~~~~~~~~~~~~  ~~~~~~~~~~~ ~ ~~  ~     ~");
			System.out.println(MiniHeros.prefix + "|   *    E i s     ///  D r a c h e  * | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   ~~   ~~   ~ ~~  ~     ~");
			System.out.println(MiniHeros.prefix + "|   *   *   *   *   *   *   *   *   *  | ~~~      ~~~~~~~~~~~~~~~~~~~  ~     ~");
			System.out.println(MiniHeros.prefix + "*======================================* ~            ~~~~~~~~~~~~~  ~~ ~~  ~     ~");
		} 
		
		// STRANGE HEROLIST
		else if(heroClass == Classes.JESUS) {
			createHero(10,10,50,700,2000, Values.POWERjesus, 0.5);
		} else if(heroClass == Classes.GOTT) {
			createHero(1000,10000,10000,1000000,1000000,0.5,Values.POWERgott);
		} else if(heroClass == Classes.SATAN) {
			createHero(666,10000,50,9999999,6666666,0.1,Values.POWERsatan);
		} else if(heroClass == Classes.HITLER) {
			createHero(300,30,500,0,900,2,Values.POWERhitler);
			addSpells("HEIL","MARSCH","JUDENVERNICHTUNG");
		}
		
 
		
		// SPECIAL HEROLIST
		else if(heroClass == Classes.NEINHEIT) {
			createHero(1000,50,50000,1,50000,0.1,Values.POWERneinheit);
			addSpells("NEIN","ICHSAGENEIN","ÄHNEIN","NEINNEINNEIN");
		} else if(heroClass == Classes.JAHEIT) {
			createHero(1000,8000,100,100,50000,2,Values.POWERjaheit);
			addSpells("JA","ICHSAGEIMMERJA","JAKLAR","JANATÜÜÜRLICH");
		} else if(heroClass == Classes.LEVIATHAN) {
			createHero(2500,1300,700,600,100000,0.2,Values.POWERleviathan);
			addSpells("normal","geschickt","super","leviate");
		} else if(heroClass == Classes.ULTIMATEFORM) {
			createHero(777,400,5000,3000,100,0.05,Values.POWERjaheit);
			addSpells("verwirren","vernaschen","zermalmen","zernichten","Zetox");
		} 
		
		/*
		 * 
		 * ------------------------------------------
		 *        SUPER HEROLIST
		 * ------------------------------------------
		 */
		
		else if(heroClass == Classes.SHELDON) {
			createHero(2,1,2000,0,600,1.5,Values.POWERsheldon);
			addSpells("penny","dasistmeinplatz","zeitreise");
		} else if(heroClass == Classes.PENNY) {
			createHero(15,30,20,0,800,Values.POWERpenny);
		} else if(heroClass == Classes.LENNARD) {
			createHero(10,20,150,0,700,0.95,Values.POWERlennard);
		}
		
		else if(heroClass == Classes.GOKU) {
			createHero(700,2000,20,100,4500,0.75,Values.POWERgoku);
		} else if(heroClass == Classes.SPIDERMAN) {
			createHero(250,500,60,0,2000,0.9,Values.POWERspiderman);
		} else if(heroClass == Classes.DARKSPIDERMAN) {
			createHero(500,700,20,0,1700,1.2,Values.POWERdarkspiderman);
		} else if(heroClass == Classes.SPIDERPIG) {
			createHero(1,1,1,90000,100000,Values.POWERspiderpig);
		}
		
		// FREIER PLATZ FÜR DEINE HELDEN!
		else if(heroClass == Classes.MENSCH) {
			createHero(10,20,50,0,200,Values.POWERmensch);
			addSpells("superschlag","usw","usw");
		} else if(heroClass == Classes.MENSCH) {
			createHero(10,20,50,0,200,Values.POWERmensch);
		} else if(heroClass == Classes.MENSCH) {
			createHero(10,20,50,0,200,Values.POWERmensch);
		} else if(heroClass == Classes.MENSCH) {
			createHero(10,20,50,0,200,Values.POWERmensch);
		}
		
		// END OF LIST
		else {
			System.out.println("#FEHLER - missing HeroData!");
			createHero(10,20,50,1,200,Values.POWERmensch); // Spieler wird Mensch
		}
	}

	// KLASSEN
	public Classes getClassS() {
		return clas;
	}

	public void setClassS(Classes classS) {
		this.clas = classS;
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
		return 0.6 + 0.2*Math.ceil(3*Math.random());
	}


}
