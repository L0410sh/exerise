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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class append extends JFrame implements ActionListener {
	JTextField  t1,t2,t3;
	JLabel j1,j2,j3;
    JButton  b;
   
	append()
	{
		j1 = new JLabel("姓名");
		j2 = new JLabel("学号");
		j3 = new JLabel("成绩");
		t1 =new JTextField(10);
		t2 =new JTextField(10);
		t3 =new JTextField(10);
		b= new JButton("提交");
		
		b.addActionListener(this);
		add(j1);
		add(t1);
		add(j2);
		add(t2);
		add(j3);
		add(t3);
		add(b);
		this.setLayout(new FlowLayout());
		this.setVisible(true);
		this.setSize(100,200);
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(2);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() ==b)
		{
			String name =t1.getText();
			String mina= t2.getText();
			String score=t3.getText();
			int k1 =Integer.parseInt(mina);
			int k2 =Integer.parseInt(score);
			Connection con = ConnectDb.connect();
			 Statement sql; 
			try { 
		          sql=con.createStatement();
		          String str= "insert into student values('"+name+"',"+k1+","+k2+")";
		          JFrame jFrame=new JFrame();
	             	jFrame.setAlwaysOnTop(true);
	             	JOptionPane.showMessageDialog( jFrame, "添加成功！！！",null , JOptionPane.INFORMATION_MESSAGE);
	             	t1.setText(null);
	             	t2.setText(null);
	             	t3.setText(null);
		          System.out.println(str);
		          int ok = sql.executeUpdate(str);
		         
		          
		          con.close();
			}catch(Exception ee)
			{
				ee.printStackTrace();
			}
	}
	}
}