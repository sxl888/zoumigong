package ch6.view;
import javax.swing.JButton;
import ch6.data.*;
import java.awt.event.*;
public class RandomMazeView extends MazeView implements ActionListener {
    JButton renew;                 //���¿�ʼ
    public RandomMazeView(Point[][] p){
       super(p);
       renew = new JButton("���Թ�");
       add(renew);
       renew.setSize(80,30);
       renew.setLocation(1,leftY);
       renew.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
       int m =point.length;
       int n =point[0].length;
       MazeMaker mazeMaker = new MazeByRandom(m,n);
       point= mazeMaker.initMaze();
       initPointXY();   
       initView();
       SetChargeOnRoad police = new  ChargeOnRoad();
       point = police.setChargeOnRoad(point,20);    //����20���շ�վ
       handleMove.recordTime.stop();
       handleMove.spendTime = 0;
       handleMove.showTime.setText("0");
       handleMove.isLeave = false;
       peopleWalker.cleanMoney();
       repaint();
       peopleWalker.requestFocusInWindow();
   }
}
