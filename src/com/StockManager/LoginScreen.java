package com.StockManager;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class LoginScreen {
    public User user;

    LoginScreen() {
        //Fonts
        Font titleFont = new Font("DialogInput", Font.BOLD, 20);
        Font regularFont = new Font("DialogInput", Font.BOLD, 16);

        //Frame
        JFrame frame = new JFrame("Stock Manager");
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);

        //Panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.darkGray);

        //Labels
        JLabel titleLabel = new JLabel("Log In");
        titleLabel.setForeground(Color.black);
        titleLabel.setFont(titleFont);
        titleLabel.setBounds(250 - titleLabel.getPreferredSize().width, 10, titleLabel.getPreferredSize().width, titleLabel.getPreferredSize().height);
        panel.add(titleLabel);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setForeground(Color.black);
        idLabel.setFont(regularFont);
        idLabel.setBounds(120, 80, idLabel.getPreferredSize().width,idLabel.getPreferredSize().height);
        panel.add(idLabel);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.black);
        passwordLabel.setFont(regularFont);
        passwordLabel.setBounds(120, 110, passwordLabel.getPreferredSize().width, passwordLabel.getPreferredSize().height);
        panel.add(passwordLabel);

        JLabel errorLabel = new JLabel();
        errorLabel.setForeground(Color.black);
        errorLabel.setFont(regularFont);
        errorLabel.setBounds(0, 350, 500, 100);
        panel.add(errorLabel);

        //TextField
        JTextField idTextField = new JTextField();
        idTextField.setFont(regularFont);
        idTextField.setBounds(220, 80, 100, idLabel.getPreferredSize().height);
        panel.add(idTextField);

        //PasswordField
        JPasswordField passwordTextField = new JPasswordField();
        passwordTextField.setFont(regularFont);
        passwordTextField.setBounds(220, 110, 100, passwordLabel.getPreferredSize().height);
        panel.add(passwordTextField);

        //Buttons
        JButton logInButton = new JButton("Log In");
        logInButton.setBackground(Color.GRAY);
        logInButton.setForeground(Color.black);
        logInButton.setFont(regularFont);
        logInButton.setBounds(260 - logInButton.getPreferredSize().width, 200, logInButton.getPreferredSize().width, logInButton.getPreferredSize().height);
        logInButton.setFocusPainted(false);
        logInButton.addActionListener(e -> {
            //Sets up Scanner to read the "," as a separator
            Scanner read = null;
            try {
                read = new Scanner(new File("UserDetails.txt"));
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            assert read != null;
            read.useDelimiter(",");

            String check, type = null;
            boolean exist = false, exist2 = false;

            //Checks to see if id and password exists in the file
            while (read.hasNext()) {
                check = read.next();

                if (check.equalsIgnoreCase("admin") || check.equalsIgnoreCase("regular")) {
                    type = check;
                }

                if (check.equals(idTextField.getText())) {
                    exist = true;
                    check = read.next();

                    if (check.equals(String.valueOf(passwordTextField.getPassword()))) {
                        exist2 = true;
                    }
                }

            }
            read.close();


            if (!(idTextField.getText().isEmpty() ||  String.valueOf(passwordTextField.getPassword()).isEmpty())) {
                if (exist) {
                    if (exist2) {
                        //CLoses this window and open menu selection screen
                        user = new User(type, idTextField.getText());
                        frame.dispose();
                        new MenuSelection();
                    } else {
                        errorLabel.setText("Password Incorrect!");
                    }
                }
                else {
                    errorLabel.setText("ID does not exist!");
                }
            }
            else {
                errorLabel.setText("Can not have empty fields!");
            }


        });
        panel.add(logInButton);

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setBackground(Color.GRAY);
        signUpButton.setForeground(Color.black);
        signUpButton.setFont(regularFont);
        signUpButton.setBounds(265 - signUpButton.getPreferredSize().width, 250, signUpButton.getPreferredSize().width, signUpButton.getPreferredSize().height);
        signUpButton.setFocusPainted(false);
        signUpButton.addActionListener(e -> {
            //CLoses this window and open sign up screen
            frame.dispose();
            new SignUpScreen();
        });
        panel.add(signUpButton);

        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
