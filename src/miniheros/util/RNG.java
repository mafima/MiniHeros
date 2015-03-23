package miniheros.util;

public class RNG {
	static double randomzahl;
	static double maxzahl; // maxzahl ist hilfsvariabel um prozente von oben zu nutzen!

	public static void gen() {
		randomzahl = (double) Math.ceil(Math.random()*100);
		maxzahl = 100;
	}
	public static boolean chance(double i){
		if (i > 100) i = 100;
		if (i < 0) i = 0;
		
		maxzahl -= i;
		if (maxzahl<0) {
			System.out.println("ERROR: RNG.maxzahl erreicht - Werte! Setze maxzahl auf 0"); 
			maxzahl = 0;
		}
		if (randomzahl < maxzahl) return false;
		return true;
	}
}