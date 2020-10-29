package s18001020707.V4.model.Skill;

public abstract class Skill {
	 public int Atk = 0;//攻击

	 public int mp = 0;//法力消耗

	 public int exp = 0;//经验

	 public String name = "";//技能名字

	public int useSkill() {
		int hurt = Atk*(exp/10+1);//伤害=攻击*(经验/10+1)
		exp += 1;
		return hurt;
	}

	public void getSkill(String username) {
		System.out.println(username + "使用了" + name);
	}
	public int getAtk() {
		return Atk;
	}
	public void setAtk(int atk) {
		Atk = atk;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMp() {
		return mp;
	}
	public void setMp(int mp) {
		this.mp = mp;
	}

	@Override
	public String toString() {
		return  name ;
	}
}
