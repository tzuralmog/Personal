import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Sudoko {

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("FrameDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create the menu bar.  Make it have a green background.
        JMenuBar greenMenuBar = new JMenuBar();
        greenMenuBar.setOpaque(true);
        greenMenuBar.setBackground(new Color(154, 165, 127));
        greenMenuBar.setPreferredSize(new Dimension(200, 20));

        JLabel emptyLabel = new JLabel("Base");
        emptyLabel.setPreferredSize(new Dimension(175, 100));
        frame.setJMenuBar(greenMenuBar);
        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

        

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    // public static void main(String[] args) {
    //     System.out.println("Hello, Sudoko.");
       
    // }
}
