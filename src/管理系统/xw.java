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



class BackgroundPanel4 extends JPanel
{
    Image im;
    public BackgroundPanel4(Image im)
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




public class xw {


    private static BackgroundPanel4 contentPane;
    static int count=0;



    public static void referStaff(final JFrame choice){
        contentPane=new BackgroundPanel4((new ImageIcon("D:\\Java test\\mysql test\\src\\管理系统\\8817BC70FCE74842AC52C9522D3DBC5A.jpg")).getImage());
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        contentPane.setSize( 1020, 550);
        final JFrame referStaff=new JFrame("行文发送");
        referStaff.setBounds(200, 200,1020, 550);
        referStaff.setLocationRelativeTo(referStaff.getOwner());

        referStaff.setVisible(true);
        JLabel title=new JLabel("行文档案",JLabel.CENTER);
        JLabel SelectField =new JLabel("输入");    //选择查询字段
        JLabel boring =new JLabel("=");         //=

        /*  属性值面板  */

        JLabel ID=new JLabel("XW_ID",JLabel.CENTER);
        JLabel NAME=new JLabel("XW_NAME",JLabel.CENTER);
        JLabel AUTHER=new JLabel("XW_AUTHER",JLabel.CENTER);
        JLabel CONTEXT=new JLabel("XW_CONTEXT",JLabel.CENTER);
        JLabel DATE=new JLabel("XW_DATE",JLabel.CENTER);
        JLabel FLA=new JLabel("XW_FLA",JLabel.CENTER);

        /*  输入输出框    */
        final JTextField XW_ID=new JTextField(10);
        final JTextField XW_NAME=new JTextField(10);
        final JTextField XW_AUTHER=new JTextField(10);
        final JTextField XW_CONTEXT=new JTextField(10);
        final JTextField XW_DATE=new JTextField(10);
        final JTextField XW_FLA=new JTextField(10);




        JButton found=new JButton("查询");
        JButton foundAll=new JButton("查询所有记录");
        JButton insert=new JButton("插入该条信息");
        insert.setVisible(true);
        JButton update=new JButton("更新该条信息");
        //	JButton delete=new JButton("删除该条信息");
        JButton back=new JButton("返回");


        JLabel Select =new JLabel("ID",JLabel.CENTER);


        final JTextField selectItem=new JTextField(10);

        Vector titleVector = new Vector();       //二维表标题部分
        final Vector staffVector = new Vector();     //二维表下部分
        titleVector.add("XW_ID");
        titleVector.add("XW_NAME");
        titleVector.add("XW_AUTHER");
        titleVector.add("XW_CONTEXT");
        titleVector.add("XW_DATE");
        titleVector.add("XW_FLA");



        final JTable StaffJTable = new JTable(staffVector, titleVector);
        StaffJTable.setPreferredScrollableViewportSize(new Dimension(1000,250));
        JScrollPane staffJScrollPane = new JScrollPane(StaffJTable);
        //分别设置水平和垂直滚动条自动出现
        staffJScrollPane.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);   // 当需要时则出现滚动条
        staffJScrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        StaffJTable.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                int row = ((JTable) e.getSource()).rowAtPoint(e.getPoint()); // 获得行位置
                System.out.println("mouseClicked(). row = " + row);
                Vector v = new Vector();
                v = (Vector) staffVector.get(row);

