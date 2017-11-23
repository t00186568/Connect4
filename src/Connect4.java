import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;


public class Connect4 extends JFrame {


    public static void main(String[] args) {
        new Connect4();

    }

    public Connect4(){
       setTitle("Connect4");

       setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,750); // Set width and height to 800x800
        setVisible(true);
        setLayout(null);


    }

    public void buttons(){
        //Button 1
        JButton slot1=new JButton("Slot 1"); //declare new button
        slot1.setEnabled(true); //enable new button
        add(slot1); //Add new button to jFrame
        slot1.setBounds(10,610,100,50); // Set new Button Size and Location

    }

    public void paint(Graphics g) {
        //g.setColor(Color.black); //Sets Outline color to black

        int x=25, y=50;

        for(x=25; x<745; x=x+110){ //Outer loop draws horizontal ovals
            //if(x/135) = "empty" slot empty -- code for checking if slot is empty
            for(y=50; y<600; y=y+100){ //inner loop draws vertical ovals
                //if(y/600) = "empty" slot empty
                g.drawOval(x, y, 80, 80);

            }


        }


    }


//int array - 0 = empty, 1= red or 2 = blue
// Counter++ for turn tracking - will modulus to check who's turn it is, red is evens, blue is odds
// Each button will have a counter to know how many rows up each counter is




}
