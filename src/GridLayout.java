
import javax.swing.*;
import java.awt.*;

public class GridLayout extends JFrame {
    JButton b1 = new JButton("Show Phone Array");
    JButton b2 = new JButton("Hide the Array");
    JTextArea t1 = new JTextArea("");

    public GridLayout() {

        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        getContentPane().setLayout(gridbag);
//        constraints.fill = GridBagConstraints.HORIZONTAL;
        setSize(800,600);

        constraints.gridx = 0;
        constraints.gridy = 0;
        gridbag.setConstraints(b1, constraints);
        getContentPane().add(b1);

        constraints.gridx = 1;
        constraints.gridy = 0;
        gridbag.setConstraints(b2, constraints);
        getContentPane().add(b2);

        constraints.gridwidth = 2;
        constraints.gridx = 0;
        constraints.gridy = 2;
        gridbag.setConstraints(t1, constraints);
//        t1.setSize(600,500);
        getContentPane().add(t1);

        setVisible(true);
    }
}

