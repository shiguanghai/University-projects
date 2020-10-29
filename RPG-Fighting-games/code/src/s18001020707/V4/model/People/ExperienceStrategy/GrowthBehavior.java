package s18001020707.V4.model.People.ExperienceStrategy;

public class GrowthBehavior implements ExperienceBehavior {
    @Override
    public int useStage(int level) {
        //³É³¤½×¶Î 6:1700 7:2562 8:3844
        return (int) (100*Math.pow(1.5,level+1));
    }
}
