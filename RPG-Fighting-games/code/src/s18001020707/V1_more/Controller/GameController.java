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
        System.out.println("��ӭ����������Ϸ���������������");
        Scanner i=new Scanner(System.in);
        String username=i.nextLine();
        while (checkmgc(username)){
            System.out.println("�������id�������дʣ�����������");
            username=i.nextLine();
        }
        System.out.println("����ɹ�");
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
        System.out.println("ѡ��ְҵ��1.�����ɣ�2.��ü�ɣ�3.����");
        String flag=scan.nextLine();
        Role r=null;
        switch (flag){
            case "1":
                r=Role.getRole(username,new shaolin());
                System.out.println("��ϲ������"+r.getRoleCareer().toString());
                break;
            case "2":
                r=Role.getRole(username,new emei());
                System.out.println("��ϲ������"+r.getRoleCareer().toString());
                break;
            case "3":
                r=Role.getRole(username,new tangmen());
                System.out.println("��ϲ������"+r.getRoleCareer().toString());
                break;
            default:
                System.out.println("������Ч������ѡ��");
        }
        return r;
    }

    public int selectaction(Role r,Scanner scanner) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        int flag=1;
        System.out.println("���������ִ�����Ҫ�����ж���1.������,2.�鿴����״̬��3.��������װ����4" +
                "�������ַ��ߣ�5.��������������6.�������ɷ��ߣ�7.��������,8.�˳�");
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
                System.out.println("�����ɹ�,��ǰ����"+r.getRoleWeapon().toString()+"����ǰ����������"+r.getRoleWeapon().getAtk());

                break;
            case "4":
                r.setRoleClothes(new freshClothes());
                System.out.println("�����ɹ�,��ǰ����"+r.getRoleClothes().toString()+"����ǰ���߷�����"+r.getRoleClothes().getDef());
                break;
            case "5":
                if (r.getRoleCareer().toString().equals("������")){
                    r.setRoleWeapon(new SL_gun());
                }
                if (r.getRoleCareer().toString().equals("��ü��")){
                    r.setRoleWeapon(new EM_Chi());
                }
                if (r.getRoleCareer().toString().equals("����")){
                    r.setRoleWeapon(new TM_Biao());
                }
                System.out.println("�����ɹ�,��ǰ����"+r.getRoleWeapon().toString()+"����ǰ����������"+r.getRoleWeapon().getAtk());
                break;
            case "6":
                r.setRoleClothes(new superiorClothes());
                System.out.println("�����ɹ�,��ǰ����"+r.getRoleClothes().toString()+"����ǰ���߷�����"+r.getRoleClothes().getDef());
                break;
            case "7":
                r.getRoleWeapon().levelup();
                System.out.println("����ɹ�����ǰ����������"+r.getRoleWeapon().getAtk());
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
            enemy = cloneEnemy.getEnemyclone("�����ħ");
        }else if (ene>50){
            enemy = cloneEnemy.getEnemyclone("����а��");
        }else {
            enemy = cloneEnemy.getEnemyclone("�����ӵ�");
        }
        System.out.println("����"+enemy.getEnemyname()+"���٣�");
        System.out.println(enemy.toString());
        System.out.println("��ѡ������ж���1������ 2������ 3���������");
        String i = scanner.nextLine();
        switch (i){
            case "1":
                combat(r,scanner,enemy);
                break;
            case "2":
                System.out.println("�㷵���˳���");
                selectaction(r,scanner);
                break;
            case "3":
                System.out.println("����������Ķ�����ɱ�����㣡��Ϸ������");
                gogame();
                break;
            default:
            System.out.println("�㷵���˳���");
        }
    }

    public void combat(Role r,Scanner scanner,Enemy enemy) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        List<Skill> skills = r.getRoleSkill();
        CombatSystem combatSystem = new CombatSystem(enemy,r);
        Skill commom = new CommonAttack();
        while (true){
            System.out.println("��ѡ����Ҫʹ�õĹ�����1��"+commom.getName()+" 2��"+skills.get(0).getName()
                    + " 3��"+skills.get(1).getName() + " 4��" + skills.get(2).getName());
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
                    System.out.println("������˹�����");
            }
            int result = combatSystem.roleAttackEnemy(atk);
            if (result == 0){
                r.Victory();
                break;
            }else {
                System.out.println(enemy.toString());
                System.out.println("����״̬��"+r.getState());
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
