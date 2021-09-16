package 管理系统;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class system {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> method());
    }

    private static void method() {
        JFrame jf = new JFrame();
        jf.setTitle("内部行文管理系统");
        jf.setSize(426, 300);
        jf.setLocation(497, 242);
        jf.setResizable(true);
        JPanel jp1, jp2, jp3, jp4;
        jp1 = new JPanel();
        jp4 = new JPanel();

        JLabel userid = new JLabel("账号");
        JTextField userid2 = new JTextField(10);
        jp1.add(userid);
        jp1.add(userid2);

        JLabel userPassword = new JLabel("密码");
        JPasswordField userPassword2 = new JPasswordField(10);
        jp2 = new JPanel();
        jp2.add(userPassword);
        jp2.add(userPassword2);

        JRadioButton users = new JRadioButton("用户登录", true);
        ButtonGroup group = new ButtonGroup();
        group.add(users);
        jp3 = new JPanel();
        jp3.add(users);
        JButton enter=new JButton("登录");
        JButton exit=new JButton("退出");
        jp4.add(enter);
        jp4.add(exit);

        jf.setLayout(new GridLayout(4, 1));
        jf.add(jp1);
        jf.add(jp2);
        jf.add(jp3);
        jf.add(jp4);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //监听器
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id= userid2.getText();
                String pd = userPassword2.getText();
                String user = "root";
                String url = "jdbc:mysql://localhost:3306/hmh_system?serverTimezone=GMT";
                String passsword = "hmh010329";;

                //注册驱动
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
                try {
                    //获取数据库连接
                    Connection con= DriverManager.getConnection(url,user,passsword);
                    //获取SQL语句执行者
                    PreparedStatement pstmt=con.prepareStatement("select * from user_pswd");

                    ResultSet rs = pstmt.executeQuery();
                    //处理结果集
                    int i = 0 , j = 0;
                    while (rs.next())
                    {
                        String NBXW_USER = rs.getString("NBXW_USER");
                        String NBXW_PSWD = rs.getString("NBXW_PSWD");

                        if (pd.equals(NBXW_PSWD)==true&&id.equals(NBXW_USER)==true){
                            break;
                        }
                        else{
                            i++;
                        }

                    }

                    if (i==3){
                        JDialog jd = new JDialog(jf,true);//true 模态对话框
                        jd.setDefaultCloseOperation(jd.HIDE_ON_CLOSE);
                        jd.setSize(200,200);
                        jd.setLocation(600, 300);
                        jd.setTitle("内部行文管理系统");
                        JLabel jl= new JLabel("输入错误");
                        JPanel jp5 = new JPanel();
                        jp5.add(jl);
                        jd.add(jp5);
                        jd.setResizable(true);
                        jd.setVisible(true);
                    }
                    else{
                        jf.setVisible(false);
                        choice.choose();
                    }

                    //释放资源
                    con.close();
                    pstmt.close();
                    rs.close();



                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
                jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });

        //关闭窗口时一同关闭java程序
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口可见
        jf.setVisible(true);
    }
}
