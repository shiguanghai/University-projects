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
                System.out.println("****�ɾʹ�ɣ�С�����֣��״λ�ɱ"+this.enemy+"������****");
                JOptionPane.showMessageDialog(null,"****�ɾʹ�ɣ�С�����֣��״λ�ɱ"+this.enemy+"������****","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
                break;
            case 3:
                JOptionPane.showMessageDialog(null,"****�ɾʹ�ɣ����гɾͣ���ɱ"+this.enemy+"3�Σ�����****","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
                System.out.println("****�ɾʹ�ɣ����гɾͣ���ɱ"+this.enemy+"3�Σ�����****");
                break;
            case 5:
                JOptionPane.showMessageDialog(null,"****�ɾʹ�ɣ�ɱ�����飺��ɱ"+this.enemy+"5�Σ�����****","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
                System.out.println("****�ɾʹ�ɣ�ɱ�����飺��ɱ"+this.enemy+"5�Σ�����****");
                break;
            case 10:
                JOptionPane.showMessageDialog(null,"****�ɾʹ�ɣ�����ս����ɱ"+this.enemy+"10�Σ�����****","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
                System.out.println("****�ɾʹ�ɣ�����ս����ɱ"+this.enemy+"10�Σ�����****");
                break;
            default:
        }

}
}
