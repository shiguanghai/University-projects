package s18001020707.V4.model.Achievement;

import javax.swing.*;

public class KillEnemysEvent extends KillEnemys {

    @Override
    public int notify(String enemy, int death) {
        death++;
        JOptionPane.showMessageDialog(null,enemy+"����ɱ��","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
        System.out.println(enemy+"����ɱ��");
        return death;
    }
}
