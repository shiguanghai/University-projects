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

    //����ע���������

    JPanel jpTitel,jpName,jpCareer,jpButtone=null;
    JLabel jlbTitle,jlbName,jlbCareer=null;//��ӭ �ǳ� ְҵ
    JTextField jtfName=null;//�ǳ�����
    JRadioButton jrbSL,jrbEM,jrbTS=null;//������ ��ü�� ����
    ButtonGroup bgCareer=null;//ְҵ��
    JButton jbStart,jbReset,jbQuit=null;//��ʼ ���� �˳�

    public static void main(String[] args) {
        register r = new register();
    }

    //���캯��
    public register(){

        //�������
        jbStart=new JButton("��ʼ");
        jbReset=new JButton("����");
        jbQuit=new JButton("�˳�");
        //���ü���
        jbStart.addActionListener(this);
        jbReset.addActionListener(this);
        jbQuit.addActionListener(this);

        jrbSL=new JRadioButton("������",true);
        jrbEM=new JRadioButton("��ü��");
        jrbTS=new JRadioButton("��ɽ");
        bgCareer=new ButtonGroup();
        bgCareer.add(jrbSL);
        bgCareer.add(jrbEM);
        bgCareer.add(jrbTS);

        jpTitel=new JPanel();
        jpName=new JPanel();
        jpCareer=new JPanel();
        jpButtone=new JPanel();

        jlbTitle=new JLabel("��ӭ��������Ϸ");
        jlbName=new JLabel("������������֣�");
        jlbCareer=new JLabel("ѡ��ְҵ��");

        jtfName=new JTextField(10);

        //���뵽Jpanel��
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

        //����JFrame��
        this.add(jpTitel);
        this.add(jpName);
        this.add(jpCareer);
        this.add(jpButtone);
        //���ò��ֹ�����
        this.setLayout(new GridLayout(4,1));
        //���������ñ���
        this.setTitle("��Ϸս��ϵͳ(RPGС��Ϸ)");
        //���ô����С
        this.setSize(400,200);
        //���ô����ʼλ��
        this.setLocationRelativeTo(null);
        //���õ��رմ���ʱ����֤JVMҲ�˳�
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //��ʾ����
        this.setVisible(true);
        this.setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand()=="�˳�"){
            System.exit(0);
        }else if(e.getActionCommand()=="��ʼ"){
            //���ж��û������Ƿ����Ԫ�أ��еĻ� isEmpty����false
            if(!jtfName.getText().isEmpty()){
                //������ɫ
                Role r = getRole(jtfName.getText());
                while (r==null){
                    r = getRole(jtfName.getText());
                }
                //���ÿ�ʼ����
                start(r);
            }else{
                //δ�����û���
                JOptionPane.showMessageDialog(null,"���ֲ���Ϊ��","��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
                this.clear();
            }
        }else if(e.getActionCommand()=="����"){
            this.clear();
        }
    }

    //��ȡְҵ
    public Role getRole(String username){
        Role r=null;
        //ְҵѡ��
        if(jrbSL.isSelected()){
            //������
            r= Role.getRole(username,new shaolin());
        }else if(jrbEM.isSelected()){
            //��ü��
            r= Role.getRole(username,new emei());
        }else if(jrbTS.isSelected()){
            //��ɽ
            r= Role.getRole(username,new tangmen());
        }
        return r;
    }

    //������ֿ�
    private void clear() {
        jtfName.setText("");
    }

    //��Ϸ��ʼ
    public void start(Role r){
        JOptionPane.showMessageDialog(null,"��ϲ������"+r.getRoleCareer().toString(),"��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
        this.clear();
        //�رյ�ǰ����
        dispose();
        //����һ���½���
        gameStart start = new gameStart(r);
    }
}
