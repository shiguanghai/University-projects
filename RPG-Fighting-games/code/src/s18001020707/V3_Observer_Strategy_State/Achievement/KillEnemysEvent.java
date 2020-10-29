package s18001020707.V3_Observer_Strategy_State.Achievement;

public class KillEnemysEvent extends KillEnemys {

    @Override
    public int notify(String enemy, int death) {
        death++;
        System.out.println(enemy+"±»»÷É±£¡");
        return death;
    }
}
