import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class gameInfo  {

    //http://www.java2s.com/Code/Java/Swing-JFC/GridBagLayoutwithanchorconstraints.htm
    GridBagConstraints gbc = new GridBagConstraints();
    //Never ended up using this layout manager but I had referenced it from here

    public static void main(String[] args){
        new Connect4();
        new gameInfo();

    }

    public static JFrame  gameInfo;
    public static JPanel infoWindow;

    gameInfo(){


        gameInfo = new JFrame();
        gameInfo.setTitle("Connect4");
        gameInfo.setDefaultCloseOperation(EXIT_ON_CLOSE);

        gameInfo.setSize(850,500);
        gameInfo.setLocation(500,500);

        //REVISED -- https://stackoverflow.com/questions/18794324/grid-of-buttons-actionlistener
        //Generating grid of JButtons roughly adapted from here
        //JButton grid[][] = new JButton[6][7];  //Array for drawing JButtons in grid

        gameInfo.setLayout(new FlowLayout());
        gameInfo.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);




        //Right side
        infoWindow = new JPanel();
        infoWindow.setSize(800,600);
        infoWindow.setLocation(500,500);
        infoWindow.setBackground(Color.white);
        infoWindow.setPreferredSize(new Dimension(200, 400));

        //Border layout set up referenced from https://docs.oracle.com/javase/7/docs/api/java/awt/BorderLayout.html
        infoWindow.setLayout(new BorderLayout());


        //Connect 4 Title
        JLabel title = new JLabel("Connect 4", JLabel.CENTER);
        title.setFont(new Font("Verdana",1,24)); //Changing font referenced from here http://www.java2s.com/Code/JavaAPI/java.awt/newFontStringnameintstyleintsize.htm
        infoWindow.add(title, BorderLayout.NORTH);



        JPanel buttonPanel = new JPanel();



        //Exit Button
        JButton quit= new JButton("Exit");
        buttonPanel.add(quit);
        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);


            }
        } );

        //Save Button
        JButton save= new JButton("Save");
        buttonPanel.add(save);
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)  {



                try {
                    save();
                } catch (IOException e1){ //using e1 as e used below
                    e1.printStackTrace();
                }



            }
        } );

        infoWindow.add(buttonPanel, BorderLayout.SOUTH);









        //infoWindow.add(turn, BorderLayout.CENTER);

        gameInfo.add(Connect4.connect4);
        gameInfo.add(infoWindow);
        infoWindow.setVisible(true);
        gameInfo.setVisible(true);

    }



    //Adapted from https://stackoverflow.com/questions/32235900/writing-array-to-txt-java
    public void save() throws IOException{
        try {
            FileWriter file = new FileWriter("ArrayOutput.txt", true);
            for(int i = 0; i < Logic.playGrid.length; i++){

                for(int j = 0; j < Logic.playGrid.length; j++){
                    file.write(Logic.playGrid[i][j]+" ");
                }
            }
            file.write("\n");

            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}









