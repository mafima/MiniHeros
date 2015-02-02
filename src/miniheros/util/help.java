
package miniheros.util;
import main.MiniHeros;

public class help {
	/*
	 *                          .=========================.
	 *                          |                         |
	 *                          |  NUETZLICHE FUNKTIONEN  |
	 *                          |                         |
	 *                          *=========================*
	 *
	 */

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
