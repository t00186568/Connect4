import javax.swing.*;
import java.awt.*;

public class Logic extends JDialog {

    public static int playGrid[][] = new int[6][7];
    boolean checkError = false;
    String winner = " ";

    //Code to check if the Lowest row of the Array is Empty
    private int lowestRow = 5;
    public void CheckRow(){


                if (playGrid[lowestRow][Connect4.getGlobalQ()] !=1 && playGrid[lowestRow][Connect4.getGlobalQ()] !=2){
                    JOptionPane.showMessageDialog(Connect4.connect4, "The lowest row must not be empty.");
                    checkError = true;
                }

        }


        //Code for checking if Diagonally down left is a match
    public void CheckDownRight(){

        int downRightCounterRed = 0;
        int downRightCounterBlue = 0;

        int status = 0;
        int count = 4;

        //For this I am using an initial for loop to begin the checks, this loop will change the 'status' variable if it doesn't find what it needs
        //The for loops in each if statement are the same but the row they check increases by 1 each time


            for (int row = 0, col = 0; count > 0; row++, col++, count--) {
    //Begins at 0,0 and works diagonally (e.g 0,0 1,1 2,2)
                if (playGrid[row][col] == 1) {
                    downRightCounterRed++;
                } else if (playGrid[row][col] == 2) {
                    downRightCounterBlue++;
                }else if(!(playGrid[row][col] == 1 || playGrid[row][col] == 2)){
                    status = 1; //if there is no match in that row, it moves onto the next check
                    break;
                }
            }
     //Checks Diagonal row 1,0 to 5,4
            if(status==1) {
                for (int row = 1, col = 0; count > 0; row++, col++, count--) {
                    if (playGrid[row][col] == 1) {
                        downRightCounterRed++;
                    } else if (playGrid[row][col] == 2) {
                        downRightCounterBlue++;
                    } else if (!(playGrid[row][col] == 1 || playGrid[row][col] == 2)) {
                        status = 2;
                        break;
                    }
                }
        }
    //Checks Diagonal row 2,0 to 5,3
            if(status==2){
                for (int row = 2, col = 0; count > 0; row++, col++, count--) {
                    if (playGrid[row][col] == 1) {
                        downRightCounterRed++;
                    } else if (playGrid[row][col] == 2) {
                        downRightCounterBlue++;
                    } else {
                        status = 3;
                        break;
                    }
                }
            }


    //Checks Diagonal row 0,1 to 5,6
            if(status==3){
                for (int row = 0, col = 1; count > 0; row++, col++, count--) {
                    if (playGrid[row][col] == 1) {
                        downRightCounterRed++;
                    } else if (playGrid[row][col] == 2) {
                        downRightCounterBlue++;
                    } else {
                        status = 4;
                        break;
                    }
                }
            }

    //Checks Diagonal row 0,2 to 4,6
            if(status==4){
                for (int row = 0, col = 2; count > 0; row++, col++, count--) {
                    if (playGrid[row][col] == 1) {
                        downRightCounterRed++;
                    } else if (playGrid[row][col] == 2) {
                        downRightCounterBlue++;
                    } else {
                        status = 5;
                        break;
                    }
                }
            }

    //Checks Diagonal row 0,3 to 3,6
        if(status==5){
            for (int row = 0, col = 2; count > 0; row++, col++, count--) {
                if (playGrid[row][col] == 1) {
                    downRightCounterRed++;
                } else if (playGrid[row][col] == 2) {
                    downRightCounterBlue++;
                } else {
                    status = 5;
                    break;
                }
            }
        }



        System.out.print("Blue: " +  downRightCounterBlue + " Red: " + downRightCounterRed + " Status: " + status);


        //Diagonal Down>Right win checker
        if(downRightCounterRed >= 4 || downRightCounterBlue >= 4){
            if(Connect4.counter%2 == 1){
                winner += "Red";
            }else{
                winner += "Blue";
            }
            JOptionPane.showMessageDialog(Connect4.connect4, winner + " wins!!");
        }


        }





        
    public boolean isCheckError() {
        return checkError;
    }

    public void setCheckError(boolean checkError) {
        this.checkError = checkError;
    }









    //Code borrowed from https://stackoverflow.com/questions/12845208/how-to-print-two-dimensional-array-like-table
    //Only for testing that array is functioning properly visually -- WILL BE REMOVED



        public static void printRow ( int[] row){
            for (int i : row) {
                System.out.print(i);
                System.out.print("\t");
            }
            System.out.println();}


        public static void main (String[]args){

            int i, j, k = 1;

            for (i = 0; i < 6; i++) {
                for (j = 0; j < 7; j++) {
                    String.valueOf(playGrid[i][j]);

                }
            }

            for (int[] row : playGrid) {
                printRow(row);

            }


        }


//End Borrowed code
 }
