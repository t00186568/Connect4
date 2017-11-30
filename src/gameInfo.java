import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class gameInfo  {

    GridBagConstraints gbc = new GridBagConstraints();

    public static void main(String[] args){
        new Connect4();
        new gameInfo();

    }

   public static JFrame  gameInfo;
    public static JPanel infoWindow;

   gameInfo(){
        gameInfo = new JFrame();
        gameInfo.setTitle("Connect4");
        gameInfo.setDefaultCloseOperation(EXIT_ON_CLOSE);

        gameInfo.setSize(850,500);
        gameInfo.setLocation(500,500);
        JButton grid[][] = new JButton[6][7];  //Array for drawing JButtons in grid

       gameInfo.setLayout(new FlowLayout());
        gameInfo.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);


       infoWindow = new JPanel();



       infoWindow.setSize(800,600);
       infoWindow.setLocation(500,500);
       infoWindow.setBackground(Color.black);
        infoWindow.setPreferredSize(new Dimension(200, 400));

       gameInfo.add(Connect4.connect4);
       gameInfo.add(infoWindow);

       gameInfo.setVisible(true);

   }






    }



