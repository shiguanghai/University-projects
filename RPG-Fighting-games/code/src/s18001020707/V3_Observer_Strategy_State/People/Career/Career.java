package s18001020707.V3_Observer_Strategy_State.People.Career;

import s18001020707.V3_Observer_Strategy_State.People.ExperienceStrategy.ExperienceBehavior;
import s18001020707.V3_Observer_Strategy_State.People.ExperienceStrategy.IntroductionBehavior;
import s18001020707.V3_Observer_Strategy_State.People.Role;
import s18001020707.V3_Observer_Strategy_State.Skill.Skill;

import java.util.List;

public abstract class Career {

    protected ExperienceBehavior experience;

    public Career(ExperienceBehavior experience) {
        super();
        this.experience = experience;
    }

    public Career() {
        super();
        this.experience = new IntroductionBehavior();
    }

    public abstract Void getMpdescription();//√Ë ˆ

    public abstract Role addshuxing(Role role);// Ù–‘

    public abstract List<Skill> getSkilllistl();//ººƒ‹

    public void setExperience(ExperienceBehavior experience) {
        this.experience = experience;
    }
    public ExperienceBehavior getExperience() {
        return experience;
    }
    public int useStage(int level){
        return experience.useStage(level);
    }
}
