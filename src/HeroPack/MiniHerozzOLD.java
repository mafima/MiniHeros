	

    package HeroPack;
    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;
     
    /* Erfinder = "Manuel Fischer" aka Mafima
     *
     * - 1 gegen 1 Kampfspiel -
     *
     */
     
    public class MiniHerozzOLD {
     
            Scanner Eingabe = new Scanner(System.in);
            static BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
     
            public static void main(String[] args) throws IOException {
     
                    // Fixvariabeln
                    int p, u, s, b, c, s1b, s2b;
     
                    // DEV Variabeln
                    int dev = 0;
     
                    // Gamechangevariabeln
                    double w = 1, wb = 0.1;
                    int skipmünze = 0;
     
     
                    // Herowerte
                    MiniHerozzOLD.hchange=1;MiniHerozzOLD.hangriff=0;MiniHerozzOLD.hgeschick=0;MiniHerozzOLD.hhirn=0;MiniHerozzOLD.hmagie=0;MiniHerozzOLD.hleben=0;
                    MiniHerozzOLD.h2change=1;MiniHerozzOLD.h2angriff=0;MiniHerozzOLD.h2geschick=0;MiniHerozzOLD.h2hirn=0;MiniHerozzOLD.h2magie=0;MiniHerozzOLD.h2leben=0;
                    double POWERmensch=1, POWERzombie=1.2, POWERkrieger= 1, POWERelf= 1,POWERork= 1,POWERzwerg= 1,POWERgnom= 1, POWERmagier= 1, POWERdrache = 0.8;
     
                    // H RANDOM wird 0.9_ 1 _ 1.1
                    hrandom = (double) Math.ceil(3*Math.random())*0.15 + 0.8;
                    hrandom2 = (double) Math.ceil(3*Math.random())*0.16 + 0.82;
     
                    MiniHerozzOLD.spieler1 = "David";
                    MiniHerozzOLD.spieler2 = "Manuel";
                    MiniHerozzOLD.spielertmp = "jesus";
                    MiniHerozzOLD.pspieler1 = " [" + spieler1 + "] ";
                    MiniHerozzOLD.pspieler2 = " [" + spieler2 + "] ";
                    MiniHerozzOLD.hero1 = "null";
                    MiniHerozzOLD.hero2 = "null";
                    MiniHerozzOLD.superprefix = "null";
     
                    System.out.println("DEV?");
                    Scanner Eingabe = new Scanner(System.in);
                    dev = Eingabe.nextInt();
                    System.out.println(dev);
     
     
                    if (dev == 0) {
                            MiniHerozzOLD.hero1 = "krieger";
                            MiniHerozzOLD.hero2 = "zombie";
                    }
     
     
                    if (dev != 0) {
                            System.out.println(prefix1);
                            System.out.println(prefix2);
                            System.out.println("- > > > > >   MiniHero v 0.001   < < < < < -");
                            System.out.println("-     DAS SPIEL DER UNENDLICHEN HELDEN     -");
                            System.out.println(prefix2);
                            System.out.println(prefix1);
                            System.out.println(prefix + "Das Spiel beginnt!");
                            System.out.println(prefixleer);
                            System.out.println(prefix + "Wie heißt Spieler 1?");
                            String Antwort = reader.readLine();
                            MiniHerozzOLD.spieler1 = Antwort;
                            System.out.println(prefix + "Wie heißt Spieler 2?");
                            Antwort = reader.readLine();
                            MiniHerozzOLD.spieler2 = Antwort;
                            MiniHerozzOLD.pspieler1 = "[" + spieler1 + "] ";
                            MiniHerozzOLD.pspieler2 = "[" + spieler2 + "] ";
     
                            // Wer fängt an?
                            double münze = 0;
                            münze = (int) Math.ceil(2*Math.random());
                            if (skipmünze == 0) {
                                    if (münze == 1) {
                                            System.out.println(prefix + "Eine Münze wurde geworfen! " + pspieler1 +"fängt an!");
                                            System.out.println(prefix + "Welchen Held wählt " + pspieler1 + "?");
                                    } else {
                                            System.out.println(prefix + "Eine Münze wurde geworfen!" + pspieler2 +"fängt an!");
                                            System.out.println(prefix + "Welchen Held wählt " + pspieler2 + "?");
                                            spielertmp = spieler1;
                                            spieler1 = spieler2;
                                            spieler2 = spielertmp;
                                            pspieler1 = "[" + spieler1 + "] ";
                                            pspieler2 = "[" + spieler2 + "] ";
                                    }
                            }
                    }
     
     
                    long t1 = System.currentTimeMillis();
                    System.out.println(prefix + "Du hast 20 Sekunden!");
                   
                    /*
                     *                              .=========================.
                     *                              |                                                 |
                     *                      |       Spieler 1 Rassenwahl  |
                     *                              |                                                 |
                     *                          *=========================*
                     *
                     */
                   
                    while (hero1 == "null") {
                            String Antwort = reader.readLine();
                            // Hero wird gelesen
                            // AUSNAHMEHELDEN:
                            if (Antwort.equalsIgnoreCase("nein")) {
                                    System.out.println(prefix + "Du hast Nein eingegeben. Bist du bescheuert?");
                                    Antwort = reader.readLine();
                                    if (Antwort.equalsIgnoreCase("ja")) {
                                            System.out.println(prefix + "Sicher dass du bescheuert bist?");
                                            Antwort = reader.readLine();
                                            if (Antwort.equalsIgnoreCase("ja")) {
                                                    System.out.println(prefix + "Nimm deinen Held! Letzte Chance, sonst stirbst du!");
                                                    Antwort = reader.readLine();
                                                    if (Antwort.equalsIgnoreCase("nein")) {
                                                            Antwort = "NEINHEIT";
                                                    } else {
                                                            System.out.println(prefix + "oke gut!");
                                                            System.out.println(prefix + "Welchen Held wählt " + pspieler1 + "?");
                                                    }
                                            } else {
                                                    System.out.println(prefix + "oke gut!");
                                                    System.out.println(prefix + "Welchen Held wählt " + pspieler1 + "?");
                                            }
                                    } else {
                                            System.out.println(prefix + "oke gut!");
                                            System.out.println(prefix + "Welchen Held wählt " + pspieler1 + "?");
                                    }
                            }
                            // ANTWORT WIRD IN HELD FALLS HELD IN DB IST!
                            hero1 = antwortDB(Antwort);
                           
                            long t2 = System.currentTimeMillis();
                            long t3 = t2 -t1;
                            if (t3 > 20000) {
                                    System.out.println(prefix + "Zeit abgelaufen! Du bist jetzt ein Mensch!!!");
                                    hero1 = "mensch";}
                    }
     
     
     
                    // HERO DATABASE
     
                            heroDB(hero1,pspieler1,hrandom, hangriff,hgeschick,hhirn,hmagie,hleben);
     
     
                    // Hero gewählt
     
     
                    /*
                     *                              .=========================.
                     *                              |                                                 |
                     *                      |       Spieler 2 Rassenwahl  |
                     *                              |                                                 |
                     *                          *=========================*
                     *
                     */
     
                    while (hero2 == "null") {
                            System.out.println(prefix + pspieler2 + "darf nun seinen Helden wählen!");
                            String Antwort = reader.readLine();
                            // Hero wird gelesen
                            MiniHerozzOLD.hero2 = antwortDB(Antwort);
                    }
     
                    // HERO DATABASE
     
     
                    heroDB(hero2,pspieler2,hrandom2, h2angriff,h2geschick,h2hirn,h2magie,h2leben);
                    if (hero2 == "mensch") {
                            System.out.println(prefix + pspieler2 + "ist ein Mensch! Wie langweilig!");
                            hchange = POWERmensch * hrandom;
                            h2angriff = (double) Math.ceil(10* hchange);
                            h2geschick = (double) Math.ceil(10 * hchange);
                            h2hirn = (double) Math.ceil(50 * hchange);
                            h2magie = (double) Math.ceil(10* hchange);
                            h2leben = (double) Math.ceil(200* hchange);
                    }
                    if (hero2 == "krieger") {
                            System.out.println(prefix + pspieler2 + "ist ein Krieger! In den Kampf!!!");
                            hchange = POWERkrieger * hrandom;
                            h2angriff = (double) Math.ceil(10* hchange);
                            h2geschick = (double) Math.ceil(10 * hchange);
                            h2hirn = (double) Math.ceil(50 * hchange);
                            h2magie = (double) Math.ceil(10* hchange);
                            h2leben = (double) Math.ceil(200* hchange);
                    }
                    if (hero2 == "zombie") {
                            System.out.println("+++ GESTALT DES TODES +++");
                            hchange = POWERzombie * hrandom;
                            h2angriff = (float) Math.ceil(3 * hchange);
                            h2geschick = (float) Math.ceil(2 * hchange);
                            h2hirn = (float) Math.ceil(0 * hchange);
                            h2magie = (float) Math.ceil(2 * hchange);
                            h2leben = (float) Math.ceil(1700 * hchange);
                            superprefix = "ZOMBIEEE";
                            System.out.println(prefix + ".======================================.");
                            System.out.println(prefix + "|   -   -   -   -   -   -   -   -   -  |");
                            System.out.println(prefix + "|   -   R.  I.  P.  . "+pspieler2+" . . .  - |");
                            System.out.println(prefix + "|   -   -   -   -   -   -   -   -   -  |");
                            System.out.println(prefix + "*======================================*");
                    }
                    if (hero2 == "drache") {
                            System.out.print("~ MÖGEN DIE FLAMMEN SIE FOLTERN ~");
                            System.out.print("~ MÖGEN DIE FLAMMEN SIE FOLTERN ~");
                            System.out.println("~ MÖGEN DIE FLAMMEN SIE FOLTERN ~");
                            h2angriff = (float) Math.ceil(500 * POWERdrache * hrandom);
                            h2geschick = (float) Math.ceil(55 * POWERdrache * hrandom);
                            h2hirn = (float) Math.ceil(4 * POWERdrache * hrandom);
                            h2magie = (float) Math.ceil(200 * POWERdrache * hrandom);
                            h2leben = (float) Math.ceil(4000 * POWERdrache * hrandom);
                            superprefix = "SUPERDRACHE";
                            System.out.println(prefix + ".======================================. ~~~~~~~~~~~~~~           ~~~~~~~ ~  ~     ");
                            System.out.println(prefix + "|   -   -   -   -   -   -   -   -   -  | ~~~~~~~~~~~~~~~~~~~  ~~~~~~~~~~~ ~ ~~  ~     ~");
                            System.out.println(prefix + "|   -  F e u e r   ~~~  D r a c h e  - | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   ~~   ~~   ~ ~~  ~     ~");
                            System.out.println(prefix + "|   -   -   -   -   -   -   -   -   -  | ~~~      ~~~~~~~~~~~~~~~~~~~  ~     ~");
                            System.out.println(prefix + "*======================================* ~            ~~~~~~~~~~~~~  ~~ ~~  ~     ~");
                    }
     
                    // Hero gewählt
     
                    // KAMPFWERTE AUSGABE
     
                    if (superprefix == "null") System.out.println(prefix + "###====|| " + hero2 + " ||====###");
                    System.out.println(prefix);
                    System.out.print(prefix + "### - Angriff: "+ h2angriff +"         -(=");
                    for (double i=0;i<h2angriff;i=i+20) System.out.print("==");
                    System.out.println(">");
                    System.out.println(prefix + "### - Geschick: "+ h2geschick +"        >>>");
                    System.out.println(prefix + "### - Hirn: "+ h2hirn +"             [#Hirn#]");
                    System.out.print(prefix + "### - Zauberkraft: "+ h2magie +"    < ");
                    for (double i=0;i<h2magie;i=i+30) System.out.print("~~");
                    System.out.println("~");
                    System.out.print(prefix + "### - Leben: "+ h2leben +"          [[<");
                    for (double i=0;i<h2leben;i=i+250) System.out.print("33");
                    System.out.println("3]]");
                    System.out.println(prefix);
     
     
     
     
     
                    if (dev !=0) {
                            System.out.println(prefix + "Bereit?");
                            String Antwort = reader.readLine(); }
     
                    System.out.println(prefix2);
                    System.out.println(prefix2);
                    System.out.println(prefix + "DER KAMPF BEGINNT!");
                    System.out.println(prefix2);
                    System.out.println(prefix2);
                    /////////////// KAMPF /////////////////////////////////////////////////////////////////
                    ///////////////////////////////////////////////////////////////////////////////////////
     
                    double dmgheat=1; double dmgheatadd=0.1; int kampf =1;
                    double hdmg = 0, h2dmg = 0;
                   
                    while (hleben > 0 && h2leben > 0) {
                            if (kampf==1) {
                           
                            //ITEMPHASE
                            itembox(hero1);
     
                            //KAMPF 1
                            // TODO: schadensverteilung: 0.8  1  1.4
                            // TODO: geschick erhöht, dass zufälle auftreten
                            // TODO: hirn erhöht den schaden von den zufällen
                            // TODO: zauberschaden = zusätzliche zufälle
     
                            // TODO: SPELLS. von 1-9
                            if (spellmax>1) System.out.println(prefix + " Welchen Angriff? 1-"+spellmax);
                            else System.out.println(prefix + " Greife mit 1 an!");
                            Eingabe = new Scanner(System.in);
                            int x = Eingabe.nextInt();
                            while ( Angriffscheck(x, spellmax) == -1) {
                                    System.out.println(prefix + " Angriff? 1-"+spellmax);
                                    x = Eingabe.nextInt();
                            }
                            MiniHerozzOLD.hdmg = dmg(x,MiniHerozzOLD.hangriff,MiniHerozzOLD.hhirn,MiniHerozzOLD.hgeschick,MiniHerozzOLD.hmagie);
                           
                            //KAMPF 1 ENDE
                            // LEBENANZEIGE
                            System.out.println(prefix + " Schaden:" + MiniHerozzOLD.hdmg);
     
                            double h2lebenvorher = MiniHerozzOLD.h2leben;
                            MiniHerozzOLD.h2leben = MiniHerozzOLD.h2leben - MiniHerozzOLD.hdmg;      // Gegner verliert Leben durch Angriff
                            anzleben(h2lebenvorher,MiniHerozzOLD.h2leben,MiniHerozzOLD.hero2,MiniHerozzOLD.pspieler2);
     
                            kampf = 2; if(MiniHerozzOLD.h2leben <= 0) kampf = 0;
                            }
     
     
                            if (kampf == 2) {
                            //ITEMPHASE
                            //KAMPF 2 ////////////////////////////////////////////////////////////////////
                            // LEBENANZEIGE
                            System.out.print(prefix + " Angriff?");
                            Eingabe = new Scanner(System.in);
                            int x = Eingabe.nextInt();
                            MiniHerozzOLD.h2dmg = dmg(x, MiniHerozzOLD.h2angriff,MiniHerozzOLD.h2hirn,MiniHerozzOLD.h2geschick,MiniHerozzOLD.h2magie);
                            System.out.println(prefix + " Schaden:" + MiniHerozzOLD.h2dmg);
     
     
                            // LEBENSANZEIGE Spieler 2
                            double hlebenvorher = MiniHerozzOLD.hleben;
                            MiniHerozzOLD.hleben = MiniHerozzOLD.hleben - MiniHerozzOLD.h2dmg;
                            anzleben(hlebenvorher,MiniHerozzOLD.hleben,MiniHerozzOLD.hero1,MiniHerozzOLD.pspieler1);
                           
                            kampf = 1; if(MiniHerozzOLD.hleben <= 0) kampf = 0;
                            }
                    }
                    // END
                    if (h2leben <= 0) System.out.println(prefix + pspieler1  + "hat gewonnen!!!");
                    else System.out.println(prefix + pspieler2  + "hat gewonnen!!!");
                    System.out.println(prefix + "********* END **********");
     
     
     
     
            }
     
            public static void anzleben (double anzlebvor , double anzleb, String hero, String pspieler) {
                    for (double i=anzlebvor;i > anzleb;i = i - (10+(anzlebvor-anzleb)/10)) {
                            if (i<(anzlebvor-anzleb)/(10+(anzlebvor-anzleb)/10)) System.out.println(prefix + "+KAMPF+" + pspieler + "[ "+hero+" ] "+ Math.ceil(anzleb)+" Leben :");
                            else System.out.print(prefix + " KAMPF -(=>" + pspieler + "["+hero+"] "+ Math.ceil(i)+" Leben :");
                            System.out.print("###");
                            for (double i4=0;i4<i;i4=i4+50) System.out.print("-="); System.out.print("#"); System.out.println("||");
                    }
            }
     
            public static void itembox (String hero) throws IOException {
                    final BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
                    String Antwort = null;
                   
                    int item = (int) Math.ceil(100*Math.random()); if (item == 1) {
                            System.out.println(prefix + "### /37283/$%4684564/$7$584385//68347#74745// ###");
                            System.out.println(prefix + "###   Schwarze Box des Untergangs gefunden!   ###");
                            System.out.println(prefix + "### /37283/$%4684564/$7$584385//68347#74745// ###");
                            System.out.println(prefix + "###                       ###");
                            System.out.println(prefix + "### was willst du machen? ###");
                            System.out.println(prefix + "###      1. Verkaufen     ###");
                            System.out.println(prefix + "###       2. Öffnen       ###");
                            System.out.println(prefix + "###        3. Essen       ###");
                            Antwort = reader.readLine();
                            if (Antwort.equalsIgnoreCase("Verkaufen")) {
                                    System.out.println(prefix + "###        Schwarze Box verkauft!       ###");
                                    System.out.println(prefix + "OH MEIN GOTT! Der Händler ist bei Berührung mit der Box gestorben!");
                                    System.out.println(prefix + "Willst du sein Haus ausrauben?");
                                    Antwort = reader.readLine();
                                    if (Antwort.equalsIgnoreCase("ja")) {
                                            System.out.println(prefix + "### Du herzloser Wicht! ###");
                                            System.out.println(prefix + "50 Schaden durch Herzlosigkeit!");
                                            hleben = hleben - 50;
                                            System.out.println(prefix + "Elfische Streitaxt gefunden! Angriff um 70 erhöht!");
                                            hangriff = hangriff + 70;
                                    }
                            }if (Antwort.equalsIgnoreCase("öffnen")) {
     
                            } if (Antwort.equalsIgnoreCase("essen")) {
     
                            }
                    }
                    if (item == 2) {
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
                            Antwort = reader.readLine();
                            if (Antwort.equalsIgnoreCase("Verkaufen")) {
                                    hangriff = hangriff + 350;
                            }
                    }
     
                    int itemchance = 15;
                    item = (int) Math.ceil(20*Math.random()); if (item == 0) {
                            System.out.println(prefix + "### /37283/$%4684564/$7$584385//68347#74745// ###");
                            System.out.println(prefix + "###   Schwarze Box des Untergangs gefunden!   ###");
                            System.out.println(prefix + "### /37283/$%4684564/$7$584385//68347#74745// ###");
                            System.out.println(prefix + "###                       ###");
                            System.out.println(prefix + "### was willst du machen? ###");
                            System.out.println(prefix + "###      1. Verkaufen     ###");
                            System.out.println(prefix + "###       2. Öffnen       ###");
                            System.out.println(prefix + "###        3. Essen       ###");
                            Antwort = reader.readLine();
                    }
            }
            public static String antwortDB (String Antwort) {
                    if (Antwort.equalsIgnoreCase("mensch")) {
                            return "mensch";
                    } else if (Antwort.equalsIgnoreCase("krieger")) {
                            return "krieger";
                    } else if (Antwort.equalsIgnoreCase("zombie")) {
                            return "zombie";
                    } else if (Antwort.equalsIgnoreCase("magier")) {
                            return "magier";
                    } else if (Antwort.equalsIgnoreCase("elf")) {
                            return "elf";
                    } else if (Antwort.equalsIgnoreCase("ork")) {
                            return "ork";
                    } else if (Antwort.equalsIgnoreCase("zwerg")) {
                            return "zwerg";
                    } else if (Antwort.equalsIgnoreCase("gnom")) {
                            return "gnom";
                    } else if (Antwort.equalsIgnoreCase("drache")) {
                            return "drache";
                    } else if (Antwort.equalsIgnoreCase("eisdrache")) {
                            return "eisdrache";
                    } else if (Antwort.equalsIgnoreCase("sheldoncooper")) {
                            return "sheldoncooper";
                    } else if (Antwort.equalsIgnoreCase("hitler")) {
                            return"hitler";
                    } else if (Antwort.equalsIgnoreCase("gott")) {
                            return "gott";
                    } else if (Antwort.equalsIgnoreCase("jesus")) {
                            return "jesus";
                    } else if (Antwort.equalsIgnoreCase("mensch")) {
                            return "mensch";
                    } else if (Antwort.equalsIgnoreCase("mensch")) {
                            return "mensch";
                    } else {
                            System.out.println(prefix + "Dieser Held wird bald spielbar sein! Versuch einen anderen!");
                            String[] TODOHELD = new String [100];
                            TODOi++; TODOHELD[TODOi] = Antwort;
                            return "null";
                    }
            }
           
            public static int Angriffscheck(int spellzahl, int spellmax) {
                            if (spellzahl <= spellmax && spellzahl >= 1) {
                                    return spellzahl;
                            } else {
                                    System.out.println(prefix + "Du hast diesen Spell nicht!");
                                    return -1;
                            }
           
            }
           
            public static double dmg(int AngriffZahl, double angriff, double hirn, double geschick, double magie) {
                    if (AngriffZahl == 5 && MiniHerozzOLD.spell5burn == 1) {
                            System.out.println(prefix + "*** ULTIMATE ***");
                            MiniHerozzOLD.spell5burn = 0; return angriff*20;}
                    else if (AngriffZahl == 1) return Math.ceil(1*angriff);
                    else return Math.ceil(0.8*angriff + (angriff* (1+ (0.005*geschick))) + (0.2*hirn) + (0.2*magie));
                   
                    /*      SPECIALSAVE
                     *
                     *              if (hhirn > h2hirn*1.10) {
                            double hirnevent = (double) (hhirn - h2hirn)*Math.random();
                            if (hirnevent > 300) {
                                    double hdmgh = Math.ceil((hhirn - h2hirn)*0.05 + 2)*100;
                                    hdmg = hdmg + hdmgh;
                                    h2hirn=h2hirn*0.9;
                                    System.out.println(prefix + pspieler1 + hero1+ "zählt alle Stellen von Pi auf! "+ Math.ceil((hhirn - h2hirn)*0.2 + 400)+" Schaden!");
                                    System.out.println(prefix + "90% der Gehirnzellen wurden gebraten!");
                            } else if (hirnevent > 99) {
                                    double hdmgh = (hhirn - h2hirn)*0.2 + 20;
                                    hdmg = hdmg + hdmgh; System.out.println(prefix + pspieler1 + Math.ceil((hhirn - h2hirn)*0.2 + 70) +" Schaden durch Matheunterricht!");
                            } else if (hirnevent > 30) {
                                    double hdmgh = (hhirn - h2hirn)*0.2 + 20; hdmg = hdmg + hdmgh ;
                                    System.out.println(prefix + pspieler1 + Math.ceil(hdmgh) +" Schaden durch Überheblichkeit verursacht!");
                            }
                    }
     
                    double critevent = (double) (hgeschick)*Math.random();
                    if (critevent > 200) {
                            hdmg = hdmg*3; System.out.println(prefix + pspieler1 + Math.ceil(hdmg*2) + " ");
                    } else if (critevent > 99) {
                            hdmg = hdmg + (hhirn - h2hirn)*0.2 + 60; System.out.println(prefix + pspieler1 + Math.ceil((hhirn - h2hirn)*0.2 + 70) +" Schaden durch Matheunterricht!");
                    } else if (critevent > 30) {
                            hdmg = hdmg + (hhirn - h2hirn)*0.2 + 20; System.out.println(prefix + pspieler1 + Math.ceil((hhirn - h2hirn)*0.2 + 20) +" Schaden durch Überheblichkeit verursacht!");
                    }
     
                    double ausweichevent = (double) (h2geschick)*Math.random();
                    if (ausweichevent > 100 ) {
                            hdmg = hdmg*((hgeschick)*0.2) -20; System.out.println(prefix + pspieler1 + Math.ceil((hhirn - h2hirn)*0.2 + 400)+" Schaden durch präzisen Steinwurf auf Dummkopf!");
                    } else if (ausweichevent > 99) {
                            hdmg = hdmg*(0.7*(hgeschick)); System.out.println(prefix + pspieler1 + Math.ceil((hhirn - h2hirn)*0.2 + 20) +" Schaden durch Überheblichkeit verursacht!");
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
           
            public static void heroDB(String hero,String pspieler,double hrandom, double hangriff,double hgeschick,double hhirn,double hmagie,double hleben) {
                    spellmax = 5;
                    if (hero == "mensch") {
                            System.out.println(prefix + pspieler + "ist ein Mensch! Wie langweilig!");
                            MiniHerozzOLD.hchange = 1 * hrandom;
                            MiniHerozzOLD.hangriff = (double) Math.ceil(10* hchange);
                            MiniHerozzOLD.hgeschick = (double) Math.ceil(10 * hchange);
                            MiniHerozzOLD.hhirn = (double) Math.ceil(50 * hchange);
                            MiniHerozzOLD.hmagie = (double) Math.ceil(10* hchange);
                            MiniHerozzOLD.hleben = (double) Math.ceil(200* hchange);
                    }
                    if (hero == "magier") {
                            System.out.println(prefix + pspieler1 + "ist ein Mager! Kazing! Woosh! Lightningbolt!");
                            MiniHerozzOLD.hchange = 1 * hrandom;
                            MiniHerozzOLD.hangriff = (double) Math.ceil(5* hchange);
                            MiniHerozzOLD.hgeschick = (double) Math.ceil(0 * hchange);
                            MiniHerozzOLD.hhirn = (double) Math.ceil(200 * hchange);
                            MiniHerozzOLD.hmagie = (double) Math.ceil(300* hchange);
                            MiniHerozzOLD.hleben = (double) Math.ceil(300* hchange);
                    }
                    if (hero == "elf") {
                            MiniHerozzOLD.hchange = 1 * hrandom;
                            MiniHerozzOLD.hangriff = (double) Math.ceil(40* hchange);
                            MiniHerozzOLD.hgeschick = (double) Math.ceil(50 * hchange);
                            MiniHerozzOLD.hhirn = (double) Math.ceil(70 * hchange);
                            MiniHerozzOLD.hmagie = (double) Math.ceil(20* hchange);
                            MiniHerozzOLD.hleben = (double) Math.ceil(300* hchange);
                            MiniHerozzOLD.superprefix = "krieger";
                            System.out.println(prefix + pspieler1 + "ist ein geschickter Elf! Mach dein Volk stolz!");
                    }
                    if (hero1 == "ork") {
                            MiniHerozzOLD.hchange = 1 * hrandom;
                            MiniHerozzOLD.hangriff = (double) Math.ceil(70* hchange);
                            MiniHerozzOLD.hgeschick = (double) Math.ceil(30 * hchange);
                            MiniHerozzOLD.hhirn = (double) Math.ceil(10 * hchange);
                            MiniHerozzOLD.hmagie = (double) Math.ceil(0* hchange);
                            MiniHerozzOLD.hleben = (double) Math.ceil(800* hchange);
                            MiniHerozzOLD.superprefix = "krieger";
                                    System.out.println(prefix + pspieler1 + "ORK SEIEN STAAAARK!");
                    }
                    if (hero1 == "zwerg") {
                            MiniHerozzOLD.hchange = 1 * hrandom;
                            MiniHerozzOLD.hangriff = (double) Math.ceil(50* hchange);
                            MiniHerozzOLD.hgeschick = (double) Math.ceil(50 * hchange);
                            MiniHerozzOLD.hhirn = (double) Math.ceil(30 * hchange);
                            MiniHerozzOLD.hmagie = (double) Math.ceil(10* hchange);
                            MiniHerozzOLD.hleben = (double) Math.ceil(600* hchange);
                            MiniHerozzOLD.superprefix = "krieger";
                            System.out.println(prefix + pspieler1 + "Mit einem starkem Bart besiegt man jeden!");
            }
                    if (hero1 == "gnom") {
                            MiniHerozzOLD.hchange = 1 * hrandom;
                            MiniHerozzOLD.hangriff = (double) Math.ceil(20* hchange);
                            MiniHerozzOLD.hgeschick = (double) Math.ceil(10 * hchange);
                            MiniHerozzOLD.hhirn = (double) Math.ceil(130 * hchange);
                            MiniHerozzOLD.hmagie = (double) Math.ceil(60* hchange);
                            MiniHerozzOLD.hleben = (double) Math.ceil(300* hchange);
                            MiniHerozzOLD.superprefix = "krieger";
                            System.out.println(prefix + pspieler1 + "Ich bin gefährlich! Hört auf zu lachen!!!");
            }
                    if (hero1 == "krieger") {
                            MiniHerozzOLD.hchange = 1 * hrandom;
                            MiniHerozzOLD.hangriff = (double) Math.ceil(50* hchange);
                            MiniHerozzOLD.hgeschick = (double) Math.ceil(10 * hchange);
                            MiniHerozzOLD.hhirn = (double) Math.ceil(50 * hchange);
                            MiniHerozzOLD.hmagie = (double) Math.ceil(10* hchange);
                            MiniHerozzOLD.hleben = (double) Math.ceil(500* hchange);
                            MiniHerozzOLD.superprefix = "krieger";
                            System.out.println(prefix + pspieler1 + "ist ein Krieger! In den Kampf!!!");
                    }
                    if (hero1 == "zombie") {
                            System.out.println("+++ GESTALT DES TODES +++");
                            MiniHerozzOLD.hchange = 1 * hrandom;
                            MiniHerozzOLD.hangriff = (double) Math.ceil(5* hchange);
                            MiniHerozzOLD.hgeschick = (float) Math.ceil(2 * hchange);
                            MiniHerozzOLD.hhirn = (float) Math.ceil(0 * hchange);
                            MiniHerozzOLD.hmagie = (float) Math.ceil(2 * hchange);
                            MiniHerozzOLD.hleben = (float) Math.ceil(1700 * hchange);
                            MiniHerozzOLD.superprefix = "ZOMBIEEE";
                            System.out.println(prefix + ".======================================.");
                            System.out.println(prefix + "|   -   -   -   -   -   -   -   -   -  |");
                            System.out.println(prefix + "|   -   R.  I.  P.  . "+pspieler1+" . . .  - |");
                            System.out.println(prefix + "|   -   -   -   -   -   -   -   -   -  |");
                            System.out.println(prefix + "*======================================*");
                    }
                    if (hero1 == "drache") {
                            System.out.print("~ MÖGEN DIE FLAMMEN SIE FOLTERN ~");
                            System.out.print("~ MÖGEN DIE FLAMMEN SIE FOLTERN ~");
                            System.out.println("~ MÖGEN DIE FLAMMEN SIE FOLTERN ~");
                            MiniHerozzOLD.hchange = 1 * hrandom;
                            MiniHerozzOLD.hangriff = (float) Math.ceil(500 * hchange);
                            MiniHerozzOLD.hgeschick = (float) Math.ceil(55 * hchange);
                            MiniHerozzOLD.hhirn = (float) Math.ceil(4 * hchange);
                            MiniHerozzOLD.hmagie = (float) Math.ceil(200 * hchange);
                            MiniHerozzOLD.hleben = (float) Math.ceil(4000 * hchange);
                            MiniHerozzOLD.superprefix = "SUPERDRACHE";
                            System.out.println(prefix + ".======================================. ~~~~~~~~~~~~~~           ~~~~~~~ ~  ~     ");
                            System.out.println(prefix + "|   -   -   -   -   -   -   -   -   -  | ~~~~~~~~~~~~~~~~~~~  ~~~~~~~~~~~ ~ ~~  ~     ~");
                            System.out.println(prefix + "|   -  F e u e r   ~~~  D r a c h e  - | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   ~~   ~~   ~ ~~  ~     ~");
                            System.out.println(prefix + "|   -   -   -   -   -   -   -   -   -  | ~~~      ~~~~~~~~~~~~~~~~~~~  ~     ~");
                            System.out.println(prefix + "*======================================* ~            ~~~~~~~~~~~~~  ~~ ~~  ~     ~");
                    }
                    if (hero1 == "eisdrache") {
                            for (int i=0;i<3;i++) {System.out.println(" ~| MÖGE DAS EIS SIE SPALTEN |~ ");}
                            MiniHerozzOLD.spellmax = 2;
                            spell1 = "Angstschrei";
                            spell2 = "Eisfeuer";
                            MiniHerozzOLD.hchange = 1 * hrandom;
                            MiniHerozzOLD.hangriff = (float) Math.ceil(500 * hchange);
                            MiniHerozzOLD.hgeschick = (float) Math.ceil(35 * hchange);
                            MiniHerozzOLD.hhirn = (float) Math.ceil(120 * hchange);
                            MiniHerozzOLD.hmagie = (float) Math.ceil(150 * hchange);
                            MiniHerozzOLD.hleben = (float) Math.ceil(3500 * hchange);
                            MiniHerozzOLD.superprefix = "SUPERDRACHE";
                            System.out.println(prefix + ".======================================. ~~~~~~~~~~~~~~           ~~~~~~~ ~  ~     ");
                            System.out.println(prefix + "|   -   -   -   -   -   -   -   -   -  | ~~~~~~~~~~~~~~~~~~~  ~~~~~~~~~~~ ~ ~~  ~     ~");
                            System.out.println(prefix + "|   -    E i s     ~~~  D r a c h e  - | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   ~~   ~~   ~ ~~  ~     ~");
                            System.out.println(prefix + "|   -   -   -   -   -   -   -   -   -  | ~~~      ~~~~~~~~~~~~~~~~~~~  ~     ~");
                            System.out.println(prefix + "*======================================* ~            ~~~~~~~~~~~~~  ~~ ~~  ~     ~");
                    }
                   
     
                    // Hero gewählt
     
                    // KAMPFWERTE AUSGABE
     
                    if (superprefix == "null") System.out.println(prefix + "###====|| " + hero1 + " ||====###");
                    System.out.println(prefix);
                    System.out.print(prefix + "### - Angriff: "+ MiniHerozzOLD.hangriff +"         -(=");
                    for (int i=0;i<MiniHerozzOLD.hangriff;i=i+20) System.out.print("==");
                    System.out.println(">");
                    System.out.println(prefix + "### - Geschick: "+ MiniHerozzOLD.hgeschick +"        >>>");
                    System.out.println(prefix + "### - Hirn: "+ MiniHerozzOLD.hhirn +"             [#Hirn#]");
                    System.out.print(prefix + "### - Zauberkraft: "+ MiniHerozzOLD.hmagie +"    < ");
                    for (int i=0;i<MiniHerozzOLD.hmagie;i=i+30) System.out.print("~~");
                    System.out.println("~");
                    System.out.print(prefix + "### - Leben: "+ MiniHerozzOLD.hleben +"          [[<");
                    for (int i=0;i<MiniHerozzOLD.hleben;i=i+250) System.out.print("33");
                    System.out.println("3]]");
                    System.out.println(prefix);
     
     
     
                    superprefix = "null";
                   
            }
           
           
            public static void heroDB2(String hero,String pspieler,double hrandom, double hangriff,double hgeschick,double hhirn,double hmagie,double hleben) {
                    spellmax = 5;
                    if (hero == "mensch") {
                            System.out.println(prefix + pspieler + "ist ein Mensch! Wie langweilig!");
                            MiniHerozzOLD.h2change = 1 * hrandom;
                            MiniHerozzOLD.h2angriff = (double) Math.ceil(10* hchange);
                            MiniHerozzOLD.h2geschick = (double) Math.ceil(10 * hchange);
                            MiniHerozzOLD.h2hirn = (double) Math.ceil(50 * hchange);
                            MiniHerozzOLD.h2magie = (double) Math.ceil(10* hchange);
                            MiniHerozzOLD.h2leben = (double) Math.ceil(200* hchange);
                    }
                    if (hero == "magier") {
                            System.out.println(prefix + pspieler1 + "ist ein Mager! Kazing! Woosh! Lightningbolt!");
                            MiniHerozzOLD.h2change = 1 * hrandom;
                            MiniHerozzOLD.h2angriff = (double) Math.ceil(5* hchange);
                            MiniHerozzOLD.h2geschick = (double) Math.ceil(0 * hchange);
                            MiniHerozzOLD.h2hirn = (double) Math.ceil(200 * hchange);
                            MiniHerozzOLD.h2magie = (double) Math.ceil(300* hchange);
                            MiniHerozzOLD.h2leben = (double) Math.ceil(300* hchange);
                    }
                    if (hero == "elf") {
                            MiniHerozzOLD.h2change = 1 * hrandom;
                            MiniHerozzOLD.h2angriff = (double) Math.ceil(40* hchange);
                            MiniHerozzOLD.h2geschick = (double) Math.ceil(50 * hchange);
                            MiniHerozzOLD.h2hirn = (double) Math.ceil(70 * hchange);
                            MiniHerozzOLD.h2magie = (double) Math.ceil(20* hchange);
                            MiniHerozzOLD.h2leben = (double) Math.ceil(300* hchange);
                            MiniHerozzOLD.superprefix = "krieger";
                            System.out.println(prefix + pspieler1 + "ist ein geschickter Elf! Mach dein Volk stolz!");
                    }
                    if (hero1 == "ork") {
                            MiniHerozzOLD.h2change = 1 * hrandom;
                            MiniHerozzOLD.h2angriff = (double) Math.ceil(70* hchange);
                            MiniHerozzOLD.h2geschick = (double) Math.ceil(30 * hchange);
                            MiniHerozzOLD.h2hirn = (double) Math.ceil(10 * hchange);
                            MiniHerozzOLD.h2magie = (double) Math.ceil(0* hchange);
                            MiniHerozzOLD.h2leben = (double) Math.ceil(800* hchange);
                            MiniHerozzOLD.superprefix = "krieger";
                                    System.out.println(prefix + pspieler1 + "ORK SEIEN STAAAARK!");
                    }
                    if (hero1 == "zwerg") {
                            MiniHerozzOLD.h2change = 1 * hrandom;
                            MiniHerozzOLD.h2angriff = (double) Math.ceil(50* hchange);
                            MiniHerozzOLD.h2geschick = (double) Math.ceil(50 * hchange);
                            MiniHerozzOLD.h2hirn = (double) Math.ceil(30 * hchange);
                            MiniHerozzOLD.h2magie = (double) Math.ceil(10* hchange);
                            MiniHerozzOLD.h2leben = (double) Math.ceil(600* hchange);
                            MiniHerozzOLD.superprefix = "krieger";
                            System.out.println(prefix + pspieler1 + "Mit einem starkem Bart besiegt man jeden!");
            }
                    if (hero1 == "gnom") {
                            MiniHerozzOLD.h2change = 1 * hrandom;
                            MiniHerozzOLD.h2angriff = (double) Math.ceil(20* hchange);
                            MiniHerozzOLD.h2geschick = (double) Math.ceil(10 * hchange);
                            MiniHerozzOLD.h2hirn = (double) Math.ceil(130 * hchange);
                            MiniHerozzOLD.h2magie = (double) Math.ceil(60* hchange);
                            MiniHerozzOLD.h2leben = (double) Math.ceil(300* hchange);
                            MiniHerozzOLD.superprefix = "krieger";
                            System.out.println(prefix + pspieler1 + "Ich bin gefährlich! Hört auf zu lachen!!!");
            }
                    if (hero1 == "krieger") {
                            MiniHerozzOLD.h2change = 1 * hrandom;
                            MiniHerozzOLD.h2angriff = (double) Math.ceil(50* hchange);
                            MiniHerozzOLD.h2geschick = (double) Math.ceil(10 * hchange);
                            MiniHerozzOLD.h2hirn = (double) Math.ceil(50 * hchange);
                            MiniHerozzOLD.h2magie = (double) Math.ceil(10* hchange);
                            MiniHerozzOLD.h2leben = (double) Math.ceil(500* hchange);
                            MiniHerozzOLD.superprefix = "krieger";
                            System.out.println(prefix + pspieler1 + "ist ein Krieger! In den Kampf!!!");
                    }
                    if (hero1 == "zombie") {
                            System.out.println("+++ GESTALT DES TODES +++");
                            MiniHerozzOLD.h2change = 1 * hrandom;
                            MiniHerozzOLD.h2angriff = (double) Math.ceil(5* hchange);
                            MiniHerozzOLD.h2geschick = (float) Math.ceil(2 * hchange);
                            MiniHerozzOLD.h2hirn = (float) Math.ceil(0 * hchange);
                            MiniHerozzOLD.h2magie = (float) Math.ceil(2 * hchange);
                            MiniHerozzOLD.h2leben = (float) Math.ceil(1700 * hchange);
                            MiniHerozzOLD.superprefix = "ZOMBIEEE";
                            System.out.println(prefix + ".======================================.");
                            System.out.println(prefix + "|   -   -   -   -   -   -   -   -   -  |");
                            System.out.println(prefix + "|   -   R.  I.  P.  . "+pspieler1+" . . .  - |");
                            System.out.println(prefix + "|   -   -   -   -   -   -   -   -   -  |");
                            System.out.println(prefix + "*======================================*");
                    }
                    if (hero1 == "drache") {
                            System.out.print("~ MÖGEN DIE FLAMMEN SIE FOLTERN ~");
                            System.out.print("~ MÖGEN DIE FLAMMEN SIE FOLTERN ~");
                            System.out.println("~ MÖGEN DIE FLAMMEN SIE FOLTERN ~");
                            MiniHerozzOLD.h2change = 1 * hrandom;
                            MiniHerozzOLD.h2angriff = (float) Math.ceil(500 * hchange);
                            MiniHerozzOLD.h2geschick = (float) Math.ceil(55 * hchange);
                            MiniHerozzOLD.h2hirn = (float) Math.ceil(4 * hchange);
                            MiniHerozzOLD.h2magie = (float) Math.ceil(200 * hchange);
                            MiniHerozzOLD.h2leben = (float) Math.ceil(4000 * hchange);
                            MiniHerozzOLD.superprefix = "SUPERDRACHE";
                            System.out.println(prefix + ".======================================. ~~~~~~~~~~~~~~           ~~~~~~~ ~  ~     ");
                            System.out.println(prefix + "|   -   -   -   -   -   -   -   -   -  | ~~~~~~~~~~~~~~~~~~~  ~~~~~~~~~~~ ~ ~~  ~     ~");
                            System.out.println(prefix + "|   -  F e u e r   ~~~  D r a c h e  - | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   ~~   ~~   ~ ~~  ~     ~");
                            System.out.println(prefix + "|   -   -   -   -   -   -   -   -   -  | ~~~      ~~~~~~~~~~~~~~~~~~~  ~     ~");
                            System.out.println(prefix + "*======================================* ~            ~~~~~~~~~~~~~  ~~ ~~  ~     ~");
                    }
                    if (hero1 == "eisdrache") {
                            for (int i=0;i<3;i++) {System.out.println(" ~| MÖGE DAS EIS SIE SPALTEN |~ ");}
                            MiniHerozzOLD.spellmax = 2;
                            spell1 = "Angstschrei";
                            spell2 = "Eisfeuer";
                            MiniHerozzOLD.h2change = 1 * hrandom;
                            MiniHerozzOLD.h2angriff = (float) Math.ceil(500 * hchange);
                            MiniHerozzOLD.h2geschick = (float) Math.ceil(35 * hchange);
                            MiniHerozzOLD.h2hirn = (float) Math.ceil(120 * hchange);
                            MiniHerozzOLD.h2magie = (float) Math.ceil(150 * hchange);
                            MiniHerozzOLD.h2leben = (float) Math.ceil(3500 * hchange);
                            MiniHerozzOLD.superprefix = "SUPERDRACHE";
                            System.out.println(prefix + ".======================================. ~~~~~~~~~~~~~~           ~~~~~~~ ~  ~     ");
                            System.out.println(prefix + "|   -   -   -   -   -   -   -   -   -  | ~~~~~~~~~~~~~~~~~~~  ~~~~~~~~~~~ ~ ~~  ~     ~");
                            System.out.println(prefix + "|   -    E i s     ~~~  D r a c h e  - | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   ~~   ~~   ~ ~~  ~     ~");
                            System.out.println(prefix + "|   -   -   -   -   -   -   -   -   -  | ~~~      ~~~~~~~~~~~~~~~~~~~  ~     ~");
                            System.out.println(prefix + "*======================================* ~            ~~~~~~~~~~~~~  ~~ ~~  ~     ~");
                    }
                   
     
                    // Hero gewählt
     
                    // KAMPFWERTE AUSGABE
     
                    if (superprefix == "null") System.out.println(prefix + "###====|| " + hero1 + " ||====###");
                    System.out.println(prefix);
                    System.out.print(prefix + "### - Angriff: "+ MiniHerozzOLD.h2angriff +"         -(=");
                    for (int i=0;i<MiniHerozzOLD.h2angriff;i=i+20) System.out.print("==");
                    System.out.println(">");
                    System.out.println(prefix + "### - Geschick: "+ MiniHerozzOLD.h2geschick +"        >>>");
                    System.out.println(prefix + "### - Hirn: "+ MiniHerozzOLD.h2hirn +"             [#Hirn#]");
                    System.out.print(prefix + "### - Zauberkraft: "+ MiniHerozzOLD.h2magie +"    < ");
                    for (int i=0;i<MiniHerozzOLD.h2magie;i=i+30) System.out.print("~~");
                    System.out.println("~");
                    System.out.print(prefix + "### - Leben: "+ MiniHerozzOLD.h2leben +"          [[<");
                    for (int i=0;i<MiniHerozzOLD.h2leben;i=i+250) System.out.print("33");
                    System.out.println("3]]");
                    System.out.println(prefix);
     
     
     
                    superprefix = "null";
                   
            }
     
     
     
     
     
     
     
            // PREFIX PACK
            public static String prefix = "[MiniHero]";
            public static String prefix1 = "*********************************************";
            public static String prefix2 = "---------------------------------------------";
            public static String prefix3 = ". . . . . . . . . . . . . . . . . . . . . . .";
            public static String prefixleer = "                                          ";
            public static String spieler1 = "David";
            public static String spieler2 = "Manuel";
            public static String spielertmp = "jesus";
            public static String pspieler1 = " [" + spieler1 + "] ";
            public static String pspieler2 = " [" + spieler2 + "] ";
            public static String hero1 = "null";
            public static String hero2 = "null";
            public static String superprefix = "null";
            public static int TODOi=0;
           
           
            // Variabeln pack
            public static double hchange,h2change;
            public static double hangriff,h2angriff;
            public static double hleben,h2leben;
            public static double hgeschick,h2geschick;
            public static double hhirn,h2hirn;
            public static double hmagie,h2magie;
           
            public static double hdmg,h2dmg;
            public static int spellmax, spellmax2,xspell,xspell2;
            public static String spell1,spell2,spell3,spell4,spell5;
            public static double spell1burn,spell2burn,spell3burn,spell4burn,spell5burn;
            public static double hrandom = (double) Math.ceil(3*Math.random())*0.15 + 0.8;
            public static double hrandom2 = (double) Math.ceil(3*Math.random())*0.16 + 0.82;
    }

