import java.util.Arrays;

public class Array {

    public static int[][] slotStatus =  new int[6][7];

    public static void fillArray(){
       java.util.Arrays.fill(slotStatus, 0);

    }

    public static void main(String[] args) {
        System.out.print(slotStatus[3][4]);
    }


    /*
    Code to make sure that the array was properly written too
    public static void main(String[] args) {
        boolean slot = slotStatus[4][5];
        if(slot=="empty") {
            System.out.print("yeah");
        }else{
            System.out.print("nope");
        }*/
    }


