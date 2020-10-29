package s18001020707.V1_more.Enemys;

abstract public class Enemy implements Cloneable {
    int hp;
    int mp;
    int atk;
    int def;
    String Enemyname;

    abstract  public int Attack();
    abstract public void useAtk();

    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getMp() {
        return mp;
    }
    public void setMp(int mp) {
        this.mp = mp;
    }
    public int getAtk() {
        return atk;
    }
    public void setAtk(int atk) {
        this.atk = atk;
    }
    public int getDef() {
        return def;
    }
    public void setDef(int def) {
        this.def = def;
    }
    public String getEnemyname() {
        return Enemyname;
    }
    public void setEnemyname(String enemyname) {
        Enemyname = enemyname;
    }
}
