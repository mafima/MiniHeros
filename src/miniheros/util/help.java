
package miniheros.util;
import main.MiniHeros;

public class Help {
	// // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // //
	// WARTE / PUNKTE
	// // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // //

	public static void warte(long zeit) {
		if (MiniHeros.dev < 3) {
			if (zeit < 0) zeit = 0;
			try {
				Thread.sleep(zeit);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else if (MiniHeros.dev < 10) {
			if (zeit < 0) zeit = 0;
			try {
				Thread.sleep(zeit/MiniHeros.dev);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void punkte() {
		warte(800);
		for (int i = 0; i < 3; i++) {
			p(); pnext(MiniHeros.prefix);
			for (int j = 0; j < i+1; j++) {
				pnext(".");
			}
			p(); warte(700);
		}
	}

	public static void punkte(int punkte, long zeit) {
		warte(800);
		if (punkte < 0) punkte = 0;
		for (int i = 0; i < punkte; i++) {
			p(); pnext(MiniHeros.prefix);
			for (int j = 0; j < i+1; j++) {
				pnext(".");
			}
			p(); warte(zeit);
		}
	}
	// // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // //
	// AUSGABE
	// // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // //

	public static void p() {
		System.out.println("");
	}

	public static void p(String text) {
		System.out.println(MiniHeros.prefix + text);
	}
	public static void p(String text, int z) {
		while (z>0) {
			System.out.println(text); 
			z--;
			}
	}
	public static void p(String text, int z, long zeit) {
		while (z>0) {
			System.out.println(text);
			warte(zeit);
			z--;
			}
	}
	public static void pleer() {
		System.out.println(" ");
	}
	
	public static void pnext() {
		p(); pnext(MiniHeros.prefix);
	}
	
	public static void pnext(String text) {
		System.out.print(text);
	}
	public static void pnext(String text, int z) {
		while (z>0) {
			System.out.print(text); 
			z--;
			}
	}
	public static void pnext(String text, int z, long zeit) {
		while (z>0) {
			System.out.print(text);
			warte(zeit);
			z--;
			}
	}
	
	public static void effekt(String text, int z, long zeit) {
		while (z>0) {
			System.out.println(">>>]|+----------------"+text+"----------------+|[<<<");
			warte(zeit);
			z--;
			}
	}
	public static void effekt2(String text, int z, long zeit) {
		while (z>0) {
			System.out.println(">>>-----"+text+"-----<<<");
			warte(zeit);
			z--;
			}
	}
	public static void pfeile(String text) {
			System.out.println(">>> "+text+" <<<");
	}
	public static void pfeile(String text, int z) {
		 	System.out.println();
		 	for (int i = 0; i < z; i++) {
		 		System.out.print(">");
		 	}
			System.out.print(" "+text+" ");
		 	for (int i = 0; i < z; i++) {
		 		System.out.print("<");
		 	}
	}
	public static void red(String text) {
		System.out.println(MiniHeros.prefix+"###>>>>> " + text);
	}
	public static void intro(String x, String y) {
		p(MiniHeros.prefix1); p(MiniHeros.prefix2); p(MiniHeros.prefix3);
		p(x); p(y);
		p(MiniHeros.prefix3); p(MiniHeros.prefix2); p(MiniHeros.prefix1);
	}
	public static void spezial(String text) {
		System.out.println("´*~->> "+text+" <<-~*` ");
	}
	
	// // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // //
	// RECHNER
	// // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // //
	
	public static boolean chance(double prozent) {
		return Math.ceil(Math.random() * (100 / prozent)) == 1 || prozent > 100;
	}
	public double rand() {
		// generiert 0.8, 1 oder 1.2
		return 0.6 + 0.2 * Math.ceil(3 * Math.random());
	}
	public static double malor(double grundzahl, double changezahl) {
		return grundzahl / (grundzahl + changezahl);
	}
}
