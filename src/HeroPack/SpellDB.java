package HeroPack;

/*
 * 
 *  ->>>>>> SPELL DATABASE <<<<<<<-
 * 
 * Ersteller: Manuel Fischer
 * Helfer: Alex, ferdl
 * 
 * Thema: Wandelt spellname in damage um.
 * Genutzt in: MiniHeros.java in dmg funktion.
 */
public class SpellDB {

    public static double spell(Hero held, Hero gegner, String spell) {
        if (gegner.getClassS() == Classes.GOTT && held.getH() < 30) {
            System.out.println("Du glaubst an mich. Niemand zweifelt an mir. NIIIIEMAND!");
            double schaden = held.getH();
            held.reH(10);
            return schaden;
        } else {

			// LIST: DEFAULT, KRIEGER, MAGIER, ELF, ORK, GNOM, ZWERG, ZOMBIE, DRACHE, EISDRACHE,
            // --- DEFAULT ---
            if (spell.equalsIgnoreCase("normal")) {
                return normal(held, gegner);
            } else if (spell.equalsIgnoreCase("geschickt")) {
                return g(held, gegner);
            } else if (spell.equalsIgnoreCase("intelligent")) {
                return h(held, gegner);
            } else if (spell.equalsIgnoreCase("Zaubertrick")) {
                if (held.getM() <= 0) {
                    System.out.println("*- Keine Zauberkraft ! -*");
                    return normal(held, gegner);
                } else {
                    return m(held, gegner);
                }
            } // -- KRIEGER --
            else if (spell.equalsIgnoreCase("Ansturm")) {
                return Ansturm(held, gegner);
            } else if (spell.equalsIgnoreCase("Fury")) {
                return Fury(held, gegner);
            } // - MAGIER
            else if (spell.equalsIgnoreCase("LAZOR")) {
                if (held.getM() <= 0) {
                    System.out.println("*- Keine Zauberkraft ! -*");
                    return normal(held, gegner);
                } else {
                    return LAZOR(held, gegner);
                }
            } else if (spell.equalsIgnoreCase("hurricane")) {
                if (held.getM() <= 0) {
                    System.out.println("*- Keine Zauberkraft ! -*");
                    return normal(held, gegner);
                } else {
                    return hurricane(held, gegner);
                }
            } else if (spell.equalsIgnoreCase("spellbook")) {
                return spellbook(held, gegner);
            } // -- ELF --
            else if (spell.equalsIgnoreCase("Ansturm")) {
                return Ansturm(held, gegner);
            } else if (spell.equalsIgnoreCase("Fury")) {
                return Fury(held, gegner);
            } else if (spell.equalsIgnoreCase("Fury")) {
                return Fury(held, gegner);
            } // -- ORK --
            else if (spell.equalsIgnoreCase("Ansturm")) {
                return Ansturm(held, gegner);
            } else if (spell.equalsIgnoreCase("Fury")) {
                return Fury(held, gegner);
            } else if (spell.equalsIgnoreCase("Fury")) {
                return Fury(held, gegner);
            } // -- GNOM --
            else if (spell.equalsIgnoreCase("Ansturm")) {
                return Ansturm(held, gegner);
            } else if (spell.equalsIgnoreCase("Fury")) {
                return Fury(held, gegner);
            } else if (spell.equalsIgnoreCase("Fury")) {
                return Fury(held, gegner);
            } // -- ZWERG --
            else if (spell.equalsIgnoreCase("Ansturm")) {
                return Ansturm(held, gegner);
            } else if (spell.equalsIgnoreCase("Fury")) {
                return Fury(held, gegner);
            } else if (spell.equalsIgnoreCase("Fury")) {
                return Fury(held, gegner);
            } // --- ZOMBIE ---
            else if (spell.equalsIgnoreCase("Zombiebiss")) {
                return Zombiebiss(held, gegner);
            } else if (spell.equalsIgnoreCase("zombieschrei")) {
                return Zombieschrei(held, gegner);
            } else if (spell.equalsIgnoreCase("hirnwurf")) {
                if (held.getH() <= 0) {
                    System.out.println("#ERROR305: DOOFKOPF! Nicht genug HIIIIIRN um es zu werfen!");
                    return normal(held, gegner);
                } else {
                    return hirnwurf(held, gegner);
                }
            } else if (spell.equalsIgnoreCase("zombieschlag")) {
                return zombieschlag(held, gegner);
            } // -- DRACHE --
            else if (spell.equalsIgnoreCase("Drachenschrei")) {
                return Drache1(held, gegner);
            } else if (spell.equalsIgnoreCase("Feuerbombe")) {
                return Drache2(held, gegner);
            } else if (spell.equalsIgnoreCase("Feuerspei")) {
                return Drache3(held, gegner);
            } else if (spell.equalsIgnoreCase("Drachenbiss des Todes")) {
                if (held.getM() > 0) {
                    return Drache4(held, gegner);
                }
                System.out.println("*- Deine Drachenkraft ist schon verbraucht! -*");
                return normal(held, gegner);
            } // -- EISDRACHE --
            else if (spell.equalsIgnoreCase("Ansturm")) {
                return Ansturm(held, gegner);
            } else if (spell.equalsIgnoreCase("Fury")) {
                return Fury(held, gegner);
            } else if (spell.equalsIgnoreCase("Fury")) {
                return Fury(held, gegner);
            } // ANDERE
            else if (spell.equalsIgnoreCase("Xalor")) {
                return Xalor(held, gegner);
            } else if (spell.equalsIgnoreCase("z")) {
                return 100;
            } else if (spell.equalsIgnoreCase("doppelangriff")) {
                System.out.println("// Doppelter Angriff! //");
                return 0.7 * normal(held, gegner) + 0.7 * normal(held, gegner);
            } else if (spell.equalsIgnoreCase("jesus")) {
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
            System.out.println(special + "* JESUS: Du kannst mich aufhaengen, mich quaelen, aber ich werde NIIIIIIIEMALS STERBEN!!! " + special);
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
            return Math.ceil(0.25 * h.getH() + h.getA() * (1 + h.getH() / (h.getH() + 333.33)));
        }
    }

    public static double m(Hero h, Hero g) {
        if (g.getClassS() == Classes.SHELDON) {
            System.out.println("/// PSYSTRAHL ///");
            System.out.println("* Sheldon: Magie gehorscht keinen Physikalischen Gesetzen!!! WIE KANN ES MIR SCHADEN MACHEN! AHHH *");
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
                System.out.println("~ Dein Held fuehrt einen raeudigen Zaubertrick aus ~");
                System.out.println("Magiekraft sinkt auf " + h.getM() * 0.5);
                h.setM(h.getM() * 0.5);
                return Math.ceil(h.getM() * 0.5);
            } else if (chance(40)) {
                System.out.println("///> Gedankenraub <///");
                System.out.println("~ Du buendelst Hirn und Magiekraft um einen Energiestrahl zu erzeugen! ~");
                System.out.println("# " + h.getpName() + " Angriff und Geschick um 10%, Hirn um 30% reduziert.");
                double a = 2 * h.getH() * (h.getM() / (h.getM() + 100));
                g.setA(g.getA() * 0.9);
                g.setG(g.getG() * 0.9);
                g.setH(g.getH() * 0.7);
                h.setM(0);
                return a;
            } else {
                System.out.println("///- Schattenfeuer _.xxXX) -///");
                double a = h.getM() * (0.75 + g.getL() * 0.05);
                h.setM(0);
                return a;
            }
        }

    }

