package miniheros.util;

import static main.Textarena.*;

public class Help {
    // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // //
    // WARTE / PUNKTE
    // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // //

    public static void warte(long zeit) {
        if (dev < 3) {
            if (zeit < 0) {
                zeit = 0;
            }
            try {
                Thread.sleep(zeit);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else if (dev < 10) {
            if (zeit < 0) {
                zeit = 0;
            }

            try {
                Thread.sleep(zeit / dev);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void punkte() {
        warte(300);
        for (int i = 0; i < 3; i++) {
            p();
            pnext(prefix);
            for (int j = 0; j < i + 1; j++) {
                pnext(".");
            }
            p();
            warte(500);
        }
    }

    public static void superpunkte() {
        warte(300);
        for (int i = 0; i < 3; i++) {
            p();
            pnext(prefix);
            for (int j = 0; j < i + 1; j++) {
                pnext(".");
            }
            p();
            warte(200);
        }
    }

    public static void punkte(int punkte, long zeit) {
        warte(300);
        if (punkte < 0) {
            punkte = 0;
        }
        for (int i = 0; i < punkte; i++) {
            p();
            pnext(prefix);
            for (int j = 0; j < i + 1; j++) {
                pnext(".");
            }
            p();
            warte(zeit);
        }
    }

    // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // //
    // AUSGABE
    // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // //
    public static void p() {
        System.out.println("");
    }

    public static void p(String text) {
        System.out.println(prefix + text);
        warte(50);
    }

    public static void p(String text, int z) {
        while (z > 0) {
            System.out.println(prefix + text);
            z--;
        }
    }

    public static void p(String text, int z, long zeit) {
        while (z > 0) {
            System.out.println(prefix + text);
            warte(zeit);
            z--;
        }
    }

    public static void p(String[] text, long zeit) {
        for (int x = 0; x < text.length; x++) {
            System.out.println(prefix + text[x]);
            warte(zeit);
        }
    }

    public static void pleer() {
        System.out.println(" ");
    }

    public static void pnext(String text) {
        System.out.print(text);
    }

    public static void pnext(String text, int z) {
        while (z > 0) {
            System.out.print(text);
            z--;
        }
    }

    public static void pnext(String text, int z, long zeit) {
        while (z > 0) {
            System.out.print(text);
            warte(zeit);
            z--;
        }
    }

    public static void effekt(String text, int z, long zeit) {
        while (z > 0) {
            System.out.println(">>>]|+----------------" + text + "----------------+|[<<<");
            warte(zeit);
            z--;
        }
    }

    public static void effekt2(String text, int z, long zeit) {
        while (z > 0) {
            System.out.println(">>>-----" + text + "-----<<<");
            warte(zeit);
            z--;
        }
    }

    public static void pfeile(String text) {
        System.out.println(">>> " + text + " <<<");
    }

    public static void pfeile(String text, int z) {
        System.out.println();
        for (int i = 0; i < z; i++) {
            System.out.print(">");
        }
        System.out.print(" " + text + " ");
        for (int i = 0; i < z; i++) {
            System.out.print("<");
        }
    }

    public static void red(String text) {
        System.out.println(prefix + "-~- -~- -~- " + text);
    }

    public static void intro(String x, String y) {
        p(prefix1);
        p(prefix2);
        p(prefix3);
        p(x);
        p(y);
        p(prefix3);
        p(prefix2);
        p(prefix1);
    }

    public static void spezial(String text) {
        System.out.println(prefix + "*~->> " + text + " <<-~* ");
    }

    // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // //
    // BERECHNUNGEN
    // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // //
    public static boolean chance(double prozent) {
    	// gibt true oder false boolean
        // bei prozent = 70 wird mit 70%tiger wahrscheinlichkeit ein true gegeben.
        // bei werten die 100 uebersteigen wird immer true ermittelt
        return Math.ceil(Math.random() * (100 / prozent)) == 1 || prozent >= 100;
    }

    public double rand() {
        // generiert 0.8, 1 oder 1.2
        return 0.6 + 0.2 * Math.ceil(3 * Math.random());
    }

    public double rand(double zahl) {
        // generiert 0.8, 1 oder 1.2 und multipliziert mit zahl
        return zahl * (0.6 + 0.2 * Math.ceil(2 * Math.random()));
    }

    public double rand(double zahl, double range) {
        if (range > 1) {
            range = 1;
        } else if (range < 0) {
            range = 0;
        }

        return zahl * (1 - range * 2 + range * Math.ceil(3 * Math.random()));
    }

    // MALORBERECHNUNG -
    // z.b. grundzahl 25 = ~0.3      grundzahl 800 = ~0.9
    public static double malor(double grundzahl) {
        return grundzahl / (grundzahl + 100); // 100 als defaultwert
    }

    public static double malor(double grundzahl, double changezahl) {
        return grundzahl / (grundzahl + changezahl);
    }

    // PREFIX PACK
    public static String prefix = "[MiniHeros] ";
    public static String prefix1 = "**************************************";
    public static String prefix2 = "---------------------------------------------------------";
    public static String prefix3 = ". . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . .";
}
