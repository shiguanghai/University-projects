package s18001020707.V4.model.People.ExperienceStrategy;

public class NoviceBehavior implements ExperienceBehavior {
    @Override
    public int useStage(int level) {
        //ÐÂÊÖ½×¶Î 4:556 5:724
        return (int) (150*Math.pow(1.3,level+1));

    }
}