                XW_ID.setText((String) v.get(0));
                XW_NAME.setText((String) v.get(1));
                XW_AUTHER.setText((String) v.get(2));
                XW_CONTEXT.setText((String) v.get(3));
                XW_DATE.setText((String) v.get(4));
                XW_FLA.setText((String) v.get(5));


            }
        });



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
        division3.add(SelectField);
        division3.add(Select);
        division3.add(boring);
        division3.add(selectItem);
        division3.add(found);
        division3.add(foundAll);


        division4.setLayout(new FlowLayout(FlowLayout.CENTER,12,10));

        division4.add(ID);
        division4.add(XW_ID);
        division4.add(NAME);
        division4.add(XW_NAME);
        division4.add(AUTHER);
        division4.add(XW_AUTHER);


        division5.setLayout(new FlowLayout(FlowLayout.CENTER,12,10));
        division5.add(CONTEXT);
        division5.add(XW_CONTEXT);
        division5.add(DATE);
        division5.add(XW_DATE);
        division5.add(FLA);
        division5.add(XW_FLA);


        division6.setLayout(new FlowLayout(FlowLayout.RIGHT,30,10));
        division6.add(insert);
        division6.add(update);
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

        found.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                if(!selectItem.getText().isEmpty()){
                    String sQueryField = selectItem.getText().trim();

                    queryProcess(sQueryField,staffVector,StaffJTable);
                }
            }
        });

        foundAll.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){

                String sQueryField = selectItem.getText().trim();

                queryAllProcess(staffVector,StaffJTable);

            }
        });

        insert.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                if(!XW_ID.getText().isEmpty()){
                    count=refercount()+1;
                    String pId =String.valueOf(count);
                    String pID = XW_ID.getText().trim();
                    String pNAME= XW_NAME.getText().trim();
                    String pAUTHER= XW_AUTHER.getText().trim();
                    String pCONTEXT = XW_CONTEXT.getText().trim();
                    String pDATE= XW_DATE.getText().trim();
                    String pFLA = XW_FLA.getText().trim();


                    addProcess(pID,pNAME,pAUTHER,pCONTEXT,pDATE,pFLA);
                    queryAllProcess(staffVector,StaffJTable);
                }

            }
        });

        update.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                if(!XW_NAME.getText().isEmpty()){
                    String pID = XW_ID.getText().trim();
                    String pNAME= XW_NAME.getText().trim();
                    String pAUTHER= XW_AUTHER.getText().trim();
                    String pCONTEXT = XW_CONTEXT.getText().trim();
                    String pDATE= XW_DATE.getText().trim();
                    String pFLA = XW_FLA.getText().trim();

                    UpdateProcess(pID,pNAME,pAUTHER,pCONTEXT,pDATE,pFLA);
                    queryAllProcess(staffVector,StaffJTable);
                    JOptionPane.showMessageDialog(null, "更新成功","提示",JOptionPane.INFORMATION_MESSAGE);
                    XW_ID.setText("");
                    XW_NAME.setText("");
                    XW_AUTHER.setText("");
                    XW_CONTEXT.setText("");
                    XW_DATE.setText("");
                    XW_FLA.setText("");

                }
                else
                    JOptionPane.showMessageDialog(null, "请确认修改项！！","提示",JOptionPane.ERROR_MESSAGE);
            }
        });


        back.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                referStaff.setVisible(false);
                choice.setVisible(true);
            }
        });


    }

    public static void queryProcess(String sQueryField,Vector staffVector,JTable StaffJTable){
        try{
            String sql=null;

            sql = "select XW_ID,XW_NAME,XW_AUTHER,XW_CONTEXT,XW_DATE,XW_FLA from xw where ";
            sql = sql + "XW_ID";
            sql = sql + " like ";
            sql = sql + "'" +'%' +sQueryField +'%' +"';";

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
                v.add(DbProcess.rs.getString("XW_ID"));
                v.add(DbProcess.rs.getString("XW_NAME"));
                v.add(DbProcess.rs.getString("XW_AUTHER"));
                v.add(DbProcess.rs.getString("XW_CONTEXT"));
                v.add(DbProcess.rs.getString("XW_DATE"));
                v.add(DbProcess.rs.getString("XW_FLA"));


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

    public static void queryAllProcess(Vector staffVector,JTable StaffJTable)
    {
        try{
            // 建立查询条件
            String sql = "select * from xw;";
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
                v.add(DbProcess.rs.getString("XW_ID"));
                v.add(DbProcess.rs.getString("XW_NAME"));
                v.add(DbProcess.rs.getString("XW_AUTHER"));
                v.add(DbProcess.rs.getString("XW_CONTEXT"));
                v.add(DbProcess.rs.getString("XW_DATE"));
                v.add(DbProcess.rs.getString("XW_FLA"));



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

    public static void  UpdateProcess(String pID, String pNAME, String pAUTHER, String pCONTEXT, String pDATE, String pFLA)
    {
        //int QNo=yuangongchaxun.refercount();
        // String qNo=String.valueOf(QNo+1);
        String sql = "update xw set XW_NAME = '";
        sql = sql +  pNAME + "', XW_AUTHER = '";
        sql = sql + pAUTHER + "', XW_CONTEXT = '";
        sql = sql + pCONTEXT+ "', XW_DATE = '";
        sql = sql + pDATE + "', XW_FLA = '";
        sql = sql + pFLA + "'";
        sql = sql + " WHERE XW_ID = '" +  pID + "';";
        System.out.println("updateProcess(). sql = " + sql);
        try{
            if (DbProcess.executeUpdate(sql) < 1) {
                System.out.println("updateProcess(). update database failed.");
            }
        }catch(Exception e){
            System.out.println("e = " + e);
            JOptionPane.showMessageDialog(null,
                    "数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void  addProcess(String pID, String pNAME, String pAUTHER, String pCONTEXT, String pDATE, String pFLA)
    {
        String sql="insert into xw values('";
        sql=sql+pID+"','";
        sql=sql+pNAME+"','";
        sql=sql+pAUTHER+"','";
        sql=sql+pCONTEXT+"','";
        sql=sql+pDATE+"','";
        sql=sql+pFLA+"');";


        System.out.println("addProcess().sql="+sql);
        try{
            if (DbProcess.executeUpdate(sql) < 1) {
                System.out.println("addProcess(). add database failed.");
            }
            else
            {System.out.println("插入成功！！！");


            }
        }catch(Exception e){
            System.out.println("e = " + e);
            JOptionPane.showMessageDialog(null,
                    "数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
        }
    }


    public static  int refercount(){
        try{
            // 建立查询条件
            String sql = "select * from xw";
            System.out.println("queryAllProcess(). sql = " + sql);

            DbProcess.connect();
            ResultSet rs = DbProcess.executeQuery(sql);

            // 将查询获得的记录数据，转换成适合生成JTable的数据形式

            while(rs.next()){
                count++;
            }
            System.out.println("已有行文： "+(count));

        }catch(SQLException sqle){
            System.out.println("sqle = " + sqle);
            JOptionPane.showMessageDialog(null,
                    "数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
        }
        return count;
    }

}
