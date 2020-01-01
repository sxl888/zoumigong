package ch6.data;
import ch6.data.Point;
import java.util.Random;
import java.util.ArrayList;
public class  ChargeOnRoad extends SetChargeOnRoad{ //����amount���շѵ�
    public Point [][] setChargeOnRoad(Point [][] point,int amount){ 
        ArrayList<Point> list = new ArrayList<Point>();//�����Թ��е�·
        Random random = new Random();  
        for(int i=0;i<point.length;i++) {
          for(int j=0;j<point[i].length;j++){ 
              if(point[i][j].isRoad()&&!point[i][j].isEnter()&&!point[i][j].isOut())
                 list.add(point[i][j]);
                 point[i][j].setIsCharge(false);
          }
        }
        amount = Math.min(list.size(),amount);
        while(amount>0){
           int index =random.nextInt(list.size());//����õ�һ��[0,list.size())֮�����
           Point pointSetCharge = list.remove(index);//��������ɾ��һ���ڵ㲢�õ��ýڵ�
           pointSetCharge.setIsCharge(true);
           int money = random.nextInt(MAXMoney)+1;  //[1,MAXMoney]֮��������
           pointSetCharge.setChargeMoney(money);
           amount--;
       }
       return point;
   }
}