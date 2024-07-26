package keshe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class schoolResume  extends JFrame implements ActionListener {
        JMenuBar menuBar = new JMenuBar();
        JMenuItem Menu1 = new JMenuItem("学校概括");
        JMenuItem Menu2 = new JMenuItem("招生");
        JMenuItem Menu3 = new JMenuItem("校历");
        JComboBox<?> jBox1=null;
		JComboBox<?> jBox2=null;
		JComboBox<?> jBox3=null;
		JComboBox<?> jBox4=null;
		
    schoolResume() {
		//初始化界面
        initialize();
		//菜单
        menuBar.add(Menu1);
        menuBar.add(Menu2);
        menuBar.add(Menu3);
        setJMenuBar(menuBar);
        Menu1.addActionListener(this);
        Menu2.addActionListener(this);
        Menu3.addActionListener(this);
    }
    schoolResume(int m){
    	schoolOverview();
    }

    private void initialize() {
        setSize(630, 500);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        final JLabel[] label = new JLabel[1];
        label[0] = new JLabel();
        int number=0;
        cycle(label, number);
    }

	public void cycle(final JLabel[] label, int number) {
		while(number<1000){
			setLayout(new BorderLayout());
            int time=1000;
            Timer timer = new Timer(time,new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ImageIcon imageIcon=new ImageIcon("C:\\Users\\19687\\Desktop\\lsh\\picture\\school��1��.png");
                    label[0].setIcon(imageIcon);
                }
            });
            timer.start();
            label[0].setSize(630,179);
            label[0].setVisible(true);
            add(label[0],BorderLayout.NORTH);
        Timer timer3 = new Timer(time+2500,new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 ImageIcon imageIcon=new ImageIcon("C:\\Users\\19687\\Desktop\\lsh\\picture\\school��2��.png");
                 label[0].setIcon(imageIcon);

            }
        });
        timer3.start();
        label[0].setSize(630,180);
        add(label[0],BorderLayout.NORTH);
        label[0].setVisible(true);
        Timer timer1 = new Timer(time+3500,new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon imageIcon=new ImageIcon("C:\\Users\\19687\\Desktop\\lsh\\picture\\school��3��.png");
                label[0].setIcon(imageIcon);

            }
        });
        timer1.start();
        label[0].setSize(630,175);
        add(label[0],BorderLayout.NORTH);
        label[0].setVisible(true);
        number+=1;
    }
	}
    @Override
    public void actionPerformed(ActionEvent e) {
        Object object = e.getSource();
        action(object);
    }

    private void action(Object object) {
        if (object == Menu1) {
            dispose();
            schoolOverview();
        }
        if (object == Menu2) {
            dispose();
            recruitStudents();

        }
        if (object == Menu3) {
            dispose();
            schoolCalendar();

        }
    }
	public void schoolCalendar() {
		JFrame jFrame3 = new schoolResume();
		JLabel jLabel=new JLabel(new  ImageIcon("C:\\Users\\19687\\Desktop\\lsh\\picture\\schoolCalender.jpg"));
		//添加滚轮
		JPanel panel = new JPanel();
		panel.setBounds(20, 20, 300, 300);
		panel.setLayout(new BorderLayout());
		panel.add(jLabel, BorderLayout.CENTER);
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(20, 20, 300, 300);
		scrollPane1.getViewport().add(panel);
		//水平隐藏，垂直显示
		scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jFrame3.add(scrollPane1);
		jFrame3.setVisible(true);
	}
	public void recruitStudents() {
		JFrame jFrame2 = new schoolResume();
		jFrame2.setLayout(new FlowLayout());
		JLabel jLabel1 = new JLabel();
		jLabel1.setText("历年招生计划");
		jLabel1.setSize( 50, 20);
		String []n1= {"请选择年份","2024","2023","2022","2021","2020","2019","2018","2017"};
		String []n2= {"请选择省会","北京","天津","河北","山西","内蒙古","辽宁","吉林","黑龙江"};
		jBox1=new JComboBox<Object>(n1);
		jBox2=new JComboBox<Object>(n2);
		jBox3=new JComboBox<Object>(n1);
		jBox4=new JComboBox<Object>(n2);
		JButton jButton1=new JButton("查询");
		JButton jButton2=new JButton("查询");
		JLabel jLabel2 = new JLabel();
		jLabel2.setText("历年录取分数");
		jLabel1.setSize(50, 20);
		jLabel1.setSize(50, 20);
		jFrame2.add(jLabel1);
		jFrame2.add(jBox1);
		jFrame2.add(jBox2);
		jFrame2.add(jButton1);
		jFrame2.add(new JLabel("                                                                  "));
		jFrame2.add(jLabel2);
		jFrame2.add(jBox3);
		jFrame2.add(jBox4);
		jFrame2.add(jButton2);
		jFrame2.add(new JLabel("                                                                  "));
		jButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			    subinterface1();
			}
		});
		jButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				subinterface2();
			}
		});
		jFrame2.setVisible(true);
	} 
	public void subinterface1() {
     Connection con = ConnectDb.connect();
	 Statement sql; 
     ResultSet rs;
     try { 
    	String n1=(String) jBox1.getSelectedItem();
		String n2= (String) jBox2.getSelectedItem();
         sql=con.createStatement();
         rs=sql.executeQuery("SELECT * FROM school1"); //查询school1表
         while(rs.next()) {
            String nn=rs.getString(1);
            int ps=rs.getInt(2);
            if(n2.equals(nn) && n1.equals(ps+""))
            {
           	new Frame1(n1,n2);
           	break;
            }
            else {
           	System.out.println("2312123");
			}
         }
         con.close();
     }
     catch(SQLException eee) { 
     }  
	}
	public void subinterface2() {
	     Connection con = ConnectDb.connect();
		 Statement sql; 
	     ResultSet rs;
	     try { 
	    	String n1=(String) jBox3.getSelectedItem();
			String n2= (String) jBox4.getSelectedItem();
	         sql=con.createStatement();
	         rs=sql.executeQuery("SELECT * FROM school2"); //查询school2表
	         while(rs.next()) {
	            String nn=rs.getString(1);
	            int ps=rs.getInt(2);
	            if(n2.equals(nn) && n1.equals(ps+""))
	            {
	           	new Frame2(n1,n2);
	           	
	            }
	            else {
	           	
				}
	         }
	         con.close();
	     }
	     catch(SQLException eee) { 
	     }   
		}
	public void schoolOverview() {
		JFrame jFrame1 = new schoolResume();
		JTextArea textArea = new JTextArea(new StringBuilder().append("大连交通大学是东北地区唯一一所以轨道交通为特色的高等学校。1956年，学校应我国铁道机车车辆工业的发展需要而创建，时为大连机车车辆制造学校。1958年升格为大连铁道学院，隶属原铁道部管理。2000年2月，划转为辽宁省政府管理。2004年5月，更名为大连交通大学。\n").append("在长期的办学历程中，学校始终坚守大学使命，坚持服务区域经济社会、轨道交通行业发展和国家战略需求，形成了“明德求索、锲而不舍”的校训，培养了十余万名毕业生，大多数毕业生在轨道交通行业就业，部分已成为了行业领军人物和核心技术骨干，在业内享有“中国轨道交通装备制造业工程师摇篮”的美誉。\n").append("学校现有沙河口校区、旅顺口校区两个校区，占地总面积82.1万平方米，校舍建筑总面积54.6万平方米。教学科研仪器设备总值4.47亿元，馆藏文献资源总量为132.32万册，电子图书159.24万册，中外文电子期刊41254种。\n").append("学校具有博士、硕士、学士学位授予权，是辽宁省一流学科重点建设高校。机械工程、材料科学与工程2个学科是辽宁省高等学校一流学科；机械工程、材料科学与工程、交通运输工程3个学科是省一级重点学科。拥有机械工程、材料科学与工程2个博士后科研流动站，一级学科博士授权点2个，一级学科硕士授权点13个，硕士专业学位授权点6个，50个本科专业，5个五年制双专业，涵盖了工、管、文、理、法、艺6个学科门类。目前全日制在校生19349人，其中，本科生16084人，硕士、博士研究生3265人。\n").append("学校具有推荐优秀应届本科毕业生免试攻读研究生资格，是教育部第二批实施卓越工程师教育培养计划高校、国家软件人才国际培训（大连）基地、国家级人才培养模式创新实验区、全国建设高水平运动队院校和体育文化研究基地、辽宁省车辆工程紧缺本科人才培养基地、辽宁省对日服务外包人才培养基地和大连东北亚国际航运人才培训基地。2006年10月，以“优秀”的成绩通过了教育部本科教学工作水平评估。学校现有国家级一流本科专业建设点16个，国家级综合改革试点专业2个、教育部卓越工程师教育培养计划试点专业5个、中国工程教育认证专业10个；省级一流本科专业建设点4个，省级一流本科教育示范专业、特色专业、重点支持专业、综合改革试点专业、工程人才培养模式改革试点专业、国际化试点专业、应用型转型专业、创新创业教育改革试点等建设点46项。拥有国家级现代产业学院1个、省级现代产业学院5个；国家级虚拟仿真实验教学中心1个、国家级工程实践教育中心4个，省级实验教学示范中心17个、省级大学生校外实践教育基地14个；国家级一流本科课程5门，省级一流课程160门。\n").append("学校现有教职工1421人，其中专任教师队伍1032人，具有硕博士学位的教师占比91%，双师双能型教师占比27%，其中高级职称教师占比54%，45岁以下中青年教师占比55%。学校现有国家级人才项目人选5人，省部级优秀教师、教学名师36人、省级课程思政教学名师和团队5个；省优秀青年骨干教师22人；省级教学团队8个，其中辽宁省高校黄大年式教师团队2个。\n").append("学校是国家产学研合作先进单位，是辽宁省产学研合作创新基地。发起成立了“中国轨道交通装备制造创新联盟”，牵头成立了“辽宁省轨道交通产业校企联盟”“连续挤压产业创新联盟”。建有国家级大学科技园、国家地方联合工程研究中心、教育部工程中心、国家技术转移示范机构、辽宁省高等学校产业研究院等国家级、省部级科技平台、社科基地、智库等40个。2018年以来，学校承担国家重点研发计划、国家自然科学基金、国家社会科学基金等国家级项目98项，获批省部级项目525项；获得省部级以上奖励25项；出版学术著作175部，获授权发明专利334项。\n").append("学校是中国政府奖学金来华留学生接收院校、《中美人才培养计划》121项目创新人才培养实验基地。先后与澳大利亚、美国、日本、俄罗斯等24个国家和地区的100余所院校和教育科研机构建立了校际合作关系。学校经教育部批准设立中外合作办学机构——大连交通大学远交大交通学院。拥有中外合作办学本科教育项目3个，建有中日友好大连人才培训中心。\n").append("学校先后获评“辽宁省高等学校先进党组织”，成为“全省党建工作示范高校”培育创建单位。学校是全国大学生暑期社会实践先进单位，在全国大学生艺术展演活动中两次获得优秀组织奖，“青年马克思主义者百千万培养工程”等两项成果被评为教育部高校校园文化建设优秀成果，获评“全国铁路五四红旗团委”“辽宁省五四红旗团委”。\n").append("新时代，学校坚持以习近平新时代中国特色社会主义思想为指导，深入学习贯彻党的二十大精神，紧紧围绕辽宁实现新时代全面振兴、全方位振兴和现代轨道交通装备制造业发展，抓牢“一带一路”倡议、“交通强国”等发展机遇，全面深入实施学校“十四五”发展规划，全力加快推进学校“双一流”建设，开创学校高质量发展新局面。\n").append("\n").append("\n").append("\n").append("（数据截至2023年10月）\n").toString());
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		//��ӹ���
		JPanel panel = new JPanel();
		panel.setBounds(20, 20, 300, 300);
		panel.setLayout(new BorderLayout());
		panel.add(textArea, BorderLayout.CENTER);
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(20, 20, 300, 300);
		scrollPane1.getViewport().add(panel);
		//水平隐藏，垂直显示
		scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jFrame1.add(scrollPane1);
		jFrame1.setVisible(true);
	}
}


