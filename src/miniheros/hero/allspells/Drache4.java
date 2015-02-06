package miniheros.hero.allspells;


import main.MiniHeros;
import miniheros.hero.Classes;
import miniheros.hero.Hero;
import miniheros.hero.Spell;
import miniheros.util.help;

public class Drache4 extends Spell{
	
	public Drache4(){
		// (String name, 		           CD CDSET       NEED               COST
		super("{} Drachenbiss des Todes {}", 4, 10,       0, 0, 0, 0, 0,         0, 0, 0, 300, 0);
	}

	public float cast(Hero h, Hero g) {
		float schaden = 0;
		help.p("//> "+this.getSpellname()+" <//");
		if (MiniHeros.dev < 2) help.punkte(5,500);
		
		if (g.getClassS() == Classes.SHELDON) {
			p("* Drache hat keine Lust Shelden aufzuessen! Zu eklig! *");
			return 0;
		} else if (g.getClassS() == Classes.GNOM) {
			p("* Gnom ist zu klein um ihn aufzuessen! *");
			return 0;
		} else if (g.getClassS() == Classes.ZWERG) {
			p("* Zwerg ist zu klein um ihn aufzufressen! *");
			return 0;
		} else {
			p("// Drachenbiss //");
			p("Du stuerzt dich auf den Gegner und beisst den Kopf von "+h.getpName()+" ab!");
			schaden = (float) (70+h.getM()*(1-(g.getpercentmax())));
			h.reM(0);
		}
			return schaden;
		}
	
	
	// funktionen!
public static void warte(long zeit) {
	p("");
	try {
		Thread.sleep(zeit);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}

}

public static void punkte() {
for (int i = 0; i <= 3; i++) {
	p("");
	for (int j = 0; j < i; j++) {
		print(".");
	}
	p("");
	try {
		Thread.sleep(1500);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}
}

public static void punkte(int punkte, long zeit) {
for (int i = 0; i <= punkte; i++) {
	p("");
	for (int j = 0; j < i; j++) {
		print(".");
	}
	p("");
	try {
		Thread.sleep(zeit);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}
}

public static void p() {
System.out.println(" ");
}
public static void p(String text) {
System.out.println(text);
}
public static void p(String text, int z) {
while (z>0) {
	System.out.println(text); 
	z--;
	}
}
public static void print(String text) {
System.out.print(text);
}
public static void print(String text, int z) {
while (z>0) {
	System.out.print(text); 
	z--;
	}
}
public static void red(String text) {
System.out.println("###>>>>> " + text);
}
public static void intro(String x, String y) {
p(MiniHeros.prefix1); p(MiniHeros.prefix2); p(MiniHeros.prefix3);
p(x); p(y);
p(MiniHeros.prefix3); p(MiniHeros.prefix2); p(MiniHeros.prefix1);
}

public static boolean chance(double prozent) {
return Math.ceil(Math.random() * (100 / prozent)) == 1 || prozent > 100;
}
}