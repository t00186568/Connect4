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

    public int counter = 1;
    public Color color = Color.black; //sets global color
    public Connect4(){
       setTitle("Connect4");

       setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,700); // Set width and height to 800x800

        setLayout(new FlowLayout(FlowLayout.LEFT));
        setVisible(true);

         // Turn counter, odds - blue, evens - red


        //Button 1
        JButton slot1=new JButton("Slot 1"); //declare new button
        slot1.setEnabled(true); //enable new button
        add(slot1); //Add new button to jFrame
        slot1.setBounds(10,610,100,50); // Set new Button Size and Location
        slot1.addActionListener(new ActionListener(){
                int i=-1; //Initial array reference is -1, when clicked i++ is used which will fill in position 0 in array
                public void actionPerformed(ActionEvent e){


                            i++;
                           if(Array.slotStatus[1][i] == 0) {
                               if (counter % 2 == 1) { //Finds which players turn is active - if modulus has a remainder it is Player 1's turn

                                   Array.slotStatus[0][i] = 1; //Assigns player 1 to relevant Array entry


                                   getGraphics().fillOval( 25, ((550)-(i*100)), 80, 80); //fills in relevant oval

                                   repaint(); //redraws screen to show new oval
                                   System.out.println(Arrays.deepToString(Array.slotStatus)); //prints array status to console - will be removed



                               }else if(counter % 2 == 0){
                                   Array.slotStatus[0][i] = 2;
                                   getGraphics().fillOval(25, (550)-(i*100), 80, 80);
                                   repaint();

                               }

                           }



                       System.out.print(Array.slotStatus[1][0]);
                        counter++;
                }
            });



        //Button2
        JButton slot2=new JButton("Slot 2");
        slot2.setBounds(120,610,100,50);
        slot2.setEnabled(true);
        add(slot2);

        //Button3
        JButton slot3=new JButton("Slot 3");
        slot3.setBounds(230,610,100,50);
        slot3.setEnabled(true);
        add(slot3);

        //Button4
        JButton slot4=new JButton("Slot 4");
        slot4.setBounds(340,610,100,50);
        slot4.setEnabled(true);
        add(slot4);

        //Button5
        JButton slot5=new JButton("Slot 5");
        slot5.setBounds(450,610,100,50);
        slot5.setEnabled(true);
        add(slot5);

        //Button6
        JButton slot6=new JButton("Slot 6");
        slot6.setBounds(560,610,100,50);
        slot6.setEnabled(true);
        add(slot6);

        //Button2
        JButton slot7=new JButton("Slot 7");
        slot7.setBounds(670,610,100,50);
        slot7.setEnabled(true);
        add(slot7);


    }



    public void paint(Graphics g) {
        g.setColor(color); //Sets Outline color to black using global variable

        int x=25, y=50;

        for(x=25; x<745; x=x+110){ //Outer loop draws horizontal ovals

            for(y=50; y<600; y=y+100){ //inner loop draws vertical ovals


                    g.drawOval(x, y, 80, 80);
                }
        }

        /*for(int i = 0; i<6; i++){
            if(Array.slotStatus[i][i] == 1){
                g.setColor(Color.RED);
                g.fillOval((i*135), (i*100), 80, 80);

            }
        }*/

    }


//int array - 0 = empty, 1= red or 2 = blue
// Counter++ for turn tracking - will modulus to check who's turn it is, red is evens, blue is odds
// Each button will have a counter to know how many rows up each counter is




}
