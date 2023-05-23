package MainWindow;

import javax.swing.*;
import java.awt.*;

public class Main_window {
    public JFrame frame = new JFrame();
    public JPanel panel;
    public JButton info = new JButton("info");
    public JButton show = new JButton("show db");
    public JButton add = new JButton("add film");
    public JButton pfas = new JButton("print field ascending genre");
    public JButton mboc = new JButton("min by oscars count");
    public JButton aooc = new JButton("average of oscars count");

    public Main_window() {
        workWithFrame();
    }

    public void workWithFrame(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Main programm");
        frame.setLayout(new FlowLayout());
        frame.setSize(new Dimension(700, 600));
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); // centring
        frame.getContentPane().setBackground(new Color(196, 255, 209));
    }

    public void addButton(){
        frame.add(info);
        frame.add(show);
        frame.add(add);
        frame.add(pfas);
        frame.add(mboc);
        frame.add(aooc);
    }
}
