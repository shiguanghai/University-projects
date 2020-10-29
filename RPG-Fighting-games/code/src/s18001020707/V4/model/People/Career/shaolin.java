package s18001020707.V4.model.People.Career;

import s18001020707.V4.model.People.Role;
import s18001020707.V4.model.Skill.Skill;
import s18001020707.V4.model.Skill.imp.SL1;
import s18001020707.V4.model.Skill.imp.SL2;
import s18001020707.V4.model.Skill.imp.SL3;

import java.util.ArrayList;
import java.util.List;

public class shaolin extends Career {

    private String Careername="少林派";
    private int Atk=200;
    private int def=10;
    private int Strength=20;
    private int intl=10;
    private int speed=15;

    private List<Skill> skilllist=new ArrayList<>();

    public shaolin(){
        skilllist.add(new SL1());
        skilllist.add(new SL2());
        skilllist.add(new SL3());
    }

    @Override
    public List<Skill> getSkilllistl() {
        return skilllist;
    }

    @Override
    public Void getMpdescription() {
        System.out.println("力量很高的门派，使用少林棍法");
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
