import javax.swing.*;
import java.awt.*;

public class flowlayout {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> method());
    }

    private static void method() {
        //窗口
        JFrame jf = new JFrame("FlowLayout");
        jf.setBounds(300, 200, 400, 400);
        //指定布局
        jf.setLayout(new FlowLayout(FlowLayout.CENTER,20,30));
        //创建组件并加入容器
        jf.add(new JButton("第1个"));
        jf.add(new JButton("第2个"));
        jf.add(new JButton("第3个"));
        jf.add(new JButton("第4个"));
        jf.add(new JButton("第5个"));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
}