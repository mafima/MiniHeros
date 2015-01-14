package HeroPack;

/*
 * 
 *  ->>>>>> SPELL DATABASE <<<<<<<-
 * 
 * creator: Manuel Fischer
 * helped: Alex, ferdl
 */
public class SpellDB {

    public static double spell(Hero held, Hero gegner, String sz) {
        if (held.getClassS() == Classes.GOTT && gegner.getH() < 10) {
            System.out.println("Du glaubst an mich. Daher habe ich schon gewonnen.");
            return 0;
        } else {
            // --- DEFAULT ---
            if (sz.equalsIgnoreCase("normal")) {
                return normal(held, gegner);
            } else if (sz.equalsIgnoreCase("geschickt")) {
                return g(held, gegner);
            } else if (sz.equalsIgnoreCase("intelligent")) {
                return h(held, gegner);
            } else if (sz.equalsIgnoreCase("Zaubertrick")) {
                if (held.getM() <= 0) {
                    System.out.println("*- Keine Zauberkraft ! -*");
                    return normal(held, gegner);
                }
                return m(held, gegner);
            }

            // -- KRIEGER --
            if (sz.equalsIgnoreCase("Ansturm")) {
                return Ansturm(held, gegner);
            } else if (sz.equalsIgnoreCase("Fury")) {
                return Fury(held, gegner);
            } // --- ZOMBIE ---
            else if (sz.equalsIgnoreCase("Zombiebiss")) {
                return Zombiebiss(held, gegner);
            } else if (sz.equalsIgnoreCase("zombieschrei")) {
                return Zombieschrei(held, gegner);
            } else if (sz.equalsIgnoreCase("hirnwurf")) {
                if (held.getH() <= 0) {
                    System.out.println("#ERROR305: DOOFKOPF! Nicht genug HIIIIIRN um es zu werfen!");
                    return normal(held, gegner);
                } else {
                    return hirnwurf(held, gegner);
                }
            } else if (sz.equalsIgnoreCase("zombieschlag")) {
                return zombieschlag(held, gegner);
            } else if (sz.equalsIgnoreCase("Xalor")) {
                return Xalor(held, gegner);
            } else if (sz.equalsIgnoreCase("z")) {
                return 100;
            } else if (sz.equalsIgnoreCase("doppelangriff")) {
                System.out.println("// Doppelter Angriff! //");
                return 0.7 * normal(held, gegner) + 0.7 * normal(held, gegner);
            } else if (sz.equalsIgnoreCase("jesus")) {
                System.out.println("JEEEEEESUS");
                return 1000;
            } else {
                return normal(held, gegner);
            }
        }

    }

    // BASIC
    public static double normal(Hero h, Hero g) {
        if (g.getClassS() == Classes.SHELDON) {
            System.out.println("* Sheldon: Diese Regeln stehen nicht in der Einwohnervereinbahrung! Schaden auf 0 gesetzt! *");
            return 0;
        } else if (g.getClassS() == Classes.GOTT) {
            System.out.println("* GOTT: Niemand zweifelt an Gott. *");
            return 0;
        } else {
            System.out.println("Normaler Angriff! o-(==>");
            if (g.getG() < 0) {
                return h.getA() * (((-1) * g.getG())) * 0.02;
            } else {
                if (g.getG() > 1) {
                    if (chance(g.getG() / (g.getG() + 1000))) {
                        System.out.println(g.getpName() + " ist deinem Angriff geschickt ausgewichen!");
                        return 0;
                    } else {
                        return Math.ceil((1 + h.getG() / (h.getG() + 100)) * (h.getA()) * (1 - g.getG() / (g.getG() + 100)));
                    }
                } else {
                    return Math.ceil((1 - 0.02 * h.getG()) * h.getA());
                }
            }
        }
    }

