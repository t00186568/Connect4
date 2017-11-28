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
    public static int counter = 1;
    public static int globalQ;

    public static JFrame connect4;

     Connect4() {

       connect4 = new JFrame();
       connect4.setTitle("Connect4");
       connect4.setDefaultCloseOperation(EXIT_ON_CLOSE);
       connect4.setVisible(true);
       connect4.setSize(800,600);
       connect4.setLocation(500,500);
        JButton grid[][] = new JButton[6][7];  //Array for drawing JButtons in grid





       //Begin Buttons
        for(int i=0; i <6; i++) //For loop for drawing vertical buttons
            for(int  q=0; q<7; q++){ //For loop for drawing horizontal buttons
                String locationOfi = String.valueOf(i+1);
                String locationOfq = String.valueOf(q+1); //Storing typecasted values in Variable to avoid "Variable is accessed within inner class" error
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
                         Logic runlogic = new Logic();

                         //Temp Code - Outputs Logic's table to console on Run
                         runlogic.main(null);
                         System.out.print("\n\n");
                         //end temp code

                         globalQ = variableQ; //Stores variable to global that is accessible from Logic class for checking Lowest row is not empty
                         runlogic.CheckRow();
                            if(runlogic.isCheckError() == true){
                                grid[variableI][variableQ].setBackground(Color.white);
                                Logic.playGrid[variableI][variableQ] -= 1;
                            }
                         counter++;


                        }else{
                            grid[variableI][variableQ].setBackground(Color.blue);
                            Logic.playGrid[variableI][variableQ] += 2;

                            //Temp Code - Outputs Logic's table to console on Run
                            Logic runlogic = new Logic();
                            runlogic.main(null);
                            System.out.print("\n\n");
                            //end temp code

                            globalQ = variableQ;//Stores variable to global that is accessible from Logic class for checking Lowest row is not empty
                            runlogic.CheckRow();
                                if(runlogic.isCheckError() == true){
                                    grid[variableI][variableQ].setBackground(Color.white);
                                    Logic.playGrid[variableI][variableQ] -= 2;
                                }
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

    public JFrame getConnect4() {
        return connect4;
    }

    public void setConnect4(JFrame connect4) {
        this.connect4 = connect4;
    }

    public static int getGlobalQ() {
        return globalQ;
    }

    public static void setGlobalQ(int globalQ) {
        Connect4.globalQ = globalQ;
    }
}
