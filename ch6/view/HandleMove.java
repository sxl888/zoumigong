package ch6.view;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import ch6.data.Point;
public class HandleMove extends JPanel implements KeyListener,ActionListener {  
    Point [][] p;
    int spendTime=0;
    javax.swing.Timer recordTime; //��ʱ��
    JTextField showTime;     
    Toolkit tool;            //��������������
    PersonInMaze person;
    boolean isLeave = false; //�ж��Ƿ��Ѿ��뿪����
    int out_i,out_j;         //��ų��ڵ�λ������
    HandleMove(){
       recordTime=new javax.swing.Timer(1000,this);
       showTime=new JTextField("0",5);
       tool=getToolkit(); 
       showTime.setEditable(false);
       showTime.setHorizontalAlignment(JTextField.CENTER);
       add(new JLabel("��ʱ��:"));
       add(showTime);
       setBackground(Color.cyan);
    } 
    public void setMazePoint(Point [][] point){
        p=point;
    }
    public void initSpendTime(){
       recordTime.stop();
       spendTime=0;
       showTime.setText(null);
    }
    public void keyPressed(KeyEvent e){
        recordTime.start();
        person=(PersonInMaze)e.getSource();
        int m=-1,n=-1;
        Point startPoint=person.getAtMazePoint();
        for(int i=0;i<p.length;i++){
            for(int j=0;j<p[i].length;j++){
               if(startPoint.equals(p[i][j])){
                  m=i;
                  n=j;
                  break;
               }
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_UP){
           int k=Math.max(m-1,0);
           if(p[k][n].isRoad()){
             tool.beep(); //����ཱུ�һ��
             person.setAtMazePoint(p[k][n]);
             person.setLocation(p[k][n].getX(),p[k][n].getY());
             if(p[k][n].getIsCharge()) {
                charseMoney(p[k][n]); //��������շѷ���charseMoney
             }
           }
        }
        else if(e.getKeyCode()==KeyEvent.VK_DOWN){
           int k=Math.min(m+1,p.length-1);
           if(p[k][n].isRoad()) {
             tool.beep();
             person.setAtMazePoint(p[k][n]);
             person.setLocation(p[k][n].getX(),p[k][n].getY());
             if(p[k][n].getIsCharge())
                charseMoney(p[k][n]);
           }
        }
        else if(e.getKeyCode()==KeyEvent.VK_LEFT){
           int k=Math.max(n-1,0);
           if(p[m][k].isRoad()){
             tool.beep();
             person.setAtMazePoint(p[m][k]);
             person.setLocation(p[m][k].getX(),p[m][k].getY());
             if(p[m][k].getIsCharge())
                charseMoney(p[m][k]);
           }
        } 
        else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
           int k=Math.min(n+1,p[0].length-1);
           if(p[m][k].isRoad()){
             tool.beep();
             person.setAtMazePoint(p[m][k]);
             person.setLocation(p[m][k].getX(),p[m][k].getY());
             if(p[m][k].getIsCharge())
                charseMoney(p[m][k]);
           }
        }
    } 
    public void actionPerformed(ActionEvent e){
          spendTime++;
          showTime.setText("��ʱ:"+spendTime+"��");
    } 
    public void keyReleased(KeyEvent e){
        if(isLeave == true)
           return;
        PersonInMaze person=(PersonInMaze)e.getSource();
        int m=-1,n=-1;
        Point endPoint=person.getAtMazePoint();
        if(endPoint.isOut()){
          String str=JOptionPane.showInputDialog(this,"��������·�ѣ����֣�","�շ�վ����",
                                              JOptionPane.PLAIN_MESSAGE);
          int number = 0;
          try {
               number = Integer.parseInt(str.trim());
          }
          catch(Exception exp){
               JOptionPane.showMessageDialog(this,"�����ò��ԣ������½������","��Ϣ��",
                                       JOptionPane.INFORMATION_MESSAGE );
          }
          if(number == person.getMoney()){
                recordTime.stop();
                JOptionPane.showMessageDialog(this,"�������뿪����","��Ϣ��",
                                       JOptionPane.INFORMATION_MESSAGE );
                int x=p[p.length-1][p[0].length-1].getX()+person.getBounds().width;
                int y=p[p.length-1][p[0].length-1].getY()+person.getBounds().height;
                person.setLocation(x,y);
                isLeave = true;
                person.cleanMoney();
          }
          else {
                 JOptionPane.showMessageDialog(this,"�����ò��ԣ������½������","��Ϣ��",
                                       JOptionPane.INFORMATION_MESSAGE );
          }
       }
    }
    public void charseMoney(Point p){
        int money = p.getChargeMoney();
        person.setMoney(money);
    }
    public void keyTyped(KeyEvent e) {}
}