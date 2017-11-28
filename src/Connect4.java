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

    public int counter = 1; // Turn counter, odds - blue, evens - red Global variable
    public Color color = Color.black; //sets global color
    public Connect4() {
        setTitle("Connect4");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 700); // Set width and height to 800x800


    }
    




}
