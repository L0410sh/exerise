package keshe;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class user extends JFrame implements ActionListener {
	     JButton jButton1,jButton2,jButton3,jButton4;
	     JLabel jLabel;
	public user() {
		// TODO 自动生成的构造函数存根
		 setDefaultCloseOperation(2);
	     setSize(630, 100);
	     setAlwaysOnTop(true);
	     setLocationRelativeTo(null);
	     setLayout(new FlowLayout());
	     
	     jLabel=new JLabel("请选择你想实现的功能");
	     jButton1=new JButton("添加学生信息");
	     jButton2=new JButton("修改学生信息");
	     jButton3=new JButton("删除学生信息");
	     jButton4=new JButton("检查学生信息");
	     add(jLabel);
	     add(jButton1);
	     add(jButton2);
	     add(jButton3);
	     add(jButton4);
	     jButton1.addActionListener(this);
	     jButton2.addActionListener(this);
	     jButton3.addActionListener(this);
	     jButton4.addActionListener(this);
	     setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if (e.getSource()==jButton1)
		{
			 new append();
		}
		if (e.getSource()==jButton2)
	    {  	
			new change();
			
		}
		if (e.getSource()==jButton3)
	    {  	
			new delete();
			
		}
		if (e.getSource()==jButton4)
	    {  	
			new see();
			
		}
	}
}

