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




        //Right side
       infoWindow = new JPanel();
       infoWindow.setSize(800,600);
       infoWindow.setLocation(500,500);
       infoWindow.setBackground(Color.white);
        infoWindow.setPreferredSize(new Dimension(200, 400));
        infoWindow.setLayout(new BorderLayout());

       JLabel title = new JLabel("Connect 4", JLabel.CENTER);
       title.setFont(new Font("Verdana",1,24));
       infoWindow.add(title, BorderLayout.NORTH);


        String color = "";
       JLabel turn = new JLabel("", JLabel.CENTER);
       turn.setFont(new Font("Verdana",1,24));
       turn.setForeground(Color.red);




       infoWindow.add(turn, BorderLayout.CENTER);

       gameInfo.add(Connect4.connect4);
       gameInfo.add(infoWindow);

       gameInfo.setVisible(true);

   }






    }



