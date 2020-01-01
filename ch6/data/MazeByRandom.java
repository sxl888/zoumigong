package ch6.data;
import java.util.ArrayList;
import java.util.LinkedList;      
import java.util.Collections;
import java.util.Random;
import java.util.Iterator;  
public class MazeByRandom implements MazeMaker{
   public Point [][] point;        //point[i][j]���Թ��еĵ�
   int row,column;
   LinkedList<Point> isMountainPoint;
   public MazeByRandom(int row,int column){
      this.row = row;
      this.column = column;
      isMountainPoint = new LinkedList<Point>();
      point = new Point[row][column];
      for(int i=0;i<row;i++) {
         for(int j=0;j<column;j++){
            point[i][j] = new Point();//�����Թ��еĵ�
            point[i][j].setX(j);      
            point[i][j].setY(i);    
         }
      }
   }
   public Point [][] initMaze() {
      initRoad(); 
      initNumber();
      point[0][0].setIsEnter(true);
      point[0][0].setIsRoad(true); 
      point[0][0].setHaveFlag(true);  
      point[0][0].setNumber(-1);                   //��ڵ��ϵ�������С(ɽ�)
      point[0][0].setIsMountain(true);
      point[row-1][column-1].setIsOut(true);
      point[row-1][column-1].setNumber(row*column);//���ڵ��ϵ��������ɽ��ߣ�
      point[row-1][column-1].setIsMountain(true);
      isMountainPoint.add(point[0][0]);
      isMountainPoint.add(point[row-1][column-1]);
      randomSetMountain(row*column/5);//�ٽ�row*column/5��������Ϊɽ 
      Point pStart = point[0][0];
      while(pStart != point[row-1][column-1]){
          pStart = findMaxHeightMountain(pStart);
      }
      return point;
   }
   private void initRoad(){
      for(int i=0;i<row;i++) {
         for(int j=0;j<column;j++){
            point[i][j].setIsRoad(false);     //���õ㶼����·
            point[i][j].setHaveFlag(false);   //���õ㶼û����
            point[i][j].setIsMountain(false); //���õ㶼����ɽ
         
         }
      }
   }
   private void initNumber(){
        ArrayList<Integer> list = new ArrayList<Integer>();    
        for(int i = 0;i<row*column;i++){    
           list.add(i);    
        }    
        Collections.shuffle(list); //��list�Ľڵ�ϴ��
        Iterator<Integer> ite = list.iterator();
        int m = 0;    
        for(int i=0;i<row;i++) {
          for(int j=0;j<column;j++){    
             point[i][j].setNumber(ite.next());//ÿ���������������һ����[0,row*column-1]�е���
          } 
        }    
   }
   private void randomSetMountain(int n){
       LinkedList<Point> list = new LinkedList<Point>();
       Random random = new Random();    
        for(int i=0;i<row;i++) {
           for(int j=0;j<column;j++){ 
             if(point[i][j]!=point[0][0]&&point[i][j]!=point[row-1][column-1])   
                 list.add(point[i][j]); 
           }   
       }  
       while(n>0){
         int index =random.nextInt(list.size()); //����õ�һ��[0,list.size())֮�����
         Point pointBySet =  list.remove(index);//��������ɾ��һ���ڵ㣬���õ��ýڵ�
         pointBySet.setIsMountain(true);
         isMountainPoint.add(pointBySet);
         n--;
       }
   }
   Point findMaxHeightMountain(Point p){
       Point targetPoint = null;
       
       int minDistance = Integer.MAX_VALUE;
       LinkedList<Point>  pointFind  = new LinkedList<Point>(); //�ҵ��ľ���p�����û�����ɽ
       for(int i = 0;i<isMountainPoint.size();i++){ //���ȼ����������
           Point pt = isMountainPoint.get(i);
           if(p !=pt && pt.getHaveFlag() == false){
               if(p.distanceTo(pt)<minDistance)
                  minDistance = p.distanceTo(pt);
           }
       }
       for(int i = 0;i<isMountainPoint.size();i++){ //������������û�����ɽ
           Point pt = isMountainPoint.get(i);
           if(p != pt && pt.getHaveFlag() == false){
               if(minDistance ==p.distanceTo(pt)) {
                   pointFind.add(pt); 
               }
           }
       }
       //��pointFind��һ����������Point������һ����ߵ�ɽ��
       Point maxPoint =null;
       int maxHeight = pointFind.get(0).getNumber();
       for(int i=0;i<pointFind.size();i++){
          int mNumber = pointFind.get(i).getNumber();
          if(mNumber >= maxHeight){
             maxHeight = mNumber;
          }
       } 
       for(int i=0;i<pointFind.size();i++){
          if(pointFind.get(i).getNumber() == maxHeight){
             maxPoint = pointFind.get(i);
             break;
          }
       } 
       targetPoint = maxPoint;
       targetPoint.setHaveFlag(true);        //����ɽ���������
       SetRoad.setRoad(p,targetPoint,point); //���ô�p��targetPoint��·
       return targetPoint;
  }
}
