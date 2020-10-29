package s18001020707.V4.model.Achievement;

import javax.swing.*;

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
                JOptionPane.showMessageDialog(null,"****成就达成：小试身手：首次击杀"+this.enemy+"！！！****","提示消息",JOptionPane.WARNING_MESSAGE);
                break;
            case 3:
                JOptionPane.showMessageDialog(null,"****成就达成：略有成就：击杀"+this.enemy+"3次！！！****","提示消息",JOptionPane.WARNING_MESSAGE);
                System.out.println("****成就达成：略有成就：击杀"+this.enemy+"3次！！！****");
                break;
            case 5:
                JOptionPane.showMessageDialog(null,"****成就达成：杀敌如麻：击杀"+this.enemy+"5次！！！****","提示消息",JOptionPane.WARNING_MESSAGE);
                System.out.println("****成就达成：杀敌如麻：击杀"+this.enemy+"5次！！！****");
                break;
            case 10:
                JOptionPane.showMessageDialog(null,"****成就达成：身经百战：击杀"+this.enemy+"10次！！！****","提示消息",JOptionPane.WARNING_MESSAGE);
                System.out.println("****成就达成：身经百战：击杀"+this.enemy+"10次！！！****");
                break;
            default:
        }

}
}
