package miniheros.util;

import java.util.Scanner;

import main.MiniHeros;

public class Quiz extends MiniHeros {
	static int fragengesamt = 3;
	static String[] Antworten = new String[4];
	static boolean gewonnen;
	private static int maxtime = 10000;
	
	public static boolean quiz () {
		Help.p("*** WER SOLL ANFANGEN? das entscheidet die folgende Frage!!!");
		Help.p(getHhero1().getpName()+"du hast "+maxtime /1000+" Sekunden. Es geht los in...");
		Help.warte(2000);
		Help.punkte(3,1000);
		fragenDB();
		if (gewonnen) {
			Help.p("RICHTIG! Du darfst den ersten Angriff machen!");
			Help.warte(1800);
			return true;
		}
		Help.p("Falsch! Dein Gegner darf den ersten Angriff machen!");
		Help.warte(1800);
		return false;
	}

	private static void Antworten(String string, String string2,
			String string3, String string4) {
		for (int i = 0; i<Antworten.length; i++) {
			if(i==0) Antworten[i] = string;
			else if (i==1) Antworten[i] = string2;
			 else if (i==2) Antworten[i] = string3;
			 else if (i==3) Antworten[i] = string4;
		}
		mische(Antworten);
		gebeantworten();
	}
	public static String[] mische(String[] x) {
		for (int i =0;i<x.length;i++) {
			String help = x[i];
			int lol = (int) Math.random()*x.length;
			x[i] = x[lol];
			x[lol] = help;
		}
		return x;
	}
	public static void gebeantworten() {
		for (int i = 0; i<4; i++) {
			if (i == 0) Help.pnext("A");
			else if (i == 1) Help.pnext("B");
			else if (i == 2) Help.pnext("C");
			else if (i == 3) Help.pnext("D");
			Help.pnext(": "+Antworten[i]+"   ");
		}
	}
	public static void fragenDB() {
		int fragen = 4;
		int x = (int) (Math.random()*(fragen-1));
		Scanner eingabe = new Scanner(System.in);
		long t1 = System.currentTimeMillis();
		
		if(x==0) {
			Help.p(getHhero1().getpName()+", Wie viele Kilometer ist der Umfang der Erde gross?"); Help.p();
			Antworten("30000","37000","40000","50000");
			Help.warte(200);
			String a = eingabe.next();
			if ( a.equalsIgnoreCase("40000")) gewonnen = true; else gewonnen = false;
		}
		else if(x==1) {
			Help.p(getHhero1().getpName()+", Wie viel Liter verbraucht man beim Duschen?"); Help.p();
			Antworten("50","100","150","200");
			Help.warte(200);
			String a = eingabe.next();
			if ( a.equalsIgnoreCase("50")) gewonnen = true; else gewonnen = false;
		}
		else if(x==2) {
			Help.p("RECHENAUFGABE FUER "+getHhero1().getpName()+" !!!!!");
			int y = (int) (2+Math.random()*10); int z = (int) (2+Math.random()*10);
			Help.p(getHhero1().getpName()+", Was ist "+y+" * "+z+" ?"); Help.p();
			int zufall = (int) Math.ceil(Math.random()*4);
			if (zufall == 1) {Help.pnext("A: "+(z*y)+" "); Help.pnext("B: "+(z*y+2)+" "); Help.pnext("C: "+(z*y-1)+" "); Help.pnext("D: "+(z*y+5)+" ");}
			else if (zufall == 2) {Help.pnext("A: "+(z*y+3)+" "); Help.pnext("B: "+(z*y)+" "); Help.pnext("C: "+(z*y-1)+" "); Help.pnext("D: "+(z*y+5)+" ");}
			else if (zufall == 3) {Help.pnext("A: "+(z*y-6)+" "); Help.pnext("B: "+(z*y+6)+" "); Help.pnext("C: "+(z*y)+" "); Help.pnext("D: "+(z*y+5)+" ");}
			else {Help.pnext("A: "+(z*y-1)+" "); Help.pnext("B: "+(z*y+6)+" "); Help.pnext("C: "+(z*y+8)+" "); Help.pnext("D: "+(z*y)+" ");}
			Help.warte(200);
			int a = eingabe.nextInt();
			if (a == (z*y)) gewonnen = true; else gewonnen = false;
			t1 = t1 + 3000;
		}
		else if(x==3) {
			Help.p(getHhero1().getpName()+", Was ist am schlechtesten?"); Help.p();
			Antworten("Russland","handyakku leer","ISIS","Religion");
			Help.warte(300);
			String a = eingabe.next();
			if ( a.equalsIgnoreCase("ISIS")) gewonnen = true; else gewonnen = false;
		}
		Help.p(""+(System.currentTimeMillis()-t1));
		if ((System.currentTimeMillis()-t1) > maxtime) {
			Help.p("Zeit abgelaufen! Du hast verloren!");
			Help.warte(2000);
			gewonnen = false;
		}
	}

}
