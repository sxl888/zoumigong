package ch6.gui;
import ch6.data.*;
import ch6.view.*;
import java.io.File;
public class AppWindow {
   public static void main(String []args) {
       MazeMaker mazeMaker = new MazeByRandom(21,39);
       Point [][] point= mazeMaker.initMaze();
       //�����շѵ㣨��ѡ��
       SetChargeOnRoad policeOne = new  ChargeOnRoad();
       // �շ�վ����շѶ�Ĭ����20
       point = policeOne.setChargeOnRoad(point,20); //����20���շ�վ
       MazeView mazeView  = new RandomMazeView(point);
       IntegrationView integrationView = new IntegrationView();
       integrationView.addMazeView("����Թ�",mazeView);
       mazeMaker = new MazeByFile(new File("�Թ��ļ�/����Թ�.txt"));
       point= mazeMaker.initMaze();
       SetChargeOnRoad policeTwo = new  ChargeOnRoad();
       policeTwo.setMAXMoney(10); //�շ�վ����շѶ�Ϊ10
       point = policeTwo.setChargeOnRoad(point,6); //����6���շ�վ
       mazeView  = new FixedMazeView(point);
       integrationView.addMazeView("����Թ�",mazeView);
   }
}