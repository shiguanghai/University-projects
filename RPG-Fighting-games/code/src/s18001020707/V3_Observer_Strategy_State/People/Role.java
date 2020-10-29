package s18001020707.V3_Observer_Strategy_State.People;

import s18001020707.V3_Observer_Strategy_State.Achievement.AchievementObserver;
import s18001020707.V3_Observer_Strategy_State.Achievement.KillEnemys;
import s18001020707.V3_Observer_Strategy_State.Achievement.KillEnemysEvent;
import s18001020707.V3_Observer_Strategy_State.Achievement.Observer;
import s18001020707.V3_Observer_Strategy_State.Command.Invoker;
import s18001020707.V3_Observer_Strategy_State.Command.SkillCommand;
import s18001020707.V3_Observer_Strategy_State.Command.weaponCommand;
import s18001020707.V3_Observer_Strategy_State.Equipment.Clothes.Clothes;
import s18001020707.V3_Observer_Strategy_State.Equipment.Weapon.Weapon;
import s18001020707.V3_Observer_Strategy_State.Equipment.abstractFactory.fresh_factory;
import s18001020707.V3_Observer_Strategy_State.People.Career.Career;
import s18001020707.V3_Observer_Strategy_State.People.ExperienceStrategy.GrowthBehavior;
import s18001020707.V3_Observer_Strategy_State.People.ExperienceStrategy.IntroductionBehavior;
import s18001020707.V3_Observer_Strategy_State.People.ExperienceStrategy.MasterBehavior;
import s18001020707.V3_Observer_Strategy_State.People.ExperienceStrategy.NoviceBehavior;
import s18001020707.V3_Observer_Strategy_State.People.State.Health;
import s18001020707.V3_Observer_Strategy_State.People.State.State;
import s18001020707.V3_Observer_Strategy_State.People.State.binsi;
import s18001020707.V3_Observer_Strategy_State.Skill.Skill;

import java.util.List;

public class Role {

    private String Rolename;
    private int Currenthp=500;//�ִ�Ѫ��
    private int maxhp=500;
    private int Currentmp=100;
    private int mp=100;//ħ��ֵ
    private int Atk=100;//������
    private int def=100;//������
    private int exp=0;//����ֵ
    private int level=1;//�ȼ�
    private int strength=10;//����
    private int intl=10;//����
    private int speed=10;//����

    private Career RoleCareer;//����
    private Weapon RoleWeapon;//����
    private Clothes RoleClothes;//��װ
    private List<Skill> RoleSkill;//����
    private State state;//״̬
    private static Role role;
    private static KillEnemys killEnemys;//�ɾ�ϵͳ
    private static AchievementObserver enemyA;
    private static AchievementObserver enemyB;
    private static AchievementObserver enemyC;//��ɱ�ɾ�

    private Role(String username, Career usercareer){
        this.setRolename(username);
        this.setRoleCareer(usercareer);
        this.getRoleCareer().addshuxing(this);
        fresh_factory ff=new fresh_factory();
        this.setRoleWeapon(ff.CreateWeapon());
        this.setRoleClothes(ff.CreateClothes());
        this.setRoleSkill(usercareer.getSkilllistl());
        this.setState(new Health());
    }

    /**
     * ���ɵ���ģʽ
     * @return
     */
    public static Role getRole(String username, Career c){
        if (role==null){
            role=new Role(username,c);
        }
        return role;
    }

    /**
     * ��ȡ�����������
     */
    public void getRolestats(){
        role.toString();
    }

    /**
     *��������
     * @return
     */
    public void levelup(){
        this.level++;
        this.setMaxhp(getMaxhp()+level*10);
        this.Currenthp=this.maxhp;
        this.setMp(getMp()+level*10);
        this.Currentmp=this.mp;
        this.setAtk(getAtk()+level*5);
        this.setDef(getDef()+level*5);
        this.setStrength(getStrength()+level*3);
        this.setIntl(getIntl()+level*3);
        this.setSpeed(getSpeed()+level*3);
        System.out.println("��ϲ�������ˣ�");
        System.out.println("Ѫ������+"+level*10+","+"ħ��ֵ+"+level*10+","+"������+"+level*5+","
                +"������+"+level*5+","+"����+"+level*3+","+"����+"+level*3+","+"����+"+level*3+"��");
    }

    /**
     * ս��ʤ���ָ�ȫ��Ѫ��
     */
    public void Victory(String enemyname){
        enemyname(enemyname);//��ɱ�ɾͽ���
        this.setCurrenthp(this.getMaxhp());//�ָ�����
        this.setCurrentmp(this.getMp());//�ָ�����
        switch (enemyname){
            case "�����ӵ�":
                this.setExp(getExp()+50*(int)(Math.pow(1.2,getLevel()+1)));//ʤ��+50 ʹ�ü���+1
                break;
            case "����а��":
                this.setExp(getExp()+100*(int)(Math.pow(1.2,getLevel()+1)));//ʤ��+100 ʹ�ü���+1
                break;
            default:
                this.setExp(getExp()+150*(int)(Math.pow(1.2,getLevel()+1)));//ʤ��+150 ʹ�ü���+1
        }
        getMaxExperience(getLevel());
    }

