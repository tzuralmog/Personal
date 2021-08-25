import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Sudoko extends JFrame{
    final static int maxGap = 20;
    static int cols = 9 ,rows = 9;

    public Sudoko(String name) {
        super(name);
        // setResizable(false);
    }

    public void addComponentsToPane(final Container pane) {
        final JPanel compsToExperiment = new JPanel();
        compsToExperiment.setLayout(new GridLayout(cols,rows));

        // JButton b = new JButton("Just fake button");
        // Dimension buttonSize = b.getPreferredSize();

        // compsToExperiment.setPreferredSize(new Dimension((int)(buttonSize.getWidth() * 2.5)+maxGap, (int)(buttonSize.getHeight() * 3.5)+maxGap * 2));
        // compsToExperiment.add(new SudokoButton("Button 1"));
        for(int i = 0; i< rows; i++){
            for(int j = 0; j< cols; j++){
                compsToExperiment.add(new SudokoButton("Button X" + (i +1) + " Y" + (j +1)));
            }
        }
        // compsToExperiment.add(new SudokoButton("Button 2"));
        // compsToExperiment.add(new SudokoButton("Button 3"));
        // compsToExperiment.add(new SudokoButton("Long-Named Button 4"));
        // compsToExperiment.add(new SudokoButton("5"));

        //Process the Apply gaps button press
        // applyButton.addActionListener(new ActionListener(){
        //     public void actionPerformed(ActionEvent e){
        //         //Get the horizontal gap value
        //         String horGap = (String)horGapComboBox.getSelectedItem();
        //         //Get the vertical gap value
        //         String verGap = (String)verGapComboBox.getSelectedItem();
        //         //Set up the horizontal gap value
        //         experimentLayout.setHgap(Integer.parseInt(horGap));
        //         //Set up the vertical gap value
        //         experimentLayout.setVgap(Integer.parseInt(verGap));
        //         //Set up the layout of the buttons
        //         experimentLayout.layoutContainer(compsToExperiment);
        //     }
        // });

        pane.add(compsToExperiment, BorderLayout.NORTH);
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