    public static double g(Hero h, Hero g) {
        if (g.getClassS() == Classes.SHELDON) {
            System.out.println(special + " Sheldon: Diese Regeln stehen nicht in der Einwohnervereinbahrung! Schaden auf 0 gesetzt! " + special);
            return 0;
        } else if (g.getClassS() == Classes.JESUS) {
            System.out.println(special + "* JESUS: Du kannst mich aufh�ngen, mich qu�len, aber ich werde NIIIIIIIEMALS STERBEN!!! " + special);
            return 0;
        } else if (g.getClassS() == Classes.GOTT) {
            System.out.println(special + "* GOTT: Dieser Angriff wird mich nicht erreichen. " + special);
            return 0;
        } else {
            System.out.println(normal + " Geschickter Angriff! ->>> " + normal);
            return Math.ceil((1 + h.getG() / (h.getG() + 333.33)) * h.getA() * (1 - g.getG() / (g.getG() + 333.33)));
        }
    }

    public static double h(Hero h, Hero g) {
        if (g.getClassS() == Classes.SHELDON) {
            System.out.println("* Sheldon: Diese Regeln stehen nicht in der Einwohnervereinbahrung! Schaden auf 0 gesetzt! *");
            return 0;
        } else if (g.getClassS() == Classes.JESUS) {
            System.out.println("* JESUS: NEIIIIN, NICHT DEIN HIRN AN MACHEN!!!! AHHHH *TOT* *");
            return g.getL();
        } else if (g.getClassS() == Classes.GOTT) {
            System.out.println("* GOTT: Zu zweifelst an mir??? *");
            return g.getL();
        } else {
            System.out.println("Intelligenter Angriff! ->>>");
            return Math.ceil(h.getA() * (1 + h.getH() / (h.getH() + 333.33)));
        }
    }

    public static double m(Hero h, Hero g) {
        if (g.getClassS() == Classes.SHELDON) {
            System.out.println("/// PSYSTRAHL ///");
            System.out.println("* Sheldon: Magie gehorscht keinen Physikalischen Gesetzen!!! WIE KANN ES MIR SCHADEN MACHEN!�)3t4? *");
            h.setM(0);
            return h.getM();
        } else if (g.getClassS() == Classes.JESUS) {
            System.out.println("* JESUS: Magie ist gegen mich sinnlos! *");
            return 0;
        } else if (g.getClassS() == Classes.GOTT) {
            System.out.println("* GOTT: Niemand zweifelt an Gott. *");
            return 0;
        } else {
            System.out.println("Magischer Zaubertrick! =( ooo>");

            if (chance(30)) {
                System.out.println("// mieser Zaubertrick -> //");
                System.out.println("~ Dein Held f�hrt einen r�udigen Zaubertrick aus ~");
                System.out.println("Magiekraft sinkt auf " + h.getM() * 0.5);
                h.setM(h.getM() * 0.5);
                return Math.ceil(h.getM() * 0.5);
            } else if (chance(40)) {
                System.out.println("///> Gedankenraub <///");
                System.out.println("~ Du b�ndelst Hirn und Magiekraft um einen Energiestrahl zu erzeugen! ~");
                System.out.println("# " + h.getpName() + " Angriff und Geschick um 10%, Hirn um 30% reduziert");
                double a = 2 * h.getH() * (h.getM() / (h.getM() + 100));
                g.setA(g.getA() * 0.9);
                g.setG(g.getG() * 0.9);
                g.setH(g.getH() * 0.7);
                h.setM(0);
                return a;
            } else {
                System.out.println("///- Schattenfeuer _.xxXX) -///");
                double a = h.getM() * (0.75 + g.getL() + 0.05);
                h.setM(0);
                return a;
            }
        }

    }

    // KRIEGER
    public static double Ansturm(Hero h, Hero g) {
        if (g.getClassS() == Classes.DRACHE || g.getClassS() == Classes.DRACHE) {
            System.out.println("* Gegner fliegt. Worauf willst du st�rmen?! *");
            h.reG(1.5);
            System.out.println("*" + h.getpName() + " ist n�her am Gegner! Geschick steigt auf " + h.getG() + "*");
            return 0;
        } else {
            if (chance(0.5 * h.getG() - g.getG() * 0.1)) {
                System.out.println("/// >>>>>>>>>>>> /// ");
                System.out.println("/// ANSTUUUUUURM /// ");
                System.out.println("Du wirfst " + g.getpName() + " zu Boden! Auf dem Boden liegt Schlamm." + g.getpName() + " ekelt sich!");
                h.reG(1.4);
                g.reG(0.5);
                g.reH(0.8);
                return (100 + h.getM() * 0.5);
            }
            System.out.println("Gegner ist vor Zombiebiss ausgewichen!");
            return 0;

        }
    }

