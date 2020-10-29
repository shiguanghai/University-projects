package s18001020707.V4.model.Command;

import s18001020707.V4.model.Skill.Skill;

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
