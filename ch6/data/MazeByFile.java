package ch6.data;
import java.io.*;
public class MazeByFile implements MazeMaker{
   public Point [][] point;  //point[i][j]���Թ��еĵ�
   int row,column;
   File mazeFile;           //�Թ��ļ�
   public MazeByFile(File mazeFile){
      this.mazeFile = mazeFile;
   }
   public Point [][] initMaze() {
      RandomAccessFile in=null; 
      String lineWord=null;
      try{  in=new RandomAccessFile(mazeFile,"r");
            long length=in.length();
            long position=0;
            in.seek(position);
            while(position<length){
                String str=in.readLine().trim();
                if(str.length()>=column)
                    column=str.length();
                position=in.getFilePointer();
                row++;
            }
            point=new Point[row][column];
            for(int i=0;i<row;i++) {
                for(int j=0;j<column;j++){
                   point[i][j] = new Point();//�����Թ��еĵ�
                   point[i][j].setX(j);      
                   point[i][j].setY(i);    
                }
            }
            position=0;
            in.seek(position);
            for(int i=0;i<row;i++) {
                String str=in.readLine().trim();
                char [] a =str.toCharArray();
                for(int j=0;j<a.length;j++){
                   if(a[j] == '*'){
                      point[i][j].setIsEnter(true);
                      point[i][j].setIsRoad(true);
                   }
                   else if(a[j] == '1'){
                      point[i][j].setIsRoad(false);
                   }
                   else if(a[j] == '0'){
                      point[i][j].setIsRoad(true);
                   } 
                   else if(a[j] == '#'){
                      point[i][j].setIsOut(true);
                      point[i][j].setIsRoad(true);
                   } 
                }
            }
       }
       catch(IOException exp){}
       return point;
    }
}
