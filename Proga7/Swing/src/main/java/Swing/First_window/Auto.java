package Swing.First_window;

import javax.swing.*;
import java.awt.*;

public class Auto {

    protected JFrame frame;
    protected JPanel panel;
    protected JLabel authorization;
    protected JLabel username;
    protected JTextField usernameTF;
    protected JLabel passwordLabel;
    protected JPasswordField password;
    protected JCheckBox checkPassword;
    protected JButton login;
    protected JButton register;

    public Auto(JFrame frame) {
        this.frame = frame;
    }

    protected JPanel workWithPanel(){
        panel = new JPanel();

        panel.setBackground(Color.white);
        panel.setPreferredSize(new Dimension((int) (frame.getSize().width * 0.80), (int) (frame.getSize().height * 0.83)));
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        workWithAuthorizationLabel();
        workWithUsernameLabel();
        workWithUserNameTF();
        workWithPasswordLabel();
        workWithPasswordF();
        workWithCheckBox();
        workWithLoginButton();
        workWithRegistButton();

        return panel;
    }

    private void workWithAuthorizationLabel(){
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

    private void workWithUsernameLabel(){
        username = new JLabel("Username ");

        username.setFont(new Font("Arial", Font.TYPE1_FONT, 15));
        username.setForeground(Color.GRAY);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridheight = 2;
        gbc.gridwidth = 1;

        panel.add(username, gbc);
    }

    private void workWithUserNameTF(){
        usernameTF = new JTextField(12);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridheight = 2;
        gbc.gridwidth = 1;

        panel.add(usernameTF, gbc);
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
