package First_window;

import javax.swing.*;
import java.awt.*;

public class Reg {

    public JPanel panel = new JPanel();;
    public JLabel registration = new JLabel("Registration");
    public JLabel username = new JLabel("Username ");
    public JTextField usernameTF = new JTextField(12);
    public JLabel passwordLabel1 = new JLabel("Password ");
    public JPasswordField password1 = new JPasswordField(12);
    public JLabel passwordLabel2 = new JLabel("Repeat ");
    public JPasswordField password2 = new JPasswordField(12);
    public JCheckBox checkPassword = new JCheckBox("Show password");
    public JButton login = new JButton("Login");
    public JButton register = new JButton("Register");


    public JPanel workWithPanel(JFrame frame){

        panel.setBackground(Color.white);
        panel.setPreferredSize(new Dimension((int) (frame.getSize().width * 0.80), (int) (frame.getSize().height * 0.83)));
        panel.setLayout(new GridBagLayout());
        panel.setVisible(true);

        workWithAuthorizationLabel();
        workWithUsernameLabel();
        workWithUserNameTF();
        workWithPasswordLabel1();
        workWithPasswordF1();
        workWithPasswordLabel2();
        workWithPasswordF2();
        workWithCheckBox();
        workWithLoginButton();
        workWithRegistButton();

        return panel;
    }

    public void workWithAuthorizationLabel(){

        registration.setFont(new Font("Arial", Font.TYPE1_FONT, 30));
        registration.setForeground(Color.GRAY);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.gridwidth = 2;

        panel.add(registration, gbc);
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

    public void workWithPasswordLabel1(){

        passwordLabel1.setFont(new Font("Arial", Font.TYPE1_FONT, 15));
        passwordLabel1.setForeground(Color.GRAY);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridheight = 2;
        gbc.gridwidth = 1;

        panel.add(passwordLabel1, gbc);
    }

    public void workWithPasswordF1(){

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridheight = 2;
        gbc.gridwidth = 1;

        panel.add(password1, gbc);
    }

    public void workWithPasswordLabel2(){

        passwordLabel2.setFont(new Font("Arial", Font.TYPE1_FONT, 15));
        passwordLabel2.setForeground(Color.GRAY);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridheight = 2;
        gbc.gridwidth = 1;

        panel.add(passwordLabel2, gbc);
    }

    public void workWithPasswordF2(){

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridheight = 2;
        gbc.gridwidth = 1;

        panel.add(password2, gbc);
    }

    public void workWithCheckBox(){

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.gridheight = 2;
        gbc.gridwidth = 1;

        panel.add(checkPassword, gbc);
    }

    public void workWithLoginButton(){

        login.setSize(new Dimension(20, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridheight = 2;
        gbc.gridwidth = 1;

        panel.add(login, gbc);
    }

    public void workWithRegistButton(){

        register.setSize(new Dimension(20, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 11;
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
