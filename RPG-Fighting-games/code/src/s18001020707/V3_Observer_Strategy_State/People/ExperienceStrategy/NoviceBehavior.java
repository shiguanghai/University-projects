package s18001020707.V3_Observer_Strategy_State.People.ExperienceStrategy;

public class NoviceBehavior implements ExperienceBehavior {
    @Override
    public int useStage(int level) {
        //���ֽ׶� 4:556 5:724
        return (int) (150*Math.pow(1.3,level+1));

    }
}
