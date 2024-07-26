package keshe;

import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class student extends JFrame {
	JLabel jLabel;
	  JTextArea jArea;
	    Connection con = ConnectDb.connect();
	 	Statement sql; 
	    ResultSet rs;
	public student(String n1,String n2) {
		// TODO 自动生成的构造函数存根
		this.setLayout(new FlowLayout());
		this.setVisible(true);
		this.setSize(300,200);
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(2);
		jArea=new JTextArea();
		 jLabel=new JLabel("姓名"+"                "+"学号"+"                "+"成绩"+"                ");
		try { 
	          sql=con.createStatement();
	          rs=sql.executeQuery("SELECT *FROM student  where name like '"+ n1+"'"+" and id like'"+n2+"'"); //查询student表
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
	         
 
	} 
	catch(Exception ee)
				{
					ee.printStackTrace();
				}
		
		
		
		
		
	}

}
