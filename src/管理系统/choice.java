package 管理系统;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;


public class choice {


        public static void choose(){

            final JFrame choice=new JFrame("操作选择");
            choice.setBounds(600, 200, 260, 400);
            choice.setLocationRelativeTo(choice.getOwner());

            choice.setLayout(null);
            choice.setVisible(true);





            JButton addStaff=new JButton("员工档案查询");
            JButton change=new JButton(" 部门查询 ");
            JButton refer=new JButton("行文发送与修改");
            JButton referRecord=new JButton("行文接收与处理");
            addStaff.setBounds(50, 50, 160, 35);
            change.setBounds(50, 120, 160, 35);
            refer.setBounds(50, 190, 160, 35);
            referRecord.setBounds(50, 260, 160, 35);
            choice.add(addStaff);
            choice.add(change);
            choice.add(refer);
            choice.add(referRecord);
            addStaff.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e){
                    choice.setVisible(false);
                    yuangongchaxun.toAdd(choice);
                }
            });
            change.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e){
                    choice.setVisible(false);
                    bumenchaxun.changes(choice);
                }
            });
            refer.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e){
                    choice.setVisible(false);
                    xw.referStaff(choice);
                }
            });
            referRecord.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e){
                    choice.setVisible(false);
                    xwcl.referRecord(choice);
                }
            });

            choice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }


