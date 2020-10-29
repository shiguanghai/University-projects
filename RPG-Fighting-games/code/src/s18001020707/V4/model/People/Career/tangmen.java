package s18001020707.V4.model.People.Career;

import s18001020707.V4.model.People.Role;
import s18001020707.V4.model.Skill.Skill;
import s18001020707.V4.model.Skill.imp.TM1;
import s18001020707.V4.model.Skill.imp.TM2;
import s18001020707.V4.model.Skill.imp.TM3;

import java.util.ArrayList;
import java.util.List;

public class tangmen extends Career {

    private String Careername="����";
    private int Atk=80;
    private int def=120;
    private int Strength=10;
    private int intl=15;
    private int speed=20;

    private List<Skill> skilllist=new ArrayList<>();

    public tangmen(){
        // TODO: 2019/3/24 �Ѽ��ܼӽ�ȥ
        skilllist.add(new TM1());
        skilllist.add(new TM2());
        skilllist.add(new TM3());
    }

    @Override
    public List<Skill> getSkilllistl() {
        return skilllist;
    }

    @Override
    public Void getMpdescription() {
        System.out.println("�����ܸߵ����ɣ�ʹ�ö�ü��");
        return null;
    }

    @Override
    public Role addshuxing(Role role) {
        role.setAtk(role.getAtk()+this.Atk);
        role.setDef(role.getDef()+this.def);
        role.setStrength(role.getStrength()+this.Strength);
        role.setIntl(role.getIntl()+this.intl);
        role.setSpeed(role.getSpeed()+this.speed);
        return role;
    }

    @Override
    public String toString() {
        return Careername;
    }


}
