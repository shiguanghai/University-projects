package s18001020707.V2_Decorator.Command;

import s18001020707.V2_Decorator.Skill.Skill;

public class SkillCommand implements Command {
    private Skill skill;

    public SkillCommand(Skill skill){
        this.skill = skill;
    }

    @Override
    public void execute(String username) {
        skill.getSkill(username);
    }
}
