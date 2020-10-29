package s18001020707.V4.view;

import s18001020707.V4.model.Enemys.Enemy;
import s18001020707.V4.model.People.Role;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class fight extends JFrame implements ActionListener {

    //定义组件
    JButton jb1 = null;//确定
    JRadioButton jrb1,jrb2,jrb3=null;//锤他 逃跑 跪地求饶
    ButtonGroup bg=null;//行动组
    JLabel jlb1,jlb2=null;//怪物信息  请选择您的行动：
    JPanel jp1,jp2,jp3=null;

    Role r=null;
    Enemy en=null;

    public fight(Role role,Enemy enemy){
        r=role;
        en=enemy;

        jb1=new JButton("确定");
        jb1.addActionListener(this);

        jrb1=new JRadioButton("锤他",true);
        jrb2=new JRadioButton("逃跑");
        jrb3=new JRadioButton("跪地求饶");
        bg=new ButtonGroup();
        bg.add(jrb1);
        bg.add(jrb2);
        bg.add(jrb3);

        jp1=new JPanel();
        jp2=new JPanel();
        jp3=new JPanel();

        jlb1=new JLabel(en.toString());
        jlb2=new JLabel("请选择您的行动");

        jp1.add(jlb1);

        jp2.add(jlb2);
        jp2.add(jrb1);
        jp2.add(jrb2);
        jp2.add(jrb3);

        jp3.add(jb1);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);

        this.setLayout(new GridLayout(3,1));
        //给窗口设置标题
        this.setTitle("行动选择");
        //设置窗体大小
        this.setSize(360,150);
        //设置窗体初始位置
        this.setLocationRelativeTo(null);
        //显示窗体
        this.setVisible(true);
        this.setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="确定"){
            if(jrb1.isSelected()){
                //锤他
                combat c = new combat(r,en);
                c.setVisible(true);
                dispose();

            }else if(jrb2.isSelected()){
                //逃跑
                JOptionPane.showMessageDialog(null,"你返回了城镇。","提示消息",JOptionPane.WARNING_MESSAGE);
                dispose();

            }else if(jrb3.isSelected()){
                //跪地求饶
                JOptionPane.showMessageDialog(null,"他抢光了你的东西并杀死了你！游戏结束！","提示消息",JOptionPane.WARNING_MESSAGE);
                System.exit(0);

            }
        }

    }

}