    // KRIEGER
    public static double Ansturm(Hero h, Hero g) {
        if (g.getClassS() == Classes.DRACHE || g.getClassS() == Classes.DRACHE) {
            System.out.println("* Gegner fliegt. Worauf willst du stuermen?! *");
            h.reG(1.5);
            System.out.println("*" + h.getpName() + " ist naeher am Gegner! Geschick steigt auf " + h.getG() + "*");
            return 0;
        } else {
            if (chance(1.5 * h.getG())) {
                System.out.println("/// >>>>>>>>>>>> /// ");
                System.out.println("/// ANSTUUUUUURM /// ");
                System.out.println("Du wirfst " + g.getpName() + " zu Boden! Auf dem Boden liegt Schlamm." + g.getpName() + " ekelt sich!");
                h.reG(1.4);
                g.reG(0.5);
                g.reH(0.8);
                return (100 + h.getM() * 0.5);
            }
            System.out.println("Gegner ist vor Ansturm ausgewichen!!");
            return 0;

        }
    }

    public static double Fury(Hero h, Hero g) {
        System.out.println("/// FURY /// ");
        if (g.getClassS() == Classes.DRACHE) {
            System.out.println("* Gegner fliegt. Worauf willst du Fury anwenden?! *");
            h.reG(1.4);
            System.out.println("*" + h.getpName() + " hat sich besser positioniert! Geschick steigt auf " + h.getG() + "*");
            return 0;
        } else if (g.getClassS() == Classes.GNOM) {
            superp("Beim 2. Angriff schlaegt dir der Gnom in die Nuesse. " + g.getpName() + "lacht dich aus.");
            h.reG(0.5);
            return normal(h, g) * 1.2;
        } else {
            if (chance(h.getG() * 0.5 + (70 * h.getL() / h.getmax()))) {
                double schaden = 0;
                if (chance(100 * malor(h.getG(), 300))) {
                    schaden += normal(h, g) * 0.9;
                } else {
                    System.out.println("*** Schneller Angriff: Kritischer Treffer! ***");
                    schaden += Math.ceil(h.getA() * 2);
                }
                h.kampf(schaden * 0.1);
                System.out.println("+++ Fury Heilung: " + schaden * 0.1 + " +++");
                return schaden;
            }
            System.out.println("$ Beim 2. Angriff rutschst du aus und faellst um!" + g.getpName() + "lacht dich aus. $");
            h.reG(0.8);
            return normal(h, g) * 1.2;
        }
    }

