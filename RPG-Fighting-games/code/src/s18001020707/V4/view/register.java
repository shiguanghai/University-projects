package s18001020707.V4.view;


import s18001020707.V4.model.People.Career.emei;
import s18001020707.V4.model.People.Career.shaolin;
import s18001020707.V4.model.People.Career.tangmen;
import s18001020707.V4.model.People.Role;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class register extends JFrame implements ActionListener {

    //定义注册界面的组件

    JPanel jpTitel,jpName,jpCareer,jpButtone=null;
    JLabel jlbTitle,jlbName,jlbCareer=null;//欢迎 昵称 职业
    JTextField jtfName=null;//昵称输入
    JRadioButton jrbSL,jrbEM,jrbTS=null;//少林派 峨眉派 唐门
    ButtonGroup bgCareer=null;//职业组
    JButton jbStart,jbReset,jbQuit=null;//开始 重置 退出

    public static void main(String[] args) {
        register r = new register();
    }

    //构造函数
    public register(){

        //创建组件
        jbStart=new JButton("开始");
        jbReset=new JButton("重置");
        jbQuit=new JButton("退出");
        //设置监听
        jbStart.addActionListener(this);
        jbReset.addActionListener(this);
        jbQuit.addActionListener(this);

        jrbSL=new JRadioButton("少林派",true);
        jrbEM=new JRadioButton("峨眉派");
        jrbTS=new JRadioButton("唐山");
        bgCareer=new ButtonGroup();
        bgCareer.add(jrbSL);
        bgCareer.add(jrbEM);
        bgCareer.add(jrbTS);

        jpTitel=new JPanel();
        jpName=new JPanel();
        jpCareer=new JPanel();
        jpButtone=new JPanel();

        jlbTitle=new JLabel("欢迎来到本游戏");
        jlbName=new JLabel("请输入你的名字：");
        jlbCareer=new JLabel("选择职业：");

        jtfName=new JTextField(10);

        //加入到Jpanel中
        jpTitel.add(jlbTitle);

        jpName.add(jlbName);
        jpName.add(jtfName);

        jpCareer.add(jlbCareer);
        jpCareer.add(jrbSL);
        jpCareer.add(jrbEM);
        jpCareer.add(jrbTS);

        jpButtone.add(jbStart);
        jpButtone.add(jbReset);
        jpButtone.add(jbQuit);

        //加入JFrame中
        this.add(jpTitel);
        this.add(jpName);
        this.add(jpCareer);
        this.add(jpButtone);
        //设置布局管理器
        this.setLayout(new GridLayout(4,1));
        //给窗口设置标题
        this.setTitle("游戏战斗系统(RPG小游戏)");
        //设置窗体大小
        this.setSize(400,200);
        //设置窗体初始位置
        this.setLocationRelativeTo(null);
        //设置当关闭窗口时，保证JVM也退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //显示窗体
        this.setVisible(true);
        this.setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand()=="退出"){
            System.exit(0);
        }else if(e.getActionCommand()=="开始"){
            //先判断用户名框是否存在元素，有的话 isEmpty返回false
            if(!jtfName.getText().isEmpty()){
                //创建角色
                Role r = getRole(jtfName.getText());
                while (r==null){
                    r = getRole(jtfName.getText());
                }
                //调用开始方法
                start(r);
            }else{
                //未输入用户名
                JOptionPane.showMessageDialog(null,"名字不能为空","消息提示",JOptionPane.WARNING_MESSAGE);
                this.clear();
            }
        }else if(e.getActionCommand()=="重置"){
            this.clear();
        }
    }

    //获取职业
    public Role getRole(String username){
        Role r=null;
        //职业选择
        if(jrbSL.isSelected()){
            //少林派
            r= Role.getRole(username,new shaolin());
        }else if(jrbEM.isSelected()){
            //峨眉派
            r= Role.getRole(username,new emei());
        }else if(jrbTS.isSelected()){
            //唐山
            r= Role.getRole(username,new tangmen());
        }
        return r;
    }

    //清空名字框
    private void clear() {
        jtfName.setText("");
    }

    //游戏开始
    public void start(Role r){
        JOptionPane.showMessageDialog(null,"恭喜您加入"+r.getRoleCareer().toString(),"提示消息",JOptionPane.WARNING_MESSAGE);
        this.clear();
        //关闭当前界面
        dispose();
        //创建一个新界面
        gameStart start = new gameStart(r);
    }
}
