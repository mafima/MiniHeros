package miniheros.hero;

import miniheros.util.help;

public abstract class Spell {

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

		// NEEDS  UND COSTS
		this.needA = needa; this.needG = needg; this.needH = needh; this.needM = needm; this.needL = needl;
		this.costA = costa; this.costG = costg; this.costH = costh; this.costM = costm; this.costL = costl;
	}
	public long getcd() {
		return cooldown;
	}
	public void setcd() {
		this.cooldown = cooldownset;
	}
	public void changecd(long zeitset) {
		this.cooldown += zeitset;
	}
	public String getSpellname() {
		return spellname;
	}
	public void setCooldownset( long cdset) {
		this.cooldownset = cdset*1000;
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
		boolean fail = false;
		if (this.getcd() > 0) {
			System.out.println("Du musst dich noch "+this.getcd()+" Sekunden erholen um "+this.getSpellname()+" zu nutzen!");
			help.warte(2000);
			fail = true;
		}
		
		if (this.getNeedA() > hero.getA() && this.getNeedA()!=0) {
			System.out.println("Du brauchst "+this.getNeedM()+" Angriff um "+this.getSpellname()+" zu nutzen!");
			fail = true;
		} if (this.getNeedG() > hero.getG() && this.getNeedG()!=0) {
			System.out.println("Du brauchst "+this.getNeedG()+" Geschick um "+this.getSpellname()+" zu nutzen!");
			fail = true;
		} if (this.getNeedH() > hero.getH() && this.getNeedH()!=0) {
			System.out.println("Du brauchst "+this.getNeedH()+" Hirn um "+this.getSpellname()+" zu nutzen!");
			fail = true;
		} if (this.getNeedM() > hero.getM() && this.getNeedM()!=0) {
			System.out.println("Du brauchst "+this.getNeedM()+" Magie um "+this.getSpellname()+" zu nutzen!");
			fail = true;
		} if (this.getNeedL() > hero.getL() && this.getNeedL()!=0) {
			System.out.println("Du brauchst "+this.getNeedL()+" Leben um "+this.getSpellname()+" zu nutzen!");
			fail = true;
		}
		
		if (this.getCostA() > hero.getA() && this.getCostA()!=0) {
			System.out.println("Du hast nicht "+this.getCostM()+" Angriff um "+this.getSpellname()+" zu nutzen! Angriff: "+hero.getA());
			fail = true;
		} else hero.setA(hero.getA()-getCostA());
		if (this.getCostG() > hero.getG() && this.getCostG()!=0) {
			System.out.println("Du hast nicht "+this.getCostG()+" Geschick um "+this.getSpellname()+" zu nutzen! Geschick: "+hero.getG());
			fail = true;
		} else hero.setG(hero.getG()-getCostG());
		if (this.getCostH() > hero.getH() && this.getCostH()!=0) {
			System.out.println("Du hast nicht "+this.getCostM()+" Hirn um "+this.getSpellname()+" zu nutzen! Hirn: "+hero.getH());
			fail = true;
		} else hero.setH(hero.getH()-getCostH());
		if (this.getCostM() > hero.getM() && this.getCostM()!=0) {
			System.out.println("Du hast nicht "+this.getCostM()+" Zauberkraft um "+this.getSpellname()+" zu nutzen! Zauberkraft: "+hero.getA());
			fail = true;
		} else hero.setM(hero.getM()-getCostM() );
		if (this.getCostL() > hero.getL() && this.getCostL()!=0) {
			System.out.println("Du hast nicht "+this.getCostL()+" Leben um "+this.getSpellname()+" zu nutzen! Leben: "+hero.getA());
			fail = true;
		} else hero.setL(hero.getL()-getCostL());
		
		return fail;
	}


	public abstract double cast(Hero hero, Hero gegner);
}