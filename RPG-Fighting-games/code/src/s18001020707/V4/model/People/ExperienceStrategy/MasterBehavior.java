package s18001020707.V4.model.People.ExperienceStrategy;

public class MasterBehavior implements ExperienceBehavior {
    @Override
    public int useStage(int level) {
        //¸ßÊÖ½×¶Î 9:8650 10:12975
        return (int) (150*Math.pow(1.5,level+1));

    }
}
