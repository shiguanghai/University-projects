package s18001020707.V4.view;

import s18001020707.V4.model.Equipment.Weapon.imp.EM_Chi;
import s18001020707.V4.model.Equipment.Weapon.imp.SL_gun;
import s18001020707.V4.model.Equipment.Weapon.imp.TM_Biao;
import s18001020707.V4.model.Equipment.Weapon.skin.DazzlingSkin;
import s18001020707.V4.model.Equipment.Weapon.skin.DivineSkin;
import s18001020707.V4.model.People.Role;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class changeSkin extends JFrame implements ActionListener {
    //定义组件
    JButton jb1 = null;//更换
    JRadioButton jrb1,jrb2,jrb3=null;//无 炫彩皮肤(Lv2) 神级皮肤(Lv5)
    ButtonGroup bg=null;//皮肤组
    JLabel jlb1=null;//您要更换的皮肤：
    JPanel jp1,jp2=null;

    Role r=null;

    public changeSkin(Role role){
        r=role;
        jb1=new JButton("更换");
        jb1.addActionListener(this);

        jrb1=new JRadioButton("无",true);
        jrb2=new JRadioButton("炫彩皮肤(Lv2)");
        jrb3=new JRadioButton("神级皮肤(Lv5)");
        bg=new ButtonGroup();
        bg.add(jrb1);
        bg.add(jrb2);
        bg.add(jrb3);

        jp1=new JPanel();
        jp2=new JPanel();

        jlb1=new JLabel("您要更换的皮肤：");

        jp1.add(jlb1);
        jp1.add(jrb1);
        jp1.add(jrb2);
        jp1.add(jrb3);

        jp2.add(jb1);

        this.add(jp1);
        this.add(jp2);

        this.setLayout(new GridLayout(2,1));
        //给窗口设置标题
        this.setTitle("武器皮肤更换");
        //设置窗体大小
        this.setSize(400,100);
        //设置窗体初始位置
        this.setLocationRelativeTo(null);
        //显示窗体
        this.setVisible(true);
        this.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="更换"){
            if(jrb1.isSelected()){
                //无
                if(r.getRoleCareer().toString().equals("少林派")){
                    r.setRoleWeapon(new SL_gun());
                }else if(r.getRoleCareer().toString().equals("峨眉派")){
                    r.setRoleWeapon(new EM_Chi());
                }else if(r.getRoleCareer().toString().equals("唐门")){
                    r.setRoleWeapon(new TM_Biao());
                }
                gameStart.jlbWeapon.setText("武器:"+r.getRoleWeapon()+"  ");
                JOptionPane.showMessageDialog(null,"更换成功,当前武器"+r.getRoleWeapon().toString()+"，当前武器攻击力"+r.getRoleWeapon().getAtk(),"提示消息",JOptionPane.WARNING_MESSAGE);
            }else if(jrb2.isSelected()){
                //炫彩
                if(r.getLevel()>=2){
                    if(r.getRoleCareer().toString().equals("少林派")){
                        r.setRoleWeapon(new DazzlingSkin(new SL_gun()));
                    }else if(r.getRoleCareer().toString().equals("峨眉派")){
                        r.setRoleWeapon(new DazzlingSkin(new EM_Chi()));
                    }else if(r.getRoleCareer().toString().equals("唐门")){
                        r.setRoleWeapon(new DivineSkin(new EM_Chi()));
                    }
                    gameStart.jlbWeapon.setText("武器:"+r.getRoleWeapon()+"  ");
                    JOptionPane.showMessageDialog(null,"更换成功,当前武器"+r.getRoleWeapon().toString()+"，当前武器攻击力"+r.getRoleWeapon().getAtk(),"提示消息",JOptionPane.WARNING_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(null,"等级未达到","消息提示",JOptionPane.WARNING_MESSAGE);
                    dispose();
                }

            }else if(jrb3.isSelected()){
                //神级
                if(r.getLevel()>=5){
                    if(r.getRoleCareer().toString().equals("少林派")){
                        r.setRoleWeapon(new DivineSkin(new SL_gun()));
                    }else if(r.getRoleCareer().toString().equals("峨眉派")){
                        r.setRoleWeapon(new DivineSkin(new EM_Chi()));
                    }else if(r.getRoleCareer().toString().equals("唐门")){
                        r.setRoleWeapon(new DivineSkin(new TM_Biao()));
                    }
                    gameStart.jlbWeapon.setText("武器:"+r.getRoleWeapon()+"  ");
                    JOptionPane.showMessageDialog(null,"更换成功,当前武器"+r.getRoleWeapon().toString()+"，当前武器攻击力"+r.getRoleWeapon().getAtk(),"提示消息",JOptionPane.WARNING_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(null,"等级未达到","消息提示",JOptionPane.WARNING_MESSAGE);
                    dispose();
                }
            }
            dispose();
        }
    }
}
