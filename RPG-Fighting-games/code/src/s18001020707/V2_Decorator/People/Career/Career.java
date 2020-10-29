package s18001020707.V2_Decorator.People.Career;

import s18001020707.V2_Decorator.People.Role;
import s18001020707.V2_Decorator.Skill.Skill;

import java.util.List;

public interface Career {

    Void getMpdescription();

    Role addshuxing(Role role);

    List<Skill> getSkilllistl();

}
