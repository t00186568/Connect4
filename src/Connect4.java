import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;


public class Connect4  {


    public static void main(String[] args) {
        new Connect4();

    }

    //Counter for determining which player's turn
    //Odds = Red
    //Evens = Blue
    public static int counter = 1;
    public static int globalQ;
    public static int globalI;

    public static JPanel connect4;

    Connect4() {

        connect4 = new JPanel();


        //connect4.setVisible(true);
        connect4.setSize(600,400);
        connect4.setPreferredSize(new Dimension(600, 400));
        //connect4.setLocation(500,500);
        JButton grid[][] = new JButton[6][7];  //Array for drawing JButtons in grid





        //Begin Buttons


        //REVISED -- https://stackoverflow.com/questions/18794324/grid-of-buttons-actionlistener
        //Generating grid of JButtons roughly adapted from here


        //i is the for loop counter for columns, generating 6 vertical buttons
        //q is the for loop counter for rows, generating 7 horizontal buttons
        for(int i=0; i <6; i++) //For loop for drawing vertical buttons
            for(int  q=0; q<7; q++){ //For loop for drawing horizontal buttons


                //These variables were used for displaying grid location numbers on top buttons
                String locationOfi = String.valueOf(i);
                String locationOfq = String.valueOf(q); //Storing typecasted values in Variable to avoid "Variable is accessed within inner class" error
                //This was removed


                final int variableI = i; //Storing what i currently is as a final int to avoid "Variable is accessed within inner class" error
                final int variableQ = q;


                // boolean showGridNum = false; -- Removed - never got button working to toggle showing grid numbers



                grid[i][q] = new JButton();



                grid[i][q].setBackground(Color.white);
                grid[i][q].setOpaque(true);
                connect4.add(grid[i][q]);
                grid[i][q].addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        if((counter % 2) == 1 ){ //Red
                            grid[variableI][variableQ].setBackground(Color.red);
                            Logic.playGrid[variableI][variableQ] += 1;
                            Logic runlogic = new Logic();



                            globalQ = variableQ; //Stores variable to global that is accessible from Logic class for checking Lowest row is not empty
                            globalI = variableI;
                            runlogic.CheckRow(); // Checking if lowest row isn't empty, if it is empty lowest row's color is reset to white and the number for setting color in playGrid is reset
                            if(runlogic.isCheckError() == true){
                                grid[variableI][variableQ].setBackground(Color.white);
                                Logic.playGrid[variableI][variableQ] -= 1;
                            }


                            runlogic.CheckDownRight();
                            runlogic.CheckUpRight();
                            runlogic.CheckDownLeft();
                            runlogic.CheckUpLeft();
                            runlogic.CheckHorizontal();
                            runlogic.CheckVertical();
                            counter++;


                        }else{ //Blue
                            grid[variableI][variableQ].setBackground(Color.blue);
                            Logic.playGrid[variableI][variableQ] += 2;


                            Logic runlogic = new Logic();




                            globalQ = variableQ;//Stores variable to global that is accessible from Logic class for checking Lowest row is not empty
                            globalI = variableI;
                            runlogic.CheckRow();// Checking if lowest row isn't empty, if it is empty lowest row's color is reset to white and the number for setting color in playGrid is reset
                            if(runlogic.isCheckError() == true){
                                grid[variableI][variableQ].setBackground(Color.white);
                                Logic.playGrid[variableI][variableQ] -= 2;
                            }


                            runlogic.CheckDownRight();
                            runlogic.CheckUpRight();
                            runlogic.CheckDownLeft();
                            runlogic.CheckUpLeft();
                            runlogic.CheckHorizontal();
                            runlogic.CheckVertical();
                            counter++;
                        }

                    }
                });
            }







        connect4.setLayout(new GridLayout(6,7));
        //connect4.add(connect4);



    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public JPanel getConnect4() {
        return connect4;
    }

    public void setConnect4(JPanel connect4) {
        this.connect4 = connect4;
    }

    public static int getGlobalQ() {
        return globalQ;
    }

    public static void setGlobalQ(int globalQ) {
        Connect4.globalQ = globalQ;
    }

    public static int getGlobalI() {
        return globalI;
    }

    public static void setGlobalI(int globalI) {
        Connect4.globalI = globalI;
    }


}
