package keshe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class startInterface extends JFrame {
    public startInterface() {
        //初始化窗口大小于位置（设置为居中）
        setSize(630,340);
        setResizable(false);
        setLocationRelativeTo(null);
        //设置标题
        setTitle("welcome to the DJTU");
        //设置界面置顶
        setAlwaysOnTop(true);
        //设置窗口关闭程序停止运行
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //设置界面背景照片
        JLabel label = new JLabel(new ImageIcon("picture/教务首页.png"));
        label.setSize(630, 246);
        getLayeredPane().add(label,Integer.MIN_VALUE);
        JPanel panel = (JPanel) getContentPane();
        panel.setOpaque(false);
        panel.setLayout(null);
        //添加学校官网地址
        JTextField text = new JTextField("http://www.djtu.edu.cn/");
        text.setSize(630,20);
        Font font = new Font("Times New Roman", Font.PLAIN, 20);
        text.setFont(font);
        text.setEditable(false);
        text.setHorizontalAlignment(JTextField.CENTER);
        text.setLocation(0,280);
        add(text);
        //添加按钮(学校简介  登录教务)
        JButton button1 = new JButton("School resume");
        JButton button2 = new JButton("Academic affairs");
        button1.setSize(315,30);
        button2.setSize(315,30);
        button1.setLocation(0,246);
        button2.setLocation(315,246);
        add(button1);
        add(button2);
        //设置界面显示
        setVisible(true);
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new academicAffairs();
            }
        });
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new schoolResume(1);
            }
        });
    }
}