    // MAGIER
    public static double LAZOR(Hero h, Hero g) {
        System.err.println("|o/ <============  /o/  LAzzz00RBEAAAAAM !!!!!");
        if (g.getClassS() == Classes.SHELDON) {
            System.err.println("* LAZZZ0000RRR BEAAAAAM !!!! Sheldons Hirn wird pulverisiert. *");
            return g.getL();
        } else if (g.getClassS() == Classes.DRACHE) {
            System.err.println("* LAZ0000R BEEAAM !!! trifft die Fluegel des Drachen. Er faellt zu Boden! *");
            g.reA(0.2);
            g.reG(0.2);
            return 50 + g.getL() * 0.4;
        } else if (g.getClassS() == Classes.GNOM) {
            System.err.println("* LAZ00000RBEAM DES TODES !!! ... trifft einen Baum. Der Gnom hat einen Ablenkungszauber genutzt! *");
            return 0;
        } else if (g.getClassS() == Classes.ZWERG) {
            System.err.println("* LAZ00000RBEAM DES TODES !!! ... trifft den Zwerg! Ein zischen ist zu hoeren. Es scheint ihm nicht sehr zu schaden. *");
            return 10 + g.getL() * (malor(h.getM(), 1000));
        } else if (g.getClassS() == Classes.ORK) {
            System.err.println("* LAZ000R BEAAAM zerreist die Haut des Orks! Der Ork schreit grausam wegen den Schmerzen. Aus Mitleid hoerst du nach 4 Sekunden auf. *");
            return 0.75 * g.getL() / g.getres();
        } else {
            return 50 + 0.6 * h.getM() + g.getL() * 0.15;
        }
    }

