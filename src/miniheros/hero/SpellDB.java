package miniheros.hero;

import main.MiniHeros;
import miniheros.util.help;

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
			p("Du glaubst an mich. Niemand zweifelt an mir. NIIIIEMAND!");
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
					p("*- Keine Zauberkraft ! -*");
					return normal(held, gegner);
				} else return m(held, gegner);
			}

			// -- KRIEGER --
			else if (spell.equalsIgnoreCase("Ansturm")) {
				return Ansturm(held, gegner);
			} else if (spell.equalsIgnoreCase("Fury")) {
				return Fury(held, gegner);
			}

			// - MAGIER
			else if (spell.equalsIgnoreCase("LAZOR")) {
				if (held.getM() <= 0) {
					p("*- Keine Zauberkraft ! -*");
					return normal(held, gegner);
				} else return LAZOR(held, gegner);
			} else if (spell.equalsIgnoreCase("hurricane")) {
				if (held.getM() <= 0) {
					p("*- Keine Zauberkraft ! -*");
					return normal(held, gegner);
				} else return Wirbelsturm(held,gegner);
			} else if (spell.equalsIgnoreCase("spellbook")) {
				return Zauberbuch(held, gegner);
			}


			// -- ELF --
			else if (spell.equalsIgnoreCase("Ansturm")) {
				return Ansturm(held, gegner);
			} else if (spell.equalsIgnoreCase("Fury")) {
				return Fury(held, gegner);
			} else if (spell.equalsIgnoreCase("Fury")) {
				return Fury(held, gegner);
			}

			// -- ORK --
			else if (spell.equalsIgnoreCase("Ansturm")) {
				return Ansturm(held, gegner);
			} else if (spell.equalsIgnoreCase("Fury")) {
				return Fury(held, gegner);
			} else if (spell.equalsIgnoreCase("Fury")) {
				return Fury(held, gegner);
			}

			// -- GNOM --
			else if (spell.equalsIgnoreCase("Ansturm")) {
				return Ansturm(held, gegner);
			} else if (spell.equalsIgnoreCase("Fury")) {
				return Fury(held, gegner);
			} else if (spell.equalsIgnoreCase("Fury")) {
				return Fury(held, gegner);
			}

			// -- ZWERG --
			else if (spell.equalsIgnoreCase("Ansturm")) {
				return Ansturm(held, gegner);
			} else if (spell.equalsIgnoreCase("Fury")) {
				return Fury(held, gegner);
			} else if (spell.equalsIgnoreCase("Fury")) {
				return Fury(held, gegner);
			}





			// --- ZOMBIE ---
			else if (spell.equalsIgnoreCase("Zombiebiss")) {
				if (held.getM() <= 0) {
					p("*- Keine Zauberkraft ! -*");
					return zombieschlag(held, gegner);
				} else return Zombiebiss(held, gegner);
			} else if (spell.equalsIgnoreCase("zombieschrei")) {
				return Zombieschrei(held, gegner);
			} else if (spell.equalsIgnoreCase("hirnwurf")) {
				if (held.getH() <= 0) {
					p("#ERROR305: DOOFKOPF! Nicht genug HIIIIIRN um es zu werfen!");
					return normal(held, gegner);
				} else {
					return hirnwurf(held, gegner);
				}
			} else if (spell.equalsIgnoreCase("zombieschlag")) {
				return zombieschlag(held, gegner);
			}

			// -- DRACHE --
			else if (spell.equalsIgnoreCase("Drachenschrei")) {
				return Drache1(held, gegner);
			} else if (spell.equalsIgnoreCase("Feuerbombe")) {
				return Drache2(held, gegner);
			} else if (spell.equalsIgnoreCase("Feuerspei")) {
				return Drache3(held, gegner);
			} else if (spell.equalsIgnoreCase("Drachenbiss des Todes")) {
				if (held.getM()>0) return Drache4(held, gegner);
				p("*- Deine Drachenkraft ist schon verbraucht! -*");
				return normal(held,gegner);
			}

			// -- EISDRACHE --
			else if (spell.equalsIgnoreCase("Eissplitter")) {
				return Eisdrache2(held, gegner);
			} else if (spell.equalsIgnoreCase("Eisatem")) {
				return Eisdrache3(held, gegner);
			}
			// -- NEINHEIT --
			 else if (spell.equalsIgnoreCase("NEIN")) {
					return neinheit1(held, gegner);
				} else if (spell.equalsIgnoreCase("ICHSAGENEIN")) {
					return neinheit2(held, gegner);
				} else if (spell.equalsIgnoreCase("EHHHNEIN")) {
					return neinheit3(held, gegner);
				} else if (spell.equalsIgnoreCase("NEINNEINNEIN")) {
					if (held.getM()>0) return neinheit4(held, gegner);
					p("*- Deine NEINKRAFT ist schon verbraucht! -*");
					return 0;
				}
			// -- JAHEIT --
			 else if (spell.equalsIgnoreCase("JA")) {
					return jaheit1(held, gegner);
				} else if (spell.equalsIgnoreCase("ICH SAGE IMMER JA")) {
					return jaheit2(held, gegner);
				} else if (spell.equalsIgnoreCase("JA KLAR")) {
					return jaheit3(held, gegner);
				} else if (spell.equalsIgnoreCase("JA natuuurlich!")) {
					if (held.getM()>0) return jaheit4(held, gegner);
					p("*- Deine JAKRAFT ist schon verbraucht! -*");
					return 0;
				}
			
			
			
			// ANDERE
			else if (spell.equalsIgnoreCase("Xalor")) {
				return Xalor(held, gegner);
			} else if (spell.equalsIgnoreCase("z")) {
				return 100;
			} else if (spell.equalsIgnoreCase("doppelangriff")) {
				p("// Doppelter Angriff! //");
				return 0.7 * normal(held, gegner) + 0.7 * normal(held, gegner);
			} else if (spell.equalsIgnoreCase("jesus")) {
				p("JEEEEEESUS");
				return 1000;
			} else {
				return normal(held, gegner);
			}
		}

	}

	// BASIC
	public static double normal(Hero h, Hero g) {
		int schaden=0;
		if (g.getClassS() == Classes.SHELDON) {
			p("* Sheldon: Diese Regeln stehen nicht in der Einwohnervereinbahrung! Schaden auf 0 gesetzt! *");
		} else if (g.getClassS() == Classes.GOTT) {
			p("* GOTT: Niemand zweifelt an Gott. *");
		} else {
			p("Normaler Angriff! o-(==>");
			if (g.getG() < 0) {
				return h.getA() * (((-1) * g.getG())) * 0.02;
			} else {
				if (g.getG() > 0) {
					if (chance(g.getG() / (g.getG() + 500))) {
						p(g.getpName() + " ist deinem Angriff geschickt ausgewichen!");
					} else {
						schaden = (int) Math.ceil((1 + h.getG() / (h.getG() + 100)) * (h.getA()) * (1 - g.getG() / (g.getG() + 100)));
					}
				} else {
					schaden = (int) Math.ceil(h.getA()+(g.getG()*g.getG()));
				}
			}
		}
		if (g.getClassS() == Classes.DRACHE||g.getClassS() == Classes.EISDRACHE) schaden*=0.4;
		return schaden;
	}

	public static double g(Hero h, Hero g) {
		int schaden=0;
		if (g.getClassS() == Classes.SHELDON) {
			p(special + " Sheldon: Diese Regeln stehen nicht in der Einwohnervereinbahrung! Schaden auf 0 gesetzt! " + special);
		} else if (g.getClassS() == Classes.JESUS) {
			p(special + "* JESUS: Du kannst mich aufhaengen, mich quaelen, aber ich werde NIIIIIIIEMALS STERBEN!!! " + special);
		} else if (g.getClassS() == Classes.GOTT) {
			p(special + "* GOTT: Dieser Angriff wird mich nicht erreichen. " + special);
		} else {
			p(normal + " Geschickter Angriff! ->>> " + normal);
			schaden=(int) Math.ceil((1 + h.getG() / (h.getG() + 333.33)) * h.getA() * (1 - g.getG() / (g.getG() + 333.33)));
		}

		if (g.getClassS() == Classes.DRACHE||g.getClassS() == Classes.EISDRACHE) schaden*=0.4;
		return schaden;
	}

	public static double h(Hero h, Hero g) {
		int schaden = 0;
		if (g.getClassS() == Classes.SHELDON) {
			p("* Sheldon: Diese Regeln stehen nicht in der Einwohnervereinbahrung! Schaden auf 0 gesetzt! *");
		} else if (g.getClassS() == Classes.JESUS) {
			help.p("* JESUS: NEIIIIN, NICHT DEIN HIRN AN MACHEN!!!! AHHHH *TOT* *");
			schaden=(int) g.getL();
		} else if (g.getClassS() == Classes.GOTT) {
			help.p("* GOTT: Zu zweifelst an mir??? *");
			schaden=(int) g.getL();
		} else {
			help.p("Intelligenter Angriff! ->>>");
			schaden = (int) Math.ceil(0.25*h.getH()+h.getA() * (1 + h.getH() / (h.getH() + 333.33)));
		}
		if (g.getClassS() == Classes.DRACHE||g.getClassS() == Classes.EISDRACHE) schaden*=0.4;
		return schaden;
	}

	public static double m(Hero h, Hero g) {
		int schaden = 0;
		if (g.getClassS() == Classes.SHELDON) {
			help.p("/// PSYSTRAHL ///");
			help.p("* Sheldon: Magie gehorscht keinen Physikalischen Gesetzen!!! WIE KANN ES MIR SCHADEN MACHEN! AHHH *");
			h.setM(0);
			schaden = (int) h.getM();
		} else if (g.getClassS() == Classes.JESUS) {
			help.p("* JESUS: Magie ist gegen mich sinnlos! *");
		} else if (g.getClassS() == Classes.GOTT) {
			help.p("* GOTT: Niemand zweifelt an Gott. *");
		} else {
			help.p("Magischer Zaubertrick! =( ooo>");
			if (chance(30)) {
				help.p("// mieser Zaubertrick -> //");
				help.p("~ Dein Held fuehrt einen raeudigen Zaubertrick aus ~");
				help.p("Magiekraft sinkt auf " + h.getM() * 0.5);
				h.setM(h.getM() * 0.5);
				schaden = (int) Math.ceil(h.getM() * 0.5);
			} else if (chance(40)) {
				help.p("///> Gedankenraub <///");
				help.p("~ Du buendelst Hirn und Magiekraft um einen Energiestrahl zu erzeugen! ~");
				help.p("# " + h.getpName() + " Angriff und Geschick um 10%, Hirn um 30% reduziert.");
				double a = 2 * h.getH() * (h.getM() / (h.getM() + 100));
				g.setA(g.getA() * 0.9);
				g.setG(g.getG() * 0.9);
				g.setH(g.getH() * 0.7);
				h.setM(0);
				schaden = (int) a;
			} else {
				help.p("///- Schattenfeuer _.xxXX) -///");
				double a = 0.4*h.getM() + (g.getL() * 0.05);
				h.setM(0);
				schaden = (int) a;
			}
		}
		return schaden;
	}

	// KRIEGER
	public static double Ansturm(Hero h, Hero g) {
		int schaden = 0;
		if (g.getClassS() == Classes.DRACHE || g.getClassS() == Classes.EISDRACHE) {
			help.p("* Das ist ein Drache, der hoch im Himmel fliegt. Worauf willst du stuermen?! *");
			h.reG(1.5);
			help.p("*" + h.getpName() + " ist naeher am Gegner! Geschick steigt auf " + h.getG() + "*");
		} else {
			if (chance(1.5 * h.getG())) {
				help.p("/// >>>>>>>>>>>> /// ");
				help.p("/// ANSTUUUUUURM /// ");
				help.p("Du wirfst " + g.getpName() + " zu Boden! Auf dem Boden liegt Schlamm." + g.getpName() + " ekelt sich!");
				h.reG(1.4);
				g.reG(0.5);
				g.reH(0.8);
				schaden = (int) Math.ceil(100 + h.getM() * 0.5);
			}
			help.p("Gegner ist vor Ansturm ausgewichen!!");
		}
		return schaden;
	}

	public static double Fury(Hero h, Hero g) {
		help.p("/// FURY /// ");
		if (g.getClassS() == Classes.DRACHE) {
			help.p("* Gegner fliegt. Worauf willst du Fury anwenden?! *");
			h.reG(1.4);
			help.p("*" + h.getpName() + " hat sich besser positioniert! Geschick steigt auf " + h.getG() + "*");
			return 0;
		} else if (g.getClassS() == Classes.GNOM) {
			superp("Beim 2. Angriff schlaegt dir der Gnom in die Nuesse. " + g.getpName() + "lacht dich aus.");
			h.reG(0.5);
			return normal(h, g) * 1.2;
		} else {
			if (chance(h.getG() * 0.8 - (20 * h.getL() / h.getmax()))) {
				double schaden = 0;
				int m= 3;
				for (int i = 0; i < m; i++) {
					if (chance(100 * malor(h.getG(), 300))) {
						schaden += normal(h, g) * 0.9;
					} else {
						help.p("*** o-(==> Kritischer Treffer! ***");
						schaden += Math.ceil(h.getA() * 2);
					}
				}
				h.kampf(schaden * 0.1);
				help.p("+++ Fury Heilung: " + schaden * 0.1 + " +++");
				return schaden;
			}
			help.p("$ Beim 2. Angriff rutschst du aus und faellst um!" + g.getpName() + "lacht dich aus. $");
			h.reG(0.8);
			return normal(h, g) * 1.2;
		}
	}


	// MAGIER
	public static double LAZOR(Hero h, Hero g) {
		r("|o/ <============  /o/  LAzzz00RBEAAAAAM !!!!!");
		if (g.getClassS() == Classes.SHELDON ) {
			r("* LAZZZ0000RRR BEAAAAAM !!!! Sheldons Hirn wird pulverisiert. *");
			return g.getL();
		} else if (g.getClassS() == Classes.DRACHE ) {
			r("* Fluegel des Drachen getroffen!!! Er faellt heftig zu Boden! *");
			g.reA(0.2); g.reG(0.2);
			return 50+g.getL()*0.4;
		} else if (g.getClassS() == Classes.GNOM ) {
			System.err.println("* LAZ00000RBEAM DES TODES !!! ... trifft einen Baum. Der Gnom hat einen Ablenkungszauber genutzt! *");
			return 0;
		} else if (g.getClassS() == Classes.ZWERG ) {
			System.err.println("* LAZ00000RBEAM DES TODES !!! ... trifft den Zwerg! Ein zischen ist zu hoeren. Es scheint ihm nicht sehr zu schaden. *");
			return 10+g.getL()*(malor(h.getM(),1000));
		} else if (g.getClassS() == Classes.ORK ) {
			System.err.println("* LAZ000R BEAAAM zerreist die Haut des Orks! Der Ork schreit grausam wegen den Schmerzen. Aus Mitleid hoerst du nach 4 Sekunden auf. *");
			return 0.75*g.getL()/g.getres();
		} else {
			return 100+0.6*h.getM()+g.getL()*0.15;
		}
	}
	public static double Wirbelsturm(Hero h, Hero g) {
		help.p("/// WIRBELSTURM ///");
		double schaden=0;
		if (g.getClassS() == Classes.SHELDON ) {
			help.p("* WUUUUSCH STUUUUURM WAAAH !!!! Sheldon stirbt *");
			schaden=g.getL();
		} else if (g.getClassS() == Classes.DRACHE ) {
			help.p("*  WUUUUSCH STUUUUURM WAAAH !!! Der Drache faellt zu Boden! *");
			g.reA(0.4); g.reG(0.4);
			schaden=50+g.getL()*0.3;
		} else if (g.getClassS() == Classes.GNOM ) {
			help.p("*  WUUUUSCH STUUUUURM WAAAH !!! Hurricane hat bei einem Gnom keine Wirkung *");
			schaden=0;
		} else if (g.getClassS() == Classes.ZWERG ) {
			help.p("*  WUUUUSCH STUUUUURM WAAAH !!! Es scheint ihm nicht sehr zu schaden. *");
			schaden=10+g.getL()*(0.01+malor(h.getM(),500));
		} else if (g.getClassS() == Classes.ORK ) {
			help.p("*  WUUUUSCH STUUUUURM WAAAH !!! Hurricane wirft den Ork zu Himmel! *");
			schaden=0.45*g.getL()/g.getres();
		} else {
			schaden=h.getH()*0.2+h.getM()*0.4;
		}
		if (h.getM()<=0) return schaden*0.1;
		if (schaden > 0) h.setM(0.8); // setzt Magiekraft auf 0 falls schaden groesser als 0
		return schaden;
	}
	public static double Zauberbuch(Hero h, Hero g) {
		h.setM(20+(h.getM()*1.25));
		h.reH(1.4);
		help.p("// Zauberbuch - Du lernst neue Zaubersprueche. Deine Zauberkraft steigt auf: "+h.getM());
		if (chance(10)) {
			int heilung = (int) MiniHeros.heat;
			help.p("// +++ Heilzauber +++ // Du heilst dich um "+150*heilung+" Leben!");
			h.kampf(150*heilung);
		}
		if (chance(40)) {
			help.p("// Buchwurf! // Du wirfst dein Buch dem Gegner ins Gesicht!");
			return 120;
		}
		return 0;
	}

	// ZOMBIE
	public static double Zombiebiss(Hero h, Hero g) {
		if (g.getClassS() == Classes.SHELDON) {
			help.p("* Hirn zu eklig! *");
			return 5 + h.getA() * 0.01;
		} else {
			if (chance(100 * h.getL() / (h.getmax() + g.getG()))) {
				help.p("/// ZOMBIEBISS /// ");
				help.p("100  Hirnmasse verspeist!!!");
				g.setH(g.getH() - 100);
				h.setH(h.getH() + 100);
				if (g.getH() <= 0) {
					help.p("*** " + (0.5 * h.getM() + 300 - g.getH() * 0.8) + " Schaden durch Zombievirus! ***");
					return (0.5 * h.getM() + 300 - g.getH() * 0.8);
				}
				return (200 + h.getM() * 0.5);
			}
			help.p("Gegner ist vor Zombiebiss ausgewichen!");
			return 0;

		}
	}

	public static double Zombieschrei(Hero h, Hero g) {
		help.p("// Zombieschrei //");
		if (g.getClassS() == Classes.SHELDON) {
			help.p("* Sheldon schreit auch!!! Zombieschrei wird neutralisiert! *");
			return 0;
		}
		if (g.getClassS() == Classes.ZOMBIE) {
			help.p("* Geht nicht, wenn Gegner ein Zombie ist! *");
			help.p("Normaler Angriff!");
			return normal(h, g);
		} else {
			int r = (int) (Math.random() * 3);
			if (r > 0) {
				help.p("Zombieschrei war so laut, dass " + r + " Zombies nun mit dir kaempfen!");
				r++;
				System.out.print(" Angriff steigt von " + h.getA() + " auf " + h.getA() * r + " !");
				System.out.print(" Geschick steigt von " + h.getG() + " auf " + h.getG() * r + " !");
				help.p("Magie steigt von " + h.getM() + " auf " + h.getM() * r + " !");
				h.setA(h.getA() * r);
				h.setG(h.getG() * r);
				h.setM(h.getM() * r);

				help.p("Angst verursacht! Gegner hat 20% weniger Angriff und Geschick");
				g.setA(g.getA() * 0.8);
				g.setG(g.getG() * 0.8);
				return 0;
			}
			help.p("Angst verursacht! Gegner hat 40% weniger Angriff und Geschick");
			g.setA(g.getA() * 0.6);
			g.setG(g.getG() * 0.6);
			return 0;
		}
	}

	public static double hirnwurf(Hero h, Hero g) {
		if (g.getClassS() == Classes.SHELDON) {
			help.p(special + "* SHELDON kommt mit HIRNMASSE in Kontakt. Er explodiert. " + special);
			return g.getL();
		} else {
			help.p("/// HIRNWURF /// ");
			help.p("Du wirfst 70% deiner Hirnmasse auf den Gegner!");
			double hirn = h.getH() * 0.7;
			h.setH(h.getH() * 0.3);
			if (chance(100 * malor(h.getH(), 10))) {
				return (hirn * 2);
			}
			help.p("Du hast den Gegner nicht mit deinem Hirn getroffen!");
			return 0;

		}
	}

	public static double zombieschlag(Hero h, Hero g) {
		if (g.getClassS() == Classes.SHELDON) {
			help.p("* Zombieschlag toetet Sheldon! *");
			return g.getL();
		} else {
			help.p("// Zombieschlag //");
			return h.getA() * 0.5 + h.getG() * 0.4 + h.getM() * 0.1;
		}
	}

	// DRACHE - "Drachenschrei", "Feuerbombe", "Feueratem", "Drachenbiss des Todes"
	public static double Drache1(Hero h, Hero g) {
		if (g.getClassS() == Classes.SHELDON) {
			help.p("* Drachenschrei toetet Sheldon*");
			return g.getL();
		} else {
			help.p("// Drachenschrei //");
			g.reG(0.6);
			h.reG(1.3);
			h.reR(1.1);
			h.reM(1.2);
			return 5+h.getM()*0.05;
		}
	}
	public static double Drache2(Hero h, Hero g) {
		if (g.getClassS() == Classes.SHELDON) {
			help.p("* Feuerbombe macht kein Schaden gegen Sheldon *");
			return 0;
		} else {
			help.p("// Feuerbombe //");
			if (chance(100-g.getG())) {
				help.p(">>> Feuerbombe trifft! <<<");
				return h.getM()*0.35;
			}
			help.p("> Feuerbombe zerreist einen Baum");
			g.reG(0.95);
			return 0;
		}
	}
	public static double Drache3(Hero h, Hero g) {
		if (g.getClassS() == Classes.SHELDON) {
			help.p("* Feuerspei toetet Sheldon *");
			return g.getL();
		} else {
			help.p("// Feuerspei //");
			help.p("Du speihst einen riesigen Feuerstrahl!");
			h.reM(0.65);
			return 30+h.getM()*0.5+h.getA()*0.1;
		}
	}
	public static double Drache4(Hero h, Hero g) {
		if (g.getClassS() == Classes.SHELDON) {
			help.p("* Drache hat keine Lust Shelden aufzuessen! Zu eklig! *");
			return 0;
		} else if (g.getClassS() == Classes.GNOM) {
			help.p("* Gnom ist zu klein um ihn aufzuessen! *");
			return 0;
		} else if (g.getClassS() == Classes.ZWERG) {
			help.p("* Zwerg ist zu klein um ihn aufzufressen! *");
			return 0;
		} else {
			help.p("// Drachenbiss //");
			help.p("Du stuerzt dich auf den Gegner und beisst den Kopf von"+h.getpName()+"ab!");
			double dmg = h.getM()*(1-(g.getmax()-g.getL())/g.getmax());
			h.reM(0);
			return dmg;
		}
	}



	// DRACHE - "Drachenschrei", "Eissplitter", "Eisfeuer", "Drachenbiss des Todes"
	public static double Eisdrache2(Hero h, Hero g) {
		if (g.getClassS() == Classes.SHELDON) {
			help.p("* Eissplitter toetet Sheldon*");
			return g.getL();
		} else {
			help.p("// Eissplitter //");
			if (chance(120-g.getG())) {
				help.p(">>> Eissplitter trifft! <<<");
				return h.getM()*0.8;
			}
			help.p("> Eissplitter rammt voll in den Boden rein");
			g.reG(0.95);
			return 0;
		}
	}
	public static double Eisdrache3(Hero h, Hero g) {
		if (g.getClassS() == Classes.SHELDON) {
			help.p("* Eisatem gegen Sheldon nutzlos! *");
			return 0;
		} else {
			help.p("// Eisatem //");
			help.p("Du speihst einen riesigen Eisstrahl!");
			h.reM(0.75);
			return 50+h.getM()*0.4+h.getH()*0.3;
		}
	}

	// NEINHEIT - spells: "NEIN", "ICHSAGENEIN", "EHHHNEIN", "NEINNEINNEIN" - a1000, g50, h50000, m1, 50000, 0.1
	public static double neinheit4(Hero h, Hero g) {
		int schaden = 0;
		if (g.getClassS() == Classes.SHELDON) {
			help.p("* Sheldon sagt NEIN zu deiner Ultimate! *");
		} else if (g.getClassS() == Classes.GNOM || g.getClassS() == Classes.MAGIER) {
			help.p("* Ultimatives Nein nicht gegen so schlaue Person einsetzbar! *");
		} else {
			help.p("// NEINNEINNEIN //");
			help.p(">>> Du wirfst HITLER auf den Gegner! <<<");
			if (chance(100-g.getG())) {
				help.p(">>> Treffer! Hitler explodiert! <<<");
				schaden = (int) Math.ceil(h.getG()*2 + h.getA()*0.1);
			} else {
				help.p("> Ein Jude laeuft vorbei. Der fliegende Hitler aendert den Kurs.");	
			}
		}
		return schaden;
	}
	public static double neinheit3(Hero h, Hero g) {
		int schaden = 0;
		if (g.getClassS() == Classes.SHELDON) {
			help.p("* EHH NEIN! gegen Sheldon nutzlos! *");
			return 0;
		} else {
			help.p("// EHHH NEIN! //");
			help.p(">>> DU SAGST NEIN ZU REGELN UND JA ZUR ATOMKRAFT!");
			int x = (int) Math.ceil(Math.random()*5);
			if(chance(20)) {
				help.p("Addiert "+x*100+" Magiekraft!");
				h.setM(h.getM()+x*100);
			} else if (chance(30)) {
				help.p("Addiert "+x*100+" Geschick!");
				h.setG(h.getG()+x*100);
			} else if (chance(40)) {
				help.p("Addiert "+x*100+" Hirn!");
				h.setM(h.getM()+x*100);
			} else {
				help.p("Addiert "+x*100+" Angriff!");
				h.setA(h.getA()+x*100);
			}
			if (chance (40)) {
				help.p("!!!!!!!!11!!4!!13423!!!!§ ATOMSCHLAG !!!!!!!!!!!!!!!!!11!!1!!!");
				schaden = x*150;
			}
		}
		return schaden;
	}
	public static double neinheit2(Hero h, Hero g) {
		int schaden = 0;
		if (g.getClassS() == Classes.SPIDERPIG) {
			help.p("* zu SPIDERPIG kann man nicht NEIN sagen! *");
			g.reM(1.5); g.reA(1.5);
		} else {
			help.p("// ICH SAGE ... //");
			int ende = 0;
			while (ende < 2) {
			if (chance(70)) {
				help.p(">>> BOOM! NEINBOMBE TRIFFT! <<<");
				schaden += h.getG()*0.01;
			} else {
				help.p("X-X NEINBOMBE geht daneben! OCH NEIN! X-X");
				ende++;
			}
			}
			help.p("Die Bomben heilen dich um "+schaden*0.05);
			h.kampf(schaden*0.05);
		}
		return schaden;
	}
	public static double neinheit1(Hero h, Hero g) {
		int schaden = 0;
		if (g.getClassS() == Classes.SHELDON) {
			help.p("* NEIN verwirrt Sheldon! *");
			schaden = 50;
		} else if (g.getClassS() == Classes.MAGIER) {
			help.p("* Magier unterbricht deine Neinsagung! *");
		} else{
			help.p("// NEIN zum Angriff! //");
			help.p("Angreifen wird ueberbewertet!");
			if (chance(30)) {
				help.p("Deine Entspanntheit ver3-facht dein Geschick");
				h.reG(3);
			} else if (chance(30)) {
				help.p("Deine Entspanntheit ver10-facht dein Geschick");
				h.reG(10);
			} else {
				help.p("Du rutschst auf einer Banane aus und explodierst aus Versehen! 20000 Schaden!");
				h.kampf(-20000);
			}
		}
		return schaden;
	}
	
	//	JAHEIT -		createHero(1000, 8000, 100, 100, 50000, 2, Values.POWERjaheit);
	// addSpells("JA", "ICHSAGEIMMERJA", "JAKLAR", "JA natuuuurlich");
	public static double jaheit4(Hero h, Hero g) {
		int schaden = 0;
		if (g.getClassS() == Classes.SHELDON) {
			help.p("* Sheldon sagt JA zu deiner Ultimate! *");
			help.p("* Dein Strahl aus JAs erhellt die Umgebung durchbohrt Sheldon! *");
			schaden = (int) g.getL();
		} else if (g.getClassS() == Classes.ELF || g.getClassS() == Classes.KRIEGER || g.getClassS() == Classes.DARKSPIDERMAN || g.getClassS() == Classes.SPIDERMAN || g.getClassS() == Classes.SPIDERPIG || g.getClassS() == Classes.GOKU || g.getClassS() == Classes.ZWERG) {
			help.p("* Ultimatives JA nicht gegen so geschickte Person einsetzbar! *");
		} else {
			help.p("// JAAAAA NATUUUUUUERLICH! //");
			help.p(">>> Du wirfst die heilige Granate auf den Gegner! HALELUJA! <<<");
			help.warte(1000); help.p(">>> HALELUJA! <<<"); help.warte(1000); help.p(">>> HALELUJA! <<<"); help.warte(1000);
			if (chance(40+ 10/malor(g.getG(),300))) {
				help.p(">>> KAWUUUUUUUUSCH <<<");
				schaden = (int) Math.ceil(h.getM()*2+h.getA()*0.1);
			} else {
				help.p("> "+g.getpName()+"kickt die Granate wieder zurueck! 20000 Schaden an dich!");
				g.kampf(-8000);
			}
		}
		h.setM(h.getM()-1);
		return schaden;
	}
	public static double jaheit3(Hero h, Hero g) {
		int schaden = 0;
		if (g.getClassS() == Classes.SPIDERPIG) {
			help.p("* zu SPIDERPIG kann man nur JA sagen! *");
			help.p("Du streichelst das Spiderpig");
		} else {
			help.p("// JAAA KLAR DOCH //");
			if (chance(85)) {
				help.p(">>> Du schreist so laut, dass 9 Ja-Kampfeinheiten sich dir anschliessen! <<<");
				h.reM(10);
			} else {
				help.p("X-X "+g.getpName()+" schreit zurueck: JA is gut, beruhig dich, Peter! X-X");
			}
			help.p("Der Schrei reinigt deine Lunge. Heilung um 2000 Leben!");
			h.kampf(2000);
		}
		return schaden;
	}
	public static double jaheit2(Hero h, Hero g) {
		int schaden = 0;
		if (g.getClassS() == Classes.SHELDON) {
			help.p("* Sheldon sagt Nope! *");
			return 0;
		} else {
			help.p("// ICH SAG IMMER JA! //");
			int x = (int) Math.ceil(Math.random()*30);
			help.p(">>> DU SAGST JA ZU GENPRODUKTE! Du mutierst und verdoppelst dich "+x+" mal!");
			help.p("Deine Doppelkaenger sind stark agressiv. Sie greifen alle an!");
			schaden = (int) Math.ceil(x*h.getM()*0.01);
			if(chance(20)) {
				help.p("Einer deiner Doppelkaenger gibt dir einen Kuchen!");
				h.setM(h.getM()+x*100);
			} if (chance(30)) {
				help.p("Einer deiner Doppelkaenger gibt dir einen Crysis 3 Kampfanzug!");
				h.reG(4); h.reA(2);
			} if (chance(40)) {
				help.p("All deine Doppelgaenger explodieren.");
				h.kampf((-500*x));
			} else {
				help.p("All deine Doppelgaenger werden zu Feenstaub. Du musst husten!");
				h.reG(0.8);
			}
		}
		return schaden;
	}
	public static double jaheit1(Hero h, Hero g) {
		int schaden = 0;
		if (g.getClassS() == Classes.SHELDON) {
			help.p("* JA heilt Sheldon um 500 Leben! *");
			g.kampf(500);
		} else if (g.getClassS() == Classes.KRIEGER) {
			help.p("* Krieger unterbricht deine Jasagung! *");
		} else{
			help.p("// JA ZUM LEBEN!!! //");
			help.p("Du schaust erleuchtet hoch und streckst deine Arme in den Himmel!");
			help.punkte();
			help.p("Du heilst alle um 400 Leben!"); h.setL(h.getL()+400); g.setL(g.getL()+400);
			if (chance(30)) {
				help.p("Deine Erleuchtung ver2-facht deine Zauberkraft");
				h.reM(2);
			} else if (chance(30)) {
				help.p("Deine Erleuchtung ver5-facht deine Zauberkraft");
				h.reM(5);
			} else {
				help.p("Ein Vogel kackt dir ins Gesicht! Du bekommst 20000 Schaden! Unangenehm!");
				h.kampf(-20000);
				h.reM(0.8); h.reA(0.8); h.reG(0.8);
			}
		}
		return schaden;
	}
	// TODO: 
	/*
	 * 			addSpells();
		} else if (heroClass == Classes.JAHEIT) {

			
		} else if (heroClass == Classes.LEVIATHAN) {
			createHero(2500, 1300, 700, 600, 100000, 0.2, Values.POWERleviathan);
			addSpells("normal", "geschickt", "super", "leviate");
		} else if (heroClass == Classes.ULTIMATEFORM) {
			createHero(777, 400, 5000, 3000, 100, 0.05
			("verwirren", "vernaschen", "zermalmen", "zernichten", "Zetox");
		sheldon: "penny", "dasistmeinplatz", "zeitreise");
	 */








	// ZAUBER ERSTELLEN KONSTRUKTOR
	public static double ZAUBERNAME(Hero h, Hero g) {
		if (g.getClassS() == Classes.SHELDON) {
			help.p("* // dieser zauber toetet Sheldon! *");
			return g.getL();
		} else {
			help.p("// DEIN ZAUBERNAME //");
			return h.getA()+30;

		}
	}

	public static double Xalor(Hero h, Hero g) {
		if (g.getClassS() == Classes.SHELDON) {
			help.p("* Xalor geht nicht gegen Sheldon! *");
			return 0;
		} else {
			help.p("// ----Xalor---- //");
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
public static void r(String text) {
	System.out.println("###>>>>> " + text);
}

	public static void superp(String text) {
		System.out.println("$$$ " + text + " $$$");
	}
}
