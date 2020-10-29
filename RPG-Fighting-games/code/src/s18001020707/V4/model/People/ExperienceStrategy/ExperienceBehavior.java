package s18001020707.V4.model.People.ExperienceStrategy;

public interface ExperienceBehavior {

    /*运用策略模式将各个等级进行划分为入门期、新手期、成长期、高手期，
    不同的时期在计算升级所需策略时通常不同，
    保证在角色在不同时期，升级所需的时长不同*/

    public abstract int useStage(int level);//阶段选择
}
