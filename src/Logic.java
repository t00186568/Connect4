public class Logic {

    public static int playGrid[][] = new int[6][7];


    public void CheckRow(){

        
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
