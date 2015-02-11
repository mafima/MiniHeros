
package miniheros.util;
import main.MiniHeros;

public class Help {
	/*
	 *                          .=========================.
	 *                          |                         |
	 *                          |  NUETZLICHE FUNKTIONEN  |
	 *                          |                         |
	 *                          *=========================*
	 *
	 */

	public static void warte(long zeit) {
		if (MiniHeros.dev < 2) {
			try {
				Thread.sleep(zeit);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void punkte() {
		warte(800);
		for (int i = 0; i <= 3; i++) {
			p("");
			for (int j = 0; j < i; j++) {
				print(".");
			}
			p("");
			warte(700);
		}
	}

	public static void punkte(int punkte, long zeit) {
		warte(800);
		for (int i = 0; i <= punkte; i++) {
			p("");
			for (int j = 0; j < i; j++) {
				print(".");
			}
			p("");
			warte(zeit);
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
	public static void p(String text, int z, long zeit) {
		while (z>0) {
			System.out.println(text);
			warte(zeit);
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
	public static void print(String text, int z, long zeit) {
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
