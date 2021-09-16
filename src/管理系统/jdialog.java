import javax.swing.*;

public class jdialog {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> method()) ;

    }

    private static void method() {
        //创建窗口
        JFrame jf = new JFrame("内部行文管理系统");
        jf.setSize(400,400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        //创建jdialog对话框
        //JDialog(Frame owner , String title)
        JDialog jd = new JDialog(jf,"abc",true);//true 模态对话框
        jd.setDefaultCloseOperation(jd.HIDE_ON_CLOSE);
        jd.setSize(200,200);
        jd.setVisible(true);
    }
}
