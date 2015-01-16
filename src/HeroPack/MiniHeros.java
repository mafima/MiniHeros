package HeroPack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* Erfinder = "Manuel Fischer" aka Mafima
 *
 * - 1 gegen 1 Kampfspiel -
 *
 *
 * FERTIGE HELDEN:
 * MENSCH, KRIEGER, ZOMBIE
 *
 * HELDEN mit fehlenden spells:
 * ~ 20
 *
 */

public class MiniHeros {

    // Hero Objekte werden erstellt
    private static Hero hhero1;
    private static Hero hhero2;

    // Scanner laden fuer Eingabe
    Scanner Eingabe = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    // main methode
    public static void main(String[] args) throws IOException {

        // Erstellen der 2 Hero Objekte
        hhero1 = new Hero(0, 0, 0, 0, 0);
        hhero2 = new Hero(0, 0, 0, 0, 0);

        
        /* ============== *
         * GAMECHANGE BOX *
		 * xxxxxxxxxxxxxx *
         * ==============*/
        
        int skipmuenze = 0; // Soll Muenzwurf uebersprungen werden? 0=nein 1=ja
        long timeout = 30000; // bestimme wie lang man zeit zum held nehmen hat!

        

        System.err.println("DEV?");
        Scanner eingabe = new Scanner(System.in);
        int dev = eingabe.nextInt();

        if (dev == 1) {
            hhero1.setClassS(Classes.MENSCH);
            hhero2.setClassS(Classes.ZOMBIE);
            hhero1.setName("Manuel");
            hhero2.setName("David");
        }

        if (dev != 1) {
            System.out.println(prefix1);
            System.out.println(prefix2);
            System.out.println("- > > > > >   MiniHero v 0.001   < < < < < -");
            System.out.println("-     DAS SPIEL DER UNENDLICHEN HELDEN     -");
            System.out.println(prefix2);
            System.out.println(prefix1);
            System.out.println(prefix + "Wie heisst Spieler 1?");
            String antwort = reader.readLine();
            hhero1.setName(antwort);
            System.out.println(prefix + "Wie heisst Spieler 2?");
            antwort = reader.readLine();
            hhero2.setName(antwort);

            // Wer faengt an?
            if (skipmuenze == 0) {
                if (Math.ceil(2 * Math.random()) != 1) { // muenzwurf
                    spielertmp = hhero1.getName(); // spielernamen werden getauscht wenn spieler 2 anfangen soll
                    hhero1.setName(hhero2.getName());
                    hhero2.setName(spielertmp);
                }
                System.out.println(prefix + "Eine Muenze wurde geworfen!" + hhero1.getpName() + "faengt an!");
            }
        }

        /*
         *                          .=========================.
         *                          |                         |
         *                          |   Spieler 1 Rassenwahl  |
         *                          |                         |
         *                          *=========================*
         *
         */
        herowahl(hhero1, dev, timeout);
        
 


        /*
         *                          .=========================.
         *                          |                          |
         *                      	|    Spieler 2 Rassenwahl  |
         *                          |                          |
         *                          *=========================*
         *
         */
        herowahl(hhero2, dev, timeout);
        long t5 = System.currentTimeMillis();
        while (hhero2.getClassS() == null) {
            System.err.println(prefix + hhero2.getpName() + "darf nun seinen Helden waehlen!");
            String antwort = reader.readLine();
            // Hero wird gelesen

            long t6 = System.currentTimeMillis();
            if ((t6 - t5) > 20000) { // falls zu lange gebraucht wird Held "mensch" genommen
                System.err.println(prefix + "Zeit abgelaufen! Du bist jetzt ein Mensch!!!");
                try {
                    Thread.sleep(1200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                antwort = "mensch";
            }
            antwortDB(antwort, hhero2);
        }

        // HERO DB
        hhero2.addDefaultValues(hhero2.getClassS());
        werteanz(hhero2);

        // HEROS GEWÄHLT. 
        if (dev != 1) {
            System.out.println(prefix + "Bereit?");
            String antwort = reader.readLine();
        }
        System.out.println(prefix2);
        System.out.println(prefix2);
        System.out.println(prefix + "DER KAMPF BEGINNT!");
        System.out.println(prefix2);
        System.out.println(prefix2);
        /////////////// KAMPF /////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////

        int kampf = 1;
        while (hhero1.getL() > 0 && hhero2.getL() > 0) {
            if (kampf == 1) {
                kampf(hhero1, hhero2, dev);
                kampf = 2;
                if (hhero2.getL() <= 0) {
                    kampf = 0;
                }
            }
            if (kampf == 2) {
                kampf(hhero2, hhero1, dev);
                kampf = 1;
                if (hhero1.getL() <= 0) {
                    kampf = 0;
                }
            }
        }

        // END ><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><
        // ><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><
        if (hhero2.getL() <= 0) {
            System.out.println(prefix + hhero1.getpName() + "hat gewonnen!!!");
            changePOWERLEVEL(hhero1,hhero2);
        } else {
            System.out.println(prefix + hhero2.getpName() + "hat gewonnen!!!");
            changePOWERLEVEL(hhero2,hhero1);
        }
        
        System.out.println(prefix + "********* END **********");
    }

    public static void anzleben(double anzlebvor, double anzleb, Hero hero) {
        for (double i = anzlebvor; i > anzleb && i > 0; i = i - (10 + (anzlebvor - anzleb) / 10)) {
            if (i < (anzlebvor - anzleb) / (10 + (anzlebvor - anzleb) / 10)) {
                System.out.println(prefix + "+KAMPF+" + hero.getpName() + "[ " + hero.getClassS() + " ] " + Math.ceil(anzleb) + " Leben :");
            } else {
                System.out.print(prefix + " KAMPF -(=>" + hero.getpName() + "[" + hero.getClassS() + "] " + Math.ceil(i) + " Leben :");
            }
            System.out.print("###");
            for (double i4 = 0; i4 < i; i4 = i4 + 50) {
                System.out.print("-=");
            }
            System.out.print("#");
            System.out.println("||");
        }
    }

    public static void itembox(Hero hero, Hero gegner) throws IOException {
        final BufferedReader boxReader = new BufferedReader(new InputStreamReader(System.in));
        String Antwort = null;

        if (chance(1)) {
            System.out.println(prefix + "### /37283/$%4684564/$7$584385//68347#74745// ###");
            System.out.println(prefix + "###   Schwarze Box des Untergangs gefunden!   ###");
            System.out.println(prefix + "### /37283/$%4684564/$7$584385//68347#74745// ###");
            System.out.println(prefix + "###                       ###");
            System.out.println(prefix + "### was willst du machen? ###");
            System.out.println(prefix + "###      1. Verkaufen     ###");
            System.out.println(prefix + "###       2. Öffnen       ###");
            System.out.println(prefix + "###        3. Essen       ###");
            Antwort = boxReader.readLine();
            if (Antwort.equalsIgnoreCase("Verkaufen") || Antwort.equals("1")) {
                System.out.println(prefix + "###        Schwarze Box verkauft!       ###");
                System.out.println(prefix + "OH MEIN GOTT! Der Haendler ist bei Beruehrung mit der Box gestorben!");
                System.out.println(prefix + "Willst du sein Haus ausrauben?");
                Antwort = boxReader.readLine();
                if (Antwort.equalsIgnoreCase("ja")) {
                    System.out.println(prefix + "### Du herzloser Wicht! ###");
                    System.out.println(prefix + "Ein Priester hat dich entdeckt! 50 Schaden durch Herzlosigkeit!");
                    hero.kampf(-50);
                    System.out.println(prefix + "Elfische Streitaxt gefunden! Angriff um 70 erhöht!");
                    hero.setA(hero.getA() + 70);
                } else if (Antwort.equalsIgnoreCase("nein")) {
                    System.out.println(prefix + "### Mitgefuehlbonus! ###");
                    System.out.println(prefix + "Ein Prister erkennt dein Mitgefuehl und heilt dich um 400 Leben !");
                    hero.kampf(400);
                } else {
                    System.out.println(prefix + "Du hast versagt ja oder nein einzugeben.");
                    System.out.println(prefix + "Dummheitsbonus! 50 Schaden!");
                    hero.kampf(-50);
                }
            } else if (Antwort.equalsIgnoreCase("öffnen") || Antwort.equals("2")) {
                int x = (int) Math.random() * 3 + 1;
                if (x == 1) {
                    hero.setL(hero.getL() + hero.getM());
                    hero.setA(hero.getA() + hero.getM());
                    hero.setM(0);
                    System.out.println(prefix + "Schwarze Box entzieht dir all deine Magie und wandelt sie in Angriff und Leben um!");
                } else if (x == 2) {
                    hero.setA(hero.getA() * 0.8);
                    hero.setG(hero.getG() * 0.8);
                    hero.kampf(-200);
                    gegner.kampf(-200);
                    System.out.println(prefix + "3$)294 Schwarze Box explodiert! 3)324=");
                    System.out.println(prefix + "Die Explosion fuegt beiden Helden 200 Schaden zu! Ausserdem senkt sich dein Angriff und Geschick um 20%");
                } else {
                    hero.setM(666 + hero.getM());
                    hero.kampf(200);
                    System.out.println(prefix + "In der schwarzen Box findest du einen winzigen Magier");
                    System.out.println(prefix + "Er heilt dich um 200 und kaempft nun fuer dich! Magie steigt auf: " + hero.getM());
                }
            } else if (Antwort.equalsIgnoreCase("essen") || Antwort.equals("3")) {
                System.out.println(prefix + "Du isst die dunkle Box mit Messer und Gabel. Es schmeckt hart und nach dunkler Magie.");
                for (int i = 0; i < 3; i++) {
                    System.out.println("");
                    for (int j = 0; j < i; j++) {
                        System.out.print(".");
                    }
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (chance(30)) {
                    hero.setClassS(Classes.ULTIMATEFORM);
                    hero.addDefaultValues(Classes.ULTIMATEFORM);
                    System.out.println(prefix + "/// RIESIGE EXPLOSION! ///");
                    System.out.println(prefix + "Du wirst zu Illidan, dem Herrscher der Finsterniss!");
                    werteanz(hero);
                } else {
                    hero.setL(hero.getL() * 0.8);
                    System.out.println(prefix + "Verwandlung fehlgeschlagen. Du verlierst 20% deines Lebens!");
                }
            } else {
                hero.kampf(-50);
                System.out.println(prefix + "50 Schaden durch Dummheit");
            }
        }
        if (chance(1)) {
            System.out.println(prefix + "### ********************* ###");
            System.out.println(prefix + "### ********************* ###");
            System.out.println(prefix + "###   Diamant gefunden!   ###");
            System.out.println(prefix + "### ********************* ###");
            System.out.println(prefix + "### ********************* ###");
            System.out.println(prefix + "###                       ###");
            System.out.println(prefix + "### was willst du machen? ###");
            System.out.println(prefix + "###      1. Verkaufen     ###");
            System.out.println(prefix + "###       2. Werfen       ###");
            System.out.println(prefix + "###        3. Essen       ###");
            Antwort = boxReader.readLine();
            if (Antwort.equalsIgnoreCase("Verkaufen") || Antwort.equals("1")) {
                hero.setA(hero.getA() * 2);
                hero.setL(hero.getL() + 1500);
                hero.setG(hero.getG() * 0.75);
                System.out.println(prefix + "# Diamant verkauft und davon Waffen und Ruestung gekauft! Die Ruestung ist schwer.");
                System.out.println(prefix + "Angriff: " + hero.getA());
                System.out.println(prefix + "Geschick: " + hero.getG());
                System.out.println(prefix + "Leben: " + hero.getL());
            } else if (Antwort.equalsIgnoreCase("Werfen") || Antwort.equals("2")) {
                System.out.println("/***/ Diamantwurf /***/");
                System.out.println("Dein Held holt aus und wirft mit aller Kraft!!!");
                for (int i = 0; i < 3; i++) {
                    System.out.println("");
                    for (int j = 0; j < i; j++) {
                        System.out.print(".");
                    }
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Der Diamant fliegt mit so hoher Geschwindigkeit, dass er die Schallmauer durchbricht und deinen Gegner betaeubt!!");
                gegner.reG(0.7);
                gegner.reA(0.7);
                if (chance(100 * hero.getG() / (hero.getG() + 50))) {
                    System.out.println("=== kritischer TREFFER! ===");
                    System.out.println("Diamant trifft Auge des Gegners! 800 Schaden!!!");
                    gegner.reG(0.7);
                    gegner.reA(0.7);
                    gegner.kampf(-800);
                } else {

                }
                System.out.println(prefix + "# Diamant verkauft und davon Waffen und Ruestung gekauft! Die Ruestung ist schwer.");
            } else if (Antwort.equalsIgnoreCase("Essen") || Antwort.equals("3")) {
                hero.kampf(-400);
                System.out.println(prefix + "# Deine Gabel zerbricht. Du wirfst den Diamant in deinen Mund und schluckst. " + hero.getpName() + " verliert 400 Leben.");
            } else {

            }
        }
    }

    public static void antwortDB(String a, Hero hhero) {
        if (a.equalsIgnoreCase("mensch")) {
            hhero.setClassS(Classes.MENSCH);
        } else if (a.equalsIgnoreCase("krieger")) {
            hhero.setClassS(Classes.KRIEGER);
        } else if (a.equalsIgnoreCase("zombie")) {
            hhero.setClassS(Classes.ZOMBIE);
        } else if (a.equalsIgnoreCase("magier")) {
            hhero.setClassS(Classes.MAGIER);
        } else if (a.equalsIgnoreCase("elf")) {
            hhero.setClassS(Classes.ELF);
        } else if (a.equalsIgnoreCase("ork")) {
            hhero.setClassS(Classes.ORK);
        } else if (a.equalsIgnoreCase("zwerg")) {
            hhero.setClassS(Classes.ZWERG);
        } else if (a.equalsIgnoreCase("gnom")) {
            hhero.setClassS(Classes.GNOM);
        } else if (a.equalsIgnoreCase("drache")) {
            hhero.setClassS(Classes.DRACHE);
        } else if (a.equalsIgnoreCase("eisdrache")) {
            hhero.setClassS(Classes.EISDRACHE);
        } else if (a.equalsIgnoreCase("sheldon")) {
            hhero.setClassS(Classes.SHELDON);
        } else if (a.equalsIgnoreCase("hitler")) {
            hhero.setClassS(Classes.HITLER);
        } else if (a.equalsIgnoreCase("gott")) {
            hhero.setClassS(Classes.GOTT);
        } else if (a.equalsIgnoreCase("jesus")) {
            hhero.setClassS(Classes.JESUS);
        } else if (a.equalsIgnoreCase("mensch")) {
            hhero.setClassS(Classes.MENSCH);
        } else if (a.equalsIgnoreCase("Illidan")) {
            System.out.println("Netter Versuch, aber Illidan kannst du nicht nehmen, er is zu maechtig.");
        } else {
            System.out.println(prefix + "Dieser Held wird bald spielbar sein! Versuch einen anderen!");
            TODOi++;
        }
    }
    
    public static void herowahl(Hero held, int dev, float time) throws IOException {
        System.out.println(prefix + "Du hast "+time/1000+" Sekunden Zeit! Sei kreativ!");
    	
        long t1 = System.currentTimeMillis(); // Zeit zaehlen beginnt
        while (held.getClassS() == null) {
            System.err.println(prefix + "Welcher Held willst du,  " + held.getName() + " sein?");
            String antwort = reader.readLine();
            // Hero wird gelesen
            // AUSNAHMEHELDEN:
            if (antwort.equalsIgnoreCase("nein")) {
                System.out.println(prefix + "Du hast Nein eingegeben. Bist du bescheuert?");
                antwort = reader.readLine();
                if (antwort.equalsIgnoreCase("ja")) {
                    System.out.println(prefix + "Sicher dass du bescheuert bist?");
                    antwort = reader.readLine();
                    if (antwort.equalsIgnoreCase("ja")) {
                        System.out.println(prefix + "Nimm deinen Held! Letzte Chance, sonst stirbst du!");
                        antwort = reader.readLine();
                        if (antwort.equalsIgnoreCase("nein")) {
                            antwort = "NEINHEIT";
                        } else {
                            System.out.println(prefix + "oke gut!");
                            System.out.println(prefix + "Welchen Held waehlt " + held.getpName() + "?");
                        }
                    } else {
                        System.out.println(prefix + "oke gut!");
                        System.out.println(prefix + "Welchen Held waehlt " + held.getpName() + "?");
                    }
                } else {
                    System.out.println(prefix + "oke gut!");
                    System.out.println(prefix + "Welchen Held waehlt " + held.getpName() + "?");
                }
            }
                if ((System.currentTimeMillis() - t1) > time) {  // falls zu lange gebraucht wird Held "mensch" genommen
                    System.err.println(prefix + "Zeit abgelaufen! Du bist jetzt ein Mensch!!!");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    antwort = "mensch";
                }

            // ANTWORT WIRD IN HELD FALLS HELD IN DB IST!
            antwortDB(antwort, held);
        }
        held.addDefaultValues(held.getClassS()); // Wertezuweisung
        werteanz(held); // Werteanzeige
    }

    public static void kampf(Hero held, Hero gegner, int d) throws IOException {
        System.out.println("=====================================");
        itembox(gegner, held);
        System.out.println(prefix + held.getpName() + " Welchen Angriff? 1-" + held.getSpellSize());
        Scanner eingabe = new Scanner(System.in);
        int inputspell;
        if (d == 1) {
            System.out.println("HEAT:" + MiniHeros.heat);
            inputspell = (int) Math.ceil(Math.random() * held.getSpellSize());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            inputspell = eingabe.nextInt();
            while (inputspell <= 0 || inputspell > held.getSpellSize()) {
                System.out.println(prefix + " Dein Held denkt du redest Chinesisch!");
                System.out.println(prefix + " Angriff mit 1-" + held.getSpellSize());
                inputspell = eingabe.nextInt();
            }
        }

        held.setdmg(dmg(inputspell, held, MiniHeros.heat, gegner));
        if (held.getdmg() != 0) {
            System.out.println(prefix + held.getpName() + " Schaden : " + held.getdmg());
        }

        // LEBENSANZEIGE
        double hlebenvorher = gegner.getL();
        gegner.setL(gegner.getL() - held.getdmg());
        anzleben(hlebenvorher, gegner.getL(), gegner);

        /*
         * 				// KAMPF 1
         //ITEMPHASE
         System.out.println("=====================================");
         itembox(hhero1,hhero2);

         if (hhero1.getSpellSize()>1) System.out.println(prefix + hhero1.getpName() +" Welchen Angriff? 1-"+hhero1.getSpellSize());
         else System.out.println(prefix + hhero1.getpName()+" Greife mit 1 an!");
         eingabe = new Scanner(System.in);
         int inputspell = eingabe.nextInt();

         while (inputspell <= 0 || inputspell > hhero1.getSpellSize()) {
         System.out.println(prefix + " Dein Held weiss nicht was er mit "+inputspell+" anfangen soll.");
         System.out.println(prefix + " Angriff mit 1-"+hhero1.getSpellSize());
         inputspell = eingabe.nextInt();
         }
         hhero1.setdmg(dmg(inputspell, hhero1, MHero.heat, hhero2));
         if (hhero1.getdmg()!=0)System.out.println(prefix + hhero1.getpName()+ " Schaden :" + hhero1.getdmg());


         // LEBENSANZEIGE Spieler 1
         double hlebenvorher2 = hhero2.getL();
         hhero2.setL(hhero2.getL() - hhero1.getdmg());
         anzleben(hlebenvorher2,hhero2.getL(),hhero2);
         */
    }

    public static int dmg(int i, Hero h, double heat, Hero g) {
        Scanner eingabe = new Scanner(System.in);

        if (heat > 1.1) MiniHeros.heat = heat + 0.05*heat; // Jede Runde erhoeht sich der Schaden um 5%
        else MiniHeros.heat = heat*heat;
        return (int) Math.ceil(g.getres() * (heat) * (SpellDB.spell(h, g, h.getspell(i))));

        /*      SPECIALSAVE
         *
         *              if (hhirn > h2hirn*1.10) {
         double hirnevent = (double) (hhirn - h2hirn)*Math.random();
         if (hirnevent > 300) {
         double hdmgh = Math.ceil((hhirn - h2hirn)*0.05 + 2)*100;
         hdmg = hdmg + hdmgh;
         h2hirn=h2hirn*0.9;
         System.out.println(prefix + hhero1.getpName() + hero1+ "zaehlt alle Stellen von Pi auf! "+ Math.ceil((hhirn - h2hirn)*0.2 + 400)+" Schaden!");
         System.out.println(prefix + "90% der Gehirnzellen wurden gebraten!");
         } else if (hirnevent > 99) {
         double hdmgh = (hhirn - h2hirn)*0.2 + 20;
         hdmg = hdmg + hdmgh; System.out.println(prefix + hhero1.getpName() + Math.ceil((hhirn - h2hirn)*0.2 + 70) +" Schaden durch Matheunterricht!");
         } else if (hirnevent > 30) {
         double hdmgh = (hhirn - h2hirn)*0.2 + 20; hdmg = hdmg + hdmgh ;
         System.out.println(prefix + hhero1.getpName() + Math.ceil(hdmgh) +" Schaden durch Überheblichkeit verursacht!");
         }
         }

         double critevent = (double) (hgeschick)*Math.random();
         if (critevent > 200) {
         hdmg = hdmg*3; System.out.println(prefix + hhero1.getpName() + Math.ceil(hdmg*2) + " ");
         } else if (critevent > 99) {
         hdmg = hdmg + (hhirn - h2hirn)*0.2 + 60; System.out.println(prefix + hhero1.getpName() + Math.ceil((hhirn - h2hirn)*0.2 + 70) +" Schaden durch Matheunterricht!");
         } else if (critevent > 30) {
         hdmg = hdmg + (hhirn - h2hirn)*0.2 + 20; System.out.println(prefix + hhero1.getpName() + Math.ceil((hhirn - h2hirn)*0.2 + 20) +" Schaden durch Überheblichkeit verursacht!");
         }

         double ausweichevent = (double) (h2geschick)*Math.random();
         if (ausweichevent > 100 ) {
         hdmg = hdmg*((hgeschick)*0.2) -20; System.out.println(prefix + hhero1.getpName() + Math.ceil((hhirn - h2hirn)*0.2 + 400)+" Schaden durch praezisen Steinwurf auf Dummkopf!");
         } else if (ausweichevent > 99) {
         hdmg = hdmg*(0.7*(hgeschick)); System.out.println(prefix + hhero1.getpName() + Math.ceil((hhirn - h2hirn)*0.2 + 20) +" Schaden durch Überheblichkeit verursacht!");
         }


         double critchance = 0.1 + (Math.pow((hgeschick/400),2) + Math.pow((hhirn/400),2))*0.9;
         double chance = 0.7 - (0.3*Math.pow((hgeschick/100),2)) ;

         double fail = (double) (Math.random() * (1 - chance));
         double mittel = (double) (Math.random() * chance);
         double kritisch = (double) (Math.random() * critchance);

         if (kritisch > fail && kritisch > mittel) {
         // System.out.println("Du bekommst ein Diamantschwert");
         kritisch =1;
         } else if (mittel > fail && mittel > kritisch) {
         // System.out.println("Du bekommst ein Goldschwert");
         mittel =1;
         } else {
         // System.out.println("Du bekommst ein Steinschwert");
         fail = 1;
         }
         *
         */
    }

    public static void changePOWERLEVEL(Hero winner, Hero looser) {
        if (winner.getClassS() == Classes.MENSCH) {
            Values.POWERdrache -= 0.1;
        } else if (winner.getClassS() == Classes.DRACHE) {
            Values.POWERdrache -= 0.1;
        } else if (winner.getClassS() == Classes.EISDRACHE) {
            Values.POWERdrache -= 0.1;
        } 
    }

    public static void werteanz(Hero hhero) {
        // KAMPFWERTE AUSGABE

        if (superprefix.isEmpty()) {
            System.out.println(prefix + "###====|| " + hhero.getpName() + " ||====###");
        }
        System.out.println(prefix);
        System.out.print(prefix + "### - Angriff: " + hhero.getA() + "         -(=");
        for (int i = 0; i < hhero.getA(); i = i + 20) {
            System.out.print("==");
        }
        System.out.println(">");
        System.out.println(prefix + "### - Geschick: " + hhero.getG() + "        >>>");
        System.out.println(prefix + "### - Hirn: " + hhero.getH() + "             [#Hirn#]");
        System.out.print(prefix + "### - Zauberkraft: " + hhero.getM() + "    < ");
        for (int i = 0; i < hhero.getM(); i = i + 30) {
            System.out.print("~~");
        }
        System.out.println("~");
        System.out.print(prefix + "### - Leben: " + hhero.getL() + "          [[");
        for (int i = 0; i < hhero.getL(); i = i + 100) {
            System.out.print(":");
        }
        System.out.println("]]");
        System.out.println(prefix);
        superprefix = "null";

        System.out.print(prefix + "# ZAUBER # -  ");
        for (int i = 1; i <= hhero.getSpellSize(); i++) {
            System.out.print("Taste " + (i) + ": " + hhero.getspell(i) + " || ");
        }
        System.out.println("");

    }

    public static boolean chance(double prozent) {
        return Math.ceil(Math.random() * (100 / prozent)) == 1 || prozent > 100;
    }

    // PREFIX PACK
    public static String prefix = "[MiniHero] ";
    public static String prefix1 = "*********************************************";
    public static String prefix2 = "---------------------------------------------";
    public static String prefix3 = ". . . . . . . . . . . . . . . . . . . . . . .";
    public static String prefixleer = "                                          ";
    public static String spieler1 = "David";
    public static String spieler2 = "Manuel";
    public static String spielertmp = "jesus";
    public static String hero1 = "null";
    public static String hero2 = "null";
    public static String superprefix = "null";
    public static int TODOi = 0;

    // Variabeln pack
    public static double hchange, h2change;
    public static double hangriff, h2angriff;
    public static double hleben, h2leben;
    public static double hgeschick, h2geschick;
    public static double hhirn, h2hirn;
    public static double hmagie, h2magie;

    public static double hrandom = (double) Math.ceil(3 * Math.random()) * 0.15 + 0.8;
    public static double hrandom2 = (double) Math.ceil(3 * Math.random()) * 0.16 + 0.82;

    // GAMECHANGE:
    public static double heat = 1.001;
}
