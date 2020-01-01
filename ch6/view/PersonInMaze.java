package ch6.view;
import javax.swing.*;
import ch6.data.Point;
import java.awt.*;
public class PersonInMaze extends JTextField{
   Point point;  //���ڵĵ�
   Toolkit tool;
   int money;    //����ȡ��ȫ��Ǯ
   PersonInMaze(){
      tool=getToolkit();
      setEditable(false);
      setBorder(null);
      setOpaque(false);
      setToolTipText("������,Ȼ�󰴼��̷����");
      requestFocusInWindow();
   }
   public void setAtMazePoint(Point p){
      point = p;
   }
   public Point getAtMazePoint(){
      return point;
   }
   public void setMoney(int m){
      money += m;
   }
   public void cleanMoney(){
      money = 0;
   }
   public int getMoney(){
      return money;
   }
   public void paintComponent(Graphics g){
      super.paintComponent(g);
      int w=getBounds().width;
      int h=getBounds().height; 
      Image image=tool.getImage("�Թ��ļ�/person.gif");  
      g.drawImage(image,0,0,w,h,this);
  } 
}