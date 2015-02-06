package miniheros.hero;

import miniheros.util.help;

public abstract class Spell {

	private final String spellname;

	private long cooldown;
	private long cooldownset;

	private final float needA;
	private final float needG;
	private final float needH;
	private final float needM;
	private final float needL;

	private final float costA;
	private final float costG;
	private final float costH;
	private final float costM;
	private final float costL;


	public Spell(String name, long cd, long cdset, float needa, float needg, float needh, float needm, float needl, float costa, float costg, float costh, float costm, float costl){
		this.spellname = name;
		this.cooldown = cd;
		this.cooldownset = cdset;

		this.needA = needa;
		this.needG = needg;
		this.needH = needh;
		this.needM = needm;
		this.needL = needl;

		this.costA = costa;
		this.costG = costg;
		this.costH = costh;
		this.costM = costm;
		this.costL = costl;
	}
	public long getcd() {
		return cooldown/1000;
	}
	public void setcd() {
		this.cooldown = cooldownset;
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
	public float getNeedA() {
		return needA;
	}
	public float getNeedG() {
		return needG;
	}
	public float getNeedH() {
		return needH;
	}
	public float getNeedM() {
		return needM;
	}
	public float getNeedL() {
		return needL;
	}
	public float getCostA() {
		return costA;
	}
	public float getCostG() {
		return costG;
	}
	public float getCostH() {
		return costH;
	}
	public float getCostM() {
		return costM;
	}
	public float getCostL() {
		return costL;
	}

	public boolean checkall(Hero hero){
		boolean fail = false;
		if (this.getcd() > 0) {
			System.out.println("Du musst noch "+this.getcd()+" warten um "+this.getSpellname()+" zu nutzen!");
			help.warte(1000);
			fail = true;
		} if (this.getCostA() > hero.getA()) {
			System.out.println("Du hast nicht "+this.getCostM()+" Angriff um "+this.getSpellname()+" zu nutzen!");
			fail = true;
		} if (this.getCostG() > hero.getG()) {
			System.out.println("Du hast nicht "+this.getCostG()+" Geschick um "+this.getSpellname()+" zu nutzen!");
			fail = true;
		} if (this.getCostH() > hero.getH()) {
			System.out.println("Du hast nicht "+this.getCostM()+" Hirn um "+this.getSpellname()+" zu nutzen!");
			fail = true;
		} if (this.getCostM() > hero.getM()) {
			System.out.println("Du hast nicht "+this.getCostM()+" Magie um "+this.getSpellname()+" zu nutzen!");
			fail = true;
		} if (this.getCostL() > hero.getL()) {
			System.out.println("Du hast nicht "+this.getCostL()+" Leben um "+this.getSpellname()+" zu nutzen!");
			fail = true;
		}
		
		if (this.getNeedA() > hero.getA()) {
			System.out.println("Du hast nicht "+this.getCostM()+" Angriff um "+this.getSpellname()+" zu nutzen!");
			fail = true;
		} if (this.getNeedG() > hero.getG()) {
			System.out.println("Du hast nicht "+this.getCostG()+" Geschick um "+this.getSpellname()+" zu nutzen!");
			fail = true;
		} if (this.getNeedH() > hero.getH()) {
			System.out.println("Du hast nicht "+this.getCostM()+" Hirn um "+this.getSpellname()+" zu nutzen!");
			fail = true;
		} if (this.getNeedM() > hero.getM()) {
			System.out.println("Du hast nicht "+this.getCostM()+" Magie um "+this.getSpellname()+" zu nutzen!");
			fail = true;
		} if (this.getNeedL() > hero.getL()) {
			System.out.println("Du hast nicht "+this.getCostL()+" Leben um "+this.getSpellname()+" zu nutzen!");
			fail = true;
		}

		return fail;
	}


	public abstract float cast(Hero hero, Hero gegner);
}