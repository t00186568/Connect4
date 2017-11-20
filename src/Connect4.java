import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;


public class Connect4 extends JFrame {


    public static void main(String[] args) {
        new Connect4();

    }

    public Connect4(){
       setTitle("Connect4");
        setVisible(true);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,700); // Set width and height to 800x800

    }

    public void paint(Graphics g) {
        g.setColor(Color.black); //Sets Outline color to black

        int x=25, y=50;

        for(x=25; x<945; x=x+110){ //Outer loop draws horizontal ovals
            //if(x/135) = false slot empty -- code for checking if slot is empty
            for(y=50; y<600; y=y+100){ //inner loop draws vertical ovals
                //if(y/600) = false slot empty
                g.drawOval(x, y, 80, 80);

            }


        }


    }


//string array - empty, red or blue
// Counter++ for turn tracking - will modulus to check who's turn it is, red is evens, blue is odds
// Each button will have a counter to know how many rows up each counter is




}
