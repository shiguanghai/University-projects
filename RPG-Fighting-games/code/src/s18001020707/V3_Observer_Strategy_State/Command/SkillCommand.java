package s18001020707.V3_Observer_Strategy_State.Command;

import s18001020707.V3_Observer_Strategy_State.Skill.Skill;

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
