package First_window;

import javax.swing.*;
import java.awt.*;

public class Auto {

    public JPanel panel = new JPanel();;
    public JLabel authorization = new JLabel("Authorization");
    public JLabel username = new JLabel("Username ");
    public JTextField usernameTF = new JTextField(12);
    public JLabel passwordLabel = new JLabel("Password ");
    public JPasswordField password = new JPasswordField(12);
    public JCheckBox checkPassword = new JCheckBox("Show password");
    public JButton login = new JButton("Login");
    public JButton register = new JButton("Register");


    public JPanel workWithPanel(JFrame frame){

        panel.setBackground(Color.white);
        panel.setPreferredSize(new Dimension((int) (frame.getSize().width * 0.80), (int) (frame.getSize().height * 0.83)));
        panel.setLayout(new GridBagLayout());
        panel.setVisible(true);

//        GridBagConstraints gbc = new GridBagConstraints();
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

    public void workWithAuthorizationLabel(){

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

    public void workWithUsernameLabel(){

        username.setFont(new Font("Arial", Font.TYPE1_FONT, 15));
        username.setForeground(Color.GRAY);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridheight = 2;
        gbc.gridwidth = 1;

        panel.add(username, gbc);
    }

    public void workWithUserNameTF(){

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridheight = 2;
        gbc.gridwidth = 1;

        panel.add(usernameTF, gbc);
    }

    public void workWithPasswordLabel(){

        passwordLabel.setFont(new Font("Arial", Font.TYPE1_FONT, 15));
        passwordLabel.setForeground(Color.GRAY);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridheight = 2;
        gbc.gridwidth = 1;

        panel.add(passwordLabel, gbc);
    }

    public void workWithPasswordF(){

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridheight = 2;
        gbc.gridwidth = 1;

        panel.add(password, gbc);
    }

    public void workWithCheckBox(){

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridheight = 2;
        gbc.gridwidth = 1;

        panel.add(checkPassword, gbc);
    }

    public void workWithLoginButton(){

        login.setSize(new Dimension(20, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.gridheight = 2;
        gbc.gridwidth = 1;

        panel.add(login, gbc);
    }

    public void workWithRegistButton(){

        register.setSize(new Dimension(20, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridheight = 2;
        gbc.gridwidth = 1;

        panel.add(register, gbc);
    }

    public void getInvisible(){
        panel.setVisible(false);
    }

    public void getVisible(){
        panel.setVisible(true);
    }

}
