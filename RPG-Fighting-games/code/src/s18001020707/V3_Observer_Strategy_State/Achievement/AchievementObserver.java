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
                System.out.println("****�ɾʹ�ɣ�С�����֣��״λ�ɱ"+this.enemy+"������****");
                break;
            case 3:
                System.out.println("****�ɾʹ�ɣ����гɾͣ���ɱ"+this.enemy+"3�Σ�����****");
                break;
            case 5:
                System.out.println("****�ɾʹ�ɣ�ɱ�����飺��ɱ"+this.enemy+"5�Σ�����****");
                break;
            case 10:
                System.out.println("****�ɾʹ�ɣ�����ս����ɱ"+this.enemy+"10�Σ�����****");
                break;
            default:
        }

}
}
