package keshe;

import java.awt.FlowLayout;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class delete extends JFrame implements ActionListener {
	    JButton b1;
	    JLabel j1;
	    JTextField t1;
	    JTextArea jArea;
	    JLabel jLabel;
	    Connection con = ConnectDb.connect();
     	Statement sql; 
	    ResultSet rs;
	public delete() {
		this.setLayout(new FlowLayout());
		this.setVisible(true);
		this.setSize(300,200);
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(2);
	    b1 = new JButton("确认");
	    t1 = new JTextField(10);
	    j1 = new JLabel("请输入需要删除学生的学号");
	    jArea=new JTextArea();
	    jLabel=new JLabel("姓名"+"                "+"学号"+"                "+"成绩"+"                ");
			try { 
		          sql=con.createStatement();
		          rs=sql.executeQuery("SELECT *FROM student ");//查询student表
		          while(rs.next()) {
			             String s1=rs.getString(1);
			             String s2=rs.getString(2);
			             String s3=rs.getString(3);
			             jArea.append(s1+"                ");
			             jArea.append(s2+"                ");
			             jArea.append(s3+"                ");
			             jArea.append("\n ");
			          }
		add(jLabel);          
	    add(jArea);
	    add(j1);
	    add(t1);
	   add(b1);
	   b1.addActionListener(this);

				// TODO 自动生成的构造函数存根
			}
			catch(Exception ee)
			{
				ee.printStackTrace();
			}	
	}
	
	
public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1)	{
			String n2 = t1.getText();
			
		          String str= "delete FROM student  where id ='"+n2+"'";
		          System.out.println(str);
		          JFrame jFrame=new JFrame();
	             	jFrame.setAlwaysOnTop(true);
	             	JOptionPane.showMessageDialog( jFrame, "删除成功！！！",null , JOptionPane.INFORMATION_MESSAGE);
		          try {
					int ok = sql.executeUpdate(str);
				} catch (SQLException e1) {
					  // TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
		          this.dispose();		          
		          try {
					con.close();
				} catch (SQLException e1) {
					  // TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
			
		}	
	
}