    public static double Fury(Hero h, Hero g) {
        if (g.getClassS() == Classes.DRACHE) {
            System.out.println("* Gegner fliegt. Worauf willst du Fury anwenden?! *");
            h.reG(1.4);
            System.out.println("*" + h.getpName() + " hat sich besser positioniert! Geschick steigt auf " + h.getG() + "*");
            return 0;
        } else if (g.getClassS() == Classes.GNOM) {
            superp("Beim 2. Angriff schl�gt dir der Gnom in die N�sse. " + g.getpName() + "lacht dich aus.");
            h.reG(0.5);
            return normal(h, g) * 1.2;
        } else {
            System.out.println("/// FURY /// ");
            if (chance(h.getG() * 0.5 + (70 * h.getL() / h.getmax()))) {
                System.out.println("/// FURY /// ");
                double schaden = 0;
                if (chance(100 * malor(h.getG(), 300))) {
                    schaden += normal(h, g) * 0.9;
                } else {
                    System.out.println("*** Schneller Angriff: Kritischer Treffer! ***");
                    schaden += h.getA() * 2;
                }
                h.kampf(schaden * 0.1);
                System.out.println("+++ Fury Heilung: " + schaden * 0.1 + "+++");
                return schaden;
            }
            System.out.println("$ Beim 2. Angriff rutschst du aus und f�llst um!" + g.getpName() + "lacht dich aus. $");
            h.reG(0.8);
            return normal(h, g) * 1.2;
        }
    }

    // ZOMBIE
    public static double Zombiebiss(Hero h, Hero g) {
        if (g.getClassS() == Classes.SHELDON) {
            System.out.println("* Hirn zu eklig! *");
            return 5 + h.getA() * 0.01;
        } else {
            if (chance(100 * h.getL() / (h.getmax() + g.getG()))) {
                System.out.println("/// ZOMBIEBISS /// ");
                System.out.println("100  Hirnmasse verspeist!!!");
                g.setH(g.getH() - 100);
                h.setH(h.getH() + 100);
                if (g.getH() <= 0) {
                    System.out.println("*** " + (0.5 * h.getM() + 300 - g.getH() * 0.8) + " Schaden durch Zombievirus! ***");
                    return (0.5 * h.getM() + 300 - g.getH() * 0.8);
                }
                return (200 + h.getM() * 0.5);
            }
            System.out.println("Gegner ist vor Zombiebiss ausgewichen!");
            return 0;

        }
    }

    public static double Zombieschrei(Hero h, Hero g) {
        if (g.getClassS() == Classes.SHELDON) {
            System.out.println("* Sheldon schreit auch!!! Zombieschrei wird neutralisiert! *");
            return 0;
        }
        if (g.getClassS() == Classes.ZOMBIE) {
            System.out.println("* Geht nicht, wenn Gegner ein Zombie ist! *");
            System.out.println("Normaler Angriff!");
            return normal(h, g);
        } else {
            int r = (int) Math.ceil(Math.random() * 3);
            if (r > 0) {
                r++;
                System.out.println("Zombieschrei war so laut, dass " + r + " Zombies nun mit dir k�mpfen!");
                System.out.print(" Angriff steigt von " + h.getA() + " auf " + h.getA() * r + " !");
                System.out.print(" Geschick steigt von " + h.getG() + " auf " + h.getG() * r + " !");
                System.out.println("Magie steigt von " + h.getM() + " auf " + h.getM() * r + " !");
                h.setA(h.getA() * r);
                h.setG(h.getG() * r);
                h.setM(h.getM() * r);

                System.out.println("Angst verursacht! Gegner hat 20% weniger Angriff und Geschick");
                g.setA(g.getA() * 0.8);
                g.setG(g.getG() * 0.8);
                return 0;
            }
            System.out.println("Angst verursacht! Gegner hat 40% weniger Angriff und Geschick");
            g.setA(g.getA() * 0.6);
            g.setG(g.getG() * 0.6);
            return 0;
        }
    }

