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

    //Counter for determining which player's turn
    //Odds = Red
    //Evens = Blue
    int counter = 1;

     Connect4() {
       JFrame connect4;
       connect4 = new JFrame();
       connect4.setTitle("Connect4");
       connect4.setDefaultCloseOperation(EXIT_ON_CLOSE);
       connect4.setVisible(true);
       connect4.setSize(800,600);
        JButton grid[][] = new JButton[6][7];  //Array for drawing JButtons in grid





       //Begin Buttons
        for(int i=0; i <6; i++) //For loop for drawing vertical buttons
            for(int  q=0; q<7; q++){ //For loop for drawing horizontal buttons
                String locationOfi = String.valueOf(i);
                String locationOfq = String.valueOf(q); //Storing typecasted values in Variable to avoid "Variable is accessed within inner class" error
                final int variableI = i; //Storing what i currently is as a final int to avoid "Variable is accessed within inner class" error
                final int variableQ = q;

                grid[i][q] = new JButton(locationOfi + "," + locationOfq); //Gives buttons their Grid location Numbers -- will remove
                grid[i][q].setBackground(Color.white);
                grid[i][q].setOpaque(true);
                connect4.add(grid[i][q]);
                grid[i][q].addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        if((counter % 2) == 1 ){
                         grid[variableI][variableQ].setBackground(Color.red);
                         Logic.playGrid[variableI][variableQ] += 1;

                         //Temp Code - Outputs Logic's table to console on Run
                         Logic runlogic = new Logic();
                         runlogic.main(null);
                         System.out.print("\n\n");
                         //end temp code

                         counter++;


                        }else{
                            grid[variableI][variableQ].setBackground(Color.blue);
                            Logic.playGrid[variableI][variableQ] += 2;

                            //Temp Code - Outputs Logic's table to console on Run
                            Logic runlogic = new Logic();
                            runlogic.main(null);
                            System.out.print("\n\n");
                            //end temp code

                            counter++;
                        }

                    }
                });
            }







       connect4.setLayout(new GridLayout(6,7));




    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
