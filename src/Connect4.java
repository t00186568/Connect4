import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;


public class Connect4 extends JFrame {


    public static void main(String[] args) {
        new Connect4();

    }


    Connect4() {
       JFrame connect4;
       connect4 = new JFrame();
       connect4.setTitle("Connect4");
       connect4.setDefaultCloseOperation(EXIT_ON_CLOSE);
       connect4.setVisible(true);
       connect4.setSize(800,600);
        JButton grid[][] = new JButton[6][7];  //Array for drawing JButtons in grid
        int status[][] = new int[6][7]; //Array for tracking what status of buttons are

       //Begin Buttons
        for(int i=0; i <6; i++) //For loop for drawing vertical buttons
            for(int  q=0; q<7; q++){ //For loop for drawing horizontal buttons
                grid[i][q] = new JButton(String.valueOf(i) + "," + String.valueOf(q)); //Gives buttons their Grid location Numbers -- will remove
                grid[i][q].setBackground(Color.white);
                grid[i][q].setOpaque(true);
                connect4.add(grid[i][q]);
            }







       connect4.setLayout(new GridLayout(6,7));




    }





}
