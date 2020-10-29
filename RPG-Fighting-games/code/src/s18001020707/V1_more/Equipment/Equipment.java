package s18001020707.V1_more.Equipment;

abstract public class Equipment {

    protected int Atk = 0;
    protected int Def = 0;
    protected String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAtk() {
        return Atk;
    }
    public void setAtk(int atk) {
        Atk = atk;
    }
    public int getDef() {
        return Def;
    }
    public void setDef(int def) {
        Def = def;
    }

}
