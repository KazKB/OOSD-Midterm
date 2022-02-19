package com.StockManager;

import javax.swing.*;
import java.awt.*;

public class MenuSelection {
    MenuSelection() {
        //Fonts
        Font titleFont = new Font("DialogInput", Font.BOLD, 20);
        Font regularFont = new Font("DialogInput", Font.BOLD, 12);

        //Frame
        JFrame frame = new JFrame("Stock Manager");
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);

        //Panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.darkGray);

        //Labels
        JLabel titleLabel = new JLabel("Menu Selection");
        titleLabel.setForeground(Color.black);
        titleLabel.setFont(titleFont);
        titleLabel.setBounds(250 - titleLabel.getPreferredSize().width, 10, titleLabel.getPreferredSize().width, titleLabel.getPreferredSize().height);
        panel.add(titleLabel);

        JLabel errorLabel = new JLabel();
        errorLabel.setForeground(Color.black);
        errorLabel.setFont(regularFont);
        errorLabel.setBounds(0, 400, 500, 100);
        panel.add(errorLabel);

        //Buttons
        JButton createStockButton = new JButton("Create Stock");
        createStockButton.setBackground(Color.GRAY);
        createStockButton.setForeground(Color.black);
        createStockButton.setFont(regularFont);
        createStockButton.setBounds(10, 50, createStockButton.getPreferredSize().width, createStockButton.getPreferredSize().height);
        createStockButton.setFocusPainted(false);
        panel.add(createStockButton);

        JButton editStockButton = new JButton("Edit Stock");
        editStockButton.setBackground(Color.GRAY);
        editStockButton.setForeground(Color.black);
        editStockButton.setFont(regularFont);
        editStockButton.setBounds(150, 50, editStockButton.getPreferredSize().width, editStockButton.getPreferredSize().height);
        editStockButton.setFocusPainted(false);
        panel.add(editStockButton);

//        JButton editStockButton = new JButton("Edit Stock");
//        editStockButton.setBackground(Color.GRAY);
//        editStockButton.setForeground(Color.black);
//        editStockButton.setFont(regularFont);
//        editStockButton.setBounds(150, 50, editStockButton.getPreferredSize().width, editStockButton.getPreferredSize().height);
//        editStockButton.setFocusPainted(false);
//        panel.add(editStockButton);


        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
