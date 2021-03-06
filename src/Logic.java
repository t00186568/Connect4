import javax.swing.*;
import java.awt.*;

public class Logic extends JDialog { /**Logic class extends JDialog*/

public static int playGrid[][] = new int[6][7];
    boolean checkError = false;
    String winner = " ";

    /**Code to check if the Lowest row of the Array is Empty*/
    private int lowestRow = 5;
    public void CheckRow(){


        if (playGrid[lowestRow][Connect4.getGlobalQ()] !=1 && playGrid[lowestRow][Connect4.getGlobalQ()] !=2){
            JOptionPane.showMessageDialog(Connect4.connect4, "The lowest row must not be empty.");
            checkError = true;
        }

    }

    /**Code for checking if Diagonally down left is a match*/
    public void CheckDownRight(){

        int downRightCounterRed = 0;
        int downRightCounterBlue = 0;

        int status = 0;
        int count = 4;

        /**For this I am using an initial for loop to begin the checks, this loop will change the 'status' variable if it doesn't find what it needs
         The for loops in each if statement are the same but the row they check increases by 1 each time*/


        //REVISED -- https://stackoverflow.com/questions/37480515/connect-4-check-diagonal-win
        //count variable referenced from this link in the "Forward Diagonals" part
        //This counter will count down for each square it checks, this is so that it will only check
        //the first four tiles in each direction - e.g 0,0 1,1 2,2 3,3



        for (int row = 0, col = 0; count > 0; row++, col++, count--) {
            /**Begins at 0,0 and works diagonally (e.g 0,0 1,1 2,2)*/
            if (playGrid[row][col] == 1) {
                downRightCounterRed++;
            } else if (playGrid[row][col] == 2) {
                downRightCounterBlue++;
            }else if(!(playGrid[row][col] == 1 || playGrid[row][col] == 2)){
                status = 1; /**if there is no match in that row, it moves onto the next check&*/
                break;
            }
        }
        /**Checks Diagonal row 1,0 to 5,4*/
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
        /**Checks Diagonal row 2,0 to 5,3*/
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

        /**Begins checking columns
         Checks Diagonal row 0,1 to 5,6*/
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

        /**Checks Diagonal row 0,2 to 4,6*/
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

        /**Checks Diagonal row 0,3 to 3,6*/
        if(status==5){
            for (int row = 0, col = 3; count > 0; row++, col++, count--) {
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



        //System.out.print("Blue: " +  downRightCounterBlue + " Red: " + downRightCounterRed + " Status: " + status); //Remove


        /**Diagonal Down>Right win checker*/
        if(downRightCounterRed >= 4 || downRightCounterBlue >= 4){
            if(Connect4.counter%2 == 1){
                winner += "Red";
            }else{
                winner += "Blue";
            }
            JOptionPane.showMessageDialog(Connect4.connect4, winner + " wins!!");
        }


    }
//End checking Diagonal Down Right


//Code for checking Diagonal Up Right

    public void CheckUpRight(){

        int upRightCounterRed = 0;
        int upRightCounterBlue = 0;

        int status = 0;
        int count = 4;

        /**For this I am using an initial for loop to begin the checks, this loop will change the 'status' variable if it doesn't find what it needs
         The for loops in each if statement are the same but the row they check increases by 1 each time*/


        for (int row = 5, col = 0; count > 0; row--, col++, count--) {
            /**Begins at 5,0 and works diagonally (e.g 5,0 4,1 3,2)*/
            if (playGrid[row][col] == 1) {
                upRightCounterRed++;
            } else if (playGrid[row][col] == 2) {
                upRightCounterBlue++;
            }else if(!(playGrid[row][col] == 1 || playGrid[row][col] == 2)){
                status = 1; /**if there is no match in that row, it moves onto the next check*/
                break;
            }
        }
        /**Checks Diagonal row 4,0 to 0,4*/
        if(status==1) {
            for (int row = 4, col = 0; count > 0; row--, col++, count--) {
                if (playGrid[row][col] == 1) {
                    upRightCounterRed++;
                } else if (playGrid[row][col] == 2) {
                    upRightCounterBlue++;
                } else if (!(playGrid[row][col] == 1 || playGrid[row][col] == 2)) {
                    status = 2;
                    break;
                }
            }
        }
        /**Checks Diagonal row 3,0 to 0,3*/
        if(status==2){
            for (int row = 3, col = 0; count > 0; row--, col++, count--) {
                if (playGrid[row][col] == 1) {
                    upRightCounterRed++;
                } else if (playGrid[row][col] == 2) {
                    upRightCounterBlue++;
                } else {
                    status = 3;
                    break;
                }
            }
        }

        /**Begins checking columns
         Checks Diagonal row 5,1 to 0,6*/
        if(status==3){
            for (int row = 5, col = 1; count > 0; row--, col++, count--) {
                if (playGrid[row][col] == 1) {
                    upRightCounterRed++;
                } else if (playGrid[row][col] == 2) {
                    upRightCounterBlue++;
                } else {
                    status = 4;
                    break;
                }
            }
        }

        /**Checks Diagonal row 5,2 to 1,6*/
        if(status==4){
            for (int row = 5, col = 2; count > 0; row--, col++, count--) {
                if (playGrid[row][col] == 1) {
                    upRightCounterRed++;
                } else if (playGrid[row][col] == 2) {
                    upRightCounterBlue++;
                } else {
                    status = 5;
                    break;
                }
            }
        }

        /**Checks Diagonal row 5,3 to 2,6*/
        if(status==5){
            for (int row = 5, col = 3; count > 0; row--, col++, count--) {
                if (playGrid[row][col] == 1) {
                    upRightCounterRed++;
                } else if (playGrid[row][col] == 2) {
                    upRightCounterBlue++;
                } else {
                    status = 5;
                    break;
                }
            }
        }



        // System.out.print("Blue: " +  upRightCounterBlue + " Red: " + upRightCounterRed + " Status: " + status); //Remove


        /**Diagonal Up>Right win checker*/
        if(upRightCounterRed >= 4 || upRightCounterBlue >= 4){
            if(Connect4.counter%2 == 1){
                winner += "Red";
            }else{
                winner += "Blue";
            }
            JOptionPane.showMessageDialog(Connect4.connect4, winner + " wins!!");
        }


    }

//End checking Diagonal up Right


//Begin checking Diagonal Down left

    public void CheckDownLeft(){

        int downLeftCounterRed = 0;
        int downLeftCounterBlue = 0;

        int status = 0;
        int count = 4;

        /**For this I am using an initial for loop to begin the checks, this loop will change the 'status' variable if it doesn't find what it needs
         The for loops in each if statement are the same but the row they check increases by 1 each time*/


        for (int row = 0, col = 6; count > 0; row++, col--, count--) {//Begins at 0,6 and works diagonally (e.g 0,6 1,5 2,4)
            if (playGrid[row][col] == 1) {
                downLeftCounterRed++;
            } else if (playGrid[row][col] == 2) {
                downLeftCounterBlue++;
            }else if(!(playGrid[row][col] == 1 || playGrid[row][col] == 2)){
                status = 1; //if there is no match in that row, it moves onto the next check
                break;
            }
        }
        /**Checks Diagonal row 1,6 to 5,2*/
        if(status==1) {
            for (int row = 1, col = 6; count > 0; row++, col--, count--) {
                if (playGrid[row][col] == 1) {
                    downLeftCounterRed++;
                } else if (playGrid[row][col] == 2) {
                    downLeftCounterBlue++;
                } else if (!(playGrid[row][col] == 1 || playGrid[row][col] == 2)) {
                    status = 2;
                    break;
                }
            }
        }
        /**Checks Diagonal row 2,6 to 5,3*/
        if(status==2){
            for (int row = 2, col = 6; count > 0; row++, col--, count--) {
                if (playGrid[row][col] == 1) {
                    downLeftCounterRed++;
                } else if (playGrid[row][col] == 2) {
                    downLeftCounterBlue++;
                } else {
                    status = 3;
                    break;
                }
            }
        }

        /**Begins checking columns
         Checks Diagonal row 0,5 to 5,0*/
        if(status==3){
            for (int row = 0, col = 5; count > 0; row++, col--, count--) {
                if (playGrid[row][col] == 1) {
                    downLeftCounterRed++;
                } else if (playGrid[row][col] == 2) {
                    downLeftCounterBlue++;
                } else {
                    status = 4;
                    break;
                }
            }
        }

        /**Checks Diagonal row 0,4 to 4,0*/
        if(status==4){
            for (int row = 0, col = 4; count > 0; row++, col--, count--) {
                if (playGrid[row][col] == 1) {
                    downLeftCounterRed++;
                } else if (playGrid[row][col] == 2) {
                    downLeftCounterBlue++;
                } else {
                    status = 5;
                    break;
                }
            }
        }

        /**Checks Diagonal row 0,3 to 3,0*/
        if(status==5){
            for (int row = 0, col = 3; count > 0; row++, col--, count--) {
                if (playGrid[row][col] == 1) {
                    downLeftCounterRed++;
                } else if (playGrid[row][col] == 2) {
                    downLeftCounterBlue++;
                } else {
                    status = 5;
                    break;
                }
            }
        }



        //System.out.print("Blue: " +  downLeftCounterBlue + " Red: " + downLeftCounterRed + " Status: " + status); // Remove


        /**Diagonal down Left win checker*/
        if(downLeftCounterRed >= 4 || downLeftCounterBlue >= 4){
            if(Connect4.counter%2 == 1){
                winner += "Red";
            }else{
                winner += "Blue";
            }
            JOptionPane.showMessageDialog(Connect4.connect4, winner + " wins!!");
        }


    }

//End Down Left Checking



//Begin checking Diagonal Up left

    public void CheckUpLeft(){

        int upLeftCounterRed = 0;
        int upLeftCounterBlue = 0;

        int status = 0;
        int count = 4;

        /**For this I am using an initial for loop to begin the checks, this loop will change the 'status' variable if it doesn't find what it needs
         The for loops in each if statement are the same but the row they check increases by 1 each time*/


        for (int row = 5, col = 6; count > 0; row--, col--, count--) {
            /**Begins at 5,6 and works diagonally (e.g 5,6 4,5 3,4)*/
            if (playGrid[row][col] == 1) {
                upLeftCounterRed++;
            } else if (playGrid[row][col] == 2) {
                upLeftCounterBlue++;
            }else if(!(playGrid[row][col] == 1 || playGrid[row][col] == 2)){
                status = 1; /**if there is no match in that row, it moves onto the next check*/
                break;
            }
        }
        /**Checks Diagonal row 4,6 to 0,2*/
        if(status==1) {
            for (int row = 4, col = 6; count > 0; row--, col--, count--) {
                if (playGrid[row][col] == 1) {
                    upLeftCounterRed++;
                } else if (playGrid[row][col] == 2) {
                    upLeftCounterBlue++;
                } else if (!(playGrid[row][col] == 1 || playGrid[row][col] == 2)) {
                    status = 2;
                    break;
                }
            }
        }
        /**Checks Diagonal row 3,6 to 0,3*/
        if(status==2){
            for (int row = 3, col = 6; count > 0; row--, col--, count--) {
                if (playGrid[row][col] == 1) {
                    upLeftCounterRed++;
                } else if (playGrid[row][col] == 2) {
                    upLeftCounterBlue++;
                } else {
                    status = 3;
                    break;
                }
            }
        }

        /**Begins checking columns
         Checks Diagonal row 5,5 to 0,0*/
        if(status==3){
            for (int row = 5, col = 5; count > 0; row--, col--, count--) {
                if (playGrid[row][col] == 1) {
                    upLeftCounterRed++;
                } else if (playGrid[row][col] == 2) {
                    upLeftCounterBlue++;
                } else {
                    status = 4;
                    break;
                }
            }
        }

        /**Checks Diagonal row 5,4 to 1,0*/
        if(status==4){
            for (int row = 5, col = 4; count > 0; row--, col--, count--) {
                if (playGrid[row][col] == 1) {
                    upLeftCounterRed++;
                } else if (playGrid[row][col] == 2) {
                    upLeftCounterBlue++;
                } else {
                    status = 5;
                    break;
                }
            }
        }

        /**Checks Diagonal row 5,3 to 2,0*/
        if(status==5){
            for (int row = 5, col = 3; count > 0; row--, col--, count--) {
                if (playGrid[row][col] == 1) {
                    upLeftCounterRed++;
                } else if (playGrid[row][col] == 2) {
                    upLeftCounterBlue++;
                } else {
                    status = 5;
                    break;
                }
            }
        }






        /**Diagonal Up>Left win checker*/
        if(upLeftCounterRed >= 4 || upLeftCounterBlue >= 4){
            if(Connect4.counter%2 == 1){
                winner += "Red";
            }else{
                winner += "Blue";
            }
            JOptionPane.showMessageDialog(Connect4.connect4, winner + " wins!!");
        }


    }
//End Up Left Checking


    //Begin checking Horizontal
    int horizontalCounterRed = 0;
    int horizontalCounterBlue = 0;

    public void CheckHorizontal(){





        for(int col = 0; col < 7; col++)
            for(int row = 5; row >= 5; row--){
                //red




                if (playGrid[row][col] == 1) {   //These loops check if tile is a) the same color, b) surrounded by a tile that is the same color

                    if ((col - 1 > -1)) { // Validation for making sure tile before isn't out of bounds

                        if (col - 1 == 1) {
                            horizontalCounterRed = horizontalCounterRed + 1;

                        } else if (col + 1 == 1) {
                            horizontalCounterRed = horizontalCounterRed + 1;

                        } else if ((col + 1 == 2) || (col - 1 == 2)) {

                            horizontalCounterRed = 0;


                        } else {

                            horizontalCounterRed = horizontalCounterRed + 1;

                        }

                    }else {
                        horizontalCounterRed = horizontalCounterRed + 1;
                    }
                }



                //blue


                if (playGrid[row][col] == 2) {
                    if (col - 1 > 0) {
                        if (col - 1 == 2) {
                            horizontalCounterBlue = horizontalCounterBlue + 1;

                        } else if (col + 1 == 2) {
                            horizontalCounterBlue = horizontalCounterBlue + 1;

                        } else if (col + 1 != 2 || col - 1 != 2) {
                            horizontalCounterBlue = 0;

                        } else {

                            horizontalCounterBlue = horizontalCounterBlue + 1;


                        }

                    }else {
                        horizontalCounterBlue++;
                    }


                }


            }


        //System.out.println(" Horizontal Blue: " +  horizontalCounterBlue + " Red: " + horizontalCounterRed );
        /**Win Tracker for Horizontal Counter*/
        if(horizontalCounterRed == 4 || horizontalCounterBlue == 4){
            if(Connect4.counter%2 == 1){
                winner += "Red";
            }else{
                winner += "Blue";
            }
            JOptionPane.showMessageDialog(Connect4.connect4, winner + " wins!!");
        }



    }




    //Begin checking Vertical
    int verticalCounterRed = 0;
    int verticalCounterBlue = 0;
    public void CheckVertical() {


        for (int row = 5; row > 0; row--)
            for (int col = 0; col < 7; col++) {
                //red
                if (playGrid[row][col] == 1) {   /**These loops check if tile is a) the same color, b) surrounded by a tile that is the same color
                 vertically that is not out of bounds before apply the score*/
                    if (row - 1 > 0 && row + 1 < 6) {
                        if (playGrid[row - 1][col] == 1 ) {
                            verticalCounterRed++;
                        } else {
                            verticalCounterRed = 0;
                        }


                    }
                }
                //blue


                if (playGrid[row][col] == 2) {
                    if (row - 1 > 0 && row + 1 < 6) {
                        if (playGrid[row - 1][col] == 2 ) {
                            verticalCounterBlue++;
                        } else {
                            verticalCounterBlue = 0;
                        }

                    }


                }


            }

        // System.out.print("Blue: " + verticalCounterBlue + " Red: " + verticalCounterRed);
        /**Win tracker for Vertical Counter*/
        if (verticalCounterRed == 4 || verticalCounterBlue == 4) {
            if (Connect4.counter % 2 == 1) {
                winner += "Red";
            } else {
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










}
