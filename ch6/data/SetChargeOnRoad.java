package ch6.data;
import ch6.data.Point;
public abstract class  SetChargeOnRoad {
    int MAXMoney = 20; //��ߵ��շѽ��
    //�ڵ�����amount���շѵ�:
    public abstract Point [][] setChargeOnRoad(Point [][] point,int amount);
    public void setMAXMoney(int money){
       MAXMoney = money;
    }
}