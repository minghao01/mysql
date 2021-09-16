import javax.swing.*;
import java.awt.*;

public class borderlayout {
    public static void main(String[] args) {
        //创建窗口
        SwingUtilities.invokeLater(() -> method());
    }

    private static void method() {
        JFrame jf = new JFrame("布局管理器");
        //设置当前窗口用哪一种布局 -> 边界布局
        jf.setLayout(new BorderLayout());
        jf.setSize(400,300);
        jf.setLocation(200,300);

        //创建5个组件（按钮组件）
        JButton jb1 =new JButton("首页");
        JButton jb2 =new JButton("账号");
        JButton jb3 =new JButton("密码");
        JButton jb4 =new JButton("注册");
        JButton jb5 =new JButton("登入");

        //将组件加入容器
        jf.add(jb1,BorderLayout.PAGE_START);
        jf.add(jb2,BorderLayout.PAGE_END);
        jf.add(jb3,BorderLayout.LINE_START);
        jf.add(jb4,BorderLayout.LINE_END);
        jf.add(jb5,BorderLayout.CENTER);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }


}
