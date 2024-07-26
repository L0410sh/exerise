package keshe;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

public class academicAffairs extends JFrame implements ActionListener{
	JLabel j1,j2,j3;
	JTextField t1,t2;
	JButton b1,b2;
	JRadioButton b3,b4;
	ButtonGroup group=new ButtonGroup();
    academicAffairs()
    {
		//初始化界面
        extracted();
        
        setVisible(true);
    }

    private void extracted() {
        setTitle("Academic Affairs");
        j3=new JLabel(new ImageIcon("C:\\Users\\19687\\Desktop\\lsh\\picture\\jiaowu.png") );
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(630,500);
        setAlwaysOnTop(true);
  	    this.setLayout(new FlowLayout());
  	    j1 = new JLabel("用户名");
  	    j2 = new JLabel("密码");
  	    t1= new JTextField(10);
  	    t2= new JTextField(10);
  	    b1 =new JButton("登录");
  	    b2 =new JButton("重置");
  	    b3=new JRadioButton("教师");
  	    b4=new JRadioButton("学生");
  	    b1.addActionListener(this);
  	    b2.addActionListener(this);
  	    add(j3);
  	    add(j1);
  	    add(t1);
  	    add(j2);
  	    add(t2);
  	    add(b1);
  	    add(b2);
  	    add(b3);
  	    add(b4);
  	    group.add(b3);
  	    group.add(b4);
  	    b3.addActionListener(this);
  	    b4.addActionListener(this);
  	    setLocationRelativeTo(null);
    }
	//登录
    public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == b1&&b4.isSelected())
		{
			String name =t1.getText();
			String mina= t2.getText();
			Connection con = ConnectDb.connect();
			 Statement sql; 
		     ResultSet rs;
			try { 
		          sql=con.createStatement();
		          rs=sql.executeQuery("SELECT * FROM student"); //查询student表
		          while(rs.next()) {
		             String nn=rs.getString(1);
		             int ps=rs.getInt(2);
		             if(name.equals(nn) && mina.equals(ps+""))
		             {
		            	 //----------------
		            	new student(name,mina);
		            	 this.dispose();
		            	 break;
		             }
		             else {
		            	 JFrame jFrame=new JFrame();
		             	jFrame.setAlwaysOnTop(true);
		             	JOptionPane.showMessageDialog( jFrame, "用户名或密码错误！！！", "发生错误！！！", JOptionPane.ERROR_MESSAGE);
		             	t1.setText(null);
		    			t2.setText(null);
					}
		          }
		          con.close();
		      }
		      catch(SQLException eee) { 
		      } 
		}
		else if(e.getSource() == b1&&b3.isSelected())
		{
			String name =t1.getText();
			String mina= t2.getText();
			Connection con = ConnectDb.connect();
			 Statement sql; 
		     ResultSet rs;
			try { 
		          sql=con.createStatement();
		          rs=sql.executeQuery("SELECT * FROM user"); //查询user表
		          while(rs.next()) {
		             String nn=rs.getString(1);
		             int ps=rs.getInt(2);
		             if(name.equals(nn) && mina.equals(ps+""))
		             {
		            	 //----------------
		            	 
		             	 new user();
		            	 break;
		             }
		             else {
		            	 JFrame jFrame=new JFrame();
		             	jFrame.setAlwaysOnTop(true);
		             	JOptionPane.showMessageDialog( jFrame, "用户名或密码错误！！！", "发生错误！！！", JOptionPane.ERROR_MESSAGE);
		             	t1.setText(null);
		    			t2.setText(null);
					}
		          }
		          con.close();
		      }
		      catch(SQLException eee) { 
		      } 	
		}
    else if(e.getSource()==b2)
		{
			t1.setText(null);
			t2.setText(null);
			
		}
    }
}
