package HeroPack;

import java.util.Scanner;

public class Quiz extends MiniHeros {
	static int fragengesamt = 3;
	static String[] Antworten = new String[4];
	static String[] fragen = new String[fragengesamt];
	static boolean gewonnen;
	
	public static boolean quiz () {
		p("*** WER SOLL ANFANGEN? das entscheidet die folgende Frage!!!");
		p(getHhero1().getpName()+"du hast 6 Sekunden. Es geht los in...");
		warte(2000);
		punkte();
		fragenDB();
		if (gewonnen) {
			p("RICHTIG! Du darfst den ersten Angriff machen!");
			return true;
		}
		p("Falsch! Dein Gegner darf den ersten Angriff machen!");
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
			if (i == 0) print("A");
			else if (i == 1) print("B");
			else if (i == 2) print("C");
			else if (i == 3) print("D");
			print(": "+Antworten[i]+"   ");
		}
	}
	public static void fragenDB() {
		int fragen = 4;
		int x = (int) (Math.random()*fragen-1);
		Scanner eingabe = new Scanner(System.in);
		long t1 = System.currentTimeMillis();
		long maxtime = 6000;
		
		if(x==0) {
			p(getHhero1().getpName()+", Wie viele Kilometer ist der Umfang der Erde gross?"); p();
			Antworten("30000","37000","40000","50000");
			warte(200);
			String a = eingabe.next();
			if ( a.equalsIgnoreCase("40000")) gewonnen = true; else gewonnen = false;
		}
		else if(x==1) {
			p(getHhero1().getpName()+", Wie viel Liter verbraucht man beim Duschen?"); p();
			Antworten("50","100","150","200");
			warte(200);
			String a = eingabe.next();
			if ( a.equalsIgnoreCase("50")) gewonnen = true; else gewonnen = false;
		}
		else if(x==2) {
			p("RECHENAUFGABE FUER "+getHhero1().getpName()+" !!!!!");
			int y = (int) (Math.random()*10); int z = (int) (Math.random()*10);
			p(getHhero1().getpName()+", Was ist "+y+" * "+z+" ?"); p();
			print("A: "+(z*y)+" "); print("B: "+(z*y+2)+" "); print("C: "+(z*y-1)+" "); print("D: "+(z*y+5)+" ");
			warte(200);
			int a = eingabe.nextInt();
			if (a == (z*y)) gewonnen = true; else gewonnen = false;
		}
		else if(x==3) {
			p(getHhero1().getpName()+", Was ist am schlechtesten?"); p();
			Antworten("Russland","handyakku leer","ISIS","Religion");
			warte(300);
			String a = eingabe.next();
			if ( a.equalsIgnoreCase("ISIS")) gewonnen = true; else gewonnen = false;
		}
	}

}
