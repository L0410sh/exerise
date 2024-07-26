package keshe;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class Frame1 extends JFrame{
	JButton jLabel1,jLabel2,jLabel3,jLabel4,jLabel5,jLabel6;
	JTextArea jArea;
	  Connection con = ConnectDb.connect();
	  Statement sql; 
      ResultSet rs;
	 Frame1(String n1,String n2) {
		 setSize(630, 500);
		 GridBagLayout layout= new GridBagLayout();
	     setLayout(layout);
	     GridBagConstraints c=new GridBagConstraints();
	     c.fill=GridBagConstraints.BOTH;
	     c.weightx=100;
	     c.weighty=190000;
	     setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	     setAlwaysOnTop(true);
	     setLocationRelativeTo(null);
		 jLabel1=new JButton("专业名称");
		 jLabel2=new JButton("科类");
		 jLabel3=new JButton("批次");
		 jLabel4=new JButton("学制");
		 jLabel5=new JButton("计划");
		 jLabel6=new JButton("收费标准");
		 jArea=new JTextArea();
		 layout.setConstraints(jLabel1, c);
		 layout.setConstraints(jLabel2, c);
		 layout.setConstraints(jLabel3, c);
		 layout.setConstraints(jLabel4, c);
		 layout.setConstraints(jLabel5, c);
		 c.gridwidth=GridBagConstraints.REMAINDER;
		 layout.setConstraints(jLabel6, c);
		 add(jLabel1);
		 add(jLabel2);
		 add(jLabel3);
		 add(jLabel4);
		 add(jLabel5);
		 add(jLabel6);
		 c.weightx=0;
		 c.weighty=0;
		 layout.setConstraints(jArea, c);
		 add(jArea);
		 try { 
	          sql=con.createStatement();
	          rs=sql.executeQuery("SELECT *FROM school1  where 年份 like '"+ n1+"'"+" and 省份 like'"+n2+"'"); //查询school1表
			 while(rs.next()) {
	             String s1=rs.getString(3);
	             String s2=rs.getString(4);
	             String s3=rs.getString(5);
	             String s4=rs.getString(6);
	             String s5=rs.getString(7);
	             String s6=rs.getString(8);
	             jArea.append(s1+"                ");
	             jArea.append(s2+"                ");
	             jArea.append(s3+"                ");
	             jArea.append(s4+"                ");
	             jArea.append(s5+"                ");
	             jArea.append(s6+"                ");
	             jArea.append("\n ");
	          }
	          con.close();
	      }
	      catch(SQLException eee) { 
	      } 
		 pack();
	    setVisible(true);
		
	}

}
