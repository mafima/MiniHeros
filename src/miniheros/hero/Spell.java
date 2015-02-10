package miniheros.hero;

import main.MiniHeros;
import miniheros.util.Help;

public abstract class Spell extends Help {

	private final String spellname;

	private long cooldown;
	private long cooldownset;

	private final double needA;
	private final double needG;
	private final double needH;
	private final double needM;
	private final double needL;

	private final double costA;
	private final double costG;
	private final double costH;
	private final double costM;
	private final double costL;


	public Spell(String name, long cd, long cdset, double needa, double needg, double needh, double needm, double needl, double costa, double costg, double costh, double costm, double costl){
		this.spellname = name;
		this.cooldown = cd;
		this.cooldownset = cdset;

		// NEEDS  UND COSTS werden gesetzt
		this.needA = needa; this.needG = needg; this.needH = needh; this.needM = needm; this.needL = needl;
		this.costA = costa; this.costG = costg; this.costH = costh; this.costM = costm; this.costL = costl;
	}
	// COOLDOWN SETTER UND GETTER
	public long getcd() {
		return cooldown;
	}
	public void castcd() {
		if (cooldownset != 0) {
			this.cooldown = cooldownset;
			p(this.getSpellname()+" Cooldown: "+cooldownset+" Sekunden!");
		}
	}
	public void setcd(long zeitset) {
		this.cooldown = zeitset;
	}
	public void changecd(long zeitset) {
		if (cooldown > 0) {
			this.cooldown += zeitset;
			if (cooldown < 0) cooldown = 0;
		}
		
	}
	
	public String getSpellname() {
		return spellname;
	}
	public long getCooldownset() {
		return cooldownset;
	}
	public double getNeedA() {
		return needA;
	}
	public double getNeedG() {
		return needG;
	}
	public double getNeedH() {
		return needH;
	}
	public double getNeedM() {
		return needM;
	}
	public double getNeedL() {
		return needL;
	}
	public double getCostA() {
		return costA;
	}
	public double getCostG() {
		return costG;
	}
	public double getCostH() {
		return costH;
	}
	public double getCostM() {
		return costM;
	}
	public double getCostL() {
		return costL;
	}

	public boolean checkall(Hero hero){
		// SET: FAIL = FALSE
		boolean fail = false;
		
		// CD CHECK
		if (this.getcd() > 0) {
			System.out.println(this.getSpellname()+" nicht bereit! Du musst dich noch "+this.getcd()+" Sekunden im Gegnerzug ausruhen!");
			Help.warte(2000);
			fail = true;
		}
		
		// NEED CHECK
		if (this.getNeedA() > hero.getA() && this.getNeedA()!=0) {
			System.out.println(this.getSpellname()+" braucht "+this.getNeedA()+" Angriff! Du hast: "+Math.round(hero.getA()));
			fail = true;
		} if (this.getNeedG() > hero.getG() && this.getNeedG()!=0) {
			System.out.println(this.getSpellname()+" braucht "+this.getNeedG()+" Geschick! Du hast: "+Math.round(hero.getG()));
			fail = true;
		} if (this.getNeedH() > hero.getH() && this.getNeedH()!=0) {
			System.out.println(this.getSpellname()+" braucht "+this.getNeedH()+" Hirn! Du hast: "+Math.round(hero.getH()));
			fail = true;
		} if (this.getNeedM() > hero.getM() && this.getNeedM()!=0) {
			System.out.println(this.getSpellname()+" braucht "+this.getNeedM()+" Magie! Du hast: "+Math.round(hero.getM()));
			fail = true;
		} if (this.getNeedL() > hero.getL() && this.getNeedL()!=0) {
			System.out.println(this.getSpellname()+" braucht "+this.getNeedL()+" Leben! Du hast: "+Math.round(hero.getL()));
			fail = true;
		}
		
		// COST CHECK
		if (this.getCostA() > hero.getA() && this.getCostA()!=0) {
			System.out.println(this.getSpellname()+" verbraucht "+this.getCostA()+" Angriff! Du hast: "+Math.round(hero.getA()));
			fail = true;
		} else if (getCostA() >= 1 || getCostA() == 0) hero.setA(hero.getA()-getCostA()); else hero.setA(hero.getA()*getCostA());
		if (this.getCostG() > hero.getG() && this.getCostG()!=0) {
			System.out.println(this.getSpellname()+" verbraucht "+this.getCostG()+" Geschick ! Du hast: Geschick: "+Math.round(hero.getG()));
			fail = true;
		} else if (getCostG() >= 1 || getCostG() == 0) hero.setG(hero.getG()-getCostG()); else hero.setG(hero.getG()*getCostG());
		if (this.getCostH() > hero.getH() && this.getCostH()!=0) {
			System.out.println(this.getSpellname()+" verbraucht "+this.getCostH()+" Hirn ! Du hast: Hirn: "+Math.round(hero.getH()));
			fail = true;
		} else if (getCostH() >= 1 || getCostH() == 0) hero.setH(hero.getH()-getCostH()); else hero.setH(hero.getH()*getCostH());
		if (this.getCostM() > hero.getM() && this.getCostM()!=0) {
			System.out.println(this.getSpellname()+" verbraucht "+this.getCostM()+" Zauberkraft ! Du hast: Zauberkraft: "+Math.round(hero.getM()));
			fail = true;
		} else  if (getCostM() >= 1 || getCostM() == 0) hero.setM(hero.getM()-getCostM()); else hero.setM(hero.getG()*getCostM());
		if (this.getCostL() > hero.getL() && this.getCostL()!=0) {
			System.out.println(this.getSpellname()+" verbraucht "+this.getCostL()+" Leben ! Du hast: Leben: "+Math.round(hero.getL()));
			fail = true;
		} else  if (getCostL() >= 1 || getCostL() == 0) hero.setL(hero.getL()-getCostL()); else hero.setM(hero.getL()*getCostL());
		
		// RETURN if fail is true of false
		return fail;
	}

	public abstract double cast(Hero hero, Hero gegner);

}