    public static double hurricane(Hero h, Hero g) {
        System.out.println("/// HURRICAAAAANE ///");
        double schaden = 0;
        if (g.getClassS() == Classes.SHELDON) {
            System.out.println("* WUUUUSCH STUUUUURM WAAAH !!!! Sheldon stirbt *");
            schaden = g.getL();
        } else if (g.getClassS() == Classes.DRACHE) {
            System.out.println("*  WUUUUSCH STUUUUURM WAAAH !!! Der Drache faellt zu Boden! *");
            g.reA(0.4);
            g.reG(0.4);
            schaden = 50 + g.getL() * 0.3;
        } else if (g.getClassS() == Classes.GNOM) {
            System.out.println("*  WUUUUSCH STUUUUURM WAAAH !!! Hurricane hat bei einem Gnom keine Wirkung *");
            schaden = 0;
        } else if (g.getClassS() == Classes.ZWERG) {
            System.out.println("*  WUUUUSCH STUUUUURM WAAAH !!! Es scheint ihm nicht sehr zu schaden. *");
            schaden = 10 + g.getL() * (0.01 + malor(h.getM(), 500));
        } else if (g.getClassS() == Classes.ORK) {
            System.out.println("*  WUUUUSCH STUUUUURM WAAAH !!! Hurricane wirft den Ork zu Himmel! *");
            schaden = 0.45 * g.getL() / g.getres();
        } else {
            schaden = h.getA() * 0.5 + h.getG() * 0.1 + h.getH() * 0.1 + h.getM() * 0.1;
        }
        if (schaden > 0) {
            h.setM(0); // setzt Magiekraft auf 0 falls schaden groesser als 0
        }
        if (h.getM() <= 0) {
            return schaden * 0.1;
        }
        return schaden;
    }

    public static double spellbook(Hero h, Hero g) {
        h.reM(1.4);
        System.out.println("// Zauberbuch - Du lernst neue Zaubersprueche. Deine Zauberkraft steigt auf: " + h.getM());
        return 0;
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
                System.out.println("Zombieschrei war so laut, dass " + r + " Zombies nun mit dir kaempfen!");
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
            System.out.println("* Zombieschlag toetet Sheldon! *");
            return g.getL();
        } else {
            System.out.println("// Zombieschlag //");
            return h.getA() * 0.5 + h.getG() * 0.1 + h.getH() * 0.1 + h.getM() * 0.1;

        }
    }

    // DRACHE - "Drachenschrei", "Feuerbombe", "Feueratem", "Drachenbiss des Todes"
    public static double Drache1(Hero h, Hero g) {
        if (g.getClassS() == Classes.SHELDON) {
            System.out.println("* Drachenschrei toetet Sheldon*");
            return g.getL();
        } else {
            System.out.println("// Drachenschrei //");
            g.reG(0.6);
            h.reG(1.3);
            h.reR(1.1);
            h.reM(1.2);
            return 5 + h.getM() * 0.05;
        }
    }

    public static double Drache2(Hero h, Hero g) {
        if (g.getClassS() == Classes.SHELDON) {
            System.out.println("* Feuerbombe toetet Sheldon*");
            return g.getL();
        } else {
            System.out.println("// Feuerbombe //");
            if (chance(100 - g.getG())) {
                System.out.println(">>> Feuerbombe trifft! <<<");
                return h.getM() * 0.35;
            }
            System.out.println("> Feuerbombe zerreist einen Baum");
            g.reG(0.95);
            return 0;
        }
    }

    public static double Drache3(Hero h, Hero g) {
        if (g.getClassS() == Classes.SHELDON) {
            System.out.println("* Feuerspei toetet Sheldon *");
            return g.getL();
        } else {
            System.out.println("// Feuerspei //");
            System.out.println("Du speist einen riesigen Feuerstrahl!");
            h.reM(0.75);
            return 30 + h.getM() * 0.5 + h.getA() * 0.1;
        }
    }

    public static double Drache4(Hero h, Hero g) {
        if (g.getClassS() == Classes.SHELDON) {
            System.out.println("* Drachenbiss toetet Sheldon*");
            return g.getL();
        } else {
            System.out.println("// Drachenbiss //");
            System.out.println("Du stuerzt dich auf den Gegner und beisst den Kopf von" + h.getpName() + "ab!");
            double dmg = h.getM() * (1 - (g.getmax() - g.getL()) / g.getmax());
            h.reM(0);
            return dmg;
        }
    }

    // ZAUBER ERSTELLEN KONSTRUKTOR
    public static double ZAUBERNAME(Hero h, Hero g) {
        if (g.getClassS() == Classes.SHELDON) {
            System.out.println("* // dieser zauber toetet Sheldon! *");
            return g.getL();
        } else {
            System.out.println("// DEIN ZAUBERNAME //");
            return h.getA() + 30;

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

    public static void r(String text) {
        System.err.println(text);
    }

    public static void superp(String text) {
        System.out.println("$$$ " + text + " $$$");
    }
}
