package Swing.First_window;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.nio.file.Paths;

public class First_window {
    private JFrame frame;
    private JButton login;
    private JButton register;
    private JTextField name;
    private JPasswordField password;
    private JLabel nameLabel;
    private JLabel passwordLabel;
    private JCheckBox checkPassword;
    private JPanel panel;
    private JPanel panelReg;
    private JLabel authorization;


    public First_window() {
        frame = new JFrame();
        panel = new JPanel();

        workWithFrame();
        workWithPanel();
    }

    private void workWithFrame(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Login process...");
        frame.setLayout(new GridBagLayout());
        frame.setSize(new Dimension(450, 600));
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); // centring
        frame.getContentPane().setBackground(new Color(196, 255, 209));
    }

    private void workWithPanel(){
        panel.setBackground(Color.white);
        panel.setPreferredSize(new Dimension((int) (frame.getSize().width * 0.80), (int) (frame.getSize().height * 0.83)));
        panel.setBorder(new LineBorder(new Color(196, 255, 209), 34, true));
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        workWithAutoLabel();
        workWithnameLabel();
        workWithNameTF();
        workWithPasswordLabel();
        workWithPasswordF();
        workWithCheckBox();
        workWithLoginButton();
        workWithRegistButton();
        frame.add(panel, gbc);
    }

    private void workWithAutoLabel(){
        authorization = new JLabel("Authorization");
        authorization.setFont(new Font("Arial", Font.TYPE1_FONT, 30));
        authorization.setForeground(Color.GRAY);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.gridwidth = 2;
        panel.add(authorization, gbc);
    }

    private void workWithnameLabel(){
        nameLabel = new JLabel("Username ");
        nameLabel.setFont(new Font("Arial", Font.TYPE1_FONT, 15));
        nameLabel.setForeground(Color.GRAY);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridheight = 2;
        gbc.gridwidth = 1;
        panel.add(nameLabel, gbc);
    }

    private void workWithNameTF(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridheight = 2;
        gbc.gridwidth = 1;
        panel.add(name, gbc);
    }

    private void workWithPasswordLabel(){
        passwordLabel = new JLabel("Password ");
        passwordLabel.setFont(new Font("Arial", Font.TYPE1_FONT, 15));
        passwordLabel.setForeground(Color.GRAY);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridheight = 2;
        gbc.gridwidth = 1;
        panel.add(passwordLabel, gbc);
    }

    private void workWithPasswordF(){
        password = new JPasswordField(12);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridheight = 2;
        gbc.gridwidth = 1;
        panel.add(password, gbc);
    }

    private void workWithCheckBox(){
        checkPassword = new JCheckBox("Show password");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridheight = 2;
        gbc.gridwidth = 1;
        panel.add(checkPassword, gbc);
    }

    private void workWithLoginButton(){
        login = new JButton("Login");
        login.setSize(new Dimension(20, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.gridheight = 2;
        gbc.gridwidth = 1;
        panel.add(login, gbc);
    }

    private void workWithRegistButton(){
        register = new JButton("Register");
        register.setSize(new Dimension(20, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridheight = 2;
        gbc.gridwidth = 1;
        panel.add(register, gbc);
    }


}