    /**
     * ս��ʤ������ɾ�
     * @param enemyname
     */
    public void enemyname(String enemyname){
        if(killEnemys==null){
            killEnemys = new KillEnemysEvent();
        }
        if(enemyA==null){
            enemyA = new AchievementObserver("�����ӵ�");
        }
        if(enemyB==null){
            enemyB = new AchievementObserver("����а��");
        }
        if(enemyC==null){
            enemyC = new AchievementObserver("�����ħ");
        }
        Observer observer;
        switch (enemyname){
            case "�����ӵ�":
                observer = enemyA;
                break;
            case "����а��":
                observer = enemyB;
                break;
            case "�����ħ":
                observer = enemyC;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + enemyname);
        }
        killEnemys.registerObserver(observer);
        int death = killEnemys.notify(enemyname, ((AchievementObserver) observer).getDeath());//������Ϣ��ɱ���������ɱ���Ĺ���idһ����
        ((AchievementObserver) observer).setDeath(death);
        observer.response();//��ȡ�ɾ���Ϣ
    }

    /**
     * ս��ʤ�������Ƿ�����
     */
    public int getMaxExperience(int level){
        if(level<=3){
            RoleCareer.setExperience(new IntroductionBehavior());
        }
        else if(level<=5){
            RoleCareer.setExperience(new NoviceBehavior());
        }
        else if(level<=8){
            RoleCareer.setExperience(new GrowthBehavior());
        }else {
            RoleCareer.setExperience(new MasterBehavior());
        }
        if(this.getExp()>=(RoleCareer.useStage(level))){
            this.setExp(this.getExp()-(RoleCareer.useStage(level)));
            levelup();
        }
        System.out.println("��ǰ�ȼ���"+getLevel()+"��,��һ����"+getExp()+"/"+RoleCareer.useStage(getLevel()));
        return 0;
    }


    /**
     * ս��
     */
    public int attack(Skill skill){
        Invoker invoker=new Invoker();
        if (skill.getName()=="��ͨ����"){//��ͨ����
            weaponCommand ws = new weaponCommand(getRoleWeapon());
            invoker.setCommand(ws);
        }else {//���ܹ���
            this.setCurrentmp(this.getCurrentmp()-skill.getMp());
            SkillCommand sc=new SkillCommand(skill);
            invoker.setCommand(sc);
        }
        invoker.buttonWatPressed(this.Rolename);
        this.updateState();//���½�ɫս��״̬
        return this.getState().doATK(this)+skill.useSkill()+this.getRoleWeapon().getAtk()+5*
                this.getStrength()+6*this.getSpeed()+3*this.getIntl();
        //���˺�=����+�����˺�+�����˺�+����*5+����*6+����*3
    }

    /**
     * ���½�ɫս��״̬
     */
    public void updateState(){
        if (((double)this.getCurrenthp()/(double)this.getMaxhp())<0.5){//�ִ�Ѫ��<50%
            this.setState(new binsi());//���� ����*1.2
        }
        else{
            this.setState(new Health());//����
        }
    }

    /**
     * ����Ķ���setget����
     * @return
     */
    public String getRolename() {
        return Rolename;
    }
    public void setRolename(String rolename) {
        Rolename = rolename;
    }
    public int getCurrenthp() {
        return Currenthp;
    }
    public void setCurrenthp(int currenthp) {
        Currenthp = currenthp;
    }
    public int getMaxhp() {
        return maxhp;
    }
    public void setMaxhp(int maxhp) {
        this.maxhp = maxhp;
    }
    public int getMp() {
        return mp;
    }
    public void setMp(int mp) {
        this.mp = mp;
    }
    public int getAtk() {
        return Atk;
    }
    public void setAtk(int atk) {
        Atk = atk;
    }
    public int getDef() {
        return def;
    }
    public void setDef(int def) {
        this.def = def;
    }
    public int getExp() {
        return exp;
    }
    public void setExp(int exp) {
        this.exp = exp;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getStrength() {
        return strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
    public int getIntl() {
        return intl;
    }
    public void setIntl(int intl) {
        this.intl = intl;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public Career getRoleCareer() {
        return RoleCareer;
    }
    public void setRoleCareer(Career roleCareer) {
        RoleCareer = roleCareer;
    }
    public Weapon getRoleWeapon() {
        return RoleWeapon;
    }
    public void setRoleWeapon(Weapon roleWeapon) {
        RoleWeapon = roleWeapon;
    }
    public Clothes getRoleClothes() {
        return RoleClothes;
    }
    public void setRoleClothes(Clothes roleClothes) {
        RoleClothes = roleClothes;
    }
    public List<Skill> getRoleSkill() {
        return RoleSkill;
    }
    public void setRoleSkill(List<Skill> roleSkill) {
        RoleSkill = roleSkill;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public State getState() {
        return state;
    }
    public void setState(State state) {
        this.state = state;
    }

    public int getCurrentmp() {
        return Currentmp;
    }

    public void setCurrentmp(int currentmp) {
        Currentmp = currentmp;
    }

    @Override
    public String toString() {
        return "Role{" +
                "��ɫ����='" + Rolename + '\'' +
                ", ��ǰhp=" + Currenthp +
                ", ���hp=" + maxhp +
                ", mp=" + mp +
                ", Atk=" + Atk +
                ", def=" + def +
                ", ����ֵ=" + exp +
                ", �ȼ�=" + level +
                ", ����=" + strength +
                ", ����=" + intl +
                ", �ٶ�=" + speed +
                ",\n ����ְҵ=" + RoleCareer +
                ", ��������=" + RoleWeapon +
                ", �����·�=" + RoleClothes +
                ", ����=" + RoleSkill +
                ", ״̬=" + state +
                '}';
    }
}
