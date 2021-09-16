import javax.swing.*;
import java.awt.*;

public class gridlayout {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> method());
    }
    private static void method() {
        //窗口
        JFrame jf = new JFrame("GridLayout");
        jf.setBounds(300, 200, 400, 400);
        //设置布局
        jf.setLayout(new GridLayout(4,3));

        for (int i = 1; i <= 9; i++){
            JButton jb = new JButton("jb"+ i);
            jf.add(jb);
        }




        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

    }
}
