import javax.swing.*;
import java.awt.*;

public class Logic extends JDialog {

    public static int playGrid[][] = new int[6][7];
    boolean checkError = false;


    //Begin code to check if the Lowest row of the Array is Empty
    private int lowestRow = 5;
    public void CheckRow(){

            if((playGrid[lowestRow][Connect4.getGlobalQ()] != 1 && playGrid[lowestRow][Connect4.getGlobalQ()] != 2)){
                JOptionPane.showMessageDialog(Connect4.connect4, "The lowest row must not be empty.");
                checkError = true;
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
