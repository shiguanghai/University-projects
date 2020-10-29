package s18001020707.V4.model.People.Career;

import s18001020707.V4.model.People.ExperienceStrategy.ExperienceBehavior;
import s18001020707.V4.model.People.ExperienceStrategy.IntroductionBehavior;
import s18001020707.V4.model.People.Role;
import s18001020707.V4.model.Skill.Skill;

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

    public abstract Void getMpdescription();//����

    public abstract Role addshuxing(Role role);//����

    public abstract List<Skill> getSkilllistl();//����

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
