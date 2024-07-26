package keshe;

import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class see extends JFrame {
	JLabel jLabel;
	  JTextArea jArea;
	    Connection con = ConnectDb.connect();
	 	Statement sql; 
	    ResultSet rs;
	    public see() {
	    	this.setLayout(new FlowLayout());
			this.setVisible(true);
			this.setSize(300,200);
			this.setAlwaysOnTop(true);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(2);
			// TODO 自动生成的构造函数存根
	    	jArea=new JTextArea();
	    	jLabel=new JLabel("姓名"+"                "+"学号"+"                "+"成绩"+"                ");
		    
			try { 
		          sql=con.createStatement();
		          rs=sql.executeQuery("SELECT *FROM student "); //查询student表
		          while(rs.next()) {
			             String s1=rs.getString(1);
			             String s2=rs.getString(2);
			             String s3=rs.getString(3);
			             jArea.append(s1+"                ");
			             jArea.append(s2+"                ");
			             jArea.append(s3+"                ");
			             jArea.append("\n ");
			          }
		         
	   
		} 
		catch(Exception ee)
					{
						ee.printStackTrace();
					}
	    	add(jLabel);
			add(jArea);
}
}
