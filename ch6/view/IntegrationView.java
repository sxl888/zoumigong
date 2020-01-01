package ch6.view;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
public class IntegrationView extends JFrame{
    JTabbedPane tabbedPane; //��ѡ�����MazeView��ͼ
    public IntegrationView(){
        tabbedPane= new JTabbedPane(JTabbedPane.LEFT);//������� 
        tabbedPane.validate();
        add(tabbedPane,BorderLayout.CENTER); 
        setBounds(5,5,1500,720);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    public void addMazeView(String cardName,MazeView view){
       tabbedPane.add(cardName,view);
       validate();
    }
}