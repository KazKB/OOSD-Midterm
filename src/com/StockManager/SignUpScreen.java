package com.StockManager;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class SignUpScreen {
    public User user;

    SignUpScreen() {
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
        JLabel titleLabel = new JLabel("Sign Up");
        titleLabel.setForeground(Color.black);
        titleLabel.setFont(titleFont);
        titleLabel.setBounds(250 - titleLabel.getPreferredSize().width, 10, titleLabel.getPreferredSize().width, titleLabel.getPreferredSize().height);
        panel.add(titleLabel);

        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setForeground(Color.black);
        firstNameLabel.setFont(regularFont);
        firstNameLabel.setBounds(100, 80, firstNameLabel.getPreferredSize().width, firstNameLabel.getPreferredSize().height);
        panel.add(firstNameLabel);

        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setForeground(Color.black);
        lastNameLabel.setFont(regularFont);
        lastNameLabel.setBounds(100, 110, lastNameLabel.getPreferredSize().width, lastNameLabel.getPreferredSize().height);
        panel.add(lastNameLabel);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.black);
        emailLabel.setFont(regularFont);
        emailLabel.setBounds(100, 140, emailLabel.getPreferredSize().width, emailLabel.getPreferredSize().height);
        panel.add(emailLabel);

        JLabel typeLabel = new JLabel("Type:");
        typeLabel.setForeground(Color.black);
        typeLabel.setFont(regularFont);
        typeLabel.setBounds(100, 170, typeLabel.getPreferredSize().width, typeLabel.getPreferredSize().height);
        panel.add(typeLabel);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setForeground(Color.black);
        idLabel.setFont(regularFont);
        idLabel.setBounds(100, 200, idLabel.getPreferredSize().width, idLabel.getPreferredSize().height);
        panel.add(idLabel);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.black);
        passwordLabel.setFont(regularFont);
        passwordLabel.setBounds(100, 230, passwordLabel.getPreferredSize().width, passwordLabel.getPreferredSize().height);
        panel.add(passwordLabel);

        JLabel errorLabel = new JLabel();
        errorLabel.setForeground(Color.black);
        errorLabel.setFont(regularFont);
        errorLabel.setBounds(0, 350, 500, 100);
        panel.add(errorLabel);

        //TextFields
        JTextField firstNameTextField = new JTextField();
        firstNameTextField.setFont(regularFont);
        firstNameTextField.setBounds(220, 80, 100, firstNameLabel.getPreferredSize().height);
        firstNameTextField.setBorder(null);
        panel.add(firstNameTextField);

        JTextField lastNameTextField = new JTextField();
        lastNameTextField.setFont(regularFont);
        lastNameTextField.setBounds(220, 110, 100, lastNameLabel.getPreferredSize().height);
        lastNameTextField.setBorder(null);
        panel.add(lastNameTextField);

        JTextField emailTextField = new JTextField();
        emailTextField.setFont(regularFont);
        emailTextField.setBounds(220, 140, 100, emailLabel.getPreferredSize().height);
        emailTextField.setBorder(null);
        panel.add(emailTextField);

        JTextField typeTextField = new JTextField();
        typeTextField.setFont(regularFont);
        typeTextField.setBounds(220, 170, 100, typeLabel.getPreferredSize().height);
        typeTextField.setBorder(null);
        panel.add(typeTextField);

        JTextField idTextField = new JTextField();
        idTextField.setFont(regularFont);
        idTextField.setBounds(220, 200, 100, idLabel.getPreferredSize().height);
        idTextField.setBorder(null);
        panel.add(idTextField);

        //PasswordField
        JPasswordField passwordTextField = new JPasswordField();
        passwordTextField.setFont(regularFont);
        passwordTextField.setBounds(220, 230, 100, passwordLabel.getPreferredSize().height);
        passwordTextField.setBorder(null);
        panel.add(passwordTextField);

        //Button
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setBackground(Color.GRAY);
        signUpButton.setForeground(Color.black);
        signUpButton.setFont(regularFont);
        signUpButton.setBounds(265 - signUpButton.getPreferredSize().width, 300, signUpButton.getPreferredSize().width, signUpButton.getPreferredSize().height);
        signUpButton.setFocusPainted(false);
        signUpButton.addActionListener(e -> {
            //Sets up Scanner to read the "," as a separator
            Scanner read = null;
            try {
                read = new Scanner(new File("UserDetails.txt"));
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            assert read != null;
            read.useDelimiter(",");

            String check;
            boolean exist = false;

            //Checks to see if id exists in the file
            while (read.hasNext()) {
                check = read.next();

                if (check.equals(idTextField.getText())) {
                    exist = true;
                    break;
                }
            }
            read.close();
            //Checks if fields are empty, if type is admin or regular, and if password is greater than 8
            //Also checks if the id exists
            //Then adds details to file
            if (!exist) {
                if (!(firstNameTextField.getText().isEmpty() || lastNameTextField.getText().isEmpty() || emailTextField.getText().isEmpty() || idTextField.getText().isEmpty() || typeTextField.getText().isEmpty() || String.valueOf(passwordTextField.getPassword()).isEmpty())) {
                    if (typeTextField.getText().equalsIgnoreCase("admin") || typeTextField.getText().equalsIgnoreCase("regular")) {
                        if (passwordTextField.getPassword().length >= 8) {
                            String[] userDetails = new String[6];

                            userDetails[0] = firstNameTextField.getText();
                            userDetails[1] = lastNameTextField.getText();
                            userDetails[2] = emailTextField.getText();
                            userDetails[3] = typeTextField.getText();
                            userDetails[4] = idTextField.getText();
                            userDetails[5] = String.valueOf(passwordTextField.getPassword());

                            user = new User(userDetails[0], userDetails[1], userDetails[2], userDetails[3], userDetails[4], userDetails[5]);

                            try {
                                //Creates a file writer that writes the users details to a file
                                FileWriter writer = new FileWriter("UserDetails.txt", true);

                                for (int i = 0; i < 5; i++) {
                                    writer.append(userDetails[i]).append(",");
                                }
                                writer.append(userDetails[5]);
                                writer.append("\n");
                                writer.close();

                                //CLoses this window and open menu selection screen
                                frame.dispose();
                                new MenuSelection();
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            errorLabel.setText("Password must be 8 or more characters!");
                        }
                    } else {
                        errorLabel.setText("Account type must be either regular or admin!");
                    }
                } else {
                    errorLabel.setText("Can not have empty fields!");
                }
            } else {
                errorLabel.setText("Id exists!");
            }
        });
        panel.add(signUpButton);

        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
