package s18001020707.V1_more.Controller;

import s18001020707.V1_more.Combat.CombatSystem;
import s18001020707.V1_more.Command.Invoker;
import s18001020707.V1_more.Command.SkillCommand;
import s18001020707.V1_more.Enemys.CloneEnemy;
import s18001020707.V1_more.Enemys.Enemy;
import s18001020707.V1_more.Equipment.Clothes.imp.freshClothes;
import s18001020707.V1_more.Equipment.Clothes.imp.superiorClothes;
import s18001020707.V1_more.Equipment.Weapon.imp.EM_Chi;
import s18001020707.V1_more.Equipment.Weapon.imp.SL_gun;
import s18001020707.V1_more.Equipment.Weapon.imp.TM_Biao;
import s18001020707.V1_more.Equipment.Weapon.imp.freshWeapon;
import s18001020707.V1_more.Filter.Filter1;
import s18001020707.V1_more.Filter.Filter2;
import s18001020707.V1_more.People.Career.emei;
import s18001020707.V1_more.People.Career.shaolin;
import s18001020707.V1_more.People.Career.tangmen;
import s18001020707.V1_more.People.Role;
import s18001020707.V1_more.Skill.Skill;
import s18001020707.V1_more.Skill.imp.CommonAttack;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameController {

    public void gogame() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        System.out.println("欢迎您来到本游戏，请输入你的名字");
        Scanner i=new Scanner(System.in);
        String username=i.nextLine();
        while (checkmgc(username)){
            System.out.println("您输入的id包含敏感词，请重新输入");
            username=i.nextLine();
        }
        System.out.println("输入成功");
        Role r=getrole(username,i);
        while (r==null){
            r=getrole(username,i);
        }
        int t=1;
        while (t==1){
            selectaction(r,i);
        }


    }
    public boolean checkmgc(String name){
        Filter1 f1=new Filter1();
        Filter2 f2=new Filter2();
        return f1.hasanyMGC(name)||f2.hasanyMGC(name);

    }

    public Role getrole(String username,Scanner scan){
        System.out.println("选择职业：1.少林派，2.峨眉派，3.唐门");
        String flag=scan.nextLine();
        Role r=null;
        switch (flag){
            case "1":
                r=Role.getRole(username,new shaolin());
                System.out.println("恭喜您加入"+r.getRoleCareer().toString());
                break;
            case "2":
                r=Role.getRole(username,new emei());
                System.out.println("恭喜您加入"+r.getRoleCareer().toString());
                break;
            case "3":
                r=Role.getRole(username,new tangmen());
                System.out.println("恭喜您加入"+r.getRoleCareer().toString());
                break;
            default:
                System.out.println("输入无效请重新选择");
        }
        return r;
    }

    public int selectaction(Role r,Scanner scanner) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        int flag=1;
        System.out.println("请输入数字代表你要做的行动：1.外出逛逛,2.查看人物状态，3.更换新手装备，4" +
                "更换新手防具，5.更换门派武器，6.更换门派防具，7.锻造武器,8.退出");
        String i =scanner.nextLine();
        switch (i){
            case "1":
                fight(r,scanner);
                break;
            case "2":
                System.out.println(r.toString());
                break;
            case "3":
                freshWeapon fw=new freshWeapon();
                r.setRoleWeapon(fw);
                System.out.println("更换成功,当前武器"+r.getRoleWeapon().toString()+"，当前武器攻击力"+r.getRoleWeapon().getAtk());

                break;
            case "4":
                r.setRoleClothes(new freshClothes());
                System.out.println("更换成功,当前防具"+r.getRoleClothes().toString()+"，当前防具防御力"+r.getRoleClothes().getDef());
                break;
            case "5":
                if (r.getRoleCareer().toString().equals("少林派")){
                    r.setRoleWeapon(new SL_gun());
                }
                if (r.getRoleCareer().toString().equals("峨眉派")){
                    r.setRoleWeapon(new EM_Chi());
                }
                if (r.getRoleCareer().toString().equals("唐门")){
                    r.setRoleWeapon(new TM_Biao());
                }
                System.out.println("更换成功,当前武器"+r.getRoleWeapon().toString()+"，当前武器攻击力"+r.getRoleWeapon().getAtk());
                break;
            case "6":
                r.setRoleClothes(new superiorClothes());
                System.out.println("更换成功,当前防具"+r.getRoleClothes().toString()+"，当前防具防御力"+r.getRoleClothes().getDef());
                break;
            case "7":
                r.getRoleWeapon().levelup();
                System.out.println("锻造成功，当前武器攻击力"+r.getRoleWeapon().getAtk());
                break;

            default:
                flag =0;

        }
        return flag;
    }

    public void fight(Role r,Scanner scanner) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        CloneEnemy cloneEnemy = new CloneEnemy();
        Random random = new Random();
        int ene = random.nextInt(100);
        Enemy enemy;
        if (ene>80){
            enemy = cloneEnemy.getEnemyclone("鬼怪妖魔");
        }else if (ene>50){
            enemy = cloneEnemy.getEnemyclone("歪门邪道");
        }else {
            enemy = cloneEnemy.getEnemyclone("落魄子弟");
        }
        System.out.println("遭遇"+enemy.getEnemyname()+"抢劫！");
        System.out.println(enemy.toString());
        System.out.println("请选择你的行动：1、锤他 2、逃跑 3、跪地求饶");
        String i = scanner.nextLine();
        switch (i){
            case "1":
                combat(r,scanner,enemy);
                break;
            case "2":
                System.out.println("你返回了城镇。");
                selectaction(r,scanner);
                break;
            case "3":
                System.out.println("他抢光了你的东西并杀死了你！游戏结束！");
                gogame();
                break;
            default:
            System.out.println("你返回了城镇。");
        }
    }

    public void combat(Role r,Scanner scanner,Enemy enemy) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        List<Skill> skills = r.getRoleSkill();
        CombatSystem combatSystem = new CombatSystem(enemy,r);
        Skill commom = new CommonAttack();
        while (true){
            System.out.println("请选择你要使用的攻击：1、"+commom.getName()+" 2、"+skills.get(0).getName()
                    + " 3、"+skills.get(1).getName() + " 4、" + skills.get(2).getName());
            int atk = 0;
            String i = scanner.nextLine();
            switch (i){
                case "1":
                    atk = r.attack(commom);
                    break;
                case "2":
                    atk = r.attack(skills.get(0));
                    break;
                case "3":
                    atk = r.attack(skills.get(1));
                    break;
                case "4":
                    atk = r.attack(skills.get(2));
                    break;
                default:
                    System.out.println("你放弃了攻击！");
            }
            int result = combatSystem.roleAttackEnemy(atk);
            if (result == 0){
                r.Victory();
                break;
            }else {
                System.out.println(enemy.toString());
                System.out.println("个人状态："+r.getState());
                int ss = combatSystem.EnemyAttackRole(enemy.Attack());
                Invoker invoker = new Invoker();
                SkillCommand skillCommand = new SkillCommand(commom);
                invoker.setCommand(skillCommand);
                invoker.buttonWatPressed(enemy.getEnemyname());
                if (ss == 0) {
                        gogame();
                        break;
                    }
                }
        }
        selectaction(r,scanner);
    }

}
