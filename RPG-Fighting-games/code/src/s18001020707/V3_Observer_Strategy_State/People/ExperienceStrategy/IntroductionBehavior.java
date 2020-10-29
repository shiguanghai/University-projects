package s18001020707.V3_Observer_Strategy_State.People.ExperienceStrategy;

public class IntroductionBehavior implements ExperienceBehavior {
    @Override
    public int useStage(int level) {
        //ÈëÃÅ½×¶Î 1:169 2:219 3:285
        return (int) (100*Math.pow(1.3,level+1));

    }
}
