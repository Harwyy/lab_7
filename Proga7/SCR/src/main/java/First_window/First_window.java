package First_window;

import javax.swing.*;
import java.awt.*;

public class First_window {
    public JFrame frame = new JFrame();
    public JPanel panel;
    public Auto auto = new Auto();
    public Reg reg = new Reg();
    public String[] array = {"Eng", "Rus", "Ch"};
    public JComboBox comboBox = new JComboBox(array);

    public First_window() {
        workWithFrame();
    }

    public void workWithFrame(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Login process...");
        frame.setLayout(new GridBagLayout());
        frame.setSize(new Dimension(450, 600));
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); // centring
        frame.getContentPane().setBackground(new Color(196, 255, 209));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTH;
        frame.add(comboBox, gbc);
    }

    public void autoWindow(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 0;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.gridwidth = 2;
        panel = auto.workWithPanel(frame);
        frame.add(panel, gbc);
    }

    public void regWindow(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 0;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.gridwidth = 2;
        panel = reg.workWithPanel(frame);
        frame.add(panel, gbc);
    }

    public void setInvis(){
        frame.setVisible(false);
    }

    public void setVisibl(){
        frame.setVisible(true);
    }
}
