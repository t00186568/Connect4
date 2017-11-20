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
            for(y=50; y<600; y=y+100){ //inner loop draws vertical ovals

                g.drawOval(x, y, 80, 80); 

            }


        }


    }







}
