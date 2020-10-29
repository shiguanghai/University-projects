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
    private int Currenthp=500;//现存血量
    private int maxhp=500;
    private int Currentmp=100;
    private int mp=100;//魔法值
    private int Atk=100;//攻击力
    private int def=100;//防御力
    private int exp=0;//经验值
    private int level=1;//等级
    private int strength=10;//力量
    private int intl=10;//智力
    private int speed=10;//敏捷

    private Career RoleCareer;//帮派
    private Weapon RoleWeapon;//武器
    private Clothes RoleClothes;//服装
    private List<Skill> RoleSkill;//技能
    private State state;//状态
    private static Role role;
    private static KillEnemys killEnemys;//成就系统
    private static AchievementObserver enemyA;
    private static AchievementObserver enemyB;
    private static AchievementObserver enemyC;//击杀成就

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
     * 生成单例模式
     * @return
     */
    public static Role getRole(String username, Career c){
        if (role==null){
            role=new Role(username,c);
        }
        return role;
    }

    /**
     * 获取人物基础属性
     */
    public void getRolestats(){
        role.toString();
    }

    /**
     *人物升级
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
        System.out.println("恭喜您升级了！");
        System.out.println("血量上线+"+level*10+","+"魔法值+"+level*10+","+"攻击力+"+level*5+","
                +"防御力+"+level*5+","+"力量+"+level*3+","+"智力+"+level*3+","+"敏捷+"+level*3+"。");
    }

    /**
     * 战斗胜利恢复全部血量
     */
    public void Victory(String enemyname){
        enemyname(enemyname);//击杀成就结算
        this.setCurrenthp(this.getMaxhp());//恢复生命
        this.setCurrentmp(this.getMp());//恢复法力
        switch (enemyname){
            case "落魄子弟":
                this.setExp(getExp()+50*(int)(Math.pow(1.2,getLevel()+1)));//胜利+50 使用技能+1
                break;
            case "歪门邪道":
                this.setExp(getExp()+100*(int)(Math.pow(1.2,getLevel()+1)));//胜利+100 使用技能+1
                break;
            default:
                this.setExp(getExp()+150*(int)(Math.pow(1.2,getLevel()+1)));//胜利+150 使用技能+1
        }
        getMaxExperience(getLevel());
    }

    /**
     * 战斗胜利结算成就
     * @param enemyname
     */
    public void enemyname(String enemyname){
        if(killEnemys==null){
            killEnemys = new KillEnemysEvent();
        }
        if(enemyA==null){
            enemyA = new AchievementObserver("落魄子弟");
        }
        if(enemyB==null){
            enemyB = new AchievementObserver("歪门邪道");
        }
        if(enemyC==null){
            enemyC = new AchievementObserver("鬼怪妖魔");
        }
        Observer observer;
        switch (enemyname){
            case "落魄子弟":
                observer = enemyA;
                break;
            case "歪门邪道":
                observer = enemyB;
                break;
            case "鬼怪妖魔":
                observer = enemyC;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + enemyname);
        }
        killEnemys.registerObserver(observer);
        int death = killEnemys.notify(enemyname, ((AchievementObserver) observer).getDeath());//发送消息，杀死怪物，并将杀死的怪物id一起发送
        ((AchievementObserver) observer).setDeath(death);
        observer.response();//获取成就信息
    }

    /**
     * 战斗胜利结算是否升级
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
        System.out.println("当前等级："+getLevel()+"级,下一级："+getExp()+"/"+RoleCareer.useStage(getLevel()));
        return 0;
    }


    /**
     * 战斗
     */
    public int attack(Skill skill){
        Invoker invoker=new Invoker();
        if (skill.getName()=="普通攻击"){//普通攻击
            weaponCommand ws = new weaponCommand(getRoleWeapon());
            invoker.setCommand(ws);
        }else {//技能攻击
            this.setCurrentmp(this.getCurrentmp()-skill.getMp());
            SkillCommand sc=new SkillCommand(skill);
            invoker.setCommand(sc);
        }
        invoker.buttonWatPressed(this.Rolename);
        this.updateState();//更新角色战斗状态
        return this.getState().doATK(this)+skill.useSkill()+this.getRoleWeapon().getAtk()+5*
                this.getStrength()+6*this.getSpeed()+3*this.getIntl();
        //总伤害=攻击+技能伤害+武器伤害+力量*5+敏捷*6+智力*3
    }

    /**
     * 更新角色战斗状态
     */
    public void updateState(){
        if (((double)this.getCurrenthp()/(double)this.getMaxhp())<0.5){//现存血量<50%
            this.setState(new binsi());//濒死 攻击*1.2
        }
        else{
            this.setState(new Health());//健康
        }
    }

    /**
     * 下面的都是setget方法
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
                "角色名称='" + Rolename + '\'' +
                ", 当前hp=" + Currenthp +
                ", 最大hp=" + maxhp +
                ", mp=" + mp +
                ", Atk=" + Atk +
                ", def=" + def +
                ", 经验值=" + exp +
                ", 等级=" + level +
                ", 力量=" + strength +
                ", 智力=" + intl +
                ", 速度=" + speed +
                ",\n 人物职业=" + RoleCareer +
                ", 人物武器=" + RoleWeapon +
                ", 人物衣服=" + RoleClothes +
                ", 技能=" + RoleSkill +
                ", 状态=" + state +
                '}';
    }
}
