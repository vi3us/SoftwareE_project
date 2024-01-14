

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class SignUpGUI implements ActionListener {
    // Components
    JFrame frame = new JFrame("Register");

    JButton backButton = new JButton("<-");

    JLabel firstNameLabel = new JLabel("First Name:");
    JLabel lastNameLabel = new JLabel("Last Name:");
    JTextField firstNameField = new JTextField();
    JTextField lastNameField = new JTextField();

    JLabel emailLabel = new JLabel("Email:");
    JTextField emailField = new JTextField();

    JLabel phoneNumberLabel = new JLabel("Phone Number:");
    JTextField phoneNumberField = new JTextField();

    JLabel dateOfBirthLabel = new JLabel("Date of Birth (DD/MM/YYYY):");
    JLabel separator = new JLabel("/");
    JLabel separator1 = new JLabel("/");
    JTextField day = new JTextField();
    JTextField month = new JTextField();
    JTextField year = new JTextField();

    JLabel addressLabel = new JLabel("Address:");
    JLabel cityLabel = new JLabel("City:");
    JLabel postcodeLabel = new JLabel("Postcode:");
    JTextField addressField = new JTextField();
    JTextField cityField = new JTextField();
    JTextField postcodeField = new JTextField();

    JButton submitButton = new JButton("Submit");
    JLabel submitLabel = new JLabel("");

    SignUpGUI() {
        // Setting the size and position of each component then adding it to the frame
        backButton.setBounds(10,10,50,25);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        frame.add(backButton);

        firstNameLabel.setBounds(10,60,75,25);
        frame.add(firstNameLabel);
        firstNameField.setBounds(120,60,200,25);
        frame.add(firstNameField);

        lastNameLabel.setBounds(10,110,75,25);
        frame.add(lastNameLabel);
        lastNameField.setBounds(120,110,200,25);
        frame.add(lastNameField);

        emailLabel.setBounds(10,160,75,25);
        frame.add(emailLabel);
        emailField.setBounds(120,160,200,25);
        frame.add(emailField);

        phoneNumberLabel.setBounds(10,210,150,25);
        frame.add(phoneNumberLabel);
        phoneNumberField.setBounds(120,210,200,25);
        frame.add(phoneNumberField);

        dateOfBirthLabel.setBounds(10,260,300,25);
        frame.add(dateOfBirthLabel);
        day.setBounds(190,260,30,25);
        frame.add(day);
        separator.setBounds(230,260,50,25);
        frame.add(separator);
        month.setBounds(250,260,30,25);
        frame.add(month);
        separator1.setBounds(290,260,50,25);
        frame.add(separator1);
        year.setBounds(310,260,60,25);
        frame.add(year);

        addressLabel.setBounds(10,330,75,25);
        frame.add(addressLabel);
        cityLabel.setBounds(10,380,75,25);
        frame.add(cityLabel);
        postcodeLabel.setBounds(10,430,75,25);
        frame.add(postcodeLabel);
        addressField.setBounds(80,330,200,25);
        frame.add(addressField);
        cityField.setBounds(80,380,200,25);
        frame.add(cityField);
        postcodeField.setBounds(80,430,200,25);
        frame.add(postcodeField);

        submitButton.setBounds(10,500,100,30);
        submitButton.setFocusable(false);
        submitButton.addActionListener(this);
        frame.add(submitButton);
        submitLabel.setBounds(200,500,350,25);
        frame.add(submitLabel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public boolean datachecks() {
        boolean pass = true;
        
        if (firstNameField.getText().trim().equals("") || lastNameField.getText().trim().equals("") || emailField.getText().trim().equals("") || phoneNumberField.getText().trim().equals("") || day.getText().trim().equals("") || month.getText().trim().equals("") || year.getText().trim().equals("") || addressField.getText().trim().equals("") || cityField.getText().trim().equals("") || postcodeField.getText().trim().equals("")) {
            pass = false;
            submitLabel.setForeground(Color.red);
            submitLabel.setText("Error: One or more fields are blank or have empty spaces");
        }
        return pass;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // If backbutton is pressed, create login page GUI and dispose current frame
        if (e.getSource() == backButton) {
            LoginGUI login = new LoginGUI();
            frame.dispose();
        }
        // If submit button is pressed, set submit label's text (which is currently nothing) to the specified message
        if (e.getSource() == submitButton) {
            if (datachecks() == true) {
                submitLabel.setForeground(Color.green);
                submitLabel.setText("Thank you, a member of staff will contact you soon");
                firstNameField.setText("");
                lastNameField.setText("");
                emailField.setText("");
                phoneNumberField.setText("");
                day.setText("");
                month.setText("");
                year.setText("");
                addressField.setText("");
                cityField.setText("");
                postcodeField.setText("");
            }
        }
    }
}