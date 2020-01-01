package ch6.view;
import javax.swing.JButton;
import ch6.data.*;
import java.awt.event.*;
import java.io.*;
public class FixedMazeView extends MazeView implements ActionListener {
    JButton again;                 //��һ��
    public FixedMazeView(Point[][] p){
       super(p);
       again = new JButton("����");
       add(again);
       again.setSize(80,30);
       again.setLocation(1,leftY);
       again.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
       int m =point.length;
       int n =point[0].length;
       MazeMaker mazeMaker = new MazeByFile(new File("�Թ��ļ�/����Թ�.txt"));
       point= mazeMaker.initMaze();
       initPointXY();   
       initView();
       SetChargeOnRoad police = new  ChargeOnRoad();
       police.setMAXMoney(10);
       point = police.setChargeOnRoad(point,6);    //����6���շ�վ
       handleMove.recordTime.stop();
       handleMove.spendTime = 0;
       handleMove.showTime.setText("0");
       handleMove.isLeave = false;
       peopleWalker.cleanMoney();
       repaint();
       peopleWalker.requestFocusInWindow();
   }
}
