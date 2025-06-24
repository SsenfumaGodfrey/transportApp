package com.mycompany.exhibitionregistration;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExhibitionGUI extends JFrame {

    private JTextField regIdField, nameField, facultyField, projectTitleField, contactField, emailField;
    private JLabel imageLabel;
    private String imagePath = "";

    public ExhibitionGUI() {
        setTitle("VUE Exhibition Registration");
        setSize(640, 750);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font labelFont = new Font("Segoe UI", Font.PLAIN, 14);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 13);

        // Header
        JLabel header = new JLabel("Innovation & Technology Exhibition");
        header.setBounds(150, 10, 400, 30);
        header.setFont(new Font("Segoe UI", Font.BOLD, 18));
        add(header);

        // Registration ID
        JLabel regIdLabel = new JLabel("Registration ID:");
        regIdLabel.setBounds(30, 60, 150, 25);
        regIdLabel.setFont(labelFont);
        add(regIdLabel);

        regIdField = new JTextField();
        regIdField.setBounds(180, 60, 400, 25);
        regIdField.setFont(fieldFont);
        add(regIdField);

        // Student Name
        JLabel nameLabel = new JLabel("Student Name:");
        nameLabel.setBounds(30, 100, 150, 25);
        nameLabel.setFont(labelFont);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(180, 100, 400, 25);
        nameField.setFont(fieldFont);
        add(nameField);

        // Faculty
        JLabel facultyLabel = new JLabel("Faculty:");
        facultyLabel.setBounds(30, 140, 150, 25);
        facultyLabel.setFont(labelFont);
        add(facultyLabel);

        facultyField = new JTextField();
        facultyField.setBounds(180, 140, 400, 25);
        facultyField.setFont(fieldFont);
        add(facultyField);

        // Project Title
        JLabel projectLabel = new JLabel("Project Title:");
        projectLabel.setBounds(30, 180, 150, 25);
        projectLabel.setFont(labelFont);
        add(projectLabel);

        projectTitleField = new JTextField();
        projectTitleField.setBounds(180, 180, 400, 25);
        projectTitleField.setFont(fieldFont);
        add(projectTitleField);

        // Contact Number
        JLabel contactLabel = new JLabel("Contact Number:");
        contactLabel.setBounds(30, 220, 150, 25);
        contactLabel.setFont(labelFont);
        add(contactLabel);

        contactField = new JTextField();
        contactField.setBounds(180, 220, 400, 25);
        contactField.setFont(fieldFont);
        add(contactField);

        // Email Address
        JLabel emailLabel = new JLabel("Email Address:");
        emailLabel.setBounds(30, 260, 150, 25);
        emailLabel.setFont(labelFont);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(180, 260, 400, 25);
        emailField.setFont(fieldFont);
        add(emailField);

        // Upload Button
        JButton uploadButton = new JButton("Upload Project Image");
        uploadButton.setBounds(30, 310, 200, 30);
        add(uploadButton);

        imageLabel = new JLabel("No Image Selected", SwingConstants.CENTER);
        imageLabel.setBounds(180, 310, 400, 180);
        imageLabel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                "Project Prototype",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                labelFont
        ));
        add(imageLabel);

        // Add Buttons
        String[] buttonNames = {"Register", "Search", "Update", "Delete", "Clear", "Exit"};
        int x = 60;
        for (String name : buttonNames) {
            JButton btn = new JButton(name);
            btn.setBounds(x, 520, 90, 35);
            add(btn);
            x += 95;

            // Attach action listeners
            if (name.equals("Exit")) {
                btn.addActionListener(e -> System.exit(0));
            } else if (name.equals("Clear")) {
                btn.addActionListener(e -> clearFields());
            } else if (name.equals("Register")) {
                btn.addActionListener(e -> register());
            } else if (name.equals("Search")) {
                btn.addActionListener(e -> search());
            } else if (name.equals("Update")) {
                btn.addActionListener(e -> update());
            } else if (name.equals("Delete")) {
                btn.addActionListener(e -> delete());
            }
        }

        // Upload Button Listener
        uploadButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                imagePath = fileChooser.getSelectedFile().getAbsolutePath();
                ImageIcon icon = new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(400, 180, Image.SCALE_SMOOTH));
                imageLabel.setIcon(icon);
                imageLabel.setText("");
            }
        });

        setVisible(true);
    }

    private void clearFields() {
        regIdField.setText("");
        nameField.setText("");
        facultyField.setText("");
        projectTitleField.setText("");
        contactField.setText("");
        emailField.setText("");
        imageLabel.setIcon(null);
        imageLabel.setText("No Image Selected");
        imagePath = "";
    }

    // Placeholder methods for button actions
    private void register() {
        JOptionPane.showMessageDialog(this, "Register button clicked!");
        // Add registration logic here
    }

    private void search() {
        JOptionPane.showMessageDialog(this, "Search button clicked!");
        // Add search logic here
    }

    private void update() {
        JOptionPane.showMessageDialog(this, "Update button clicked!");
        // Add update logic here
    }

    private void delete() {
        JOptionPane.showMessageDialog(this, "Delete button clicked!");
        // Add delete logic here
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ExhibitionGUI());
    }
}