package 管理系统;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


class BackgroundPanel6 extends JPanel
{
    Image im;
    public BackgroundPanel6(Image im)
    {
        this.im=im;
        this.setOpaque(false);                    //设置控件不透明,若是false,那么就是透明
    }
    //Draw the background again,继承自Jpanle,是Swing控件需要继承实现的方法,而不是AWT中的Paint()
    public void paintComponent(Graphics g)       //绘图类
    {
        super.paintComponents(g);
        g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);  //绘制指定图像中当前可用的图像。图像的左上角位于该图形上下文坐标空间的 (x, y)。图像中的透明像素不影响该处已存在的像素

    }
}


public class bumenchaxun {


    private static BackgroundPanel6 contentPane;
    static String a1="";
    static String b1="";
    static String c1="";


    //static Vector<Vector<String>> staffVector = null ;
    //static JTable StaffJTable = null;
    public static void changes(final JFrame choice){

        contentPane=new BackgroundPanel6((new ImageIcon("D:\\Java test\\mysql test\\src\\管理系统\\F56684E74CB31681D226D03184DEB6E6.jpg")).getImage());
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        contentPane.setSize( 500, 380);


        final JFrame changes=new JFrame("人事变更");
        changes.setBounds(600, 350, 500, 380);
        changes.setLocationRelativeTo(changes.getOwner());

        changes.setVisible(true);
        //changes.setLayout(new GridLayout(4,1,20,25));
        contentPane.setLayout(new GridLayout(4,1,20,25));

        JLabel SelectNo=new JLabel("请输入DEPT_ID：");
        final JTextField Selectno=new JTextField(10);
        JButton found=new JButton("查询");


        Vector titleVector = new Vector();       //二维表标题部分
        final Vector staffVector = new Vector();     //二维表下部分

        titleVector.add("DEPT_NAME");
        titleVector.add("DEPT_MANAGER");
        titleVector.add("DEPT_VICEMANAGER");

        final JTable StaffJTable = new JTable(staffVector, titleVector);
        StaffJTable.setPreferredScrollableViewportSize(new Dimension(385,100));

        JScrollPane staffJScrollPane = new JScrollPane(StaffJTable);
        //分别设置水平和垂直滚动条自动出现
        staffJScrollPane.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);   // 当需要时则出现滚动条
        staffJScrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);


        final JTextField alter=new JTextField(10);

        JButton back=new JButton("返回");


        JPanel division1=new  JPanel();
        division1.setLayout(new FlowLayout(FlowLayout.CENTER,5,20));
        division1.add(SelectNo);
        division1.add(Selectno);
        division1.add(found);

        JPanel division2=new  JPanel();
        division2.add(staffJScrollPane);


        JPanel division4=new  JPanel();
        division4.add(back);
        division4.setLayout(new FlowLayout(FlowLayout.CENTER,70,0));

        contentPane.add(division1);
        contentPane.add(division2);
        contentPane.add(division4);

        division1.setOpaque(false);
        division2.setOpaque(false);
        division4.setOpaque(false);

        changes.add(contentPane);

        back.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                changes.setVisible(false);
                choice.setVisible(true);
            }
        });

        found.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                if(!Selectno.getText().isEmpty()){
                    String sQueryField = Selectno.getText().trim();

                    queryProcess(sQueryField,staffVector,StaffJTable);
                    System.out.println(a1+" "+b1+" "+c1);
                }


            }
        });


        changes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static   void queryProcess(String sQueryField,Vector staffVector,JTable StaffJTable ){

        try{
            String sql = "select DEPT_ID,DEPT_NAME,DEPT_MANAGER,DEPT_VICEMANAGER from dept where ";
            String queryFieldStr = "DEPT_ID";




            sql = sql + queryFieldStr;
            sql = sql + " = ";
            sql = sql + "'" + sQueryField + "';";


            System.out.println("queryProcess(). sql = " + sql);

            DbProcess.connect();

            DbProcess.executeQuery(sql);   //结果集ResultSet

            //	while(DbProcess.rs.next()){
            //	System.out.println(DbProcess.rs.getString("pName"));
            //}

            // 将查询获得的记录数据，转换成适合生成JTable的数据形式
            staffVector.clear();
            while(DbProcess.rs.next()){
                Vector v = new Vector();
                System.out.println(DbProcess.rs.getString("DEPT_ID"));
                v.add(DbProcess.rs.getString("DEPT_NAME"));
                v.add(DbProcess.rs.getString("DEPT_MANAGER"));
                v.add(DbProcess.rs.getString("DEPT_VICEMANAGER"));
                staffVector.add(v);
            }
            StaffJTable.updateUI();
            DbProcess.disconnect();
        }catch(SQLException sqle){
            System.out.println("sqle = " + sqle);
            JOptionPane.showMessageDialog(null,
                    "数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
        }catch(Exception e){
            System.out.println("e = " + e);
            JOptionPane.showMessageDialog(null,
                    "数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
        }
    }




}
