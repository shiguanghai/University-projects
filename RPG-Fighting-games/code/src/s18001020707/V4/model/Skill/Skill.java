package s18001020707.V4.model.Skill;

public abstract class Skill {
	 public int Atk = 0;//����

	 public int mp = 0;//��������

	 public int exp = 0;//����

	 public String name = "";//��������

	public int useSkill() {
		int hurt = Atk*(exp/10+1);//�˺�=����*(����/10+1)
		exp += 1;
		return hurt;
	}

	public void getSkill(String username) {
		System.out.println(username + "ʹ����" + name);
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
