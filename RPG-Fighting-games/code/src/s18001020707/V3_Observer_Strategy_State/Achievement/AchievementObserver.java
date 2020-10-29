package s18001020707.V3_Observer_Strategy_State.Achievement;

public class AchievementObserver implements Observer {
    private int death;
    private String enemy;

    public AchievementObserver(String enemy) {
        this.death = 0;
        this.enemy = enemy;
    }

    public int getDeath() {
        return death;
    }
    public void setDeath(int death) {
        this.death = death;
    }
    public String getEnemy() {
        return enemy;
    }
    public void setEnemy(String enemy) {
        this.enemy = enemy;
    }

    @Override
    public void response() {
        switch(this.death){
            case 1:
                System.out.println("****成就达成：小试身手：首次击杀"+this.enemy+"！！！****");
                break;
            case 3:
                System.out.println("****成就达成：略有成就：击杀"+this.enemy+"3次！！！****");
                break;
            case 5:
                System.out.println("****成就达成：杀敌如麻：击杀"+this.enemy+"5次！！！****");
                break;
            case 10:
                System.out.println("****成就达成：身经百战：击杀"+this.enemy+"10次！！！****");
                break;
            default:
        }

}
}
