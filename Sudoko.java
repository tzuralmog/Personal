import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Sudoko extends JFrame{

    public Sudoko(String name) {
        super(name);
        // setResizable(false);
    }

    public void addComponentsToPane(final Container pane) {
        final JPanel compsToExperiment = new JPanel();
        compsToExperiment.setLayout(new GridLayout(3,3));
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        Sudoko frame = new Sudoko("Sudoko");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // calls above function
        frame.addComponentsToPane(frame.getContentPane());
        
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