    public static double hirnwurf(Hero h, Hero g) {
        if (g.getClassS() == Classes.SHELDON) {
            System.out.println(special + "* SHELDON kommt mit HIRNMASSE in Kontakt. Er explodiert. " + special);
            return g.getL();
        } else {
            System.out.println("/// HIRNWURF /// ");
            System.out.println("Du wirfst 70% deiner Hirnmasse auf den Gegner!");
            double hirn = h.getH() * 0.7;
            h.setH(h.getH() * 0.3);
            if (chance(100 * malor(h.getH(), 10))) {
                return (hirn * 2);
            }
            System.out.println("Du hast den Gegner nicht mit deinem Hirn getroffen!");
            return 0;

        }
    }

    public static double zombieschlag(Hero h, Hero g) {
        if (g.getClassS() == Classes.SHELDON) {
            System.out.println("* Zombieschlag t�tet Sheldon! *");
            return g.getL();
        } else {
            System.out.println("// Zombieschlag //");
            return h.getA() * 0.5 + h.getG() * 0.1 + h.getH() * 0.1 + h.getM() * 0.1;

        }
    }

    public static double LAZOR(Hero h, Hero g) {
        if (g.getClassS() == Classes.SHELDON) {
            System.out.println("* LAZZZ0000RRR BEAAAAAM !!!! Sheldons Hirn wird pulverisiert. *");
            return g.getL();
        } else if (g.getClassS() == Classes.DRACHE) {
            System.out.println("* LAZ0000R BEEAAM !!! trifft die Fl�gel des Drachen. Er f�llt zu Boden! *");
            g.ausre("a", 0.2);
            g.ausre("a", 0.2);
            return 50 + g.getL() * 0.4;
        } else if (g.getClassS() == Classes.GNOM) {
            System.out.println("* Zombieschlag t�tet Sheldon! *");
            return g.getL();
        } else if (g.getClassS() == Classes.ZWERG) {
            System.out.println("* Zombieschlag t�tet Sheldon! *");
            return g.getL();
        } else if (g.getClassS() == Classes.ORK) {
            System.out.println("* Zombieschlag t�tet Sheldon! *");
            return g.getL();
        } else {
            System.out.println("// Zombieschlag //");
            return h.getA() * 0.5 + h.getG() * 0.1 + h.getH() * 0.1 + h.getM() * 0.1;

        }
    }

    public static double Xalor(Hero h, Hero g) {
        if (g.getClassS() == Classes.SHELDON) {
            System.out.println("* Xalor geht nicht gegen Sheldon! *");
            return 0;
        } else {
            p("// ----Xalor---- //");
            if (h.getA() <= 0) {
                h.setA(-h.getA());
            } else if (h.getA() > 1000) {
                h.setA(Math.random() * 1000);
            }
            return 0;

        }
    }

	// BACKUP castspell
	/* 	public static void castspell (Hero held, Hero gegner, Spellz spell) {
     if (spell == Spellz.NORMAL) {
     normal(held,gegner);
     } else {
     castspell(held,gegner,Spellz.NORMAL);
     }
     }
	

     * 
     */
    // SUPERFUNKTIONEN
    public static double malor(double grundzahl, double changezahl) {
        return grundzahl / (grundzahl + changezahl);
    }

    public static boolean chance(double prozent) {
        return prozent > 100 || Math.ceil(Math.random() * (100 / prozent)) == 1;
    }

    public static String special = ":*:";
    public static String normal = "--";

    public static void p(String text) {
        System.out.println(text);
    }

    public static void superp(String text) {
        System.out.println("$$$ " + text + " $$$");
    }
}
