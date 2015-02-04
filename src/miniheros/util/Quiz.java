package miniheros.util;

import java.util.Scanner;

import main.MiniHeros;

public class Quiz extends MiniHeros {
	static int fragengesamt = 3;
	static String[] Antworten = new String[4];
	static boolean gewonnen;
	private static int maxtime = 10000;
	
	public static boolean quiz () {
		help.p("*** WER SOLL ANFANGEN? das entscheidet die folgende Frage!!!");
		help.p(getHhero1().getpName()+"du hast "+maxtime /1000+" Sekunden. Es geht los in...");
		help.warte(2000);
		help.punkte(3,1000);
		fragenDB();
		if (gewonnen) {
			help.p("RICHTIG! Du darfst den ersten Angriff machen!");
			help.warte(1800);
			return true;
		}
		help.p("Falsch! Dein Gegner darf den ersten Angriff machen!");
		help.warte(1800);
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
			if (i == 0) help.print("A");
			else if (i == 1) help.print("B");
			else if (i == 2) help.print("C");
			else if (i == 3) help.print("D");
			help.print(": "+Antworten[i]+"   ");
		}
	}
	public static void fragenDB() {
		int fragen = 4;
		int x = (int) (Math.random()*(fragen-1));
		Scanner eingabe = new Scanner(System.in);
		long t1 = System.currentTimeMillis();
		
		if(x==0) {
			help.p(getHhero1().getpName()+", Wie viele Kilometer ist der Umfang der Erde gross?"); help.p();
			Antworten("30000","37000","40000","50000");
			help.warte(200);
			String a = eingabe.next();
			if ( a.equalsIgnoreCase("40000")) gewonnen = true; else gewonnen = false;
		}
		else if(x==1) {
			help.p(getHhero1().getpName()+", Wie viel Liter verbraucht man beim Duschen?"); help.p();
			Antworten("50","100","150","200");
			help.warte(200);
			String a = eingabe.next();
			if ( a.equalsIgnoreCase("50")) gewonnen = true; else gewonnen = false;
		}
		else if(x==2) {
			help.p("RECHENAUFGABE FUER "+getHhero1().getpName()+" !!!!!");
			int y = (int) (2+Math.random()*10); int z = (int) (2+Math.random()*10);
			help.p(getHhero1().getpName()+", Was ist "+y+" * "+z+" ?"); help.p();
			int zufall = (int) Math.ceil(Math.random()*4);
			if (zufall == 1) {help.print("A: "+(z*y)+" "); help.print("B: "+(z*y+2)+" "); help.print("C: "+(z*y-1)+" "); help.print("D: "+(z*y+5)+" ");}
			else if (zufall == 2) {help.print("A: "+(z*y+3)+" "); help.print("B: "+(z*y)+" "); help.print("C: "+(z*y-1)+" "); help.print("D: "+(z*y+5)+" ");}
			else if (zufall == 3) {help.print("A: "+(z*y-6)+" "); help.print("B: "+(z*y+6)+" "); help.print("C: "+(z*y)+" "); help.print("D: "+(z*y+5)+" ");}
			else {help.print("A: "+(z*y-1)+" "); help.print("B: "+(z*y+6)+" "); help.print("C: "+(z*y+8)+" "); help.print("D: "+(z*y)+" ");}
			help.warte(200);
			int a = eingabe.nextInt();
			if (a == (z*y)) gewonnen = true; else gewonnen = false;
			t1 = t1 + 3000;
		}
		else if(x==3) {
			help.p(getHhero1().getpName()+", Was ist am schlechtesten?"); help.p();
			Antworten("Russland","handyakku leer","ISIS","Religion");
			help.warte(300);
			String a = eingabe.next();
			if ( a.equalsIgnoreCase("ISIS")) gewonnen = true; else gewonnen = false;
		}
		help.p(""+(System.currentTimeMillis()-t1));
		if ((System.currentTimeMillis()-t1) > maxtime) {
			help.p("Zeit abgelaufen! Du hast verloren!");
			help.warte(2000);
			gewonnen = false;
		}
	}

}
