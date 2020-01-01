package ch6.view;
import javax.swing.*;
import ch6.data.Point;
import java.awt.*;
import java.awt.geom.*;
public class MazeView extends JPanel {
    public Point [][] point;        //��Ҫ��ͼ���Թ�
    Rectangle2D [][] block;        //�Թ���·��ǽ����ͼ
    int width = 22;                //·��ǽ�Ŀ��
    int height =22;
    int leftX = 80;                //���ƫ������
    int leftY = 50;
    PersonInMaze peopleWalker;     //���Թ���
    HandleMove  handleMove;        //����������
    public MazeView(Point[][] p){
       point = p; 
       peopleWalker = new PersonInMaze();
       handleMove = new HandleMove();
       initPointXY();  //������ͼ�������õ������
       handleMove.setMazePoint(point);
       block = new Rectangle2D[point.length][point[0].length];
       setLayout(null);
       JPanel pNorth = new JPanel();
       add(handleMove);
       add(peopleWalker);
       handleMove.setSize(120,30);
       handleMove.setLocation(leftX,leftY/3);
       peopleWalker.setSize(width,height);
       peopleWalker.setAtMazePoint(getEnterPoint(point));
       peopleWalker.setLocation(getEnterPoint(point).getX(),getEnterPoint(point).getY()); 
       initView();
       registerListener();
   }
   public void initPointXY(){ //������ͼ�������õ������
       for(int i=0;i<point.length;i++) {
         for(int j=0;j<point[i].length;j++){
           point[i][j].setX(j*width+leftX);   //�������ϵԭ�������Ͻǣ�������x-�ᣬ������y-��
           point[i][j].setY(i*height+leftY);    
         }
       }
       peopleWalker.setAtMazePoint(getEnterPoint(point));
       peopleWalker.setLocation(getEnterPoint(point).getX(),getEnterPoint(point).getY()); 
       handleMove.setMazePoint(point); 
   }
   public void initView() {
      for(int i = 0;i<point.length;i++){
           for(int j = 0;j<point[i].length;j++) {
             int x = point[i][j].getX();
             int y = point[i][j].getY();
             //���Ƶľ��ε����Ͻ������ǣ�x*width+leftX,y*height+leftY��
             block[i][j]=new Rectangle2D.Double(x,y,width,height);
           }
      }
      repaint();
      handleMove.showTime.setText("0");
      peopleWalker.requestFocusInWindow();
      validate();
   }
   public void registerListener(){
      peopleWalker.addKeyListener(handleMove);
      handleMove.setMazePoint(point);
   }
   public void paintComponent(Graphics g){
       super.paintComponent(g);
       Graphics2D g_2d = (Graphics2D)g;
       BasicStroke bs=
                   new BasicStroke(1,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER);
       for(int i = 0;i<point.length;i++){
           for(int j = 0;j<point[i].length;j++) {
               if(!point[i][j].isRoad()){  
                   Color c = new Color(233,143,22);
                   g_2d.setColor(c);
                   g_2d.setStroke(bs); 
                   g_2d.draw(block[i][j]);
               }
               else {
                   g_2d.setColor(Color.green);
                   g_2d.fill(block[i][j]);
                   g_2d.setColor(Color.blue);
                   g_2d.setStroke(bs);
                   g_2d.draw(block[i][j]); 
                   if(point[i][j].getIsCharge()){
                      g_2d.setColor(Color.blue);
                      g_2d.fill(block[i][j]); 
                      g_2d.setColor(Color.white);
                      int x =point[i][j].getX();//Ϊ�˰���д��point[i][j]��������
                      int y =point[i][j].getY();
                      g_2d.setFont(new Font("",Font.BOLD,15)); 
                      g_2d.drawString(""+point[i][j].getChargeMoney(),x+width/8,y+4*height/5);
                   }
                   if(point[i][j].isOut()){
                      g_2d.setColor(Color.red);
                      g_2d.fill(block[i][j]);
                      g_2d.setColor(Color.white);
                      g_2d.setFont(new Font("",Font.BOLD,10));
                      g_2d.drawString("����",point[i][j].getX(),point[i][j].getY()+4*height/5);
                   }
               }  
           }
       }
       g_2d.setColor(Color.red);
       int x = point[0][0].getX();
       int y = point[0][0].getY();
       x= x*width+leftX;
       y= y*height+leftY;
       Rectangle2D rect = 
       new Rectangle2D.Double(x,y,width*point[0].length,height*point.length);
       g_2d.draw(rect);
       g_2d.setColor(Color.black);
       String mess1 ="��ɫ��·,��ɫ�ǳ��ڣ���ɫ���շ�վ��ֻҪ�������շѣ���������������"+
                     "��ؼ�ס����·�ѣ������޷��뿪����";
       String mess2 ="����굥�����Թ��ߣ�Ȼ�󰴷��������";
       int toLeftDis =handleMove.getBounds().width+leftX;
       g_2d.setFont(new Font("",Font.PLAIN,14));
       g_2d.drawString(mess1,toLeftDis+2,2*leftY/3);
       g_2d.drawString(mess2,leftX,(point.length+1)*height+leftY);
   }
   public Point getEnterPoint(Point [][] point){ //�õ���ڵ�
       Point p =null;
       for(int i = 0;i<point.length;i++){
           for(int j = 0;j<point[i].length;j++) {
               if(point[i][j].isEnter()){
                    p = point[i][j];
                    break;
               }
           }
       }
       return p;
   }
}
