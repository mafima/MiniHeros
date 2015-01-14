package HeroPack;

import java.util.ArrayList;

public class Hero {

	// LIFECHANGe
	private double life = 3;
	
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
	private Spellz superspell;





	public Hero(double angriff, double geschick, double hirn, double magie, double leben) {
		this.hangriff = angriff;
		this.hgeschick = geschick;
		this.hhirn = hirn;
		this.hmagie = magie;
		this.hleben = leben;
	}

	public void createHero(double angriff, double geschick, double hirn, double magie, double leben, double v) {
		this.change = rand() * v;
		this.hangriff = Math.ceil(angriff * change);
		this.hgeschick = Math.ceil(geschick * change);
		this.hhirn = Math.ceil(hirn * change);
		this.hmagie = Math.ceil(magie * change);
		this.hleben = Math.ceil(life * leben * change);
	}
	public void createHero(double angriff, double geschick, double hirn, double magie, double leben, double v, double res) {
		this.change = rand() * v;
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
		double Life = 3;
		addSpells("normal","geschickt","intelligent","Zaubertrick");
		
		// NORMAL HEROLIST
		if(heroClass == Classes.MENSCH) {
			setgroup(group.MENSCHEN);
			createHero(10,10,20,1,200,Values.POWERmensch);
		} else if(heroClass == Classes.KRIEGER) {
			createHero(70,30,10,1,600,Values.POWERkrieger,0.9);
			addSpells("normal","Ansturm","Fury");
			System.out.println(MHero.prefix + getpName() + "ist ein Krieger! MIT KRAFT UND EHRE!");
		} else if(heroClass == Classes.MAGIER) {
			createHero(5,0,200,300,300,Values.POWERmagier,1.1);
			addSpells("Zaubertrick","Spellbook","Hurricane","LAZOR");
			System.out.println(MHero.prefix + getpName() + "ist ein Magier! Kazing! Woosh! Lightningbolt! Kazing! Woosh!");
		} else if(heroClass == Classes.ELF) {
			createHero(40,50,70,20,300,Values.POWERelf,0.95);
			System.out.println(MHero.prefix + getpName() + "ist ein geschickter Elf! Mach dein Volk stolz!");
		} else if(heroClass == Classes.ORK) {
			createHero(70,30,5,0,800,Values.POWERork,0.7);
			System.out.println(MHero.prefix + getpName() + "ruft: ORK seien STAAARK!");
		} else if(heroClass == Classes.ZWERG) {
			createHero(50,50,30,10,600,Values.POWERzwerg,0.85);
			System.out.println(MHero.prefix + getpName() + "ruft: Mit einem starkem Bart ist alles möglich!");
		} else if(heroClass == Classes.GNOM) {
			createHero(20,30,250,400,200,Values.POWERgnom,1.1);
			System.out.println(MHero.prefix + getpName() + "sagt: Hört auf zu lachen! Ich bin nicht klein!");
		} else if(heroClass == Classes.ZOMBIE) {
			createHero(5,4,2,15,1200,Values.POWERzombie,0.95);
			addSpells("Zombieschlag","Hirnwurf","Zombieschrei","Zombiebiss");
			System.out.println("+++ GESTALT DES TODES +++");
			System.out.println(MHero.prefix + ".=======================================.");
			System.out.println(MHero.prefix + "|   -   -   -   -   -   -   -   -   -   |");
			System.out.print  (MHero.prefix + "|   -   R.  I.  P.  . "+getName()+" ");for (int i = 0; i < 15-getpName().length();i=i+4) System.out.print("-   ");System.out.println("|");
			System.out.println(MHero.prefix + "|   -   -   -   -   -   -   -   -   -   |");
			System.out.println(MHero.prefix + "*=======================================*");
		} else if(heroClass == Classes.DRACHE) {
			createHero(100,10,2,80,2000, Values.POWERdrache, 0.95);
			addSpells("Drachenschrei","Feuerbombe","Feueratem","Drachenbiss des Todes");
			System.out.println(); for (int i=0;i<3;i++) {System.out.print("~ MÖGEN DIE FLAMMEN SIE FOLTERN! ~");} System.out.println();
			System.out.println(MHero.prefix + ".=======================================. ~~~~~~~~~~~~~~           ~~~~~~~ ~  ~     ");
			System.out.println(MHero.prefix + "|   -   -   -   -   -   -   -   -   -   | ~~~~~~~~~~~~~~~~~~~  ~~~~~~~~~~~ ~ ~~  ~     ~");
			System.out.println(MHero.prefix + "|   -  F e u e r   ~~~  D r a c h e  -  | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   ~~   ~~   ~ ~~  ~     ~");
			System.out.println(MHero.prefix + "|   -   -   -   -   -   -   -   -   -   | ~~~      ~~~~~~~~~~~~~~~~~~~  ~     ~");
			System.out.println(MHero.prefix + "*=======================================* ~            ~~~~~~~~~~~~~  ~~ ~~  ~     ~");
		} else if(heroClass == Classes.EISDRACHE) {
			createHero(110,20,10,700,1700, Values.POWERdrache, 0.95);
			addSpells("Drachenschrei","Eissplitter","Eisfeuer","Drachenbiss des Todes");
			System.out.println(); for (int i=0;i<3;i++) {System.out.print(" ~| MÖGE DAS EIS SIE VERNICHTEN! |~ ");}
			System.out.println(MHero.prefix + ".======================================. ~~~~~~~~~~~~~~           ~~~~~~~ ~  ~     ");
			System.out.println(MHero.prefix + "|   *   *   *   *   *   *   *   *   *  | ~~~~~~~~~~~~~~~~~~~  ~~~~~~~~~~~ ~ ~~  ~     ~");
			System.out.println(MHero.prefix + "|   *    E i s     ///  D r a c h e  * | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   ~~   ~~   ~ ~~  ~     ~");
			System.out.println(MHero.prefix + "|   *   *   *   *   *   *   *   *   *  | ~~~      ~~~~~~~~~~~~~~~~~~~  ~     ~");
			System.out.println(MHero.prefix + "*======================================* ~            ~~~~~~~~~~~~~  ~~ ~~  ~     ~");
		} 
		
		// STRANGE HEROLIST
		else if(heroClass == Classes.JESUS) {
			double hchange = Values.POWERjesus * rand();
			setA((double) Math.ceil(10 *hchange));
			setG((double) Math.ceil(10 *hchange));
			setH((double) Math.ceil(50 *hchange));
			setM((double) Math.ceil(0 *hchange));
			setL((double) Math.ceil(Life*2000 *hchange));
		} else if(heroClass == Classes.GOTT) {
			setA((double) Math.ceil(1000));
			setG((double) Math.ceil(10000000));
			setH((double) Math.ceil(10000000));
			setM((double) Math.ceil(10000000));
			setL((double) Math.ceil(10000000));
		} else if(heroClass == Classes.SATAN) {
			double hchange = Values.POWERsatan * rand();
			setA((double) Math.ceil(6666 *hchange));
			setG((double) Math.ceil(10 *hchange));
			setH((double) Math.ceil(50 *hchange));
			setM((double) Math.ceil(99999999 *hchange));
			setL((double) Math.ceil(Life*6666666 *hchange));
		} else if(heroClass == Classes.HITLER) {
			double hchange = Values.POWERhitler * rand();
			setA((double) Math.ceil(300 * hchange));
			setG((double) Math.ceil(30 *hchange));
			setH((double) Math.ceil(500 *hchange));
			setM((double) Math.ceil(0 *hchange));
			setL((double) Math.ceil(Life*900*hchange));
		}
		
 
		
		// SPECIAL HEROLIST
		else if(heroClass == Classes.NEINHEIT) {
			double hchange = Values.POWERmensch * rand();
			setA((double) Math.ceil(10 *hchange));
			setG((double) Math.ceil(10 *hchange));
			setH((double) Math.ceil(50 *hchange));
			setM((double) Math.ceil(50 *hchange));
			setL((double) Math.ceil(Life*1));
		} else if(heroClass == Classes.JAHEIT) {
			double hchange = Values.POWERmensch * rand();
			setA((double) Math.ceil(10 *hchange));
			setG((double) Math.ceil(10 *hchange));
			setH((double) Math.ceil(50 *hchange));
			setM((double) Math.ceil(0 *hchange));
			setL((double) Math.ceil(Life*1));
		} else if(heroClass == Classes.LEVIATHAN) {
			double hchange = Values.POWERmensch * rand();
			setA((double) Math.ceil(10 *hchange));
			setG((double) Math.ceil(10 *hchange));
			setH((double) Math.ceil(50 *hchange));
			setM((double) Math.ceil(0 *hchange));
			setL((double) Math.ceil(Life*200 *hchange));
		} else if(heroClass == Classes.ULTIMATEFORM) {
			double hchange = Values.POWERmensch * rand();
			setA((double) Math.ceil(777 *hchange));
			setG((double) Math.ceil(400 *hchange));
			setH((double) Math.ceil(5000 *hchange));
			setM((double) Math.ceil(3000*hchange));
			setL((double) Math.ceil(Life*100 *hchange));
		} 
		
		
		
		/*
		 * 
		 * ------------------------------------------
		 *        SUPER HEROLIST
		 * ------------------------------------------
		 */
		
		else if(heroClass == Classes.SHELDON) {
			double hchange = Values.POWERsheldon * rand();
			setA((double) Math.ceil(2 *hchange));
			setG((double) Math.ceil(1 *hchange));
			setH((double) Math.ceil(2000 *hchange));
			setM((double) Math.ceil(0 *hchange));
			setL((double) Math.ceil(Life*400 *hchange));
		} else if(heroClass == Classes.PENNY) {
			double hchange = Values.POWERpenny * rand();
			setA((double) Math.ceil(10 *hchange));
			setG((double) Math.ceil(10 *hchange));
			setH((double) Math.ceil(50 *hchange));
			setM((double) Math.ceil(0 *hchange));
			setL((double) Math.ceil(Life*800 *hchange));
		} else if(heroClass == Classes.LENNARD) {
			double hchange = Values.POWERlennard * rand();
			setA((double) Math.ceil(10 *hchange));
			setG((double) Math.ceil(10 *hchange));
			setH((double) Math.ceil(50 *hchange));
			setM((double) Math.ceil(0 *hchange));
			setL((double) Math.ceil(Life*200 *hchange));
		}
		
		
		
		
		
		
		
		

/*
 * 
 * JESUS, GOTT, SATAN, HITLER, 
	  
	// SPECIAL
	NEINHEIT, JAHEIT, LEVIATHAN, ULTIMATEFORM, 
	  
	// MEDIA CELEBS
	SHELDON, PENNY, LENNARD, GOKU, SPIDERMAN, DARKSPIEDERMAN, SPIDERPIG;
 */
		
		
		// END OF LIST
		else {
			System.out.println("#FEHLER a1d0 - missing HeroData!");
			double hrandom = rand();
			setA((double) Math.ceil(10 * Values.POWERmensch * hrandom));
			setG((double) Math.ceil(10 * Values.POWERmensch * hrandom));
			setH((double) Math.ceil(50 * Values.POWERmensch * hrandom));
			setM((double) Math.ceil(0 * Values.POWERmensch * hrandom));
			setL((double) Math.ceil(Life*200 * Values.POWERmensch * hrandom));
		}
	}

	// KLASSEN
	public Classes getClassS() {
		return clas;
	}

	public void setClassS(Classes classS) {
		this.clas = classS;
	}
	public Group getgroup() {
		return group;
	}

	public void setgroup(Group group) {
		this.group = group;
	}
	
	
	//SPELLZ
	public Spellz getSpellz() {
		return superspell;
	}

	public void setSpellz(Spellz supers) {
		this.superspell = supers;
	}
	
	// FUNKTIONEN
	public double rand() {
		return 0.6 + 0.2*Math.ceil(3*Math.random());
	}


}
