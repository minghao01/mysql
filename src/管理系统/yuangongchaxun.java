package 管理系统;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
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



class BackgroundPanel extends JPanel
{
    Image im;
    public BackgroundPanel(Image im)
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




public class yuangongchaxun {


    private static BackgroundPanel contentPane;

    public static void toAdd(final JFrame choice){
        contentPane=new BackgroundPanel((new ImageIcon("D:\\Java test\\mysql test\\src\\管理系统\\5AE2050F1B882D1CB49F6F4C6C6CF59A.jpg")).getImage());
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        contentPane.setSize( 1020, 550);
        final JFrame referStaff=new JFrame("员工信息查询修改");
        referStaff.setBounds(200, 200,1020, 550);
        referStaff.setLocationRelativeTo(referStaff.getOwner());

        referStaff.setVisible(true);
        JLabel title=new JLabel("员工档案",JLabel.CENTER);


        JButton foundAll=new JButton("查询所有记录");
        //	JButton delete=new JButton("删除该条信息");
        JButton back=new JButton("返回");






        Vector titleVector = new Vector();       //二维表标题部分
        final Vector staffVector = new Vector();     //二维表下部分
        titleVector.add("EMP_NO");
        titleVector.add("EMP_NAME");
        titleVector.add("DEPT_ID");
        titleVector.add("EMP_GENDER");
        titleVector.add("EMP_TELENO");
        titleVector.add("EMP_EMAIL");



        final JTable StaffJTable = new JTable(staffVector, titleVector);
        StaffJTable.setPreferredScrollableViewportSize(new Dimension(1000,250));
        JScrollPane staffJScrollPane = new JScrollPane(StaffJTable);
        //分别设置水平和垂直滚动条自动出现
        staffJScrollPane.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);   // 当需要时则出现滚动条
        staffJScrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);





        JPanel division1=new JPanel();
        JPanel division2=new  JPanel();
        JPanel division3=new  JPanel();
        JPanel division4=new  JPanel();
        JPanel division5=new  JPanel();
        JPanel division6=new  JPanel ();
        JPanel division7=new  JPanel ();


        JPanel top=new  JPanel();
        JPanel bottom=new  JPanel();


        division1.add(title,BorderLayout.SOUTH);
        division2.add(staffJScrollPane);

        division3.setLayout(new FlowLayout(FlowLayout.LEFT,15,0));



        division3.add(foundAll);


        division4.setLayout(new FlowLayout(FlowLayout.CENTER,12,10));


        division5.setLayout(new FlowLayout(FlowLayout.CENTER,12,10));



        division7.setLayout(new FlowLayout(FlowLayout.CENTER,12,10));


        division6.setLayout(new FlowLayout(FlowLayout.RIGHT,30,10));

        //	division6.add(delete);

        division6.add(back);
        division6.setVisible(true);



        top.add(division1);
        top.add(division2);
        bottom.setLayout(new GridLayout(5, 1));
        bottom.add(division3);
        bottom.add(division4);
        bottom.add(division5);
        bottom.add(division7);
        bottom.add(division6);


        // bottom.add(division6);
        //bottom.setLayout(new FlowLayout(FlowLayout.RIGHT));

        contentPane.setLayout(new GridLayout(2,1,20,0));
        contentPane.add(top);
        contentPane.add(bottom);
        //referStaff.setLayout(new GridLayout(2,1,20,0));
        //referStaff.add(top);
        //referStaff.add(bottom);
        referStaff.add(contentPane);
        top.setOpaque(false);
        division1.setOpaque(false);
        division2.setOpaque(false);
        bottom.setOpaque(false);
        division3.setOpaque(false);
        division4.setOpaque(false);
        division5.setOpaque(false);
        division6.setOpaque(false);
        division7.setOpaque(false);
        staffJScrollPane.setOpaque(false);
        StaffJTable.setOpaque(false);


        referStaff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        foundAll.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){

                queryAllProcess(staffVector,StaffJTable);

            }
        });


        back.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                referStaff.setVisible(false);
                choice.setVisible(true);
            }
        });


    }



    public static void queryAllProcess(Vector staffVector,JTable StaffJTable)
    {
        try{
            // 建立查询条件
            String sql = "select * from personnel;";
            System.out.println("queryAllProcess(). sql = " + sql);

            DbProcess.connect();


            // 将查询获得的记录数据，转换成适合生成JTable的数据形式


            DbProcess.executeQuery(sql);   //结果集ResultSet

            //	while(DbProcess.rs.next()){
            //	System.out.println(DbProcess.rs.getString("pName"));
            //}

            // 将查询获得的记录数据，转换成适合生成JTable的数据形式
            staffVector.clear();
            while(DbProcess.rs.next()){
                Vector v = new Vector();
                v.add(DbProcess.rs.getString("EMP_NO"));
                v.add(DbProcess.rs.getString("EMP_NAME"));
                v.add(DbProcess.rs.getString("DEPT_ID"));
                v.add(DbProcess.rs.getString("EMP_GENDER"));
                v.add(DbProcess.rs.getString("EMP_TELENO"));
                v.add(DbProcess.rs.getString("EMP_EMAIL"));
                ;

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
