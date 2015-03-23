package miniheros.util;

public class Round {

	public static int nice(double s) {
        if (s >= 1000) {
            s *= 0.01;
            return ((int) Math.round(s)) * 100;
        } else if (s >= 100) {
            s *= 0.1;
            return ((int) Math.round(s)) * 10;
        } else if (s >= 50) {
            s *= 0.05;
            return ((int) Math.round(s)) * 5;
        } else {
            return (int) Math.round(s);
        }
	}
	
	public static int r(double s) {
            return (int) Math.round(s);
	}
}
